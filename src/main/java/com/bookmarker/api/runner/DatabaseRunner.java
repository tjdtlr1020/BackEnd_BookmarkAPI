package com.bookmarker.api.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
// 러너중에서 먼저 실행되게하기 위해서 ORDER에 1을 넣어서 우선실행
@Order(1)
@Slf4j
public class DatabaseRunner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("DataSource 구현객체는 = {} ", dataSource.getClass().getName());
        try (Connection connection = dataSource.getConnection()) {
            log.info("DB URL = {}", connection.getMetaData().getURL());
            log.info("DB Username = {}", connection.getMetaData().getUserName());
            log.info(">>>>>>>DB Product Vendor  = {}",connection.getMetaData().getDatabaseProductName());
        }
    }
}