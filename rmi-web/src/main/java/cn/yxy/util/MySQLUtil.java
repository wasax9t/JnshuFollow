package cn.yxy.util;

import java.sql.Connection;
import java.sql.DriverManager;

//已经不用了
public class MySQLUtil {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/db_jnshu_follow"
            + "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static final String DBUSER = "root";
    private static final String DBPASS = "admin";

    public static Connection getConn() throws Exception {
        Connection conn = null;

        // 加载驱动
        Class.forName(JDBC_DRIVER);

        // 连接数据库
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        return conn;
    }

}