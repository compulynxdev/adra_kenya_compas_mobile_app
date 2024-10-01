package com.compastbc.ui.transaction.cart;

import com.compastbc.data.db.model.PurchasedProducts;
import com.compastbc.ui.base.MvpPresenter;

import java.util.List;

public interface CartMvpPresenter<V extends CartMvpView> extends MvpPresenter<V> {

    void getData(List<PurchasedProducts> purchasedProducts);

    void Update(Long id);

    void readCardDetails();

    void saveData();

}
