package com.tedu.duanzu.common.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringShiroConfig {
	@Bean
	public SecurityManager securityManager(Realm realm,
			CookieRememberMeManager rememberMeManager) {
			 DefaultWebSecurityManager sManager=
			 new DefaultWebSecurityManager();
			 sManager.setRememberMeManager(rememberMeManager);
			 sManager.setRealm(realm);
			 return sManager;
	}
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactor(
			SecurityManager securityManager) {
		ShiroFilterFactoryBean sfBean = new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		sfBean.setLoginUrl("/fupo");
		LinkedHashMap<String,String> map = new LinkedHashMap<>();
			//anon,静态资源允许匿名访问
			map.put("/CreateHouse_files/**","anon");
			map.put("/img/**","anon");
			map.put("/public/**", "anon");
			map.put("/zhuce","anon");
			map.put("/landlord/doLogin", "anon");
			map.put("/landlord/register", "anon");
			map.put("/landlord/getPicCode", "anon");
			//除了匿名访问的资源,其它都要认证("authc")后访问
			map.put("/**","user");
			sfBean.setFilterChainDefinitionMap(map);
			return sfBean;
	}
	@Bean
	public CookieRememberMeManager rememberMeManager() {
			CookieRememberMeManager cManager = 
					new CookieRememberMeManager();
			SimpleCookie cookie = new SimpleCookie("rememberMe");
			cookie.setMaxAge(10*60);
			cManager.setCookie(cookie);
			return cManager;
	}
	@Bean
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sManager = new DefaultWebSessionManager();
		sManager.setGlobalSessionTimeout(60*60*100);
		return sManager;
	}
}
