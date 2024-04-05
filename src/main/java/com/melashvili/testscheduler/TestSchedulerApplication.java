package com.melashvili.testscheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;



@SpringBootApplication(exclude = {
        ConfigurationPropertiesAutoConfiguration.class,
        CacheAutoConfiguration.class
})
@EnableCaching
public class TestSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSchedulerApplication.class, args);
    }

}
