package cn.nuc.thesis.weekly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ThesisWeeklyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThesisWeeklyApplication.class, args);
    }

}
