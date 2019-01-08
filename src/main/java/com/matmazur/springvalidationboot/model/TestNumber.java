package com.matmazur.springvalidationboot.model;

import com.matmazur.springvalidationboot.myValidators.constraints.Divided;

public class TestNumber {

    @Divided(by = 5)
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
