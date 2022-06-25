package com.example.cardiacrecorder;

import com.google.android.material.textfield.TextInputLayout;

public class setsystdiast {
    String systolic,diastolic;

    public setsystdiast() {

    }
    public setsystdiast(String syst,String diast) {
        this.systolic = syst;
        this.diastolic= diast;}
    public String getName() {
        return systolic;
    }

    public void setName(String syst) {
        this.systolic = syst;
    }

    public String getLastname() {
        return diastolic;
    }

    public void setUsername(String diastolic) {
        this.diastolic = diastolic;

    }

}
