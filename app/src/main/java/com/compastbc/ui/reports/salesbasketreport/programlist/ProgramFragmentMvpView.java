package com.compastbc.ui.reports.salesbasketreport.programlist;

import com.compastbc.data.network.model.SalesProgramBean;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface ProgramFragmentMvpView extends MvpView {
    void setData(List<SalesProgramBean> data);

}
