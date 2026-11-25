package com.haier.globalwasher.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.LaundryActivityInfo;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class f extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f25805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<LaundryActivityInfo> f25806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Resources f25807c;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f25808a;

        public a() {
        }
    }

    public f(Context context, ArrayList<LaundryActivityInfo> arrayList) {
        this.f25805a = context;
        this.f25806b = arrayList;
        this.f25807c = context.getResources();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f25806b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i7) {
        return this.f25806b.get(i7);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.f25805a, R.layout.adapter_laundry_at_detail_activity, null);
            aVar = new a();
            view.setTag(aVar);
            aVar.f25808a = (FontTextView) view.findViewById(R.id.ftv_content_);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f25808a.setText(this.f25806b.get(i7).getTypeTitle() + ":" + this.f25806b.get(i7).getDiscountValues());
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i7) {
        return false;
    }
}
