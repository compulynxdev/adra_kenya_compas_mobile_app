package com.compastbc.ui.reports.sync_report;

import com.compastbc.data.network.model.SyncReportModel;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface SyncReportMvpView extends MvpView {

    void setData(List<SyncReportModel> models, String count, String totalTxn, String totalAmount);

}
