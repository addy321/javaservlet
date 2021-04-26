
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Umessage;
import entity.Page;

public class UmessageDao extends daoTemplate {

    /*
     * 添加
     */
    public int save(Umessage data) throws Exception {
        String sql = "insert into umessage(id,productName,text,userName) values(?,?,?,?)";
        List<Object> values = new ArrayList<Object>(4);

        values.add(data.getId());
        values.add(data.getProductName());
        values.add(data.getText());
        values.add(data.getUserName());

        return super.executeInsert(sql, values);
    }

    /*
     * 删除
     */
    public int delete(String id) throws Exception {
        String sql = "delete from umessage where id=?";
        List<Object> values = new ArrayList<Object>(1);
        values.add(id);
        return executeUpdate(sql, values);
    }

    /*
     * 修改
     */
    public int update(Umessage data) throws Exception {
        StringBuffer sql = new StringBuffer("update umessage set ");
        List<Object> values = new ArrayList<Object>();

        if (data.getProductName() != null) {
            sql.append("productName=?,");
            values.add(data.getProductName());
        }

        if (data.getText() != null) {
            sql.append("text=?,");
            values.add(data.getText());
        }

        if (data.getUserName() != null) {
            sql.append("userName=?,");
            values.add(data.getUserName());
        }


        sql.append(" where id=?");
        values.add(data.getId());

        return executeUpdate(sql.toString(), values);
    }

    /*
     * 分页查询
     */
    public List<Umessage> queryPage(String condition, List<Object> values, Page page) throws Exception {
        String sql = "select id,productName,text,userName from umessage";
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
            List<Umessage> datas = new ArrayList<Umessage>();
            while (rs.next()) {
                Umessage data = new Umessage();

                data.setId(rs.getInt("id"));
                data.setProductName(rs.getString("productName"));
                data.setText(rs.getString("text"));
                data.setUserName(rs.getString("userName"));
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
    public List<Umessage> queryAll(String condition, List<Object> values) throws Exception {
        String sql = "select id,productName,text,userName from umessage";
        if (condition != null && !"".equals(condition) && values != null && values.size() > 0) {
            sql = sql + " where " + condition;
        }

        ResultSet rs = null;
        try {
            rs = executeQuery(sql, values);
            List<Umessage> datas = new ArrayList<Umessage>();
            while (rs.next()) {
                Umessage data = new Umessage();

                data.setId(rs.getInt("id"));
                data.setProductName(rs.getString("productName"));
                data.setText(rs.getString("text"));
                data.setUserName(rs.getString("userName"));
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
    public Umessage queryData(String id) throws Exception {
        if (id == null) {
            return null;
        }
        String sql = "select * from umessage where id = ?";
        ResultSet rs = null;
        ArrayList<Object> values = new ArrayList<Object>(1);
        values.add(id);
        Umessage data = null;
        try {
            rs = executeQuery(sql, values);
            rs.next();

            if (rs.next()) {
                data = new Umessage();

                data.setId(rs.getInt("id"));
                data.setProductName(rs.getString("productName"));
                data.setText(rs.getString("text"));
                data.setUserName(rs.getString("userName"));

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
        String sql = "select count(1) from umessage";
        if (condition != null && !"".equals(condition) && values != null && values.size() > 0) {
            sql = sql + " where " + condition;
        }
        return countQuery(sql, values);
    }
}
            