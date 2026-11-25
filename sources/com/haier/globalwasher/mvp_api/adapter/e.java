package com.haier.globalwasher.mvp_api.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.haier.globalwasher.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f24785b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f24786c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f24787d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24788e = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f24789a;

    public e(Context context, View view, int i7) {
        if (i7 == 1) {
            this.f24789a = View.inflate(context, R.layout.adapter_base_view, null);
        } else if (i7 == 2) {
            this.f24789a = View.inflate(context, R.layout.adapter_base_view_not_projection, null);
        } else if (i7 == 3) {
            this.f24789a = View.inflate(context, R.layout.adapter_base_view_not_projection_have_padding, null);
        } else if (i7 == 4) {
            this.f24789a = View.inflate(context, R.layout.adapter_base_view_all_not, null);
        } else {
            this.f24789a = View.inflate(context, R.layout.adapter_base_view, null);
        }
        ((LinearLayout) this.f24789a.findViewById(R.id.lly_margin)).addView(view);
        this.f24789a.setTag(this);
    }
}
