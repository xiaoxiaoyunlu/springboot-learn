package oz.mano.online.mq;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * 推送消息
 *
 * @author zj
 * @date 2018年3月20日  新建
 */
@Setter
@Getter
public class PushMsg {
	
	@Expose
	@SerializedName("id")
	private Long id;
	
	//消息发送方
	@Expose
	@SerializedName("msg_from")
	private String msg_from;
	//消息接收方
	@Expose
	@SerializedName("msg_to")
	private String msg_to;
	
	//推送消息类型
	@Expose
	@SerializedName("type")
	private Integer type;
	
	@Expose
	@SerializedName("push_type")
	private Integer push_type;
	
	//消息简述
	@Expose
	@SerializedName("msg_info")
	private String msg_info;
	
	//
	@Expose
	@SerializedName("msg_content")
	private String msg_content;
	
	@Expose
	@SerializedName("create_time")
	private Date create_time;
	
	/**
	 * 定时发送的设定时间
	 */
	@Expose
	@SerializedName("msg_time_set")
	private Date msg_time_set;
}
