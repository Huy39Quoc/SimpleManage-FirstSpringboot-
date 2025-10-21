package sum25.SE190573.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.SE190573.entities.SonyAccounts;
import sum25.SE190573.repositories.AuthenticationRepository;
import sum25.SE190573.services.AuthenticationInterfaces;

@Service
public class AuthenticationImpl implements AuthenticationInterfaces {

    private final AuthenticationRepository authenticationRepository;

    @Autowired
    public AuthenticationImpl(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public boolean loginValid(String phone, String password) {
        return authenticationRepository.findByPhoneAndPassword(phone, password) != null;
    }

    @Override
    public SonyAccounts login(String phone, String password) {
        return authenticationRepository.findByPhoneAndPassword(phone, password);
    }
}
