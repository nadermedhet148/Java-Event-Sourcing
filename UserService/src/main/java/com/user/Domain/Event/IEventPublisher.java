package com.user.Domain.Event;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public interface IEventPublisher {

    public void publish(Event ev) throws IOException, TimeoutException;
}
