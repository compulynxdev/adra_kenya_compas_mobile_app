package com.compastbc.ui.reports.xreport;

import com.compastbc.ui.base.MvpPresenter;

public interface XReportMvpPresenter<V extends XReportMvpView> extends MvpPresenter<V> {

    void getXreportData();
}
