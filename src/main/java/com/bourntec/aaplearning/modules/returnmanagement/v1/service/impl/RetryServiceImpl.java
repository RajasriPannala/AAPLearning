package com.bourntec.aaplearning.modules.returnmanagement.v1.service.impl;

import java.time.LocalDateTime;

import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.retry.annotation.Backoff;

import lombok.extern.slf4j.Slf4j;
@EnableRetry
@Slf4j
@Service
public class RetryServiceImpl {
	
	
		@Scheduled(fixedDelay = 1000 * 60 * 60)
		@Retryable(value = {Exception.class},maxAttempts =5,backoff = @Backoff(delay = 1000,multiplier = 2))
//		@Retryable(value = {
//				ArithmeticException.class }, maxAttemptsExpression = "${retry.maxAttempts}",backoff = @Backoff(delayExpression = "${retry.backOffDelay}", multiplier=3 ))
				public void retry() {
				log.info("entering into retry()", LocalDateTime.now());
				
				int a = 10 / 0;
				}
		

				@Recover
				void recover(Exception e) {
				log.info("entering into retry()" + e.getMessage());

				}
}
