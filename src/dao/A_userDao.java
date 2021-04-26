
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.A_user;
import entity.Page;

public class A_userDao extends daoTemplate {

    /*
     * 添加
     */
    public int save(A_user data) throws Exception {
        String sql = "insert into a_user(createTime,id,name,phone,pwd,type) values(?,?,?,?,?,?)";
        List<Object> values = new ArrayList<Object>(6);

        values.add(data.getCreateTime());
        values.add(data.getId());
        values.add(data.getName());
        values.add(data.getPhone());
        values.add(data.getPwd());
        values.add(data.getType());

        return super.executeInsert(sql, values);
    }

    /*
     * 删除
     */
    public int delete(String id) throws Exception {
        String sql = "delete from a_user where id=?";
        List<Object> values = new ArrayList<Object>(1);
        values.add(id);
        return executeUpdate(sql, values);
    }

    /*
     * 修改
     */
    public int update(A_user data) throws Exception {
        StringBuffer sql = new StringBuffer("update a_user set ");
        List<Object> values = new ArrayList<Object>();

        if (data.getCreateTime() != null) {
            sql.append("createTime=?,");
            values.add(data.getCreateTime());
        }

        if (data.getName() != null) {
            sql.append("name=?,");
            values.add(data.getName());
        }

        if (data.getPhone() != null) {
            sql.append("phone=?,");
            values.add(data.getPhone());
        }

        if (data.getPwd() != null) {
            sql.append("pwd=?,");
            values.add(data.getPwd());
        }

        if (data.getType() != null) {
            sql.append("type=?,");
            values.add(data.getType());
        }


        sql.append(" where id=?");
        values.add(data.getId());

        return executeUpdate(sql.toString(), values);
    }

    /*
     * 分页查询
     */
    public List<A_user> queryPage(String condition, List<Object> values, Page page) throws Exception {
        String sql = "select createTime,id,name,phone,pwd,type from a_user";
        if (condition != null && !"".equals(condition) && values != null && values.size() > 0) {
            sql = sql + " where " + condition;
        }
        if (values == null) {
            values = new ArrayList<Object>(2);
        }
        sql = sql + " limit ?,?";
        values.add(page.getPageOffset());
        values.add(page.getPageSize());

        ResultSet rs = null;
        try {
            rs = executeQuery(sql, values);
            List<A_user> datas = new ArrayList<A_user>();
            while (rs.next()) {
                A_user data = new A_user();

                data.setCreateTime(rs.getDate("createTime"));
                data.setId(rs.getInt("id"));
                data.setName(rs.getString("name"));
                data.setPhone(rs.getString("phone"));
                data.setPwd(rs.getString("pwd"));
                data.setType(rs.getInt("type"));
                datas.add(data);
            }
            return datas;
        } catch (Exception e) {
            throw e;
        } finally {
            super.close(null, pre, rs);
        }
    }

    /*
     * 数据量大时请不要使用（查询全部数据）
     */
    public List<A_user> queryAll(String condition, List<Object> values) throws Exception {
        String sql = "select createTime,id,name,phone,pwd,type from a_user";
        if (condition != null && !"".equals(condition) && values != null && values.size() > 0) {
            sql = sql + " where " + condition;
        }

        ResultSet rs = null;
        try {
            rs = executeQuery(sql, values);
            List<A_user> datas = new ArrayList<A_user>();
            while (rs.next()) {
                A_user data = new A_user();

                data.setCreateTime(rs.getDate("createTime"));
                data.setId(rs.getInt("id"));
                data.setName(rs.getString("name"));
                data.setPhone(rs.getString("phone"));
                data.setPwd(rs.getString("pwd"));
                data.setType(rs.getInt("type"));
                datas.add(data);
            }
            return datas;
        } catch (Exception e) {
            throw e;
        } finally {
            super.close(null, pre, rs);
        }
    }

    /*
     * 根据主键查询
     */
    public A_user queryData(String id) throws Exception {
        if (id == null) {
            return null;
        }
        String sql = "select * from a_user where id = ?";
        ResultSet rs = null;
        ArrayList<Object> values = new ArrayList<Object>(1);
        values.add(id);
        A_user data = null;
        try {
            rs = executeQuery(sql, values);
            rs.next();

            if (rs.next()) {
                data = new A_user();

                data.setCreateTime(rs.getDate("createTime"));
                data.setId(rs.getInt("id"));
                data.setName(rs.getString("name"));
                data.setPhone(rs.getString("phone"));
                data.setPwd(rs.getString("pwd"));
                data.setType(rs.getInt("type"));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            super.close(conn, pre, rs);
        }
        return data;
    }

    /*
     * 查询数量总数
     */
    public long count(String condition, List<Object> values) throws Exception {
        String sql = "select count(1) from a_user";
        if (condition != null && !"".equals(condition) && values != null && values.size() > 0) {
            sql = sql + " where " + condition;
        }
        return countQuery(sql, values);
    }
}
            