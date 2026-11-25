package com.haier.globalwasher.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class c extends androidx.viewpager.widget.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<ImageView> f25794e;

    public c(ArrayList<ImageView> arrayList) {
        this.f25794e = arrayList;
    }

    @Override // androidx.viewpager.widget.a
    public void b(ViewGroup viewGroup, int i7, Object obj) {
        viewGroup.removeView(this.f25794e.get(i7));
    }

    @Override // androidx.viewpager.widget.a
    public int e() {
        return this.f25794e.size();
    }

    @Override // androidx.viewpager.widget.a
    public Object j(ViewGroup viewGroup, int i7) {
        viewGroup.addView(this.f25794e.get(i7));
        return this.f25794e.get(i7);
    }

    @Override // androidx.viewpager.widget.a
    public boolean k(View view, Object obj) {
        return view == obj;
    }
}
