package com.sky.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DishPageQueryDTO implements Serializable {
    private int page;

    private int pageSize;

    private String name;

    private Integer categoryId;

    private Integer status;
}
