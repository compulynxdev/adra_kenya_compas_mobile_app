package com.compastbc.ui.agentpassword;

import com.compastbc.ui.base.MvpPresenter;

public interface ChangeAgentPasswordMvpPresenter extends MvpPresenter<ChangeAgentPasswordMvpView> {
    void doChangePwd(String current, String newPassword, String confirm);
}
