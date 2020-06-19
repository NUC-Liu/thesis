package cn.nuc.thesis.hadoop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.*;

@SpringBootTest
class ThesisHadoopApplicationTests {

    @Test
    void contextLoads() {
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            Connection connection = DriverManager.getConnection("jdbc:hive2://192.168.1.139:10000/sjczq_db", "hadoop", "");
            Statement stmt = connection.createStatement();
            String querySQL="select * from tms_weekly";
            ResultSet resut = stmt.executeQuery(querySQL);
            while (resut.next()) {
                System.out.println(resut.getInt(1));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
