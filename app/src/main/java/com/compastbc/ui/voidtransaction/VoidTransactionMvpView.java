package com.compastbc.ui.voidtransaction;

import com.compastbc.data.db.model.Transactions;
import com.compastbc.ui.base.MvpView;

import org.json.JSONObject;

public interface VoidTransactionMvpView extends MvpView {

    void showDetails(JSONObject object);

    void showDetails(Transactions transactionsList);

    void openNextActivity();

    void hideDialog();
}
