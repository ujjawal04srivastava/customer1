package com.vpinfotechsoftware.customer.controller;

import com.sun.xml.internal.messaging.saaj.soap.name.NameImpl;
import com.vpinfotechsoftware.customer.model.Customer;
import com.vpinfotechsoftware.customer.service.impl.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.UUID;

@RestController
@RequestMapping("/api/vpinfotech/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<Customer> getCustomerDetail(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> customerRegistration(@RequestBody Customer customer){
        HttpHeaders header = new HttpHeaders();
        Customer customerRecord= customerService.addNewCustomer(customer);
        header.add("Location","/api/vpinfotech/customer/"+customerRecord.getId().toString());
        return new ResponseEntity<>(header, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomerDetail(@PathVariable("customerId") UUID customerId, Customer customer){
        HttpHeaders header= new HttpHeaders();
        customerService.editCustomersDetail(customer);
        header.add("Location","/api/vpinfotech/customer/"+customerId.toString());
        return new ResponseEntity<>(header, HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{customerId}")
    public void removeCustomerRecord(@PathVariable("customerId") UUID customerId){
      customerService.removeCustomer(customerId);

    }
}
