package com.compastbc.ui.reports.vendor_summary;

import com.compastbc.data.db.model.TxnCount;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface VendorSummaryMvpView extends MvpView {

    void showData(List<TxnCount> list, long ttlCount);
}
