package com.compastbc.ui.login;


import com.compastbc.ui.base.MvpPresenter;


/**
 * Created by hemant sharma on 12/08/19.
 */

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onNextClick(String userName, String password);

    void checkBioStatus();
}
