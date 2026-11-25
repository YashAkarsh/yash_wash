package com.haier.globalwasher.view.custom_view.xlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* JADX INFO: loaded from: classes2.dex */
public class XListViewForScroll extends ListView {
    public XListViewForScroll(Context context) {
        super(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public XListViewForScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public XListViewForScroll(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
    }
}
