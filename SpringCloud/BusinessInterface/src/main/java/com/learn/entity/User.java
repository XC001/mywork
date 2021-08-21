package com.learn.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import lombok.Data;

@Data
@JsonDeserialize
public class User {
    @JsonProperty
    private Integer id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String sex;

    @JsonProperty
    private String addr;
}
