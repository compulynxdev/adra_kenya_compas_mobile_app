package com.compastbc.ui.reports.salesbasketreport.salesbasketfilter.select_uom;

import com.compastbc.data.network.model.Uom;
import com.compastbc.ui.base.MvpPresenter;

import java.util.List;

public interface SelectUomMvpPresenter<V extends SelectUomMvpView> extends MvpPresenter<V> {
    void getSaleUom(String programId, String commodityId, int offset, String startDate, String endDate);

    Uom getUom(List<Uom> uoms, String uom);
}
