package com.compastbc.ui.transaction.services.servicedialog;

import com.compastbc.data.network.model.ServicePrices;
import com.compastbc.ui.base.MvpPresenter;

import java.util.List;

public interface ServiceDialogMvpPresenter<V extends ServiceDialogMvpView> extends MvpPresenter<V> {

    String getMaxPrice(List<ServicePrices> servicePrices, String uom);
}
