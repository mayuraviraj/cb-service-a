package com.mayura.cb.cb_service_a.client;

import feign.Param;
import feign.RequestLine;

public interface ServiceBClient {

    @RequestLine("GET /{id}")
    String getData(@Param("id") String id);

}
