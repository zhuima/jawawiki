package com.zhuima.jawawiki;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@MapperScan("com.zhuima.jawawiki.mapper")
public class JawaWikiApplication {


    private static final Logger LOG = LoggerFactory.getLogger(JawaWikiApplication.class);
    public static void main(String[] args) {
//        SpringApplication.run(JawawikiApplication.class, args);
        SpringApplication app = new SpringApplication(JawaWikiApplication.class);
        ConfigurableEnvironment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));

    }

}
