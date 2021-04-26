
package entity;
// 角色表
public class TbRole{
    public TbRole() {

    }
    
    //编码
    private String code;
        
    //主键
    private Integer id;
        
    //是否删除 1：已删除；0：未删除
    private Integer isDelete;
        
    //名称
    private String name;
        
    public String getCode() {
        return code;
    }
    public void setCode(String Code) {
        this.code = Code;
    }
            
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
            
    public String getName() {
        return name;
    }
    public void setName(String Name) {
        this.name = Name;
    }
             
    @Override
    public String toString() {
        return "TbRole[code=" + code + ",id=" + id + ",isDelete=" + isDelete + ",name=" + name + "]";
    }
        
    
}
    