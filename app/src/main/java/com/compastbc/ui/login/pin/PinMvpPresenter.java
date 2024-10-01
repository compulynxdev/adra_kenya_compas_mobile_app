package com.compastbc.ui.login.pin;


import com.compastbc.ui.base.MvpPresenter;

/**
 * Created by hemant sharma on 12/08/19.
 */

public interface PinMvpPresenter<V extends PinMvpView> extends MvpPresenter<V> {

    void verifyInput(String userName, String userPassword);

}
