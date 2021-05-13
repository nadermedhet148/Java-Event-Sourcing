package com.payment.Adapters.Rest;

import com.payment.Adapters.Messages.EventPubliser;
import com.payment.Adapters.Rest.requests.CreatePaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping(value = "/users")

public class TransactionsController {



    @Autowired
    EventPubliser eventPubliser;


    @PostMapping(value = "")
    public String createUser(@RequestBody CreatePaymentRequest body) {
        return  null;
    }

}
