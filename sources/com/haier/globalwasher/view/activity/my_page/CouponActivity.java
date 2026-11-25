package com.haier.globalwasher.view.activity.my_page;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c.t0;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.CouponPageBeen;
import com.haier.globalwasher.modle.enum_.c;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.mvp_api.adapter.b;
import com.haier.globalwasher.mvp_api.adapter.d;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class CouponActivity extends BaseListActivity<CouponPageBeen> implements d<CouponPageBeen, b> {
    XListView B;
    private Resources C;
    private com.haier.globalwasher.presenter.b D = new com.haier.globalwasher.presenter.b();
    private com.haier.globalwasher.mvp_api.adapter.a<CouponPageBeen, b> E;

    class a extends BaseListActivity<CouponPageBeen>.a {
        a() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<CouponPageBeen> arrayList) {
            if (CouponActivity.this.E != null) {
                CouponActivity.this.E.notifyDataSetChanged();
                return;
            }
            CouponActivity couponActivity = CouponActivity.this;
            CouponActivity couponActivity2 = CouponActivity.this;
            couponActivity.E = new com.haier.globalwasher.mvp_api.adapter.a(couponActivity2, arrayList, couponActivity2);
            CouponActivity couponActivity3 = CouponActivity.this;
            couponActivity3.B.setAdapter((ListAdapter) couponActivity3.E);
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_coupon;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.D;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        this.B = (XListView) findViewById(R.id.xlv_coupon);
        d0(getResources().getString(R.string.my_page_coupon), 1, new View[0]);
        this.C = getResources();
        V(getResources().getString(R.string.no_coupon_msg));
        return this.B;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.D.i(i8, i7, new a());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    @t0(api = 16)
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, b bVar, CouponPageBeen couponPageBeen) {
        bVar.b(R.id.lly_background, R.id.tv_coupon_name, R.id.tv_price, R.id.tv_fuhao, R.id.tv_time);
        String string = context.getResources().getString(R.string.discount_coupon_ends);
        TextView textView = (TextView) bVar.a(R.id.tv_coupon_name);
        TextView textView2 = (TextView) bVar.a(R.id.tv_price);
        TextView textView3 = (TextView) bVar.a(R.id.tv_fuhao);
        TextView textView4 = (TextView) bVar.a(R.id.tv_time);
        textView.setText(this.C.getString(c.e(couponPageBeen.getCouponCode()).d()) + "/\n" + this.C.getString(R.string.discount_coupon_code_SELF_COMMON));
        textView2.setText(couponPageBeen.getCouponValue());
        textView3.setText(couponPageBeen.getCurrencySymbol());
        if (TextUtils.isEmpty(couponPageBeen.getValidityEndTime())) {
            textView4.setText(this.C.getString(R.string.Nearby_laundry_expires));
            return;
        }
        textView4.setText(string + " " + d0.b(couponPageBeen.getValidityEndTime(), "yyyy-MM-dd"));
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public b x(int i7, ViewGroup viewGroup) {
        return new b(this, View.inflate(this, R.layout.coupon_item, null), 2);
    }
}
