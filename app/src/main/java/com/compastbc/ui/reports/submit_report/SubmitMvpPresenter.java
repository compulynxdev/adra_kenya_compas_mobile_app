package com.compastbc.ui.reports.submit_report;

import com.compastbc.ui.base.MvpPresenter;

public interface SubmitMvpPresenter<V extends SubmitMvpView> extends MvpPresenter<V> {

    void getData();

    void updateTransactions();

}
