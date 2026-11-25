package com.haier.globalwasher.view.activity.order;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import c.m0;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.CountDownBeen;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.modle.bean.OrderTimeBeen;
import com.haier.globalwasher.modle.bean.UBluetoothBean;
import com.haier.globalwasher.modle.g;
import com.haier.globalwasher.modle.utils.h0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver;
import com.haier.globalwasher.presenter.h;
import com.haier.globalwasher.presenter.i;
import com.haier.globalwasher.presenter.o;
import com.haier.globalwasher.presenter.y;
import com.haier.globalwasher.view.activity.MainActivity;
import com.haier.globalwasher.view.activity.WebActivity;
import com.haier.globalwasher.view.custom_view.FontTextView;
import com.haier.globalwasher.view.custom_view.wave_imageview.WaveFunctionView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class OrderIsPaidToRunActivity extends BaseActivity {
    public static final String Q = "UsdkUtil";
    private FontTextView A;
    private FontTextView B;
    private RelativeLayout C;
    private ImageView D;
    private FontTextView E;
    private FontTextView F;
    private Resources G;
    private MyBroadcastReceiver I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    CountDownBroadcastReceiver f25722J;
    OrderDetailsBeen K;
    private com.haier.globalwasher.modle.utils.bluetoothutil.a O;
    private com.haier.globalwasher.modle.utils.bluetoothutil.a.g P;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private WaveFunctionView f25723u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private FontTextView f25724v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private FontTextView f25725w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private FontTextView f25726x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private FontTextView f25727y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private FontTextView f25728z;
    private i H = new i();
    private int L = -1;
    private long M = 0;
    f N = new f();

    public static class MyBroadcastReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<OrderIsPaidToRunActivity> f25729a;

        public MyBroadcastReceiver(OrderIsPaidToRunActivity orderIsPaidToRunActivity) {
            this.f25729a = new WeakReference<>(orderIsPaidToRunActivity);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i7;
            if (intent == null || this.f25729a.get() == null || !com.haier.globalwasher.modle.d.f24392a.equals(intent.getAction())) {
                return;
            }
            String stringExtra = intent.getStringExtra(com.haier.globalwasher.modle.d.f24393b);
            long longExtra = intent.getLongExtra(com.haier.globalwasher.modle.d.f24394c, 0L);
            FontTextView fontTextView = (this.f25729a.get().K != null && this.f25729a.get().K.getOrderId().equals(stringExtra) && ((i7 = e.f25734a[com.haier.globalwasher.modle.enum_.e.e(Integer.parseInt(this.f25729a.get().K.getOrderStatus())).ordinal()]) == 1 || i7 == 2 || i7 == 3 || i7 == 4)) ? this.f25729a.get().B : null;
            if (fontTextView == null || !fontTextView.isShown()) {
                return;
            }
            if (longExtra <= 0) {
                fontTextView.setEnabled(true);
                fontTextView.setText(this.f25729a.get().G.getString(R.string.order_list_Btn_Restart));
                fontTextView.getPaint().setFlags(8);
                fontTextView.getPaint().setAntiAlias(true);
                return;
            }
            fontTextView.setEnabled(false);
            fontTextView.setText((longExtra / 1000) + "s");
            fontTextView.getPaint().setFlags(0);
            fontTextView.getPaint().setAntiAlias(true);
        }
    }

    class a extends CountDownBroadcastReceiver {
        a() {
        }

        @Override // com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver
        public void a(ArrayList<CountDownBeen> arrayList) {
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                if (arrayList.get(i7).getWashOrderId().equals(OrderIsPaidToRunActivity.this.K.getOrderId())) {
                    q.c("OrderActivityManager", arrayList.get(i7).getStatuId() + "----112----" + arrayList.get(i7).getOverTime());
                    if (arrayList.get(i7).getStatuId() == com.haier.globalwasher.modle.enum_.e.PAY_SUCCESS.b()) {
                        long overTime = arrayList.get(i7).getOverTime();
                        long j7 = overTime / 1000;
                        int i8 = ((int) (j7 / 60)) + (((int) (j7 % 60)) > 0 ? 1 : 0);
                        OrderIsPaidToRunActivity.this.M = overTime;
                        OrderIsPaidToRunActivity.this.E.setText(i8 + OrderIsPaidToRunActivity.this.G.getString(R.string.payment_success_pageds_time_unit));
                    } else {
                        OrderIsPaidToRunActivity.this.n0(String.valueOf(arrayList.get(i7).getStatuId()));
                    }
                }
            }
        }
    }

    class b implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<OrderTimeBeen>> {
        b() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            q.c(OrderIsPaidToRunActivity.Q, "" + exc.toString());
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<OrderTimeBeen> baseData) {
            if ("00000".equals(baseData.getRetCode())) {
                q.c(OrderIsPaidToRunActivity.Q, "object.getData().getRemainingTime()=" + baseData.getData().getRemainingTime());
                long j7 = 0;
                try {
                    if (com.haier.globalwasher.modle.enum_.e.e(Integer.parseInt(OrderIsPaidToRunActivity.this.K.getOrderStatus())) != com.haier.globalwasher.modle.enum_.e.ORDER_SUCCESS) {
                        j7 = Long.parseLong(baseData.getData().getRemainingTime()) * 60 * 1000;
                    }
                } catch (Exception unused) {
                }
                MyApplication.s(new CountDownBeen(OrderIsPaidToRunActivity.this.K.getOrderId(), j7, Integer.parseInt(baseData.getData().getStatus()), 0L));
            }
        }
    }

    class c implements n2.c {
        c() {
        }

        @Override // n2.c
        public void a(com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar) {
            OrderIsPaidToRunActivity.this.u0(cVar, true);
        }
    }

    class d extends com.haier.globalwasher.modle.utils.bluetoothutil.a.g {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(com.haier.globalwasher.modle.utils.bluetoothutil.a aVar, boolean z7, v3.b bVar) {
            super(z7, bVar);
            Objects.requireNonNull(aVar);
        }

        @Override // com.haier.globalwasher.modle.utils.bluetoothutil.a.g, n2.b
        public void d() {
            super.d();
            if (!r()) {
                e(true);
                return;
            }
            q.c(OrderIsPaidToRunActivity.Q, "deviceIsConnent..");
            int i7 = e.f25735b[c().ordinal()];
            if (i7 == 1) {
                OrderIsPaidToRunActivity.this.r0();
            } else {
                if (i7 != 2) {
                    return;
                }
                OrderIsPaidToRunActivity.this.t0();
            }
        }

        @Override // n2.a
        public void e(boolean z7) {
            q.c(OrderIsPaidToRunActivity.Q, "endCheck=" + z7);
            OrderIsPaidToRunActivity.this.A.setOnClickListener(z7 ? OrderIsPaidToRunActivity.this : null);
            OrderIsPaidToRunActivity.this.B.setOnClickListener(z7 ? OrderIsPaidToRunActivity.this : null);
        }

        @Override // v3.a
        public void g(com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar, int i7) {
            e(true);
            if (i7 == 1 || i7 == 2) {
                t(i7 == 1);
            }
            com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar2 = com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND;
            if (i7 == cVar2.b() && cVar == cVar2) {
                if (p()) {
                    OrderIsPaidToRunActivity orderIsPaidToRunActivity = OrderIsPaidToRunActivity.this;
                    i0.d(orderIsPaidToRunActivity, orderIsPaidToRunActivity.getResources().getString(R.string.usdk_device_is_running));
                }
                Message message = new Message();
                message.what = 1;
                message.obj = OrderIsPaidToRunActivity.this.K.getOrderId();
                com.haier.globalwasher.modle.f.b().sendMessage(message);
                return;
            }
            com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar3 = com.jiao.project.bluetoothofabroadwasherapp.enums.c.END_COMMAND;
            if (i7 == cVar3.b() && cVar == cVar3 && !p()) {
                OrderDetailsBeen orderDetailsBeen = OrderIsPaidToRunActivity.this.K;
                StringBuilder sb = new StringBuilder();
                com.haier.globalwasher.modle.enum_.e eVar = com.haier.globalwasher.modle.enum_.e.ORDER_SUCCESS;
                sb.append(eVar.b());
                sb.append("");
                orderDetailsBeen.setOrderStatus(sb.toString());
                OrderIsPaidToRunActivity.this.n0(eVar.b() + "");
            }
        }
    }

    static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f25735b;

        static {
            int[] iArr = new int[com.jiao.project.bluetoothofabroadwasherapp.enums.c.values().length];
            f25735b = iArr;
            try {
                iArr[com.jiao.project.bluetoothofabroadwasherapp.enums.c.START_COMMAND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25735b[com.jiao.project.bluetoothofabroadwasherapp.enums.c.END_COMMAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[com.haier.globalwasher.modle.enum_.e.values().length];
            f25734a = iArr2;
            try {
                iArr2[com.haier.globalwasher.modle.enum_.e.PAY_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25734a[com.haier.globalwasher.modle.enum_.e.SECCESS_PAY_OUT_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25734a[com.haier.globalwasher.modle.enum_.e.FAULT_CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25734a[com.haier.globalwasher.modle.enum_.e.SUCCESS_PAY_FAULT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private class f implements com.haier.globalwasher.mvp_api.moudle.b<BaseData> {
        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData baseData) {
            q.c("GsonRequest", baseData.toString());
            if (!"00000".equals(baseData.getRetCode())) {
                i0.d(OrderIsPaidToRunActivity.this, baseData.getRetInfo());
                return;
            }
            if (OrderIsPaidToRunActivity.this.K.getOrderDeviType() == 1) {
                OrderIsPaidToRunActivity.this.u0(com.jiao.project.bluetoothofabroadwasherapp.enums.c.END_COMMAND, true);
                return;
            }
            OrderDetailsBeen orderDetailsBeen = OrderIsPaidToRunActivity.this.K;
            StringBuilder sb = new StringBuilder();
            com.haier.globalwasher.modle.enum_.e eVar = com.haier.globalwasher.modle.enum_.e.ORDER_SUCCESS;
            sb.append(eVar.b());
            sb.append("");
            orderDetailsBeen.setOrderStatus(sb.toString());
            OrderIsPaidToRunActivity.this.n0(eVar.b() + "");
        }

        private f() {
        }
    }

    private void l0() {
        if (MyApplication.j() != null) {
            for (int i7 = 0; i7 < MyApplication.j().size(); i7++) {
                if (!(MyApplication.j().get(i7) instanceof MainActivity)) {
                    MyApplication.j().get(i7).finish();
                }
            }
        }
    }

    public static void s0(OrderDetailsBeen orderDetailsBeen, Context context, int i7) {
        Intent intent = new Intent(context, (Class<?>) OrderIsPaidToRunActivity.class);
        intent.putExtra(o.C, orderDetailsBeen);
        intent.putExtra(o.D, i7);
        context.startActivity(intent);
    }

    @Override // com.haier.globalwasher.base.BaseActivity
    public void W() {
        super.W();
        com.haier.globalwasher.modle.utils.bluetoothutil.a aVar = this.O;
        if (aVar != null) {
            aVar.t();
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.f25727y.getPaint().setFlags(8);
        this.f25727y.getPaint().setAntiAlias(true);
        this.f25728z.getPaint().setFlags(8);
        this.f25728z.getPaint().setAntiAlias(true);
        this.A.getPaint().setFlags(8);
        this.A.getPaint().setAntiAlias(true);
        this.B.getPaint().setFlags(8);
        this.B.getPaint().setAntiAlias(true);
        if (this.K.getDeviceInfo() != null) {
            if (this.K.getDeviceInfo().getLaundryInfo().getHotLine() != null) {
                this.f25727y.setText(this.G.getString(R.string.machine_fault_customer) + " " + this.K.getDeviceInfo().getLaundryInfo().getHotLine());
            } else if (this.K.getHotLine() != null) {
                this.f25727y.setText(this.G.getString(R.string.machine_fault_customer) + " " + this.K.getHotLine());
            } else {
                this.f25727y.setText("");
            }
        } else if (this.K.getHotLine() != null) {
            this.f25727y.setText(this.G.getString(R.string.machine_fault_customer) + " " + this.K.getHotLine());
        } else {
            this.f25727y.setText("");
        }
        this.H.j(this.K.getOrderId(), new b());
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_order_is_pay_to_run;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        Resources resources = getResources();
        this.G = resources;
        d0(resources.getString(R.string.payment_success_pageds_title), 0, new View[0]);
        Intent intent = getIntent();
        this.K = (OrderDetailsBeen) intent.getSerializableExtra(o.C);
        this.L = intent.getIntExtra(o.D, -1);
        if (this.K == null) {
            return;
        }
        this.f25723u = (WaveFunctionView) findViewById(R.id.iv_washer_time);
        this.E = (FontTextView) findViewById(R.id.tv_down_time);
        this.f25724v = (FontTextView) findViewById(R.id.tv_message);
        FontTextView fontTextView = (FontTextView) S(R.id.tv_to_use_others, true);
        this.f25725w = fontTextView;
        int i7 = this.L;
        if (i7 != 1 && i7 == 2) {
            fontTextView.setText(getResources().getString(R.string.payment_success_pageds_nonebtn_return_order_list));
        } else {
            fontTextView.setText(getResources().getString(R.string.payment_success_pageds_nonebtn));
        }
        this.f25726x = (FontTextView) S(R.id.tv_order_details, true);
        this.f25727y = (FontTextView) S(R.id.tv_tell, true);
        this.f25728z = (FontTextView) S(R.id.tv_help, true);
        this.A = (FontTextView) S(R.id.tv_end_order, true);
        this.B = (FontTextView) S(R.id.tv_restart, true);
        this.F = (FontTextView) findViewById(R.id.tv_iv_message);
        this.C = (RelativeLayout) findViewById(R.id.iv_washer_lin);
        this.D = (ImageView) findViewById(R.id.iv_wahser_image);
        q0();
        if (!this.K.getOrderStatus().equals(String.valueOf(com.haier.globalwasher.modle.enum_.e.PAY_SUCCESS.b()))) {
            n0(this.K.getOrderStatus());
            return;
        }
        this.C.setVisibility(0);
        this.D.setVisibility(8);
        this.f25724v.setText(this.G.getString(R.string.payment_success_pageds_detail));
        this.f25724v.setTextColor(this.G.getColor(R.color.first_page_bottom_text_true));
        this.E.setText(0 + this.G.getString(R.string.payment_success_pageds_time_unit));
        if (this.K.isStart()) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
        this.f25722J = new a();
        IntentFilter intentFilter = new IntentFilter(i2.a.f34153y);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.f25722J, intentFilter, 4);
        } else {
            registerReceiver(this.f25722J, intentFilter);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public i f() {
        return this.H;
    }

    public void n0(String str) {
        q.c(Q, "changeClearButtonStuta");
        this.C.setVisibility(8);
        this.D.setVisibility(0);
        if (str.equals(String.valueOf(com.haier.globalwasher.modle.enum_.e.ORDER_SUCCESS.b()))) {
            this.B.setVisibility(8);
            this.A.setVisibility(8);
            this.D.setImageResource(R.drawable.icon_xidiwancheng);
            this.f25724v.setText(this.G.getString(R.string.payment_success_pageds_time_Washing_finish));
            this.f25724v.setTextColor(this.G.getColor(R.color.first_page_bottom_text_true));
            return;
        }
        this.A.setVisibility(8);
        if (this.K.isStart()) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
        this.D.setImageResource(R.drawable.pic_jiqiguzhang);
        this.f25724v.setText(this.G.getString(R.string.machine_fault_failure));
        this.f25724v.setTextColor(this.G.getColor(R.color.app_order_coler));
    }

    public com.haier.globalwasher.modle.utils.bluetoothutil.a.g o0() {
        v3.b uBluetoothBean;
        if (this.P == null) {
            int i7 = Integer.parseInt(this.K.getDeviceInfo().getBlueToolthInfo().getModuleType());
            if (i7 != 1) {
                uBluetoothBean = i7 != 2 ? null : new w3.a(this.K.getDeviceInfo().getBlueToolthInfo().getDeviceCode(), this.K.getDeviceInfo().getBlueToolthInfo().getBlueName(), this.K.getDeviceInfo().getBlueToolthInfo().getDirective());
            } else {
                uBluetoothBean = new UBluetoothBean(this.K.getDeviceInfo().getBlueToolthInfo().getAccessToken(), this.K.getDeviceInfo().getBlueToolthInfo().getBlueName(), this.K.getDeviceInfo().getBlueToolthInfo().getDirective());
            }
            p0();
            com.haier.globalwasher.modle.utils.bluetoothutil.a aVar = this.O;
            if (aVar != null) {
                Objects.requireNonNull(aVar);
                this.P = new d(aVar, true, uBluetoothBean);
            }
        }
        return this.P;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_to_use_others) {
            l0();
            return;
        }
        if (id == R.id.tv_tell) {
            h0.a(this, this.K.getDeviceInfo().getLaundryInfo().getHotLine() + "");
            return;
        }
        if (id == R.id.tv_order_details) {
            h.b(this, null, this.K.getOrderId(), com.haier.globalwasher.modle.enum_.d.ORDER_DETAIL_ACTIVITY, 0);
            return;
        }
        if (id != R.id.tv_help) {
            if (id == R.id.tv_end_order) {
                g.a(this, this.K, this.N);
                return;
            } else {
                if (id == R.id.tv_restart) {
                    g.c(this, this.K, new c());
                    return;
                }
                return;
            }
        }
        Intent intent = new Intent(this, (Class<?>) WebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", this.G.getString(R.string.my_page_help) + "");
        bundle.putString(y.f25407e, i2.a.G1);
        intent.putExtra(y.f25405c, bundle);
        startActivity(intent);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com.haier.globalwasher.modle.utils.bluetoothutil.a aVar = this.O;
        if (aVar != null) {
            aVar.s();
        }
        CountDownBroadcastReceiver countDownBroadcastReceiver = this.f25722J;
        if (countDownBroadcastReceiver != null) {
            unregisterReceiver(countDownBroadcastReceiver);
            this.f25722J = null;
        }
        MyBroadcastReceiver myBroadcastReceiver = this.I;
        if (myBroadcastReceiver != null) {
            unregisterReceiver(myBroadcastReceiver);
            this.I = null;
        }
        super.onDestroy();
    }

    @Override // com.haier.globalwasher.base.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i7, KeyEvent keyEvent) {
        if (i7 != 4) {
            return super.onKeyDown(i7, keyEvent);
        }
        l0();
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i7, @m0 String[] strArr, @m0 int[] iArr) {
        super.onRequestPermissionsResult(i7, strArr, iArr);
        com.haier.globalwasher.modle.utils.bluetoothutil.a aVar = this.O;
        if (aVar != null) {
            aVar.r(i7, strArr, iArr);
        }
    }

    public void p0() {
        if (this.O != null || this.K.getDeviceInfo().getBlueToolthInfo() == null) {
            return;
        }
        this.O = new com.haier.globalwasher.modle.utils.bluetoothutil.a(this, Integer.parseInt(this.K.getDeviceInfo().getBlueToolthInfo().getModuleType()));
    }

    public void q0() {
        this.I = new MyBroadcastReceiver(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.haier.globalwasher.modle.d.f24392a);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.I, intentFilter, 4);
        } else {
            registerReceiver(this.I, intentFilter);
        }
    }

    public void r0() {
        v3.b uBluetoothBean;
        OrderDetailsBeen orderDetailsBeen = this.K;
        if (orderDetailsBeen == null || orderDetailsBeen.getDeviceInfo() == null || this.K.getDeviceInfo().getBlueToolthInfo() == null) {
            return;
        }
        int i7 = Integer.parseInt(this.K.getDeviceInfo().getBlueToolthInfo().getModuleType());
        if (i7 != 1) {
            uBluetoothBean = i7 != 2 ? null : new w3.a(this.K.getDeviceInfo().getBlueToolthInfo().getDeviceCode(), this.K.getDeviceInfo().getBlueToolthInfo().getBlueName(), this.K.getDeviceInfo().getBlueToolthInfo().getDirective());
        } else {
            uBluetoothBean = new UBluetoothBean(this.K.getDeviceInfo().getBlueToolthInfo().getAccessToken(), this.K.getDeviceInfo().getBlueToolthInfo().getBlueName(), this.K.getDeviceInfo().getBlueToolthInfo().getDirective());
        }
        o0().w(uBluetoothBean, o0());
    }

    public void t0() {
        OrderDetailsBeen orderDetailsBeen = this.K;
        if (orderDetailsBeen == null || orderDetailsBeen.getDeviceInfo() == null || this.K.getDeviceInfo().getBlueToolthInfo() == null) {
            return;
        }
        o0().y(Integer.parseInt(this.K.getDeviceInfo().getBlueToolthInfo().getModuleType()) != 2 ? new UBluetoothBean(this.K.getDeviceInfo().getBlueToolthInfo().getAccessToken(), this.K.getDeviceInfo().getBlueToolthInfo().getBlueName(), this.K.getDeviceInfo().getBlueToolthInfo().getDirective()) : new w3.a(this.K.getDeviceInfo().getBlueToolthInfo().getDeviceCode(), this.K.getDeviceInfo().getBlueToolthInfo().getBlueName(), this.K.getDeviceInfo().getBlueToolthInfo().getDirective()), o0());
    }

    public void u0(com.jiao.project.bluetoothofabroadwasherapp.enums.c cVar, boolean z7) {
        o0().u(z7);
        o0().s(cVar);
        p0();
        com.haier.globalwasher.modle.utils.bluetoothutil.a aVar = this.O;
        if (aVar != null) {
            aVar.u(o0());
        }
    }
}
