package com.compastbc.utils.print;

public interface OnPrinterInteraction {
    void onSuccess(String TAG);

    void onFail(String TAG);

    void onPrintStatusBusy();

    void onPrintStatusHighTemp();

    void onPrintStatusPaperLack();

    void onPrintStatusNoBattery();
}
