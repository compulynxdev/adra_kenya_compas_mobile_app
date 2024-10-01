package com.compastbc.data.prefs;


import android.app.Activity;

import com.compastbc.data.db.model.Beneficiary;
import com.compastbc.data.network.model.ConfigurableParameters;
import com.compastbc.data.network.model.Configuration;
import com.compastbc.data.network.model.Details;

import java.util.HashMap;

/**
 * Created by hemant
 * Date: 10/4/18.
 */

public interface PreferencesHelper {

    boolean isLoggedIn();

    void setLoggedIn(boolean isLoggedIn);

    HashMap<String, String> getHeader();

    Details getUserDetail();

    void setUserDetail(Details detail);

    void setUser(String userName);

    void setPassword(String userPassword);

    String getUserName();

    String getUserPassword();

    boolean isFirstTime();

    void setFirstTimeStatus(boolean isFirst);

    Configuration getConfigurationDetail();

    void setConfigurationDetail(Configuration configuration);

    void logout(Activity activity);

    String getDeviceId();

    void setDeviceId(String deviceId);

    ConfigurableParameters getConfigurableParameterDetail();

    void setConfigurableParameterDetail(ConfigurableParameters parameters);

    String getLanguage();

    void setLanguage(String language);

    Beneficiary getCurrentVerifyBenfInfo();

    void setCurrentVerifyBenfInfo(Beneficiary currentVerifyBenfInfo);

    String getCurrency();

    void setCurrency(String currency);

}
