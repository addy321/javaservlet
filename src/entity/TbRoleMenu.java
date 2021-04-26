
package entity;
// 角色菜单关系表
public class TbRoleMenu{
    public TbRoleMenu() {

    }
    
    //主键
    private Integer id;
        
    //菜单ID
    private Integer menuId;
        
    //角色ID
    private Integer roleId;
        
    public Integer getId() {
        return id;
    }
    public void setId(Integer Id) {
        this.id = Id;
    }
            
    public Integer getMenuId() {
        return menuId;
    }
    public void setMenuId(Integer MenuId) {
        this.menuId = MenuId;
    }
            
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer RoleId) {
        this.roleId = RoleId;
    }
             
    @Override
    public String toString() {
        return "TbRoleMenu[id=" + id + ",menuId=" + menuId + ",roleId=" + roleId + "]";
    }
        
    
}
    