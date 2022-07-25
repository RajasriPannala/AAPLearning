package com.bourntec.aaplearning.modules.commonmanagement.v1.initializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.plivo.api.Plivo;

@Configuration
public class PlivoInitializer {
	
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PlivoInitializer.class);
	
	
	public PlivoInitializer() {
		
        Plivo.init("MAYZDKYZUXMMIXYJEXOD", "YTM1MDUzMjViOWI3MzAwMTA0MmJhNTM1MTE2ZThj");
        
        LOGGER.info("Plivo initialized");
}

	
}
