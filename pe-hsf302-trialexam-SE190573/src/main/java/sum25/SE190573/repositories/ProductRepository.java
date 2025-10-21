package sum25.SE190573.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sum25.SE190573.entities.SonyProducts;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<SonyProducts, Long> {
    SonyProducts findByProductName(String productName);
//    List<SonyProducts> findTop3ByOrderByStockDesc();
}