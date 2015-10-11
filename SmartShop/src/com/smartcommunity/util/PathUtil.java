package com.smartcommunity.util;

import com.sun.xml.internal.ws.message.Util;

public class PathUtil {

	/**
	 * 
	 * @version 创建时间: 2015年4月4日
	 * @author yangjunlei
	 * @param useId
	 * @return
	 */
	public static String getComplaintsPath(String roomnumber) {
		if (roomnumber == null || "".equals(roomnumber)) {
			roomnumber = "anonymous";
		}
		return "../images/" + roomnumber + "/complaints/" ;
	}
	public static String getRepairPath(String roomnumber) {
		if (roomnumber == null || "".equals(roomnumber)) {
			roomnumber = "anonymous";
		}
		return  "../images/" + roomnumber + "/repair/";
	}
	
	/**
	 * 返回图片保存地址 这里可能需要修改
	 * 原则是一个文件夹下不要有过多图片，
	 * 也不要有过多文件夹，一般两级即可
	 * @version 创建时间: 2015年4月4日
	 * @author Huynh
	 * @param name  店铺名
	 * @return
	 */
	public static String getProductPath(String name){
		if (TextUtil.isEmpty(name)) {
			name = "anonymous";
		}
		return "../images/"+"product/"+name.hashCode()+"/";

	}
	public static String getApkPath() {
		return "./apk/";
	}
	public static String getApkLogPath() {
		return "../apk/";
	}
	public static String getAbsPath(String relativePath) {
		String absPath = org.apache.struts2.ServletActionContext.
				getServletContext().getRealPath(relativePath);
		return absPath;
	}
}
