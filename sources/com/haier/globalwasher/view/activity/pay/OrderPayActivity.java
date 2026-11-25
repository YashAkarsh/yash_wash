package com.haier.globalwasher.view.activity.pay;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import c.m0;
import c.t0;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.base.BaseListActivity;
import com.haier.globalwasher.modle.bean.BluetoothInfoBean;
import com.haier.globalwasher.modle.bean.ClearBucketBeen;
import com.haier.globalwasher.modle.bean.CountDownBeen;
import com.haier.globalwasher.modle.bean.CouponPageBeen;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.modle.bean.UBluetoothBean;
import com.haier.globalwasher.modle.bean.discount.CounponSelectReturnBean;
import com.haier.globalwasher.modle.bean.discount.DisCountInfo;
import com.haier.globalwasher.modle.bean.pay.PayListBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.mvp_api.moudle.BaseBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver;
import com.haier.globalwasher.presenter.o;
import com.haier.globalwasher.view.activity.order.OrderIsPaidToRunActivity;
import com.haier.globalwasher.view.activity.order.PayCouponActivity;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class OrderPayActivity extends BaseListActivity<PayListBeen> implements com.haier.globalwasher.mvp_api.adapter.d<PayListBeen, com.haier.globalwasher.mvp_api.adapter.b> {
    private FontTextView C;
    private ListView D;
    private com.haier.globalwasher.modle.utils.bluetoothutil.a.g D0;
    private ListView E;
    k E0;
    private com.haier.globalwasher.mvp_api.adapter.a<PayListBeen, com.haier.globalwasher.mvp_api.adapter.b> F;
    private FontTextView H;
    private FontTextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private FontTextView f25760J;
    private com.haier.globalwasher.mvp_api.adapter.a<PayListBeen, com.haier.globalwasher.mvp_api.adapter.b> K;
    private Resources O;
    private CountDownBroadcastReceiver Q;
    private OrderDetailsBeen R;
    private View T;
    private String U;
    private o B = new o();
    private String G = "OrderPayActivity";
    ArrayList<DisCountInfo> L = new ArrayList<>();
    private String M = "";
    private int N = 0;
    private int P = 2;
    private long S = 0;
    private ArrayList<PayListBeen> V = new ArrayList<>();
    private ArrayList<PayListBeen> W = new ArrayList<>();
    m X = new m();
    private String Y = "0";
    private final String Z = "0";
    private CouponPageBeen A0 = null;
    private int B0 = 0;
    private String C0 = null;
    private boolean F0 = true;
    boolean G0 = false;
    l H0 = new l();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25761a;

        static {
            int[] iArr = new int[com.jiao.project.bluetoothofabroadwasherapp.enums.d.values().length];
            f25761a = iArr;
            try {
                iArr[com.jiao.project.bluetoothofabroadwasherapp.enums.d.STATUS_READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    class b extends CountDownBroadcastReceiver {
        b() {
        }

        /* JADX WARN: Code duplicated, block: B:28:0x01aa  */
        @Override // com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver
        @t0(api = 16)
        @TargetApi(21)
        public void a(ArrayList<CountDownBeen> arrayList) {
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                if (arrayList.get(i7).getWashOrderId().equals(OrderPayActivity.this.R.getOrderId())) {
                    long overTime = arrayList.get(i7).getOverTime();
                    long j7 = overTime / 1000;
                    int i8 = (int) (j7 / 60);
                    int i9 = (int) (j7 % 60);
                    StringBuilder sb = new StringBuilder();
                    sb.append(i8);
                    sb.append(":");
                    sb.append(i9 < 10 ? "0" + i9 : Integer.valueOf(i9));
                    OrderPayActivity.this.f0(sb.toString());
                    OrderPayActivity.this.S = overTime;
                    if (arrayList.get(i7).getStatuId() == com.haier.globalwasher.modle.enum_.e.NO_PAY_OUT_TIME.b()) {
                        OrderPayActivity.this.f25760J.setBackground(OrderPayActivity.this.getDrawable(R.drawable.background_huise_button));
                        OrderPayActivity.this.f25760J.setOnClickListener(null);
                    }
                    if (arrayList.get(i7).getStatuId() == com.haier.globalwasher.modle.enum_.e.CLEANING.b()) {
                        if (arrayList.get(i7).getClearbucketCountDownTime() > 0) {
                            long clearbucketCountDownTime = arrayList.get(i7).getClearbucketCountDownTime();
                            OrderPayActivity.this.S = arrayList.get(i7).getOverTime();
                            long j8 = clearbucketCountDownTime / 1000;
                            int i10 = (int) (j8 / 60);
                            int i11 = (int) (j8 % 60);
                            int i12 = (i11 > 0 ? 1 : 0) + i10;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(i10);
                            sb2.append(":");
                            sb2.append(i11 < 10 ? "0" + i11 : Integer.valueOf(i11));
                            OrderPayActivity.this.f0(sb2.toString());
                            OrderPayActivity.this.H.setVisibility(0);
                            OrderPayActivity.this.f25760J.setBackground(OrderPayActivity.this.getDrawable(R.drawable.background_huise_button));
                            OrderPayActivity.this.f25760J.setOnClickListener(null);
                            OrderPayActivity.this.H.setText(OrderPayActivity.this.O.getString(R.string.barrels_of_clean_ing) + i12 + OrderPayActivity.this.O.getString(R.string.payment_success_pageds_time_unit));
                            OrderPayActivity.this.I.setBackground(OrderPayActivity.this.O.getDrawable(R.drawable.background_huise_button));
                            OrderPayActivity.this.I.setTextColor(OrderPayActivity.this.O.getColor(R.color.app_white));
                            OrderPayActivity.this.I.setOnClickListener(null);
                        } else {
                            OrderPayActivity.this.R0(2);
                        }
                    }
                }
            }
        }
    }

    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
            for (int i8 = 0; i8 < OrderPayActivity.this.V.size(); i8++) {
                if (i8 == i7) {
                    ((PayListBeen) OrderPayActivity.this.V.get(i8)).setSelect(!((PayListBeen) OrderPayActivity.this.V.get(i8)).isSelect());
                    if (((PayListBeen) OrderPayActivity.this.V.get(i8)).isSelect()) {
                        OrderPayActivity.this.Y = ((PayListBeen) OrderPayActivity.this.V.get(i7)).getId() + "";
                    } else {
                        OrderPayActivity.this.Y = "0";
                    }
                } else {
                    ((PayListBeen) OrderPayActivity.this.V.get(i8)).setSelect(false);
                }
            }
            OrderPayActivity.this.F.notifyDataSetChanged();
        }
    }

    class d implements AdapterView.OnItemClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
            String id = ((PayListBeen) OrderPayActivity.this.W.get(i7)).getId();
            id.hashCode();
            if (id.equals("2")) {
                PayCouponActivity.u0(OrderPayActivity.this.U, OrderPayActivity.this.R.getDeviceInfo().getType(), OrderPayActivity.this.A0, OrderPayActivity.this);
            }
        }
    }

    class e implements com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<PayListBeen>> {
        e() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseListDate<PayListBeen> baseListDate) {
            if (!"00000".equals(baseListDate.getRetCode()) || baseListDate.getData() == null || baseListDate.getData().size() <= 0) {
                return;
            }
            OrderPayActivity.this.V.addAll(baseListDate.getData());
            ((PayListBeen) OrderPayActivity.this.V.get(0)).setSelect(true);
            OrderPayActivity orderPayActivity = OrderPayActivity.this;
            orderPayActivity.Y = ((PayListBeen) orderPayActivity.V.get(0)).getId();
            if (OrderPayActivity.this.F != null) {
                OrderPayActivity.this.F.notifyDataSetChanged();
                return;
            }
            OrderPayActivity orderPayActivity2 = OrderPayActivity.this;
            OrderPayActivity orderPayActivity3 = OrderPayActivity.this;
            orderPayActivity2.F = new com.haier.globalwasher.mvp_api.adapter.a(orderPayActivity3, orderPayActivity3.V, OrderPayActivity.this);
            OrderPayActivity.this.D.setAdapter((ListAdapter) OrderPayActivity.this.F);
        }
    }

    class f implements View.OnClickListener {

        class a implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<ClearBucketBeen>> {
            a() {
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            public void a(Exception exc) {
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            @t0(api = 16)
            @SuppressLint({"NewApi"})
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void b(BaseData<ClearBucketBeen> baseData) {
                q.c(OrderPayActivity.this.G, baseData.toString());
                if ("00000".equals(baseData.getRetCode())) {
                    OrderPayActivity.this.I.setBackground(OrderPayActivity.this.O.getDrawable(R.drawable.background_huise_button));
                    OrderPayActivity.this.I.setTextColor(OrderPayActivity.this.O.getColor(R.color.app_white));
                    if (baseData.getData().getOverTime() == null || "".equals(baseData.getData().getOverTime())) {
                        baseData.getData().setOverTime("1000");
                    } else {
                        baseData.getData().setOverTime((Integer.parseInt(baseData.getData().getOverTime()) * 60 * 1000) + "");
                    }
                    MyApplication.s(new CountDownBeen(OrderPayActivity.this.R.getOrderId(), OrderPayActivity.this.S, com.haier.globalwasher.modle.enum_.e.CLEANING.b(), Long.parseLong(baseData.getData().getOverTime())));
                    OrderPayActivity.this.I.setBackground(OrderPayActivity.this.O.getDrawable(R.drawable.background_huise_button));
                    OrderPayActivity.this.I.setTextColor(OrderPayActivity.this.O.getColor(R.color.app_white));
                    OrderPayActivity.this.f25760J.setBackground(OrderPayActivity.this.getDrawable(R.drawable.background_huise_button));
                    OrderPayActivity.this.I.setOnClickListener(null);
                    OrderPayActivity.this.f25760J.setOnClickListener(null);
                }
            }
        }

        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OrderPayActivity.this.B.l(1, OrderPayActivity.this.R.getOrderId(), new a());
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o oVar = OrderPayActivity.this.B;
            String orderId = OrderPayActivity.this.R.getOrderId();
            String str = OrderPayActivity.this.Y;
            String str2 = OrderPayActivity.this.U;
            OrderPayActivity orderPayActivity = OrderPayActivity.this;
            oVar.y(orderId, str, str2, orderPayActivity.L, orderPayActivity.H0);
        }
    }

    class h extends com.bumptech.glide.request.target.j<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f25769d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ PayListBeen f25770e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(int i7, int i8, ImageView imageView, PayListBeen payListBeen) {
            super(i7, i8);
            this.f25769d = imageView;
            this.f25770e = payListBeen;
        }

        @Override // com.bumptech.glide.request.target.m
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, com.bumptech.glide.request.animation.e<? super Bitmap> eVar) {
            if (this.f25769d.getTag().equals(this.f25770e.getImgUrl())) {
                this.f25769d.setImageBitmap(bitmap);
            }
        }
    }

    class i extends com.haier.globalwasher.modle.utils.bluetoothutil.a.g {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(k kVar, boolean z7, v3.b bVar) {
            super(z7, bVar);
            Objects.requireNonNull(kVar);
        }

        @Override // com.haier.globalwasher.modle.utils.bluetoothutil.a.g, n2.b
        public void d() {
            super.d();
            OrderPayActivity.this.f25760J.setOnClickListener(OrderPayActivity.this);
            if (r()) {
                OrderPayActivity.this.Z0();
            } else {
                e(true);
            }
        }

        @Override // n2.a
        public void e(boolean z7) {
            if ((com.haier.globalwasher.modle.enum_.e.VERIFICATION_NO_PAY.b() + "").equals(OrderPayActivity.this.R.getOrderStatus())) {
                OrderPayActivity.this.f25760J.setOnClickListener(z7 ? OrderPayActivity.this : null);
            }
        }

        @Override // v3.a
        public void g(com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar, int i7) {
            OrderPayActivity.this.E0.p();
            if (i7 == 1 || i7 == 2) {
                t(i7 == 1);
            }
            OrderPayActivity orderPayActivity = OrderPayActivity.this;
            com.haier.globalwasher.presenter.h.b(orderPayActivity, null, orderPayActivity.R.getOrderId(), com.haier.globalwasher.modle.enum_.d.DEVICE_RUN_ACTIVITY, 0);
        }
    }

    class j implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<CounponSelectReturnBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ DisCountInfo f25773a;

        j(DisCountInfo disCountInfo) {
            this.f25773a = disCountInfo;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            q.c(OrderPayActivity.this.G, "requestFinalPrice " + exc.toString());
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<CounponSelectReturnBean> baseData) {
            q.c(OrderPayActivity.this.G, "" + baseData.toString());
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(OrderPayActivity.this, baseData.getRetInfo() + "");
                return;
            }
            if (OrderPayActivity.this.L.size() == 0) {
                OrderPayActivity.this.L.add(this.f25773a);
            } else {
                DisCountInfo disCountInfo = null;
                for (int i7 = 0; i7 < OrderPayActivity.this.L.size(); i7++) {
                    if (OrderPayActivity.this.L.get(i7).getPreferType().equals(this.f25773a.getPreferType())) {
                        disCountInfo = OrderPayActivity.this.L.get(i7);
                    }
                }
                if (disCountInfo != null) {
                    OrderPayActivity.this.L.remove(disCountInfo);
                }
                OrderPayActivity.this.L.add(this.f25773a);
            }
            if (OrderPayActivity.this.f25760J != null) {
                OrderPayActivity.this.R.setPayAmount(baseData.getData().getPayAmount());
                OrderPayActivity.this.f25760J.setText(OrderPayActivity.this.O.getString(R.string.barrels_of_clean_twobtn) + " " + OrderPayActivity.this.R.getCurrencySymbol() + " " + baseData.getData().getPayAmount());
            }
        }
    }

    public static class k extends com.haier.globalwasher.modle.utils.bluetoothutil.a {
        public k(BaseActivity baseActivity, int i7) {
            super(baseActivity, i7);
        }

        @Override // com.haier.globalwasher.modle.utils.bluetoothutil.a
        public void k() {
        }
    }

    public class l implements m2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f25775a = System.currentTimeMillis();

        public l() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            OrderPayActivity orderPayActivity = OrderPayActivity.this;
            orderPayActivity.G0 = true;
            i0.d(orderPayActivity, exc.getMessage());
        }

        @Override // m2.a
        public void c(Object obj) {
            this.f25775a = System.currentTimeMillis();
            OrderPayActivity.this.G0 = false;
        }

        @Override // m2.a
        public void d(BaseData baseData) {
            OrderPayActivity orderPayActivity = OrderPayActivity.this;
            orderPayActivity.G0 = true;
            i0.d(orderPayActivity, baseData.getRetInfo() + "");
        }

        @Override // m2.a
        public void e(String str) {
            OrderPayActivity orderPayActivity = OrderPayActivity.this;
            orderPayActivity.G0 = false;
            i0.d(orderPayActivity, str);
        }

        public boolean f() {
            return System.currentTimeMillis() - this.f25775a > 600;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            BluetoothInfoBean blueToolthInfo;
            OrderPayActivity.this.G0 = true;
            q.c(OrderIsPaidToRunActivity.Q, "支付成功");
            if (!"00000".equals(baseData.getRetCode()) && !i2.a.f34132r.equals(baseData.getRetCode())) {
                i0.d(OrderPayActivity.this, baseData.getRetInfo());
                return;
            }
            v3.b uBluetoothBean = null;
            if (OrderPayActivity.this.R.getDeviceInfo() != null) {
                blueToolthInfo = OrderPayActivity.this.R.getDeviceInfo().getBlueToolthInfo();
            } else {
                blueToolthInfo = OrderPayActivity.this.R.getDeviceList() != null ? OrderPayActivity.this.R.getDeviceList().getBlueToolthInfo() : null;
            }
            if (OrderPayActivity.this.R.getOrderDeviType() != 1 || blueToolthInfo == null || !d0.j(OrderPayActivity.this.R.getDeviceInfo().getBlueToolthInfo().getDirective())) {
                q.c(OrderIsPaidToRunActivity.Q, "orderDetailsBeen.getDirective()=null");
                OrderPayActivity orderPayActivity = OrderPayActivity.this;
                com.haier.globalwasher.presenter.h.b(orderPayActivity, null, orderPayActivity.R.getOrderId(), com.haier.globalwasher.modle.enum_.d.DEVICE_RUN_ACTIVITY, 0);
            } else {
                int i7 = Integer.parseInt(OrderPayActivity.this.R.getDeviceInfo().getBlueToolthInfo().getModuleType());
                if (i7 == 1) {
                    uBluetoothBean = new UBluetoothBean(OrderPayActivity.this.R.getDeviceInfo().getBlueToolthInfo().getAccessToken(), OrderPayActivity.this.R.getDeviceInfo().getBlueToolthInfo().getBlueName(), OrderPayActivity.this.R.getDeviceInfo().getBlueToolthInfo().getDirective());
                } else if (i7 == 2) {
                    uBluetoothBean = new w3.a(OrderPayActivity.this.R.getDeviceInfo().getBlueToolthInfo().getDeviceCode(), OrderPayActivity.this.R.getDeviceInfo().getBlueToolthInfo().getBlueName(), OrderPayActivity.this.R.getDeviceInfo().getBlueToolthInfo().getDirective());
                }
                OrderPayActivity.this.U0().w(uBluetoothBean, OrderPayActivity.this.U0());
            }
        }
    }

    public class m implements com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<PayListBeen>> {

        class a implements com.haier.globalwasher.mvp_api.moudle.b<BaseBeen> {
            a() {
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            public void a(Exception exc) {
                for (int i7 = 0; i7 < OrderPayActivity.this.W.size(); i7++) {
                    if ("2".equals(((PayListBeen) OrderPayActivity.this.W.get(i7)).getId() + "")) {
                        ((PayListBeen) OrderPayActivity.this.W.get(i7)).setDisplyName("0 " + ((PayListBeen) OrderPayActivity.this.W.get(i7)).getDisplyName());
                    }
                }
            }

            @Override // com.haier.globalwasher.mvp_api.moudle.b
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public void b(BaseBeen baseBeen) {
                q.c(OrderPayActivity.this.G, baseBeen.toString());
                if ("00000".equals(baseBeen.getRetCode())) {
                    OrderPayActivity.this.B0 = Integer.parseInt(baseBeen.getRetData());
                    for (int i7 = 0; i7 < OrderPayActivity.this.W.size(); i7++) {
                        if ("2".equals(((PayListBeen) OrderPayActivity.this.W.get(i7)).getId() + "")) {
                            ((PayListBeen) OrderPayActivity.this.W.get(i7)).setDisplyName(OrderPayActivity.this.B0 + " " + ((PayListBeen) OrderPayActivity.this.W.get(i7)).getDisplyName());
                        }
                    }
                }
                OrderPayActivity.this.K.notifyDataSetChanged();
            }
        }

        public m() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseListDate<PayListBeen> baseListDate) {
            q.c(OrderPayActivity.this.G, "优惠方式" + baseListDate.toString());
            if (!"00000".equals(baseListDate.getRetCode()) || baseListDate.getData() == null || baseListDate.getData().size() <= 0) {
                OrderPayActivity.this.C.setVisibility(8);
                OrderPayActivity.this.E.setVisibility(8);
                return;
            }
            OrderPayActivity.this.W.clear();
            OrderPayActivity.this.W.addAll(baseListDate.getData());
            OrderPayActivity.this.C.setVisibility(0);
            OrderPayActivity.this.E.setVisibility(0);
            if (OrderPayActivity.this.K == null) {
                OrderPayActivity orderPayActivity = OrderPayActivity.this;
                OrderPayActivity orderPayActivity2 = OrderPayActivity.this;
                ArrayList arrayList = orderPayActivity2.W;
                OrderPayActivity orderPayActivity3 = OrderPayActivity.this;
                orderPayActivity.K = new com.haier.globalwasher.mvp_api.adapter.a(orderPayActivity2, arrayList, new com.haier.globalwasher.view.adapter.i(orderPayActivity3, orderPayActivity3.W));
                OrderPayActivity.this.E.setAdapter((ListAdapter) OrderPayActivity.this.K);
            } else {
                OrderPayActivity.this.K.notifyDataSetChanged();
            }
            q.c(OrderPayActivity.this.G, "优惠方式" + OrderPayActivity.this.W.size());
            for (int i7 = 0; i7 < OrderPayActivity.this.W.size(); i7++) {
                if ("2".equals(((PayListBeen) OrderPayActivity.this.W.get(i7)).getId() + "")) {
                    OrderPayActivity orderPayActivity4 = OrderPayActivity.this;
                    orderPayActivity4.C0 = ((PayListBeen) orderPayActivity4.W.get(i7)).getDisplyName();
                    q.c(OrderPayActivity.this.G, "-----");
                    OrderPayActivity.this.B.o(0, OrderPayActivity.this.U, OrderPayActivity.this.R.getDeviceInfo().getType(), new a());
                }
            }
        }
    }

    private void S0() {
        if (1 == this.R.getOrderDeviType() && d0.j(this.R.getDirective())) {
            q.c(OrderIsPaidToRunActivity.Q, "checkPhoneForOrder");
            this.f25760J.setOnClickListener(null);
            b1(false);
        }
    }

    public static void a1(OrderDetailsBeen orderDetailsBeen, Context context) {
        Intent intent = new Intent(context, (Class<?>) OrderPayActivity.class);
        intent.putExtra(o.C, orderDetailsBeen);
        context.startActivity(intent);
    }

    @SuppressLint({"CutPasteId"})
    public void P0(String str, String str2, String str3, String str4) {
        String str5 = str + str2 + "";
        if (this.T == null) {
            if (str2 == null || !str2.equals(str3)) {
                View viewInflate = View.inflate(this, R.layout.activity_pay_toolbar, null);
                this.T = viewInflate;
                FontTextView fontTextView = (FontTextView) viewInflate.findViewById(R.id.tv_price_now);
                FontTextView fontTextView2 = (FontTextView) this.T.findViewById(R.id.tv_price_old);
                FontTextView fontTextView3 = (FontTextView) this.T.findViewById(R.id.tv_price_explain);
                fontTextView2.getPaint().setFlags(16);
                fontTextView2.setText(str3);
                fontTextView.setText(str5);
                fontTextView3.setText(str4);
            } else {
                View viewInflate2 = View.inflate(this, R.layout.activity_pay_toolbar_single_price, null);
                this.T = viewInflate2;
                ((FontTextView) viewInflate2.findViewById(R.id.tv_price_now)).setText(str5);
            }
        }
        addViewInToolbarBottom(this.T);
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    @t0(api = 16)
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public void i(Context context, int i7, com.haier.globalwasher.mvp_api.adapter.b bVar, PayListBeen payListBeen) {
        bVar.b(R.id.iv_tag, R.id.tv_pay_name, R.id.cb_selelct_pay);
        ImageView imageView = (ImageView) bVar.a(R.id.iv_tag);
        FontTextView fontTextView = (FontTextView) bVar.a(R.id.tv_pay_name);
        ((CheckBox) bVar.a(R.id.cb_selelct_pay)).setSelected(payListBeen.isSelect());
        fontTextView.setText(payListBeen.getDisplyName());
        View childAt = this.D.getChildAt(i7);
        if (payListBeen.getImgUrl() != null && payListBeen.getImgUrl().length() > 1) {
            imageView.setTag(payListBeen.getImgUrl());
            com.bumptech.glide.l.O(this).E(payListBeen.getImgUrl()).L0().F(new h(Integer.MIN_VALUE, Integer.MIN_VALUE, imageView, payListBeen));
            q.c(this.G, "支付方式图片 " + payListBeen.getImgUrl());
        }
        if (childAt != null) {
            LinearLayout linearLayout = (LinearLayout) childAt.findViewById(R.id.lly_margin);
            if (payListBeen.isSelect()) {
                linearLayout.setBackground(context.getResources().getDrawable(R.drawable.pay_item_blue));
            } else {
                linearLayout.setBackground(context.getResources().getDrawable(R.drawable.cardview_background));
            }
        }
    }

    @SuppressLint({"NewApi", "SetTextI18n"})
    public void R0(int i7) {
        k kVar;
        if (i7 != 2) {
            if (i7 == 1) {
                this.H.setVisibility(8);
                this.I.setVisibility(8);
                return;
            }
            if (i7 == 3) {
                this.H.setVisibility(0);
                this.f25760J.setBackground(getDrawable(R.drawable.background_huise_button));
                this.f25760J.setOnClickListener(null);
                this.H.setText(this.O.getString(R.string.barrels_of_clean_ing) + this.R.getDeviceInfo().getTimeRemaining() + this.O.getString(R.string.payment_success_pageds_time_unit));
                this.I.setBackground(this.O.getDrawable(R.drawable.background_huise_button));
                this.I.setTextColor(this.O.getColor(R.color.app_white));
                this.I.setOnClickListener(null);
                return;
            }
            return;
        }
        this.H.setVisibility(0);
        this.I.setBackground(this.O.getDrawable(R.drawable.background_huise_button));
        this.I.setTextColor(this.O.getColor(R.color.app_white));
        this.I.setOnClickListener(null);
        this.H.setText(getResources().getString(R.string.barrels_of_clean_finish));
        V0();
        if (1 != this.R.getOrderDeviType() || (kVar = this.E0) == null) {
            this.f25760J.setBackground(getDrawable(R.drawable.background_blue_button));
            this.f25760J.setOnClickListener(this);
            return;
        }
        com.jiao.project.bluetoothofabroadwasherapp.enums.d dVarH = kVar.h(this.R.getDeviceInfo().getBlueMac());
        if (dVarH == null) {
            i0.d(this, getResources().getString(R.string.usdk_device_commend_response_error));
            this.f25760J.setBackground(getDrawable(R.drawable.background_huise_button));
            this.f25760J.setOnClickListener(null);
        } else if (a.f25761a[dVarH.ordinal()] != 1) {
            this.f25760J.setBackground(getDrawable(R.drawable.background_huise_button));
            this.f25760J.setOnClickListener(null);
        } else {
            this.f25760J.setBackground(getDrawable(R.drawable.background_blue_button));
            this.f25760J.setOnClickListener(this);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.adapter.d
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public com.haier.globalwasher.mvp_api.adapter.b x(int i7, ViewGroup viewGroup) {
        return new com.haier.globalwasher.mvp_api.adapter.b(this, View.inflate(this, R.layout.adapter_pay_list, null), 1);
    }

    public com.haier.globalwasher.modle.utils.bluetoothutil.a.g U0() {
        if (this.D0 == null) {
            v3.b uBluetoothBean = Integer.parseInt(this.R.getDeviceInfo().getBlueToolthInfo().getModuleType()) != 2 ? new UBluetoothBean(this.R.getDeviceInfo().getBlueToolthInfo().getAccessToken(), this.R.getDeviceInfo().getBlueToolthInfo().getBlueName(), this.R.getDeviceInfo().getBlueToolthInfo().getDirective()) : new w3.a(this.R.getDeviceInfo().getBlueToolthInfo().getDeviceCode(), this.R.getDeviceInfo().getBlueToolthInfo().getBlueName(), this.R.getDeviceInfo().getBlueToolthInfo().getDirective());
            V0();
            k kVar = this.E0;
            if (kVar != null) {
                Objects.requireNonNull(kVar);
                this.D0 = new i(kVar, true, uBluetoothBean);
            }
        }
        return this.D0;
    }

    public void V0() {
        OrderDetailsBeen orderDetailsBeen;
        int i7;
        if (this.E0 != null || (orderDetailsBeen = this.R) == null || orderDetailsBeen.getDeviceInfo().getBlueToolthInfo() == null) {
            return;
        }
        String moduleType = this.R.getDeviceInfo().getBlueToolthInfo().getModuleType();
        if ("1".equals(moduleType)) {
            i7 = 1;
        } else {
            i7 = "2".equals(moduleType) ? 2 : -1;
        }
        this.E0 = new k(this, i7);
    }

    @Override // com.haier.globalwasher.base.BaseActivity
    public void W() {
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public w2.a<BaseActivity> l0() {
        return this.B;
    }

    public void X0(boolean z7) {
        if (z7) {
            for (int i7 = 0; i7 < this.W.size(); i7++) {
                if ("2".equals(this.W.get(i7).getId() + "")) {
                    this.W.remove(i7);
                }
            }
            if (this.W.size() == 0) {
                this.C.setVisibility(8);
                this.E.setVisibility(8);
            } else {
                this.C.setVisibility(0);
                this.E.setVisibility(0);
            }
        }
    }

    public void Y0(DisCountInfo disCountInfo) {
        this.B.A(this.R.getOrderId(), disCountInfo, new j(disCountInfo));
    }

    public void Z0() {
        String string;
        if ('1' == this.R.getDeviceInfo().getType().charAt(0)) {
            string = this.O.getString(R.string.payment_start_wash_remind);
        } else if ('2' == this.R.getDeviceInfo().getType().charAt(0)) {
            string = this.O.getString(R.string.payment_start_Shos_remind);
        } else {
            string = '3' == this.R.getDeviceInfo().getType().charAt(0) ? this.O.getString(R.string.payment_start_Dry_remind) : "";
        }
        z.b(this, 1, 2, 1, this.O.getString(R.string.New_payment_page_Prompts), string, this.O.getString(R.string.payment_start_confirm), new g(), null);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_pay;
    }

    public void b1(boolean z7) {
        U0().u(z7);
        U0().s(com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND);
        V0();
        k kVar = this.E0;
        if (kVar != null) {
            kVar.u(U0());
        }
    }

    public void c1() {
        for (int i7 = 0; i7 < this.R.getDeviceInfo().getRunMode().size(); i7++) {
            try {
                if (this.R.getDeviceInfo().getRunMode().get(i7).getCode() != null && this.R.getDeviceInfo().getRunMode().get(i7).getCode().equals("TNK_CLN")) {
                    if (this.R.getDeviceInfo().getRunMode().get(i7).getTimeDuration() != null) {
                        this.P = Integer.parseInt(this.R.getDeviceInfo().getRunMode().get(i7).getTimeDuration());
                        this.H.setText(this.O.getString(R.string.barrels_of_clean_clean) + this.P + this.O.getString(R.string.barrels_of_clean_free));
                        this.H.setVisibility(0);
                        this.I.setOnClickListener(this);
                        return;
                    }
                    return;
                }
            } catch (NullPointerException unused) {
                this.H.setVisibility(8);
                this.I.setVisibility(8);
                return;
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public ListView m0() {
        OrderDetailsBeen orderDetailsBeen = (OrderDetailsBeen) getIntent().getSerializableExtra(o.C);
        this.R = orderDetailsBeen;
        if (orderDetailsBeen == null) {
            return new ListView(this);
        }
        if (orderDetailsBeen.getDeviceInfo() != null) {
            this.U = this.R.getDeviceInfo().getDeviceId();
        }
        Resources resources = getResources();
        this.O = resources;
        d0(resources.getString(R.string.barrels_of_clean_title), 1, P("0:00", null));
        this.C = (FontTextView) findViewById(R.id.tv_title_coupon);
        this.D = (ListView) findViewById(R.id.lv_payList);
        this.E = (ListView) findViewById(R.id.lv_preferential_approach);
        this.H = (FontTextView) findViewById(R.id.tv_clean_bucket_countdown);
        this.f25760J = (FontTextView) S(R.id.tv_pay, true);
        this.f25760J.setText(this.O.getString(R.string.barrels_of_clean_twobtn) + " " + this.R.getCurrencySymbol() + " " + new BigDecimal(this.R.getSalePrice()).doubleValue());
        this.I = (FontTextView) findViewById(R.id.tv_clean);
        if (!"T".equals(this.R.getDeviceInfo().getSupportsCleaning())) {
            R0(1);
        } else if (!"F".equals(this.R.getIsCleaningComplete())) {
            R0(2);
        } else if (Integer.parseInt(this.R.getOrderStatus()) == com.haier.globalwasher.modle.enum_.e.CLEANING.b()) {
            R0(3);
        } else {
            c1();
        }
        P0(this.R.getCurrencySymbol(), this.R.getSalePrice(), this.R.getPrice(), this.R.getLaundryActivityTitle());
        this.Q = new b();
        IntentFilter intentFilter = new IntentFilter(i2.a.f34153y);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.Q, intentFilter, 4);
        } else {
            registerReceiver(this.Q, intentFilter);
        }
        this.D.setOnItemClickListener(new c());
        this.E.setOnItemClickListener(new d());
        S0();
        return this.D;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i7, int i8, Intent intent) {
        super.onActivityResult(i7, i8, intent);
        if (i7 != 1002 || i8 != 1003) {
            o oVar = this.B;
            if (oVar == null || i7 != oVar.f25231n || intent == null) {
                return;
            }
            this.B.x(this.R.getOrderId(), intent.getStringExtra("response"), this.H0);
            return;
        }
        CouponPageBeen couponPageBeen = (CouponPageBeen) intent.getSerializableExtra(o.G);
        this.A0 = couponPageBeen;
        if (couponPageBeen != null) {
            for (int i9 = 0; i9 < this.W.size(); i9++) {
                if ("2".equals(this.W.get(i9).getId() + "")) {
                    this.M = this.W.get(i9).getId();
                    this.N = this.A0.getCouponId();
                    this.W.get(i9).setDisplyName(this.A0.getCurrencySymbol() + " " + this.A0.getCouponValue() + " " + getResources().getString(R.string.discount_coupon_title));
                    CouponPageBeen couponPageBeen2 = this.A0;
                    if (couponPageBeen2 == null || TextUtils.isEmpty(couponPageBeen2.getValidityEndTime())) {
                        this.W.get(i9).setEndTime(getResources().getString(R.string.Nearby_laundry_expires));
                    } else {
                        this.W.get(i9).setEndTime(d0.b(this.A0.getValidityEndTime(), "yyyy-MM-dd"));
                    }
                    this.W.get(i9).setSelectContent(true);
                }
            }
        } else {
            this.A0 = new CouponPageBeen();
            for (int i10 = 0; i10 < this.W.size(); i10++) {
                if ("2".equals(this.W.get(i10).getId())) {
                    this.M = "";
                    CouponPageBeen couponPageBeen3 = this.A0;
                    if (couponPageBeen3 != null) {
                        couponPageBeen3.setCouponId(0);
                    }
                    this.W.get(i10).setDisplyName(this.B0 + " " + this.C0);
                    this.W.get(i10).setSelectContent(false);
                }
            }
        }
        this.K.notifyDataSetChanged();
        Y0(this.A0 != null ? new DisCountInfo(com.haier.globalwasher.modle.enum_.b.COUPON.b(), this.A0.getCouponId() + "") : null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.tv_pay) {
            if (id == R.id.tv_clean) {
                z.c(this, 1, 2, this.O.getString(R.string.barrels_of_clean_onebtn), MessageFormat.format(this.O.getString(R.string.Clean_bucket_Remind), Integer.valueOf(this.P)), this.O.getString(R.string.order_list_Btn_cancal_Remind_left), this.O.getString(R.string.order_list_Btn_cancal_Remind_right), null, new f());
            }
        } else if (1 == this.R.getOrderDeviType()) {
            b1(true);
        } else {
            Z0();
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        unregisterReceiver(this.Q);
        this.Q = null;
        k kVar = this.E0;
        if (kVar != null) {
            kVar.s();
        }
        super.onDestroy();
    }

    @Override // com.haier.globalwasher.base.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i7, KeyEvent keyEvent) {
        if (i7 != 4) {
            return super.onKeyDown(i7, keyEvent);
        }
        sendBroadcast(new Intent(i2.a.f34156z));
        finish();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i7, @m0 String[] strArr, @m0 int[] iArr) {
        super.onRequestPermissionsResult(i7, strArr, iArr);
        V0();
        k kVar = this.E0;
        if (kVar != null) {
            kVar.r(i7, strArr, iArr);
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.F0) {
            this.F0 = false;
        } else if (this.G0 && this.H0.f()) {
            this.B.z(this.Y, this.R.getOrderId(), this.H0);
        }
    }

    @Override // com.haier.globalwasher.base.BaseListActivity
    public void p0(int i7, int i8) {
        this.B.p(this.R.getOrderId(), 2, "1", this.X);
        this.B.p(this.R.getOrderId(), 1, "1", new e());
    }
}
