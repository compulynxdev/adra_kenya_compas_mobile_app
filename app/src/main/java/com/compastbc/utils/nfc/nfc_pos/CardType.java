package com.compastbc.utils.nfc.nfc_pos;

/**
 * Created by Hemant Sharma on 25-09-19.
 * Divergent software labs pvt. ltd
 */
public enum CardType {
    /**
     * mag-stripe mode
     */
    INMODE_MAG(0x02),

    /**
     * insert card mode
     */
    INMODE_IC(0x08),

    /**
     * contactless card mode
     */
    INMODE_NFC(0x10);

    private int val;

    CardType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}