package com.bit.sts06.util;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAop {

	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		return joinPoint.proceed();
	}
}
