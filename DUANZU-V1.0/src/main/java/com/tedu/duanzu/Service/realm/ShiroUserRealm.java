package com.tedu.duanzu.Service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.tedu.duanzu.Dao.registerDao;
import com.tedu.duanzu.entity.regtister;
@Configuration
public class ShiroUserRealm extends AuthorizingRealm{
	@Autowired
	private  registerDao registerDao; 
	//设置凭证匹配器,与用户添加仓做使用相同的加密算法
	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
		cMatcher.setHashAlgorithmName("MD5");
		cMatcher.setHashIterations(1);
		super.setCredentialsMatcher(cMatcher);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo
	(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo
	(AuthenticationToken token) 
			throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username=upToken.getUsername();
		regtister user = registerDao.findByName(username);
		if(user==null)throw new UnknownAccountException();//用户名不能为空
		ByteSource credentialsSalt=ByteSource.Util.bytes(user.getSalt());
		SimpleAuthenticationInfo Info = 
				new SimpleAuthenticationInfo(
						user,//身份
						user.getPassword(),
						credentialsSalt,
						getName());
		return Info;
	}
	
}
