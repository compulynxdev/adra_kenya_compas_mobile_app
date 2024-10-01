package com.compastbc.ui.cardrestore.restore;


import com.compastbc.data.db.model.NFCCardData;

interface CardDataRestoreMvpPresenter<V extends CardDataRestoreMvpView> {
    void doCardDataRestore(NFCCardData nfcCardDataBean);
}
