
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.TbRole;
import entity.Page;

public class TbRoleDao extends daoTemplate{

    /*
    * 添加
   */ 
    public int save(TbRole data) throws Exception {
        String sql="insert into tb_role(code,id,is_delete,name) values(?,?,?,?)";
        List<Object> values=new ArrayList<Object>(4);
        
        values.add(data.getCode());
        values.add(data.getId());
        values.add(data.getIs_delete());
        values.add(data.getName());
        
        return super.executeInsert(sql, values);
    }

    /*
    * 删除
   */ 
    public int delete(String id) throws Exception {
        String sql="delete from tb_role where id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(id);
        return executeUpdate(sql, values);
    }

    /*
    * 修改
   */ 
    public int update(TbRole data) throws Exception {
        StringBuffer sql=new StringBuffer("update tb_role set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getCode()!=null){
            sql.append("code=?,");
            values.add(data.getCode());
        }
                
        if(data.getIs_delete()!=null){
            sql.append("is_delete=?,");
            values.add(data.getIs_delete());
        }
                
        if(data.getName()!=null){
            sql.append("name=?,");
            values.add(data.getName());
        }
                
        
        
        sql.append(" where id=?");
        values.add(data.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    /*
    * 分页查询
   */ 
    public List<TbRole> queryPage(String condition, List<Object> values, Page page) throws Exception {
        String sql="select code,id,is_delete,name from tb_role";
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
        List<TbRole> datas=new ArrayList<TbRole>();
        while(rs.next()){
            TbRole data=new TbRole();
            
            data.setCode(rs.getString("code"));
            data.setId(rs.getInt("id"));
            data.setIs_delete(rs.getInt("is_delete"));
            data.setName(rs.getString("name"));	
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
    public List<TbRole> queryAll(String condition, List<Object> values) throws Exception {
        String sql="select code,id,is_delete,name from tb_role";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }

        ResultSet rs=null;
        try{
        rs=executeQuery(sql, values);
        List<TbRole> datas=new ArrayList<TbRole>();
        while(rs.next()){
            TbRole data=new TbRole();
            
            data.setCode(rs.getString("code"));
            data.setId(rs.getInt("id"));
            data.setIs_delete(rs.getInt("is_delete"));
            data.setName(rs.getString("name"));	
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
    public TbRole queryData(String id) throws Exception {
    	if(id == null) {
    		return null;
    	}
    	String sql="select * from tb_role where id = ?";
    	ResultSet rs=null;
    	ArrayList<Object> values=new ArrayList<Object>(1);
    	values.add(id);
        TbRole data= null;
        try{
        rs=executeQuery(sql, values);
        rs.next();
       
        if(rs.next()) {
        	data = new TbRole();
            
            data.setCode(rs.getString("code"));
            data.setId(rs.getInt("id"));
            data.setIs_delete(rs.getInt("is_delete"));
            data.setName(rs.getString("name"));
        	
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
        String sql="select count(1) from tb_role";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }
}
            