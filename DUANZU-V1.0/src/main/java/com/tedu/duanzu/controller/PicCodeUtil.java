package com.tedu.duanzu.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class PicCodeUtil {
	public static final String DEF_CHATSET = "UTF-8";
	public static final int DEF_CONN_TIMEOUT = 30000;
	public static final int DEF_READ_TIMEOUT = 30000;
	public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

	// 配置您申请的KEY
	public static final String APPKEY = "3db8a56c1ac24cacbedec676ebbd1ebe";

	public void getPicCode(HttpServletRequest request, HttpServletResponse response) {
		String codeChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// 获得验证码集合的长度
		int charsLength = codeChars.length();
		// 下面3条记录是关闭客户端浏览器的缓冲区
		// 这3条语句都可以关闭浏览器的缓冲区，但是由于浏览器的版本不同，对这3条语句的支持也不同
		// 因此，为了保险起见，同时使用这3条语句来关闭浏览器的缓冲区
		response.setHeader("ragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		// 设置图形验证码的长和宽
		int width = 80, height = 20;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandomColor(180, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.ITALIC, height));
		g.setColor(getRandomColor(120, 180));
		// 用户保存最后随机生成的验证码
		StringBuffer validationCode = new StringBuffer();
		// 验证码的随机字体
		String[] fontNames = { "Times New Roman", "Book antiqua", "Arial" };

		// 随机生成4个验证码
		for (int i = 0; i < 4; i++) {
			// 随机设置当前验证码的字符的字体
			g.setFont(new Font(fontNames[random.nextInt(3)], Font.ITALIC, height));
			// 随机获得当前验证码的字符
			char codeChar = codeChars.charAt(random.nextInt(charsLength));
			validationCode.append(codeChar);
			// 随机设置当前验证码字符的颜色
			g.setColor(getRandomColor(10, 100));
			// 在图形上输出验证码字符，x和y都是随机生成的
			g.drawString(String.valueOf(codeChar), 16 * i + random.nextInt(7), height - random.nextInt(6));
		}
		// 获得HttpSession对象
		HttpSession session = request.getSession();
		// 设置session对象5分钟失效
		session.setMaxInactiveInterval(5 * 60);
		// 将验证码保存在session对象中,key为validation_code\
		System.out.println("validation_code:" + validationCode);
		session.setAttribute("validation_code", validationCode.toString());
		// 关闭Graphics对象
		g.dispose();
		OutputStream outS = null;
		try {
			outS = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ImageIO.write(image, "JPEG", outS);
		} catch (IOException e) {
			e.printStackTrace();

		}

	}

	public Color getRandomColor(int minColor, int maxColor) {
		Random random = new Random();
		if (minColor > 255) {
			minColor = 255;
		}
		if (maxColor > 255) {
			maxColor = 255;
		}
		// 获得r的随机颜色值
		int red = minColor + random.nextInt(maxColor - minColor);
		int green = minColor + random.nextInt(maxColor - minColor);
		int blue = minColor + random.nextInt(maxColor - minColor);
		return new Color(red, green, blue);
	}

}
