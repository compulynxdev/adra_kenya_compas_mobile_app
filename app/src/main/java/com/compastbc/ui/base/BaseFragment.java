package com.compastbc.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.afollestad.materialdialogs.MaterialDialog;
import com.compastbc.Compas;
import com.compastbc.data.AppDataManager;

import cn.pedant.SweetAlert.SweetAlertDialog;


public abstract class BaseFragment extends Fragment implements MvpView {

    private BaseActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLanguage(getDataManager().getLanguage());
        setHasOptionsMenu(false);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    private void updateLanguage(String appLanguage) {
        if (mActivity != null) mActivity.updateLanguage(appLanguage);
    }

    @Override
    public void showLoading() {
        if (mActivity != null)
            mActivity.showLoading();
    }

    @Override
    public void showLoading(String label) {
        if (mActivity != null)
            mActivity.showLoading(label);
    }

    @Override
    public void hideLoading() {
        if (mActivity != null)
            mActivity.hideLoading();
    }

    @Override
    public void onError(String message) {
        if (mActivity != null) {
            mActivity.onError(message);
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.onError(resId);
        }
    }

    @Override
    public void showMessage(String message) {
        if (mActivity != null) {
            mActivity.showMessage(message);
        }
    }

    @Override
    public void showMessage(@StringRes int resId) {
        if (mActivity != null) {
            mActivity.showMessage(resId);
        }
    }

    @Override
    public void showMessage(String title, String message) {
        if (mActivity != null) {
            mActivity.showMessage(title, message);
        }
    }

    @Override
    public void showMessage(@StringRes int title, @StringRes int message) {
        if (mActivity != null) {
            mActivity.showMessage(title, message);
        }
    }

    @Override
    public boolean verifyDeviceModel(String modelName) {
        return mActivity != null && mActivity.verifyDeviceModel(modelName);
    }

    @Override
    public void show(SweetAlertDialog sweetAlertDialog) {
        if (mActivity != null) mActivity.show(sweetAlertDialog);
    }

    @Override
    public SweetAlertDialog sweetAlert(String title, String message) {
        return mActivity.sweetAlert(title, message);
    }

    @Override
    public SweetAlertDialog sweetAlert(int alertType, int title, int content) {
        return mActivity.sweetAlert(alertType, title, content);
    }

    @Override
    public SweetAlertDialog sweetAlert(@StringRes int title, @StringRes int message) {
        return mActivity.sweetAlert(title, message);
    }

    @Override
    public SweetAlertDialog sweetAlert(int title, String message) {
        return mActivity.sweetAlert(title, message);
    }

    @Override
    public SweetAlertDialog sweetAlert(int alertType, String title, String content) {
        return mActivity.sweetAlert(alertType, title, content);
    }

    @Override
    public MaterialDialog materialDialog(String title, String message) {
        return mActivity.materialDialog(title, message);
    }

    @Override
    public MaterialDialog materialDialog(int title, int message) {
        return mActivity.materialDialog(title, message);
    }

    @Override
    public void hideSweetAlertDialog() {
        if (mActivity != null) {
            mActivity.hideSweetAlertDialog();
        }
    }

    @Override
    public boolean isNetworkConnected() {
        return mActivity.isNetworkConnected();
    }

    @Override
    public boolean isNetworkConnected(boolean isMsgShow) {
        return mActivity.isNetworkConnected(isMsgShow);
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    @Override
    public void openActivityOnTokenExpire() {
        if (mActivity != null) {
            mActivity.openActivityOnTokenExpire();
        }
    }

    protected BaseActivity getBaseActivity() {
        return mActivity;
    }

    protected AppDataManager getDataManager() {
        return Compas.getInstance().getDataManager();
    }

    protected abstract void setUp(View view);

    @Override
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    @Override
    public void createLog(String activityName, String action) {
        if (mActivity != null) mActivity.createLog(activityName, action);
    }

    @Override
    public void createAttendanceLog() {
        if (mActivity != null) mActivity.createAttendanceLog();
    }

    @Override
    public void getAccessToken(String userName, String pwd, BaseActivity.TokenCallback tokenCallback) {
        if (mActivity != null)
            mActivity.getAccessToken(userName, pwd, tokenCallback);
    }

    @Override
    public void getAccessToken(BaseActivity.TokenCallback tokenCallback) {
        if (mActivity != null)
            mActivity.getAccessToken(tokenCallback);
    }

    protected String getAddressFromLatLng(Double latitude, Double longitude) {
        if (mActivity != null) {
            return mActivity.getAddressFromLatLng(latitude, longitude);
        } else return "";
    }

    @Override
    public void uploadExceptionData(String data, String methodName, int lineNo, String className, String exception) {
        if(mActivity!=null){
            mActivity.uploadExceptionData(data, methodName, lineNo, className, exception);
        }
    }

    @Override
    public void downloadMasterData(BaseActivity.DownloadDataCallback dataCallback) {
        if (mActivity != null)
            mActivity.downloadMasterData(dataCallback);
    }

        public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}

