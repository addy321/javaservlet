
package entity;

// 订单
public class Userorder {
    public Userorder() {

    }

    //
    private Integer id;

    //
    private Double price;

    //
    private String productName;

    //
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double Price) {
        this.price = Price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String ProductName) {
        this.productName = ProductName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String UserName) {
        this.userName = UserName;
    }

    @Override
    public String toString() {
        return "Userorder[id=" + id + ",price=" + price + ",productName=" + productName + ",userName=" + userName + "]";
    }


}
    