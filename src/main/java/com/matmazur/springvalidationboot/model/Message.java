package com.matmazur.springvalidationboot.model;

import com.matmazur.springvalidationboot.common.Lang;
import com.matmazur.springvalidationboot.myValidators.constraints.NotBadWord;

import javax.validation.constraints.NotBlank;

public class Message {

    @NotBlank
    private String name;
    @NotBadWord(lang = {Lang.ENG, Lang.PL})
    private String message;

    public Message(@NotBlank String name, String message) {
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
