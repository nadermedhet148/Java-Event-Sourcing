package com.transactionReport.Infrastructure.RepositoryImpl;

import com.transactionReport.Domain.Models.User.IUserRepository;
import com.transactionReport.Domain.Models.User.User;
import com.transactionReport.Infrastructure.ServicesProxy.User.IUserService;
import com.transactionReport.Infrastructure.ServicesProxy.User.UserServiceProxy;


public class UserRepository implements IUserRepository {

    private IUserService proxy = new UserServiceProxy().getProxy();

    @Override
    public User getUser(String id){

        User user = proxy.getUser(id);
        return user;
    }
}
