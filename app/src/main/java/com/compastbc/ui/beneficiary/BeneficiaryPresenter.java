package com.compastbc.ui.beneficiary;

import com.compastbc.data.DataManager;
import com.compastbc.ui.base.BasePresenter;

class BeneficiaryPresenter<V extends BeneficiaryMvpView> extends BasePresenter<V>
        implements BeneficiaryMvpPresenter<V> {

    BeneficiaryPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
