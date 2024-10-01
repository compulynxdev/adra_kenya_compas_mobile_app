package com.compastbc.ui.reports.salesbasketreport.beneficiaryuomlist;

import com.compastbc.data.network.model.SalesBeneficiary;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface BeneficiaryUomMvpView extends MvpView {

    void setData(List<SalesBeneficiary> data);

}
