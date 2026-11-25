package com.haier.hailicommontlib.mvp_api.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import c.h0;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<C extends Context, T extends ArrayList> extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    T f26229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    C f26230b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f26231a;

        public a(View view) {
            this.f26231a = view;
            view.setTag(this);
        }
    }

    public b(C c8, T t7) {
        this.f26229a = t7;
        this.f26230b = c8;
    }

    public abstract void a();

    public View b(View view, int i7) {
        return view.findViewById(i7);
    }

    public View c(View view, int i7, View.OnClickListener onClickListener) {
        View viewFindViewById = view.findViewById(i7);
        if (onClickListener != null) {
            viewFindViewById.setOnClickListener(onClickListener);
        }
        return viewFindViewById;
    }

    @h0
    public abstract int d();

    public abstract void e(a aVar, Object obj);

    public abstract Map<Integer, View> f();

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f26229a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i7) {
        return this.f26229a.get(i7);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.f26230b, d(), null);
            aVar = new a(view);
            view.setTag(aVar);
            a();
        } else {
            aVar = (a) view.getTag();
        }
        e(aVar, getItem(i7));
        return view;
    }
}
