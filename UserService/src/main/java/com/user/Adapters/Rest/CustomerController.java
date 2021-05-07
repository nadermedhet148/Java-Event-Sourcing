package com.user.Adapters.Rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
