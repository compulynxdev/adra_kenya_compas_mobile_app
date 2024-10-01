package com.compastbc.ui.base;

public interface ClickListener extends ItemClickListener {
    void onEditClick(int pos);

    void onDeleteClick(int pos);
}
