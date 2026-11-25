package com.haier.uhome.usdk.base.hiwifi;

import android.text.TextUtils;
import androidx.core.app.l2;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f31298a = "app_id";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f31299b = "app_name";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f31300c = "client_id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f31301d = "method";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f31302e = "device.iot.list";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f31303f = "device.iot.discover";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f31304g = "device.iot.add";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f31305h = "data";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f31306i = "version";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f31307j = "mac";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f31308k = "macs";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f31309l = "arguments";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f31310m = "ssid";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f31311n = "code";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f31312o = "msg";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f31313p = "list";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f31314q = "client_secret";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f31315r = "iot_local_token";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f31316s = "timestamp";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f31317t = "signature";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f31318u = "vendor";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f31319v = "haier";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private com.haier.library.okhttp.api.e f31320w;

    public interface a {
        void onCallBack(boolean z7, ErrorConst errorConst);
    }

    public interface b {
        void onCallBack(List<com.haier.uhome.usdk.base.hiwifi.c> list);
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static d f31332a = new d();

        private c() {
        }
    }

    private d() {
        this.f31320w = com.haier.library.okhttp.api.e.n(15L, TimeUnit.SECONDS, false);
        a(new a() { // from class: com.haier.uhome.usdk.base.hiwifi.e
            @Override // com.haier.uhome.usdk.base.hiwifi.d.a
            public final void onCallBack(boolean z7, ErrorConst errorConst) {
                d.a(z7, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        String strG = com.haier.uhome.usdk.base.hiwifi.a.a().g();
        e3.a.o("checkIsBind, get clientSecret is %s", strG);
        if (TextUtils.isEmpty(strG)) {
            c(aVar);
        } else {
            e3.a.o("This router already Bind .", new Object[0]);
            aVar.onCallBack(true, ErrorConst.ERR_INTERNAL);
        }
    }

    private void c(final a aVar) {
        this.f31320w.i(com.haier.uhome.usdk.base.hiwifi.b.f31287b, null, new com.haier.library.okhttp.api.f() { // from class: com.haier.uhome.usdk.base.hiwifi.d.2
            @Override // com.haier.library.okhttp.api.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(com.haier.library.okhttp.a aVar2, String str) {
                if (TextUtils.isEmpty(str)) {
                    aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
                    e3.a.o("bind error , response is null or empty!", new Object[0]);
                }
                e3.a.o("bind get response <%s>!", str);
                HiWifiResp hiWifiResp = (HiWifiResp) com.haier.library.json.a.z(str, HiWifiResp.class);
                if (hiWifiResp.getCode() != 0) {
                    e3.a.o("bind error code : ", Integer.valueOf(hiWifiResp.getCode()));
                    aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
                    return;
                }
                com.haier.library.json.e eVarT = com.haier.library.json.a.t(hiWifiResp.getAppData());
                if (eVarT == null) {
                    aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
                    e3.a.o("bind error, get appData is null!", new Object[0]);
                } else {
                    String strR0 = eVarT.R0(d.f31315r);
                    String strR1 = eVarT.R0(d.f31307j);
                    d dVar = d.this;
                    dVar.a((Map<String, String>) dVar.a(strR0, strR1), aVar);
                }
            }

            @Override // com.haier.library.okhttp.api.b
            public void onError(com.haier.library.okhttp.a aVar2, Exception exc) {
                aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
                e3.a.o("bind error , onError !" + exc, new Object[0]);
            }
        });
    }

    private String c(String str) {
        return com.haier.library.common.util.a.i(l2.f5208p0 + str + com.haier.uhome.usdk.base.hiwifi.a.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z7, ErrorConst errorConst) {
        e3.a.e("HiWifiService Router Support -> (%s)", Boolean.valueOf(z7));
    }

    public static d a() {
        return c.f31332a;
    }

    private void a(final a aVar) {
        this.f31320w.i(com.haier.uhome.usdk.base.hiwifi.b.f31286a, null, new com.haier.library.okhttp.api.f() { // from class: com.haier.uhome.usdk.base.hiwifi.d.1
            @Override // com.haier.library.okhttp.api.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(com.haier.library.okhttp.a aVar2, String str) {
                if (TextUtils.isEmpty(str)) {
                    e3.a.o("checkWiFiEnvironment error , response is null or empty!", new Object[0]);
                    aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
                    return;
                }
                e3.a.o("checkWiFiEnvironment get response <%s>!", str);
                try {
                    HiWifiResp hiWifiResp = (HiWifiResp) com.haier.library.json.a.z(str, HiWifiResp.class);
                    if (hiWifiResp.getCode() != 0) {
                        e3.a.o("checkWiFiEnvironment error code : %d", Integer.valueOf(hiWifiResp.getCode()));
                        aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
                        return;
                    }
                    com.haier.library.json.e eVarT = com.haier.library.json.a.t(hiWifiResp.getAppData());
                    String strR0 = eVarT.R0("version");
                    if (!d.this.b(strR0)) {
                        e3.a.o("checkWiFiEnvironment error,router version not support <v:%s>!", strR0);
                        aVar.onCallBack(false, ErrorConst.ERR_USDK_ROUTER_VERSION_TOO_LOW);
                        return;
                    }
                    String strR1 = eVarT.R0(d.f31307j);
                    if (TextUtils.isEmpty(strR1)) {
                        e3.a.o("checkWiFiEnvironment error,router mac not found !", new Object[0]);
                        aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
                    } else {
                        com.haier.uhome.usdk.base.hiwifi.a.a().b(strR1);
                        d.this.b(aVar);
                    }
                } catch (Exception e8) {
                    e3.a.v("checkWiFiEnvironment excp -> %s", e8);
                    aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
                }
            }

            @Override // com.haier.library.okhttp.api.b
            public void onError(com.haier.library.okhttp.a aVar2, Exception exc) {
                e3.a.o("checkWiFiEnvironment error , onError !" + exc, new Object[0]);
                aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
            }
        });
    }

    private void b(final b bVar) {
        final ArrayList arrayList = new ArrayList();
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("method", f31303f);
        eVar.put("app_id", com.haier.uhome.usdk.base.hiwifi.a.a().b());
        eVar.put("client_id", com.haier.uhome.usdk.base.hiwifi.a.a().e());
        com.haier.library.json.e eVar2 = new com.haier.library.json.e();
        eVar2.put(f31318u, f31319v);
        eVar.put("data", eVar2);
        this.f31320w.u(String.format(Locale.getDefault(), com.haier.uhome.usdk.base.hiwifi.b.f31289d, com.haier.uhome.usdk.base.hiwifi.a.a().f(), c(eVar.toString())), null, eVar.toString(), new com.haier.library.okhttp.api.f() { // from class: com.haier.uhome.usdk.base.hiwifi.d.4
            @Override // com.haier.library.okhttp.api.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(com.haier.library.okhttp.a aVar, String str) {
                try {
                    e3.a.o("discoverDevice get data: %s", str);
                    HiWifiResp hiWifiResp = (HiWifiResp) com.haier.library.json.a.z(str, HiWifiResp.class);
                    if (hiWifiResp.getAppCode() != 100005 && hiWifiResp.getAppCode() != 100012 && hiWifiResp.getAppCode() != 100015) {
                        com.haier.library.json.b bVarK0 = com.haier.library.json.a.t(hiWifiResp.getAppData()).K0(d.f31313p);
                        for (int i7 = 0; i7 < bVarK0.size(); i7++) {
                            String strReplaceAll = bVarK0.K0(i7).R0(d.f31307j).replaceAll(":", "");
                            String strR0 = bVarK0.K0(i7).R0("ssid");
                            if (!TextUtils.isEmpty(strReplaceAll) && strR0.endsWith("z")) {
                                arrayList.add(new com.haier.uhome.usdk.base.hiwifi.c(strReplaceAll, strR0));
                            }
                        }
                        bVar.onCallBack(arrayList);
                        return;
                    }
                    com.haier.uhome.usdk.base.hiwifi.a.a().c(null);
                    bVar.onCallBack(arrayList);
                } catch (Exception e8) {
                    e3.a.v("doDiscoverDevice excp -> %s", e8);
                    bVar.onCallBack(arrayList);
                }
            }

            @Override // com.haier.library.okhttp.api.b
            public void onError(com.haier.library.okhttp.a aVar, Exception exc) {
                bVar.onCallBack(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> a(String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap map = new HashMap();
        map.put("client_id", com.haier.uhome.usdk.base.hiwifi.a.a().e());
        map.put(f31315r, str);
        map.put(f31307j, str2);
        map.put("app_name", com.haier.uhome.usdk.base.hiwifi.a.a().c());
        map.put("timestamp", String.valueOf(jCurrentTimeMillis));
        map.put(f31317t, a(jCurrentTimeMillis, com.haier.uhome.usdk.base.hiwifi.a.a().d(), com.haier.uhome.usdk.base.hiwifi.a.a().e()));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, String> map, final a aVar) {
        this.f31320w.s(com.haier.uhome.usdk.base.hiwifi.b.f31288c, null, map, new com.haier.library.okhttp.api.f() { // from class: com.haier.uhome.usdk.base.hiwifi.d.3
            @Override // com.haier.library.okhttp.api.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(com.haier.library.okhttp.a aVar2, String str) {
                if (TextUtils.isEmpty(str)) {
                    aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
                    e3.a.o("iotBind error , response is null or empty!", new Object[0]);
                    return;
                }
                e3.a.o("iotBind get response <%s>!", str);
                com.haier.library.json.e eVarT = com.haier.library.json.a.t(str);
                if (eVarT.J0("code").intValue() != 0) {
                    e3.a.o("iotBind error, msg <%s>!", eVarT.R0("msg"));
                    aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
                } else {
                    String strR0 = eVarT.R0(d.f31314q);
                    com.haier.uhome.usdk.base.hiwifi.a.a().c(strR0);
                    aVar.onCallBack(true ^ TextUtils.isEmpty(strR0), ErrorConst.ERR_INTERNAL);
                }
            }

            @Override // com.haier.library.okhttp.api.b
            public void onError(com.haier.library.okhttp.a aVar2, Exception exc) {
                aVar.onCallBack(false, ErrorConst.ERR_INTERNAL);
                e3.a.o("iotBind error , onError !" + exc, new Object[0]);
            }
        });
    }

    public void a(final b bVar) {
        a(new a() { // from class: com.haier.uhome.usdk.base.hiwifi.g
            @Override // com.haier.uhome.usdk.base.hiwifi.d.a
            public final void onCallBack(boolean z7, ErrorConst errorConst) {
                this.f31335a.a(bVar, z7, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar, boolean z7, ErrorConst errorConst) {
        if (z7) {
            b(bVar);
        } else {
            bVar.onCallBack(new ArrayList(0));
        }
    }

    private void b(List<String> list, final o oVar) {
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("method", f31304g);
        eVar.put("app_id", com.haier.uhome.usdk.base.hiwifi.a.a().b());
        eVar.put("client_id", com.haier.uhome.usdk.base.hiwifi.a.a().e());
        com.haier.library.json.e eVar2 = new com.haier.library.json.e();
        eVar2.put(f31318u, f31319v);
        com.haier.library.json.e eVar3 = new com.haier.library.json.e();
        eVar3.put(f31308k, new com.haier.library.json.b(new ArrayList(list)));
        eVar2.put(f31309l, eVar3);
        eVar.put("data", eVar2);
        this.f31320w.u(String.format(Locale.getDefault(), com.haier.uhome.usdk.base.hiwifi.b.f31289d, com.haier.uhome.usdk.base.hiwifi.a.a().f(), c(eVar.toString())), null, eVar.toString(), new com.haier.library.okhttp.api.f() { // from class: com.haier.uhome.usdk.base.hiwifi.d.5
            @Override // com.haier.library.okhttp.api.b
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponse(com.haier.library.okhttp.a aVar, String str) {
                try {
                    e3.a.o("configDeviceToHiWifi get data: %s", str);
                    oVar.onCallback(ErrorConst.getErrorConstById(((HiWifiResp) com.haier.library.json.a.z(str, HiWifiResp.class)).getCode()));
                } catch (Exception unused) {
                    oVar.onCallback(ErrorConst.ERR_INTERNAL);
                }
            }

            @Override // com.haier.library.okhttp.api.b
            public void onError(com.haier.library.okhttp.a aVar, Exception exc) {
                oVar.onCallback(ErrorConst.ERR_INTERNAL);
            }
        });
    }

    public void a(final List<String> list, final o oVar) {
        a(new a() { // from class: com.haier.uhome.usdk.base.hiwifi.h
            @Override // com.haier.uhome.usdk.base.hiwifi.d.a
            public final void onCallBack(boolean z7, ErrorConst errorConst) {
                this.f31337a.a(list, oVar, z7, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(List list, o oVar, boolean z7, ErrorConst errorConst) {
        if (z7) {
            b((List<String>) list, oVar);
        } else {
            oVar.onCallback(errorConst);
        }
    }

    public void a(final o oVar) {
        a(new a() { // from class: com.haier.uhome.usdk.base.hiwifi.f
            @Override // com.haier.uhome.usdk.base.hiwifi.d.a
            public final void onCallBack(boolean z7, ErrorConst errorConst) {
                this.f31333a.a(oVar, z7, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(o oVar, boolean z7, ErrorConst errorConst) {
        if (z7) {
            b(oVar);
        } else {
            oVar.onCallback(ErrorConst.ERR_USDK_NOT_SUPPORT);
        }
    }

    private int a(String str) {
        String[] strArrSplit = str.split("\\.");
        return Integer.parseInt(strArrSplit[0].concat(strArrSplit[1]));
    }

    private String a(long j7, String str, String str2) {
        String strValueOf = String.valueOf(j7);
        int length = strValueOf.length();
        long j8 = 0;
        long j9 = 0;
        for (int i7 = 0; i7 < 5; i7++) {
            j9 = (j9 * 10) + Long.parseLong(String.valueOf(strValueOf.charAt((length - i7) - 2)));
        }
        for (int i8 = 0; i8 < 4; i8++) {
            j8 = (j8 * 10) + Long.parseLong(String.valueOf(strValueOf.charAt((length - i8) - 1)));
        }
        return com.haier.library.common.util.a.j((j7 - ((j9 * j8) / 2)) + str + str2);
    }

    private void b(o oVar) {
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("method", f31302e);
        eVar.put("app_id", com.haier.uhome.usdk.base.hiwifi.a.a().b());
        eVar.put("client_id", com.haier.uhome.usdk.base.hiwifi.a.a().e());
        com.haier.library.json.e eVar2 = new com.haier.library.json.e();
        eVar2.put(f31318u, f31319v);
        eVar.put("data", eVar2);
        this.f31320w.u(String.format(Locale.getDefault(), com.haier.uhome.usdk.base.hiwifi.b.f31289d, com.haier.uhome.usdk.base.hiwifi.a.a().f(), c(eVar.toString())), null, eVar.toString(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String[] strArrSplit = str.split("\\.");
        e3.a.d("checkRouterVersionIsOk subVersions : <%s> <%s>", strArrSplit[0], strArrSplit[1], new Object[0]);
        if (Integer.parseInt(strArrSplit[0]) > 1) {
            return true;
        }
        return Integer.parseInt(strArrSplit[0]) == 1 && Integer.parseInt(strArrSplit[1]) >= 4;
    }
}
