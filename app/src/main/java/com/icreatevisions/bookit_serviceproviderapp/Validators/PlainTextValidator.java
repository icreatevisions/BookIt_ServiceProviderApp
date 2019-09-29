package com.icreatevisions.bookit_serviceproviderapp.Validators;

public abstract class PlainTextValidator implements TextValidator {

    public PlainTextValidator() { super();}

    @Override
    public boolean validate(String s) {
        return s == null || s.equals("") ?false :true;
    }
}
