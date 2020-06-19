package cn.nuc.thesis.hadoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ThesisHadoopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThesisHadoopApplication.class, args);
    }

}
