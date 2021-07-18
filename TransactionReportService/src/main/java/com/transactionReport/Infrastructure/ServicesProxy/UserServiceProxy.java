package com.transactionReport.Infrastructure.ServicesProxy;

import feign.Feign;
import feign.gson.GsonDecoder;

public class UserServiceProxy {

    private IUserService userService = Feign.builder()
            .decoder(new GsonDecoder())
            .target(IUserService.class, "http://localhost:8000/users");

    public IUserService getProxy(){
        return userService;
    }
}
