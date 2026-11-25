package com.haier.uhome.trace.api;

import android.os.Build;
import android.text.TextUtils;
import com.haier.library.common.util.u;
import com.haier.uhome.account.api.RetInfoContent;
import com.haier.uhome.nfc.service.HttpHelper;
import com.haier.uhome.trace.b.c;
import com.haier.uhome.trace.b.e;
import com.haier.uhome.trace.b.f;
import com.haier.uhome.trace.b.g;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.paytm.pgsdk.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f30229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f30230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f30231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f30232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f30233e = String.format("%s|%s", Build.BRAND, Build.MODEL);

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f30234a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f30234a;
    }

    private ErrorConst i(String str, TraceNode traceNode) {
        c cVarA = g.a().a(str);
        return cVarA != null ? cVarA.a(traceNode, e.USDK) : ErrorConst.ERR_INTERNAL;
    }

    public TraceNode b(TraceNode traceNode) {
        TraceNode traceNodeA = a("getSoftApDeviceConfigInfo", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "2");
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode c(TraceNode traceNode) {
        TraceNode traceNodeA = a("getConfigInfo", "local", f.CS, traceNode);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode d(int i7, String str, int i8, TraceNode traceNode) {
        TraceNode traceNodeA = a("getDeviceBindInfo", "local", f.CR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i8 > -1 ? String.valueOf(i8) : null);
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode e(int i7, String str, int i8, TraceNode traceNode) {
        TraceNode traceNodeA = a("getDeviceBindInfo", "local", f.CR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i8 > -1 ? String.valueOf(i8) : null);
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode f(int i7, String str, TraceNode traceNode) {
        TraceNode traceNodeA = a(com.haier.uhome.usdk.base.a.aq, com.haier.uhome.usdk.base.a.aq, f.CR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode g(TraceNode traceNode) {
        TraceNode traceNodeA = a("bindByQRCode", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode h(int i7, String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindSelfDevice", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, String str2, boolean z7, ArrayList<String> arrayList, int i7, TraceNode traceNode) {
        TraceNode traceNodeA = a("configBySmartLink", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SECURITY_TYPE, z7 ? "1" : "2");
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "1");
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str2);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(RetInfoContent.TYPEID_ISNULL, a(arrayList));
        if (str == null) {
            str = "";
        }
        eVar.put(y2.a.C, str);
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode c(int i7, String str, int i8, TraceNode traceNode) {
        TraceNode traceNodeA = a("configBySoftap", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("code", i7 + "");
        if (i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
            traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i8 > -1 ? String.valueOf(i8) : null);
        }
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode i(int i7, String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("saveDeviceVersion", "local", f.CR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode b(int i7, String str, int i8, TraceNode traceNode) {
        TraceNode traceNodeA = a("configBySoftap", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        if (i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
            traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i8 > -1 ? String.valueOf(i8) : null);
        }
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode f(TraceNode traceNode) {
        TraceNode traceNodeA = a("bindBySoftap", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SECURITY_TYPE, "2");
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "2");
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode d(int i7, String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindDevice_v2", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode e(int i7, String str, TraceNode traceNode) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f30230b;
        TraceNode traceNodeA = a(com.haier.uhome.trace.b.b.f30244a, "local", f.CR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_TOKEN, com.haier.uhome.usdk.base.service.e.a().g());
        traceNodeA.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        traceNodeA.add(TraceProtocolConst.PRO_SPAN, String.valueOf(jCurrentTimeMillis));
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode g(String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindSelfDevice", "local", f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode h(TraceNode traceNode) {
        TraceNode traceNodeA = a("bindBLEAdvDevice", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode c(int i7, String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindDevice_v2", "local", f.CR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode g(int i7, String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindSelfDevice", "local", f.CR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode d(int i7, String str, String str2, TraceNode traceNode) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f30229a;
        TraceNode traceNodeA = a("bioCer", "local", f.CR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_TOKEN, str2);
        traceNodeA.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        traceNodeA.add(TraceProtocolConst.PRO_SPAN, String.valueOf(jCurrentTimeMillis));
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode h(String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("saveDeviceVersion", "local", f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode b(int i7, String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindDevice", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode f(String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindByQRCode", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        if (str == null) {
            str = "";
        }
        eVar.put("qrCode", str);
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode c(int i7, String str, int i8, String str2, TraceNode traceNode) {
        TraceNode traceNodeA = a("configDeviceByNoPassword", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("code", i7 + "");
        if (i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
            traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i8 > -1 ? String.valueOf(i8) : null);
            traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SCM, str2);
        }
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(int i7, String str, int i8, TraceNode traceNode) {
        TraceNode traceNodeA = a("configBySmartLink", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("code", i7 + "");
        if (i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
            traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i8 > -1 ? String.valueOf(i8) : null);
        }
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode e(TraceNode traceNode) {
        return d("bindDeviceWithoutWifi", traceNode);
    }

    public TraceNode e(String str, TraceNode traceNode) {
        TraceNode traceNodeA = a(com.haier.uhome.usdk.base.a.aq, com.haier.uhome.usdk.base.a.aq, f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode b(String str, int i7, TraceNode traceNode) {
        TraceNode traceNodeA = a("getDeviceBindInfo", "local", f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i7 > -1 ? String.valueOf(i7) : null);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode e(int i7, String str, String str2, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindBLEAdvDevice", str2, f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode c(String str, int i7, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindPureBLEDevice", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "5");
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode d(TraceNode traceNode) {
        return d("bindByBLE", traceNode);
    }

    public TraceNode a(String str, String str2, String str3, String str4, boolean z7, ArrayList<String> arrayList, int i7, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindBySmartLink", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SECURITY_TYPE, z7 ? "1" : "2");
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "1");
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str4);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(RetInfoContent.TYPEID_ISNULL, a(arrayList));
        eVar.put(y2.a.C, str == null ? "" : str);
        if (str2 == null) {
            str2 = "";
        }
        eVar.put("bssid", str2);
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        eVar.put("ad", com.haier.library.common.util.a.i(str + str3));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode b(String str, String str2, TraceNode traceNode) {
        TraceNode traceNodeA = a(str2, com.haier.uhome.usdk.base.a.av, f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode d(String str, TraceNode traceNode) {
        TraceNode traceNodeA = a(str, "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "4");
        traceNodeA.add("mdl", this.f30233e);
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode b(int i7, String str, String str2, TraceNode traceNode) {
        TraceNode traceNodeA = a(str2, com.haier.uhome.usdk.base.a.av, f.CR, traceNode);
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode e(int i7, String str, TraceNode traceNode, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f30232d;
        TraceNode traceNodeA = a("bindDeviceByCameraScanQRCode", str2, f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_TRACE_ID, traceNode.getTraceId());
        traceNodeA.add("sys", e.USDK.name());
        traceNodeA.add(TraceProtocolConst.PRO_SPAN, String.valueOf(jCurrentTimeMillis));
        traceNodeA.add("code", i7 + "");
        if ("00000".equals(i7 + "") || i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
            traceNodeA.add("code", "00000");
        }
        traceNodeA.add(TraceProtocolConst.PRO_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode d(int i7, String str, TraceNode traceNode, String str2) {
        TraceNode traceNodeA = a("bindByQRCode", str2, f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("code", i7 + "");
        if (i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        }
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode b(int i7, String str, int i8, String str2, TraceNode traceNode) {
        TraceNode traceNodeA = a("getDeviceBindInfo", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        if (str2 == null) {
            str2 = "";
        }
        eVar.put("bindinfo", str2);
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i8 > -1 ? String.valueOf(i8) : null);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode c(int i7, String str, String str2, TraceNode traceNode) {
        TraceNode traceNodeA = a("setBleDevId", "local", f.CR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(RetInfoContent.TYPEID_ISNULL, str2);
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode d(String str, int i7, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindBLEAdvDevice", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(TraceNode traceNode) {
        TraceNode traceNodeA = a("bindBySmartLink", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "1");
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode b(String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("setBleDevId", "local", f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode c(String str, TraceNode traceNode) {
        this.f30230b = System.currentTimeMillis();
        TraceNode traceNodeA = a(com.haier.uhome.trace.b.b.f30244a, "local", f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_TOKEN, com.haier.uhome.usdk.base.service.e.a().g());
        traceNodeA.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("devId", str);
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode b(String str, int i7, String str2, TraceNode traceNode) {
        TraceNode traceNodeA = a(str, "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        if (i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str2);
        }
        traceNodeA.add("code", i7 + "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(int i7, String str, String str2, TraceNode traceNode, String str3) {
        TraceNode traceNodeA = a("bindBySmartLink", str3, f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("code", i7 + "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode b(int i7, String str, TraceNode traceNode, String str2) {
        TraceNode traceNodeA = a("bindByBLE", str2, f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        if (i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        }
        traceNodeA.add("code", i7 + "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, boolean z7, TraceNode traceNode, String str2) {
        TraceNode traceNodeA = a("smartLink", "local", f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_LINK_B_BSN, str2);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode c(String str, String str2, TraceNode traceNode) {
        TraceNode traceNodeA = a(str, "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str2);
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "4");
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(int i7, String str, int i8, String str2, String str3, TraceNode traceNode, String str4) {
        TraceNode traceNodeA = a("smartLink", "local", f.CR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SCM, str2);
        traceNodeA.add(TraceProtocolConst.PRO_USN, str3);
        traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i8 > -1 ? String.valueOf(i8) : null);
        traceNodeA.add(TraceProtocolConst.PRO_LINK_B_BSN, str4);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode b(String str, String str2, int i7, TraceNode traceNode) {
        TraceNode traceNodeA = a("retryBindDevice", str2, f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.setCustomTraceId(traceNode != null ? traceNode.getTraceId() : "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode c(int i7, String str, TraceNode traceNode, String str2) {
        TraceNode traceNodeA = a("bindDeviceWithoutWifi", str2, f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        if (i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        }
        traceNodeA.add("code", String.valueOf(i7));
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, String str2, TraceNode traceNode) {
        TraceNode traceNodeCreateNode = TraceNode.createNode(com.haier.uhome.trace.b.b.f30244a, "", f.CS, traceNode);
        traceNodeCreateNode.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(RetInfoContent.TYPEID_ISNULL, str2);
        traceNodeCreateNode.add(TraceProtocolConst.PRO_IPM, eVar.k());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeCreateNode);
        return traceNodeCreateNode;
    }

    public TraceNode c(String str, String str2, int i7, TraceNode traceNode) {
        TraceNode traceNodeA = a("retryBindDevice", str2, f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_PROTOCOL, str2);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("code", "" + i7);
        traceNodeA.setCustomTraceId(traceNode != null ? traceNode.getTraceId() : "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(int i7, String str, String str2, TraceNode traceNode) {
        TraceNode traceNodeCreateNode = TraceNode.createNode(com.haier.uhome.trace.b.b.f30244a, str2, f.CR, traceNode);
        traceNodeCreateNode.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeCreateNode.add("code", i7 + "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeCreateNode);
        return traceNodeCreateNode;
    }

    public TraceNode a(int i7, String str, String str2, Integer num, TraceNode traceNode) {
        TraceNode traceNodeA = a("getConfigInfo", "local", f.CR, traceNode);
        traceNodeA.add("code", i7 + "");
        if (i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            traceNodeA.add("btp", str2);
        }
        if (num != null) {
            traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SCM, (num.intValue() + 2) + "");
        }
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(int i7, String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("getSoftApDeviceConfigInfo", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        if (i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        }
        traceNodeA.add("code", i7 + "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, String str2, boolean z7, int i7, String str3, int i8, String str4, TraceNode traceNode) {
        TraceNode traceNodeA = a("configBySoftap", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SECURITY_TYPE, z7 ? "1" : "2");
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "2");
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str2);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        eVar.put(y2.a.C, str);
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        if (!TextUtils.isEmpty(str3)) {
            eVar.put("domain", str3);
            eVar.put("port", Integer.valueOf(i8));
        }
        if (!TextUtils.isEmpty(str4)) {
            eVar.put("country", str4);
        }
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, boolean z7, TraceNode traceNode) {
        TraceNode traceNodeA = a("softap", "local", f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SECURITY_TYPE, z7 ? "1" : "2");
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(int i7, String str, Integer num, TraceNode traceNode) {
        TraceNode traceNodeA = a("softap", "local", f.CR, traceNode);
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        if (num != null) {
            traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SCM, (num.intValue() + 2) + "");
        }
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, boolean z7, boolean z8, List<String> list, int i7, String str2, int i8, String str3, TraceNode traceNode) {
        TraceNode traceNodeA = a("configBySoftap", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SECURITY_TYPE, z7 ? "1" : "2");
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "2");
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        eVar.put(y2.a.C, str);
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        eVar.put("bkgcnt", z8 ? "1" : "0");
        eVar.put(RetInfoContent.TYPEID_ISNULL, a(list));
        if (!TextUtils.isEmpty(str2)) {
            eVar.put("domain", str2);
            eVar.put("port", Integer.valueOf(i8));
        }
        if (!TextUtils.isEmpty(str3)) {
            eVar.put("country", str3);
        }
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, int i7, String str2, int i8, TraceNode traceNode) {
        TraceNode traceNodeA = a("getDeviceBindInfo", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i7 > -1 ? String.valueOf(i7) : null);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        if (str2 == null) {
            str2 = "";
        }
        eVar.put(d.R, str2);
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i8));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, int i7, TraceNode traceNode) {
        TraceNode traceNodeA = a("getDeviceBindInfo", "local", f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i7 > -1 ? String.valueOf(i7) : null);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(int i7, String str, int i8, String str2, TraceNode traceNode) {
        TraceNode traceNodeA = a("getDeviceBindInfo", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        if (str2 == null) {
            str2 = "";
        }
        eVar.put("bindinfo", str2);
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i8 > -1 ? String.valueOf(i8) : null);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, String str2, String str3, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindDevice", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        if (str2 == null) {
            str2 = "";
        }
        eVar.put(HttpHelper.a.f29520d, str2);
        if (str3 == null) {
            str3 = "";
        }
        eVar.put("dname", str3);
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindDevice_v2", "local", f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, String str2, long j7, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindDevice_v2", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("clientid", com.haier.uhome.usdk.base.service.e.a().k());
        if (str2 == null) {
            str2 = "";
        }
        eVar.put("dname", str2);
        eVar.put(com.alipay.sdk.data.a.f13674p, Long.valueOf(j7));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, int i7, String str2, TraceNode traceNode) {
        TraceNode traceNodeA = a("getDeviceBindInfo", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i7 > -1 ? String.valueOf(i7) : null);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        if (str2 == null) {
            str2 = "";
        }
        eVar.put(d.R, str2);
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, String str2, int i7, TraceNode traceNode) {
        TraceNode traceNodeA = a("configDeviceByNoPassword", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SECURITY_TYPE, "2");
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "1");
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        if (str2 == null) {
            str2 = "";
        }
        eVar.put(RetInfoContent.TYPEID_ISNULL, str2);
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(int i7, String str, TraceNode traceNode, String str2) {
        TraceNode traceNodeA = a("bindPureBLEDevice", str2, f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, String str2, String str3, int i7, TraceNode traceNode) {
        this.f30229a = System.currentTimeMillis();
        TraceNode traceNodeA = a("bioCer", "local", f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_TOKEN, str2);
        traceNodeA.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("bleDevId", str);
        eVar.put(d.R, str2);
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        eVar.put("traceId", str3);
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(int i7, String str, String str2, int i8, TraceNode traceNode) {
        this.f30231c = System.currentTimeMillis();
        TraceNode traceNodeA = a("bindByBioCerBLE", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_TOKEN, com.haier.uhome.usdk.base.service.e.a().g());
        traceNodeA.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i7 > -1 ? String.valueOf(i7) : null);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, TraceProtocolConst.PRO_CONFIG_PROFILE_BT_SECURITY);
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i8));
        eVar.put("devId", str);
        eVar.put("uplusId", str2);
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(int i7, int i8, String str, TraceNode traceNode) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f30231c;
        TraceNode traceNodeA = a("bindByBioCerBLE", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add("code", i7 + "");
        traceNodeA.add(TraceProtocolConst.PRO_TOKEN, com.haier.uhome.usdk.base.service.e.a().g());
        traceNodeA.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        traceNodeA.add(TraceProtocolConst.PRO_SPAN, String.valueOf(jCurrentTimeMillis));
        traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i8 > -1 ? String.valueOf(i8) : null);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, TraceProtocolConst.PRO_CONFIG_PROFILE_BT_SECURITY);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, String str2, String str3, String str4, int i7, int i8, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindByBLE", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(y2.a.C, str2);
        eVar.put("bssid", str4);
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        eVar.put("ad", com.haier.library.common.util.a.i(str2 + str3));
        eVar.put("rssi", Integer.valueOf(i8));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "4");
        traceNodeA.add("mdl", this.f30233e);
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, int i7, int i8, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindDeviceWithoutWifi", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        eVar.put("rssi", Integer.valueOf(i8));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "4");
        traceNodeA.add("mdl", this.f30233e);
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, String str2, String str3, boolean z7, boolean z8, List<String> list, int i7, String str4, int i8, String str5, String str6, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindBySoftap", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_SECURITY_TYPE, z7 ? TraceProtocolConst.PRO_CONFIG_SECURITY_TYPE : "2");
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, "2");
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(y2.a.C, TextUtils.isEmpty(str) ? "" : str);
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        eVar.put("bssid", str3);
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        eVar.put("bkgcnt", z8 ? "1" : "0");
        eVar.put("domain", str4);
        eVar.put("port", Integer.valueOf(i8));
        eVar.put("country", str5);
        if (TextUtils.isEmpty(str6)) {
            str6 = "";
        }
        eVar.put("iotbssid", str6);
        eVar.put("ad", com.haier.library.common.util.a.i(str + str2));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(int i7, String str, int i8, TraceNode traceNode, String str2) {
        TraceNode traceNodeA = a("bindBySoftap", str2, f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("code", i7 + "");
        if (i7 == 0) {
            traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
            traceNodeA.add(TraceProtocolConst.PRO_MODULE_SECURITY_TYPE, i8 > -1 ? String.valueOf(i8) : null);
        }
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, String str2, String str3, String str4, long j7, int i7, long j8, TraceNode traceNode) {
        TraceNode traceNodeA = a(str, com.haier.uhome.usdk.base.a.av, f.CS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str2);
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("uplusId", str3);
        eVar.put("devName", str4);
        eVar.put("bindCode", Long.valueOf(j7));
        eVar.put("isSecurityCheck", Integer.valueOf(i7));
        eVar.put(com.alipay.sdk.data.a.f13674p, Long.valueOf(j8 / 1000));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, int i7, String str2, String str3, int i8, long j7, TraceNode traceNode) {
        TraceNode traceNodeA = a(str, com.haier.uhome.usdk.base.a.av, f.CR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str2);
        traceNodeA.add("code", i7 + "");
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("uplusId", str3);
        eVar.put("onLine", Integer.valueOf(i8));
        eVar.put("bts", Long.valueOf(j7));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(String str, double d8, TraceNode traceNode) {
        TraceNode traceNodeA = a("bindSelfDevice", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put(com.alipay.sdk.data.a.f13674p, Double.valueOf(d8));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    private TraceNode a(String str, String str2, f fVar, TraceNode traceNode) {
        TraceNode traceNodeCreateNode = TraceNode.createNode(str, str2, fVar, traceNode);
        traceNodeCreateNode.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        traceNodeCreateNode.add(TraceProtocolConst.PRO_TOKEN, com.haier.uhome.usdk.base.service.e.a().g());
        return traceNodeCreateNode;
    }

    private String a(List<String> list) {
        if (u.h(list)) {
            return "";
        }
        ArrayList arrayList = new ArrayList(list);
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            if (i7 == arrayList.size() - 1) {
                sb.append((String) arrayList.get(i7));
            } else {
                sb.append((String) arrayList.get(i7));
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public TraceNode a(String str, String str2, String str3, String str4, int i7, String str5, String str6, TraceNode traceNode) {
        this.f30232d = System.currentTimeMillis();
        TraceNode traceNodeA = a("bindDeviceByCameraScanQRCode", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE, TraceProtocolConst.PRO_CONFIG_PROFILE_TYPE_BLE_ADV);
        traceNodeA.add(TraceProtocolConst.PRO_TRACE_ID, traceNode.getTraceId());
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add("sys", e.USDK.name());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("productCode", str);
        eVar.put("BSSID", str2);
        eVar.put("QRCodeImgSize", str3);
        eVar.put(y2.a.C, str4);
        eVar.put("timeoutInterval", Integer.valueOf(i7));
        eVar.put("uplusID", str5);
        eVar.put("password", com.haier.library.common.util.a.i(str6));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        traceNodeA.add(TraceProtocolConst.PRO_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(TraceNode traceNode, String str, int i7) {
        TraceNode traceNodeA = a("bindCellularDevice", "local", f.SR, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("moduleId", str);
        eVar.put(com.alipay.sdk.data.a.f13674p, Integer.valueOf(i7));
        traceNodeA.add(TraceProtocolConst.PRO_IPM, eVar.k());
        traceNodeA.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        traceNodeA.add("mver", Build.VERSION.RELEASE);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public TraceNode a(TraceNode traceNode, String str, String str2) {
        TraceNode traceNodeA = a("bindCellularDevice", "local", f.SS, traceNode);
        traceNodeA.add(TraceProtocolConst.PRO_DEVICE_ID, str);
        traceNodeA.add(TraceProtocolConst.PRO_VERSION, VersionManager.getInstance().getSDKVersion());
        traceNodeA.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        traceNodeA.add("code", str2);
        i(com.haier.uhome.trace.b.b.f30244a, traceNodeA);
        return traceNodeA;
    }

    public int a(TraceNode traceNode, String str, String str2, String str3, String str4, String str5) {
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            e3.a.v("diTrace is empty,so return", new Object[0]);
            return -1;
        }
        DITraceNode dITraceNode = new DITraceNode(com.haier.uhome.trace.b.b.f30244a, str, str2, str4, VersionManager.getInstance().getSDKVersion());
        dITraceNode.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        dITraceNode.add(TraceProtocolConst.PRO_PROTOCOL, com.haier.uhome.usdk.base.a.av);
        dITraceNode.add("sys", e.USDK.name());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("moduleId", str2);
        if (!TextUtils.isEmpty(str3)) {
            eVar.put("moduleType", str3);
        }
        dITraceNode.add(TraceProtocolConst.PRO_IPM, eVar.k());
        dITraceNode.add(TraceProtocolConst.PRO_RRT, str5);
        return traceCreateDITrace.addDITraceNode(traceNode.getTraceId(), dITraceNode);
    }

    public int a(TraceNode traceNode, String str, String str2, String str3, String str4) {
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            e3.a.v("diTrace is empty,so return", new Object[0]);
            return -1;
        }
        DITraceNode dITraceNode = new DITraceNode(com.haier.uhome.trace.b.b.f30244a, str, str2, null, VersionManager.getInstance().getSDKVersion());
        dITraceNode.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        dITraceNode.add(TraceProtocolConst.PRO_PROTOCOL, "local");
        dITraceNode.add("sys", e.USDK.name());
        com.haier.library.json.e eVar = new com.haier.library.json.e();
        eVar.put("moduleId", str2);
        if (!TextUtils.isEmpty(str3)) {
            eVar.put("moduleType", str3);
        }
        dITraceNode.add(TraceProtocolConst.PRO_IPM, eVar.k());
        dITraceNode.add(TraceProtocolConst.PRO_RRT, str4);
        return traceCreateDITrace.addDITraceNode(traceNode.getTraceId(), dITraceNode);
    }
}
