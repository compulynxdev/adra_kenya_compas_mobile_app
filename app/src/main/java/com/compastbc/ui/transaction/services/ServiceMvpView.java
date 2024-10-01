package com.compastbc.ui.transaction.services;

import com.compastbc.data.db.model.Services;
import com.compastbc.data.network.model.ServicePrices;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface ServiceMvpView extends MvpView {

    void showServices(List<Services> servicesList);

    void showDialog(List<ServicePrices> servicePrices);
}
