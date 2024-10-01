package com.compastbc.ui.reports.summary;

import com.compastbc.ui.base.MvpPresenter;

public interface SummaryMvpPresenter<V extends SummaryMvpView> extends MvpPresenter<V> {

    void getAllDetails();

}
