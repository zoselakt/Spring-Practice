package com.varxyz.jvx330.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.varxyz.jvx330.lifecycle.example1.Dog;
import com.varxyz.jvx330.lifecycle.example2.Eagle;
import com.varxyz.jvx330.lifecycle.example3.Goat;
import com.varxyz.jvx330.lifecycle.example3.Horse;

@Configuration
public class AppConfig {
	/**
	 * <bean name="dog" class="com.varxyz.jvx330.lifecycle.example1.Dog">
	 * 	<constructor-arg index="0" type="java.lang.String value="현식이"/>
	 * 	<property name="name" value="볼트"/>
	 * </bean>
	 * @return
	 */
	@Bean
	public Dog dog() {
		Dog d = new Dog("현식이");
		d.setName("볼트");
		return d;
	}
	@Bean(initMethod = "attachWings", destroyMethod = "detachWings")
	public Eagle eagle() {
		Eagle e = new Eagle();
		e.setName("한화 이글스");
		return e;
	}
	@Bean
	@Scope("singleton")
	public Goat goat() {
		return new Goat();
	}
	@Bean
	@Scope("prototype")
	public Horse horse() {
		return new Horse();
	}
}
