package com.haier.globalwasher.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.DefaultPageBeen;
import com.haier.globalwasher.modle.bean.LatestVersion;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import com.haier.globalwasher.modle.bean.SettingPageBeen;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.mvp_api.moudle.BaseListDate;
import com.haier.globalwasher.presenter.broadcast_receiver.QuitLoginBroadcastReceiver;
import com.haier.globalwasher.view.activity.loginregistrationbackmodel.LoginActivity;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class q extends w2.a<BaseActivity> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f25275n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f25276o = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BaseActivity f25277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Resources f25278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private QuitLoginBroadcastReceiver f25279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f25280f = "isReceive";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25281g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f25282h = "osType";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f25283i = "2";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f25284j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f25285k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f25286l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f25287m = 3;

    class a extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25288g;

        a(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25288g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25288g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25288g.b(baseData);
        }
    }

    class b extends QuitLoginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseActivity f25290a;

        b(BaseActivity baseActivity) {
            this.f25290a = baseActivity;
        }

        @Override // com.haier.globalwasher.presenter.broadcast_receiver.QuitLoginBroadcastReceiver
        protected void a(Intent intent) {
            this.f25290a.unregisterReceiver(this);
        }
    }

    class c extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f25292g;

        c(String str) {
            this.f25292g = str;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            if ("00000".equals(baseData.getRetCode())) {
                ProfileAvatarImageBeen.getInstance().setIsReceiveMessage(this.f25292g);
            }
        }
    }

    class d extends com.haier.globalwasher.modle.network.a<BaseData> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25294g;

        d(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25294g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25294g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData baseData) {
            this.f25294g.b(baseData);
        }
    }

    class e extends com.haier.globalwasher.modle.network.a<BaseData<LatestVersion>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ com.haier.globalwasher.mvp_api.moudle.b f25296g;

        e(com.haier.globalwasher.mvp_api.moudle.b bVar) {
            this.f25296g = bVar;
        }

        @Override // com.haier.globalwasher.modle.network.a
        public void i(Exception exc) {
            this.f25296g.a(exc);
        }

        @Override // com.haier.globalwasher.modle.network.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void p(BaseData<LatestVersion> baseData) {
            this.f25296g.b(baseData);
        }
    }

    @Override // w2.a
    public BaseActivity f(BaseActivity baseActivity) {
        this.f25277c = baseActivity;
        this.f25278d = baseActivity.getResources();
        return baseActivity;
    }

    public int g(Activity activity) {
        try {
            this.f25281g = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e8) {
            this.f25281g = -1;
            e8.printStackTrace();
        }
        return this.f25281g;
    }

    public void h() {
        try {
            com.haier.globalwasher.modle.utils.f.a(MyApplication.k());
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public String i() {
        try {
            return this.f25277c.getPackageManager().getPackageInfo(this.f25277c.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e8) {
            e8.printStackTrace();
            return "";
        }
    }

    public void j(com.haier.globalwasher.mvp_api.moudle.b<BaseData<LatestVersion>> bVar) {
        HashMap map = new HashMap();
        map.put("osType", "2");
        new e(bVar).j(0, this.f25277c, i2.a.f34098f1, i2.a.f34101g1, map, LatestVersion.class, 1);
    }

    public String k() {
        try {
            return com.haier.globalwasher.modle.utils.f.f(MyApplication.k());
        } catch (Exception e8) {
            e8.printStackTrace();
            return "";
        }
    }

    public void l(com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        new a(bVar).g(1, this.f25277c, i2.a.f34139t0, i2.a.f34142u0, new HashMap(), null, 1);
    }

    public void m(String str, com.haier.globalwasher.mvp_api.moudle.b<BaseData> bVar) {
        HashMap map = new HashMap();
        map.put("isReceive", str);
        new d(bVar).g(1, this.f25277c, i2.a.f34157z0, i2.a.A0, map, null, 1);
    }

    public void n(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<SettingPageBeen>> bVar) {
        BaseListDate<SettingPageBeen> baseListDate = new BaseListDate<>();
        ArrayList<SettingPageBeen> arrayList = new ArrayList<>();
        arrayList.add(new SettingPageBeen(this.f25278d.getString(R.string.clear_cache_push), "", 0));
        arrayList.add(new SettingPageBeen(this.f25278d.getString(R.string.secuity_center_nav_title), "", 1));
        arrayList.add(new SettingPageBeen(this.f25278d.getString(R.string.clear_cache_cachecleanner), k(), 2));
        arrayList.add(new SettingPageBeen(this.f25278d.getString(R.string.clear_cache_version), i(), 3));
        baseListDate.setRetCode("00000");
        baseListDate.setData(arrayList);
        bVar.b(baseListDate);
        String strA = t2.a.a(this.f25277c, t2.a.f40362i, t2.a.f40366m);
        if (ProfileAvatarImageBeen.getInstance().getIsReceiveMessage() == null || !ProfileAvatarImageBeen.getInstance().getIsReceiveMessage().equals(strA)) {
            m(strA, new c(strA));
        }
    }

    public void o(com.haier.globalwasher.mvp_api.moudle.b<BaseListDate<DefaultPageBeen>> bVar) {
        BaseListDate<DefaultPageBeen> baseListDate = new BaseListDate<>();
        ArrayList<DefaultPageBeen> arrayList = new ArrayList<>();
        arrayList.add(new DefaultPageBeen(this.f25278d.getString(R.string.secuity_center_cancellation_accoun), "", 0));
        arrayList.add(new DefaultPageBeen(this.f25278d.getString(R.string.secuity_center_privacy_policy), "", 1));
        baseListDate.setRetCode("00000");
        baseListDate.setData(arrayList);
        bVar.b(baseListDate);
    }

    public void p(BaseActivity baseActivity, int i7) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(i2.a.f34126p);
        if (this.f25279e == null) {
            this.f25279e = new b(baseActivity);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            baseActivity.registerReceiver(this.f25279e, intentFilter, 4);
        } else {
            baseActivity.registerReceiver(this.f25279e, intentFilter);
        }
        Intent intent = new Intent(i2.a.f34126p);
        intent.putExtra(y.f25405c, new Bundle());
        baseActivity.sendBroadcast(intent);
        if (i7 == 2) {
            baseActivity.startActivity(new Intent(baseActivity, (Class<?>) LoginActivity.class));
        }
        baseActivity.finish();
    }
}
