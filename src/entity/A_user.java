
package entity;

// 用户
public class A_user {
    public A_user() {

    }

    //时间
    private java.util.Date createTime;

    //主键
    private Integer id;

    //
    private String name;

    //大苏打
    private String phone;

    //秘密
    private String pwd;

    //大撒
    private Integer type;

    public java.util.Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.util.Date CreateTime) {
        this.createTime = CreateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String Phone) {
        this.phone = Phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String Pwd) {
        this.pwd = Pwd;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer Type) {
        this.type = Type;
    }

    @Override
    public String toString() {
        return "A_user[createTime=" + createTime + ",id=" + id + ",name=" + name + ",phone=" + phone + ",pwd=" + pwd + ",type=" + type + "]";
    }


}
    