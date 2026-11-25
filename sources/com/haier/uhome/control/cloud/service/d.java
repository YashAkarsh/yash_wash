package com.haier.uhome.control.cloud.service;

import com.haier.uhome.account.api.Const;
import com.haier.uhome.account.api.CustomReqInfo;
import com.haier.uhome.account.api.HttpRequestType;
import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.api.uAccount;
import com.haier.uhome.account.model.RespCommonModel;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f29194a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f29195b = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(String str) {
        e3.a.e("https parserRetCode %s", str);
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return ErrorConst.ERR_INTERNAL.getErrorId();
        }
    }

    public static void a(final int i7, final String str, final String str2, final String str3, final long j7, final int i8, final int i9, final long j8, final long j9, final long j10, final String str4) {
        e3.a.e("doHttpReq methodId = %d,devId = %s,bindCode = %d, bindCodeFrom = %d", Integer.valueOf(i7), str, Long.valueOf(j7), Integer.valueOf(i8));
        com.haier.uhome.usdk.base.d.f.a().b().post(new Runnable() { // from class: com.haier.uhome.control.cloud.service.g0
            @Override // java.lang.Runnable
            public final void run() {
                d.a(i7, str, str2, str3, j7, i8, str4, i9, j8, j9, j10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i7, int i8, String str, long j7) {
        e3.a.e("sendHttpResp methodId = %d,code = %d", Integer.valueOf(i7), Integer.valueOf(i8));
        b.a().a(i7, i8, str, j7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i7, String str, String str2, String str3, long j7, int i8, String str4, int i9, long j8, long j9, long j10) {
        int i10 = i7;
        String str5 = "";
        i10 = 1;
        try {
            if (i10 == 0) {
                a(str, str2, str3, j7, i8, str4, i9, j8);
            } else {
                if (i10 != 1) {
                    try {
                        b(i10, -9999, str5, j8);
                        return;
                    } catch (Exception e8) {
                        e = e8;
                        str5 = str5;
                        i10 = 1;
                        Object[] objArr = new Object[i10];
                        objArr[0] = e.getMessage();
                        e3.a.h("doHttpReq get excp %s", objArr);
                        b(i7, -9998, str5, j8);
                        return;
                    }
                }
                a(str, j7, i8, str4, i9, j8, j9, j10);
            }
        } catch (Exception e9) {
            e = e9;
        }
    }

    private static void a(String str, String str2, String str3, long j7, int i7, String str4, int i8, final long j8) {
        String str5 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + Const.DCS_BINDING;
        CustomReqInfo customReqInfo = new CustomReqInfo();
        customReqInfo.setUrl(str5);
        customReqInfo.setBody(a(str, str2, str3, j7));
        customReqInfo.setRequestType(HttpRequestType.POST);
        customReqInfo.setHttps(true);
        customReqInfo.setTimeout((i8 * 1000) - 500);
        customReqInfo.setNotFixResult(true);
        HashMap map = new HashMap(3);
        map.put("accessToken", com.haier.uhome.usdk.base.service.e.a().g());
        map.put("apiVersion", "v1");
        map.put("bindCodeType", "" + i7);
        map.put(TraceProtocolConst.PRO_TRACE_ID, str4);
        customReqInfo.setHeaders(map);
        uAccount.getSingleInstance().sendCustomRequest(com.haier.uhome.usdk.base.service.e.a().b(), customReqInfo, new IAccountListener<String>() { // from class: com.haier.uhome.control.cloud.service.d.1
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str6) {
                d.b(0, 0, str6, j8);
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onHttpError(RespCommonModel respCommonModel) {
                e3.a.v("onHttpError errInfo:<%s>", respCommonModel.getRetInfo());
                d.b(0, d.b(respCommonModel.getRetCode()), "", j8);
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onResponseFailed(RespCommonModel respCommonModel) {
                e3.a.v("onResponseFailed errInfo:<%s>", respCommonModel.getRetInfo());
                d.b(0, d.b(respCommonModel.getRetCode()), "", j8);
            }
        });
    }

    private static Map<String, Object> a(String str, String str2, String str3, long j7) {
        HashMap map = new HashMap();
        map.put(com.haier.globalwasher.presenter.o.f25218y, str);
        map.put("uplusId", str2);
        map.put("deviceName", str3);
        map.put("bindCode", Long.valueOf(j7));
        return map;
    }

    private static void a(String str, long j7, int i7, String str2, int i8, final long j8, long j9, long j10) {
        String str3 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + Const.DCS_GET_BINDING_STATUS;
        CustomReqInfo customReqInfo = new CustomReqInfo();
        customReqInfo.setUrl(str3);
        customReqInfo.setBody(a(str, j7, j9, j10));
        customReqInfo.setRequestType(HttpRequestType.POST);
        customReqInfo.setHttps(true);
        customReqInfo.setTimeout((i8 * 1000) - 500);
        customReqInfo.setNotFixResult(true);
        HashMap map = new HashMap(3);
        map.put("accessToken", com.haier.uhome.usdk.base.service.e.a().g());
        map.put("apiVersion", "v2");
        map.put("bindCodeType", "" + i7);
        map.put(TraceProtocolConst.PRO_TRACE_ID, str2);
        customReqInfo.setHeaders(map);
        uAccount.getSingleInstance().sendCustomRequest(com.haier.uhome.usdk.base.service.e.a().b(), customReqInfo, new IAccountListener<String>() { // from class: com.haier.uhome.control.cloud.service.d.2
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str4) {
                d.b(1, 0, str4, j8);
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onHttpError(RespCommonModel respCommonModel) {
                e3.a.v("onHttpError errInfo:<%s>", respCommonModel.getRetInfo());
                d.b(1, d.b(respCommonModel.getRetCode()), "", j8);
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onResponseFailed(RespCommonModel respCommonModel) {
                e3.a.v("onResponseFailed errInfo:<%s>", respCommonModel.getRetInfo());
                d.b(1, d.b(respCommonModel.getRetCode()), "", j8);
            }
        });
    }

    private static Map<String, Object> a(String str, long j7, long j8, long j9) {
        HashMap map = new HashMap(4);
        map.put(com.haier.globalwasher.presenter.o.f25218y, str);
        map.put("bindCode", Long.valueOf(j7));
        if (j8 > 0) {
            map.put("lastBts", Long.valueOf(j8));
        }
        map.put("btsOffset", Long.valueOf(j9));
        return map;
    }
}
