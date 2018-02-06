package com.zsy.WXDemo.common;

/**
 * 全局常量类
 * @author zj
 *
 */
public final class Constant {
    /**************** 0——4数字 *****************/
    public final static int ZERO  = 0;
    public final static int ONE   = 1;
    public final static int TWO   = 2;
    public final static int THREE = 3;
    public final static int FOUR  = 4;
    
    /*************** 0——4数字字符串  ***************/
    public final static String S_ZERO  = "0";
    public final static String S_ONE   = "1";
    public final static String S_TWO   = "2";
    public final static String S_THREE = "3";
    public final static String S_FOUR  = "4";
    
    /****************** 分辨率 *******************/
    public final static String LCD1080 = "1920x1080";
    public final static String LCD720  = "1280x720";
    public final static String LCD540  = "960x540";
    public final static String LCD480  = "854x480";
    /****************** 符号 *******************/
    /*** 句号(.) ***/
    public final static String STOP      = ".";
    /*** 逗号(,) ***/
    public final static String COMMA     = ",";
    /*** 正斜杠(/) ***/
    public final static String SLASH     = "/";
    /*** 分号(;) ***/
    public final static String SEMICOLON = ";";
    /*** 下划线(_) ***/
    public final static String UNDERLINE = "_";
    /*** 中划线(-) ***/
    public final static String LINEATION = "-";
    /*** 冒号(:) ***/
    public final static String COLON     = ":";
    /*** 空字符串("") ***/
    public final static String EMPTY     = "";
    /*** 与符号("&") ***/
    public final static String AND       = "&";
    
    /****************** 编码 *******************/
    public final static String UTF8     = "utf-8";
    public final static String GBK      = "gbk";
    public final static String GB2312   = "gb2312";
    public final static String ISO88591 = "iso8859-1";
    
    /****************** 扩展名 *******************/
    public final static String JPG  = "jpg";
    public final static String PNG  = "png";
    public final static String ZIP  = "zip";
    
    
    //常用状态
    public final static int STATUS_INVAILD=0;
    public final static int STATUS_VALID=1;
    
    //大赛类别
    public final static int COMPETION_TYPE=1;
    
    
  //大赛第几届
    public final static int COMPETION_FIRST=1;
    
  //微信自定义菜单类型
    public final static String MENU_VIEW="view";    //跳转url
    public final static String MENU_CLICK="click";    //点推事件
    public final static String MENU_MINPROGRAM="miniprogram";   //小程序
    public final static String MENU_SCANCODE_PUSH="scancode_push";  //扫码推事件
    public final static String MENU_SCANCODE_WAITMSG="scancode_waitmsg"; //扫码等待相应事件
    public final static String MENU_PIC_SYSPHOTO="pic_sysphoto";  //弹出系统拍照发给开发者，等待开发者相应
    public final static String MENU_PIC_PHOTO_OR_ALBUM="pic_photo_or_album";  //弹出拍照或者相册选择
    public final static String MENU_PIC_WEIXIN="pic_weixin";  //弹出微信相册发图，等待相应
    public final static String MENU_LOCATION_SELECT="location_select";   //弹出地理位置发送
    public final static String MENU_MEDIA_ID="media_id";  //下发消息（除文本信息）  必须是素材管理上传获得id
    public final static String MENU_VIEW_LIMITED="view_limited"; //跳转消息url   必须是素材管理上传的id
    
    
    //微信二维码  状态
    public final static String QR_CODE_ALL="QR_LIMIT_SCENE";   //永久二维码
    public final static String QR_CODE_STR_ALL="QR_LIMIT_STR_SCENE";
    public final static String QR_CODE_LIMIT="QR_SCENE";    //临时二维码 
    
}
