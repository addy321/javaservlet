
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.AGQPGameRecord;
import entity.Page;

public class AGQPGameRecordDao extends daoTemplate{

    /*
    * 添加
   */ 
    public int save(AGQPGameRecord data) throws Exception {
        String sql="insert into AGQPGameRecord(Id,CompanyStyle,Account,GameName,ServerName,BetAmount,Score,Revenue,PlayerId,ServerId,GameId,StartTime,EndTime,GameCode,CreateTime,IsDelete) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object> values=new ArrayList<Object>(16);
        
        values.add(data.getId());
        values.add(data.getCompanyStyle());
        values.add(data.getAccount());
        values.add(data.getGameName());
        values.add(data.getServerName());
        values.add(data.getBetAmount());
        values.add(data.getScore());
        values.add(data.getRevenue());
        values.add(data.getPlayerId());
        values.add(data.getServerId());
        values.add(data.getGameId());
        values.add(data.getStartTime());
        values.add(data.getEndTime());
        values.add(data.getGameCode());
        values.add(data.getCreateTime());
        values.add(data.getIsDelete());
        
        return super.executeInsert(sql, values);
    }

    /*
    * 删除
   */ 
    public int delete(String Id) throws Exception {
        String sql="delete from AGQPGameRecord where Id=?";
        List<Object> values=new ArrayList<Object>(1);
            values.add(Id);
        return executeUpdate(sql, values);
    }

    /*
    * 修改
   */ 
    public int update(AGQPGameRecord data) throws Exception {
        StringBuffer sql=new StringBuffer("update AGQPGameRecord set ");
        List<Object> values=new ArrayList<Object>();
        
        if(data.getId()!=null){
            sql.append("Id=?,");
            values.add(data.getId());
        }
                
        if(data.getCompanyStyle()!=null){
            sql.append("CompanyStyle=?,");
            values.add(data.getCompanyStyle());
        }
                
        if(data.getAccount()!=null){
            sql.append("Account=?,");
            values.add(data.getAccount());
        }
                
        if(data.getGameName()!=null){
            sql.append("GameName=?,");
            values.add(data.getGameName());
        }
                
        if(data.getServerName()!=null){
            sql.append("ServerName=?,");
            values.add(data.getServerName());
        }
                
        if(data.getBetAmount()!=null){
            sql.append("BetAmount=?,");
            values.add(data.getBetAmount());
        }
                
        if(data.getScore()!=null){
            sql.append("Score=?,");
            values.add(data.getScore());
        }
                
        if(data.getRevenue()!=null){
            sql.append("Revenue=?,");
            values.add(data.getRevenue());
        }
                
        if(data.getPlayerId()!=null){
            sql.append("PlayerId=?,");
            values.add(data.getPlayerId());
        }
                
        if(data.getServerId()!=null){
            sql.append("ServerId=?,");
            values.add(data.getServerId());
        }
                
        if(data.getGameId()!=null){
            sql.append("GameId=?,");
            values.add(data.getGameId());
        }
                
        if(data.getStartTime()!=null){
            sql.append("StartTime=?,");
            values.add(data.getStartTime());
        }
                
        if(data.getEndTime()!=null){
            sql.append("EndTime=?,");
            values.add(data.getEndTime());
        }
                
        if(data.getGameCode()!=null){
            sql.append("GameCode=?,");
            values.add(data.getGameCode());
        }
                
        if(data.getCreateTime()!=null){
            sql.append("CreateTime=?,");
            values.add(data.getCreateTime());
        }
                
        if(data.getIsDelete()!=null){
            sql.append("IsDelete=?,");
            values.add(data.getIsDelete());
        }
                
        
        
        sql.append(" where Id=?");
        values.add(data.getId());
        
        return executeUpdate(sql.toString(), values);
    }

