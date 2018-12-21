package oz.mano.online.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHelper implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;

    public SpringContextHelper() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    	SpringContextHelper.applicationContext = applicationContext;
    }

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName) {
		if(null != applicationContext){
			return (T) applicationContext.getBean(beanName);
		}
		return null;
	}

}
