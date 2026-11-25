package com.haier.globalwasher.mvp_api.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class b extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SparseArray<View> f24778f;

    public b(Context context, View view, int i7) {
        super(context, view, i7);
        this.f24778f = new SparseArray<>();
    }

    public <V> V a(int i7) {
        return (V) this.f24778f.get(i7);
    }

    public void b(int... iArr) {
        for (int i7 : iArr) {
            if (this.f24778f.get(i7) == null) {
                this.f24778f.remove(i7);
                this.f24778f.put(i7, this.f24789a.findViewById(i7));
            }
        }
    }
}
