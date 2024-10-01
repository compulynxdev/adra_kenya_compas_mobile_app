package com.compastbc.utils.nfc;

/**
 * Created by Hemant Sharma on 07-02-20.
 * Divergent software labs pvt. ltd
 */
public interface NFCListener {
    void onSuccess(int flag);

    void onFail(String TAG, String msg);
}
