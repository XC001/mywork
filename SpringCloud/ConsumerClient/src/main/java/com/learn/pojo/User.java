package com.learn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String sex;
    private String addr;
}
