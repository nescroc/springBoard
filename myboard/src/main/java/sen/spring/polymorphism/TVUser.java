package sen.spring.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		/*
		 * BeanFactory factory = new BeanFactory(); TV tv =
		 * (TV)factory.getBean(args[0]); tv.powerOn(); tv.volumeUp(); tv.volumeDown();
		 * tv.powerOff();
		 */
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		TV tv = (TV)factory.getBean("tv");		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		factory.close();
	}

}
