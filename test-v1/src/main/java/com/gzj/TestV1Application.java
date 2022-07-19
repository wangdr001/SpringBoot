package com.gzj;

import com.gzj.web.AopPrintConstController;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.gzj.dao"})
public class TestV1Application implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(TestV1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(TestV1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("程序启动中");
	}

	/**
	 * com.baomidou.mybatisplus.core.toolkit.StringUtils
	 */
}
