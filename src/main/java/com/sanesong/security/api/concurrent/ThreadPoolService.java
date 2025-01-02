package com.sanesong.security.api.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class ThreadPoolService implements CacheThreadPool {
	
	public static final int DEFAULT_THREAD_COUNT 	= 4;
	public static final int THREAD_POOL_CACHE 		= 0x0001;
	public static final int THREAD_POOL_SINGLE 		= 0x0002;
	public static final int THREAD_POOL_FIXED 		= 0x0004;
	public static final int THREAD_POOL_SCHEDULE 	= 0x0008;
	
	private volatile int corePoolSize;
	private volatile int maximumPoolSize;
	private volatile long keepAliveTime;
	private volatile TimeUnit keepAliveTimeUnit;
	private ExecutorService cahceThreadPool;
	
	public ThreadPoolService() {
		this(0, 0, 60L, TimeUnit.SECONDS);
	}
	
	public ThreadPoolService(int corePoolSize, int maximumPoolSize) {
		this(corePoolSize, maximumPoolSize, 60L, TimeUnit.SECONDS);
	}
	
	public ThreadPoolService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit keepAliveTimeUnit) {
		final int availableProcessors = Runtime.getRuntime().availableProcessors() * 8 + 1;
		final int defaultMaximumPoolSize = availableProcessors <= DEFAULT_THREAD_COUNT ? DEFAULT_THREAD_COUNT : availableProcessors;
		this.corePoolSize = corePoolSize;
		this.maximumPoolSize = maximumPoolSize == 0 ? defaultMaximumPoolSize : maximumPoolSize;
		this.keepAliveTime = keepAliveTime;
		this.keepAliveTimeUnit = keepAliveTimeUnit;
	}

	@PostConstruct
	public void initialize() {
		cahceThreadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, keepAliveTimeUnit, new SynchronousQueue<Runnable>());
	}

	@PreDestroy
	public void dispose() {
		if(cahceThreadPool.isTerminated())
			return;
		
		cahceThreadPool.shutdown();
		try {
			cahceThreadPool.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			
		}
	}
	
	@Override
	public Future<?> executeTask(FutureTask<?> task) {
		return cahceThreadPool.submit(task);
	}

	@Override
	public <T> Future<T> executeTask(Callable<T> task) {
		return cahceThreadPool.submit(task);
	}

	@Override
	public void executeTask(Runnable task) {
		cahceThreadPool.execute(task);
	}
}
