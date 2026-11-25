package com.haier.globalwasher.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.l;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.LaundryActivityInfo;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f25795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<LaundryActivityInfo> f25796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Resources f25797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, Bitmap> f25798d = new HashMap();

    class a extends com.bumptech.glide.request.target.j<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f25799d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f25800e;

        a(String str, ImageView imageView) {
            this.f25799d = str;
            this.f25800e = imageView;
        }

        @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.m
        public void c(Exception exc, Drawable drawable) {
            super.c(exc, drawable);
            this.f25800e.setImageDrawable(d.this.f25797c.getDrawable(R.drawable.icon_commonmix));
        }

        @Override // com.bumptech.glide.request.target.m
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, com.bumptech.glide.request.animation.e<? super Bitmap> eVar) {
            if (bitmap != null) {
                try {
                    if (this.f25799d.equals(this.f25800e.getTag())) {
                        d.this.f25798d.put(this.f25799d, bitmap);
                        this.f25800e.setImageBitmap(bitmap);
                    }
                } catch (Exception e8) {
                    q.c("", e8.toString());
                    return;
                }
            }
            d.this.notifyDataSetChanged();
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f25802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        TextView f25803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ImageView f25804c;

        private b() {
        }
    }

    public d(Context context, ArrayList<LaundryActivityInfo> arrayList) {
        this.f25795a = context;
        this.f25796b = arrayList;
        this.f25797c = context.getResources();
    }

    public void a(String str, ImageView imageView) {
        if (str == null) {
            return;
        }
        imageView.setTag(str);
        if (this.f25798d.get(str) != null) {
            imageView.setImageBitmap(this.f25798d.get(str));
        } else {
            q.c("loadDrawable", str);
            l.M(this.f25795a).E(str).L0().F(new a(str, imageView));
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f25796b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i7) {
        return this.f25796b.get(i7);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.f25795a, R.layout.adapter_laundry_list_activity, null);
            bVar = new b();
            view.setTag(bVar);
            bVar.f25804c = (ImageView) view.findViewById(R.id.iv_activity_lft_img);
            bVar.f25802a = (FontTextView) view.findViewById(R.id.ftv_content);
            bVar.f25803b = (FontTextView) view.findViewById(R.id.ftv_time);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f25803b.setText(this.f25796b.get(i7).getEndDate() + " " + this.f25797c.getString(R.string.Nearby_laundry_activity_end));
        bVar.f25802a.setText(this.f25796b.get(i7).getTitle());
        a(this.f25796b.get(i7).getActivityPicUrl(), bVar.f25804c);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i7) {
        return false;
    }
}
