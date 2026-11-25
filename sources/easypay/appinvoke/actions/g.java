package easypay.appinvoke.actions;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.webkit.WebView;
import androidx.core.app.l2;
import com.facebook.GraphRequest;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Activity f33812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    WebView f33813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    EasypayBrowserFragment f33814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, String> f33815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f33816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f33817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    BroadcastReceiver f33818g = new a();

    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String string = intent.getExtras().getString("eventName");
            string.hashCode();
            if (string.equals("proceedProceedHelper")) {
                g.this.b();
                g gVar = g.this;
                gVar.f33814c.logEvent("proceeded", gVar.f33815d.get("id"));
            } else if (string.equals("activateProceedHelper")) {
                g.this.a();
                g gVar2 = g.this;
                gVar2.f33814c.logEvent("activated", gVar2.f33815d.get("id"));
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public g(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map<String, String> map) {
        this.f33812a = activity;
        this.f33814c = easypayBrowserFragment;
        this.f33815d = map;
        this.f33813b = webView;
        this.f33812a.registerReceiver(this.f33818g, new IntentFilter("com.paytm.com.paytm.pgsdk.easypay.appinvoke.CUSTOM_EVENT"));
        String str = this.f33815d.get(l2.P0);
        String str2 = this.f33815d.get("autoproceed");
        str = str2 != null ? "true" : str;
        webView.loadUrl("javascript:" + this.f33815d.get("functionStart") + (this.f33815d.get(GraphRequest.FIELDS_PARAM) + "Android.showLog('inside proceed helper'); var a=fields; if(!" + str + "){ Android.sendEvent('activateProceedHelper', 0, 0); } if(typeof(autoSubmitForm) == 'undefined'){ autoSubmitForm=function(){Android.showLog('activating proceedhelper1'); a[0]" + (this.f33815d.get("element").equals("input") ? ".click()" : this.f33815d.get("element").equals(j0.c.f34239c) ? ".submit()" : "") + "}; }  if(" + str2 + "){ autoSubmitForm();}") + this.f33815d.get("functionEnd"));
    }

    public void a() {
        this.f33812a.runOnUiThread(new b());
    }

    public void b() {
        BroadcastReceiver broadcastReceiver = this.f33818g;
        if (broadcastReceiver != null) {
            this.f33812a.unregisterReceiver(broadcastReceiver);
        }
        this.f33813b.loadUrl("javascript:if(typeof(autoSubmitForm) != 'undefined'){Android.showLog('activating proceedhelper0'); autoSubmitForm();}");
    }

    public void c() {
        try {
            BroadcastReceiver broadcastReceiver = this.f33818g;
            if (broadcastReceiver != null) {
                this.f33812a.unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }
}
