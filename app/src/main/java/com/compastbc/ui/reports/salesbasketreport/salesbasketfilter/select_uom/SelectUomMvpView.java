package com.compastbc.ui.reports.salesbasketreport.salesbasketfilter.select_uom;

import com.compastbc.data.network.model.Uom;
import com.compastbc.ui.base.MvpView;

import java.util.List;

public interface SelectUomMvpView extends MvpView {
    void setData(List<Uom> data);

    void dismissDialogView();
}
