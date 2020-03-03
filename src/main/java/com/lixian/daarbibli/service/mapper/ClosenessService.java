package com.lixian.daarbibli.service.mapper;

import com.lixian.daarbibli.web.rest.AccountResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClosenessService {

    String pathClosness = "src/main/resources/booksResources/closeness.txt";

    private final Logger log = LoggerFactory.getLogger(AccountResource.class);

    public ClosenessService() {}


}
