package com.compastbc.ui.reports.salesbasketreport.salesbasketfilter.select_commodity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.compastbc.R;
import com.compastbc.data.network.model.SalesCommodityBean;
import com.compastbc.ui.base.BaseDialog;
import com.compastbc.ui.base.BaseFilterSalesReport;
import com.compastbc.utils.AppConstants;
import com.compastbc.utils.pagination.RecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;


public class SelectCommodity extends BaseDialog implements SelectCommodityMvpView, SelectCommodityAdapter.ItemClickListener {
    private static OnFragmentInteractionListener interactionListener;
    private static String startDate, endDate;
    private LinearLayout linearLayout;
    private int offset = 0;
    private SelectCommodityAdapter adapter;
    private List<SalesCommodityBean> list;
    private SelectCommodityMvpPresenter<SelectCommodityMvpView> mvpPresenter;

    public static SelectCommodity newInstance(OnFragmentInteractionListener listener, String stDate, String eDate) {
        SelectCommodity fragment = new SelectCommodity();
        Bundle args = new Bundle();
        startDate = stDate;
        endDate = eDate;
        fragment.setArguments(args);
        interactionListener = listener;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_commodity, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    @Override
    protected void setUp(View view) {
        mvpPresenter = new SelectCommodityPresenter<>(getDataManager(), getBaseActivity());
        mvpPresenter.onAttach(this);
        showLoading();
        list = new ArrayList<>();
        adapter = new SelectCommodityAdapter(list);
        adapter.setClickListener(this);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        linearLayout = view.findViewById(R.id.linear);
        mvpPresenter.getSaleCommodities(BaseFilterSalesReport.getProgrammeId(), BaseFilterSalesReport.getProductId(), BaseFilterSalesReport.getCategoryId(), offset, startDate, endDate);
        recyclerView.setAdapter(adapter);
        RecyclerViewScrollListener scrollListener = new RecyclerViewScrollListener() {
            @Override
            public void onLoadMore() {
                adapter.showLoading(true);
                adapter.notifyDataSetChanged();
                if (getDataManager().getConfigurableParameterDetail().isOnline())
                    offset += 1;
                else offset += AppConstants.LIMIT;
                mvpPresenter.getSaleCommodities(BaseFilterSalesReport.getProgrammeId(), BaseFilterSalesReport.getProductId(), BaseFilterSalesReport.getCategoryId(), offset, startDate, endDate);
            }
        };
        recyclerView.addOnScrollListener(scrollListener);
        ViewGroup frame = view.findViewById(R.id.frame);
        frame.setOnClickListener(v -> dismissDialog("Select Commodity"));
    }

    @Override
    public void onItemClick(String id) {

        if (interactionListener != null) {
            String[] ids = id.split(",");
            SalesCommodityBean bean = mvpPresenter.getCommodity(list, ids[0]);
          /*  if(bean.getCommodityType().equalsIgnoreCase("Commodity")){
                dismissDialog("Select Commodity");
                interactionListener.onFragmenXtInteraction(list,id,bean);
            }else {
                dismissDialog("Select Commodity");
                showMessage(R.string.YouSelectedTheCashCommodity);
            }*/
            String uom = mvpPresenter.getCashCurrency(BaseFilterSalesReport.getProgrammeId());
            dismissDialog("Select Commodity");
            interactionListener.onFragmentInteraction(list, id, bean, bean.getCommodityType(), uom);

        }

    }

    @Override
    public void setData(List<SalesCommodityBean> data) {
        adapter.showLoading(false);
        adapter.notifyDataSetChanged();

        list.addAll(data);

        if (list.size() > 0) {
            linearLayout.setVisibility(View.VISIBLE);
            adapter.notifyDataSetChanged();
        } else {
            sweetAlert(1, R.string.error, R.string.NoCommodity).setConfirmButton(R.string.Ok, sweetAlertDialog -> {
                sweetAlertDialog.dismissWithAnimation();
                dismissDialog("Select Commodity");
            }).show();

        }
    }

    @Override
    public void dismissDialogView() {
        dismissDialog("Select Commodity");
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(List<SalesCommodityBean> list, String id, SalesCommodityBean bean, String commodityType, String cashUom);
    }
}
