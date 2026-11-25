package com.haier.globalwasher.view.activity.order;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import c.t0;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.CouponPageBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.mvp_api.adapter.d;
import com.haier.globalwasher.presenter.o;
import com.haier.globalwasher.view.activity.pay.OrderPayActivity;
import com.haier.globalwasher.view.custom_view.FontTextView;
import com.haier.globalwasher.view.custom_view.xlist.XListView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class PayCouponActivity extends BaseListActivity<CouponPageBeen> implements d<CouponPageBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    XListView C;
    FontTextView D;
    FontTextView E;
    private com.haier.globalwasher.mvp_api.adapter.a<CouponPageBeen, com.haier.globalwasher.mvp_api.adapter.b> F;
    CouponPageBeen G;
    private String H;
    private String I;
    private o B = new o();

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private String f25737J = "";
    ArrayList<CouponPageBeen> K = new ArrayList<>();

    class a extends BaseListActivity<CouponPageBeen>.a {
        a() {
            super();
        }

        @Override // com.haier.globalwasher.base.BaseListActivity.a
        public void f(ArrayList<CouponPageBeen> arrayList) {
            PayCouponActivity.this.K.clear();
            PayCouponActivity.this.K.addAll(arrayList);
            if (PayCouponActivity.this.F != null) {
                PayCouponActivity.this.F.notifyDataSetChanged();
                return;
            }
            PayCouponActivity payCouponActivity = PayCouponActivity.this;
            PayCouponActivity payCouponActivity2 = PayCouponActivity.this;
            payCouponActivity.F = new com.haier.globalwasher.mvp_api.adapter.a(payCouponActivity2, payCouponActivity2.K, payCouponActivity2);
            PayCouponActivity payCouponActivity3 = PayCouponActivity.this;
            payCouponActivity3.C.setAdapter((ListAdapter) payCouponActivity3.F);
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f25739a;

        b(int i7) {
            this.f25739a = i7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            for (int i7 = 0; i7 < PayCouponActivity.this.K.size(); i7++) {
                if (i7 == this.f25739a) {
                    PayCouponActivity.this.K.get(i7).setSelect(!PayCouponActivity.this.K.get(i7).isSelect());
                } else {
                    PayCouponActivity.this.K.get(i7).setSelect(false);
                }
            }
            PayCouponActivity.this.C.setOnItemClickListener(null);
            Intent intent = new Intent(PayCouponActivity.this, (Class<?>) OrderPayActivity.class);
            intent.putExtra(o.G, PayCouponActivity.this.K.get(this.f25739a));
            PayCouponActivity.this.setResult(1003, intent);
            PayCouponActivity.this.finish();
        }
    }

    class c implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinearLayout f25741a;

        c(LinearLayout linearLayout) {
            this.f25741a = linearLayout;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
            this.f25741a.performClick();
        }
    }

    public static void u0(String str, String str2, CouponPageBeen couponPageBeen, BaseActivity baseActivity) {
        Intent intent = new Intent(baseActivity, (Class<?>) PayCouponActivity.class);
        intent.putExtra(o.G, couponPageBeen);
        intent.putExtra(o.f25218y, str);
        intent.putExtra("deviceType", str2);
        baseActivity.startActivityForResult(intent, 1002);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_pay_coupon;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public com.haier.globalwasher.mvp_api.presenter.b l0() {
        return this.B;
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        d0(getResources().getString(R.string.barrels_of_clean_coupon), 1, new View[0]);
        Intent intent = getIntent();
        this.G = (CouponPageBeen) intent.getSerializableExtra(o.G);
        this.H = intent.getStringExtra(o.f25218y);
        this.I = intent.getStringExtra("deviceType");
        this.D = (FontTextView) findViewById(R.id.title);
        this.C = (XListView) findViewById(R.id.xlv_coupon);
        this.E = (FontTextView) S(R.id.tv_is_use, true);
        return this.C;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_is_use) {
            for (int i7 = 0; i7 < this.K.size(); i7++) {
                this.K.get(i7).setSelect(false);
            }
            com.haier.globalwasher.mvp_api.adapter.a<CouponPageBeen, com.haier.globalwasher.mvp_api.adapter.b> aVar = this.F;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
            setResult(1003, new Intent(this, (Class<?>) OrderPayActivity.class));
            finish();
        }
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        if (this.I.charAt(0) == '1') {
            this.f25737J = "washCoupon";
        } else if (this.I.charAt(0) == '2') {
            this.f25737J = "shoeCoupon";
        } else if (this.I.charAt(0) == '3') {
            this.f25737J = "dryCoupon";
        } else {
            this.f25737J = "";
        }
        this.B.n(i7, i8, this.H, this.f25737J, new a());
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    @t0(api = 16)
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, CouponPageBeen couponPageBeen) {
        bVar.b(R.id.tv_coupon_name, R.id.tv_endTime, R.id.cb_selelct_pay, R.id.lly_margin);
        FontTextView fontTextView = (FontTextView) bVar.a(R.id.tv_coupon_name);
        CheckBox checkBox = (CheckBox) bVar.a(R.id.cb_selelct_pay);
        if (couponPageBeen == null || TextUtils.isEmpty(couponPageBeen.getValidityEndTime())) {
            fontTextView.setText(couponPageBeen.getCurrencySymbol() + " " + couponPageBeen.getCouponValue() + " " + context.getResources().getString(R.string.Nearby_laundry_expires));
        } else {
            fontTextView.setText(couponPageBeen.getCurrencySymbol() + " " + couponPageBeen.getCouponValue() + " " + d0.b(couponPageBeen.getValidityEndTime(), "yyyy-MM-dd"));
        }
        CouponPageBeen couponPageBeen2 = this.G;
        if (couponPageBeen2 != null && couponPageBeen2.getCouponId() == couponPageBeen.getCouponId()) {
            couponPageBeen.setSelect(true);
        }
        checkBox.setSelected(couponPageBeen.isSelect());
        LinearLayout linearLayout = (LinearLayout) bVar.a(R.id.lly_margin);
        if (couponPageBeen.isSelect()) {
            linearLayout.setBackground(context.getResources().getDrawable(R.drawable.pay_item_blue));
        } else {
            linearLayout.setBackground(context.getResources().getDrawable(R.drawable.cardview_background));
        }
        linearLayout.setOnClickListener(new b(i7));
        checkBox.setOnCheckedChangeListener(new c(linearLayout));
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.pay_coupons_item, null), 1);
    }
}
