package com.haier.uhome.control.base.c;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.haier.uhome.account.api.CustomReqInfo;
import com.haier.uhome.account.api.HttpRequestType;
import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.api.uAccount;
import com.haier.uhome.account.model.RespCommonModel;
import com.haier.uhome.account.okhttp.uAccountRequest;
import com.haier.uhome.control.base.json.DeviceNetQualityDto;
import com.haier.uhome.control.base.json.DeviceTokenInfo;
import com.haier.uhome.control.base.json.DeviceTokenInfoList;
import com.haier.uhome.control.base.json.NetworkQualityInfoV2Dto;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f28883a = "00000";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f28884b = "/uds/v1/protected/{deviceId}/deviceNetQuality";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f28885c = "/uds/v1/protected/dcd/auth";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f28886d = "/uds/v1/protected/dcd/invalid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f28887e = "/uds/v1/protected/dcd/list";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f28888f = "/dcs/device-service-2c/get/device/net/quality";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f28889g = {"wifi"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f28890h = {"H", "G", "R"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<a> f28891i;

    /* JADX INFO: renamed from: com.haier.uhome.control.base.c.d$1, reason: invalid class name */
    class AnonymousClass1 implements IAccountListener<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.haier.uhome.control.base.api.m f28892a;

        AnonymousClass1(com.haier.uhome.control.base.api.m mVar) {
            this.f28892a = mVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(com.haier.uhome.control.base.api.m mVar) {
            mVar.onDeviceNetQualityGet(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR, null, 0);
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponseSuccess(final String str) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.control.base.api.m mVar = this.f28892a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.b0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28878a.a(str, mVar);
                }
            });
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onHttpError(RespCommonModel respCommonModel) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.control.base.api.m mVar = this.f28892a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.z
                @Override // java.lang.Runnable
                public final void run() {
                    d.AnonymousClass1.a(mVar);
                }
            });
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onResponseFailed(RespCommonModel respCommonModel) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.control.base.api.m mVar = this.f28892a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.a0
                @Override // java.lang.Runnable
                public final void run() {
                    d.AnonymousClass1.b(mVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(String str, com.haier.uhome.control.base.api.m mVar) {
            if (TextUtils.isEmpty(str)) {
                mVar.onDeviceNetQualityGet(ErrorConst.ERR_INTERNAL, null, 0);
                return;
            }
            try {
                DeviceNetQualityDto deviceNetQualityDto = (DeviceNetQualityDto) com.haier.library.json.a.z(com.haier.library.json.a.t(str).get("deviceNetQualityDto").toString(), DeviceNetQualityDto.class);
                if (deviceNetQualityDto != null && !TextUtils.isEmpty(deviceNetQualityDto.getNetType())) {
                    if (!d.this.a(deviceNetQualityDto)) {
                        mVar.onDeviceNetQualityGet(ErrorConst.ERR_USDK_DEVICE_NOT_NETQUALITY, null, 0);
                        return;
                    } else {
                        int iB = d.this.b(deviceNetQualityDto);
                        mVar.onDeviceNetQualityGet(ErrorConst.RET_USDK_OK, d.this.a(iB), iB);
                        return;
                    }
                }
                mVar.onDeviceNetQualityGet(ErrorConst.ERR_USDK_DEVICE_NOT_GET_NETQUALITY, null, 0);
            } catch (Exception e8) {
                e3.a.v("requestDeviceNetQuality excp -> %s", e8);
                mVar.onDeviceNetQualityGet(ErrorConst.ERR_INTERNAL, null, 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(com.haier.uhome.control.base.api.m mVar) {
            mVar.onDeviceNetQualityGet(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR, null, 0);
        }
    }

    /* JADX INFO: renamed from: com.haier.uhome.control.base.c.d$3, reason: invalid class name */
    class AnonymousClass3 implements IAccountListener<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.haier.uhome.control.base.api.n f28896a;

        AnonymousClass3(com.haier.uhome.control.base.api.n nVar) {
            this.f28896a = nVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(com.haier.uhome.control.base.api.n nVar) {
            nVar.onDeviceTokenGet(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR, "");
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponseSuccess(final String str) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.control.base.api.n nVar = this.f28896a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.c0
                @Override // java.lang.Runnable
                public final void run() {
                    d.AnonymousClass3.a(str, nVar);
                }
            });
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onHttpError(RespCommonModel respCommonModel) {
            e3.a.h("requestDeviceToken onHttpError<%s>", respCommonModel.toString());
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.control.base.api.n nVar = this.f28896a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.e0
                @Override // java.lang.Runnable
                public final void run() {
                    d.AnonymousClass3.a(nVar);
                }
            });
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onResponseFailed(RespCommonModel respCommonModel) {
            e3.a.h("requestDeviceToken onResponseFailed<%s>", respCommonModel.toString());
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.control.base.api.n nVar = this.f28896a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.d0
                @Override // java.lang.Runnable
                public final void run() {
                    d.AnonymousClass3.b(nVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, com.haier.uhome.control.base.api.n nVar) {
            if (TextUtils.isEmpty(str)) {
                nVar.onDeviceTokenGet(ErrorConst.ERR_INTERNAL, "");
                return;
            }
            try {
                com.haier.library.json.e eVarT = com.haier.library.json.a.t(str);
                if (eVarT.R0(uAccountRequest.KEY_RET_CODE).equals("00000")) {
                    nVar.onDeviceTokenGet(ErrorConst.RET_USDK_OK, eVarT.R0("deviceToken"));
                } else {
                    e3.a.h("requestDeviceToken error<%s>", eVarT.toString());
                    nVar.onDeviceTokenGet(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR, "");
                }
            } catch (Exception e8) {
                e3.a.v("requestDeviceToken excp -> %s", e8);
                nVar.onDeviceTokenGet(ErrorConst.ERR_INTERNAL, "");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(com.haier.uhome.control.base.api.n nVar) {
            nVar.onDeviceTokenGet(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR, "");
        }
    }

    /* JADX INFO: renamed from: com.haier.uhome.control.base.c.d$4, reason: invalid class name */
    class AnonymousClass4 implements IAccountListener<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.haier.uhome.usdk.base.api.o f28898a;

        AnonymousClass4(com.haier.uhome.usdk.base.api.o oVar) {
            this.f28898a = oVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(String str, com.haier.uhome.usdk.base.api.o oVar) {
            if (TextUtils.isEmpty(str)) {
                oVar.onCallback(ErrorConst.ERR_INTERNAL);
                return;
            }
            try {
                if (com.haier.library.json.a.t(str).R0(uAccountRequest.KEY_RET_CODE).equals("00000")) {
                    oVar.onCallback(ErrorConst.RET_USDK_OK);
                } else {
                    oVar.onCallback(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR);
                }
            } catch (Exception e8) {
                e3.a.v("requestInvalidDeviceToken excp -> %s", e8);
                oVar.onCallback(ErrorConst.ERR_INTERNAL);
            }
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponseSuccess(final String str) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.usdk.base.api.o oVar = this.f28898a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.f0
                @Override // java.lang.Runnable
                public final void run() {
                    d.AnonymousClass4.b(str, oVar);
                }
            });
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onHttpError(RespCommonModel respCommonModel) {
            e3.a.h("requestInvalidDeviceToken onHttpError<%s>", respCommonModel.toString());
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.usdk.base.api.o oVar = this.f28898a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.g0
                @Override // java.lang.Runnable
                public final void run() {
                    d.AnonymousClass4.a(oVar);
                }
            });
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onResponseFailed(RespCommonModel respCommonModel) {
            final String retCode = respCommonModel.getRetCode();
            e3.a.h("requestInvalidDeviceToken onResponseFailed<%s>", respCommonModel.toString());
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.usdk.base.api.o oVar = this.f28898a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.h0
                @Override // java.lang.Runnable
                public final void run() {
                    d.AnonymousClass4.a(retCode, oVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, com.haier.uhome.usdk.base.api.o oVar) {
            if (str.equals("D00020")) {
                oVar.onCallback(ErrorConst.RET_USDK_OK);
            } else {
                oVar.onCallback(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(com.haier.uhome.usdk.base.api.o oVar) {
            oVar.onCallback(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR);
        }
    }

    /* JADX INFO: renamed from: com.haier.uhome.control.base.c.d$5, reason: invalid class name */
    class AnonymousClass5 implements IAccountListener<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.haier.uhome.control.base.api.j f28900a;

        AnonymousClass5(com.haier.uhome.control.base.api.j jVar) {
            this.f28900a = jVar;
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponseSuccess(final String str) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.control.base.api.j jVar = this.f28900a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.k0
                @Override // java.lang.Runnable
                public final void run() {
                    d.AnonymousClass5.a(str, jVar);
                }
            });
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onHttpError(RespCommonModel respCommonModel) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.control.base.api.j jVar = this.f28900a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.j0
                @Override // java.lang.Runnable
                public final void run() {
                    d.AnonymousClass5.a(jVar);
                }
            });
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onResponseFailed(RespCommonModel respCommonModel) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final com.haier.uhome.control.base.api.j jVar = this.f28900a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.control.base.c.i0
                @Override // java.lang.Runnable
                public final void run() {
                    d.AnonymousClass5.b(jVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str, com.haier.uhome.control.base.api.j jVar) {
            if (TextUtils.isEmpty(str)) {
                jVar.onDeviceTokenInfoList(ErrorConst.ERR_INTERNAL, null);
                return;
            }
            try {
                DeviceTokenInfoList deviceTokenInfoList = (DeviceTokenInfoList) com.haier.library.json.a.z(str, DeviceTokenInfoList.class);
                DeviceTokenInfo[] tokenList = deviceTokenInfoList.getTokenList();
                if (deviceTokenInfoList.getRetCode().equals("00000")) {
                    jVar.onDeviceTokenInfoList(ErrorConst.RET_USDK_OK, tokenList);
                } else {
                    jVar.onDeviceTokenInfoList(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR, null);
                }
            } catch (Exception e8) {
                e3.a.v("requestDeviceTokenInfoList excp -> %s", e8);
                jVar.onDeviceTokenInfoList(ErrorConst.ERR_INTERNAL, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(com.haier.uhome.control.base.api.j jVar) {
            jVar.onDeviceTokenInfoList(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(com.haier.uhome.control.base.api.j jVar) {
            jVar.onDeviceTokenInfoList(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR, null);
        }
    }

    protected class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f28902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f28903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f28904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList<String> f28905d;

        protected a(String str, String str2, String str3, ArrayList<String> arrayList) {
            this.f28902a = str;
            this.f28903b = str2;
            this.f28904c = str3;
            this.f28905d = arrayList;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static d f28907a = new d(null);

        private b() {
        }
    }

    /* synthetic */ d(AnonymousClass1 anonymousClass1) {
        this();
    }

    private d() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("2.5.00");
        ArrayList<a> arrayList2 = new ArrayList<>();
        this.f28891i = arrayList2;
        arrayList2.add(new a("R_1.0.00", "eSDK_WIFI_AC", "2.3.30", arrayList));
        this.f28891i.add(new a("R_1.0.00", com.haier.uhome.control.local.c.a.f29368a, "2.3.30", arrayList));
        this.f28891i.add(new a("R_3.0.00", "UHOME_SUNING_AC", "2.3.13", null));
        this.f28891i.add(new a("R_3.0.00", "UHOME_SUNING_UWT", "2.3.13", null));
        this.f28891i.add(new a("R_3.0.00", "UHOME_HILINK_AC", "2.3.06", null));
        this.f28891i.add(new a("R_3.0.00", "UHOME_JOYLINK_UWT", "2.3.12", null));
    }

    private int b(int i7) {
        double d8;
        double d9 = ((((double) (i7 + org.chromium.net.v.V2)) * 0.7d) + 95.0d) * 1.111d;
        if (d9 < 42.0d) {
            d8 = 4.0d;
        } else if (d9 < 42.0d || d9 >= 52.0d) {
            d8 = ((d9 < 52.0d || d9 >= 64.0d) && (d9 < 64.0d || d9 >= 76.0d)) ? 0.0d : d9 - 33.0d;
        } else {
            d8 = (((d9 - 42.0d) * 3.0d) / 2.0d) + 5.0d;
        }
        return (int) d8;
    }

    public static d a() {
        return b.f28907a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(DeviceNetQualityDto deviceNetQualityDto) throws Exception {
        a next;
        if (deviceNetQualityDto != null) {
            if (deviceNetQualityDto.getHardwareType() != null && deviceNetQualityDto.getSoftwareType() != null && deviceNetQualityDto.getSoftwareVers() != null && deviceNetQualityDto.getHardwareVers() != null) {
                if (!deviceNetQualityDto.getHardwareType().startsWith("R")) {
                    return deviceNetQualityDto.getStrength();
                }
                Iterator<a> it = this.f28891i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.f28902a.equals(deviceNetQualityDto.getHardwareType() + "_" + deviceNetQualityDto.getHardwareVers()) && next.f28903b.equals(deviceNetQualityDto.getSoftwareType())) {
                        break;
                    }
                }
                if (next == null) {
                    return deviceNetQualityDto.getStrength();
                }
                boolean z7 = a(deviceNetQualityDto.getSoftwareVers()) < a(next.f28904c);
                ArrayList<String> arrayList = next.f28905d;
                if (arrayList != null && !z7) {
                    Iterator<String> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        if (it2.next().equals(deviceNetQualityDto.getSoftwareVers())) {
                            z7 = true;
                            break;
                        }
                    }
                }
                if (!z7) {
                    return deviceNetQualityDto.getStrength();
                }
                int iB = b(deviceNetQualityDto.getStrength());
                e3.a.e("correctionStrength effect %d to %d", Integer.valueOf(deviceNetQualityDto.getStrength()), Integer.valueOf(iB));
                return iB;
            }
            throw new Exception("null deviceNetQualityDto item");
        }
        throw new Exception("null deviceNetQualityDto");
    }

    protected void a(Context context, String str, String str2, final com.haier.uhome.control.base.api.m mVar) {
        if (context != null && str != null && str2 != null) {
            String str3 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + f28884b.replace("{deviceId}", str2);
            CustomReqInfo customReqInfo = new CustomReqInfo();
            customReqInfo.setToken(str);
            customReqInfo.setUrl(str3);
            customReqInfo.setRequestType(HttpRequestType.GET);
            customReqInfo.setBody(new HashMap());
            customReqInfo.setHttps(true);
            uAccount.getSingleInstance().sendCustomRequest(context, customReqInfo, new AnonymousClass1(mVar));
            return;
        }
        final ErrorConst errorConst = ErrorConst.ERR_INTERNAL;
        if (context == null) {
            errorConst = ErrorConst.ERR_USDK_NOT_CALL_INIT;
        } else if (str == null) {
            errorConst = ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.c.x
            @Override // java.lang.Runnable
            public final void run() {
                mVar.onDeviceNetQualityGet(errorConst, null, 0);
            }
        });
    }

    protected void a(Context context, String str, String str2, final ICallback<com.haier.uhome.control.base.api.s> iCallback) {
        if (context != null && str != null && str2 != null) {
            String str3 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + "/dcs/device-service-2c/get/device/net/quality";
            HashMap map = new HashMap(1);
            map.put(com.haier.globalwasher.presenter.o.f25218y, str2);
            CustomReqInfo customReqInfo = new CustomReqInfo();
            customReqInfo.setUrl(str3);
            customReqInfo.setToken(com.haier.uhome.usdk.base.service.e.a().g());
            customReqInfo.setBody(map);
            customReqInfo.setRequestType(HttpRequestType.POST);
            customReqInfo.setHttps(true);
            customReqInfo.setTimeout(5L);
            uAccount.getSingleInstance().sendCustomRequest(context, customReqInfo, new IAccountListener<String>() { // from class: com.haier.uhome.control.base.c.d.2
                @Override // com.haier.uhome.account.api.interfaces.IAccountListener
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResponseSuccess(String str4) {
                    if (TextUtils.isEmpty(str4)) {
                        uSDKError error = ErrorConst.ERR_INTERNAL.toError();
                        error.a("http resp is empty");
                        iCallback.onFailure(error);
                        return;
                    }
                    try {
                        NetworkQualityInfoV2Dto networkQualityInfoV2Dto = (NetworkQualityInfoV2Dto) com.haier.library.json.a.z(com.haier.library.json.a.t(str4).R0(MessengerShareContentUtility.ATTACHMENT_PAYLOAD), NetworkQualityInfoV2Dto.class);
                        if (networkQualityInfoV2Dto == null) {
                            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_NOT_GET_NETQUALITY.toError());
                        } else {
                            iCallback.onSuccess(new com.haier.uhome.control.base.api.s(networkQualityInfoV2Dto));
                        }
                    } catch (Exception e8) {
                        e3.a.v("requestDeviceNetQuality excp -> %s", e8);
                        uSDKError error2 = ErrorConst.ERR_INTERNAL.toError();
                        error2.a(e8.getMessage());
                        iCallback.onFailure(error2);
                    }
                }

                @Override // com.haier.uhome.account.api.interfaces.IAccountListener
                public void onHttpError(RespCommonModel respCommonModel) {
                    uSDKError error = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
                    error.a(respCommonModel.getRetCode() + "<->" + respCommonModel.getRetInfo());
                    iCallback.onFailure(error);
                }

                @Override // com.haier.uhome.account.api.interfaces.IAccountListener
                public void onResponseFailed(RespCommonModel respCommonModel) {
                    uSDKError error = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
                    error.a(respCommonModel.getRetCode() + "<->" + respCommonModel.getRetInfo());
                    iCallback.onFailure(error);
                }
            });
            return;
        }
        ErrorConst errorConst = ErrorConst.ERR_INTERNAL;
        if (context == null) {
            errorConst = ErrorConst.ERR_USDK_NOT_CALL_INIT;
        } else if (str == null) {
            errorConst = ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST;
        }
        iCallback.onFailure(errorConst.toError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(DeviceNetQualityDto deviceNetQualityDto) throws Exception {
        if (deviceNetQualityDto != null) {
            if (deviceNetQualityDto.getNetType() != null) {
                return !deviceNetQualityDto.getNetType().equalsIgnoreCase("unknown");
            }
            throw new Exception("null deviceNetQualityDto item");
        }
        throw new Exception("null deviceNetQualityDto");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.haier.uhome.control.base.api.f a(int i7) {
        if (i7 <= 20) {
            return com.haier.uhome.control.base.api.f.WEAK;
        }
        if (i7 <= 30) {
            return com.haier.uhome.control.base.api.f.MIDDLE;
        }
        if (i7 <= 40) {
            return com.haier.uhome.control.base.api.f.GOOD;
        }
        return com.haier.uhome.control.base.api.f.STRONG;
    }

    private long a(String str) throws Exception {
        long j7 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length != 0) {
            long j8 = 1;
            for (int length = strArrSplit.length - 1; length >= 0; length--) {
                j7 += Long.parseLong(strArrSplit[length]) * j8;
                j8 *= 1000;
            }
            return j7;
        }
        throw new Exception("split softwareVers fail!!!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.api.n nVar) {
        nVar.onDeviceTokenGet(ErrorConst.ERR_INTERNAL, "");
    }

    protected void a(Context context, String str, String str2, final com.haier.uhome.control.base.api.n nVar) {
        if (context != null && str != null && str2 != null) {
            String str3 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + f28885c;
            CustomReqInfo customReqInfo = new CustomReqInfo();
            customReqInfo.setToken(str);
            customReqInfo.setUrl(str3);
            customReqInfo.setRequestType(HttpRequestType.POST);
            HashMap map = new HashMap();
            map.put(com.haier.globalwasher.presenter.o.f25218y, str2);
            customReqInfo.setBody(map);
            customReqInfo.setHttps(true);
            uAccount.getSingleInstance().sendCustomRequest(context, customReqInfo, new AnonymousClass3(nVar));
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.c.y
            @Override // java.lang.Runnable
            public final void run() {
                d.a(nVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.usdk.base.api.o oVar) {
        oVar.onCallback(ErrorConst.ERR_INTERNAL);
    }

    public void a(Context context, String str, String str2, final com.haier.uhome.usdk.base.api.o oVar) {
        if (context != null && str != null && str2 != null) {
            String str3 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + f28886d;
            CustomReqInfo customReqInfo = new CustomReqInfo();
            customReqInfo.setToken(str);
            customReqInfo.setUrl(str3);
            customReqInfo.setRequestType(HttpRequestType.POST);
            HashMap map = new HashMap();
            map.put(com.haier.globalwasher.presenter.o.f25218y, str2);
            customReqInfo.setBody(map);
            customReqInfo.setHttps(true);
            uAccount.getSingleInstance().sendCustomRequest(context, customReqInfo, new AnonymousClass4(oVar));
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.c.v
            @Override // java.lang.Runnable
            public final void run() {
                d.a(oVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.api.j jVar) {
        jVar.onDeviceTokenInfoList(ErrorConst.ERR_USDK_INVALID_PARAM, null);
    }

    public void a(Context context, String str, final com.haier.uhome.control.base.api.j jVar) {
        if (context != null && str != null) {
            e3.a.o("token:" + str, new Object[0]);
            String str2 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + f28887e;
            CustomReqInfo customReqInfo = new CustomReqInfo();
            customReqInfo.setToken(str);
            customReqInfo.setUrl(str2);
            customReqInfo.setRequestType(HttpRequestType.POST);
            customReqInfo.setBody(new HashMap());
            customReqInfo.setHttps(true);
            uAccount.getSingleInstance().sendCustomRequest(context, customReqInfo, new AnonymousClass5(jVar));
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.c.w
            @Override // java.lang.Runnable
            public final void run() {
                d.a(jVar);
            }
        });
    }
}
