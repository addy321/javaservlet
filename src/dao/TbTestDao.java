
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.TbTest;
import entity.Page;

public class TbTestDao extends daoTemplate{

    /*
    * 添加
   */ 
    public int save(TbTest data) throws Exception {
        String sql="insert into tb_test(aaaa,bbbb,cccc,dddd,eeeee,Id) values(?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(6);
        
        values.add(data.getAaaa());
        values.add(data.getBbbb());
        values.add(data.getCccc());
        values.add(data.getDddd());
        values.add(data.getEeeee());
        values.add(data.getId());
        
        return super.executeInsert(sql, values);
    }

    /*
    * 删除
   */ 
    public int delete(String Id) throws Exception {
        String sql="delete from tb_test where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    /*
    * 修改
   */ 
    public int update(TbTest data) throws Exception {
        StringBuffer sql=new StringBuffer("update tb_test set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getAaaa()!=null){
            sql.append("aaaa=?,");
            values.add(data.getAaaa());
        }
                
        if(data.getBbbb()!=null){
            sql.append("bbbb=?,");
            values.add(data.getBbbb());
        }
                
        if(data.getCccc()!=null){
            sql.append("cccc=?,");
            values.add(data.getCccc());
        }
                
        if(data.getDddd()!=null){
            sql.append("dddd=?,");
            values.add(data.getDddd());
        }
                
        if(data.getEeeee()!=null){
            sql.append("eeeee=?,");
            values.add(data.getEeeee());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(data.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    /*
    * 分页查询
   */ 
    public List<TbTest> queryPage(String condition, List<Object> values, Page page) throws Exception {
        String sql="select aaaa,bbbb,cccc,dddd,eeeee,Id from tb_test";
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
        List<TbTest> datas=new ArrayList<TbTest>();
        while(rs.next()){
            TbTest data=new TbTest();
            
            data.setAaaa(rs.getString("aaaa"));
            data.setBbbb(rs.getString("bbbb"));
            data.setCccc(rs.getString("cccc"));
            data.setDddd(rs.getString("dddd"));
            data.setEeeee(rs.getString("eeeee"));
            data.setId(rs.getInt("Id"));	
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
    public List<TbTest> queryAll(String condition, List<Object> values) throws Exception {
        String sql="select aaaa,bbbb,cccc,dddd,eeeee,Id from tb_test";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }

        ResultSet rs=null;
        try{
        rs=executeQuery(sql, values);
        List<TbTest> datas=new ArrayList<TbTest>();
        while(rs.next()){
            TbTest data=new TbTest();
            
            data.setAaaa(rs.getString("aaaa"));
            data.setBbbb(rs.getString("bbbb"));
            data.setCccc(rs.getString("cccc"));
            data.setDddd(rs.getString("dddd"));
            data.setEeeee(rs.getString("eeeee"));
            data.setId(rs.getInt("Id"));	
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
    public TbTest queryData(String Id) throws Exception {
    	if(id == null) {
    		return null;
    	}
    	String sql="select * from tb_test where Id = ?";
    	ResultSet rs=null;
    	ArrayList<Object> values=new ArrayList<Object>(1);
    	values.add(id);
        TbTest data= null;
        try{
        rs=executeQuery(sql, values);
        rs.next();
       
        if(rs.next()) {
        	data = new TbTest();
            
            data.setAaaa(rs.getString("aaaa"));
            data.setBbbb(rs.getString("bbbb"));
            data.setCccc(rs.getString("cccc"));
            data.setDddd(rs.getString("dddd"));
            data.setEeeee(rs.getString("eeeee"));
            data.setId(rs.getInt("Id"));
        	
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
        String sql="select count(1) from tb_test";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }
}
            