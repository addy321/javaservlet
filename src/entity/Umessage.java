
package entity;

// 评价
public class Umessage {
    public Umessage() {

    }

    //
    private Integer id;

    //
    private String productName;

    //
    private String text;

    //
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String ProductName) {
        this.productName = ProductName;
    }

    public String getText() {
        return text;
    }

    public void setText(String Text) {
        this.text = Text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String UserName) {
        this.userName = UserName;
    }

    @Override
    public String toString() {
        return "Umessage[id=" + id + ",productName=" + productName + ",text=" + text + ",userName=" + userName + "]";
    }


}
    