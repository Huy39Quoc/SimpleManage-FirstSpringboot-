package sum25.SE190573.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sum25.SE190573.entities.SonyAccounts;
import sum25.SE190573.entities.SonyProducts;
import sum25.SE190573.repositories.ProductRepository;
import sum25.SE190573.services.ProductInterfaces;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductRepository prepository;

    @Autowired
    private ProductInterfaces productService;

    @GetMapping("/Home")
    public String home(HttpSession session, Model model) {
        SonyAccounts account = (SonyAccounts) session.getAttribute("user");

        if (account == null) {
            return "redirect:/Login";
        }

        model.addAttribute("user", account);
        List<SonyProducts> producTop3 = productService.getTop3EachCategory();
        model.addAttribute("top3", producTop3);

        List<SonyProducts> productList = prepository.findAll();
        model.addAttribute("products", productList);

        return "Home";
    }
}
