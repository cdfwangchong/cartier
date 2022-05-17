package com.ctg.cartier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

@SpringBootTest
class CartierApplicationTests {
//    @Autowired
//    private CacheDemoService cacheDemoService;
//
//    @Autowired
//    private CacheManager cacheManager;
//
//    @Test
//    void contextLoads() {
//        System.out.println("------------------------先存储几个的缓存数据:1：值*1，2：值*2，3：值*3 ");
//        System.out.println("key=1的设置缓存的返回值"+ cacheDemoService.getFromDB(1));
//        System.out.println("key=2的设置缓存的返回值"+ cacheDemoService.getFromDB(2));
//        System.out.println("key=3的设置缓存的返回值"+ cacheDemoService.getFromDB(3));
//
//        cacheDemoService.getFromDB(2);
//        cacheDemoService.getFromDB(3);
//
//        // 获取数据~~~~
//        System.out.println("------------------------获取数据，入参是：1");
//        System.out.println(cacheDemoService.getFromDB(1));
//        System.out.println("------------------------获取数据，入参是：2");
//        System.out.println(cacheDemoService.getFromDB(2));
//        System.out.println("------------------------获取数据，入参是：3");
//        System.out.println(cacheDemoService.getFromDB(3));
//        System.out.println("------------------------获取数据，入参是：4，第一次缓存");
//        System.out.println(cacheDemoService.getFromDB(4));
//        System.out.println("------------------------获取数据，入参是：5，第一次缓存");
//        System.out.println(cacheDemoService.getFromDB(5));
//
//        System.out.println("------------------------校验缓存中的数据内容");
//        // 校验缓存里的内容~~~~
//        System.out.println("---------拿取缓存器，名称 = demoCache");
//        Cache demoCache1 = cacheManager.getCache("demoCache");
//
//        System.out.println(demoCache1.get(1, String.class));
//        System.out.println(demoCache1.get(2, String.class));
//        System.out.println(demoCache1.get(3, String.class));
//        System.out.println(demoCache1.get(4, String.class));
//        System.out.println(demoCache1.get(5, String.class));
//        System.out.println(demoCache1.get(6, String.class));
//        System.out.println(demoCache1.get(7, String.class));
//    }
}
