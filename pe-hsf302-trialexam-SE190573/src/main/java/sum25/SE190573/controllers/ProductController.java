package sum25.SE190573.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sum25.SE190573.entities.SonyAccounts;
import sum25.SE190573.entities.SonyCategories;
import sum25.SE190573.entities.SonyProducts;
import sum25.SE190573.repositories.CategoriesRepository;
import sum25.SE190573.services.ProductInterfaces;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {

    @Autowired
    private ProductInterfaces productService;

    @Autowired
    private CategoriesRepository categoriesRepository;

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam long id, HttpSession session, Model model) {
        SonyAccounts user = (SonyAccounts) session.getAttribute("user");
        if (user == null || user.getRoleID() != 1) {
            model.addAttribute("error", "You do not have permission to access this function!");
            return "redirect:/Login";
        }

        boolean deleted = productService.deleteProduct(id);
        if (!deleted) {
            model.addAttribute("error", "Delete failed. Product not found.");
        }

        return "redirect:/Home";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, HttpSession session, Model model) {
        SonyAccounts user = (SonyAccounts) session.getAttribute("user");
        if (user == null || user.getRoleID() != 1) {
            return "redirect:/Login";
        }

        SonyProducts product = productService.findById(id);
        if (product == null) {
            return "redirect:/Home";
        }

        if (product.getCategory() == null) {
            product.setCategory(new SonyCategories());
        }

        model.addAttribute("product", product);
        model.addAttribute("categories", categoriesRepository.findAll());
        return "EditProduct";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute SonyProducts product, HttpSession session, Model model) {
        SonyAccounts user = (SonyAccounts) session.getAttribute("user");
        if (user == null || user.getRoleID() != 1) {
            model.addAttribute("error", "You do not have permission to access this function!");
            return "redirect:/Login";
        }

        boolean updated = productService.updateProduct(product);
        if (!updated) {
            model.addAttribute("error", "Update failed. Please check product details (name may be duplicate or invalid).");
            model.addAttribute("product", product);
            model.addAttribute("categories", categoriesRepository.findAll());
            return "EditProduct";
        }
        return "redirect:/Home";
    }

    @GetMapping("/add")
    public String addForm(HttpSession session, Model model) {
        SonyAccounts user = (SonyAccounts) session.getAttribute("user");
        if (user == null || user.getRoleID() != 1) {
            return "redirect:/Login";
        }

        SonyProducts product = new SonyProducts();
        product.setCategory(new SonyCategories());

        model.addAttribute("product", product);
        model.addAttribute("categories", categoriesRepository.findAll());
        return "AddProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute SonyProducts product, HttpSession session, Model model) {
        SonyAccounts user = (SonyAccounts) session.getAttribute("user");
        if (user == null || user.getRoleID() != 1) {
            return "redirect:/Login";
        }

        boolean created = productService.createProduct(product);
        if (!created) {
            model.addAttribute("error", "Product name already exists or validation failed.");
            model.addAttribute("categories", categoriesRepository.findAll());
            return "AddProduct";
        }

        return "redirect:/Home";
    }

}
