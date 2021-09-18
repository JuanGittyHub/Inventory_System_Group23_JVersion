
package za.ac.cput.Products;


public class Products {
    private String productName;
    private double productPrice;
    private int productQuantity;
    private long productBarcode;

    public Products(String productName, double productPrice, int productQuantity, long productBarcode) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productBarcode = productBarcode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public long getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(long productBarcode) {
        this.productBarcode = productBarcode;
    }

    @Override
    public String toString() {
        return "Products{" + "productName=" + productName + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", productBarcode=" + productBarcode + '}';
    }
    
    
    
}
