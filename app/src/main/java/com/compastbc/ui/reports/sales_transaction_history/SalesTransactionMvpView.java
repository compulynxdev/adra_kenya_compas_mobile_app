package com.compastbc.ui.reports.sales_transaction_history;

import com.compastbc.data.network.model.TransactionHistory;
import com.compastbc.ui.base.MvpView;
import com.compastbc.utils.print.PrintServices;

import java.util.List;

public interface SalesTransactionMvpView extends MvpView {

    void setData(List<TransactionHistory> transactionHistories);

    void doPrintOperation(PrintServices printUtils);

    void createPdf();

    void doSearch(int page, String search);
}
