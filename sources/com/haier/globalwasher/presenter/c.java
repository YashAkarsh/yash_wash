package com.haier.globalwasher.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import c.t0;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.APIContralViewBean;
import com.haier.globalwasher.modle.bean.LatestVersion;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import com.haier.globalwasher.modle.bean.advertis.FirstPagePopupWindowAdvertisBean;
import com.haier.globalwasher.modle.utils.m0;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.view.activity.MainActivity;
import com.haier.globalwasher.view.activity.SplashActivity;
import com.haier.globalwasher.view.activity.WebActivity;
import com.haier.globalwasher.view.activity.loginregistrationbackmodel.LoginActivity;
import com.haier.globalwasher.view.activity.my_page.CouponActivity;
import com.haier.globalwasher.view.activity.my_page.MessageActivity;
import com.haier.globalwasher.view.activity.my_page.SettingActivity;
import java.util.HashMap;
import java.util.Locale;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.haier.globalwasher.mvp_api.presenter.b<BaseActivity> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f25077j = "phoneNumber";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BaseActivity f25078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f25079c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f25080d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f25081e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f25082f = "osType";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f25083g = "2";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f25084h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f25085i = "isReceive";

    class a extends com.haier.globalwasher.modle.network.a<BaseListDate<APIContralViewBean>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25086g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25086g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25086g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<APIContralViewBean> baseListDate) {
            this.f25086g.b(baseListDate);
        }
    }

    class b extends com.haier.globalwasher.modle.network.a<BaseData<APIContralViewBean>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25088g;

        b(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25088g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25088g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<APIContralViewBean> baseData) {
            this.f25088g.b(baseData);
        }
    }

    /* JADX INFO: renamed from: com.haier.globalwasher.presenter.c$c, reason: collision with other inner class name */
    class C0330c extends com.haier.globalwasher.modle.network.a<com.haier.globalwasher.modle.h> {
        C0330c() {
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            com.haier.globalwasher.modle.utils.q.c("System.", exc.toString());
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(com.haier.globalwasher.modle.h hVar) {
            try {
                com.haier.globalwasher.modle.utils.q.c("System.", new String(hVar.toString().replace(" ", "+").getBytes(), "UTF-8"));
                byte[] bArrDecodeBase64 = Base64.decodeBase64("KlHidTCqmX5iGBkruff7J+ZHyG74q4z/Vyam8AJERYQH3QCneDxb39eVVOUMzGEMRVdSR/RgX7FH0yytggaENgmLzJEWqY+H9MMWMUj4ECuqfuLa4IVPMsSU1Spv583pXeKWz5L0AWoNKvs3BII3qHv/5AG3rHwJFgzmnI9i8TFL/WWE1TfqMJr279pWEorcjrAOfztZeRndrpqHKIJRF1ORBba/yqrx6sz7ZN6epEww2HcwML6U7Y/01SwkzbX2lGo9IsW1pgA+KOlK6Fr1ygyuPwfSx3/ljBCYBEeOjAbAvcdthDnC53CGjZnjOhL2G3uJ+6Ix+7TSuPV4qr6Fcg==".getBytes("UTF-8"));
                String str = new String(bArrDecodeBase64, "UTF-8");
                System.out.println("原数据        " + hVar.b());
                System.out.println("base64处理    " + str);
                byte[] bArrA = m0.a(i2.a.f34111k.getBytes(), bArrDecodeBase64);
                System.out.println("解密之后       " + new String(bArrA, "UTF-8"));
                com.haier.globalwasher.modle.utils.q.a("volleyNormalRequest", "" + new String(bArrA, "UTF-8"));
                System.out.println("处理之后----------");
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        }
    }

    class d extends com.haier.globalwasher.modle.network.a<BaseData<LatestVersion>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25091g;

        d(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25091g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25091g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<LatestVersion> baseData) {
            this.f25091g.b(baseData);
        }
    }

    class e extends com.haier.globalwasher.modle.network.a<BaseData<ProfileAvatarImageBeen>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25093g;

        e(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25093g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25093g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<ProfileAvatarImageBeen> baseData) {
            this.f25093g.b(baseData);
        }
    }

    class f extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25095g;

        f(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25095g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25095g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25095g.b(baseData);
        }
    }

    class g extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25097g;

        g(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25097g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25097g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25097g.b(baseData);
        }
    }

    class h extends com.haier.globalwasher.modle.network.a<BaseListDate<FirstPagePopupWindowAdvertisBean>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25099g;

        h(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25099g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25099g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseListDate<FirstPagePopupWindowAdvertisBean> baseListDate) {
            this.f25099g.b(baseListDate);
        }
    }

    @t0(api = 26)
    public void b(String str) {
        try {
            byte[] bArrDecodeBase64 = Base64.decodeBase64("UNEtaCE563BuscomFOVebz7sfAuL+vFLKjAfCDKyvbMaUn665eWORfs9ilxUwWpKwfaG/3N1bGQj10ZLaq/bjLDPLViBFDOsvsyuBFnZdNOT3YLqyKpjOQk4ltY7iSDAscllwazp2SwPFX0TWBRzM4fP5+kLaZ5cWwmnnqHFp5eN3mbBP0hqqWCQoZlyIrgfPpeOHQ0+/Xg8GfrHWAo9GUdr55trhKnuNT5BaB3/SLbQKgwnnVTFgQb0NtePtzeuqSlsiD/I+LEJ+COpdviR+IxIuqtebS6XNxg/rhUQRLwM/cRWbsFGP2j6WRV2LAo8rRgg1MmITzyZcI2DJLPCTw==".getBytes("UTF-8"));
            String str2 = new String(bArrDecodeBase64, "UTF-8");
            System.out.println("base64处理    " + str2);
            m0.a(i2.a.f34111k.getBytes(), bArrDecodeBase64);
            JSONObject jSONObject = new JSONObject();
            new HashMap();
            jSONObject.put("type", "1");
            System.out.println(jSONObject.toString());
            new C0330c();
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public int c(Activity activity) {
        try {
            this.f25084h = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e8) {
            this.f25084h = -1;
            e8.printStackTrace();
        }
        return this.f25084h;
    }

    public void d(MainActivity mainActivity, String str) {
        t2.a.b(mainActivity, t2.a.f40362i, t2.a.f40367n, str);
        Resources resources = MyApplication.k().getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        str.hashCode();
        if (str.equals("en")) {
            configuration.locale = Locale.ENGLISH;
        } else if (str.equals("zh")) {
            configuration.locale = Locale.CHINESE;
        }
        resources.updateConfiguration(configuration, displayMetrics);
        this.f25078b.startActivity(new Intent(this.f25078b, (Class<?>) SplashActivity.class));
        this.f25078b.finish();
    }

    public void e(com.haier.globalwasher.mvp_api.moudle.b<BaseData<LatestVersion>> bVar) {
        HashMap map = new HashMap();
        map.put("osType", "2");
        new d(bVar).j(0, this.f25078b, i2.a.f34098f1, i2.a.f34101g1, map, LatestVersion.class, 1);
    }

    public void f(com.haier.globalwasher.mvp_api.moudle.b<BaseData<ProfileAvatarImageBeen>> bVar) {
        new e(bVar).j(0, this.f25078b, i2.a.D0, i2.a.E0, new HashMap(), ProfileAvatarImageBeen.class, 1);
    }

    public void g(String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        map.put("isReceive", str);
        new g(bVar).g(1, this.f25078b, i2.a.f34157z0, i2.a.A0, map, null, 1);
    }

    public void h(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<APIContralViewBean>> bVar) {
        new a(bVar).j(0, this.f25078b, i2.a.T1, i2.a.U1, new HashMap(), APIContralViewBean.class, 2);
    }

    public void i(com.haier.globalwasher.mvp_api.moudle.b<BaseData<APIContralViewBean>> bVar) {
        new b(bVar).j(0, this.f25078b, i2.a.V1, i2.a.W1, new HashMap(), APIContralViewBean.class, 1);
    }

    public void j(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<FirstPagePopupWindowAdvertisBean>> bVar) {
        HashMap map = new HashMap();
        map.put("type", "1");
        new h(bVar).j(1, this.f25078b, i2.a.X1, i2.a.Y1, map, FirstPagePopupWindowAdvertisBean.class, 2);
    }

    public void k(com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        map.put("phoneNumber", "008618600814320");
        new f(bVar).j(1, this.f25078b, i2.a.P1, i2.a.Q1, map, null, 1);
    }

    @Override // com.haier.globalwasher.mvp_api.presenter.b
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void a(BaseActivity baseActivity) {
        this.f25078b = baseActivity;
    }

    public void m(int i7, Activity activity) {
        Intent intent;
        if (i7 == 0) {
            intent = new Intent(activity, (Class<?>) MessageActivity.class);
        } else if (i7 == 1) {
            intent = new Intent(activity, (Class<?>) CouponActivity.class);
        } else if (i7 == 2) {
            intent = new Intent(activity, (Class<?>) SettingActivity.class);
        } else if (i7 == 3) {
            intent = new Intent(activity, (Class<?>) WebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("title", activity.getResources().getString(R.string.my_page_help) + "");
            bundle.putString(y.f25407e, i2.a.G1);
            intent.putExtra(y.f25405c, bundle);
        } else {
            intent = null;
        }
        activity.startActivity(intent);
    }

    public void n(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) LoginActivity.class));
    }
}
