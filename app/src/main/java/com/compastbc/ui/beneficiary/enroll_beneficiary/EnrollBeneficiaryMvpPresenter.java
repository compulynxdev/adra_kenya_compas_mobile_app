package com.compastbc.ui.beneficiary.enroll_beneficiary;

import android.graphics.Bitmap;

import com.compastbc.data.network.model.MemberInfo;
import com.compastbc.ui.base.MvpPresenter;

import org.json.JSONObject;

public interface EnrollBeneficiaryMvpPresenter<V extends EnrollBeneficiaryMvpView> extends MvpPresenter<V> {
    void searchBeneficiary(String searchCriteria, String inputText);

    void searchBeneficiaryByIdNo(String input);

    void searchBeneficiaryByCardNo(String input);

    void saveBeneficiaryBiometric(String idno, String memberId, Bitmap bitmap, MemberInfo memberInfo);

    void UploadBeneficiaryBiometric(JSONObject object);
}
