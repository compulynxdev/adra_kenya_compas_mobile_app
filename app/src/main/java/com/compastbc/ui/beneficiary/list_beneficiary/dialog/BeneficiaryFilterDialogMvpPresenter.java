package com.compastbc.ui.beneficiary.list_beneficiary.dialog;

import com.compastbc.ui.base.DialogMvpView;
import com.compastbc.ui.base.MvpPresenter;

public interface BeneficiaryFilterDialogMvpPresenter<V extends DialogMvpView> extends MvpPresenter<V> {
    void doVerifyInput();
}
