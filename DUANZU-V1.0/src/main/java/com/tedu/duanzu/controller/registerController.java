package com.tedu.duanzu.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tedu.duanzu.Service.regtisterService;
import com.tedu.duanzu.entity.regtister;
import com.tedu.duanzu.entity.vo.JsonResult;

@Controller
@RequestMapping("/landlord/")
public class registerController {
	@Autowired
	private regtisterService regtisterService;
	@ResponseBody
	@RequestMapping("register")
	public JsonResult register(regtister reg,String code,HttpServletRequest req) {
		if(code==null) return new JsonResult("验证码不能为空");
		HttpSession session = req.getSession();
		String picCode = (String) session.getAttribute("picCode");
		if(!code.toLowerCase().equals(picCode.toLowerCase())) {
			return new JsonResult("验证码不正确,请重新输入");
		}
		int rows = regtisterService.registerInset(reg);
		System.out.println("reg:"+reg);
		return new JsonResult("insert ok");
	}
	
	 @RequestMapping("doLogin")
	 @ResponseBody
	public JsonResult dologin( boolean isRememberMe,String nickname,String password) {
			//获取subject对象
			Subject subject = SecurityUtils.getSubject();
			//封装用户信息
			 UsernamePasswordToken token=
					   new UsernamePasswordToken(
							   nickname,//身份信息
							   password);//凭证信息
			 if(isRememberMe) {
				 token.setRememberMe(true);
			 }
			 subject.login(token);
		return new JsonResult("login ok");
		
	}
	 public static final String DEF_CHATSET = "UTF-8";
	 public static final int DEF_CONN_TIMEOUT = 30000;
	 public static final int DEF_READ_TIMEOUT = 30000;
	 public static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
	 
	 @RequestMapping("getPicCode")
	 public void getPicCode(HttpServletRequest request, HttpServletResponse response) {
		 String codeChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	     int charsLength = codeChars.length();
	     response.setHeader("ragma", "No-cache");
	     response.setHeader("Cache-Control", "no-cache");
	     response.setDateHeader("Expires", 0);
	     // 设置图形验证码的长和宽
	     int width = 80, height = 20;
	     BufferedImage image = new BufferedImage(width, height,
	             BufferedImage.TYPE_INT_RGB);
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
	         g.setFont(new Font(fontNames[random.nextInt(3)], Font.ITALIC,
	                 height));
	         // 随机获得当前验证码的字符
	         char codeChar = codeChars.charAt(random.nextInt(charsLength));
	         validationCode.append(codeChar);
	         // 随机设置当前验证码字符的颜色
	         g.setColor(getRandomColor(10, 100));
	         // 在图形上输出验证码字符，x和y都是随机生成的
	         g.drawString(String.valueOf(codeChar), 16 * i + random.nextInt(7),
	                 height - random.nextInt(6));
	     }
	     // 获得HttpSession对象
	     HttpSession session = request.getSession();
	     // 设置session对象5分钟失效
	     session.setMaxInactiveInterval(5 * 60);
	     // 将验证码保存在session对象中,key为validation_code\
	     System.out.println("picCode:"+validationCode);
	     session.setAttribute("picCode", validationCode.toString());
	     //关闭Graphics对象
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
	         if(minColor > 255){
	             minColor = 255;
	         }
	         if(maxColor > 255){
	             maxColor = 255;
	         }
	         //获得r的随机颜色值
	         int red = minColor+random.nextInt(maxColor-minColor);
	         int green = minColor + random.nextInt(maxColor-minColor);
	         int blue = minColor + random.nextInt(maxColor-minColor);
	         return new Color(red,green,blue);
	     }
	     
	
}
