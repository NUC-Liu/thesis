package cn.nuc.thesis.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class ThesisThirdpartyApplicationTests {

    private OSSClient ossClient;

    @Test
    void contextLoads() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("C:\\Users\\56841\\Pictures\\Saved Pictures\\tomcat.jpg");
        ossClient.putObject("thesis-liu", "tomcat.jpg", inputStream);
        ossClient.shutdown();
        System.out.println("上传完成");
    }

}
