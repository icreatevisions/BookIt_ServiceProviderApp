package com.icreatevisions.bookit_serviceproviderapp.Validators;

import android.text.TextUtils;

public abstract class PasswordValidator implements TextValidator {
    public static final int PASSWORD_LENGTH = 8;

    public PasswordValidator() { super();}

    @Override
    public boolean validate(String s) {
        return TextUtils.isEmpty(s) || s.length() <PASSWORD_LENGTH ? false : true;
    }
}
