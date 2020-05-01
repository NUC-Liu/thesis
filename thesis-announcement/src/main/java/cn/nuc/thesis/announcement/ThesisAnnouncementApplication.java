package cn.nuc.thesis.announcement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ThesisAnnouncementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThesisAnnouncementApplication.class, args);
    }

}
