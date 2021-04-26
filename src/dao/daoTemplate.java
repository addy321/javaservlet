package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.List;

import tool.JDBCUtil;

public class daoTemplate {
    protected Connection conn;
    // 用于查询中使用
    protected PreparedStatement pre;

    public daoTemplate() {

    }

    // 获取mysql连接
    private void connection() {
        conn = JDBCUtil.getMySQLConnection();
    }

    // 用于普通的update、delete语句
    private PreparedStatement PreparedStatement(String sql) throws SQLException {
        connection();
        return conn.prepareStatement(sql);
    }

    // 设置用于获得数据库自动产生的字段，用于insert语句
    private PreparedStatement insertPreparedStatement(String sql) throws SQLException {
        connection();
        return conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    }

    // 用于将占位符的值赋值到preparedstatement对象中
    private void bindParamters(PreparedStatement pre, List<Object> values) throws SQLException {
        int index = 1;
        if (values != null && values.size() >= 1)
            for (Object obj : values) {
                pre.setObject(index, obj);
                index++;
            }
    }

    // 执行普通的sql的update、delete操作
    private void executeUpdate(PreparedStatement pre) throws SQLException {
        pre.executeUpdate();
    }

    // 执行insert操作
    public Integer executeInsert(String sql, List<Object> values) throws SQLException {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Integer id = null;
        try {
            connection();
            pre = insertPreparedStatement(sql);
            bindParamters(pre, values);
            executeUpdate(pre);
            // 获得底层通过自增长或者触发器产生的主键
            rs = pre.getGeneratedKeys();

            if (rs.next())
                id = rs.getInt(1);
            conn.commit();
        } catch (SQLException e) {
            throw e;
        } finally {
            close(conn, pre, rs);
        }
        return id;

    }

    private PreparedStatement createPreparedStatement(String sql, List<Object> values) throws SQLException {
        // 初始化连接
        PreparedStatement pre = PreparedStatement(sql);
        bindParamters(pre, values);
        return pre;
    }

    // 外部调用的执行update和delete语句
    public int executeUpdate(String sql, List<Object> values) throws SQLException {
        PreparedStatement pre = null;
        try {
            connection();
            pre = createPreparedStatement(sql, values);
            int res = pre.executeUpdate();
            conn.commit();
            return res;
        } catch (SQLException e) {
            throw e;
        } finally {
            close(conn, pre, null);
        }
    }

    public ResultSet executeQuery(String sql, List<Object> values) throws SQLException {
        ResultSet rs = null;
        pre = createPreparedStatement(sql, values);
        rs = pre.executeQuery();
        return rs;
    }

    public long countQuery(String sql, List<Object> values) throws SQLException {
        ResultSet rs = null;
        try {
            pre = createPreparedStatement(sql, values);
            rs = pre.executeQuery();
            rs.next();
            long count = rs.getLong(1);
            return count;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.close(conn, pre, rs);
        }

    }

    public void close(Connection conn, PreparedStatement pre, ResultSet rs) {
        if (rs != null)
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        if (pre != null)
            try {
                pre.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        if (conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    public void close() {
        close(conn, null, null);
    }
}
