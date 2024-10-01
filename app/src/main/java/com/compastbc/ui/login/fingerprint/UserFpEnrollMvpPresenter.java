package com.compastbc.ui.login.fingerprint;


import android.graphics.Bitmap;

import com.compastbc.data.network.model.MemberInfo;
import com.compastbc.ui.base.MvpPresenter;

/**
 * Created by hemant sharma on 12/08/19.
 */

public interface UserFpEnrollMvpPresenter<V extends UserFpEnrollMvpView> extends MvpPresenter<V> {
    void doSaveAgentData(Bitmap bitmap, MemberInfo memberInfo);

    void getAgentBiometric();
}
