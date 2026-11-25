package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class p extends LinearLayoutManager {
    private static final float O = 100.0f;

    class a extends androidx.recyclerview.widget.q {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.q
        protected float w(DisplayMetrics displayMetrics) {
            return p.O / displayMetrics.densityDpi;
        }
    }

    p(Context context, int i7, boolean z7) {
        super(context, i7, z7);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void f2(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i7) {
        a aVar = new a(recyclerView.getContext());
        aVar.q(i7);
        g2(aVar);
    }
}
