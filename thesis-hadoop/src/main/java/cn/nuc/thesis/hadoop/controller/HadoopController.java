package cn.nuc.thesis.hadoop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hadoop")
public class HadoopController {

    @RequestMapping("/getDataFromHive")
    public Map getDataFromHive() {
        Map r = new HashMap();
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            Connection connection = DriverManager.getConnection("jdbc:hive2://192.168.1.139:10000/sjjsq_db", "hadoop", "");
            Statement stmt = connection.createStatement();
            String querySQL = null;
            ResultSet result;

            List proposal_nums = new ArrayList();
            // 查询开题成绩占比
            querySQL="select * from dwa_proposal_nums";
            result = stmt.executeQuery(querySQL);
            if (result.next()) {
                Map temp = new HashMap();
                temp.put("name", "不及格");
                temp.put("value",result.getString("bjg"));
                proposal_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "及格");
                temp.put("value",result.getString("jg"));
                proposal_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "良好");
                temp.put("value",result.getString("lh"));
                proposal_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "优秀");
                temp.put("value",result.getString("yx"));
                proposal_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "未完成");
                temp.put("value",result.getString("wwc"));
                proposal_nums.add(temp);
                r.put("lastUpdate", result.getString("update_time"));
            }
            r.put("proposal",proposal_nums);

            List mid_nums = new ArrayList();
            // 查询中期成绩占比
            querySQL="select * from dwa_mid_nums";
            result = stmt.executeQuery(querySQL);
            if (result.next()) {
                Map temp = new HashMap();
                temp.put("name", "不及格");
                temp.put("value",result.getString("bjg"));
                mid_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "及格");
                temp.put("value",result.getString("jg"));
                mid_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "良好");
                temp.put("value",result.getString("lh"));
                mid_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "优秀");
                temp.put("value",result.getString("yx"));
                mid_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "未完成");
                temp.put("value",result.getString("wwc"));
                mid_nums.add(temp);
            }
            r.put("mid",mid_nums);

            List final_nums = new ArrayList<>();
            // 查询毕设成绩占比
            querySQL="select * from dwa_final_nums";
            result = stmt.executeQuery(querySQL);
            if (result.next()) {
                Map temp = new HashMap();
                temp.put("name", "不及格");
                temp.put("value",result.getString("bjg"));
                final_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "及格");
                temp.put("value",result.getString("jg"));
                final_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "良好");
                temp.put("value",result.getString("lh"));
                final_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "优秀");
                temp.put("value",result.getString("yx"));
                final_nums.add(temp);
                temp = new HashMap();
                temp.put("name", "未完成");
                temp.put("value",result.getString("wwc"));
                final_nums.add(temp);
            }
            r.put("final",final_nums);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        r.put("code", 0);
        r.put("msg","");
        return r;
    }
}
