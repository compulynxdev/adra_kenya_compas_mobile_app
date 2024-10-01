package com.compastbc.ui.reports.salesbasketreport.uoms;

import android.database.Cursor;

import androidx.annotation.NonNull;

import com.compastbc.data.DataManager;
import com.compastbc.data.db.model.CommoditiesDao;
import com.compastbc.data.network.model.ServicePrices;
import com.compastbc.data.network.model.ServicePricesDao;
import com.compastbc.data.network.model.Uom;
import com.compastbc.ui.base.BasePresenter;
import com.compastbc.utils.AppConstants;
import com.compastbc.utils.AppUtils;
import com.compastbc.utils.CalenderUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UomListPresenter<V extends UomListMvpView> extends BasePresenter<V>
        implements UomListMvpPresenter<V> {

    UomListPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void getSaleUom(String programId, String commodityId, int offset) {
        getMvpView().showLoading();
        if (getDataManager().getConfigurableParameterDetail().isOnline()) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("agentId", Integer.parseInt(getDataManager().getUserDetail().getAgentId()));
                jsonObject.put("commodityId", Integer.parseInt(commodityId));
                jsonObject.put("programmeId", programId);
                jsonObject.put("locationId",getDataManager().getUserDetail().getLocationId());
                jsonObject.put("macAddress", getDataManager().getDeviceId());
                jsonObject.put("page", offset);
                jsonObject.put("size", AppConstants.LIMIT);
                RequestBody body = AppUtils.createBody(AppConstants.CONTENT_TYPE_JSON, jsonObject.toString());
                getDataManager().getUomForSales("bearer " + getDataManager().getConfigurationDetail().getAccess_token(), body).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {

                        if (response.code() == 200) {

                            assert response.body() != null;
                            try {
                                List<Uom> beans = new ArrayList<>();
                                JSONObject jsonObject = new JSONObject(response.body().string());
                                JSONArray array = jsonObject.getJSONArray("content");
                                for (int i = 0; i < array.length(); i++) {
                                    Uom bean = new Uom();
                                    bean.setUom(array.getJSONObject(i).getString("uom"));
                                    bean.setMaxPrice(array.getJSONObject(i).getString("maxPrice"));
                                    bean.setCurrency(array.getJSONObject(i).getString("programCurrency"));
                                    bean.setCount(array.getJSONObject(i).getString("totalBeneficiary"));
                                    beans.add(bean);
                                }
                                getMvpView().hideLoading();
                                getMvpView().setData(beans);
                            } catch (Exception e) {
                                getMvpView().hideLoading();
                                getMvpView().showMessage(e.getMessage());
                            }

                        } else if (response.code() == 401) {
                            getMvpView().hideLoading();
                            getMvpView().openActivityOnTokenExpire();
                        } else {
                            try {
                                getMvpView().hideLoading();
                                assert response.errorBody() != null;
                                JSONObject object = new JSONObject(response.errorBody().string());
                                getMvpView().showMessage(object.getString("message"));
                            } catch (Exception e) {
                                getMvpView().hideLoading();
                                getMvpView().showMessage(e.getMessage());
                                e.printStackTrace();
                            }
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {

                        handleApiFailure(call, t);
                    }
                });
            } catch (Exception e) {
                getMvpView().hideLoading();
                getMvpView().showMessage(e.getMessage());
            }

        } else {
            String currency = getProgramCurrency(programId);
            List<ServicePrices> servicePricesList = getDataManager().getDaoSession().getServicePricesDao().queryBuilder().where(ServicePricesDao.Properties.ServiceId.eq(commodityId),
                    ServicePricesDao.Properties.Currency.eq(currency))
                    .limit(AppConstants.LIMIT).offset(offset).list();

            List<Uom> beans = new ArrayList<>();
            for (ServicePrices servicePrices : servicePricesList) {
                Uom bean = new Uom();
                bean.setUom(servicePrices.getUom());
                bean.setMaxPrice(String.valueOf(servicePrices.getMaxPrice()));
                bean.setCurrency(currency);

                Cursor cursor1 = getDataManager().getDaoSession().getDatabase().rawQuery("SELECT * from " + CommoditiesDao.TABLENAME
                        + " where " + CommoditiesDao.Properties.Date.columnName + " = ? and "
                        + CommoditiesDao.Properties.ProductId.columnName + "=? and " + CommoditiesDao.Properties.ProgramId.columnName + "=? and "
                        + CommoditiesDao.Properties.Uom.columnName + "=? and " + CommoditiesDao.Properties.VoidTransaction.columnName + " =? "
                        + " GROUP BY " + CommoditiesDao.Properties.IdentificationNum.columnName, new String[]{
                        CalenderUtils.getDateTime(CalenderUtils.TIMESTAMP_FORMAT, Locale.US), commodityId, programId, servicePrices.getUom(), "0"
                });


                if (cursor1.moveToFirst()) {
                    bean.setCount(String.valueOf(cursor1.getCount()));
                }

                beans.add(bean);
            }

            getMvpView().hideLoading();
            getMvpView().setData(beans);
        }

    }

    @Override
    public Uom getUom(List<Uom> uoms, String uom) {
        getMvpView().showLoading();
        for (int i = 0; i < uoms.size(); i++) {
            if (uoms.get(i).getUom().equalsIgnoreCase(uom)) {
                getMvpView().hideLoading();
                return uoms.get(i);
            }
        }
        getMvpView().hideLoading();
        return null;
    }
}
