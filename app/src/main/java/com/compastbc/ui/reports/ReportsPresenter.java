package com.compastbc.ui.reports;

import com.compastbc.data.DataManager;
import com.compastbc.ui.base.BasePresenter;

class ReportsPresenter<V extends ReportsMvpView> extends BasePresenter<V>
        implements ReportsMvpPresenter<V> {

    ReportsPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
