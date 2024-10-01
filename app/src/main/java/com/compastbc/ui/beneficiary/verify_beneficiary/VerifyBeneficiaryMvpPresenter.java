package com.compastbc.ui.beneficiary.verify_beneficiary;

import com.compastbc.data.network.model.MemberInfo;
import com.compastbc.ui.base.MvpPresenter;

public interface VerifyBeneficiaryMvpPresenter<V extends VerifyBeneficiaryMvpView> extends MvpPresenter<V> {
    void searchBeneficiary(String searchCriteria, String inputText);

    void searchBeneficiaryByIdNo(String input);

    void searchBeneficiaryByCardNo(String input);

    void doVerifyBenfFp(MemberInfo memberInfo);
}
