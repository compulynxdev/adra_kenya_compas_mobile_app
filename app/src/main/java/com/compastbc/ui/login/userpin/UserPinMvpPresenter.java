package com.compastbc.ui.login.userpin;

import com.compastbc.ui.base.MvpPresenter;

public interface UserPinMvpPresenter extends MvpPresenter<UserPinMvpView> {

    void verifyInput(String password);

}
