package com.compastbc.ui.main.appupdate;


import com.compastbc.data.DataManager;
import com.compastbc.ui.base.BasePresenter;

/**
 * Created by Hemant on 26/08/19.
 */

class AppUpdateDialogPresenter<V extends AppUpdateDialogMvpView> extends BasePresenter<V>
        implements AppUpdateDialogMvpPresenter<V> {

    public static final String TAG = "AppUpdateDialogPresenter";

    private boolean isRatingSecondaryActionShown = false;

    AppUpdateDialogPresenter(DataManager dataManager) {
        super(dataManager);
    }

}
