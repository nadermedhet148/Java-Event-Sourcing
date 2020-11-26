package com.accountService.Rest;

import com.accountService.Rest.requests.ChangeBalanceRequest;
import com.accountService.events.EVENTS;
import com.accountService.events.EventPubliser;
import com.accountService.models.Account;
import com.accountService.repository.IAccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    @Autowired
    IAccountRepo accountRepo;

    @Autowired
    EventPubliser eventPubliser;


    @PostMapping(value = "")
    public String ChangeBalance(@RequestBody ChangeBalanceRequest body) throws IOException, TimeoutException {
        List<Account> accounts= this.accountRepo.findByUserId(body.getUserId());
        Account selectedAccount = accounts.get(0);
        if(selectedAccount!= null){
            selectedAccount.setBalance(body.getNewBalance());
            this.accountRepo.save(selectedAccount);
            eventPubliser.publish(EVENTS.EVENT_CREATED , selectedAccount.toJsonStringState());
            return  selectedAccount.toJsonStringState();
        }

        return "account dosn't existed";
    }

}
