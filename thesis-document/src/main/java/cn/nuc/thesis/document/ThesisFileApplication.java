package cn.nuc.thesis.document;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ThesisFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThesisFileApplication.class, args);
    }

}
