package pl.edu.wszib.iphonestore.model;


//import javax.persistence.Transient;
import javax.persistence.Entity;
import java.beans.Transient;
import java.io.InputStream;

/**
 * Created by Yevhenii Shevchenko at 12/10/20
 * Project name: iphonestore
 **/

public class Product {
    private Integer id;
    private String name;
    private String codeEAN;
    private Integer amount;
    private String pic;
    private double price;

    public Product() {
    }

    public Product(Integer id, String name, String codeEAN, Integer amount, String pic, double price) {
        this.id = id;
        this.name = name;
        this.codeEAN = codeEAN;
        this.amount = amount;
        this.pic = pic;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeEAN() {
        return codeEAN;
    }

    public void setCodeEAN(String codeEAN) {
        this.codeEAN = codeEAN;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Transient
    public String getPhotosImagePath() {
        if (pic == null || id == null) return null;

        return "/images/portfolio/" + id + "/" + pic;
    }

    public Product clone(){
        return new Product(this.id,this.name, this.codeEAN, this.amount, this.pic, this.price);
    }
}