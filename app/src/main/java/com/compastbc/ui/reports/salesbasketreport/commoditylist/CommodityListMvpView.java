package com.compastbc.ui.reports.salesbasketreport.commoditylist;

import com.compastbc.data.network.model.SalesCommodityBean;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface CommodityListMvpView extends MvpView {

    void setData(List<SalesCommodityBean> data);
}
