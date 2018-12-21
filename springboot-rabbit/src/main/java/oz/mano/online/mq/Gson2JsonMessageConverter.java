package oz.mano.online.mq;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.ClassMapper;
import org.springframework.amqp.support.converter.MessageConversionException;

import com.google.gson.Gson;

public class Gson2JsonMessageConverter extends AbstractMessageConverter {
	
	private static final String CHARSET_NAME="UTF-8";
	
	public static  Map<String, Class<?>> mqObjectMap=new HashMap<String, Class<?>>();
	
	private Logger LOGGER=LoggerFactory.getLogger(getClass());
	
	private ClassMapper classMapper = new MyClassMapper(); 
	
	private static Gson gson=new Gson();

	public Gson2JsonMessageConverter() {
		super();
	}
	
	static{
		mqObjectMap.put(PushMsg.class.getSimpleName(),PushMsg.class);
	}


	@Override
	protected Message createMessage(Object object, MessageProperties messageProperties) {
		//约定，发送消息的除了Bean 就是 String, 不会有其他类型
		 byte[] bytes = null;  
         try {  
        	 String jsonString = null;
        	 if(object instanceof String){
        		 jsonString=(String) object;
        	 }else {
        		 jsonString = gson.toJson(object); 
			}
              
             bytes = jsonString.getBytes(CHARSET_NAME);  
         }  
         catch (IOException e) {  
             throw new MessageConversionException(  
                     "Failed to convert Message content", e);  
         }  
         messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);  
         messageProperties.setContentEncoding(CHARSET_NAME); 
         //设置消息持久化
         messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
         if (bytes != null) {  
             messageProperties.setContentLength(bytes.length);  
         }  
         classMapper.fromClass(object.getClass(),messageProperties);  
         return new Message(bytes, messageProperties);  
	}

	@Override
	 public Object fromMessage(Message message)  
             throws MessageConversionException {  
         Object content = null;  
         MessageProperties properties = message.getMessageProperties();  
         if (properties != null) {  
             String contentType = properties.getContentType();  
             if (contentType != null && contentType.contains("json")) {  
                 String encoding = properties.getContentEncoding();  
                 if (encoding == null) {  
                     encoding = CHARSET_NAME;  
                 }  
                 try {  
                         Class<?> targetClass = classMapper.toClass(properties);  
                         content = convertBytesToObject(message.getBody(),  
                                 encoding, targetClass);  
                 }  
                 catch (IOException e) {  
                     throw new MessageConversionException(  
                             "Failed to convert Message content", e);  
                 }  
             }  
             else {  
            	 LOGGER.warn("Could not convert incoming message with content-type ["  
                         + contentType + "]");  
             }  
         }  
         if (content == null) {  
             content = message.getBody();  
         }  
         return content;  
     }  
   
     private Object convertBytesToObject(byte[] body, String encoding,  
             Class<?> clazz) throws UnsupportedEncodingException {  
         String contentAsString = new String(body, encoding);  
         if(null != clazz){
        	 return gson.fromJson(contentAsString, clazz);  
         }
         return contentAsString;
         
     }  

}
