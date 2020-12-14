package pl.edu.wszib.iphonestore.database.impl;

import org.springframework.stereotype.Component;
import pl.edu.wszib.iphonestore.database.IStoreRepository;
import pl.edu.wszib.iphonestore.model.Product;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhenii Shevchenko at 12/10/20
 * Project name: iphonestore
 **/
@Component
public class StoreRepositoryImpl implements IStoreRepository {
    private final List<Product> products = new ArrayList<>();
    //IOUtils.toByteArray(in)

    public StoreRepositoryImpl() throws IOException {
        this.products.add(new Product(1,
                "IPhone X",
                "12345678",
                30,
                "architecture.jpg"));
        this.products.add(new Product(2,
                "IPhone 11",
                "12345567",
                20,
                "minimalismo.jpg"));
        this.products.add(new Product(3,
                "IPhone 11 Pro Max",
                "12345677",
                25,
                "salad.jpg"));
        this.products.add(new Product(4,
                "IPhone SE",
                "12334567",
                50,
                "shutterbug.jpg"));
        this.products.add(new Product(5,
                "IPhone 12 Pro",
                "12234567",
                32,
                "skaterboy.jpg"));
        this.products.add(new Product(6,
                "IPhone XR",
                "11334567",
                46,
                "yellowwall.jpg"));
    }



    @Override
    public List<Product> getAllProduct() {
        return this.products;
    }
}
