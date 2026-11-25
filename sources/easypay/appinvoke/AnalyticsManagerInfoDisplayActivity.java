package easypay.appinvoke;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import paytm.assist.easypay.easypay.appinvoke.R;

/* JADX INFO: loaded from: classes2.dex */
public class AnalyticsManagerInfoDisplayActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f33591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TextView f33592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f33593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f33594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f33595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f33596i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f33597j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f33598k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f33599l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TextView f33600m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextView f33601n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f33602o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f33603p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f33604q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private TextView f33605r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f33606s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected HashMap<String, Object> f33607t;

    private void a0() {
        HashMap<String, Object> map = this.f33607t;
        if (map != null) {
            this.f33591d.setText(map.get("redirectUrls").toString());
            this.f33592e.setText(this.f33607t.get("mid").toString());
            this.f33593f.setText(this.f33607t.get("cardType").toString());
            this.f33594g.setText(this.f33607t.get("orderId").toString());
            this.f33595h.setText(this.f33607t.get("acsUrlRequested").toString());
            this.f33596i.setText(this.f33607t.get("cardIssuer").toString());
            this.f33597j.setText(this.f33607t.get("appName").toString());
            this.f33598k.setText(this.f33607t.get("smsPermission").toString());
            this.f33599l.setText(this.f33607t.get("isSubmitted").toString());
            this.f33600m.setText(this.f33607t.get("acsUrl").toString());
            this.f33601n.setText(this.f33607t.get("isSMSRead").toString());
            this.f33602o.setText(this.f33607t.get("mid").toString());
            this.f33603p.setText(this.f33607t.get("otp").toString());
            this.f33604q.setText(this.f33607t.get("acsUrlLoaded").toString());
            this.f33605r.setText(this.f33607t.get("sender").toString());
            this.f33606s.setText(this.f33607t.get("isAssistPopped").toString());
        }
    }

    private void d() {
        this.f33591d = (TextView) findViewById(R.id.tv_RedirectUrls);
        this.f33592e = (TextView) findViewById(R.id.tv_mid);
        this.f33593f = (TextView) findViewById(R.id.tv_cardType);
        this.f33594g = (TextView) findViewById(R.id.tv_RedirectUrls);
        this.f33595h = (TextView) findViewById(R.id.tv_acsUrlRequested);
        this.f33596i = (TextView) findViewById(R.id.tv_cardIssuer);
        this.f33597j = (TextView) findViewById(R.id.tv_appName);
        this.f33598k = (TextView) findViewById(R.id.tv_smsPermission);
        this.f33599l = (TextView) findViewById(R.id.tv_isSubmitted);
        this.f33600m = (TextView) findViewById(R.id.tv_acsUrl);
        this.f33601n = (TextView) findViewById(R.id.tv_isSMSRead);
        this.f33602o = (TextView) findViewById(R.id.tv_isAssistEnable);
        this.f33603p = (TextView) findViewById(R.id.tv_otp);
        this.f33604q = (TextView) findViewById(R.id.tv_acsUrlLoaded);
        this.f33605r = (TextView) findViewById(R.id.tv_sender);
        this.f33606s = (TextView) findViewById(R.id.tv_isAssistPopped);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_analytics_manager_info_display);
        this.f33607t = (HashMap) getIntent().getExtras().getSerializable("data");
        d();
        a0();
    }
}
