package com.compastbc.ui.reports.void_transaction_report;

import com.compastbc.data.network.model.TransactionHistory;
import com.compastbc.ui.base.MvpView;
import com.compastbc.utils.print.PrintServices;

import java.util.List;

public interface VoidReportMvpView extends MvpView {
    void setData(List<TransactionHistory> transactionHistories);

    void doPrintOperation(PrintServices printUtils);
}
