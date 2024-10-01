package com.compastbc.ui.reports.xreport;

import com.compastbc.data.network.model.XReportBean;
import com.compastbc.ui.base.MvpView;
import com.compastbc.utils.print.PrintServices;

import java.util.List;

public interface XReportMvpView extends MvpView {

    void showData(List<XReportBean> xReportBean);

    void doPrintOperation(PrintServices printUtils);
}
