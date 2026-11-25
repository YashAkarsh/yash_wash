package com.haier.globalwasher.view.custom_view.mlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

/* JADX INFO: loaded from: classes2.dex */
public class FixItemListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f25862a;

    public FixItemListView(Context context) {
        this(context, null);
    }

    private void a() {
        View view;
        int dividerHeight = getDividerHeight();
        ListAdapter adapter = getAdapter();
        if (adapter == null || this.f25862a <= 0 || adapter.getCount() == 0 || (view = adapter.getView(0, null, this)) == null) {
            return;
        }
        view.measure(0, 0);
        int measuredHeight = view.getMeasuredHeight();
        int count = adapter.getCount();
        int i7 = this.f25862a;
        setLayoutParams(new LinearLayout.LayoutParams(-1, count <= i7 ? (measuredHeight * count) + (dividerHeight * (count - 1)) : (measuredHeight / 4) + (i7 * measuredHeight) + (dividerHeight * (count - 1))));
    }

    public void setFixItemCount(int i7) {
        this.f25862a = i7;
        a();
    }

    public FixItemListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        a();
    }

    public FixItemListView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f25862a = -1;
        setLayerType(1, null);
    }
}
