package hust.shop.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import hust.shop.params.ShopParam;
import hust.shop.params.UserParam;
import hust.shop.pojo.Address;
import hust.shop.pojo.User;

import com.alibaba.fastjson.JSONObject;
import com.smartcommunity.util.ConstantPool;
import com.smartcommunity.util.JSONUtil;
import com.smartcommunity.util.LogUtil;

public class UserAction extends BaseActionSupport<UserParam> {

	private hust.shop.service.IUserService userService;
	public String register() {
		JSONObject jsonObject = userService.register(parameters.getUser());
		LogUtil.log(jsonObject.toJSONString());
		return setJSONObject(jsonObject );
		
	}

//	public void validateRegister() {
//		com.smartcommunity.util.LogUtil.log("validte");
//	//	return setJSONObject(userService.register(parameters.getUser()) );
//		
//	}
	
	public String login() throws UnsupportedEncodingException {
		JSONObject jsonObject ;
		if (getHttpServletRequest().isRequestedSessionIdValid() && parameters.getUsername() == null && parameters.getPassword() == null) {
			jsonObject = userService.logined((Integer) getHttpSession().getAttribute(ConstantPool.SESSION_USER_ID));
		} else {

			jsonObject = userService.login(parameters.getUsername(),parameters.getPassword());
		}

		// 如果没有登陆成功
		if (com.smartcommunity.util.JSONUtil.getJsonStatus(jsonObject) == false) {
			if (getHttpServletRequest().isRequestedSessionIdValid()) {
				// 如果没有就创建
				getHttpSession().invalidate(); 
		}
			return setJSONObject(jsonObject);
		}

		
//		if (getHttpServletRequest().isRequestedSessionIdValid()) {
//			jsonObject.put("JSESSIONID", httpSession.getId());
//		}
		// 如果没有就创建
		HttpSession httpSession = getHttpSession() ;
		
		httpSession.setMaxInactiveInterval(360*24*60*60); // 会话超时,单位为 秒

		String idString = "id";
		String usernamString = "username";
		String passwordString = "password";
		String telephoneString = "telephone";
		String typeString = "type";
		// 用户名密码加入 cookie
		javax.servlet.http.Cookie cookieusername = null;

			cookieusername = new javax.servlet.http.Cookie(ConstantPool.SESSION_NAME,
					java.net.URLEncoder.encode(jsonObject.getString(usernamString), "utf-8"));
		cookieusername.setMaxAge(Integer.MAX_VALUE);
		javax.servlet.http.HttpServletResponse response = ServletActionContext
				.getResponse();
		response.addCookie(cookieusername);

		javax.servlet.http.Cookie cookiepassword = new javax.servlet.http.Cookie(
				ConstantPool.SESSION_PASSWORD,java.net.URLEncoder.encode( jsonObject.getString(passwordString), "utf-8"));
		cookiepassword.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookiepassword);

		/** 保存用户信息到 session */
		httpSession.setAttribute(ConstantPool.SESSION_USER_ID,jsonObject.getInteger(idString));
		httpSession.setAttribute(ConstantPool.SESSION_NAME,jsonObject.getString(usernamString));
		httpSession.setAttribute(ConstantPool.SESSION_TELEPHONE,jsonObject.getString(telephoneString));
		httpSession.setAttribute(ConstantPool.SESSION_TYPE ,jsonObject.getBoolean(typeString));
	
		return setJSONObject(jsonObject);
	}

	public String update() {
		// 设置用户 id
		User user = parameters.getUser();
		if (user == null ) {
			return setJSONObject( JSONUtil.getFalseJsonObject("更新信息为空") );
		}
		user.setId((Integer) getHttpSession().getAttribute(ConstantPool.SESSION_USER_ID));
		return setJSONObject(userService.update(user));
	}


	public String logout() throws UnsupportedEncodingException{

		javax.servlet.http.HttpSession session = getHttpSession(true);
		
		session.invalidate();
		javax.servlet.http.Cookie cookieusername = null;

		cookieusername = new javax.servlet.http.Cookie(ConstantPool.SESSION_NAME,
				java.net.URLEncoder.encode("", "utf-8"));
	cookieusername.setMaxAge(0);
	javax.servlet.http.HttpServletResponse response = ServletActionContext
			.getResponse();
	response.addCookie(cookieusername);

	javax.servlet.http.Cookie cookiepassword = new javax.servlet.http.Cookie(
			ConstantPool.SESSION_PASSWORD,java.net.URLEncoder.encode( "", "utf-8"));
	cookiepassword.setMaxAge(0);
	response.addCookie(cookiepassword);

		return setJSONObject(com.smartcommunity.util.JSONUtil.getJsonObject(true));
	}


	public String addAddress(){
		Address address = parameters.getAddress();
		address.setUserId((Integer) getHttpSession().getAttribute(ConstantPool.SESSION_USER_ID));
		return setJSONObject(userService.addAddress(address) );
	}

	public String updateAddress(){

		Address address = parameters.getAddress();
		address.setUserId((Integer) getHttpSession().getAttribute(ConstantPool.SESSION_USER_ID));
		return setJSONObject(userService.updateAddress(address) );
		
	}

	public String deleteAddress() {
		return setJSONObject(userService.deleteAddress((Integer) getHttpSession().getAttribute(ConstantPool.SESSION_USER_ID), parameters.getId()) );
	}

	public String getAddress() {
		return setJSONObject(userService.getAddress((Integer) getHttpSession().getAttribute(ConstantPool.SESSION_USER_ID)) );
	}

	public hust.shop.service.IUserService getUserService() {
		return userService;
	}

	public void setUserService(hust.shop.service.IUserService userService) {
		this.userService = userService;
	}
	
}
