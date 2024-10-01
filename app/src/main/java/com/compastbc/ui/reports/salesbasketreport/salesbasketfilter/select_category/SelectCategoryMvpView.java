package com.compastbc.ui.reports.salesbasketreport.salesbasketfilter.select_category;

import com.compastbc.data.network.model.SalesCategoryBean;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface SelectCategoryMvpView extends MvpView {
    void setData(List<SalesCategoryBean> data);

    void dismissDialogView();
}
