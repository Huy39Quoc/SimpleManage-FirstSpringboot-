//package sum25.SE190573.Config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import sum25.SE190573.entities.SonyAccounts;
//import sum25.SE190573.entities.SonyCategories;
//import sum25.SE190573.entities.SonyProducts;
//import sum25.SE190573.repositories.AuthenticationRepository;
//import sum25.SE190573.repositories.CategoriesRepository;
//import sum25.SE190573.repositories.ProductRepository;
//
//import java.time.LocalDateTime;
//
//@Component
//public class InitialData implements CommandLineRunner {
//    private AuthenticationRepository authenticationRepository;
//    private CategoriesRepository categoriesRepository;
//    private ProductRepository productRepository;
//
//    public InitialData(AuthenticationRepository authenticationRepository, CategoriesRepository categoriesRepository, ProductRepository productRepository) {
//        this.authenticationRepository = authenticationRepository;
//        this.categoriesRepository = categoriesRepository;
//        this.productRepository = productRepository;
//    }
//
//    public void run(String... args) throws Exception {
//        authenticationRepository.save(new SonyAccounts("0905111111", "@1", 1));
//        authenticationRepository.save(new SonyAccounts("0905222222", "@1", 2));
//        authenticationRepository.save(new SonyAccounts("0905333333", "@1", 3));
//
//        SonyCategories headphone = categoriesRepository.save(new SonyCategories("HeadPhone", "active"));
//        SonyCategories camera = categoriesRepository.save(new SonyCategories("Cameras", "active"));
//        SonyCategories tv = categoriesRepository.save(new SonyCategories("TVs", "active"));
//
//        productRepository.save((new SonyProducts("Alpha 1 II-Full-frame Mirrorless", 6000, 3, LocalDateTime.of(2025, 3, 3, 0, 0), camera)));
//        productRepository.save((new SonyProducts("Alpha 7C II-Full-frame", 2000, 5, LocalDateTime.of(2025, 4, 4, 0, 0), camera)));
//        productRepository.save((new SonyProducts("BRAVIA 8 OLED 4K HDR TV", 2500, 10, LocalDateTime.of(2025, 1, 1, 0, 0), tv)));
//        productRepository.save((new SonyProducts("LinkBuds Fit Truly Wireless Noise Canceling", 180, 15, LocalDateTime.of(2025, 3, 3, 0, 0), headphone)));
//    }
//}
