
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.TbUser;
import entity.Page;

public class TbUserDao extends daoTemplate{

    /*
    * 添加
   */ 
    public int save(TbUser data) throws Exception {
        String sql="insert into tb_user(id,is_delete,mobile,name,password) values(?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(5);
        
        values.add(data.getId());
        values.add(data.getIs_delete());
        values.add(data.getMobile());
        values.add(data.getName());
        values.add(data.getPassword());
        
        return super.executeInsert(sql, values);
    }

    /*
    * 删除
   */ 
    public int delete(String id) throws Exception {
        String sql="delete from tb_user where id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(id);
        return executeUpdate(sql, values);
    }

    /*
    * 修改
   */ 
    public int update(TbUser data) throws Exception {
        StringBuffer sql=new StringBuffer("update tb_user set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getIs_delete()!=null){
            sql.append("is_delete=?,");
            values.add(data.getIs_delete());
        }
                
        if(data.getMobile()!=null){
            sql.append("mobile=?,");
            values.add(data.getMobile());
        }
                
        if(data.getName()!=null){
            sql.append("name=?,");
            values.add(data.getName());
        }
                
        if(data.getPassword()!=null){
            sql.append("password=?,");
            values.add(data.getPassword());
        }
                
        
        
        sql.append(" where id=?");
        values.add(data.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    /*
    * 分页查询
   */ 
    public List<TbUser> queryPage(String condition, List<Object> values, Page page) throws Exception {
        String sql="select id,is_delete,mobile,name,password from tb_user";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        if(values == null) {
        	values=new ArrayList<Object>(2);
        }
        sql=sql+" limit ?,?";
        values.add(page.getPageOffset());
        values.add(page.getPageSize());

        ResultSet rs=null;
        try{
        rs=executeQuery(sql, values);
        List<TbUser> datas=new ArrayList<TbUser>();
        while(rs.next()){
            TbUser data=new TbUser();
            
            data.setId(rs.getInt("id"));
            data.setIs_delete(rs.getInt("is_delete"));
            data.setMobile(rs.getString("mobile"));
            data.setName(rs.getString("name"));
            data.setPassword(rs.getString("password"));	
            datas.add(data);
        }
        return datas;
        }catch(Exception e){throw e;}
        finally{
            super.close(null, pre, rs);
        }
    }
    
    /*
    * 数据量大时请不要使用（查询全部数据）
   */ 
    public List<TbUser> queryAll(String condition, List<Object> values) throws Exception {
        String sql="select id,is_delete,mobile,name,password from tb_user";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }

        ResultSet rs=null;
        try{
        rs=executeQuery(sql, values);
        List<TbUser> datas=new ArrayList<TbUser>();
        while(rs.next()){
            TbUser data=new TbUser();
            
            data.setId(rs.getInt("id"));
            data.setIs_delete(rs.getInt("is_delete"));
            data.setMobile(rs.getString("mobile"));
            data.setName(rs.getString("name"));
            data.setPassword(rs.getString("password"));	
            datas.add(data);
        }
        return datas;
        }catch(Exception e){throw e;}
        finally{
            super.close(null, pre, rs);
        }
    }

    /*
    * 根据主键查询
   */ 
    public TbUser queryData(String id) throws Exception {
    	if(id == null) {
    		return null;
    	}
    	String sql="select * from tb_user where id = ?";
    	ResultSet rs=null;
    	ArrayList<Object> values=new ArrayList<Object>(1);
    	values.add(id);
        TbUser data= null;
        try{
        rs=executeQuery(sql, values);
        rs.next();
       
        if(rs.next()) {
        	data = new TbUser();
            
            data.setId(rs.getInt("id"));
            data.setIs_delete(rs.getInt("is_delete"));
            data.setMobile(rs.getString("mobile"));
            data.setName(rs.getString("name"));
            data.setPassword(rs.getString("password"));
        	
        }
        }catch(Exception e){throw e;}
        finally{
            super.close(conn, pre, rs);
        }
        return data;
	}

    /*
    * 查询数量总数
   */ 
    public long count(String condition, List<Object> values) throws Exception {
        String sql="select count(1) from tb_user";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }
}
            