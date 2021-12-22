package com.learn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="user")
@ToString
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String name;

    private String sex;

    private String addr;
}
