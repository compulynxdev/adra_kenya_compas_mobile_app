package com.compastbc.ui.login.fingerprint.imagecapture;

import com.compastbc.data.DataManager;
import com.compastbc.ui.base.BasePresenter;

public class ImageCapturePresenter<V extends ImageCaptureMvpView> extends BasePresenter<V>
        implements ImageCaptureMvpPresenter<V> {

    public ImageCapturePresenter(DataManager dataManager) {
        super(dataManager);
    }
}
