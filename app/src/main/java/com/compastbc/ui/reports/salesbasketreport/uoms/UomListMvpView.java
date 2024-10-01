package com.compastbc.ui.reports.salesbasketreport.uoms;

import com.compastbc.data.network.model.Uom;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface UomListMvpView extends MvpView {
    void setData(List<Uom> data);
}
