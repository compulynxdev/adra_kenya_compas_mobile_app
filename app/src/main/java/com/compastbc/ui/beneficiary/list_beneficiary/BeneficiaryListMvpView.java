package com.compastbc.ui.beneficiary.list_beneficiary;

import com.compastbc.data.db.model.Beneficiary;
import com.compastbc.data.network.model.BeneficiaryListResponse;
import com.compastbc.ui.base.MvpView;

import java.util.List;

/**
 * Created by Hemant Sharma on 26-09-19.
 * Divergent software labs pvt. ltd
 */
public interface BeneficiaryListMvpView extends MvpView {
    void hideFooterLoader();

    void updateUI(List<BeneficiaryListResponse.ContentBean> contentBeanList);

    void updateUIFromDB(List<Beneficiary> beneficiaryList);

    void doSearch(int page, String search);
}
