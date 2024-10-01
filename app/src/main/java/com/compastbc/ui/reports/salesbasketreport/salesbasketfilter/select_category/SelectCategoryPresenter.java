package com.compastbc.ui.reports.salesbasketreport.salesbasketfilter.select_category;

import android.content.Context;
import android.database.Cursor;

import androidx.annotation.NonNull;

import com.compastbc.R;
import com.compastbc.data.DataManager;
import com.compastbc.data.db.model.Categories;
import com.compastbc.data.db.model.CategoriesDao;
import com.compastbc.data.db.model.CommoditiesDao;
import com.compastbc.data.db.model.Services;
import com.compastbc.data.db.model.ServicesDao;
import com.compastbc.data.network.model.SalesCategoryBean;
import com.compastbc.ui.base.BasePresenter;
import com.compastbc.utils.AppConstants;
import com.compastbc.utils.AppUtils;
import com.compastbc.utils.CalenderUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectCategoryPresenter<V extends SelectCategoryMvpView> extends BasePresenter<V>
        implements SelectCategoryMvpPresenter<V> {

    private Context context;

    SelectCategoryPresenter(DataManager dataManager, Context context) {
        super(dataManager);
        this.context = context;
    }

    @Override
    public void getSaleCatrgories(String programId, String productId, int offset, String startDate, String endDate) {
        getMvpView().showLoading();
        if (getDataManager().getConfigurableParameterDetail().isOnline()) {
            JSONObject jsonObject = new JSONObject();

            if (getMvpView().isNetworkConnected()) {
                try {
                    jsonObject.put("agentId", Integer.parseInt(getDataManager().getUserDetail().getAgentId()));
                    jsonObject.put("productId", Integer.parseInt(productId));
                    jsonObject.put("programmeId", programId);
                    jsonObject.put("locationId",getDataManager().getUserDetail().getLocationId());
                    jsonObject.put("startDate", startDate.contains("/") ? CalenderUtils.formatDate(startDate, CalenderUtils.TIMESTAMP_FORMAT, CalenderUtils.DATE_FORMAT) : startDate);
                    jsonObject.put("endDate", endDate.contains("/") ? CalenderUtils.formatDate(endDate, CalenderUtils.TIMESTAMP_FORMAT, CalenderUtils.DATE_FORMAT) : endDate);
                    jsonObject.put("macAddress", getDataManager().getDeviceId());
                    jsonObject.put("page", offset);
                    jsonObject.put("size", AppConstants.LIMIT);
                    RequestBody body = AppUtils.createBody(AppConstants.CONTENT_TYPE_JSON, jsonObject.toString());
                    getDataManager().getCategoriesForSales("bearer " + getDataManager().getConfigurationDetail().getAccess_token(), body).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {

                            if (response.code() == 200) {

                                assert response.body() != null;
                                try {
                                    List<SalesCategoryBean> beans = new ArrayList<>();
                                    JSONObject jsonObject = new JSONObject(response.body().string());
                                    JSONArray array = jsonObject.getJSONArray("content");
                                    for (int i = 0; i < array.length(); i++) {
                                        SalesCategoryBean bean = new SalesCategoryBean();
                                        bean.setCategoryName(array.getJSONObject(i).getString("categoryName"));
                                        bean.setCategoryId(array.getJSONObject(i).getString("categoryId"));
                                        bean.setTotalAmount(array.getJSONObject(i).getString("totalAmount"));
                                        bean.setCurrency(array.getJSONObject(i).getString("programCurrency"));
                                        bean.setBeneficiaryCount(array.getJSONObject(i).getString("totalBeneficiary"));
                                        beans.add(bean);
                                    }
                                    getMvpView().hideLoading();
                                    getMvpView().setData(beans);
                                } catch (Exception e) {
                                    getMvpView().hideLoading();
                                    getMvpView().sweetAlert(1, "", e.toString()).setConfirmButton(R.string.Ok, sweetAlertDialog -> {
                                        sweetAlertDialog.dismissWithAnimation();
                                        getMvpView().dismissDialogView();
                                    }).show();

                                }

                            } else if (response.code() == 401) {
                                getMvpView().hideLoading();
                                getMvpView().openActivityOnTokenExpire();
                            } else {
                                try {
                                    getMvpView().hideLoading();
                                    assert response.errorBody() != null;
                                    JSONObject object = new JSONObject(response.errorBody().string());
                                    getMvpView().sweetAlert(1, "", object.getString("message")).setConfirmButton(R.string.Ok, sweetAlertDialog -> {
                                        sweetAlertDialog.dismissWithAnimation();
                                        getMvpView().dismissDialogView();
                                    }).show();

                                } catch (Exception e) {
                                    getMvpView().hideLoading();
                                    getMvpView().showMessage(e.getMessage());
                                    getMvpView().sweetAlert(1, "", e.toString()).setConfirmButton(R.string.Ok, sweetAlertDialog -> {
                                        sweetAlertDialog.dismissWithAnimation();
                                        getMvpView().dismissDialogView();
                                    }).show();

                                }
                            }

                        }

                        @Override
                        public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                            getMvpView().hideLoading();
                            getMvpView().sweetAlert(1, context.getString(R.string.error), t.getMessage() != null && t.getMessage().isEmpty() ? context.getString(R.string.ServerError) : t.getMessage()).setConfirmButton(R.string.Ok, sweetAlertDialog -> {
                                sweetAlertDialog.dismissWithAnimation();
                                getMvpView().dismissDialogView();
                            }).show();

                        }
                    });
                } catch (Exception e) {
                    getMvpView().hideLoading();
                    getMvpView().sweetAlert(1, "", e.toString()).setConfirmButton(R.string.Ok, sweetAlertDialog -> {
                        sweetAlertDialog.dismissWithAnimation();
                        getMvpView().dismissDialogView();
                    }).show();
                }
            }
        } else {
            List<Categories> categoriesList = getDataManager().getDaoSession().getCategoriesDao().queryBuilder().where(CategoriesDao.Properties.ProductId.eq(productId)).limit(AppConstants.LIMIT)
                    .offset(offset).list();
            List<SalesCategoryBean> beans = new ArrayList<>();
            for (Categories category : categoriesList) {
                SalesCategoryBean bean = new SalesCategoryBean();
                bean.setCategoryName(category.getCategoryName());
                bean.setCategoryId(category.getCategoryId());
                double amount = 0.0;
                int count = 0;

                List<Services> servicesList = getDataManager().getDaoSession().getServicesDao().queryBuilder().where(
                        ServicesDao.Properties.CategoryId.eq(category.getCategoryId())).list();

                for (Services services : servicesList) {
                    Cursor cursor = getDataManager().getDaoSession().getDatabase().rawQuery("SELECT sum(" + CommoditiesDao.Properties.TotalAmountChargedByRetailer.columnName + ") from " +
                                    CommoditiesDao.TABLENAME + " where " + CommoditiesDao.Properties.ProductId.columnName + "=? and " + CommoditiesDao.Properties.Date.columnName + " between ? and ? and " + CommoditiesDao.Properties.ProgramId.columnName + "=? and "
                                    + CommoditiesDao.Properties.VoidTransaction.columnName + " =? "
                            , new String[]{services.getServiceId(),
                                    CalenderUtils.formatDate(startDate, CalenderUtils.TIMESTAMP_FORMAT, CalenderUtils.TIMESTAMP_FORMAT),
                                    CalenderUtils.formatDate(endDate, CalenderUtils.TIMESTAMP_FORMAT, CalenderUtils.TIMESTAMP_FORMAT), programId, "0"});

                    if (cursor.moveToFirst()) {
                        amount = amount + cursor.getDouble(0);
                    }

                    Cursor cursor1 = getDataManager().getDaoSession().getDatabase().rawQuery("SELECT * from " + CommoditiesDao.TABLENAME
                            + " where " + CommoditiesDao.Properties.Date.columnName + " between ? and ? and "
                            + CommoditiesDao.Properties.ProductId.columnName + "=? and " + CommoditiesDao.Properties.ProgramId.columnName + "=? and "
                            + CommoditiesDao.Properties.VoidTransaction.columnName + " =? "
                            + " GROUP BY " + CommoditiesDao.Properties.IdentificationNum.columnName, new String[]{
                            CalenderUtils.formatDate(startDate, CalenderUtils.TIMESTAMP_FORMAT, CalenderUtils.TIMESTAMP_FORMAT),
                            CalenderUtils.formatDate(endDate, CalenderUtils.TIMESTAMP_FORMAT, CalenderUtils.TIMESTAMP_FORMAT), services.getServiceId(), programId, "0"
                    });

                    if (cursor1.moveToFirst()) {
                        count = count + cursor1.getCount();
                    }
                }

                bean.setTotalAmount(String.valueOf(amount));
                bean.setCurrency(getProgramCurrency(programId));
                bean.setBeneficiaryCount(String.valueOf(count));
                beans.add(bean);
            }
            getMvpView().hideLoading();
            getMvpView().setData(beans);
        }
    }

    @Override
    public SalesCategoryBean getCategory(List<SalesCategoryBean> salesCategoryBeans, String id) {
        SalesCategoryBean bean;
        getMvpView().showLoading();
        for (int i = 0; i < salesCategoryBeans.size(); i++) {
            if (salesCategoryBeans.get(i).getCategoryId().equalsIgnoreCase(id)) {
                bean = salesCategoryBeans.get(i);
                getMvpView().hideLoading();
                return bean;
            }
        }
        getMvpView().hideLoading();
        return null;
    }
}
