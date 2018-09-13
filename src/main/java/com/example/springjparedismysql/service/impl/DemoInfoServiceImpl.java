package com.example.springjparedismysql.service.impl;

import com.example.springjparedismysql.bean.DemoInfo;
import com.example.springjparedismysql.repository.DemoInfoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.PartialUpdate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author created by qwb on 2018/9/13 11:09
 */
@Service
public class DemoInfoServiceImpl implements DemoInfoService {

    @Resource
    private DemoInfoRepository demoInfoRepository;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public void test(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();

        valueOperations.set("mykey4", "random1="+Math.random());
        System.out.println(valueOperations.get("mykey4"));
    }
    /**
     *  @Caching注解可以让我们在一个方法或者类上同时指定多个Spring Cache相关的注解。其拥有三个属性：cacheable、put和evict，分别用于指定@Cacheable、@CachePut和@CacheEvict。
     * */
    //keyGenerator="myKeyGenerator"
    @Cacheable(value="demoInfo",key = "#id") //缓存,这里没有指定key.
    @Override
    public DemoInfo findById(long id) {
        System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id="+id);
        return demoInfoRepository.findById(id).get();
    }
    /**
     *  @CacheEvict是用来标注在需要清除缓存元素的方法或类上的。当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作。@CacheEvict可以指定的属性有value、key、condition、allEntries和beforeInvocation。其中value、key和condition的语义与@Cacheable对应的属性类似。即value表示清除操作是发生在哪些Cache上的（对应Cache的名称）；key表示需要清除的是哪个key，如未指定则会使用默认策略生成的key；condition表示清除操作发生的条件。下面我们来介绍一下新出现的两个属性allEntries和beforeInvocation。
     * */
    @CacheEvict(value="demoInfo")
    @Override
    public void deleteFromCache(long id) {
        System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
    }
    /**
     * 在支持Spring Cache的环境下，对于使用@Cacheable标注的方法，Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，如果存在就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中。@CachePut也可以声明一个方法支持缓存功能。与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
     * */
//    @Cacheable(value = "dinfo",key = "#demoInfo.name")
    @Override
    @CachePut(value = "info",key = "#demoInfo.pwd")
    public void save(DemoInfo demoInfo){
        demoInfoRepository.save(demoInfo);
    }
}
