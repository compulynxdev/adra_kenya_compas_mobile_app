package com.compastbc.ui.reports.salesbasketreport;

import com.compastbc.data.network.model.SalesBeneficiary;
import com.compastbc.data.network.model.SalesCategoryBean;
import com.compastbc.data.network.model.SalesCommodityBean;
import com.compastbc.data.network.model.SalesProgramBean;
import com.compastbc.data.network.model.Uom;

import java.util.List;

public interface SalesBasketReportCallBack {

    void onReceiveProgrammes(List<SalesProgramBean> programBeans, SalesProgramBean programBean);

    void onReceiveCategories(List<SalesCategoryBean> categoryBeans, SalesCategoryBean categoryBean);

    void onReceiveCommodities(List<SalesCommodityBean> salesCommodityBeans, SalesCommodityBean commodityBean);

    void onReceiveUoms(List<Uom> uomList, Uom uom);

    void onReceiveBeneficiaries(List<SalesBeneficiary> salesBeneficiaryList);

}
