package cn.nuc.thesis.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ThesisThirdpartyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThesisThirdpartyApplication.class, args);
    }

}
