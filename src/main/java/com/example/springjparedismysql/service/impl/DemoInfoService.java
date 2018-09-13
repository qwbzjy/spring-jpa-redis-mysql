package com.example.springjparedismysql.service.impl;

import com.example.springjparedismysql.bean.DemoInfo;

/**
 * @author created by qwb on 2018/9/13 11:11
 */
public interface DemoInfoService {
    public DemoInfo findById(long id);

    public void deleteFromCache(long id);

    void test();

    void save(DemoInfo demoInfo);
}
