
package za.ac.cput.Products;


public class Products {
    private String productName;
    private double productPrice;
    private int productQuantity;
    private String productBarcode;

    public Products()
    {
        this.productName = "";
        this.productPrice = 0.0d;
        this.productQuantity = 0;
        this.productBarcode = "";
    }
    
    public Products(String productName, double productPrice, int productQuantity, String productBarcode) {
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

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    @Override
    public String toString() {
        return "Products{" + "productName=" + productName + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", productBarcode=" + productBarcode + '}';
    }
    
    
    
}
