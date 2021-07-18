package com.transactionReport.Infrastructure.ServicesProxy.User;

import com.transactionReport.Domain.Models.User.User;
import feign.Param;
import feign.RequestLine;

public interface IUserService {
    @RequestLine("GET /{id}")
    User getUser(@Param("id") String id);


}
