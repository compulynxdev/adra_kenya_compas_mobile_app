package com.compastbc.ui.cardformat;


import android.content.Intent;

import com.compastbc.ui.base.MvpPresenter;

public interface CardFormatMvpPresenter<V extends CardFormatMvpView> extends MvpPresenter<V> {

    void formatCard(Intent intent, boolean isCleanFormat);
}
