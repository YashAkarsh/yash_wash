package com.haier.globalwasher.view.activity.order;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.view.View;
import c.t0;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.CountDownBeen;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.modle.bean.VerificationDeviceCodeBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver;
import com.haier.globalwasher.presenter.k;
import com.haier.globalwasher.view.activity.MainActivity;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.text.MessageFormat;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SubscriptSuccessfulActivity extends BaseActivity {
    public static final String D = "SubscriptSuccessfulActivity";
    private k A = new k();
    OrderDetailsBeen B;
    CountDownBroadcastReceiver C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private FontTextView f25752u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private FontTextView f25753v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private FontTextView f25754w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private FontTextView f25755x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f25756y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f25757z;

    class a extends CountDownBroadcastReceiver {
        a() {
        }

        @Override // com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver
        public void a(ArrayList<CountDownBeen> arrayList) {
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                if (arrayList.get(i7).getWashOrderId().equals(SubscriptSuccessfulActivity.this.B.getOrderId())) {
                    SubscriptSuccessfulActivity.this.B.setOrderStatus(arrayList.get(i7).getStatuId() + "");
                    long overTime = arrayList.get(i7).getOverTime();
                    if (overTime == 0) {
                        SubscriptSuccessfulActivity.this.finish();
                        return;
                    }
                    long j7 = overTime / 1000;
                    int i8 = (int) (j7 / 60);
                    int i9 = (int) (j7 % 60);
                    String str = i9 < 10 ? i8 + ":0" + i9 : i8 + ":" + i9;
                    SubscriptSuccessfulActivity.this.f0(str);
                    SubscriptSuccessfulActivity.this.f25752u.setText(SubscriptSuccessfulActivity.this.getResources().getString(R.string.successful_appointment_theretitle) + " " + str);
                    return;
                }
            }
        }
    }

    class b implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<VerificationDeviceCodeBeen>> {
        b() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<VerificationDeviceCodeBeen> baseData) {
            if ("00000".equals(baseData.getRetCode())) {
                q.c(SubscriptSuccessfulActivity.D, "   object.getData().getVertifiedCode()=" + baseData.getData().getVertifiedCode() + "  MyApplication.TEST_FUNCTION=" + MyApplication.f24259o);
                if (MyApplication.f24259o && baseData.getData() != null && baseData.getData().getVertifiedCode() != null) {
                    i0.d(SubscriptSuccessfulActivity.this, "" + baseData.getData().getVertifiedCode());
                }
                SubscriptSuccessfulActivity subscriptSuccessfulActivity = SubscriptSuccessfulActivity.this;
                SendCodeActivity.h0(subscriptSuccessfulActivity.B, subscriptSuccessfulActivity);
                SubscriptSuccessfulActivity.this.finish();
            }
        }
    }

    public static void h0(OrderDetailsBeen orderDetailsBeen, BaseActivity baseActivity) {
        Intent intent = new Intent(baseActivity, (Class<?>) SubscriptSuccessfulActivity.class);
        if (orderDetailsBeen == null) {
            return;
        }
        intent.putExtra(k.f25191f, orderDetailsBeen);
        baseActivity.startActivity(intent);
        if (baseActivity instanceof MainActivity) {
            return;
        }
        baseActivity.finish();
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_subscript_successful;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    @t0(api = 16)
    public void d() {
        d0(getResources().getString(R.string.successful_appointment_title), 1, P("0:00", null));
        OrderDetailsBeen orderDetailsBeen = (OrderDetailsBeen) getIntent().getSerializableExtra(k.f25191f);
        this.B = orderDetailsBeen;
        this.f25756y = d0.f(orderDetailsBeen.getDeviceInfo().getSerialNumber());
        String timeRemaining = d0.j(this.B.getDeviceInfo().getTimeRemaining()) ? this.B.getDeviceInfo().getTimeRemaining() : "0";
        if ("0".equals(timeRemaining)) {
            timeRemaining = this.B.getRunMode().getTimeDuration();
        }
        this.f25757z = Integer.parseInt(timeRemaining) * Integer.parseInt(this.B.getRunCount());
        FontTextView fontTextView = (FontTextView) findViewById(R.id.tv_time);
        this.f25752u = fontTextView;
        fontTextView.setText(getResources().getString(R.string.successful_appointment_theretitle) + " 0:00");
        this.f25754w = (FontTextView) findViewById(R.id.tv_send_code);
        this.f25753v = (FontTextView) findViewById(R.id.tv_device_number);
        this.f25755x = (FontTextView) findViewById(R.id.tv_device_number_tow);
        if (this.B.getOrderStatus().equals("101")) {
            this.f25754w.setOnClickListener(null);
            this.f25754w.setBackground(getResources().getDrawable(R.drawable.background_huise_button));
            this.f25754w.setTextColor(getResources().getColor(R.color.app_white));
            this.f25752u.setVisibility(8);
            this.f25755x.setVisibility(8);
            this.f25753v.setText(MessageFormat.format(getResources().getString(R.string.successful_appointment_details_appointment), this.f25757z + " " + getResources().getString(R.string.payment_success_pageds_time_unit)));
        } else {
            this.f25753v.setText(MessageFormat.format(getResources().getString(R.string.successful_appointment_detailsone), "#" + this.f25756y));
            this.f25752u.setVisibility(0);
            this.f25755x.setVisibility(0);
            this.f25754w.setOnClickListener(this);
        }
        this.C = new a();
        IntentFilter intentFilter = new IntentFilter(i2.a.f34153y);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.C, intentFilter, 4);
        } else {
            registerReceiver(this.C, intentFilter);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        return this.A;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (R.id.tv_send_code == view.getId()) {
            if (RegisterBeen.getInstance().getTime() == 0) {
                this.A.f(this.B.getOrderId(), new b());
            } else {
                SendCodeActivity.h0(this.B, this);
                finish();
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.C);
        this.C = null;
    }
}
