/*
 * ***************************************************************
 *  Copyright (c) Optum, Inc 2018.
 *  This software and documentation contain confidential and
 *  proprietary information owned by Optum, Inc.
 *  Unauthorized use and distribution are prohibited.
 * **************************************************************
 */
package com.kastech.blumen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(value = {"com.kastech.blumen"})
public class BlumenApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlumenApplication.class, args);


    }
}
