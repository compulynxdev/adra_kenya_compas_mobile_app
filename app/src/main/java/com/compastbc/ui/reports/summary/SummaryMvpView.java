package com.compastbc.ui.reports.summary;

import com.compastbc.data.network.model.SummaryReportBean;
import com.compastbc.ui.base.MvpView;
import com.compastbc.utils.print.PrintServices;

public interface SummaryMvpView extends MvpView {

    void showData(SummaryReportBean summaryReportBean);

    void doPrintOperation(PrintServices printUtils);

}
