package com.compastbc.ui.cardactivation;


import com.compastbc.ui.base.MvpPresenter;

public interface CardActivationMvpPresenter<V extends CardActivationMvpView> extends MvpPresenter<V> {

    void findBeneficiary(String idno);

    void verifyInput(String input);

    void doActivateCard();

}
