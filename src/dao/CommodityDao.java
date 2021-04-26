
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Commodity;
import entity.Page;

public class CommodityDao extends daoTemplate {

    /*
     * 添加
     */
    public int save(Commodity data) throws Exception {
        String sql = "insert into commodity(almostNew,currentPrice,id,price,productName) values(?,?,?,?,?)";
        List<Object> values = new ArrayList<Object>(5);

        values.add(data.getAlmostNew());
        values.add(data.getCurrentPrice());
        values.add(data.getId());
        values.add(data.getPrice());
        values.add(data.getProductName());

        return super.executeInsert(sql, values);
    }

    /*
     * 删除
     */
    public int delete(String id) throws Exception {
        String sql = "delete from commodity where id=?";
        List<Object> values = new ArrayList<Object>(1);
        values.add(id);
        return executeUpdate(sql, values);
    }

    /*
     * 修改
     */
    public int update(Commodity data) throws Exception {
        StringBuffer sql = new StringBuffer("update commodity set ");
        List<Object> values = new ArrayList<Object>();

        if (data.getAlmostNew() != null) {
            sql.append("almostNew=?,");
            values.add(data.getAlmostNew());
        }

        if (data.getCurrentPrice() != null) {
            sql.append("currentPrice=?,");
            values.add(data.getCurrentPrice());
        }

        if (data.getPrice() != null) {
            sql.append("price=?,");
            values.add(data.getPrice());
        }

        if (data.getProductName() != null) {
            sql.append("productName=?,");
            values.add(data.getProductName());
        }


        sql.append(" where id=?");
        values.add(data.getId());

        return executeUpdate(sql.toString(), values);
    }

    /*
     * 分页查询
     */
    public List<Commodity> queryPage(String condition, List<Object> values, Page page) throws Exception {
        String sql = "select almostNew,currentPrice,id,price,productName from commodity";
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
            List<Commodity> datas = new ArrayList<Commodity>();
            while (rs.next()) {
                Commodity data = new Commodity();

                data.setAlmostNew(rs.getString("almostNew"));
                data.setCurrentPrice(rs.getDouble("currentPrice"));
                data.setId(rs.getInt("id"));
                data.setPrice(rs.getDouble("price"));
                data.setProductName(rs.getString("productName"));
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
    public List<Commodity> queryAll(String condition, List<Object> values) throws Exception {
        String sql = "select almostNew,currentPrice,id,price,productName from commodity";
        if (condition != null && !"".equals(condition) && values != null && values.size() > 0) {
            sql = sql + " where " + condition;
        }

        ResultSet rs = null;
        try {
            rs = executeQuery(sql, values);
            List<Commodity> datas = new ArrayList<Commodity>();
            while (rs.next()) {
                Commodity data = new Commodity();

                data.setAlmostNew(rs.getString("almostNew"));
                data.setCurrentPrice(rs.getDouble("currentPrice"));
                data.setId(rs.getInt("id"));
                data.setPrice(rs.getDouble("price"));
                data.setProductName(rs.getString("productName"));
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
    public Commodity queryData(String id) throws Exception {
        if (id == null) {
            return null;
        }
        String sql = "select * from commodity where id = ?";
        ResultSet rs = null;
        ArrayList<Object> values = new ArrayList<Object>(1);
        values.add(id);
        Commodity data = null;
        try {
            rs = executeQuery(sql, values);
            rs.next();

            if (rs.next()) {
                data = new Commodity();

                data.setAlmostNew(rs.getString("almostNew"));
                data.setCurrentPrice(rs.getDouble("currentPrice"));
                data.setId(rs.getInt("id"));
                data.setPrice(rs.getDouble("price"));
                data.setProductName(rs.getString("productName"));

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
        String sql = "select count(1) from commodity";
        if (condition != null && !"".equals(condition) && values != null && values.size() > 0) {
            sql = sql + " where " + condition;
        }
        return countQuery(sql, values);
    }
}
            