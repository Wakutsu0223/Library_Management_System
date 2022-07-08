package com.book.util;

/**
 *工具类
 * @author sdssy
 *
 */
public class StringUtil {

	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str.trim()) || str =="") {
			return true;
		}
		else {
			return false;
		}
		
	}

	/**
	 * 判断是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if(str != null && !"".equals(str.trim())) {
			return true;
		}
		else {
			return false;
			}
		}
}