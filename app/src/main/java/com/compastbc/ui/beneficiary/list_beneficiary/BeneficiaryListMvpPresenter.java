package com.compastbc.ui.beneficiary.list_beneficiary;

import android.widget.EditText;

import com.compastbc.data.network.model.BeneficiaryFilterBean;
import com.compastbc.ui.base.MvpPresenter;

/**
 * Created by Hemant Sharma on 26-09-19.
 * Divergent software labs pvt. ltd
 */
public interface BeneficiaryListMvpPresenter<V extends BeneficiaryListMvpView> extends MvpPresenter<V> {
    void setupSearch(EditText etSearch);

    void doGetBeneficiaryList(boolean isLoader, int page, String search);

    void doGetBeneficiaryList(boolean isLoader, int page, String search, String url);

    void doGetBeneficiaryList(boolean isLoader, int page, BeneficiaryFilterBean tmpFilterBean);
}
