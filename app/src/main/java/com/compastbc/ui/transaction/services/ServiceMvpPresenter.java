package com.compastbc.ui.transaction.services;

import com.compastbc.ui.base.MvpPresenter;

public interface ServiceMvpPresenter<V extends ServiceMvpView> extends MvpPresenter<V> {

    void getCommodities();

    void getUoms(String Id);
}
