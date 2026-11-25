package com.haier.globalwasher.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.haier.globalwasher.modle.bean.advertis.AdertisView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b extends androidx.viewpager.widget.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<AdertisView> f25793e;

    public b(ArrayList<AdertisView> arrayList) {
        this.f25793e = arrayList;
    }

    @Override // androidx.viewpager.widget.a
    public void b(ViewGroup viewGroup, int i7, Object obj) {
        viewGroup.removeView(this.f25793e.get(i7).getMediaView());
    }

    @Override // androidx.viewpager.widget.a
    public int e() {
        return this.f25793e.size();
    }

    @Override // androidx.viewpager.widget.a
    public Object j(ViewGroup viewGroup, int i7) {
        viewGroup.addView(this.f25793e.get(i7).getMediaView());
        return this.f25793e.get(i7).getMediaView();
    }

    @Override // androidx.viewpager.widget.a
    public boolean k(View view, Object obj) {
        return view == obj;
    }
}
