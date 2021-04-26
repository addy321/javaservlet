
package entity;

// 商品
public class Commodity {
    public Commodity() {

    }

    //
    private String almostNew;

    //
    private Double currentPrice;

    //
    private Integer id;

    //
    private Double price;

    //
    private String productName;

    public String getAlmostNew() {
        return almostNew;
    }

    public void setAlmostNew(String AlmostNew) {
        this.almostNew = AlmostNew;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double CurrentPrice) {
        this.currentPrice = CurrentPrice;
    }

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

    @Override
    public String toString() {
        return "Commodity[almostNew=" + almostNew + ",currentPrice=" + currentPrice + ",id=" + id + ",price=" + price + ",productName=" + productName + "]";
    }


}
    