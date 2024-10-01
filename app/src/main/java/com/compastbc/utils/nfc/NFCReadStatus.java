package com.compastbc.utils.nfc;

public interface NFCReadStatus {

    void cardNotActivated();

    void cardAuthenticated();

    void cardReadFail();
}
