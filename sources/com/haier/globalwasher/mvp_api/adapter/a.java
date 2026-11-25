package com.haier.globalwasher.mvp_api.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.haier.globalwasher.R;
import com.haier.globalwasher.mvp_api.adapter.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a<T, H extends e> extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<T> f24774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d<T, H> f24775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f24776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f24777d;

    public a(Context context, d<T, H> dVar) {
        this(context, new ArrayList(), dVar);
    }

    public void a(List<T> list) {
        if (list != null) {
            this.f24774a.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void b(List<T> list) {
        this.f24774a.clear();
        a(list);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f24774a.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i7) {
        return this.f24774a.get(i7);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        e eVar;
        if (view == null) {
            e eVarX = this.f24775b.x(i7, viewGroup);
            eVar = eVarX;
            view = eVarX.f24789a;
        } else {
            eVar = (e) view.getTag();
        }
        View viewFindViewById = view.findViewById(R.id.v_padding);
        if (viewFindViewById != null) {
            if (i7 == 0) {
                viewFindViewById.setVisibility(0);
            } else {
                viewFindViewById.setVisibility(8);
            }
        }
        this.f24775b.i(this.f24776c, i7, eVar, getItem(i7));
        return view;
    }

    public a(Context context, List<T> list, d<T, H> dVar) {
        this.f24777d = "BaseListAdapter";
        this.f24774a = list == null ? new ArrayList<>() : list;
        this.f24775b = dVar;
        this.f24776c = context;
    }
}
