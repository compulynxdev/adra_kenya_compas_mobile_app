package com.compastbc.ui.reports.salesbasketreport.salesbasketfilter.select_program;

import com.compastbc.data.network.model.SalesProgramBean;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface SelectProgramMvpView extends MvpView {
    void setData(List<SalesProgramBean> data);

    void dismissDialogView();
}
