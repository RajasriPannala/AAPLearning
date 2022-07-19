package com.bourntec.aaplearning.modules.commonmanagement.v1.initializer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;



/**
 * @author Allan George
 *
 */
@Configuration
public class TwilioInitializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);

    @Autowired
    public TwilioInitializer() {
      
        Twilio.init("AC0a614ad143994e9b80ac4377c062f2fd",
        		"66415869e3665284eb7d827d0a3f04ee"
        );
        LOGGER.info("Twilio initialized ... with account sid {} ");
    }
}