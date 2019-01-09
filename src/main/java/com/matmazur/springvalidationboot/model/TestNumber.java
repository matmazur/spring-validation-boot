package com.matmazur.springvalidationboot.model;

import com.matmazur.springvalidationboot.myValidators.constraints.Divisible;
import com.matmazur.springvalidationboot.myValidators.groups.Complete;
import com.matmazur.springvalidationboot.myValidators.groups.Draft;

public class TestNumber {

    @Divisible(by = 5, groups = {Draft.class, Complete.class})
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
