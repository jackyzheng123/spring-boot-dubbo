package com.xsjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 生产者 启动类
 * @author Joe
 *
 */
@SpringBootApplication
@ImportResource(locations={"classpath:provider.xml"})
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
}
