package com.example.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"com.example"},exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class MyStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyStorageApplication.class, args);
        System.out.println("/********************************/\n");
        System.out.println("********* Storage start!!!*******/\n");
        System.out.println("/********************************/\n");

    }
}
