package com.haier.uhome.usdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.haier.library.common.b.h;
import com.haier.library.common.thread.m;
import com.haier.library.common.util.w;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.uSDKPingResult;
import com.haier.uhome.usdk.api.y;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.p;
import com.haier.uhome.usdk.base.api.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f31045a = "android.permission.READ_PHONE_STATE";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f31046b = "isRefusedPermission";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f31047c = 60000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f31048d = 5000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f31049e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f31050f = "TRACE";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f31051g = "NET";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f31052v = 9527;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f31053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f31054i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Object f31055j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f31056k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f31057l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f31058m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.haier.uhome.usdk.c.g f31059n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.haier.uhome.usdk.c.g f31060o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Timer f31061p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private b f31062q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private p f31063r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.haier.library.common.b.e f31064s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private com.haier.library.common.b.a f31065t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.haier.library.common.b.a f31066u;

    private class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private uSDKPingResult f31074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private uSDKPingResult f31075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f31076d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f31077e;

        private boolean c(uSDKPingResult usdkpingresult) {
            Map<Integer, y> sequenceNumber2Result;
            if (usdkpingresult == null || (sequenceNumber2Result = usdkpingresult.getSequenceNumber2Result()) == null || sequenceNumber2Result.isEmpty()) {
                return true;
            }
            Iterator<Map.Entry<Integer, y>> it = sequenceNumber2Result.entrySet().iterator();
            while (it.hasNext()) {
                y value = it.next().getValue();
                if (value != null && value.c() < 5000.0d) {
                    return false;
                }
            }
            return true;
        }

        private int d() {
            Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
            if (contextB == null) {
                return c.f31052v;
            }
            WifiManager wifiManager = (WifiManager) contextB.getApplicationContext().getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager != null ? wifiManager.getConnectionInfo() : null;
            int rssi = connectionInfo != null ? connectionInfo.getRssi() : 0;
            e3.a.d(c.f31050f, c.f31051g, "wifi rssi：" + rssi, new Object[0]);
            return rssi;
        }

        private a(String str) {
            this.f31076d = 0;
            this.f31077e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(uSDKPingResult usdkpingresult) {
            this.f31074b = usdkpingresult;
            b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(uSDKPingResult usdkpingresult) {
            this.f31075c = usdkpingresult;
            b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.f31076d++;
        }

        private synchronized void b() {
            int i7 = this.f31076d - 1;
            this.f31076d = i7;
            if (i7 > 0) {
                return;
            }
            if (TextUtils.isEmpty(this.f31077e)) {
                e3.a.d(c.f31050f, c.f31051g, "try send trace with null token so return direct", new Object[0]);
            } else {
                new m<Void, Void, Void>() { // from class: com.haier.uhome.usdk.b.c.a.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.haier.library.common.thread.m
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Void doInBackground(Void... voidArr) {
                        a.this.c();
                        return null;
                    }
                }.execute(new Void[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            String strValueOf;
            String strValueOf2;
            HashMap<String, String> map = new HashMap<>();
            map.put(TraceProtocolConst.PRO_NETWORK_TYPE, String.valueOf(c.this.a(com.haier.uhome.usdk.base.service.e.a().b())));
            int iD = d();
            if (iD != c.f31052v) {
                map.put("dbm", String.valueOf(iD));
            }
            map.put("sp", String.valueOf(c.this.c(com.haier.uhome.usdk.base.service.e.a().b())));
            uSDKPingResult usdkpingresult = this.f31074b;
            String str = "1";
            String strValueOf3 = "-1";
            if (usdkpingresult != null) {
                strValueOf = c(usdkpingresult) ? "-1" : String.valueOf(this.f31074b.getAverageTimeCost());
                String strValueOf4 = String.valueOf(this.f31074b.getSendCount() - this.f31074b.getReceiveCount());
                if (this.f31074b.getSendCount() != 0) {
                    str = strValueOf4;
                }
            } else {
                strValueOf = "-1";
            }
            map.put("its", strValueOf);
            map.put("ilost", str);
            uSDKPingResult usdkpingresult2 = this.f31075c;
            if (usdkpingresult2 != null) {
                strValueOf3 = c(usdkpingresult2) ? "-1" : String.valueOf(this.f31075c.getAverageTimeCost());
                strValueOf2 = String.valueOf(this.f31075c.getSendCount() - this.f31075c.getReceiveCount());
            } else {
                strValueOf2 = "4";
            }
            map.put("ats", strValueOf3);
            map.put("alost", strValueOf2);
            map.put(TraceProtocolConst.PRO_TOKEN, this.f31077e);
            e3.a.d(c.f31050f, c.f31051g, "send netSituation " + map.toString(), new Object[0]);
            com.haier.uhome.trace.b.g.a().b(map);
        }
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f31079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f31080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f31081c;

        b(String str, boolean z7) {
            if (com.haier.uhome.usdk.base.service.e.a().b() == null) {
                this.f31080b = false;
            } else {
                this.f31080b = com.haier.library.common.util.y.a(com.haier.uhome.usdk.base.service.e.a().b()).m(c.f31046b, false);
            }
            this.f31079a = str;
            this.f31081c = z7;
        }

        boolean a() {
            Context contextB;
            if ((this.f31080b && this.f31081c) || (contextB = com.haier.uhome.usdk.base.service.e.a().b()) == null) {
                return false;
            }
            if (com.haier.library.common.util.permissions.d.d().c(contextB, c.f31045a).c()) {
                return true;
            }
            this.f31080b = true;
            com.haier.library.common.util.y.a(contextB).h(c.f31046b, this.f31080b);
            return false;
        }
    }

    /* JADX INFO: renamed from: com.haier.uhome.usdk.b.c$c, reason: collision with other inner class name */
    private static class C0376c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f31083a = new c();

        private C0376c() {
        }
    }

    private void c() {
        r.a().a(this.f31063r);
        h.a().b(com.haier.uhome.usdk.base.service.e.a().b(), this.f31064s);
    }

    private void d() {
        r.a().b(this.f31063r);
        h.a().d(com.haier.uhome.usdk.base.service.e.a().b(), this.f31064s);
    }

    private void e() {
        Timer timer = this.f31061p;
        if (timer != null) {
            timer.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        synchronized (this.f31055j) {
            if (j()) {
                if (this.f31054i) {
                    return;
                }
                this.f31054i = true;
                a(new TimerTask() { // from class: com.haier.uhome.usdk.b.c.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        c.this.g();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        synchronized (this.f31055j) {
            if (!j()) {
                if (this.f31054i) {
                    e();
                }
                this.f31054i = false;
                return;
            }
            e3.a.d(f31050f, f31051g, "loop once ...", new Object[0]);
            com.haier.uhome.usdk.c.g gVarH = h();
            com.haier.uhome.usdk.c.g gVarI = i();
            final a aVar = new a(com.haier.uhome.usdk.base.service.e.a().g());
            if (gVarH == null) {
                return;
            }
            aVar.a();
            gVarH.a(new com.haier.uhome.usdk.c.g.b() { // from class: com.haier.uhome.usdk.b.c.2
                @Override // com.haier.uhome.usdk.c.g.b
                public void a(double d8) {
                }

                @Override // com.haier.uhome.usdk.c.g.b
                public void a(List<uSDKPingResult> list) {
                    e3.a.d(c.f31050f, c.f31051g, "ping gateway success", new Object[0]);
                    aVar.a(list.get(0));
                }

                @Override // com.haier.uhome.usdk.c.g.b
                public void a(String str) {
                    e3.a.d(c.f31050f, c.f31051g, "ping gateway fail!", new Object[0]);
                    aVar.a((uSDKPingResult) null);
                }
            });
            if (gVarI != null) {
                aVar.a();
                gVarI.a(new com.haier.uhome.usdk.c.g.b() { // from class: com.haier.uhome.usdk.b.c.3
                    @Override // com.haier.uhome.usdk.c.g.b
                    public void a(double d8) {
                    }

                    @Override // com.haier.uhome.usdk.c.g.b
                    public void a(List<uSDKPingResult> list) {
                        e3.a.d(c.f31050f, c.f31051g, "ping router success", new Object[0]);
                        aVar.b(list.get(0));
                    }

                    @Override // com.haier.uhome.usdk.c.g.b
                    public void a(String str) {
                        e3.a.d(c.f31050f, c.f31051g, "ping router fail!!", new Object[0]);
                        aVar.b((uSDKPingResult) null);
                    }
                });
            }
        }
    }

    private com.haier.uhome.usdk.c.g h() {
        String str = this.f31058m;
        if (TextUtils.isEmpty(str)) {
            this.f31056k = null;
            this.f31059n = null;
            return null;
        }
        if (!TextUtils.equals(this.f31056k, str)) {
            this.f31056k = str;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f31056k);
            this.f31059n = new com.haier.uhome.usdk.c.g.a().a(1, 64).a(1000L).b(f31048d).a(arrayList).a(false).a();
        }
        return this.f31059n;
    }

    private com.haier.uhome.usdk.c.g i() {
        String strI = w.i(com.haier.uhome.usdk.base.service.e.a().b());
        if (TextUtils.isEmpty(strI)) {
            this.f31057l = null;
            this.f31060o = null;
            return null;
        }
        if (!TextUtils.equals(strI, this.f31057l)) {
            this.f31057l = strI;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f31057l);
            this.f31060o = new com.haier.uhome.usdk.c.g.a().a(4, 64).a(1000L).b(f31048d).a(arrayList).a(false).a();
        }
        return this.f31060o;
    }

    private boolean j() {
        if (this.f31053h && !TextUtils.isEmpty(this.f31058m)) {
            return k();
        }
        return false;
    }

    private boolean k() {
        return com.haier.uhome.usdk.base.service.a.a().b() && com.haier.uhome.usdk.base.service.f.a().b();
    }

    private void l() {
        this.f31063r = new p() { // from class: com.haier.uhome.usdk.b.c.4
            @Override // com.haier.uhome.usdk.base.api.p
            public void a(boolean z7) {
                c.this.a(Trace.createDITrace(), z7);
                if (z7) {
                    c.this.f();
                }
            }

            @Override // com.haier.uhome.usdk.base.api.p
            public void b(boolean z7) {
                if (z7) {
                    c.this.f();
                }
            }
        };
        this.f31064s = new com.haier.library.common.b.e() { // from class: com.haier.uhome.usdk.b.g
            @Override // com.haier.library.common.b.e
            public /* synthetic */ void a(com.haier.library.common.b.r rVar) {
                com.haier.library.common.b.b.a(this, rVar);
            }

            @Override // com.haier.library.common.b.e
            public final void a(com.haier.library.common.b.a aVar) {
                this.f31085a.b(aVar);
            }
        };
    }

    private void m() {
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            return;
        }
        DITraceNode dITraceNode = new DITraceNode("netevt", a(this.f31066u), "", "", VersionManager.getInstance().getSDKVersion());
        HashMap map = new HashMap(5);
        com.haier.library.common.b.a aVar = this.f31066u;
        map.put("newIP", aVar != null ? aVar.m() : "");
        com.haier.library.common.b.a aVar2 = this.f31065t;
        map.put("oldIP", aVar2 != null ? aVar2.m() : "");
        com.haier.library.common.b.a aVar3 = this.f31066u;
        map.put("newSSID", aVar3 != null ? aVar3.l() : "");
        com.haier.library.common.b.a aVar4 = this.f31065t;
        map.put("oldSSID", aVar4 != null ? aVar4.l() : "");
        map.put("oldNet", a(this.f31065t));
        dITraceNode.add(TraceProtocolConst.PRO_IPM, com.haier.library.json.a.Z(map));
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        traceCreateDITrace.addDITraceNode(dITraceNode);
    }

    private c() {
        this.f31054i = false;
        this.f31061p = new Timer();
        this.f31055j = new Object();
        this.f31062q = new b(f31045a, true);
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public int c(Context context) {
        String strSubstring;
        if (context == null) {
            return 0;
        }
        if (!this.f31062q.a()) {
            e3.a.n(f31050f, f31051g, "missing permission so return unknown code from getSimOperatorName", new Object[0]);
            return 0;
        }
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            if (subscriberId == null || !subscriberId.startsWith("460")) {
                return 0;
            }
            try {
                strSubstring = subscriberId.substring(3, 5);
            } catch (StringIndexOutOfBoundsException e8) {
                e3.a.v("imsi substring excp -> %s", e8);
                strSubstring = "";
            }
            strSubstring.hashCode();
            switch (strSubstring) {
                case "00":
                case "02":
                case "04":
                case "07":
                    return 1;
                case "01":
                case "06":
                case "09":
                    return 2;
                case "03":
                case "05":
                case "11":
                    return 3;
                default:
                    return 0;
            }
        } catch (Exception e9) {
            e3.a.v("getSimOperatorName excp -> %s", e9);
            return 0;
        }
    }

    public void b() {
        this.f31058m = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.haier.library.common.b.a aVar) {
        this.f31065t = this.f31066u;
        this.f31066u = aVar;
        m();
        if (aVar.n() || aVar.h()) {
            f();
        }
    }

    public static c a() {
        return C0376c.f31083a;
    }

    public void a(boolean z7) {
        boolean z8 = this.f31053h;
        this.f31053h = z7;
        f();
        if (z8 == z7) {
            return;
        }
        if (z7) {
            c();
        } else {
            d();
        }
        e3.a.d(f31050f, f31051g, "enable:" + z7, new Object[0]);
    }

    private int b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return telephonyManager.getNetworkType();
        }
        return 0;
    }

    public void a(String str) {
        e3.a.d(f31050f, f31051g, "user login " + str, new Object[0]);
        this.f31058m = str;
        f();
    }

    private void a(TimerTask timerTask) {
        e();
        Timer timer = new Timer();
        this.f31061p = timer;
        timer.schedule(timerTask, 0L, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null) {
            return -1;
        }
        if (activeNetworkInfo.getType() == 0) {
            int iB = b(context);
            return iB != 0 ? iB + 2 : iB;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        return activeNetworkInfo.getType();
    }

    private String a(com.haier.library.common.b.a aVar) {
        if (aVar == null) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (NetworkInfo.State.DISCONNECTED == aVar.o()) {
            return "NotReachable";
        }
        int iA = aVar.a();
        if (iA == 0) {
            return "WWAN";
        }
        if (iA != 1) {
            return iA != 9 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : "ETHERNET";
        }
        return "WIFI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Trace trace, boolean z7) {
        if (trace == null) {
            return;
        }
        DITraceNode dITraceNode = new DITraceNode("appevt", z7 ? "EnterForeground" : "EnterBackground", null, null, VersionManager.getInstance().getSDKVersion());
        HashMap map = new HashMap(3);
        com.haier.library.common.b.a aVar = this.f31066u;
        map.put("IP", aVar == null ? "" : aVar.m());
        com.haier.library.common.b.a aVar2 = this.f31066u;
        map.put("SSID", aVar2 == null ? "" : aVar2.l());
        com.haier.library.common.b.a aVar3 = this.f31066u;
        map.put("net", aVar3 != null ? a(aVar3) : "");
        dITraceNode.add(TraceProtocolConst.PRO_IPM, com.haier.library.json.a.Z(map));
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        trace.addDITraceNode(dITraceNode);
    }
}
