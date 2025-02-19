package com.compastbc.ui.changepassword;


import com.compastbc.ui.base.MvpPresenter;

public interface ChangePasswordMvpPresenter<V extends ChangePasswordMvpView> extends MvpPresenter<V> {

    void readCardDetails();

    void writeCardDetails(String newPass, String identification);

}
