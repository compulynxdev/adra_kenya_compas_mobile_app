package com.compastbc.ui.reports.salesbasketreport.uoms;

import com.compastbc.data.network.model.Uom;
import com.compastbc.ui.base.MvpPresenter;

import java.util.List;

public interface UomListMvpPresenter<V extends UomListMvpView> extends MvpPresenter<V> {

    void getSaleUom(String programId, String commodityId, int offset);

    Uom getUom(List<Uom> uoms, String uom);


}
