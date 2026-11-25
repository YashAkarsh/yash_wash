package com.haier.globalwasher.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.LaundryActivityInfo;
import com.haier.globalwasher.view.custom_view.FontTextView;
import com.haier.globalwasher.view.custom_view.viewgroup.RoundBGLinerLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class h extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f25810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<LaundryActivityInfo> f25811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Drawable f25812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Drawable f25813d;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private RoundBGLinerLayout f25814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ImageView f25815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private FontTextView f25816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private FontTextView f25817d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private FontTextView f25818e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private FontTextView f25819f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private FontTextView f25820g;

        private a() {
        }
    }

    public h(Context context, ArrayList<LaundryActivityInfo> arrayList) {
        this.f25810a = context;
        this.f25811b = arrayList;
        this.f25812c = context.getResources().getDrawable(R.drawable.activity_type_name_discount, null);
        this.f25813d = context.getResources().getDrawable(R.drawable.activity_type_name_coupons, null);
    }

    private void a(a aVar, View view) {
        aVar.f25814a = (RoundBGLinerLayout) view.findViewById(R.id.rbg_lly_coupon);
        aVar.f25815b = (ImageView) view.findViewById(R.id.iv_activity_type);
        aVar.f25816c = (FontTextView) view.findViewById(R.id.tv_activity_content);
        aVar.f25817d = (FontTextView) view.findViewById(R.id.tv_activity_single_introduction);
        aVar.f25818e = (FontTextView) view.findViewById(R.id.tv_activity_introduction);
        aVar.f25819f = (FontTextView) view.findViewById(R.id.tv_activity_end_time);
        aVar.f25820g = (FontTextView) view.findViewById(R.id.tv_activity_use);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f25811b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i7) {
        return this.f25811b.get(i7);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"SetTextI18n"})
    public View getView(int i7, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.f25810a, R.layout.adapter_laundry_activity_at_popupwindow, null);
            aVar = new a();
            view.setTag(aVar);
            a(aVar, view);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f25815b.setImageDrawable(1 == this.f25811b.get(i7).getType() ? this.f25812c : this.f25813d);
        aVar.f25816c.setText(this.f25811b.get(i7).getDiscountValues());
        aVar.f25817d.setText(this.f25811b.get(i7).getExplain());
        aVar.f25818e.setText(this.f25811b.get(i7).getTitle());
        aVar.f25819f.setText(this.f25810a.getResources().getString(R.string.laundry_activity_list_valid_till) + this.f25811b.get(i7).getEndDate());
        return view;
    }
}
