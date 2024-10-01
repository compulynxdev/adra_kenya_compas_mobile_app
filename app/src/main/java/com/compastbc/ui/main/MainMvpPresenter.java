package com.compastbc.ui.main;


import com.compastbc.data.network.model.HomeBean;
import com.compastbc.ui.base.MvpPresenter;

import java.util.List;

/**
 * Created by hemant sharma on 12/08/19.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    List<HomeBean> getHomeOptions();

    void uploadTransactions(boolean OnClick);

    void uploadArchiveTransactions(boolean OnClick);

    void uploadTopupLogs(boolean OnClick);

    void uploadActivities(boolean OnClick);

    void uploadAttendance(boolean OnClick);

    void uploadAgents(boolean OnClick);

    void uploadBeneficiaries(boolean OnClick);

    void uploadPendingSynchronisation(boolean OnClick);

    void dismissDialog();

}
