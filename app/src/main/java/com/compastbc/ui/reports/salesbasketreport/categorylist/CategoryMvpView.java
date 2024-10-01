package com.compastbc.ui.reports.salesbasketreport.categorylist;

import com.compastbc.data.network.model.SalesCategoryBean;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface CategoryMvpView extends MvpView {


    void setData(List<SalesCategoryBean> data);

}
