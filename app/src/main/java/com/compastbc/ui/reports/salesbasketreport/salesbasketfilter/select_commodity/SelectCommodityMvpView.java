package com.compastbc.ui.reports.salesbasketreport.salesbasketfilter.select_commodity;

import com.compastbc.data.network.model.SalesCommodityBean;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface SelectCommodityMvpView extends MvpView {
    void setData(List<SalesCommodityBean> data);

    void dismissDialogView();
}
