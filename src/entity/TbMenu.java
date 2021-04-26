
package entity;
// 菜单表
public class TbMenu{
    public TbMenu() {

    }
    
    //图标地址
    private String iconUrl;
        
    //主键
    private Integer id;
        
    //是否删除 1：已删除；0：未删除
    private Integer isDelete;
        
    //层次
    private Integer level;
        
    //页面对应的地址
    private String linkUrl;
        
    //菜单编码
    private String menuCode;
        
    //名称
    private String name;
        
    //节点类型，1文件夹，2页面，3按钮
    private Integer nodeType;
        
    //父节点
    private Integer parentId;
        
    //树id的路径 整个层次上的路径id，逗号分隔，想要找父节点特别快
    private String path;
        
    //排序号
    private Integer sort;
        
    public String getIconUrl() {
        return iconUrl;
    }
    public void setIconUrl(String IconUrl) {
        this.iconUrl = IconUrl;
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
            
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer Level) {
        this.level = Level;
    }
            
    public String getLinkUrl() {
        return linkUrl;
    }
    public void setLinkUrl(String LinkUrl) {
        this.linkUrl = LinkUrl;
    }
            
    public String getMenuCode() {
        return menuCode;
    }
    public void setMenuCode(String MenuCode) {
        this.menuCode = MenuCode;
    }
            
    public String getName() {
        return name;
    }
    public void setName(String Name) {
        this.name = Name;
    }
            
    public Integer getNodeType() {
        return nodeType;
    }
    public void setNodeType(Integer NodeType) {
        this.nodeType = NodeType;
    }
            
    public Integer getParentId() {
        return parentId;
    }
    public void setParentId(Integer ParentId) {
        this.parentId = ParentId;
    }
            
    public String getPath() {
        return path;
    }
    public void setPath(String Path) {
        this.path = Path;
    }
            
    public Integer getSort() {
        return sort;
    }
    public void setSort(Integer Sort) {
        this.sort = Sort;
    }
             
    @Override
    public String toString() {
        return "TbMenu[iconUrl=" + iconUrl + ",id=" + id + ",isDelete=" + isDelete + ",level=" + level + ",linkUrl=" + linkUrl + ",menuCode=" + menuCode + ",name=" + name + ",nodeType=" + nodeType + ",parentId=" + parentId + ",path=" + path + ",sort=" + sort + "]";
    }
        
    
}
    