package com.compastbc.ui.update;

import com.compastbc.ui.base.MvpPresenter;

public interface UpdateMvpPresenter<V extends UpdateMvpView> extends MvpPresenter<V> {

    void Master();

    void CardHolders();

    void Topups();
}
