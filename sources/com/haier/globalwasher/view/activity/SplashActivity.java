package com.haier.globalwasher.view.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.l;
import com.haier.globalwasher.MyApplication;
import com.haier.globalwasher.R;
import com.haier.globalwasher.base.BaseActivity;
import com.haier.globalwasher.modle.bean.AppAdInfo;
import com.haier.globalwasher.modle.utils.d0;
import com.haier.globalwasher.modle.utils.g0;
import com.haier.globalwasher.modle.utils.q;
import com.haier.globalwasher.modle.utils.z;
import com.haier.globalwasher.mvp_api.moudle.BaseData;
import com.haier.globalwasher.presenter.r;
import com.haier.globalwasher.presenter.y;
import com.haier.globalwasher.view.custom_view.FontTextView;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class SplashActivity extends BaseActivity {
    private g0 B;
    k D;
    private LocationManager H;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private r f25438u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private j f25439v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private AppAdInfo f25440w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ImageView f25441x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private TextView f25442y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Resources f25443z;
    private int A = 1;

    @SuppressLint({"HandlerLeak"})
    private Handler C = new a();
    public boolean E = false;
    public boolean F = false;
    private String G = "GsonRequest";

    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        @SuppressLint({"SetTextI18n"})
        public void handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == 0) {
                int iIntValue = ((Integer) message.obj).intValue();
                SplashActivity.this.f25442y.setText(iIntValue + "s " + SplashActivity.this.f25443z.getString(R.string.no_network_seckil));
                return;
            }
            if (i7 != 2) {
                return;
            }
            q.c(SplashActivity.this.G, "isToRunonRequestPermissionsResult=" + SplashActivity.this.E + "   isPassPermissions =" + SplashActivity.this.F);
            SplashActivity splashActivity = SplashActivity.this;
            if (!splashActivity.E) {
                splashActivity.u0();
            } else if (splashActivity.F) {
                splashActivity.u0();
            }
        }
    }

    class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            SplashActivity splashActivity = SplashActivity.this;
            WebActivity.j0(splashActivity, splashActivity.getResources().getString(R.string.policy_first_alert_title), i2.a.R1);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(SplashActivity.this.getResources().getColor(R.color.app_zhexian_blue_relg, null));
            textPaint.setUnderlineText(false);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SplashActivity.this.o0();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t2.a.b(SplashActivity.this.getApplicationContext(), t2.a.f40362i, t2.a.f40364k, "1");
            t2.a.b(SplashActivity.this.getApplicationContext(), t2.a.f40362i, t2.a.f40365l, "" + com.haier.globalwasher.modle.a.a(SplashActivity.this));
            SplashActivity.this.s0();
        }
    }

    class e extends ClickableSpan {
        e() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            SplashActivity splashActivity = SplashActivity.this;
            WebActivity.j0(splashActivity, splashActivity.getResources().getString(R.string.policy_first_alert_title), i2.a.R1);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(SplashActivity.this.getResources().getColor(R.color.app_zhexian_blue_relg, null));
            textPaint.setUnderlineText(false);
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MyApplication.e();
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t2.a.b(SplashActivity.this.getApplicationContext(), t2.a.f40362i, t2.a.f40365l, "" + com.haier.globalwasher.modle.a.a(SplashActivity.this));
            t2.a.b(SplashActivity.this.getApplicationContext(), t2.a.f40362i, t2.a.f40364k, "1");
            SplashActivity.this.s0();
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t2.a.b(SplashActivity.this.getApplicationContext(), t2.a.f40362i, t2.a.f40366m, "F");
            SplashActivity.this.q0();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            t2.a.b(SplashActivity.this.getApplicationContext(), t2.a.f40362i, t2.a.f40366m, "T");
            SplashActivity.this.q0();
        }
    }

    class j implements com.haier.globalwasher.mvp_api.moudle.b<BaseData<AppAdInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SplashActivity f25453a;

        public j(SplashActivity splashActivity) {
            this.f25453a = splashActivity;
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        public void a(Exception exc) {
            SplashActivity.this.A = 3;
            SplashActivity.this.r0();
        }

        @Override // com.haier.globalwasher.mvp_api.moudle.b
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(BaseData<AppAdInfo> baseData) {
            if (!"00000".equals(baseData.getRetCode())) {
                SplashActivity.this.r0();
                return;
            }
            SplashActivity.this.f25440w = baseData.getData();
            if (SplashActivity.this.f25441x == null || TextUtils.isEmpty(SplashActivity.this.f25440w.getImageUrl())) {
                SplashActivity.this.f25441x.setVisibility(8);
            } else {
                SplashActivity.this.f25441x.setVisibility(0);
                if (!this.f25453a.isFinishing()) {
                    l.O(this.f25453a).E(SplashActivity.this.f25440w.getImageUrl()).E(SplashActivity.this.f25441x);
                }
            }
            if (SplashActivity.this.f25442y != null) {
                if (!TextUtils.isEmpty(SplashActivity.this.f25440w.getCountDown() + "")) {
                    SplashActivity splashActivity = SplashActivity.this;
                    splashActivity.A = splashActivity.f25440w.getCountDown();
                    SplashActivity.this.f25442y.setVisibility(0);
                    if (SplashActivity.this.f25440w.getCountDown() == 0) {
                        SplashActivity.this.A = 3;
                    }
                    SplashActivity.this.r0();
                    return;
                }
            }
            SplashActivity.this.f25442y.setVisibility(0);
            SplashActivity.this.A = 3;
            SplashActivity.this.r0();
        }
    }

    class k extends com.haier.globalwasher.modle.e {
        public k(BaseActivity baseActivity) {
            super(baseActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        g0 g0Var = new g0(this.C, this.A);
        this.B = g0Var;
        g0Var.d();
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void a() {
        if (MyApplication.f24259o) {
            String strA = t2.a.a(this, t2.a.f40362i, t2.a.f40367n);
            if (strA != null) {
                p0(this, strA);
            }
            String strA2 = t2.a.a(this, t2.a.f40362i, t2.a.f40368o);
            if (d0.j(strA2)) {
                MyApplication.f24258n = strA2.equals("1");
                q.c(this.G, "" + MyApplication.f24258n);
            }
            u0();
        }
        if (!t2.a.a(getApplicationContext(), t2.a.f40362i, t2.a.f40364k).equals("1")) {
            t0();
            return;
        }
        if (!d0.j(t2.a.a(getApplicationContext(), t2.a.f40362i, t2.a.f40365l))) {
            t0();
        } else if (com.haier.globalwasher.modle.a.a(this) <= Integer.parseInt(t2.a.a(getApplicationContext(), t2.a.f40362i, t2.a.f40365l))) {
            s0();
        } else {
            t2.a.b(getApplicationContext(), t2.a.f40362i, t2.a.f40364k, "");
            t0();
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public int b() {
        return R.layout.activity_splash;
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public void d() {
        this.D = new k(this);
        T(false, null);
        U(false);
        this.f25443z = getResources();
        this.f25441x = (ImageView) S(R.id.splasg_img, true);
        this.f25442y = (TextView) S(R.id.splasg_id, true);
        this.f25439v = new j(this);
        if (this.f25440w == null) {
            this.f25440w = new AppAdInfo();
        }
    }

    @Override // com.haier.globalwasher.mvp_api.view.a
    public void e() {
    }

    @Override // com.haier.globalwasher.base.BaseActivity, com.haier.globalwasher.mvp_api.view.a
    public com.haier.globalwasher.mvp_api.presenter.b f() {
        r rVar = new r();
        this.f25438u = rVar;
        return rVar;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x005c  */
    public void o0() {
        int i7;
        View viewInflate = View.inflate(this, R.layout.second_privacy_agreement, null);
        FontTextView fontTextView = (FontTextView) viewInflate.findViewById(R.id.ftv_content);
        String string = fontTextView.getText().toString();
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < string.length(); i8++) {
            if ("《".equals(string.charAt(i8) + "")) {
                arrayList.add(Integer.valueOf(i8));
            } else {
                if ("》".equals(string.charAt(i8) + "")) {
                    arrayList.add(Integer.valueOf(i8));
                }
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int i9 = 0;
        while (i9 < arrayList.size() && (i7 = i9 + 1) < arrayList.size()) {
            int i10 = i9 * 2;
            spannableStringBuilder.setSpan(new e(), ((Integer) arrayList.get(i10)).intValue(), ((Integer) arrayList.get(i10 + 1)).intValue() + 1, 33);
            i9 = i7;
        }
        fontTextView.setText(spannableStringBuilder);
        fontTextView.setMovementMethod(LinkMovementMethod.getInstance());
        try {
            com.haier.globalwasher.modle.utils.popwindow.a.b(this, viewInflate, new Integer[]{Integer.valueOf(R.id.first_buttom), Integer.valueOf(R.id.second_buttom)}, new View.OnClickListener[]{new f(), new g()});
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i7, int i8, Intent intent) {
        super.onActivityResult(i7, i8, intent);
        if (this.H == null) {
            this.H = (LocationManager) getSystemService("location");
        }
        if (!this.H.isProviderEnabled("network")) {
            this.D.d();
            return;
        }
        if (1007 == i7) {
            if (com.haier.globalwasher.modle.a.b(this, com.haier.globalwasher.modle.a.f24330a) != 0) {
                com.haier.globalwasher.modle.a.d(this, 1006, new String[0]);
            } else {
                this.E = false;
                this.C.sendEmptyMessage(2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.splasg_img) {
            if (id == R.id.splasg_id) {
                if (this.H == null) {
                    this.H = (LocationManager) getSystemService("location");
                }
                if (com.haier.globalwasher.modle.a.b(this, com.haier.globalwasher.modle.a.f24330a) == 0 && this.H.isProviderEnabled("network")) {
                    u0();
                    return;
                } else if (this.H.isProviderEnabled("network")) {
                    this.D.b();
                    return;
                } else {
                    this.D.d();
                    return;
                }
            }
            return;
        }
        AppAdInfo appAdInfo = this.f25440w;
        if (appAdInfo == null || appAdInfo.getHttpUrl() == null || "null".equals(this.f25440w.getHttpUrl()) || "".equals(this.f25440w.getHttpUrl())) {
            return;
        }
        g0 g0Var = this.B;
        if (g0Var != null) {
            g0Var.e();
        }
        Intent intent = new Intent(this, (Class<?>) WebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("title", this.f25440w.getTitle() + "");
        bundle.putString(y.f25407e, this.f25440w.getHttpUrl());
        intent.putExtra(y.f25405c, bundle);
        startActivityForResult(intent, 100);
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        l.M(getApplicationContext()).N();
        this.B = null;
        this.C.removeMessages(2);
        this.C = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i7, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i7, strArr, iArr);
        q.c(this.G, "onRequestPermissionsResult=");
        if (this.H == null) {
            this.H = (LocationManager) getSystemService("location");
        }
        if (com.haier.globalwasher.modle.a.b(this, com.haier.globalwasher.modle.a.f24330a) == 0 && this.H.isProviderEnabled("network") && this.H.isProviderEnabled("gps")) {
            this.F = true;
            g0 g0Var = this.B;
            if (g0Var == null || g0Var.f24603b != 0) {
                return;
            }
            this.C.sendEmptyMessage(2);
            return;
        }
        if (this.H.isProviderEnabled("network") || this.H.isProviderEnabled("gps")) {
            this.F = false;
            this.D.b();
        } else {
            this.F = false;
            this.D.d();
        }
    }

    @Override // com.haier.globalwasher.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        g0 g0Var = this.B;
        if (g0Var == null || this.A <= 0) {
            return;
        }
        this.A = g0Var.d();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        g0 g0Var = this.B;
        if (g0Var != null) {
            this.A = g0Var.e();
        }
    }

    public void p0(Context context, String str) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        str.hashCode();
        if (str.equals("en")) {
            configuration.locale = Locale.ENGLISH;
        } else if (str.equals("zh")) {
            configuration.locale = Locale.CHINESE;
        }
        resources.updateConfiguration(configuration, displayMetrics);
    }

    public void q0() {
        this.E = com.haier.globalwasher.modle.a.d(this, 1006, new String[0]);
        if (t2.a.a(getApplicationContext(), t2.a.f40354a, t2.a.f40360g).equals("1")) {
            this.f25438u.b(this.f25439v);
        } else {
            startActivity(new Intent(this, (Class<?>) GuidePageActivity.class));
            finish();
        }
    }

    public void s0() {
        if ("".equals(t2.a.a(getApplicationContext(), t2.a.f40362i, t2.a.f40366m))) {
            z.f(this, getResources().getString(R.string.open_notice_switch_popup_title), getResources().getString(R.string.open_notice_switch_popup_content), getResources().getString(R.string.open_notice_switch_popup_dont_allow), getResources().getString(R.string.open_notice_switch_popup_button_allow), new h(), new i());
        } else {
            q0();
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x00a8  */
    public void t0() {
        int i7;
        int i8;
        View viewInflate = View.inflate(this, R.layout.warm_prompt, null);
        ((FontTextView) viewInflate.findViewById(R.id.font_button_title_id)).setText(getResources().getString(R.string.policy_first_alert_title));
        FontTextView fontTextView = (FontTextView) viewInflate.findViewById(R.id.font_button_text_id);
        fontTextView.setText(getResources().getString(R.string.policy_first_alert_msg));
        ((FontTextView) viewInflate.findViewById(R.id.font_button_id_no)).setText(getResources().getString(R.string.policy_first_alert_no));
        ((FontTextView) viewInflate.findViewById(R.id.font_button_id_yes)).setText(getResources().getString(R.string.policy_first_alert_yes));
        String string = fontTextView.getText().toString();
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < string.length(); i9++) {
            if ("《".equals(string.charAt(i9) + "")) {
                arrayList.add(Integer.valueOf(i9));
            } else {
                if ("》".equals(string.charAt(i9) + "")) {
                    arrayList.add(Integer.valueOf(i9));
                }
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        for (int i10 = 0; i10 < arrayList.size() && (i8 = (i7 = i10 * 2) + 1) < arrayList.size(); i10++) {
            spannableStringBuilder.setSpan(new b(), ((Integer) arrayList.get(i7)).intValue(), ((Integer) arrayList.get(i8)).intValue() + 1, 33);
        }
        fontTextView.setText(spannableStringBuilder);
        fontTextView.setMovementMethod(LinkMovementMethod.getInstance());
        try {
            com.haier.globalwasher.modle.utils.popwindow.a.b(this, viewInflate, new Integer[]{Integer.valueOf(R.id.font_button_id_no), Integer.valueOf(R.id.font_button_id_yes)}, new View.OnClickListener[]{new c(), new d()});
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public void u0() {
        if (1 == this.D.c()) {
            this.f25438u.d(this);
        }
    }
}
