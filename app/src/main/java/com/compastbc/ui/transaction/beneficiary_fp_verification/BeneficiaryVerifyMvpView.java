package com.compastbc.ui.transaction.beneficiary_fp_verification;

import android.graphics.Bitmap;

import com.compastbc.ui.base.MvpView;

public interface BeneficiaryVerifyMvpView extends MvpView {

    void updateImage(Bitmap bitmap);

    void getPrograms();
}
