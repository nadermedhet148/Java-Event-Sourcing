package com.user.Adapters.Rest;

import com.user.Adapters.Events.EventPubliser;
import com.user.Rest.requests.CreateCustomerRequest;
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

//    @Autowired
//    ICustomerRepo customerRepo;
//
//    @Autowired
//    EventPubliser eventPubliser;
//
//
//    @PostMapping(value = "")
//    public String createCustomer(@RequestBody CreateCustomerRequest body) throws IOException, TimeoutException {
//        com.user.models.Events customer = new com.user.models.Events();
//        customer.setName(body.getName());
//        this.customerRepo.save(customer);
//        eventPubliser.publish(EVENTS.CREATED_USER , customer.toJson());
//        return customer.toJson();
//    }

}
