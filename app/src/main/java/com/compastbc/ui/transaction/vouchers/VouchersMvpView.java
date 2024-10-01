package com.compastbc.ui.transaction.vouchers;

import com.compastbc.data.db.model.Vouchers;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface VouchersMvpView extends MvpView {

    void showVouchers(List<Vouchers> list);
}
