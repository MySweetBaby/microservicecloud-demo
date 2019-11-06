//package com.staryea.service;
//
//import com.datastax.driver.core.Session;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.cassandra.core.CassandraTemplate;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by tangdy on 2019/1/15.
// */
////@Service
//@Component
//public class Cassandra implements Runnable {
//
//    private Logger log = LoggerFactory.getLogger(Cassandra.class);
//
////    private List<Map> list=new ArrayList<Map>();
//
//    private static boolean flag = true;
//
//    private static String oldDateString = "";
//
//    private static String newDateString = "";
//
//    private static int oldTimeScale = 0;
//
//    private static int newTimeScale = 0;
//
//    private String fileName = "";
//
//    private int count = 0;
//
//    private boolean isFlag = true;
//
//    @Value("${file_path}")
//    private String filePath;
//
//    @Value("${read_size}")
//    private int readSize;
//
////    private File file;
//
////    private BufferedWriter writer;
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//
//    @Autowired
//    private CassandraTemplate cassandraTemplate;
//
//    /**
//     * 创建/删除表
//     *
//     * @param tableName
//     * @return
//     */
//    public Boolean createTable(String tableName) {
//        boolean flag = true;
//        Session session = cassandraTemplate.getSession();
//        try {
//            session.execute("create table " + tableName + "(id int primary key,name text);"); //drop table tableName; 删除表
//            log.debug("创建表成功！表名：" + tableName);
//        } catch (Exception e) {
//            flag = false;
//        }
//        return flag;
//    }
//
//    /**
//     * 修改表（添加/删除列）
//     *
//     * @param tableName
//     * @return
//     */
//    public Boolean alterTable(String tableName) {
//        boolean flag = true;
//        Session session = cassandraTemplate.getSession();
//        try {
//            session.execute("alter table " + tableName + " add info text;");//alter tbale tableName drop columnName; 删除列
//            log.debug("添加表字段成功！表名：" + tableName);
//        } catch (Exception e) {
//            flag = false;
//        }
//        return flag;
//    }
//
////    public void getAll() {
////        List<Map> list = new ArrayList<Map>();
////        if (flag) {
////            file = new File(filePath);
////            try {
////                writer = new BufferedWriter(new FileWriter(file));
////            } catch (IOException e) {
////                log.error(e.getMessage());
////            }
////            long start = System.currentTimeMillis();
////            list = cassandraTemplate.select("select * from bc_span limit " + readSize + ";", Map.class);
////            log.debug("查询耗时：" + (System.currentTimeMillis() - start));
////            long start1 = System.currentTimeMillis();
////            write(list, writer);
////            log.debug("写数据耗时：" + (System.currentTimeMillis() - start1));
////            //select * from bc_span where token(date_string,time_scale)>token('20181225',15409) limit 10;
////        } else {
////            long start = System.currentTimeMillis();
////            list = cassandraTemplate.select("select * from bc_span where token(date_string,time_scale)>token('" + dateString + "'," + timeScale + ") limit " + readSize + ";", Map.class);
////            log.debug("查询耗时：" + (System.currentTimeMillis() - start));
////            long start1 = System.currentTimeMillis();
////            write(list, writer);
////            log.debug("写数据耗时：" + (System.currentTimeMillis() - start1));
////        }
////        if (list.size() == readSize) {
////            dateString = list.get((list.size() - 1)).get("date_string").toString();
////            timeScale = Integer.parseInt(list.get((list.size() - 1)).get("time_scale").toString());
////            flag = false;
////            getAll();
////        } else {
////            flag = true;
////        }
////        if (writer != null) try {
////            writer.close();
////        } catch (IOException e) {
////            log.error(e.getMessage());
////        }
////    }
//
////    public synchronized void getAll() {
////        try {
////            Thread.sleep(10);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
////        List<Map> list = new ArrayList<Map>();
////        if (flag) {
////            file = new File(filePath);
////            try {
////                writer = new BufferedWriter(new FileWriter(file));
////            } catch (IOException e) {
////                log.error(e.getMessage());
////            }
////        }
////        long start = System.currentTimeMillis();
////        String cql = "";
////        if (oldTimeScale == 0) {
////            cql = "select * from bc_span limit " + readSize + ";";
////        } else {
////            cql = "select * from bc_span where token(date_string,time_scale)>token('" + oldDateString + "'," + oldTimeScale + ") limit " + readSize + ";";
////        }
////        list = cassandraTemplate.select(cql, Map.class);
////        log.debug("查询耗时：" + (System.currentTimeMillis() - start));
////
////        long start1 = System.currentTimeMillis();
////        log.debug("写数据耗时：" + (System.currentTimeMillis() - start1));
////        //select * from bc_span where token(date_string,time_scale)>token('20181225',15409) limit 10;
////        if (null == list || list.size() == 0) {
////            isFlag = false;
////            if (writer != null) try {
////                writer.close();
////            } catch (IOException e) {
////                log.error(e.getMessage());
////            }
////        } else {
////            write(list, writer);
////            newDateString = list.get((list.size() - 1)).get("date_string").toString();
////            newTimeScale = Integer.parseInt(list.get((list.size() - 1)).get("time_scale").toString());
////            if (list.size() < readSize) {
////                if (writer != null) try {
////                    writer.close();
////                } catch (IOException e) {
////                    log.error(e.getMessage());
////                }
////                isFlag = false;
////            }
////        }
////
////    }
//
//    public void write(List<Map> list, BufferedWriter writer) {
//        long start1 = System.currentTimeMillis();
//        for (Map map : list) {
//            try {
//                writer.write(map.toString());//get("data") == null ? "" : map.get("data").toString()
//                writer.newLine();
//                writer.flush();
//            } catch (IOException e) {
//                log.error(e.getMessage());
//            }
//        }
//        log.debug("写数据耗时：" + (System.currentTimeMillis() - start1));
//    }
//
//    public void insert() {
//        Session session = cassandraTemplate.getSession();
//        for (int i = 1; i < 100; i++) {
//            String dName = "数据" + i + "部";
//            String sql = "insert into dept(deptno,dname,db_source) values(" + i + "," + dName + ",'test_database')";
//            try {
//                session.execute(sql);
//            } catch (Exception e) {
//                System.out.println("数据插入失败！");
//            }
//        }
//        System.out.println("数据插入成功！");
//        session.close();
//    }
//
//    public void run() {
//        do {
//            List<Map> list = new ArrayList<Map>();
//            BufferedWriter writer = null;
//            File file = null;
//            long start = System.currentTimeMillis();
//            String cql = "";
//            synchronized (this) {
//                List<Map<String, Object>> list1 = jdbcTemplate.queryForList("select * from span ");
//                if (list1.size() > 0) {
//                    cql = "select * from bc_span where token(date_string,time_scale)>token('" + list1.get(0).get("date_string") + "',"
//                            + list1.get(0).get("time_scale") + ") limit " + readSize + ";";
//                    try {
//                        list = cassandraTemplate.select(cql, Map.class);
//                    } catch (Exception e) {
//                        log.error(e.getMessage());
//                    }
//                    if (list.size() > 0) {
//                        try {
//                            jdbcTemplate.execute("update span set date_string='" + list.get((list.size() - 1)).get("date_string") + "',time_scale="
//                                    + list.get((list.size() - 1)).get("time_scale"));
//                        } catch (Exception e) {
//                            log.debug(e.getMessage());
//                        }
//                    } else {
//                        isFlag = false;
//                    }
//                } else {
//                    cql = "select * from bc_span limit " + readSize + ";";
//                    try {
//                        list = cassandraTemplate.select(cql, Map.class);
//                    } catch (Exception e) {
//                        log.error(e.getMessage());
//                    }
//                    if (list.size() > 0) {
//                        try {
//                            jdbcTemplate.execute("insert into span (date_string,time_scale)values('" + list.get((list.size() - 1)).get("date_string") + "',"
//                                    + list.get((list.size() - 1)).get("time_scale") + ")");
//                        } catch (Exception e) {
//                            log.error(e.getMessage());
//                        }
//                    } else {
//                        isFlag = false;
//                    }
//
//                }
////                flag = false;
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//            log.debug("查询耗时：" + (System.currentTimeMillis() - start));
//            //select * from bc_span where token(date_string,time_scale)>token('20181225',15409) limit 10;
//            if (null == list || list.size() == 0) {
//                if (writer != null) try {
//                    writer.close();
//                } catch (IOException e) {
//                    log.error(e.getMessage());
//                }
//            } else {
////                if (flag) {
//                file = new File(filePath + Thread.currentThread().getName() + System.currentTimeMillis() + ".txt");
//                try {
//                    writer = new BufferedWriter(new FileWriter(file));
//                } catch (IOException e) {
//                    log.error(e.getMessage());
//                }
////                }
//                write(list, writer);
////                if (list.size() < readSize) {
//                if (writer != null) try {
//                    writer.close();
//                } catch (IOException e) {
//                    log.error(e.getMessage());
//                }
////                }
//            }
////            getResult();
//
//        } while (isFlag);
////        while (isFlag) {
////            getResult();
////        }
//
//    }
//
//    public synchronized void getResult() {
//        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from span ");
//        if (null == list || list.size() == 0) {
////            getAll();
//            try {
//                jdbcTemplate.execute("insert into span (date_string,time_scale)values('" + newDateString + "'," + newTimeScale + ")");
//                log.debug("数据插入成功！");
//            } catch (Exception e) {
//                log.error(e.getMessage());
//            }
//        } else {
//            try {
//                oldDateString = list.get(0).get("date_string").toString();
//                oldTimeScale = Integer.parseInt(list.get(0).get("time_scale").toString());
////                getAll();
//                jdbcTemplate.execute("update span set date_string='" + newDateString + "',time_scale=" + newTimeScale);
//                log.debug("数据更新成功！");
//            } catch (Exception e) {
//                log.error(e.getMessage());
//            }
//        }
//        flag = false;
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }
//}