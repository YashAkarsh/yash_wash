package com.haier.globalwasher.presenter;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.widget.EditText;
import android.widget.TextView;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.CountryCode;
import com.haier.globalwasher.modle.bean.LoginResultBeen;
import com.haier.globalwasher.modle.bean.RegisterBeen;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.g0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.view.activity.loginregistrationbackmodel.LoginActivity;
import com.haier.globalwasher.view.activity.loginregistrationbackmodel.LoginPhoneActivity;
import com.haier.globalwasher.view.activity.loginregistrationbackmodel.RegisterActivity;
import com.haier.globalwasher.view.activity.loginregistrationbackmodel.RetrievePassWordActivity;
import com.haier.globalwasher.view.activity.loginregistrationbackmodel.RetrievePhoneActivity;
import com.haier.globalwasher.view.activity.loginregistrationbackmodel.VerificationCodeActivity;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.haier.globalwasher.mvp_api.presenter.b<BaseActivity> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f25102g = "1";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f25103h = "2";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f25104i = "3";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f25105j = "1";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f25106k = "2";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f25107l = "3";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f25108m = "4";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f25109n = "phoneNumber";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f25110o = "type";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f25111p = "verifyCode";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f25112q = "userName";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f25113r = "deviceType";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f25114s = "osVersion";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f25115t = "password";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f25116u = "channelId";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f25117v = "androidUserId";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseActivity f25118b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f25121e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f25119c = "id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25120d = "checked";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private Handler f25122f = new a();

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
                e.this.f25121e.setBackgroundResource(R.drawable.background_blue_button);
                e.this.f25121e.setText(e.this.f25118b.getResources().getString(R.string.verify_code_btn_resend));
                e.this.f25121e.setEnabled(true);
                return;
            }
            int iIntValue = ((Integer) message.obj).intValue();
            RegisterBeen.getInstance().setTime(iIntValue);
            e.this.f25121e.setText(iIntValue + "s");
            e.this.f25121e.setEnabled(false);
        }
    }

    class b extends com.haier.globalwasher.modle.network.a<BaseListDate<CountryCode>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25124g;

        b(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25124g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25124g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<CountryCode> baseListDate) {
            this.f25124g.b(baseListDate);
        }
    }

    class c extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25126g;

        c(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25126g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25126g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25126g.b(baseData);
        }
    }

    class d extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25128g;

        d(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25128g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25128g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25128g.b(baseData);
        }
    }

    /* JADX INFO: renamed from: com.haier.globalwasher.presenter.e$e, reason: collision with other inner class name */
    class C0331e extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25130g;

        C0331e(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25130g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25130g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25130g.b(baseData);
        }
    }

    class f extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25132g;

        f(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25132g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25132g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25132g.b(baseData);
        }
    }

    class g extends com.haier.globalwasher.modle.network.a<BaseData<LoginResultBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25134g;

        g(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25134g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25134g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<LoginResultBeen> baseData) {
            this.f25134g.b(baseData);
        }
    }

    class h extends com.haier.globalwasher.modle.network.a<BaseData<LoginResultBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25136g;

        h(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25136g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25136g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<LoginResultBeen> baseData) {
            this.f25136g.b(baseData);
        }
    }

    public void d(String str, String str2, String str3, String str4, com.haier.globalwasher.mvp_api.moudle.b<BaseData<LoginResultBeen>> bVar) {
        int i7;
        String str5;
        HashMap map = new HashMap();
        map.put("phoneNumber", "" + str);
        map.put("type", "" + str2);
        map.put("deviceType", "2");
        map.put(f25116u, "");
        map.put(f25117v, "" + RegisterBeen.getInstance().getAndroidUserId());
        try {
            i7 = this.f25118b.getPackageManager().getPackageInfo(this.f25118b.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e8) {
            e8.printStackTrace();
            i7 = -1;
        }
        if (i7 > 0) {
            str5 = i7 + "";
        } else {
            str5 = "";
        }
        map.put(f25114s, str5);
        map.put("password", "" + str3);
        map.put("verifyCode", "" + str4);
        new h(bVar).g(1, this.f25118b, i2.a.f34121n0, i2.a.f34124o0, map, LoginResultBeen.class, 1);
    }

    public void e(String str, String str2, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        map.put("phoneNumber", "" + str);
        if (d0.j(str2)) {
            map.put("email", "" + str2);
        }
        new d(bVar).g(1, this.f25118b, i2.a.f34103h0, i2.a.f34106i0, map, null, 1);
    }

    public void f(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<CountryCode>> bVar) {
        new b(bVar).j(0, this.f25118b, i2.a.f34091d0, i2.a.f34094e0, new HashMap(), CountryCode.class, 2);
    }

    public void g(String str, String str2, String str3, String str4, String str5, com.haier.globalwasher.mvp_api.moudle.b<BaseData<LoginResultBeen>> bVar) {
        int i7;
        String str6;
        HashMap map = new HashMap();
        map.put("phoneNumber", "" + str);
        map.put(f25112q, "" + str2);
        map.put("deviceType", "2");
        map.put(f25116u, "");
        map.put(f25117v, "" + RegisterBeen.getInstance().getAndroidUserId());
        map.put("email", "" + str5);
        try {
            i7 = this.f25118b.getPackageManager().getPackageInfo(this.f25118b.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e8) {
            e8.printStackTrace();
            i7 = -1;
        }
        if (i7 > 0) {
            str6 = i7 + "";
        } else {
            str6 = "";
        }
        map.put(f25114s, str6);
        map.put("password", "" + str3);
        map.put("verifyCode", "" + str4);
        new g(bVar).g(1, this.f25118b, i2.a.f34115l0, i2.a.f34118m0, map, LoginResultBeen.class, 1);
    }

    public void h(String str, String str2, String str3, String str4, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        if (d0.j(str)) {
            map.put("phoneNumber", "" + str);
        }
        if (d0.j(str2)) {
            map.put("email", "" + str2);
        }
        map.put("password", "" + str3);
        map.put("verifyCode", "" + str4);
        new f(bVar).g(1, this.f25118b, i2.a.f34127p0, i2.a.f34130q0, map, null, 1);
    }

    public void i(String str, String str2, String str3, String str4, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        if (d0.j(str)) {
            map.put("phoneNumber", "" + str);
        }
        if (d0.j(str4)) {
            map.put("email", "" + str4);
        }
        map.put("type", "" + str2);
        map.put("verifyCode", "" + str3);
        new C0331e(bVar).g(1, this.f25118b, i2.a.f34109j0, i2.a.f34112k0, map, null, 1);
    }

    public void j(String str, String str2, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        k(str, str2, "", bVar);
    }

    public void k(String str, String str2, String str3, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        if (d0.j(str)) {
            map.put("phoneNumber", "" + str);
        }
        map.put("type", "" + str2);
        if (d0.j(str3)) {
            map.put("email", "" + str3);
        }
        new c(bVar).g(1, this.f25118b, i2.a.f34097f0, i2.a.f34100g0, map, null, 1);
    }

    public void l(TextView textView, int i7) {
        this.f25121e = textView;
        textView.setEnabled(false);
        new g0(this.f25122f, i7).d();
    }

    public void m() {
        MyApplication.i(RetrievePassWordActivity.class);
        MyApplication.i(LoginActivity.class);
        MyApplication.i(LoginPhoneActivity.class);
        MyApplication.i(RegisterActivity.class);
        MyApplication.i(RetrievePhoneActivity.class);
        MyApplication.i(VerificationCodeActivity.class);
    }

    public void n(EditText editText) {
        Editable text = editText.getText();
        if (!(text instanceof Spannable) || "".equals(editText.getText().toString())) {
            return;
        }
        Selection.setSelection(text, text.length());
    }

    @Override // com.haier.globalwasher.mvp_api.presenter.b
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void a(BaseActivity baseActivity) {
        this.f25118b = baseActivity;
    }
}
