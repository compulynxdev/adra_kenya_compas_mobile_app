package com.compastbc.ui.transaction.cart;

import com.compastbc.data.network.model.TransactionReceipt;
import com.compastbc.ui.base.MvpView;
import com.compastbc.utils.print.PrintServices;

public interface CartMvpView extends MvpView {

    void show(String price, String qty);

    void Update(String id);

    void setData();

    void openNextActivity();

    void hideDialog();

    void print(TransactionReceipt receipt, boolean vendorReceipt);

    void printReceipt(PrintServices printUtils, TransactionReceipt receipt, boolean vendorReceipt);
}
