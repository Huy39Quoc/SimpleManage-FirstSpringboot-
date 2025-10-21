package sum25.SE190573.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.SE190573.entities.SonyProducts;
import sum25.SE190573.repositories.ProductRepository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductImpl implements ProductInterfaces {

    private final ProductRepository productRepository;

    @Autowired
    public ProductImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<SonyProducts> productList() {
        return productRepository.findAll();
    }

    public boolean createProduct(SonyProducts product) {
        if (!validateProduct(product)) return false;

        List<SonyProducts> products = productRepository.findAll();
        boolean exists = products.stream()
                .anyMatch(p -> p.getProductName().equalsIgnoreCase(product.getProductName()));
        if (exists) {
            return false;
        }

        product.setCreatedAt(LocalDateTime.now());
        productRepository.save(product);
        return true;
    }

    public boolean updateProduct(SonyProducts product) {
        if (!validateProduct(product)){
            return false;
        }

       // List<SonyProducts> products = productRepository.findAll();

        SonyProducts existingProduct = productRepository.findById(product.getProductID()).orElse(null);
        if (existingProduct == null) return false;

        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setCreatedAt(LocalDateTime.now());
        productRepository.save(existingProduct);
        return true;
    }

    @Override
    public boolean deleteProduct(long productId) {
        List<SonyProducts> products = productRepository.findAll();
        boolean exists = products.stream().anyMatch(p -> p.getProductID() == productId);
        if (!exists) {
            return false;
        }
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public List<SonyProducts> getTop3EachCategory() {
        List<SonyProducts> allProducts = productRepository.findAll();

        return allProducts.stream()
                .collect(Collectors.groupingBy(p -> p.getCategory().getCateID()))
                .values().stream()
                .flatMap(group -> group.stream()
                        .sorted(Comparator.comparingInt(SonyProducts::getStock).reversed())
                        .limit(3))
                .collect(Collectors.toList());
    }

    @Override
    public SonyProducts findById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    private boolean validateProduct(SonyProducts product) {
        if (product.getProductName() == null || product.getProductName().isBlank()) return false;
        int length = product.getProductName().length();
        if (length < 5 || length > 50) return false;
        if (product.getPrice() < 100) return false;
        if (product.getStock() < 0 || product.getStock() > 1000) return false;
        return true;
    }
}
