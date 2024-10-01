package com.compastbc.ui.reports.salesbasketreport.commoditylist;

import com.compastbc.data.network.model.SalesCommodityBean;
import com.compastbc.ui.base.MvpPresenter;

import java.util.List;

public interface CommodityListMvpPresenter<V extends CommodityListMvpView> extends MvpPresenter<V> {

    void getSaleCommodities(String programId, String productId, String categoryId, int offset);

    SalesCommodityBean getCommodity(List<SalesCommodityBean> beanList, String id);

    String getCurrency(String programmeId);
}
