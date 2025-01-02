package com.sanesong.security.api.log;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class LogbackPatternConverter extends ClassicConverter {
	
	public static final String TRACE_ID = "tid";
	
	public String convert(final ILoggingEvent iLoggingEvent) {
		final String tid = MDC.get(TRACE_ID);
		if(StringUtils.isEmpty(tid)) {
			return "tid: " + Thread.currentThread().getId();
		}
		
		return "tid: " + tid;
	}
}
