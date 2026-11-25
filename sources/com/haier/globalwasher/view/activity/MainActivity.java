package com.haier.globalwasher.view.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import c.m0;
import c.t0;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.base.SelectListActivity;
import com.haier.globalwasher.base.d;
import com.haier.globalwasher.modle.bean.LatestVersion;
import com.haier.globalwasher.modle.bean.ProfileAvatarImageBeen;
import com.haier.globalwasher.modle.utils.h;
import com.haier.globalwasher.modle.utils.i0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.broadcast_receiver.CountDownBroadcastReceiver;
import com.haier.globalwasher.presenter.broadcast_receiver.QuitLoginBroadcastReceiver;
import com.haier.globalwasher.presenter.services.UpdateIntentService;
import com.haier.globalwasher.view.activity.loginregistrationbackmodel.LoginActivity;
import com.haier.globalwasher.view.custom_view.NoSlidingViewPager;
import com.haier.globalwasher.view.fragment.FPOrderFragment;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MainActivity extends SelectListActivity {
    private static final String A0 = "page";
    private static final String Z = "MainActivity";
    public com.haier.globalwasher.presenter.c O;
    private c Q;
    private com.haier.globalwasher.modle.utils.bluetoothutil.a R;
    Resources U;
    private h Y;
    public int P = -1;
    ArrayList<com.haier.globalwasher.base.a> S = new ArrayList<>();
    ArrayList<d> T = new ArrayList<>();
    private QuitLoginBroadcastReceiver V = new a();
    public ArrayList<Drawable> W = new ArrayList<>();
    public ArrayList<Drawable> X = new ArrayList<>();

    class a extends QuitLoginBroadcastReceiver {
        a() {
        }

        @Override // com.haier.globalwasher.presenter.broadcast_receiver.QuitLoginBroadcastReceiver
        protected void a(Intent intent) {
            q.c(MainActivity.Z, "Mainactivity.quitLogin");
            MainActivity.this.m0(0);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f25432a;

        b(int i7) {
            this.f25432a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f25432a < MainActivity.this.f24298x.getChildCount()) {
                MainActivity.this.f24298x.setCurrentItem(this.f25432a);
            }
        }
    }

    class c implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<LatestVersion>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MainActivity f25434a;

        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.u0();
            }
        }

        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.u0();
            }
        }

        public c(MainActivity mainActivity) {
            this.f25434a = mainActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<LatestVersion> baseData) {
            if (!"00000".equals(baseData.getRetCode()) || TextUtils.isEmpty(baseData.getData().toString()) || Integer.parseInt(baseData.getData().getVersionNumber()) <= MainActivity.this.P) {
                return;
            }
            if (("" + baseData.getData().getIsMandatory()).equals("N")) {
                MainActivity mainActivity = MainActivity.this;
                z.c(mainActivity, 1, 2, "", mainActivity.U.getString(R.string.version_update), MainActivity.this.U.getString(R.string.areacodelist_choose_cancel), MainActivity.this.U.getString(R.string.areacodelist_choose_determine), null, new a());
            } else {
                MainActivity mainActivity2 = MainActivity.this;
                z.b(mainActivity2, 2, 2, 1, "", mainActivity2.U.getString(R.string.version_update), MainActivity.this.U.getString(R.string.areacodelist_choose_determine), new b(), null);
            }
        }
    }

    public static void w0(BaseActivity baseActivity, int i7) {
        Intent intent = new Intent(baseActivity, (Class<?>) MainActivity.class);
        intent.putExtra(A0, i7);
        baseActivity.startActivity(intent);
    }

    @Override // com.haier.globalwasher.base.BaseActivity
    public void W() {
        super.W();
        s0();
        com.haier.globalwasher.modle.utils.bluetoothutil.a aVar = this.R;
        if (aVar != null) {
            aVar.t();
        }
    }

    @Override // com.haier.globalwasher.base.SelectListActivity, com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        this.O.e(this.Q);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(i2.a.f34126p);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.V, intentFilter, 4);
        } else {
            registerReceiver(this.V, intentFilter);
        }
        int intExtra = getIntent().getIntExtra(A0, -1);
        if (intExtra >= 0) {
            this.f24298x.post(new b(intExtra));
        }
    }

    @Override // com.haier.globalwasher.base.SelectListActivity, com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        this.U = getResources();
        super.d();
        d0(this.U.getString(R.string.app_name), 0, new View[0]);
        this.Q = new c(this);
        this.P = this.O.c(this);
        this.f24298x.setSlide(false);
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.SelectListActivity, com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        com.haier.globalwasher.presenter.c cVar = (com.haier.globalwasher.presenter.c) super.f();
        this.O = cVar;
        return cVar;
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public ArrayList<com.haier.globalwasher.base.a> h0() {
        this.S.clear();
        this.S.add(new com.haier.globalwasher.view.fragment.a());
        this.S.add(new FPOrderFragment());
        this.S.add(new com.haier.globalwasher.view.fragment.b());
        return this.S;
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public ArrayList<d> i0() {
        if (this.T.size() == 0) {
            this.T.add(new d(this.U.getString(R.string.haier_home_page_laundry), 0, ""));
            this.T.add(new d(this.U.getString(R.string.haier_home_page_order), 1, ""));
            this.T.add(new d(this.U.getString(R.string.haier_home_page_my), 2, ""));
        }
        return this.T;
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public int j0() {
        return 2;
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public boolean k0() {
        return true;
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public void l0(ArrayList<d> arrayList, int i7) {
        String strA = t2.a.a(this, t2.a.f40354a, t2.a.f40355b);
        if (i7 == 0) {
            super.l0(i0(), i7);
            d0(this.U.getString(R.string.app_name), 0, new View[0]);
            super.addViewInToolbarBottom(null);
            return;
        }
        if (i7 == 1) {
            if ("".equals(strA) || strA == null) {
                r0();
                return;
            }
            super.l0(i0(), i7);
            FPOrderFragment fPOrderFragment = (FPOrderFragment) this.S.get(1);
            if (fPOrderFragment.E == 1) {
                fPOrderFragment.N(1, 0);
            }
            d0(this.T.get(i7).a(), 0, new View[0]);
            super.addViewInToolbarBottom(null);
            return;
        }
        if (i7 != 2) {
            return;
        }
        if ("".equals(strA) || strA == null) {
            r0();
            return;
        }
        super.l0(i0(), i7);
        if (this.S.size() == 3) {
            e0(false);
            com.haier.globalwasher.view.fragment.b bVar = (com.haier.globalwasher.view.fragment.b) this.S.get(2);
            bVar.J(this);
            bVar.N();
        }
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    public ArrayList<Drawable> o0() {
        this.X.add(this.U.getDrawable(R.drawable.nav_xiyidian_dis));
        this.X.add(this.U.getDrawable(R.drawable.nav_dingdan_dis));
        this.X.add(this.U.getDrawable(R.drawable.nav_wode_dis));
        return this.X;
    }

    @Override // com.haier.globalwasher.base.SelectListActivity, com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        CountDownBroadcastReceiver countDownBroadcastReceiver;
        super.onDestroy();
        try {
            QuitLoginBroadcastReceiver quitLoginBroadcastReceiver = this.V;
            if (quitLoginBroadcastReceiver != null) {
                unregisterReceiver(quitLoginBroadcastReceiver);
            }
            FPOrderFragment fPOrderFragment = (FPOrderFragment) this.S.get(1);
            if (fPOrderFragment != null && (countDownBroadcastReceiver = fPOrderFragment.f26029x) != null) {
                unregisterReceiver(countDownBroadcastReceiver);
            }
            QuitLoginBroadcastReceiver quitLoginBroadcastReceiver2 = this.V;
            if (quitLoginBroadcastReceiver2 != null) {
                unregisterReceiver(quitLoginBroadcastReceiver2);
            }
        } catch (Exception unused) {
        }
        s0();
        com.haier.globalwasher.modle.utils.bluetoothutil.a aVar = this.R;
        if (aVar != null) {
            aVar.s();
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        int currentItem;
        super.onPause();
        NoSlidingViewPager noSlidingViewPager = this.f24298x;
        if (noSlidingViewPager == null || this.A == null || this.A.size() <= (currentItem = noSlidingViewPager.getCurrentItem())) {
            return;
        }
        this.A.get(currentItem).onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i7, @m0 String[] strArr, @m0 int[] iArr) {
        super.onRequestPermissionsResult(i7, strArr, iArr);
        s0();
        com.haier.globalwasher.modle.utils.bluetoothutil.a aVar = this.R;
        if (aVar != null) {
            aVar.r(i7, strArr, iArr);
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        int currentItem;
        super.onResume();
        NoSlidingViewPager noSlidingViewPager = this.f24298x;
        if (noSlidingViewPager == null || this.A == null || this.A.size() <= (currentItem = noSlidingViewPager.getCurrentItem())) {
            return;
        }
        this.A.get(currentItem).onResume();
    }

    @Override // com.haier.globalwasher.base.SelectListActivity
    @t0(api = 23)
    public ArrayList<Drawable> p0() {
        this.W.add(this.U.getDrawable(R.drawable.nav_xiyidian_pre));
        this.W.add(this.U.getDrawable(R.drawable.nav_dingdan_pre));
        this.W.add(this.U.getDrawable(R.drawable.nav_wode_pre));
        return this.W;
    }

    public void r0() {
        ProfileAvatarImageBeen.getInstance().initRegisterBeen();
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40355b, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40356c, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40357d, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40359f, "");
        t2.a.b(MyApplication.k().getApplicationContext(), t2.a.f40354a, t2.a.f40358e, "");
        Intent intent = new Intent(MyApplication.k(), (Class<?>) LoginActivity.class);
        intent.setFlags(268435456);
        MyApplication.k().startActivity(intent);
    }

    public void s0() {
        ArrayList<com.haier.globalwasher.base.a> arrayList = this.S;
        if (arrayList != null) {
            for (com.haier.globalwasher.base.a aVar : arrayList) {
                if (aVar instanceof FPOrderFragment) {
                    this.R = ((FPOrderFragment) aVar).Y();
                }
            }
        }
    }

    public int t0() {
        NoSlidingViewPager noSlidingViewPager = this.f24298x;
        if (noSlidingViewPager == null) {
            return 0;
        }
        return noSlidingViewPager.getCurrentItem();
    }

    public void u0() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(i2.a.f34093e));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
            return;
        }
        intent.setData(Uri.parse(i2.a.f34090d));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            i0.d(this, this.U.getString(R.string.new_latest_browser));
        }
    }

    @Deprecated
    public void v0(String str) {
        Intent intent = new Intent(this, (Class<?>) UpdateIntentService.class);
        intent.setAction(UpdateIntentService.f25306g);
        intent.putExtra("appName", "update_washerClobal");
        intent.putExtra("downUrl", str);
        startService(intent);
    }
}
