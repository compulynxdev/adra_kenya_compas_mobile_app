package com.compastbc.ui.reports.salesbasketreport.categorylist;

import com.compastbc.data.network.model.SalesCategoryBean;
import com.compastbc.ui.base.MvpPresenter;

import java.util.List;

public interface CategoryMvpPresenter<V extends CategoryMvpView> extends MvpPresenter<V> {

    void getSaleCatrgories(String programId, String productId, int offset);

    SalesCategoryBean getCategory(List<SalesCategoryBean> salesCategoryBeans, String id);

}
