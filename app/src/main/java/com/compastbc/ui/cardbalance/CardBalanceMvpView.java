package com.compastbc.ui.cardbalance;

import com.compastbc.data.network.model.CardBalanceBean;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface CardBalanceMvpView extends MvpView {

    void showBalance(String identityNo, String name, String cardNo, List<CardBalanceBean> cardBalanceBeans);

}
