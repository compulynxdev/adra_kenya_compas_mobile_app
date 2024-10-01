package com.compastbc.ui.beneficiary.enroll_beneficiary;

import com.compastbc.ui.base.MvpView;

import org.json.JSONObject;

public interface EnrollBeneficiaryMvpView extends MvpView {

    void showBeneficiaryDetails(JSONObject object);

    void openNextActivity();
}
