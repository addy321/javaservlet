
package entity;
// 用户角色表
public class TbUserRole{
    public TbUserRole() {

    }
    
    //主键
    private Integer id;
        
    //角色ID
    private Integer roleId;
        
    //用户ID
    private Integer userId;
        
    public Integer getId() {
        return id;
    }
    public void setId(Integer Id) {
        this.id = Id;
    }
            
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer RoleId) {
        this.roleId = RoleId;
    }
            
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer UserId) {
        this.userId = UserId;
    }
             
    @Override
    public String toString() {
        return "TbUserRole[id=" + id + ",roleId=" + roleId + ",userId=" + userId + "]";
    }
        
    
}
    