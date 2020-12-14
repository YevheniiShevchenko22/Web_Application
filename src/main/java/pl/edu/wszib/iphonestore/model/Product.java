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

    public Product() {
    }

    public Product(Integer id, String name, String codeEAN, Integer amount, String pic) {
        this.id = id;
        this.name = name;
        this.codeEAN = codeEAN;
        this.amount = amount;
        this.pic = pic;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Transient
    public String getPhotosImagePath() {
        if (pic == null || id == null) return null;

        return "/images/portfolio/" + id + "/" + pic;
    }
}