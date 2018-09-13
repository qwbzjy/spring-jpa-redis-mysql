# spring-jpa-redis-mysql
redis缓存操作

做这个项目，踩了一个雷，就是springboot的版本问题，网上的基本上都是spring 1.x版本，但是我用的springboot 2.x，在构建cacheManager时，报错，正确构造redis缓存管理器的方法：

```
@Bean
public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        CacheManager cacheManager =  RedisCacheManager.create(redisConnectionFactory);
        return cacheManager;
    }
```

在今后的学习中，一定要注意架构的版本变化，技术更新真的很快，此外还要不断的学习新技术。