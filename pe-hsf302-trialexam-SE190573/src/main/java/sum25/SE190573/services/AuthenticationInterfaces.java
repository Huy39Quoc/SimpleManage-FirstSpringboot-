package sum25.SE190573.services;

import org.springframework.stereotype.Service;
import sum25.SE190573.entities.SonyAccounts;

public interface AuthenticationInterfaces {
    boolean loginValid(String phone, String password);

    SonyAccounts login(String phone, String password);
}
