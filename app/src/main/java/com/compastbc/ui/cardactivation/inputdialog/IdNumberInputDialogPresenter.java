package com.compastbc.ui.cardactivation.inputdialog;

import com.compastbc.data.DataManager;
import com.compastbc.ui.base.BasePresenter;

class IdNumberInputDialogPresenter<V extends IdNumberInputDialogMvpView> extends BasePresenter<V>
        implements IdNumberInputDialogMvpPresenter<V> {

    IdNumberInputDialogPresenter(DataManager dataManager) {
        super(dataManager);
    }

}
