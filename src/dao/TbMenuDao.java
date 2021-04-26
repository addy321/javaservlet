
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.TbMenu;
import entity.Page;

public class TbMenuDao extends daoTemplate{

    /*
    * 添加
   */ 
    public int save(TbMenu data) throws Exception {
        String sql="insert into tb_menu(icon_url,id,is_delete,level,link_url,menu_code,name,node_type,parent_id,path,sort) values(?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(11);
        
        values.add(data.getIcon_url());
        values.add(data.getId());
        values.add(data.getIs_delete());
        values.add(data.getLevel());
        values.add(data.getLink_url());
        values.add(data.getMenu_code());
        values.add(data.getName());
        values.add(data.getNode_type());
        values.add(data.getParent_id());
        values.add(data.getPath());
        values.add(data.getSort());
        
        return super.executeInsert(sql, values);
    }

    /*
    * 删除
   */ 
    public int delete(String id) throws Exception {
        String sql="delete from tb_menu where id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(id);
        return executeUpdate(sql, values);
    }

    /*
    * 修改
   */ 
    public int update(TbMenu data) throws Exception {
        StringBuffer sql=new StringBuffer("update tb_menu set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getIcon_url()!=null){
            sql.append("icon_url=?,");
            values.add(data.getIcon_url());
        }
                
        if(data.getIs_delete()!=null){
            sql.append("is_delete=?,");
            values.add(data.getIs_delete());
        }
                
        if(data.getLevel()!=null){
            sql.append("level=?,");
            values.add(data.getLevel());
        }
                
        if(data.getLink_url()!=null){
            sql.append("link_url=?,");
            values.add(data.getLink_url());
        }
                
        if(data.getMenu_code()!=null){
            sql.append("menu_code=?,");
            values.add(data.getMenu_code());
        }
                
        if(data.getName()!=null){
            sql.append("name=?,");
            values.add(data.getName());
        }
                
        if(data.getNode_type()!=null){
            sql.append("node_type=?,");
            values.add(data.getNode_type());
        }
                
        if(data.getParent_id()!=null){
            sql.append("parent_id=?,");
            values.add(data.getParent_id());
        }
                
        if(data.getPath()!=null){
            sql.append("path=?,");
            values.add(data.getPath());
        }
                
        if(data.getSort()!=null){
            sql.append("sort=?,");
            values.add(data.getSort());
        }
                
        
        
        sql.append(" where id=?");
        values.add(data.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    /*
    * 分页查询
   */ 
    public List<TbMenu> queryPage(String condition, List<Object> values, Page page) throws Exception {
        String sql="select icon_url,id,is_delete,level,link_url,menu_code,name,node_type,parent_id,path,sort from tb_menu";
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
        List<TbMenu> datas=new ArrayList<TbMenu>();
        while(rs.next()){
            TbMenu data=new TbMenu();
            
            data.setIcon_url(rs.getString("icon_url"));
            data.setId(rs.getInt("id"));
            data.setIs_delete(rs.getInt("is_delete"));
            data.setLevel(rs.getInt("level"));
            data.setLink_url(rs.getString("link_url"));
            data.setMenu_code(rs.getString("menu_code"));
            data.setName(rs.getString("name"));
            data.setNode_type(rs.getInt("node_type"));
            data.setParent_id(rs.getInt("parent_id"));
            data.setPath(rs.getString("path"));
            data.setSort(rs.getInt("sort"));	
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
    public List<TbMenu> queryAll(String condition, List<Object> values) throws Exception {
        String sql="select icon_url,id,is_delete,level,link_url,menu_code,name,node_type,parent_id,path,sort from tb_menu";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }

        ResultSet rs=null;
        try{
        rs=executeQuery(sql, values);
        List<TbMenu> datas=new ArrayList<TbMenu>();
        while(rs.next()){
            TbMenu data=new TbMenu();
            
            data.setIcon_url(rs.getString("icon_url"));
            data.setId(rs.getInt("id"));
            data.setIs_delete(rs.getInt("is_delete"));
            data.setLevel(rs.getInt("level"));
            data.setLink_url(rs.getString("link_url"));
            data.setMenu_code(rs.getString("menu_code"));
            data.setName(rs.getString("name"));
            data.setNode_type(rs.getInt("node_type"));
            data.setParent_id(rs.getInt("parent_id"));
            data.setPath(rs.getString("path"));
            data.setSort(rs.getInt("sort"));	
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
    public TbMenu queryData(String id) throws Exception {
    	if(id == null) {
    		return null;
    	}
    	String sql="select * from tb_menu where id = ?";
    	ResultSet rs=null;
    	ArrayList<Object> values=new ArrayList<Object>(1);
    	values.add(id);
        TbMenu data= null;
        try{
        rs=executeQuery(sql, values);
        rs.next();
       
        if(rs.next()) {
        	data = new TbMenu();
            
            data.setIcon_url(rs.getString("icon_url"));
            data.setId(rs.getInt("id"));
            data.setIs_delete(rs.getInt("is_delete"));
            data.setLevel(rs.getInt("level"));
            data.setLink_url(rs.getString("link_url"));
            data.setMenu_code(rs.getString("menu_code"));
            data.setName(rs.getString("name"));
            data.setNode_type(rs.getInt("node_type"));
            data.setParent_id(rs.getInt("parent_id"));
            data.setPath(rs.getString("path"));
            data.setSort(rs.getInt("sort"));
        	
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
        String sql="select count(1) from tb_menu";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }
}
            