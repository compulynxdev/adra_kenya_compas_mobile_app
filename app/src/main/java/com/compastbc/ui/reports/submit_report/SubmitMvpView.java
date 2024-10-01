package com.compastbc.ui.reports.submit_report;

import com.compastbc.data.network.model.SubmitTransactionBean;
import com.compastbc.ui.base.MvpView;
import com.compastbc.utils.print.PrintServices;

import java.util.List;

public interface SubmitMvpView extends MvpView {

    void doPrintOperation(PrintServices printUtils);

    void setData(List<SubmitTransactionBean> transactionHistories, String amount);

    void openNextActivity();
}
