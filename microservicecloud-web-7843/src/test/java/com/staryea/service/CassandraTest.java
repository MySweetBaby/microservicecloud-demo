//package com.staryea.service;
//
//import com.datastax.driver.core.Row;
//import com.datastax.driver.core.Session;
//import com.staryea.MicroservicecloudWeb7843Application;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.cassandra.core.CassandraTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by tangdy on 2019/1/15.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = MicroservicecloudWeb7843Application.class)
//public class CassandraTest {
//
////    @Value("${file_path}")
//    @Value("${file_path}")
//    private  String filePath;
//
//    @Value("${read_size}")
//    private   int readSize;
//
//
//
//
//    @Autowired
//    private CassandraTemplate cassandraTemplate;
//
//    private boolean flag = true;
//
//    @Test
//    public void createTable() throws Exception {
//        Session session = cassandraTemplate.getSession();
//        try {
//            session.execute("create table dept (deptno int primary key,dname text,db_source text);"); //drop table tableName; 删除表
//            System.out.println("创建表成功！");
//        } catch (Exception e) {
//            System.out.println("创建表失败！");
//            System.out.println(e.getMessage());
//        }
//        if (session != null) session.close();
//    }
//
//    @Test
//    public void alterTable() throws Exception {
//        Session session = cassandraTemplate.getSession();
//        try {
//            session.execute("alter table dept add info text;"); //drop table tableName; 删除表
//            System.out.println("修改表成功！");
//        } catch (Exception e) {
//            System.out.println("修改表失败！");
//            System.out.println(e.getMessage());
//        }
//        if (session != null) session.close();
//    }
//
//    @Test
//    public void getAll() throws Exception {
//        List<Map> list = new ArrayList<Map>();
////        Session session = cassandraTemplate.getSession();
////        ResultSet set = session.execute("select * from bc_span limit 10;");
//////        System.out.println("set is :" + set.all());
////        List<Row> list =set.all();
////        for (int i =0;i<list.size();i++) {
////            System.out.println("row is :"+list.get(i).toString());
//////            System.out.println(list.get(i).get(i,Map.class));
////        }
////        if (session != null) session.close();
//        File file =new File("D:\\test.txt");
//        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//        if (flag) {
//            list = cassandraTemplate.select("select * from bc_span limit 10;", Map.class);
//            System.out.println("第一次查询：记录数=" + list.size());
//            for (Map map : list) {
//                writer.write(map.toString().replace("=",":"));
//                writer.newLine();
//                writer.flush();
//                System.out.println("第一次查询的每条记录：" + map.toString());
//            }
//            //select * from bc_span where token(date_string,time_scale)>token('20181225',15409) limit 10;
//            list = cassandraTemplate.select("select * from bc_span where token(date_string,time_scale)>token('" + list.get(9).get("date_string") + "'," + list.get(9).get("time_scale") + ") limit 10 ;", Map.class);
//            System.out.println("第二次查询：记录数=" + list.size());
//            for (Map map : list) {
//                System.out.println("第二次查询的每条记录：" + map.toString());
//                writer.write(map.toString().replace("=",":"));
//                writer.newLine();
//                writer.flush();
//            }
//            if(writer!=null){
//                writer.close();
//            }
//        }
//    }
//
//    @Test
//    public void insert() throws Exception {
//        Session session = cassandraTemplate.getSession();
//        for (int i = 100; i < 900; i++) {
//            String dName = "数据" + i + "部";
//            String sql = "insert into dept(deptno,dname,db_source) values(" + i + ",'" + dName + "','test_database')";
//            int a = 15404 + i;
//            String sql1 = "insert into bc_span (date_string , time_scale , trace_id,span_id ,data)" +
//                    "values('20181225'," + a + ",'00646837834d3b76a59508971b9762c0','717c3e851e65325ca28a7faeb4bfce34'," +
//                    "{'{\"traceId\":\"00646837834d3b76a59508971b9762c0\",\"id\":\"717c3e851e65325ca28a7faeb4bfce34\",\"parentId\":\"7b104e78c18531b5bb81f18471282bc3\",\"name\":\"Service_route_send_OFCS\",\"timestamp\":1545682568370567,\"duration\":10,\"r\":1545682511561990,\"s\":1545682511562000,\"ep_type\":\"c\",\"ep_regionCode\":\"571\",\"ep_sysCode\":\"1015\",\"ep_appName\":\"路由转发\",\"ep_ip\":\"134.96.247.46\",\"ep_port\":\"3966\",\"ep_mac\":null,\"ep_hostId\":\"1000000037847\",\"ep_procId\":\"1000000342799\",\"bc_url\":\"ccr|abm@571.ct-bon.net\",\"bc_id\":\"wingpay@001.ct-bon.net;1545682511;2902926596\",\"bc_type\":\"c\",\"bz_scenarioCode\":null,\"bz_resultCode\":\"0\",\"bz_error\":\"\",\"binaryAnnotations\":{\"bz_acceptTime\":\"1545682511561990\",\"bz_return_code\":\"0\",\"bz_dr_amount\":\"\",\"bz_billing_routeRecord\":\"SGW3_2-4@001|CCR|20181225041511.221|20181225041511.221|SR2@001|CCR|20181225041511.271|20181225041511.296|SR2@571|CCR|20181225041511.349|20181225041511.368\",\"topic\":\"ETE_SERV_8330000\",\"bz_dr_channel\":\"\",\"bz_billing_sessionId\":\"WingPay@001.ct-bon.net;1545682511;2902926596\"}}'});";
//            try {
//                session.execute(sql1);
//            } catch (Exception e) {
//                System.out.println("数据插入失败！");
//                System.out.println(e.getMessage());
//            }
//        }
//        System.out.println("数据插入成功！");
//        if (session != null) session.close();
//
//    }
//
//}