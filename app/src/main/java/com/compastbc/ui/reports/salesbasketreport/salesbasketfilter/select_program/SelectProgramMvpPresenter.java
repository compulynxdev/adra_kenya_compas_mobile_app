package com.compastbc.ui.reports.salesbasketreport.salesbasketfilter.select_program;

import com.compastbc.data.network.model.SalesProgramBean;
import com.compastbc.ui.base.MvpPresenter;

import java.util.List;

public interface SelectProgramMvpPresenter<V extends SelectProgramMvpView> extends MvpPresenter<V> {

    void getPrograms(int offset, String startDate, String endDate);

    SalesProgramBean getProgramBean(List<SalesProgramBean> programBeans, String id);
}
