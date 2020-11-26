package com.accountService.events.consumers;

import com.accountService.events.EVENTS;
import com.accountService.events.EventPubliser;
import com.accountService.models.Account;
import com.accountService.repository.IAccountRepo;
import com.rabbitmq.client.DeliverCallback;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class CreatedUser extends EventConsumer {

    @Autowired
    IAccountRepo accountRepo;

    @Autowired
    EventPubliser eventPubliser;


    @Override
    public void eventConsume() throws IOException, TimeoutException {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String messageBody = new String(delivery.getBody(), "UTF-8");
            Account account = this.createAccount(messageBody);
            try {
                eventPubliser.publish(EVENTS.EVENT_CREATED , account.toJsonStringState());
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println(" [x] Received '" + messageBody + "'");
        };

        this.consume(EVENTS.CREATED_USER,deliverCallback);
    }

    private Account createAccount(String messageBody){
        JSONObject json = new JSONObject(messageBody);
        Account account = new Account();
        account.setUserId(json.getInt("user_id"));
        account.setBalance(Float.valueOf(0));
        this.accountRepo.save(account);
        return account;
    }
}
