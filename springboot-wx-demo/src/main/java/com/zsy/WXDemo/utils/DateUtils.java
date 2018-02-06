package com.zsy.WXDemo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author zj
 *
 */
public enum DateUtils {
    INSTANCE;
    public final static String DATE_TIME_FROMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_FROMAT      = "yyyy-MM-dd";
    public final static String DATE_FILE_PATTEN = "yyyy/MM/dd";
    
    /**
     * 获取当前时间字符串格式为‘yyyy-MM-dd HH:mm:ss’
     * @return ‘2015-08-05 14:22:22’
     */
	public String getCurrentTime() {
		return new SimpleDateFormat(DATE_TIME_FROMAT).format(new Date());
	}
	
	/**
	 * 根据传入的日期格式获取当前日期字符串
	 * @param fromat
	 * @return 
	 */
	public String getCurrentTime(String fromat) {
	    if(StringUtil.INSTANCE.isEmpty(fromat)) {
	        return null;
	    }
		return new SimpleDateFormat(fromat).format(new Date());
	}

	/**
	 * 根据传入的日期获取传入日期的日期字符串
	 * @param date
	 * @return
	 */
	public String getFormatTime(Date date) {
	    if(date == null) {
            return null;
        }
		return new SimpleDateFormat(DATE_TIME_FROMAT).format(date);
	}
	
	/**
	 * 根据传入的日期及日期格式获取日期字符串
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public String getFormatTime(Date date, String dateFormat) {
	    if(date == null || StringUtil.INSTANCE.isEmpty(dateFormat)) {
            return null;
        }
        return new SimpleDateFormat(dateFormat).format(date);
    }
	
	/**
	 * 获取当前时间戳
	 * @return
	 */
	public Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
	
	/**
	 * 根据传入的时间戳获取格式为：‘yyyy-MM-dd HH:mm:ss’日期字符串
	 * @param time 时间戳
	 * @return ‘2015-08-05 14:22:22’
	 */
	public String getDateTime(Long time) {
	    if(time == null) {
	        return null;
	    }
        return new SimpleDateFormat(DATE_TIME_FROMAT).format(new Date(time));
    }
	
	/**
     * 根据传入的时间戳获取格式为：‘yyyy-MM-dd’日期字符串
     * @param time 时间戳
     * @return ‘2015-08-05’
     */
	public String getDayTime(Long time) {
	    if(time == null) {
            return null;
        }
        return new SimpleDateFormat(DATE_FROMAT).format(new Date(time));
    }
	
	/**
	 * 根据传入的日期字符串获取日期对象
	 * @param dateStr 格式：‘yyyy-MM-dd’日期字符串
	 * @return
	 */
    public Date getDate(String dateStr,String dateFormat) {
        try {
            return new SimpleDateFormat(dateFormat).parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	/**
	 * 根据传入的日期格式及字符串日期获取时间戳
	 * @param dateFormat 日期格式
	 * @param dateTime   字符串日期
	 * @return 
	 */
	public Long getTimeStamp(String dateFormat, String dateTime){
	    if(StringUtil.INSTANCE.isEmpty(dateFormat) || StringUtil.INSTANCE.isEmpty(dateTime)) {
	        return null;
	    }
		try {
			return new SimpleDateFormat(dateFormat).parse(dateTime).getTime();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据‘yyyy-MM-dd’格式比较开始时间是否小于等于结束时间
	 * @param startDate 开始日期
	 * @param endDate   结束日期
	 * @return true  开始时间小于等于结束时间
     *         false 开始时间大小结束时间
	 */
	public boolean isCompareDate(String startDate, String endDate) {
	    startDate = startDate.substring(0, 10);
		return isCompare(startDate, endDate, DATE_FROMAT);
	}
	
	/**
	 * 根据‘yyyy-MM-dd HH:mm:ss’格式比较开始时间是否小于等于结束时间
	 * @param startTime  开始时间
	 * @param endTime    结束时间
	 * @return true  开始时间小于等于结束时间
     *         false 开始时间大小结束时间
	 */
	public boolean isCompareDateTime(String startTime, String endTime) {
		return isCompare(startTime,endTime,DATE_TIME_FROMAT);
	}
	
	/**
	 * 根据传入的日期格式比较开始时间是否小于等于结束时间
	 * @param startTime  开始时间
	 * @param endTime    结束时间
	 * @param DateFormat 日期格式
	 * @return true  开始时间小于等于结束时间
	 *         false 开始时间大小结束时间
	 */
	public boolean isCompare(String startTime, String endTime,String dateFormat) {
	    if(StringUtil.INSTANCE.isEmpty(startTime) 
	            || StringUtil.INSTANCE.isEmpty(endTime) 
	            || StringUtil.INSTANCE.isEmpty(dateFormat)) {
	        return false;
	    }
	    
		SimpleDateFormat format= new SimpleDateFormat(dateFormat);
		try {
			Date startDateTime = format.parse(startTime);
			Date endDateTime   = format.parse(endTime);
			if (startDateTime.getTime() <= endDateTime.getTime()) {
				return true;
			}
		} catch (Exception ex) {
		    ex.printStackTrace();
			return false;
		}
		return false;
	}
	
    public static void main(String[] args) {
        System.out.println(DateUtils.INSTANCE.isCompare("20150000", "20150302", "yyyyMMdd"));
        
    }
}
