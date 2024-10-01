package com.compastbc.ui.reports;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.compastbc.R;
import com.compastbc.ui.base.BaseActivity;
import com.compastbc.ui.reports.commodityreport.CommodityReportActivity;
import com.compastbc.ui.reports.sales_transaction_history.SalesTransactionHistoryReportActivity;
import com.compastbc.ui.reports.salesbasketreport.SalesBasketReport;
import com.compastbc.ui.reports.submit_report.SubmitTransactionReportActivity;
import com.compastbc.ui.reports.summary.SummaryReportActivity;
import com.compastbc.ui.reports.sync_report.SyncReportActivity;
import com.compastbc.ui.reports.vendor_summary.VendorSummaryReport;
import com.compastbc.ui.reports.void_transaction_report.VoidReportActivity;
import com.compastbc.ui.reports.xreport.XReportActivity;

public class ReportActivity extends BaseActivity implements ReportsMvpView, View.OnClickListener {
    private CardView submitReport, salesReport, syncReport;
    //private CardView voidReport;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, ReportActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        ReportsPresenter<ReportsMvpView> mvpPresenter = new ReportsPresenter<>(getDataManager());
        mvpPresenter.onAttach(this);
        setUp();
    }

    @Override
    protected void setUp() {
        findIds();
        CardView cvVendorSummaryReport = findViewById(R.id.cv_vendor_summary_report);
        setOnClickListeners(findViewById(R.id.cv_summary_report), findViewById(R.id.cv_xreports_card), findViewById(R.id.cv_commodity_report),
                findViewById(R.id.cv_sales_trans_history), submitReport, syncReport, salesReport, cvVendorSummaryReport/*, voidReport*/);

        salesReport.setVisibility(getDataManager().getConfigurableParameterDetail().isSalesReport() ? View.VISIBLE : View.GONE);
        //voidReport.setVisibility(getDataManager().getConfigurableParameterDetail().isVoidTransaction() ? View.VISIBLE : View.GONE);
        submitReport.setVisibility(getDataManager().getConfigurableParameterDetail().isOnline() ? View.GONE : View.VISIBLE);

        if (!getDataManager().getConfigurableParameterDetail().isOnline() && getDataManager().getUserDetail().getLevel().equalsIgnoreCase("2"))
            syncReport.setVisibility(View.VISIBLE);

        if (!getDataManager().getUserDetail().getLevel().equalsIgnoreCase("2")) {
            cvVendorSummaryReport.setVisibility(View.VISIBLE);
        }

    }

    private void setOnClickListeners(View... views) {
        for (View view : views) {
            view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                onBackPressed();
                break;

            case R.id.cv_summary_report:
                createLog("Report Activity", "Summary Selected");
                startActivity(SummaryReportActivity.getStartIntent(ReportActivity.this));
                break;

            case R.id.cv_vendor_summary_report:
                createLog("Report Activity", "Vendor Summary Selected");
                startActivity(VendorSummaryReport.getStartIntent(ReportActivity.this));
                break;

            case R.id.cv_xreports_card:
                createLog("Report Activity", "X report Selected");
                startActivity(XReportActivity.getStartIntent(ReportActivity.this));
                break;

            case R.id.cv_commodity_report:
                createLog("Report Activity", "Commodity Report Selected");
                startActivity(CommodityReportActivity.getStartIntent(ReportActivity.this));
                break;

            case R.id.cv_submitreport:
                createLog("Report Activity", "Submit report Selected");
                startActivity(SubmitTransactionReportActivity.getStartIntent(ReportActivity.this));
                break;

            case R.id.cv_sync_report:
                createLog("Report Activity", "Sync report Selected");
                startActivity(SyncReportActivity.getStartIntent(ReportActivity.this));
                break;

            case R.id.cv_salesBasket:
                createLog("Report Activity", "Sales Basket report Selected");
                startActivity(SalesBasketReport.getStartIntent(ReportActivity.this));
                break;

            case R.id.cv_sales_trans_history:
                createLog("Report Activity", "Sales/transaction history Selected");
                startActivity(SalesTransactionHistoryReportActivity.getStartIntent(ReportActivity.this));
                break;

            case R.id.cv_void_transaction:
                createLog("Report Activity", "Void transaction Selected");
                startActivity(VoidReportActivity.getStartIntent(ReportActivity.this));
                break;
        }
    }

    private void findIds() {
        TextView title = findViewById(R.id.tvTitle);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title.setText(R.string.reports);
        ImageView img_back = findViewById(R.id.img_back);
        img_back.setVisibility(View.VISIBLE);
        img_back.setOnClickListener(this);

        submitReport = findViewById(R.id.cv_submitreport);
        salesReport = findViewById(R.id.cv_salesBasket);
        //voidReport = findViewById(R.id.cv_void_transaction);
        syncReport = findViewById(R.id.cv_sync_report);
    }
}
