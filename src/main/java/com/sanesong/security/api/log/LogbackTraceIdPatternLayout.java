package com.sanesong.security.api.log;

import ch.qos.logback.classic.PatternLayout;

public class LogbackTraceIdPatternLayout extends PatternLayout {
	
    static {
        defaultConverterMap.put(LogbackPatternConverter.TRACE_ID, LogbackPatternConverter.class.getName());
    }
}
