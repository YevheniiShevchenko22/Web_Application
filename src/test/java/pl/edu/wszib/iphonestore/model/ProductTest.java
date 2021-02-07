package pl.edu.wszib.iphonestore.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yevhenii Shevchenko at 2/7/21
 * Project name: iphonestore
 **/
class ProductTest {

    @Test
    void testClone() {
        Product product = new Product();

        product.setId(1);
        product.setName("IPhone 11");
        product.setPrice(1299.99);
        product.setAmount(34);
        product.setPic("iphone_11.jpg");
        product.setCodeEAN("123456789");

        Product clone = product.clone();

        Assert.assertEquals(product.getId(), clone.getId());
        Assert.assertEquals(product.getName(), clone.getName());
        Assert.assertEquals(product.getPrice(), clone.getPrice(), 0.01);
        Assert.assertEquals(product.getAmount(), clone.getAmount());
        Assert.assertEquals(product.getPic(), clone.getPic());
        Assert.assertEquals(product.getCodeEAN(), clone.getCodeEAN());

        Assert.assertNotSame(product, clone);
    }
}