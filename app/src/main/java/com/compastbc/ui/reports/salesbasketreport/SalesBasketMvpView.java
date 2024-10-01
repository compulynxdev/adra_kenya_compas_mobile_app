package com.compastbc.ui.reports.salesbasketreport;

import com.compastbc.ui.base.MvpView;
import com.compastbc.utils.print.PrintServices;

public interface SalesBasketMvpView extends MvpView {

    void doPrintOperation(PrintServices printUtils);

}
