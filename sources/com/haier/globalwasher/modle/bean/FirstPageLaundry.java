package com.haier.globalwasher.modle.bean;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class FirstPageLaundry {
    private Drawable drawable;
    private boolean isSelect;
    private String title;

    public FirstPageLaundry(String str, Drawable drawable, boolean z7) {
        this.title = str;
        this.drawable = drawable;
        this.isSelect = z7;
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void setSelect(boolean z7) {
        this.isSelect = z7;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
