package com.zsy.WXDemo.utils;

import java.text.MessageFormat;
import java.util.Random;

/**
 * 字符串处理工具类
 * @author zj
 *
 */
public enum StringUtil {
    INSTANCE;
	/**
	 * 给每个id加上'',如"1,2,3"->'1','2','3'
	 * @param ids
	 * @return
	 */
	public String decorateIds(String ids){
		if(StringUtil.INSTANCE.isEmpty(ids)){
			return "";
		}
		String[] array = ids.split(",");
		if(array.length>0){
			String resultStr = "";
			for (int index = 0; index < array.length; index++) {
				resultStr = resultStr + "'" + array[index] + "',";
			}
			return resultStr.substring(0, resultStr.length() - 1);
		}
		return "";
	}
	
	private Random randGen = new Random();
	private char[] numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	/**
	 * 获取随机key
	 * @param length
	 * @return
	 */
	public String randomString(int length) {
		if (length < 1) {
			return null;
		}
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(61)];
		}
		return new String(randBuffer);
	}
	
	/**
     * 格式化字符串
     *      str = "我是{0},我来自{1},今年{2}岁";
     *      format(str, "中国人","北京",22));
     * @param pattern 
     * @param arguments
     * @return
     */
    public String formatString(String pattern, Object ... arguments){
        return MessageFormat.format(pattern, arguments);
    }
    
    /**
     * 判断参数是否为空
     * @param o
     * @return
     */
    public boolean isEmpty(Object o){
        if(null==o||"".equals(o.toString())){
            return true;
        }
        return false;
    }
}
