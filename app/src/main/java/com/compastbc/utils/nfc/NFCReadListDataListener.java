package com.compastbc.utils.nfc;

import java.util.List;

/**
 * Created by Hemant Sharma on 17-02-20.
 * Divergent software labs pvt. ltd
 */
public interface NFCReadListDataListener {
    void onSuccessRead(List<String> data);

    void onFail(String TAG, String msg);
}
