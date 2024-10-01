package com.compastbc.ui.reports.salesbasketreport.salesbasketfilter.select_beneficiary;

import com.compastbc.data.network.model.SalesBeneficiary;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface SelectBeneficiaryMvpView extends MvpView {
    void setData(List<SalesBeneficiary> data);

    void dismissDialogView();
}
