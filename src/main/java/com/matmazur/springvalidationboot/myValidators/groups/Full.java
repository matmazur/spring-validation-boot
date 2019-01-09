package com.matmazur.springvalidationboot.myValidators.groups;

import javax.validation.GroupSequence;

@GroupSequence({Draft.class, Complete.class})
public interface Full {
}
