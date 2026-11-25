package com.haier.uhome.usdk.bind;

import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.haier.uhome.account.api.Const;
import com.haier.uhome.account.api.CustomReqInfo;
import com.haier.uhome.account.api.HttpRequestType;
import com.haier.uhome.account.api.interfaces.IAccountListener;
import com.haier.uhome.account.api.uAccount;
import com.haier.uhome.account.model.RespCommonModel;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.interfaces.IuSDKResultCallback;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.api.uSDKErrorConst;
import com.haier.uhome.usdk.api.uSDKManager;
import com.haier.uhome.usdk.api.uSDKState;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31723a = "/uds/v1/protected/bindDevice";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31724b = "/uds/v1/protected/{deviceId}/unbindDevice";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31725c = 15;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f31726d = 1000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f31727e = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f31728i = "MB-UBOT-0009";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f31729j = "f36fb2d43f12c84a99f19f17e80ec77d";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f31730l = 2000005;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, AtomicBoolean> f31731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<String> f31732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f31733h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.haier.uhome.usdk.base.utils.e f31734k;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.bind.s$11, reason: invalid class name */
    class AnonymousClass11 implements IAccountListener<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IuSDKResultCallback f31748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f31749b;

        AnonymousClass11(IuSDKResultCallback iuSDKResultCallback, String str) {
            this.f31748a = iuSDKResultCallback;
            this.f31749b = str;
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onHttpError(final RespCommonModel respCommonModel) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final IuSDKResultCallback iuSDKResultCallback = this.f31748a;
            final String str = this.f31749b;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.usdk.bind.j1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31602a.a(iuSDKResultCallback, str, respCommonModel);
                }
            });
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        public void onResponseFailed(final RespCommonModel respCommonModel) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final IuSDKResultCallback iuSDKResultCallback = this.f31748a;
            final String str = this.f31749b;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.usdk.bind.l1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31629a.b(iuSDKResultCallback, str, respCommonModel);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(IuSDKResultCallback iuSDKResultCallback, String str, RespCommonModel respCommonModel) {
            if (iuSDKResultCallback != null) {
                if (s.this.f31733h.remove(str)) {
                    iuSDKResultCallback.onSuccess("get unBind msg");
                    e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "unbindDevice onResponseFailed, but get unBind msg,so ret ok!", new Object[0]);
                } else {
                    iuSDKResultCallback.onFail(uSDKErrorConst.ERR_USDK_CLOUD_COMMON_ERROR);
                    e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "unbindDevice onResponseFailed : <%s>", respCommonModel.toString());
                }
            }
        }

        @Override // com.haier.uhome.account.api.interfaces.IAccountListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponseSuccess(final String str) {
            com.haier.library.common.thread.a aVarB = com.haier.library.common.thread.a.b();
            final IuSDKResultCallback iuSDKResultCallback = this.f31748a;
            aVarB.c(new Runnable() { // from class: com.haier.uhome.usdk.bind.k1
                @Override // java.lang.Runnable
                public final void run() {
                    s.AnonymousClass11.a(iuSDKResultCallback, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(IuSDKResultCallback iuSDKResultCallback, String str) {
            if (iuSDKResultCallback != null) {
                iuSDKResultCallback.onSuccess(str);
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "unbindDevice onResponseSuccess :", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(IuSDKResultCallback iuSDKResultCallback, String str, RespCommonModel respCommonModel) {
            if (iuSDKResultCallback != null) {
                if (s.this.f31733h.remove(str)) {
                    iuSDKResultCallback.onSuccess("get unBind msg");
                    e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "unbindDevice onHttpError, but get unBind msg,so ret ok!", new Object[0]);
                } else {
                    iuSDKResultCallback.onFail(uSDKErrorConst.ERR_USDK_CLOUD_COMMON_ERROR);
                    e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "unbindDevice onHttpError : <%s>", respCommonModel.toString());
                }
            }
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final s f31801a = new s();

        private a() {
        }
    }

    private void d() {
        com.haier.uhome.control.cloud.a.h.a().a(new com.haier.uhome.control.cloud.a.a() { // from class: com.haier.uhome.usdk.bind.s.12
            @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
            public void a(String str, String str2, String str3, int i7, int i8, String str4) {
            }

            @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
            public void a(String str, String str2, String str3) {
                if (s.this.f31732g.contains(str2)) {
                    return;
                }
                s.this.f31732g.add(str2);
            }

            @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
            public void a(String str, String str2) {
                if (s.this.f31733h.contains(str2)) {
                    return;
                }
                s.this.f31733h.add(str2);
            }

            @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
            public void a(String str, int i7, String str2, int i8) {
                if (s.this.f31732g.contains(str)) {
                    return;
                }
                s.this.f31732g.add(str);
            }

            @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
            public void a(String str, int i7, int i8) {
                if (s.this.f31733h.contains(str)) {
                    return;
                }
                s.this.f31733h.add(str);
            }
        });
    }

    private Map<String, Object> e() {
        return new HashMap();
    }

    private s() {
        this.f31731f = new ConcurrentHashMap();
        this.f31732g = Collections.synchronizedList(new LinkedList());
        this.f31733h = Collections.synchronizedList(new LinkedList());
        d();
    }

    public void c() {
        if (this.f31734k != null) {
            e3.a.e("interruptBindDeviceOnline", new Object[0]);
            this.f31734k.i();
        }
    }

    private boolean b(String str) {
        for (String str2 : com.haier.uhome.config.a.C.split("\\|")) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public Map<String, AtomicBoolean> b() {
        return this.f31731f;
    }

    public static s a() {
        return a.f31801a;
    }

    private void b(final String str, final String str2, final String str3, final long j7, int i7, final boolean z7, long j8, TraceNode traceNode, final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        final TraceNode traceNodeA = com.haier.uhome.trace.api.b.a().a("https://" + com.haier.uhome.usdk.base.service.e.a().d() + Const.DCS_BINDING, str, str2, str3, j7, z7 ? 1 : 0, j8, traceNode);
        RetryBindDeviceHandler.getSingleInstance().a(str).b(str2).a(j7).a(i7).a(true);
        final String traceId = traceNode == null ? "" : traceNode.getTraceId();
        com.haier.uhome.usdk.base.utils.e<String> eVar = new com.haier.uhome.usdk.base.utils.e<String>(j8, 1000L) { // from class: com.haier.uhome.usdk.bind.s.3
            @Override // com.haier.uhome.usdk.base.utils.e
            public void a(long j9) {
                final com.haier.uhome.usdk.base.api.c cVar = new com.haier.uhome.usdk.base.api.c();
                cVar.a(ErrorConst.ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND.toError());
                s.this.a(str, str2, str3, j7, z7, traceId, new ICallback<String>() { // from class: com.haier.uhome.usdk.bind.s.3.1
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(String str4) {
                        cVar.a(ErrorConst.RET_USDK_OK.toError());
                        cVar.a(str4);
                        b(cVar);
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        cVar.a(usdkerror);
                        b(cVar);
                    }
                });
            }

            @Override // com.haier.uhome.usdk.base.utils.e
            /* JADX INFO: renamed from: a */
            public void d(com.haier.uhome.usdk.base.api.c<String> cVar) {
                s.this.b(cVar, str, str2, traceNodeA, iBindCallback);
            }
        };
        this.f31734k = eVar;
        eVar.a();
    }

    public void a(final String str, final String str2, final long j7, final int i7, long j8, final TraceNode traceNode, final ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        final com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
        if (dVarE == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError());
            return;
        }
        final TraceNode traceNodeA = traceNode != null ? a(str, str2, traceNode) : null;
        RetryBindDeviceHandler.getSingleInstance().a(str).b(str2).a(j7).a(i7).a(traceNode).a(true);
        new com.haier.uhome.usdk.base.utils.e<String>(j8, 1000L) { // from class: com.haier.uhome.usdk.bind.s.1
            @Override // com.haier.uhome.usdk.base.utils.e
            public void a(long j9) {
                final com.haier.uhome.usdk.base.api.c cVar = new com.haier.uhome.usdk.base.api.c();
                if (j9 <= 0) {
                    cVar.a(ErrorConst.ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND.toError());
                    b(cVar);
                    return;
                }
                com.haier.uhome.control.cloud.api.d dVar = dVarE;
                String str3 = str;
                String str4 = str2;
                long j10 = j7;
                int i8 = i7;
                int iA = com.haier.uhome.usdk.base.utils.f.a(j9, 5000L);
                TraceNode traceNode2 = traceNode;
                dVar.a(str3, str4, j10, i8, iA, traceNode2 != null ? traceNode2.getTraceId() : "", new ICallback<String>() { // from class: com.haier.uhome.usdk.bind.s.1.1
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(String str5) {
                        cVar.a(ErrorConst.RET_USDK_OK.toError());
                        cVar.a(TraceProtocolConst.PRO_PROTOCOL, str5);
                        b(cVar);
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        cVar.a(s.this.a(usdkerror));
                        cVar.a(TraceProtocolConst.PRO_PROTOCOL, usdkerror.b(TraceProtocolConst.PRO_PROTOCOL));
                        if (usdkerror.getCode() == s.f31730l) {
                            a(usdkerror);
                        } else {
                            b(cVar);
                        }
                    }
                });
            }

            @Override // com.haier.uhome.usdk.base.utils.e
            /* JADX INFO: renamed from: a */
            public void d(com.haier.uhome.usdk.base.api.c<String> cVar) {
                s.this.a(cVar, str, str2, traceNodeA, (ICallback<com.haier.uhome.usdk.api.w>) iCallback);
            }
        }.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0055  */
    public void b(com.haier.uhome.usdk.base.api.c<String> cVar, String str, String str2, TraceNode traceNode, ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        uSDKError usdkerrorB = cVar.b();
        BindOnlineResult bindOnlineResult = new BindOnlineResult();
        try {
            com.haier.library.json.e eVarT = com.haier.library.json.a.t(cVar.c());
            com.haier.library.json.e eVarL0 = eVarT != null ? eVarT.L0(MessengerShareContentUtility.ATTACHMENT_PAYLOAD) : null;
            if (eVarL0 != null) {
                bindOnlineResult = (BindOnlineResult) com.haier.library.json.a.z(eVarL0.toString(), BindOnlineResult.class);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        Integer num = -40000;
        if (usdkerrorB.getCode() != num.intValue()) {
            Integer num2 = -40004;
            if (usdkerrorB.getCode() == num2.intValue()) {
                usdkerrorB = ErrorConst.ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND.toError();
            }
        } else {
            usdkerrorB = ErrorConst.ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND.toError();
        }
        com.haier.uhome.trace.api.b.a().a("https://" + com.haier.uhome.usdk.base.service.e.a().d() + Const.DCS_BINDING, cVar.b().getCode(), bindOnlineResult.getDeviceId(), bindOnlineResult.getUplusId(), bindOnlineResult.getOnLine(), bindOnlineResult.getBts(), traceNode);
        StringBuilder sb = new StringBuilder();
        sb.append("PhoneBindingImpl bindDeviceOnlineFinish error = ");
        sb.append(usdkerrorB.toString());
        e3.a.e(sb.toString(), new Object[0]);
        if (usdkerrorB.a(ErrorConst.RET_USDK_OK)) {
            uSDKDevice usdkdeviceA = uSDKDeviceManager.getSingleInstance().a(str, str2, uSDKDeviceNetTypeConst.NET_REMOTE);
            com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
            wVar.a(usdkdeviceA);
            wVar.a(com.haier.uhome.usdk.base.a.av);
            com.haier.uhome.usdk.base.utils.b.a(iCallback, wVar);
            return;
        }
        HashMap<String, String> map = new HashMap<>(1);
        map.put(TraceProtocolConst.PRO_PROTOCOL, com.haier.uhome.usdk.base.a.av);
        usdkerrorB.a(map);
        com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.haier.uhome.usdk.base.api.c<String> cVar, String str, String str2, TraceNode traceNode, ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        uSDKError usdkerrorB = cVar.b();
        String str3 = (String) cVar.a(TraceProtocolConst.PRO_PROTOCOL);
        if (traceNode != null) {
            a(cVar.b().getCode(), str, str3, traceNode);
        }
        e3.a.e("PhoneBindingImpl bindCallFinish error = " + usdkerrorB.toString() + " prot = " + str3, new Object[0]);
        if (!usdkerrorB.a(ErrorConst.RET_USDK_OK) && usdkerrorB.getCode() != 1900005) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorB);
            return;
        }
        uSDKDevice usdkdeviceA = uSDKDeviceManager.getSingleInstance().a(str, str2, uSDKDeviceNetTypeConst.NET_REMOTE);
        com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
        wVar.a(usdkdeviceA);
        wVar.a(str3);
        com.haier.uhome.usdk.base.utils.b.a(iCallback, wVar);
    }

    public void a(final uSDKDevice usdkdevice, final long j7, final TraceNode traceNode, final ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        if (usdkdevice == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        } else {
            a(usdkdevice, com.haier.uhome.usdk.base.service.e.a().g(), ((int) (j7 - System.currentTimeMillis())) / 1000, traceNode, new ICallback<String>() { // from class: com.haier.uhome.usdk.bind.s.7
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(String str) {
                    s.this.a(usdkdevice.getDeviceId(), usdkdevice.getUplusId(), "", str, j7, traceNode, iCallback);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            });
        }
    }

    public void a(final String str, final String str2, final String str3, final String str4, final long j7, final TraceNode traceNode, final ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        new com.haier.library.common.thread.m<Void, Void, Void>() { // from class: com.haier.uhome.usdk.bind.s.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void doInBackground(Void... voidArr) {
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                    s.this.a(iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
                    return null;
                }
                uSDKError usdkerrorA = s.this.a(str, str3, str4, j7, traceNode);
                if (!usdkerrorA.a(ErrorConst.RET_USDK_OK.toError())) {
                    HashMap<String, String> map = new HashMap<>(1);
                    map.put(TraceProtocolConst.PRO_PROTOCOL, com.haier.uhome.usdk.base.a.av);
                    usdkerrorA.a(map);
                    s.this.a(iCallback, usdkerrorA);
                    return null;
                }
                uSDKDevice usdkdeviceA = uSDKDeviceManager.getSingleInstance().a(str, str2, uSDKDeviceNetTypeConst.NET_REMOTE);
                com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
                wVar.a(usdkdeviceA);
                wVar.a(com.haier.uhome.usdk.base.a.av);
                s.this.a((ICallback<com.haier.uhome.usdk.api.w>) iCallback, wVar);
                return null;
            }
        }.execute(new Void[0]);
    }

    public uSDKError a(String str, String str2, String str3, long j7, TraceNode traceNode) {
        String upperCase = TextUtils.isEmpty(str) ? "" : str.toUpperCase();
        this.f31732g.remove(upperCase);
        uSDKError error = ErrorConst.ERR_USDK_TIMEOUT.toError();
        TraceNode traceNode2 = traceNode;
        while (true) {
            long jCurrentTimeMillis = j7 - System.currentTimeMillis();
            if (jCurrentTimeMillis < 0) {
                if (error.a(ErrorConst.ERR_USDK_TIMEOUT)) {
                    error = ErrorConst.ERR_USDK_BIND_DEVICE_TIMEOUT.toError();
                }
                e3.a.e("retryBindDevice timeout", new Object[0]);
                break;
            }
            if (this.f31732g.remove(upperCase)) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "bindDevice receive bind msg", new Object[0]);
                error = ErrorConst.RET_USDK_OK.toError();
                e3.a.e("retryBindDevice received onBind message", new Object[0]);
                break;
            }
            TraceNode traceNodeB = com.haier.uhome.trace.api.b.a().b(upperCase, "https://" + com.haier.uhome.usdk.base.service.e.a().d() + "/uds/v1/protected/bindDevice", traceNode2);
            error = a(upperCase, str2, str3, j7, traceNodeB.getTraceId(), traceNodeB.getSpanId());
            com.haier.uhome.trace.api.b.a().b(error.getCode(), upperCase, "https://" + com.haier.uhome.usdk.base.service.e.a().d() + "/uds/v1/protected/bindDevice", traceNodeB);
            e3.a.e("retryBindDevice ... remainTime %d result %s", Long.valueOf(jCurrentTimeMillis), error.toString());
            if (error.a(uSDKErrorConst.RET_USDK_OK)) {
                e3.a.e("retryBindDevice return 0", new Object[0]);
                break;
            }
            if (!b(error.getDescription())) {
                e3.a.e("retryBindDevice no need try again", new Object[0]);
                break;
            }
            if (a().a(upperCase)) {
                error = ErrorConst.ERR_USDK_BIND_DEVICE_IS_CANCELED.toError();
                e3.a.e("retryBindDevice be canceled", new Object[0]);
                break;
            }
            if (jCurrentTimeMillis > 0) {
                if (jCurrentTimeMillis >= 1000) {
                    jCurrentTimeMillis = 1000;
                }
                SystemClock.sleep(jCurrentTimeMillis);
            }
            traceNode2 = traceNodeB;
        }
        Integer num = -40000;
        if (error.getCode() != num.intValue()) {
            Integer num2 = -40004;
            if (error.getCode() != num2.intValue()) {
                return error;
            }
        }
        return ErrorConst.ERR_USDK_BIND_DEVICE_TIMEOUT.toError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError b(RespCommonModel respCommonModel) {
        uSDKError error = ErrorConst.ERR_USDK_BIND_CODE_FAILED.toError();
        error.setDescription(respCommonModel.getRetCode());
        error.a(respCommonModel.getRetInfo());
        return error;
    }

    private uSDKError a(final String str, final String str2, final String str3, long j7, final String str4, final String str5) {
        long jCurrentTimeMillis = j7 - System.currentTimeMillis();
        e3.a.e("bindDevice remainTime<%d>", Long.valueOf(jCurrentTimeMillis));
        if (jCurrentTimeMillis <= 0) {
            return ErrorConst.ERR_USDK_BIND_DEVICE_TIMEOUT.toError();
        }
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        final ICallback<String> iCallback = new ICallback<String>() { // from class: com.haier.uhome.usdk.bind.s.9
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(String str6) {
                gVar.a(ErrorConst.RET_USDK_OK.toError());
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "bindDevice onBindCallback error  = %s", usdkerror);
                gVar.a(usdkerror);
            }
        };
        ErrorConst errorConst = ErrorConst.ERR_USDK_TIMEOUT;
        uSDKError error = errorConst.toError();
        error.setDescription(String.valueOf(errorConst.toError().getCode()));
        Runnable runnable = new Runnable() { // from class: com.haier.uhome.usdk.bind.i1
            @Override // java.lang.Runnable
            public final void run() {
                this.f31591a.a(str, str2, str3, str4, str5, iCallback);
            }
        };
        if (jCurrentTimeMillis >= 15000) {
            jCurrentTimeMillis = 15200;
        }
        return (uSDKError) gVar.b(runnable, error, jCurrentTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, String str3, String str4, String str5, ICallback iCallback) {
        a(str, str2, str3, com.haier.uhome.usdk.base.service.e.a().g(), str4, str5, (ICallback<String>) iCallback);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, final ICallback<String> iCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            String str7 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + "/uds/v1/protected/bindDevice";
            CustomReqInfo customReqInfo = new CustomReqInfo();
            customReqInfo.setUrl(str7);
            customReqInfo.setBody(a(str, str2, str3));
            customReqInfo.setRequestType(HttpRequestType.POST);
            customReqInfo.setHttps(true);
            customReqInfo.setTimeout(15L);
            customReqInfo.setToken(str4);
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                HashMap map = new HashMap(2);
                map.put(TraceProtocolConst.PRO_TRACE_ID, str5);
                map.put(TraceProtocolConst.PRO_SPAN_ID, str6);
                customReqInfo.setHeaders(map);
            }
            uAccount.getSingleInstance().sendCustomRequest(com.haier.uhome.usdk.base.service.e.a().b(), customReqInfo, new IAccountListener<String>() { // from class: com.haier.uhome.usdk.bind.s.10
                @Override // com.haier.uhome.account.api.interfaces.IAccountListener
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResponseSuccess(String str8) {
                    e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "binddevice sucess", new Object[0]);
                    s.this.a((ICallback<String>) iCallback, str8);
                }

                @Override // com.haier.uhome.account.api.interfaces.IAccountListener
                public void onHttpError(RespCommonModel respCommonModel) {
                    s.this.a(iCallback, s.this.a(respCommonModel));
                    e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "binddevice onHttpError <%s>", respCommonModel.toString());
                }

                @Override // com.haier.uhome.account.api.interfaces.IAccountListener
                public void onResponseFailed(RespCommonModel respCommonModel) {
                    s.this.a(iCallback, s.this.a(respCommonModel));
                    e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "binddevice  onResponseFailed<%s>", respCommonModel.toString());
                }
            });
            return;
        }
        a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
    }

    public void a(final String str, int i7, String str2, final IuSDKResultCallback<String> iuSDKResultCallback) {
        if (TextUtils.isEmpty(str)) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.bind.g1
                @Override // java.lang.Runnable
                public final void run() {
                    s.a(iuSDKResultCallback, str);
                }
            });
        }
        String str3 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + "/uds/v1/protected/{deviceId}/unbindDevice".replace("{deviceId}", str);
        CustomReqInfo customReqInfo = new CustomReqInfo();
        customReqInfo.setUrl(str3);
        customReqInfo.setHttps(true);
        customReqInfo.setRequestType(HttpRequestType.POST);
        customReqInfo.setBody(e());
        customReqInfo.setTimeout(i7);
        customReqInfo.setToken(str2);
        this.f31733h.remove(str);
        uAccount.getSingleInstance().sendCustomRequest(com.haier.uhome.usdk.base.service.e.a().b(), customReqInfo, new AnonymousClass11(iuSDKResultCallback, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IuSDKResultCallback iuSDKResultCallback, String str) {
        if (iuSDKResultCallback != null) {
            iuSDKResultCallback.onFail(uSDKErrorConst.ERR_USDK_INVALID_PARAM);
            e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "unbindDevice device is empty <%s>", str);
        }
    }

    private Map<String, Object> a(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put(com.haier.globalwasher.presenter.o.f25218y, str);
        if (str2 == null) {
            str2 = str + "";
        }
        map.put("name", str2);
        map.put("data", str3);
        return map;
    }

    public void a(final uSDKDevice usdkdevice, final String str, final int i7, TraceNode traceNode, final ICallback<String> iCallback) {
        final TraceNode traceNodeA = com.haier.uhome.trace.api.b.a().a(usdkdevice.getDeviceId(), usdkdevice.getSecurityVersion(), str, i7, traceNode);
        new com.haier.library.common.thread.m<Void, Void, com.haier.uhome.usdk.base.api.c<String>>() { // from class: com.haier.uhome.usdk.bind.s.13
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.haier.uhome.usdk.base.api.c<String> doInBackground(Void... voidArr) {
                return usdkdevice.retryGetDeviceBindInfo(str, i7, traceNodeA);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(com.haier.uhome.usdk.base.api.c<String> cVar) {
                com.haier.uhome.trace.api.b.a().a(cVar.b().getCode(), usdkdevice.getDeviceId(), usdkdevice.getSecurityVersion(), cVar.c(), traceNodeA);
                if (iCallback == null) {
                    e3.a.v("getDeviceBindInfoWithToken is null,so give up this callback.", new Object[0]);
                    return;
                }
                uSDKError usdkerrorB = cVar.b();
                if (usdkerrorB.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<String>) iCallback, cVar.c());
                } else {
                    s.this.a(iCallback, usdkerrorB);
                }
            }
        }.execute(new Void[0]);
    }

    public void a(final String str, final String str2, final int i7, final ICallback<Void> iCallback) {
        new com.haier.library.common.thread.m<Void, Void, uSDKError>() { // from class: com.haier.uhome.usdk.bind.s.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKError doInBackground(Void... voidArr) {
                return s.this.a(str, str2, i7);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(uSDKError usdkerror) {
                if (usdkerror.a(ErrorConst.RET_USDK_OK)) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError a(String str, String str2, int i7) {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (uSDKState.STATE_STARTED != uSDKManager.getSingleInstance().getSDKState()) {
            return ErrorConst.ERR_USDK_UNSTARTED.toError();
        }
        if (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g())) {
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
        }
        StringBuilder sb = new StringBuilder();
        if (!f31728i.equals(str) || !f31729j.equals(str2)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter appId<%s> or appKey<%s> is invalid!", str, str2);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append("appid=");
            sb.append(str);
            sb.append(", appkey=");
            sb.append(str2);
        }
        if (i7 < 5 || i7 > 120) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter timeout :" + i7, new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(", timeout=");
            sb.append(i7);
        }
        if (error.a(ErrorConst.ERR_USDK_INVALID_PARAM)) {
            error.a(sb.toString().replaceFirst(",", ""));
            return error;
        }
        final com.haier.library.common.thread.g gVar = new com.haier.library.common.thread.g();
        return (uSDKError) gVar.b(new Runnable() { // from class: com.haier.uhome.usdk.bind.h1
            @Override // java.lang.Runnable
            public final void run() {
                this.f31586a.a(gVar);
            }
        }, ErrorConst.ERR_USDK_TIMEOUT.toError(), i7 * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.haier.library.common.thread.g gVar) {
        com.haier.uhome.control.cloud.service.c.l().a((Trace) null, new ICallback<Void>() { // from class: com.haier.uhome.usdk.bind.s.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                gVar.a(ErrorConst.RET_USDK_OK.toError());
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                gVar.a(usdkerror);
            }
        });
    }

    private TraceNode a(String str, String str2, TraceNode traceNode) {
        return com.haier.uhome.trace.api.b.a().a(str, str2, traceNode);
    }

    private TraceNode a(int i7, String str, String str2, TraceNode traceNode) {
        return com.haier.uhome.trace.api.b.a().a(i7, str, str2, traceNode);
    }

    public boolean a(String str) {
        AtomicBoolean atomicBoolean = this.f31731f.get(str);
        return atomicBoolean != null && atomicBoolean.get();
    }

    protected <T> void a(ICallback<T> iCallback, uSDKError usdkerror) {
        if (iCallback == null) {
            e3.a.o(String.format("bindDevice error = %s ,but callback is null", usdkerror), new Object[0]);
        } else {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerror);
        }
    }

    protected <T> void a(ICallback<T> iCallback, T t7) {
        if (iCallback == null) {
            e3.a.o(String.format("bindDevice success = %s ,but callback is null", t7 + ""), new Object[0]);
            return;
        }
        com.haier.uhome.usdk.base.utils.b.a(iCallback, t7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError a(uSDKError usdkerror) {
        if (usdkerror.a(ErrorConst.ERR_USDK_TIMEOUT) || -25001 == usdkerror.getCode() || -25071 == usdkerror.getCode() || -40000 == usdkerror.getCode() || -40004 == usdkerror.getCode()) {
            ErrorConst errorConst = ErrorConst.ERR_USDK_BIND_TIMEOUT_NEED_RETRY_BIND;
            usdkerror.setCode(errorConst.toError().getCode());
            usdkerror.setDescription(errorConst.toError().getDescription());
        }
        return usdkerror;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public uSDKError a(RespCommonModel respCommonModel) {
        uSDKError error = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
        if (!respCommonModel.getRetCode().equals(String.valueOf(-40000)) && !respCommonModel.getRetCode().equals(String.valueOf(-40004))) {
            error.setDescription(respCommonModel.getRetCode());
            error.a(respCommonModel.getRetInfo());
        } else {
            error.setCode(Integer.parseInt(respCommonModel.getRetCode()));
            error.setDescription(respCommonModel.getRetCode());
            error.a(respCommonModel.getRetInfo());
        }
        return error;
    }

    public void a(String str, String str2, String str3, long j7, int i7, boolean z7, long j8, TraceNode traceNode, IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        if (uSDKDeviceManager.getSingleInstance().e() == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError());
        } else if (TextUtils.isEmpty(str)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        } else {
            b(str, str2, str3, j7, i7, z7, j8, traceNode, iBindCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, long j7, boolean z7, String str4, final ICallback<String> iCallback) {
        String str5 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + Const.DCS_BINDING;
        CustomReqInfo customReqInfo = new CustomReqInfo();
        customReqInfo.setUrl(str5);
        customReqInfo.setRequestType(HttpRequestType.POST);
        customReqInfo.setHttps(true);
        customReqInfo.setTimeout(15L);
        customReqInfo.setToken(com.haier.uhome.usdk.base.service.e.a().g());
        customReqInfo.setNotFixResult(false);
        HashMap map = new HashMap();
        map.put("securityCheck", z7 ? "1" : "0");
        map.put(TraceProtocolConst.PRO_TRACE_ID, str4);
        customReqInfo.setHeaders(map);
        HashMap map2 = new HashMap();
        map2.put(com.haier.globalwasher.presenter.o.f25218y, str);
        map2.put("deviceName", str3);
        map2.put("bindCode", Long.valueOf(j7));
        map2.put("upid", str2);
        customReqInfo.setBody(map2);
        uAccount.getSingleInstance().sendCustomRequest(com.haier.uhome.usdk.base.service.e.a().b(), customReqInfo, new IAccountListener<String>() { // from class: com.haier.uhome.usdk.bind.s.4
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str6) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback<String>) iCallback, str6);
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "bindCloudDeviceOnce response<%s> sucess", str6);
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onHttpError(RespCommonModel respCommonModel) {
                com.haier.uhome.usdk.base.utils.b.a(iCallback, s.this.a(respCommonModel));
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "bindCloudDeviceOnce onHttpError <%s>", respCommonModel.toString());
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onResponseFailed(RespCommonModel respCommonModel) {
                com.haier.uhome.usdk.base.utils.b.a(iCallback, s.this.a(respCommonModel));
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "bindCloudDeviceOnce  onResponseFailed<%s>", respCommonModel.toString());
            }
        });
    }

    public void a(long j7, final String str, final String str2, final ICallback<BindCodeInfo> iCallback) {
        if (uSDKDeviceManager.getSingleInstance().e() == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError());
        } else if (TextUtils.isEmpty(str)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        } else {
            new com.haier.uhome.usdk.base.utils.e<BindCodeInfo>(j7, 1000L) { // from class: com.haier.uhome.usdk.bind.s.5
                @Override // com.haier.uhome.usdk.base.utils.e
                public void a(long j8) {
                    final com.haier.uhome.usdk.base.api.c cVar = new com.haier.uhome.usdk.base.api.c();
                    cVar.a(ErrorConst.ERR_USDK_BIND_CODE_FAILED.toError());
                    s.this.a(str, str2, new ICallback<BindCodeInfo>() { // from class: com.haier.uhome.usdk.bind.s.5.1
                        @Override // com.haier.uhome.usdk.base.api.ICallback
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onSuccess(BindCodeInfo bindCodeInfo) {
                            cVar.a(ErrorConst.RET_USDK_OK.toError());
                            cVar.a(bindCodeInfo);
                            b(cVar);
                        }

                        @Override // com.haier.uhome.usdk.base.api.ICallback
                        public void onFailure(uSDKError usdkerror) {
                            cVar.a(usdkerror);
                            b(cVar);
                        }
                    });
                }

                @Override // com.haier.uhome.usdk.base.utils.e
                /* JADX INFO: renamed from: a */
                public void d(com.haier.uhome.usdk.base.api.c<BindCodeInfo> cVar) {
                    if (ErrorConst.RET_USDK_OK.toError().a(cVar.b())) {
                        com.haier.uhome.usdk.base.utils.b.a((ICallback<BindCodeInfo>) iCallback, cVar.c());
                    } else {
                        com.haier.uhome.usdk.base.utils.b.a(iCallback, cVar.b());
                    }
                }
            }.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, final ICallback<BindCodeInfo> iCallback) {
        String str3 = "https://" + com.haier.uhome.usdk.base.service.e.a().d() + Const.DCS_BINDCODE;
        CustomReqInfo customReqInfo = new CustomReqInfo();
        customReqInfo.setUrl(str3);
        customReqInfo.setRequestType(HttpRequestType.POST);
        customReqInfo.setHttps(true);
        customReqInfo.setTimeout(15L);
        customReqInfo.setNotFixResult(false);
        HashMap map = new HashMap();
        map.put("accessToken", com.haier.uhome.usdk.base.service.e.a().g());
        map.put("apiVersion", "v1");
        map.put(TraceProtocolConst.PRO_TRACE_ID, str2);
        customReqInfo.setHeaders(map);
        HashMap map2 = new HashMap();
        map2.put("md5pwd", str);
        customReqInfo.setBody(map2);
        uAccount.getSingleInstance().sendCustomRequest(com.haier.uhome.usdk.base.service.e.a().b(), customReqInfo, new IAccountListener<String>() { // from class: com.haier.uhome.usdk.bind.s.6
            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResponseSuccess(String str4) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "getBindCodeOnceByHttp response<%s> success", str4);
                BindCodeInfo bindCodeInfo = new BindCodeInfo();
                try {
                    com.haier.library.json.e eVarT = com.haier.library.json.a.t(str4);
                    com.haier.library.json.e eVarL0 = eVarT != null ? eVarT.L0(MessengerShareContentUtility.ATTACHMENT_PAYLOAD) : null;
                    if (eVarL0 != null) {
                        bindCodeInfo = (BindCodeInfo) com.haier.library.json.a.z(eVarL0.toString(), BindCodeInfo.class);
                    }
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<BindCodeInfo>) iCallback, bindCodeInfo);
                } catch (Exception e8) {
                    e8.printStackTrace();
                    uSDKError error = ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError();
                    error.a(e8.getMessage());
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, error);
                }
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onHttpError(RespCommonModel respCommonModel) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "getBindCodeOnceByHttp onHttpError <%s>", respCommonModel.toString());
                com.haier.uhome.usdk.base.utils.b.a(iCallback, s.this.b(respCommonModel));
            }

            @Override // com.haier.uhome.account.api.interfaces.IAccountListener
            public void onResponseFailed(RespCommonModel respCommonModel) {
                e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.f28377J, "getBindCodeOnceByHttp  onResponseFailed<%s>", respCommonModel.toString());
                com.haier.uhome.usdk.base.utils.b.a(iCallback, s.this.b(respCommonModel));
            }
        });
    }
}
