package com.haier.library.common.util.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements com.haier.library.common.util.a.c, com.haier.library.common.util.a.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f26534k = 15;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f26538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e f26539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WifiManager f26540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f26541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f26542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f26543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.haier.library.common.util.a.a f26544j;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26545a;

        static {
            int[] iArr = new int[e.values().length];
            f26545a = iArr;
            try {
                iArr[e.WEP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26545a[e.WPA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.haier.library.common.util.a.b$b, reason: collision with other inner class name */
    public static class C0351b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f26546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f26547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f26548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private e f26549d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f26550e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c f26551f;

        public C0351b(Context context) {
            this.f26546a = context;
        }

        public C0351b a(c cVar) {
            this.f26551f = cVar;
            return this;
        }

        public C0351b b(e eVar) {
            this.f26549d = eVar;
            return this;
        }

        public C0351b c(String str) {
            this.f26547b = str;
            return this;
        }

        public b d() {
            e eVar = this.f26549d;
            if (eVar == null) {
                eVar = e.NONE;
            }
            b bVar = new b(this.f26546a, this.f26547b, this.f26548c, this.f26550e, eVar);
            bVar.c(this.f26551f);
            return bVar;
        }

        public C0351b e(String str) {
            this.f26548c = str;
            return this;
        }

        public C0351b f(String str) {
            this.f26550e = str;
            return this;
        }
    }

    public interface c {
        void a(boolean z7);
    }

    private class d extends BroadcastReceiver {
        private d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String strE = f.e(b.this.f26535a);
            WifiInfo connectionInfo = b.this.f26540f.getConnectionInfo();
            if (connectionInfo == null || connectionInfo.getSupplicantState() != SupplicantState.COMPLETED || TextUtils.isEmpty(strE)) {
                return;
            }
            e3.a.d("change to new ssid<%s> compere with ssid<%s>", strE, b.this.f26536b, new Object[0]);
            if (TextUtils.equals(b.this.f26536b, strE)) {
                b.this.f26544j.b(Boolean.TRUE);
                return;
            }
            b.this.f26540f.disconnect();
            WifiConfiguration wifiConfigurationJ = b.this.j();
            e3.a.d("reconnect to %s-%s", wifiConfigurationJ.SSID, wifiConfigurationJ.BSSID, new Object[0]);
            b.this.f26540f.enableNetwork(wifiConfigurationJ.networkId, true);
            b.this.f26540f.reconnect();
        }

        /* synthetic */ d(b bVar, a aVar) {
            this();
        }
    }

    public b(Context context, String str) {
        this(context, str, "", "", e.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(c cVar) {
        this.f26543i = cVar;
    }

    private void g(boolean z7) {
        this.f26542h = z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WifiConfiguration j() {
        WifiConfiguration wifiConfigurationN = n();
        if (wifiConfigurationN == null) {
            wifiConfigurationN = o();
        }
        if (TextUtils.isEmpty(this.f26537c)) {
            wifiConfigurationN.BSSID = this.f26537c;
        }
        return wifiConfigurationN;
    }

    private List<WifiConfiguration> m() {
        try {
            return this.f26540f.getConfiguredNetworks();
        } catch (RuntimeException e8) {
            e8.printStackTrace();
            return null;
        }
    }

    private WifiConfiguration n() {
        List<WifiConfiguration> listM = m();
        if (listM != null) {
            String str = "\"" + this.f26536b + "\"";
            for (WifiConfiguration wifiConfiguration : listM) {
                if (TextUtils.equals(wifiConfiguration.SSID, str)) {
                    return wifiConfiguration;
                }
            }
        }
        return null;
    }

    private WifiConfiguration o() {
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.allowedAuthAlgorithms.clear();
        wifiConfiguration.allowedGroupCiphers.clear();
        wifiConfiguration.allowedKeyManagement.clear();
        wifiConfiguration.allowedPairwiseCiphers.clear();
        wifiConfiguration.allowedProtocols.clear();
        wifiConfiguration.SSID = "\"" + this.f26536b + "\"";
        int i7 = a.f26545a[this.f26539e.ordinal()];
        if (i7 == 1) {
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.wepKeys[0] = "\"" + this.f26538d + "\"";
            wifiConfiguration.allowedAuthAlgorithms.set(1);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(0);
            wifiConfiguration.allowedGroupCiphers.set(1);
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
        } else if (i7 != 2) {
            wifiConfiguration.allowedKeyManagement.set(0);
        } else {
            wifiConfiguration.hiddenSSID = true;
            wifiConfiguration.preSharedKey = "\"" + this.f26538d + "\"";
            wifiConfiguration.allowedKeyManagement.set(1);
            wifiConfiguration.allowedAuthAlgorithms.set(0);
            wifiConfiguration.allowedGroupCiphers.set(2);
            wifiConfiguration.allowedGroupCiphers.set(3);
            wifiConfiguration.allowedPairwiseCiphers.set(1);
            wifiConfiguration.allowedPairwiseCiphers.set(2);
        }
        wifiConfiguration.networkId = this.f26540f.addNetwork(wifiConfiguration);
        return wifiConfiguration;
    }

    private synchronized void p() {
        if (!r()) {
            e3.a.e("BindingDevice APConnector register=%s", "android.net.wifi.STATE_CHANGE");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            d dVar = new d(this, null);
            this.f26541g = dVar;
            try {
                this.f26535a.registerReceiver(dVar, intentFilter);
            } catch (IllegalArgumentException e8) {
                e3.a.e("BindingDevice APConnector register err=%s", e8.getMessage());
            }
            g(true);
        }
    }

    private synchronized void q() {
        if (r()) {
            e3.a.e("BindingDevice APConnector unregister=%s", "android.net.wifi.STATE_CHANGE");
            try {
                this.f26535a.unregisterReceiver(this.f26541g);
            } catch (IllegalArgumentException e8) {
                e3.a.e("BindingDevice APConnector unregister err=%s}", e8.getMessage());
            }
            g(false);
        }
    }

    private boolean r() {
        return this.f26542h;
    }

    public void b(int i7) {
        if (!this.f26540f.isWifiEnabled()) {
            this.f26543i.a(false);
            return;
        }
        if (f.e(this.f26535a).equals(this.f26536b)) {
            this.f26543i.a(true);
            return;
        }
        p();
        com.haier.library.common.util.a.a aVar = new com.haier.library.common.util.a.a(this.f26535a, this.f26536b, this, this);
        this.f26544j = aVar;
        if (i7 <= 15) {
            i7 = 15;
        }
        aVar.a(i7);
        new Thread(this.f26544j).start();
        this.f26540f.disconnect();
        this.f26540f.enableNetwork(j().networkId, true);
        this.f26540f.reconnect();
    }

    public void f() {
        b(15);
    }

    public void i() {
        WifiConfiguration wifiConfigurationN = n();
        if (wifiConfigurationN != null) {
            this.f26540f.removeNetwork(wifiConfigurationN.networkId);
        }
    }

    public b(Context context, String str, String str2, String str3, e eVar) {
        this.f26535a = context;
        this.f26536b = str;
        this.f26537c = str2;
        this.f26538d = str3;
        this.f26539e = eVar;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.f26540f = wifiManager;
        if (wifiManager == null) {
            throw new NullPointerException("APConnector wifiManager is null!!");
        }
    }

    @Override // com.haier.library.common.util.a.c
    public void a() {
        this.f26540f.enableNetwork(j().networkId, true);
        this.f26540f.reconnect();
    }

    @Override // com.haier.library.common.util.a.d
    public void a(boolean z7) {
        c cVar = this.f26543i;
        if (cVar != null) {
            cVar.a(z7);
        }
        q();
    }
}
