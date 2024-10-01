package com.compastbc.ui.cardbalance;

import com.compastbc.data.db.model.Programs;
import com.compastbc.data.network.model.Topups;
import com.compastbc.ui.base.MvpPresenter;

import java.util.List;

public interface CardBalanceMvpPresenter<V extends CardBalanceMvpView> extends MvpPresenter<V> {

    void readCardBalance();

    void findBlockCard(String cardNo);

    void findTopups(String cardNo);

    void findPrograms(List<Integer> programId);

    void createBean(List<Topups> topups, List<Programs> programmesList);
}
