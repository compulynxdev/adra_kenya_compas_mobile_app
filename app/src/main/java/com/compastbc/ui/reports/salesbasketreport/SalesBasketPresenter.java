package com.compastbc.ui.reports.salesbasketreport;


import com.compastbc.data.DataManager;
import com.compastbc.ui.base.BasePresenter;


class SalesBasketPresenter<V extends SalesBasketMvpView> extends BasePresenter<V>
        implements SalesBasketMvpPresenter<V> {


    SalesBasketPresenter(DataManager dataManager) {
        super(dataManager);

    }


}
