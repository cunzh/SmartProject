/**
 * 
 */
package com.smartcommunity.util;

/**
 * 文本工具类
 * @version 创建时间:2015年4月4日
 * @author Huynh
 */
public class TextUtil {

	/**
	 * 判断指定串是否为空
	 * @version 创建时间: 2015年4月4日
	 * @author Huynh
	 * @param text
	 * @return 空为true
	 */
	public static boolean isEmpty(String text){
		if (text == null||"".equals(text) ) {
			return true;
		}
		return false;
	}
}
