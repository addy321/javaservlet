
package entity;
// 用户表
public class Tb_user{
    public Tb_user() {

    }
    
    //消息给过来的ID
    private Integer id;
        
    //是否删除 1：已删除；0：未删除
    private Integer isDelete;
        
    //手机号
    private String mobile;
        
    //姓名
    private String name;
        
    //密码
    private String password;
        
    public Integer getId() {
        return id;
    }
    public void setId(Integer Id) {
        this.id = Id;
    }
            
    public Integer getIsDelete() {
        return isDelete;
    }
    public void setIsDelete(Integer IsDelete) {
        this.isDelete = IsDelete;
    }
            
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String Mobile) {
        this.mobile = Mobile;
    }
            
    public String getName() {
        return name;
    }
    public void setName(String Name) {
        this.name = Name;
    }
            
    public String getPassword() {
        return password;
    }
    public void setPassword(String Password) {
        this.password = Password;
    }
             
    @Override
    public String toString() {
        return "Tb_user[id=" + id + ",isDelete=" + isDelete + ",mobile=" + mobile + ",name=" + name + ",password=" + password + "]";
    }
        
    
}
    