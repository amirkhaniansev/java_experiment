package com.example.users_api;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Min;

public class UserRequest {
    @NotNull
    @NotEmpty
    private String name;

    @Min(0)
    private Integer page;

    @Min(5)
    @Max(100)
    private Integer count;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}