package sum25.SE190573.services;

import sum25.SE190573.entities.SonyProducts;

import java.util.List;

public interface ProductInterfaces {
    List<SonyProducts> productList();
    boolean deleteProduct(long productId);
    List<SonyProducts> getTop3EachCategory();
    boolean updateProduct(SonyProducts product);
    SonyProducts findById(long id);
    boolean createProduct(SonyProducts product);
}
