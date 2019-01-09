package com.matmazur.springvalidationboot.model;

import com.matmazur.springvalidationboot.myValidators.constraints.Divisible;

public class TestNumber {

    @Divisible(by = 5)
    private Integer number;

    public TestNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


}
