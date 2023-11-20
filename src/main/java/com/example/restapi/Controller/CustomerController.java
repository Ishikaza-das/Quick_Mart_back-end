package com.example.restapi.Controller;


import com.example.restapi.Model.Customer;
import com.example.restapi.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/api/customers")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/api/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomer();
    }
//    Get Id
    @GetMapping("/api/customers/id/{id}")
    public ResponseEntity<Customer> getCustomersById(@PathVariable("id") long customerId){
        return new ResponseEntity<>(customerService.getCustomersById(customerId), HttpStatus.FOUND);
    }

    @PutMapping("/api/customers/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id")long id,@RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.updateCustomer(customer,id),HttpStatus.OK);
    }

    @DeleteMapping("/api/customers/delete/{id}")
    public ResponseEntity<String > deleteCustomer(@PathVariable("id")long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<String>("Customer deleted successfully",HttpStatus.FORBIDDEN);
    }
}
