package com.haier.uhome.trace.api;

import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.service.e;
import com.paytm.pgsdk.d;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(String str, Object obj) {
        a(str, "", obj);
    }

    private static String b(Object obj) {
        return obj == null ? "" : b(obj, "getUserToken");
    }

    private static String c(Object obj) {
        return obj == null ? "" : b(obj, "getUserID");
    }

    public static void a(String str, Object obj, String str2) {
        a(str, "", obj, str2);
    }

    private static String b(Object obj, String str) {
        try {
            return (String) obj.getClass().getDeclaredMethod(str, new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean a(Object obj) {
        return (obj == null || obj.getClass().getAnnotation(com.haier.uhome.usdk.base.e.a.class) == null) ? false : true;
    }

    public static void a(String str, String str2, Object obj) {
        a(str, str2, obj, e.a().g());
    }

    private static void a(String str, String str2, Object obj, String str3) {
        Trace traceCreateDITrace;
        com.haier.uhome.usdk.base.e.a aVar;
        e3.a.d("method <%s> deviceid <%s> is self caller <%s>", str == null ? "" : str, str2 != null ? str2 : "", Boolean.valueOf(a(obj)));
        if ((obj == null || (aVar = (com.haier.uhome.usdk.base.e.a) obj.getClass().getAnnotation(com.haier.uhome.usdk.base.e.a.class)) == null || !aVar.a()) && (traceCreateDITrace = Trace.createDITrace()) != null) {
            DITraceNode dITraceNode = new DITraceNode(TraceProtocolConst.PRO_BUSINESS_ID_FUN, str, str2, "00000", VersionManager.getInstance().getSDKVersion());
            HashMap map = new HashMap(1);
            map.put("user", Integer.valueOf(a(obj) ? 1 : 0));
            dITraceNode.add(TraceProtocolConst.PRO_IPM, com.haier.library.json.a.Z(map));
            dITraceNode.add(TraceProtocolConst.PRO_TOKEN, str3);
            dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
            traceCreateDITrace.addDITraceNode(dITraceNode);
        }
    }

    public static void a(Object obj, String str) {
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            return;
        }
        DITraceNode dITraceNode = new DITraceNode(TraceProtocolConst.PRO_BUSINESS_ID_FUN, "setUserInfo", "", "00000", VersionManager.getInstance().getSDKVersion());
        HashMap map = new HashMap(3);
        map.put("userInfo", Integer.valueOf(obj != null ? 1 : 0));
        map.put(d.R, b(obj));
        map.put("userId", c(obj));
        dITraceNode.add(TraceProtocolConst.PRO_IPM, com.haier.library.json.a.Z(map));
        dITraceNode.add(TraceProtocolConst.PRO_TOKEN, str);
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        traceCreateDITrace.addDITraceNode(dITraceNode);
    }
}
