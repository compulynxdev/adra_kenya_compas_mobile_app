package com.compastbc.ui.reports.salesbasketreport.programlist;

import com.compastbc.data.network.model.SalesProgramBean;
import com.compastbc.ui.base.MvpPresenter;

import java.util.List;

public interface ProgramFragmentMvpPresenter<V extends ProgramFragmentMvpView> extends MvpPresenter<V> {

    SalesProgramBean getProgramBean(List<SalesProgramBean> programBeans, String id);

    void getProgrammesData(int offset);
}
