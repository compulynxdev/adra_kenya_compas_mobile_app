package com.compastbc.utils.print;

public interface ReportPrintCallback {
    void onSuccess(PrintServices printUtils);

    void onPrintPairError();

    void onPrintError(Exception e);

    void onNavigateNextController();
}
