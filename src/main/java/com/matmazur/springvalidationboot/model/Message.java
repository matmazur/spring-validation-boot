package com.matmazur.springvalidationboot.model;

import com.matmazur.springvalidationboot.common.Lang;
import com.matmazur.springvalidationboot.myValidators.constraints.NotBadWord;
import com.matmazur.springvalidationboot.myValidators.groups.Complete;
import com.matmazur.springvalidationboot.myValidators.groups.Draft;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Message {

    @NotBlank(groups = {Draft.class, Complete.class})
    private String name;
    @NotBadWord(lang = {Lang.ENG, Lang.PL}, groups = {Complete.class})
    @Size(min = 2, max = 200, groups = {Complete.class})
    private String message;

    public Message(String name, String message) {
        this.name = name;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
