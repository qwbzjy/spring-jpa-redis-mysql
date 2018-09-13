package com.example.springjparedismysql.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author created by qwb on 2018/9/13 11:06
 */

@Data
@Entity
@Table(name = "t_user")
public class DemoInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String pwd;

}
