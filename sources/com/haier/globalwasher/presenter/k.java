package com.haier.globalwasher.presenter;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.modle.bean.VerificationDeviceCodeBeen;
import com.haier.globalwasher.modle.utils.g0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class k implements com.haier.globalwasher.mvp_api.presenter.b<BaseActivity> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f25190e = "orderId";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f25191f = "DeviceDetailBeen";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f25192g = "firstPageOrderBeen";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseActivity f25193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f25194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private Handler f25195d = new a();

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i7 = message.what;
            if (i7 != 0) {
                if (i7 != 2) {
                    return;
                }
                k.this.f25194c.setBackgroundResource(R.drawable.button_background_g40_stroke);
                k.this.f25194c.setText(k.this.f25193b.getResources().getString(R.string.verify_the_machine_resed));
                k.this.f25194c.setEnabled(true);
                return;
            }
            int iIntValue = ((Integer) message.obj).intValue();
            RegisterBeen.getInstance().setTime(iIntValue);
            k.this.f25194c.setText(iIntValue + "s");
            k.this.f25194c.setEnabled(false);
        }
    }

    class b extends com.haier.globalwasher.modle.network.a<BaseData<VerificationDeviceCodeBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25197g;

        b(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25197g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25197g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<VerificationDeviceCodeBeen> baseData) {
            this.f25197g.b(baseData);
        }
    }

    class c extends com.haier.globalwasher.modle.network.a<BaseData<VerificationDeviceCodeBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25199g;

        c(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25199g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25199g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<VerificationDeviceCodeBeen> baseData) {
            this.f25199g.b(baseData);
        }
    }

    public void d(String str, String str2, com.haier.globalwasher.mvp_api.moudle.b<BaseData<VerificationDeviceCodeBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("orderId", str2);
        map.put("vertifiedCode", str);
        new c(bVar).j(1, this.f25193b, i2.a.f34110j1, i2.a.f34113k1, map, VerificationDeviceCodeBeen.class, 1);
    }

    public void e(TextView textView, int i7) {
        this.f25194c = textView;
        textView.setEnabled(false);
        new g0(this.f25195d, i7).d();
    }

    public void f(String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData<VerificationDeviceCodeBeen>> bVar) {
        HashMap map = new HashMap();
        map.put("orderId", str);
        new b(bVar).j(1, this.f25193b, i2.a.f34104h1, i2.a.f34107i1, map, VerificationDeviceCodeBeen.class, 1);
    }

    @Override // com.haier.globalwasher.mvp_api.presenter.b
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void a(BaseActivity baseActivity) {
        this.f25193b = baseActivity;
    }
}
