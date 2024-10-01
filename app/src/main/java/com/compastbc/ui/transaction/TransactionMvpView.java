package com.compastbc.ui.transaction;

import com.compastbc.data.db.model.Programs;
import com.compastbc.ui.base.MvpView;

import org.json.JSONObject;

import java.util.List;

public interface TransactionMvpView extends MvpView {

    void showPinView(String cardPin, List<Programs> programmesList, JSONObject programData);

    void showBiometricView(List<Programs> programmesList, List<String> fps, JSONObject programData);

    void showProgramList(List<Programs> programmesList);

    void openBeneficiaryActivity();

    void openCartActivity();
}
