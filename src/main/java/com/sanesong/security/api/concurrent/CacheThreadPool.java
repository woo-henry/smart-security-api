package com.sanesong.security.api.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public interface CacheThreadPool {
    
    public Future<?> executeTask(final FutureTask<?> task);

    public <T> Future<T> executeTask(final Callable<T> task);

    public void executeTask(final Runnable task);
}
