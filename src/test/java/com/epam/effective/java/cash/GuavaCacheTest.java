package com.epam.effective.java.cash;

import com.epam.effective.java.entity.Entity;
import com.google.common.cache.LoadingCache;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class GuavaCacheTest {
    LoadingCache<String, Entity> cache;

    @Before
    public void setUp() throws Exception {
        cache = GuavaCache.getCash(2, 3);
    }

    @Test
    public void guavaCacheTest() throws ExecutionException, InterruptedException {
        cache.get("one");
        cache.get("two");
        cache.get("one");
        cache.get("three");
        Thread.sleep(5_000);
        cache.get("three");
        Assert.assertTrue(cache.size() == 1);
        Assert.assertNotNull(cache.getIfPresent("three"));
        System.out.println(cache.stats().evictionCount());
        Assert.assertTrue(cache.stats().evictionCount() == 3);
        Assert.assertNotNull(cache.stats().averageLoadPenalty());
        System.out.println(cache.stats().averageLoadPenalty());
    }

}