    /*
    * 分页查询
   */ 
    public List<AGQPGameRecord> queryPage(String condition, List<Object> values, Page page) throws Exception {
        String sql="select Id,CompanyStyle,Account,GameName,ServerName,BetAmount,Score,Revenue,PlayerId,ServerId,GameId,StartTime,EndTime,GameCode,CreateTime,IsDelete from AGQPGameRecord";
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
        List<AGQPGameRecord> datas=new ArrayList<AGQPGameRecord>();
        while(rs.next()){
            AGQPGameRecord data=new AGQPGameRecord();
            
            data.setId(rs.getInt("Id"));
            data.setCompanyStyle(rs.getString("CompanyStyle"));
            data.setAccount(rs.getString("Account"));
            data.setGameName(rs.getString("GameName"));
            data.setServerName(rs.getString("ServerName"));
            data.setBetAmount(rs.getDouble("BetAmount"));
            data.setScore(rs.getDouble("Score"));
            data.setRevenue(rs.getDouble("Revenue"));
            data.setPlayerId(rs.getInt("PlayerId"));
            data.setServerId(rs.getInt("ServerId"));
            data.setGameId(rs.getInt("GameId"));
            data.setStartTime(rs.getDate("StartTime"));
            data.setEndTime(rs.getDate("EndTime"));
            data.setGameCode(rs.getString("GameCode"));
            data.setCreateTime(rs.getDate("CreateTime"));
            data.setIsDelete(rs.getString("IsDelete"));	
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
    public List<AGQPGameRecord> queryAll(String condition, List<Object> values) throws Exception {
        String sql="select Id,CompanyStyle,Account,GameName,ServerName,BetAmount,Score,Revenue,PlayerId,ServerId,GameId,StartTime,EndTime,GameCode,CreateTime,IsDelete from AGQPGameRecord";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }

        ResultSet rs=null;
        try{
        rs=executeQuery(sql, values);
        List<AGQPGameRecord> datas=new ArrayList<AGQPGameRecord>();
        while(rs.next()){
            AGQPGameRecord data=new AGQPGameRecord();
            
            data.setId(rs.getInt("Id"));
            data.setCompanyStyle(rs.getString("CompanyStyle"));
            data.setAccount(rs.getString("Account"));
            data.setGameName(rs.getString("GameName"));
            data.setServerName(rs.getString("ServerName"));
            data.setBetAmount(rs.getDouble("BetAmount"));
            data.setScore(rs.getDouble("Score"));
            data.setRevenue(rs.getDouble("Revenue"));
            data.setPlayerId(rs.getInt("PlayerId"));
            data.setServerId(rs.getInt("ServerId"));
            data.setGameId(rs.getInt("GameId"));
            data.setStartTime(rs.getDate("StartTime"));
            data.setEndTime(rs.getDate("EndTime"));
            data.setGameCode(rs.getString("GameCode"));
            data.setCreateTime(rs.getDate("CreateTime"));
            data.setIsDelete(rs.getString("IsDelete"));	
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
    public AGQPGameRecord queryData(String Id) throws Exception {
    	if(id == null) {
    		return null;
    	}
    	String sql="select * from AGQPGameRecord where Id = ?";
    	ResultSet rs=null;
    	ArrayList<Object> values=new ArrayList<Object>(1);
    	values.add(id);
        AGQPGameRecord data= null;
        try{
        rs=executeQuery(sql, values);
        rs.next();
       
        if(rs.next()) {
        	data = new AGQPGameRecord();
            
            data.setId(rs.getInt("Id"));
            data.setCompanyStyle(rs.getString("CompanyStyle"));
            data.setAccount(rs.getString("Account"));
            data.setGameName(rs.getString("GameName"));
            data.setServerName(rs.getString("ServerName"));
            data.setBetAmount(rs.getDouble("BetAmount"));
            data.setScore(rs.getDouble("Score"));
            data.setRevenue(rs.getDouble("Revenue"));
            data.setPlayerId(rs.getInt("PlayerId"));
            data.setServerId(rs.getInt("ServerId"));
            data.setGameId(rs.getInt("GameId"));
            data.setStartTime(rs.getDate("StartTime"));
            data.setEndTime(rs.getDate("EndTime"));
            data.setGameCode(rs.getString("GameCode"));
            data.setCreateTime(rs.getDate("CreateTime"));
            data.setIsDelete(rs.getString("IsDelete"));
        	
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
        String sql="select count(1) from AGQPGameRecord";
        if(condition!=null&&!"".equals(condition)&&values!=null&&values.size()>0){
            sql=sql+" where "+condition;
        }
        return countQuery(sql, values);
    }
}
            