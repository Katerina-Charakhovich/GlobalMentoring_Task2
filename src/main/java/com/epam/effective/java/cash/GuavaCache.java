package com.epam.effective.java.cash;


import com.epam.effective.java.entity.Entity;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

//
//Max Size = 100 000;
//      1/  Eviction policy;
//      2/ Time-based on last access (5 seconds);
//      3/  Removal listener;+++
//      4/  Just add to log of removed entry;+++
//      5/ Give statistic to user;
//      6/  Average time spent for putting new values into the cache;
//      7/  Number of cache evictions;
//      8/  Support concurrency.
public class GuavaCache {
    private static LoadingCache<String, Entity> cache;
    private static final Logger logger = Logger.getLogger(GuavaCache.class.getName());
    private static final Integer DEFAULT_SIZE_CASH = 100;
    private static final Integer EXPIRE_AFTER_ACCESS = 10;

    public static LoadingCache<String, Entity> getCash(int size, int expireAfterAccess) {
        if (cache == null) {
            cache = loadCash(size,expireAfterAccess);
        }
        return cache;
    }

    public static LoadingCache<String, Entity> getCash() {
        if (cache == null) {
            cache = loadCash(DEFAULT_SIZE_CASH,EXPIRE_AFTER_ACCESS);
        }
        return cache;
    }

    public static Entity get(String key) throws ExecutionException {
        return cache.get(key);
    }


    private static LoadingCache<String, Entity> loadCash(int size, int expireAfterAccess) {
        CacheLoader<String, Entity> cacheLoader = new CacheLoader<>() {
            @Override
            public Entity load(String key) {
                return new Entity(key);
            }
        };

        RemovalListener<String, Entity> listener = removalNotification -> {
            if (removalNotification.wasEvicted()) {
                Entity removedElement = removalNotification.getValue();
                logger.info("Removed element: " + removedElement+"Cause: "+removalNotification.getCause());
            }
        };

        return CacheBuilder.newBuilder()
                .maximumSize(size)
                .expireAfterAccess(expireAfterAccess, TimeUnit.SECONDS)
                .removalListener(listener)
                .recordStats()
                .build(cacheLoader);
    }

}
