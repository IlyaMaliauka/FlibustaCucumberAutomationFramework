package com.automation.service;

import com.automation.model.User;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "maliauka";
    public static final String TESTDATA_USER_PASSWORD = "wPtQd4Ka.nWZ3-6";

    public static User withCredentialsFromProperty() {
        return new User(TESTDATA_USER_NAME, TESTDATA_USER_PASSWORD);
    }

}
