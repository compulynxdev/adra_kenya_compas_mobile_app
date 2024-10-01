package com.compastbc.ui.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.afollestad.materialdialogs.MaterialDialog;
import com.compastbc.Compas;
import com.compastbc.data.AppDataManager;

import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * Created by hemant.
 * Date: 31/5/18
 * Time: 1:10 PM
 */

public abstract class BaseDialog extends DialogFragment implements View.OnFocusChangeListener, DialogMvpView {

    private BaseActivity mActivity;
    private Boolean isBottom = false;

    protected void setIsBottomTrue() {
        this.isBottom = true;
    }

    protected AppDataManager getDataManager() {
        return Compas.getInstance().getDataManager();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity mActivity = (BaseActivity) context;
            this.mActivity = mActivity;
            mActivity.onFragmentAttached();
        }
    }

    @Override
    public void showLoading() {
        if (mActivity != null) {
            mActivity.showLoading();
        }
    }

    @Override
    public void showLoading(String label) {
        if (mActivity != null)
            mActivity.showLoading(label);
    }

    @Override
    public void hideLoading() {
        if (mActivity != null) {
            mActivity.hideLoading();
        }
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
    public SweetAlertDialog sweetAlert(@StringRes int title, @StringRes int message) {
        return mActivity.sweetAlert(title, message);
    }

    @Override
    public SweetAlertDialog sweetAlert(int title, String message) {
        return mActivity.sweetAlert(title, message);
    }

    @Override
    public void createAttendanceLog() {
        if (mActivity != null) mActivity.createAttendanceLog();
    }

    @Override
    public SweetAlertDialog sweetAlert(int alertType, String title, String content) {
        return mActivity.sweetAlert(alertType, title, content);
    }

    @Override
    public SweetAlertDialog sweetAlert(int alertType, int title, int content) {
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
    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }

    @Override
    public void openActivityOnTokenExpire() {
        if (mActivity != null) {
            mActivity.openActivityOnTokenExpire();
        }
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    protected abstract void setUp(View view);

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (!hasFocus) {
            hideKeyboard();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // the content
        final RelativeLayout root = new RelativeLayout(getActivity());

        if (isBottom) {
            root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
        } else {
            root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        // creating the fullscreen dialog
        final Dialog dialog = new Dialog(mActivity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(root);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            if (isBottom) {
                dialog.getWindow().setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
            } else {
                dialog.getWindow().setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
        }
      /*  if (isBottom)dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimationUpDown;
        else dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;*/
        dialog.setCanceledOnTouchOutside(false);

        return dialog;
    }

    public void show(FragmentManager fragmentManager, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment prevFragment = fragmentManager.findFragmentByTag(tag);
        if (prevFragment != null) {
            transaction.remove(prevFragment);
        }
        transaction.addToBackStack(null);
        show(transaction, tag);
    }

    public void dismissDialog(String tag) {
        hideKeyboard();
        dismiss();
    }

    @Override
    public void createLog(String activityName, String action) {
        if (mActivity != null) mActivity.createLog(activityName, action);
    }
    @Override
    public void downloadMasterData(BaseActivity.DownloadDataCallback dataCallback) {
        if (mActivity != null)
            mActivity.downloadMasterData(dataCallback);
    }

    @Override
    public void getAccessToken(String userName, String pwd, BaseActivity.TokenCallback tokenCallback) {
        if (mActivity != null) mActivity.getAccessToken(userName, pwd, tokenCallback);
    }

    @Override
    public void getAccessToken(BaseActivity.TokenCallback tokenCallback) {
        if (mActivity != null) mActivity.getAccessToken(tokenCallback);
    }

    @Override
    public void uploadExceptionData(String data, String methodName, int lineNo, String className, String exception) {
        if (mActivity!=null)
            mActivity.uploadExceptionData(data, methodName, lineNo, className, exception);
    }
}
