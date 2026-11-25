package com.haier.globalwasher.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.haier.globalwasher.R;
import com.haier.globalwasher.modle.bean.pay.PayListBeen;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class i implements com.haier.globalwasher.mvp_api.adapter.d<PayListBeen, com.haier.globalwasher.mvp_api.adapter.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f25822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<PayListBeen> f25823b;

    public i(Context context, ArrayList<PayListBeen> arrayList) {
        this.f25822a = context;
        this.f25823b = arrayList;
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, PayListBeen payListBeen) {
        bVar.b(R.id.tv_coupon_number, R.id.tv_coupon_name, R.id.tv_coupon_end_time);
        FontTextView fontTextView = (FontTextView) bVar.a(R.id.tv_coupon_name);
        FontTextView fontTextView2 = (FontTextView) bVar.a(R.id.tv_coupon_end_time);
        fontTextView.setText(payListBeen.getDisplyName() + "");
        if (!"2".equals(payListBeen.getId()) || !payListBeen.isSelectContent()) {
            fontTextView2.setVisibility(8);
            fontTextView.setTextSize(13.0f);
            fontTextView.setTextColor(context.getResources().getColor(R.color.app_text, null));
            return;
        }
        fontTextView.setTextSize(17.0f);
        fontTextView.setTextColor(context.getResources().getColor(R.color.app_black_6, null));
        if (payListBeen.isSelectContent()) {
            fontTextView2.setVisibility(0);
            fontTextView2.setText(context.getResources().getString(R.string.discount_coupon_ends) + " " + payListBeen.getEndTime());
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this.f25822a, View.inflate(this.f25822a, R.layout.pay_page_preferential_item, null), 4);
    }
}
