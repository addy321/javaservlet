
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.TbRoleMenu;
import entity.Page;

public class TbRoleMenuDao extends daoTemplate{

    /*
    * 添加
   */ 
    public int save(TbRoleMenu data) throws Exception {
        String sql="insert into tb_role_menu(id,menu_id,role_id) values(?,?,?)";
        List<Object> values=new ArrayList<Object>(3);
        
        values.add(data.getId());
        values.add(data.getMenu_id());
        values.add(data.getRole_id());
        
        return super.executeInsert(sql, values);
    }

    /*
    * 删除
   */ 
    public int delete(String id) throws Exception {
        String sql="delete from tb_role_menu where id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(id);
        return executeUpdate(sql, values);
    }

    /*
    * 修改
   */ 
    public int update(TbRoleMenu data) throws Exception {
        StringBuffer sql=new StringBuffer("update tb_role_menu set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getMenu_id()!=null){
            sql.append("menu_id=?,");
            values.add(data.getMenu_id());
        }
                
        if(data.getRole_id()!=null){
            sql.append("role_id=?,");
            values.add(data.getRole_id());
        }
                
        
        
        sql.append(" where id=?");
        values.add(data.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    /*
    * 分页查询
   */ 
    public List<TbRoleMenu> queryPage(String condition, List<Object> values, Page page) throws Exception {
        String sql="select id,menu_id,role_id from tb_role_menu";
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
        List<TbRoleMenu> datas=new ArrayList<TbRoleMenu>();
        while(rs.next()){
            TbRoleMenu data=new TbRoleMenu();
            
            data.setId(rs.getInt("id"));
            data.setMenu_id(rs.getInt("menu_id"));
            data.setRole_id(rs.getInt("role_id"));	
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
    public List<TbRoleMenu> queryAll(String condition, List<Object> values) throws Exception {
        String sql="select id,menu_id,role_id from tb_role_menu";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }

        ResultSet rs=null;
        try{
        rs=executeQuery(sql, values);
        List<TbRoleMenu> datas=new ArrayList<TbRoleMenu>();
        while(rs.next()){
            TbRoleMenu data=new TbRoleMenu();
            
            data.setId(rs.getInt("id"));
            data.setMenu_id(rs.getInt("menu_id"));
            data.setRole_id(rs.getInt("role_id"));	
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
    public TbRoleMenu queryData(String id) throws Exception {
    	if(id == null) {
    		return null;
    	}
    	String sql="select * from tb_role_menu where id = ?";
    	ResultSet rs=null;
    	ArrayList<Object> values=new ArrayList<Object>(1);
    	values.add(id);
        TbRoleMenu data= null;
        try{
        rs=executeQuery(sql, values);
        rs.next();
       
        if(rs.next()) {
        	data = new TbRoleMenu();
            
            data.setId(rs.getInt("id"));
            data.setMenu_id(rs.getInt("menu_id"));
            data.setRole_id(rs.getInt("role_id"));
        	
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
        String sql="select count(1) from tb_role_menu";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }
}
            