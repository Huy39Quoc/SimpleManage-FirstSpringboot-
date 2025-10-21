package sum25.SE190573.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sum25.SE190573.entities.SonyAccounts;
import sum25.SE190573.repositories.AuthenticationRepository;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @GetMapping({"/", "/Login"})
    public String loginPage() {
        return "Login";
    }

    @PostMapping("/Login")
    public String postLogin(@RequestParam String phone,
                            @RequestParam String password,
                            HttpSession session,
                            RedirectAttributes redirectAttributes) {

        SonyAccounts account = authenticationRepository.findByPhoneAndPassword(phone, password);

        if (account != null && (account.getRoleID() == 1 || account.getRoleID() == 2)) {
            session.setAttribute("user", account);
            return "redirect:/Home";
        }
        redirectAttributes.addFlashAttribute("error", "You do not have permission to access this function!");
        return "redirect:/Login";
    }

    @GetMapping("/Logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/Login";
    }
}
