package com.compastbc.ui.transaction.beneficiary_fp_verification;

import com.compastbc.ui.base.MvpPresenter;

public interface BeneficiaryVerifyMvpPresenter<V extends BeneficiaryVerifyMvpView> extends MvpPresenter<V> {

    void onViewLoaded();

    void onClick();

}
