package com.compastbc.ui.reports.salesbasketreport.salesbasketfilter.select_commodity;

import com.compastbc.data.network.model.SalesCommodityBean;
import com.compastbc.ui.base.MvpPresenter;

import java.util.List;

public interface SelectCommodityMvpPresenter<V extends SelectCommodityMvpView> extends MvpPresenter<V> {

    void getSaleCommodities(String programId, String productId, String categoryId, int offset, String startDate, String endDate);

    SalesCommodityBean getCommodity(List<SalesCommodityBean> beanList, String id);

    String getCashCurrency(String programmeId);
}
