package tool;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC数据库操作工具类  简化数据库操作
 *
 * @author wxisme
 */

public class JDBCUtil {
    //资源文件
    /*
     * static Properties pros = null; //静态初始化 当加载JDBCUtil类时调用 static { pros = new
     * Properties(); try { //加载资源文件 InputStream in =
     * Thread.currentThread().getContextClassLoader().getResourceAsStream(
     * "db.properties"); if(in == null) { throw new
     * FileNotFoundException("配置文件未找到"); } pros.load(in); } catch (IOException e) {
     * e.printStackTrace(); } }
     */

    private static final String MDRIVENAME = "com.mysql.jdbc.Driver";
    private static final String MURL = "jdbc:mysql://localhost:3306/jdbcproject?serverTimezone=UTC&useSSL=false";
    private static final String MUSER = "root";
    private static final String MPASSWORD = "1234";

    /**
     * 获取数据库连接
     *
     * @return Connection
     */
    public static Connection getMySQLConnection() {
        Connection conn = null;
        try {
            //加载数据库驱动
            Class.forName(MDRIVENAME);
            //获取数据库连接
            conn = DriverManager.getConnection(MURL, MUSER, MPASSWORD);
            conn.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /*
     * public static Connection getOracleConn(){ try {
     * Class.forName(pros.getProperty("oracleDriver")); return
     * DriverManager.getConnection(pros.getProperty("oracleURL"),
     * pros.getProperty("oracleUser"),pros.getProperty("oraclePwd")); } catch
     * (Exception e) { e.printStackTrace(); return null; } }
     */

    /**
     * 关闭io资源
     *
     * @param io
     */
    public static void closeFile(Closeable... io) {
        for (Closeable temp : io) {
            if (temp != null) {
                try {
                    temp.close();
                } catch (IOException e) {
                    System.out.println("文件关闭失败");
                    e.printStackTrace();
                }
            }
        }
    }

    //关闭JDBC资源  注意顺序
    public static void close(ResultSet rs, Statement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement ps, Connection conn) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
