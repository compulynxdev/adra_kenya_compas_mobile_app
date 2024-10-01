package com.compastbc.ui.transaction.vouchers;

import com.compastbc.ui.base.MvpPresenter;

public interface VouchersMvpPresenter<V extends VouchersMvpView> extends MvpPresenter<V> {

    void getVouchersByProgramId(int programId);

    void getTopups();

}
