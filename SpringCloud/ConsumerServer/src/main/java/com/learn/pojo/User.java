package com.learn.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="user")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String name;

    private String sex;

    private String addr;
}
