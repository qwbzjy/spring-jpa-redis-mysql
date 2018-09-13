package com.example.springjparedismysql.repository;

import com.example.springjparedismysql.bean.DemoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author created by qwb on 2018/9/13 11:08
 */
public interface DemoInfoRepository extends JpaRepository<DemoInfo,Long> {
}
