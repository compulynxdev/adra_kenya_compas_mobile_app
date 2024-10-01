package com.compastbc.ui.reports.commodityreport;

import com.compastbc.data.network.model.CommodityReportBean;
import com.compastbc.ui.base.MvpView;
import com.compastbc.utils.print.PrintServices;

import java.util.List;

public interface CommodityReportMvpView extends MvpView {

    void setData(List<CommodityReportBean> list);

    void setDate(String dateEng, String displayDate);

    void doPrintOperation(PrintServices printUtils);
}
