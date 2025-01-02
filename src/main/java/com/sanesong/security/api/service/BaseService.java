package com.sanesong.security.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class BaseService implements Component {
    
    protected final Logger log;
    
    public BaseService() {
        log = LoggerFactory.getLogger(getClass());
    }
}
