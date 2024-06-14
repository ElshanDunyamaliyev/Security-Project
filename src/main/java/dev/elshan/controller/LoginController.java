package dev.elshan.controller;

import dev.elshan.model.Customer;
import dev.elshan.repository.CustomerRepository;
import dev.elshan.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {

    private final CustomerService customerService;
    private final PasswordEncoder passwordEncoder;

    public LoginController(CustomerService customerService, PasswordEncoder passwordEncoder) {
        this.customerService = customerService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody Customer customer) {
        String password = passwordEncoder.encode(customer.getPwd());
        customer.setPwd(password);
        customerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
