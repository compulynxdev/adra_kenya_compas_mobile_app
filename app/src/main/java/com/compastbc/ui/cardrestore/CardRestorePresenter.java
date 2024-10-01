package com.compastbc.ui.cardrestore;

import com.compastbc.data.DataManager;
import com.compastbc.data.db.model.NFCCardData;
import com.compastbc.ui.base.BasePresenter;

import java.util.List;

class CardRestorePresenter<V extends CardRestoreMvpView> extends BasePresenter<V>
        implements CardRestoreMvpPresenter<V> {

    CardRestorePresenter(DataManager dataManager) {
        super(dataManager);
    }

    public List<NFCCardData> getNFCCardList() {
        return getDataManager().getDaoSession().getNFCCardDataDao().loadAll();
    }
}
