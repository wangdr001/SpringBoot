package com.gzj.test;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(value = "com.gzj.test.mapper")
@EnableTransactionManagement
@Slf4j
public class TestV2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestV2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("程序启动中");
	}
}
