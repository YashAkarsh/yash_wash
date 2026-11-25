package com.haier.globalwasher.view.activity.order;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.CountDownBeen;
import com.haier.globalwasher.modle.bean.OrderDetailsBeen;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.modle.bean.VerificationDeviceCodeBeen;
import com.haier.globalwasher.modle.enum_.d;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver;
import com.haier.globalwasher.presenter.h;
import com.haier.globalwasher.presenter.k;
import com.haier.globalwasher.view.custom_view.FontTextView;
import com.haier.hailicommontlib.BaseApplication;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SendCodeActivity extends BaseActivity {
    OrderDetailsBeen B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private EditText f25744v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private FontTextView f25745w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private FontTextView f25746x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private FontTextView f25747y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    CountDownBroadcastReceiver f25748z;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private k f25743u = new k();
    private int A = 30;
    private String C = "SendCodeActivity";

    class a extends CountDownBroadcastReceiver {
        a() {
        }

        @Override // com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver
        public void a(ArrayList<CountDownBeen> arrayList) {
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                if (arrayList.get(i7).getWashOrderId().equals(SendCodeActivity.this.B.getOrderId())) {
                    long overTime = arrayList.get(i7).getOverTime();
                    long j7 = overTime / 1000;
                    int i8 = (int) (j7 / 60);
                    int i9 = (int) (j7 % 60);
                    SendCodeActivity.this.f0(i9 < 10 ? i8 + ":0" + i9 : i8 + ":" + i9);
                    if (overTime == 0) {
                        SendCodeActivity.this.finish();
                        return;
                    }
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
            if ("00000".equals(baseData.getRetCode()) && !BaseApplication.f26153d && d0.j(baseData.getData().getVertifiedCode())) {
                i0.d(SendCodeActivity.this, "" + baseData.getData().getVertifiedCode());
            }
        }
    }

    class c implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<VerificationDeviceCodeBeen>> {
        c() {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            q.c("GsonRequest", exc.toString());
            SendCodeActivity.this.f25746x.setVisibility(0);
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<VerificationDeviceCodeBeen> baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                SendCodeActivity.this.f25746x.setVisibility(0);
                return;
            }
            SendCodeActivity.this.f25746x.setVisibility(8);
            SendCodeActivity sendCodeActivity = SendCodeActivity.this;
            h.b(sendCodeActivity, null, sendCodeActivity.B.getOrderId(), d.ORDER_PAY_ACTIVITY, 0);
        }
    }

    public static void h0(OrderDetailsBeen orderDetailsBeen, Context context) {
        Intent intent = new Intent(context, (Class<?>) SendCodeActivity.class);
        intent.putExtra(k.f25192g, orderDetailsBeen);
        intent.putExtra(k.f25192g, orderDetailsBeen);
        context.startActivity(intent);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_send_code;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        this.B = (OrderDetailsBeen) getIntent().getSerializableExtra(k.f25192g);
        this.f25744v = (EditText) S(R.id.et_code, true);
        this.f25745w = (FontTextView) S(R.id.tv_send_code, true);
        if (RegisterBeen.getInstance().getTime() == 0) {
            this.f25743u.e(this.f25745w, this.A);
        } else {
            this.f25743u.e(this.f25745w, RegisterBeen.getInstance().getTime());
        }
        this.f25746x = (FontTextView) findViewById(R.id.tv_error);
        this.f25747y = (FontTextView) S(R.id.tv_confirmed, true);
        d0(getResources().getString(R.string.verify_the_machine_title), 1, P("0:00", null));
        this.f25748z = new a();
        IntentFilter intentFilter = new IntentFilter(i2.a.f34153y);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.f25748z, intentFilter, 4);
        } else {
            registerReceiver(this.f25748z, intentFilter);
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        return this.f25743u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.tv_send_code) {
            this.f25743u.e(this.f25745w, this.A);
            this.f25743u.f(this.B.getOrderId(), new b());
        } else if (view.getId() != R.id.et_code && view.getId() == R.id.tv_confirmed) {
            if (this.f25744v.getText() == null || this.f25744v.getText().length() <= 0) {
                this.f25746x.setVisibility(0);
            } else {
                this.f25746x.setVisibility(8);
                this.f25743u.d(this.f25744v.getText().toString(), this.B.getOrderId(), new c());
            }
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        CountDownBroadcastReceiver countDownBroadcastReceiver = this.f25748z;
        if (countDownBroadcastReceiver != null) {
            unregisterReceiver(countDownBroadcastReceiver);
        }
    }
}
