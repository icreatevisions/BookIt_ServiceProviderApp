package com.icreatevisions.bookit_serviceproviderapp.Validators;

import android.text.TextUtils;
import android.util.Patterns;

public abstract class EmailTextValidator implements TextValidator {

    private String email;

    public EmailTextValidator() {
        super();
    }

    @Override
    public boolean validate(String s) {
        return TextUtils.isEmpty(s) ? false: Patterns.EMAIL_ADDRESS.matcher(s).matches();
    }
}
