package com.customer.Rest;

import com.customer.Rest.requests.CreateCustomerRequest;
import com.customer.events.EVENTS;
import com.customer.events.EventPubliser;
import com.customer.models.Customer;
import com.customer.repository.ICustomerRepo;
import lombok.AllArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
//import javax.inject.Inject;

@RestController
@RequestMapping(value = "/customers")
//@AllArgsConstructor(onConstructor = @__(
//        @Inject))
public class CustomerController {

    @Autowired
    ICustomerRepo customerRepo;

    @Autowired
    EventPubliser eventPubliser;


    @PostMapping(value = "")
    public String createCustomer(@RequestBody CreateCustomerRequest body) throws IOException, TimeoutException {
        Customer customer = new Customer();
        customer.setName(body.getName());
        this.customerRepo.save(customer);
        eventPubliser.publish(EVENTS.CREATED_USER , customer.toJson());
        return customer.toJson();
    }

}
