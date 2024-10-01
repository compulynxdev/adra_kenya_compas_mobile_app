package com.compastbc.ui.reports.sync_report;

import com.compastbc.ui.base.MvpPresenter;

public interface SyncReportMvpPresenter<V extends SyncReportMvpView> extends MvpPresenter<V> {

    void getData();

}
