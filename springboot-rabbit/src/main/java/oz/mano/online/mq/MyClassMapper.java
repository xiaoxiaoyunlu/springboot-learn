package oz.mano.online.mq;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.ClassMapper;

public class MyClassMapper implements ClassMapper {
	
	private static final String DEFAULT_TYPE_CLASS="__TypeId__";

	@Override
	public Class<?> toClass(MessageProperties properties) {
		Object obj = properties.getHeaders().get(DEFAULT_TYPE_CLASS);
		if(null != obj){
			try {
				return Class.forName(obj.toString());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
	
	@Override
	public void fromClass(Class<?> clazz, MessageProperties properties) {
		properties.setHeader(DEFAULT_TYPE_CLASS, clazz.getName());
	}

}
