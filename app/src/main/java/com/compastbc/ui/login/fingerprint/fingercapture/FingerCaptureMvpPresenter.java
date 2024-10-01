package com.compastbc.ui.login.fingerprint.fingercapture;

import com.compastbc.data.network.model.MemberInfo;
import com.compastbc.ui.base.MvpPresenter;

/**
 * Created by hemant sharma on 12/08/19.
 */


public interface FingerCaptureMvpPresenter<V extends FingerCaptureMvpView>
        extends MvpPresenter<V> {

    void onViewLoaded();

    void onLeftThumbClick();

    void onLeftFrontClick();

    void onLeftOneCLick();

    void onLeftTwoCLick();

    void onLeftIndexClick();

    void onRightThumbClick();

    void onRightFrontClick();

    void onRightOneCLick();

    void onRightTwoCLick();

    void onRightIndexClick();

    MemberInfo getAllFingerPrintData();
}


