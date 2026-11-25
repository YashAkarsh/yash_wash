package com.haier.uhome.usdk.bind;

import android.text.TextUtils;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.service.SDKBaseNative;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class y extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f31895a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SmartLinkBindInfo f31896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.c<com.haier.uhome.usdk.api.w> f31897c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TraceNode f31898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private BindCodeInfo f31899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f31900h;

    /* JADX INFO: Access modifiers changed from: private */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f31916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f31917b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f31918c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f31919d;

        private boolean b(String str) {
            if (TextUtils.isEmpty(this.f31919d)) {
                return false;
            }
            if (TextUtils.isEmpty(str)) {
                e3.a.e("ConfigSeed. deviceId is empty!", new Object[0]);
                return false;
            }
            if (str.toUpperCase().endsWith(this.f31919d.toUpperCase())) {
                e3.a.e("ConfigSeed. matched search!", new Object[0]);
                return true;
            }
            e3.a.e("ConfigSeed. deviceId Mismatch!", new Object[0]);
            return false;
        }

        private a(String str, List<String> list, int i7) {
            a(str);
            a(list);
            this.f31918c = i7;
        }

        public void a(String str) {
            if (str == null) {
                return;
            }
            this.f31916a = str.toUpperCase();
        }

        public void a(List<String> list) {
            if (list == null) {
                return;
            }
            this.f31917b = new ArrayList(list.size());
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    this.f31917b.add(str.toUpperCase());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(String str, String str2, int i7) {
            boolean z7;
            int i8 = ((i7 & 255) << 8) + ((65280 & i7) >> 8);
            int i9 = this.f31918c;
            if (i9 != i8 && i9 != i7 && i7 != 0) {
                e3.a.e("ConfigSeed ackSeedId Mismatch!", new Object[0]);
                return false;
            }
            if (!TextUtils.isEmpty(this.f31916a)) {
                if (TextUtils.isEmpty(str)) {
                    e3.a.e("ConfigSeed. ackDeviceId is empty!", new Object[0]);
                    return false;
                }
                if (!str.toUpperCase().endsWith(this.f31916a)) {
                    e3.a.e("ConfigSeed. ackDeviceId Mismatch!", new Object[0]);
                    return false;
                }
            }
            if (!com.haier.library.common.util.u.h(this.f31917b)) {
                if (TextUtils.isEmpty(str2)) {
                    e3.a.e("ConfigSeed. ackUplusId is empty!", new Object[0]);
                    return false;
                }
                Iterator<String> it = this.f31917b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z7 = false;
                        break;
                    }
                    if (it.next().equalsIgnoreCase(str2)) {
                        e3.a.e("ConfigSeed. UplusId matched!", new Object[0]);
                        z7 = true;
                        break;
                    }
                }
                if (!z7) {
                    return false;
                }
            }
            this.f31919d = str;
            e3.a.e("ConfigSeed. matched ack!", new Object[0]);
            return true;
        }
    }

    public y(SmartLinkBindInfo smartLinkBindInfo) {
        super(smartLinkBindInfo);
        a(false);
        b(false);
        this.f31896b = smartLinkBindInfo;
        this.f31900h = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void g(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        this.f31897c = null;
        int iNextInt = new SecureRandom().nextInt() & 65535;
        if (this.f31900h) {
            BindCodeInfo bindCodeInfo = this.f31899g;
            if (bindCodeInfo == null) {
                e3.a.h("SmartlinkBind bindCodeInfo is null!", new Object[0]);
                iBindCallback.onFailure(ErrorConst.ERR_USDK_BIND_CODE_FAILED.toError());
                return;
            } else {
                iNextInt = bindCodeInfo.getSeed() & 65535;
                a(this.f31899g.getTraceIdB());
            }
        } else {
            a(b(iNextInt));
        }
        final a aVar = new a(this.f31896b.getDeviceId(), this.f31896b.getUplusIdList(), iNextInt);
        a(aVar, new com.haier.uhome.usdk.bind.a<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.y.1
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                com.haier.uhome.usdk.base.utils.b.a(iBindCallback, wVar);
                if (y.this.f31900h) {
                    y yVar = y.this;
                    yVar.a(yVar.f31898f, y.this.f31899g != null ? y.this.f31899g.getTraceIdB() : "");
                } else {
                    y yVar2 = y.this;
                    yVar2.a(yVar2.f31898f, y.this.b(aVar.f31918c));
                }
            }

            @Override // com.haier.uhome.usdk.bind.a, com.haier.uhome.usdk.bind.IBindResultCallback
            public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                IBindCallback iBindCallback2 = iBindCallback;
                if (iBindCallback2 != null) {
                    iBindCallback2.notifyProgress(bindProgress, str, str2);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, usdkerror);
                if (y.this.f31900h) {
                    y yVar = y.this;
                    yVar.a(yVar.f31898f, y.this.f31899g != null ? y.this.f31899g.getTraceIdB() : "");
                } else {
                    y yVar2 = y.this;
                    yVar2.a(yVar2.f31898f, y.this.b(aVar.f31918c));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        return System.currentTimeMillis() >= x();
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void h() {
        com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
        if (dVarE == null || this.f31899g == null) {
            return;
        }
        dVarE.a(r(), this.f31899g.getBindCode(), 1, 5, t(), null);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void i() {
        a(this.f31896b == null ? com.haier.uhome.trace.api.b.a().a((TraceNode) null) : com.haier.uhome.trace.api.b.a().a(this.f31896b.getSsid(), this.f31896b.getBssid(), this.f31896b.getPassword(), this.f31896b.getDeviceId(), this.f31896b.isSecurity(), this.f31896b.getUplusIdList(), this.f31896b.getTimeout(), this.f31896b.getAppCsNode()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.haier.uhome.config.a.c.a().b();
        com.haier.uhome.search.a.n.a().f();
    }

    @Override // com.haier.uhome.usdk.bind.k
    public void b(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        if (!this.f31900h) {
            c(((long) (this.f31896b.getTimeout() * 1000)) + System.currentTimeMillis());
        }
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.u1
            @Override // java.lang.Runnable
            public final void run() {
                this.f31831a.g(iBindCallback);
            }
        });
    }

    public void c(boolean z7) {
        this.f31900h = z7;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        uSDKError error = ErrorConst.RET_USDK_OK.toError();
        if (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g())) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "token is null", new Object[0]);
            return ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError();
        }
        SmartLinkBindInfo smartLinkBindInfo = this.f31896b;
        if (smartLinkBindInfo == null) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter uSDKSoftApConfigInfo is null", new Object[0]);
            uSDKError error2 = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error2.a("bindInfo=null");
            return error2;
        }
        String password = smartLinkBindInfo.getPassword();
        if (k.d(password)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter password : " + password, new Object[0]);
            uSDKError error3 = ErrorConst.ERR_USDK_PASSWORD_LENGTH_INVALID.toError();
            error3.a("password=" + password);
            return error3;
        }
        StringBuilder sb = new StringBuilder();
        String ssid = this.f31896b.getSsid();
        if (!com.haier.uhome.usdk.base.utils.f.b(ssid)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter ssid : " + ssid, new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(",ssid=");
            sb.append(ssid);
        }
        if (this.f31896b.getTimeout() < 30 || this.f31896b.getTimeout() > 180) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter timeout :" + this.f31896b.getTimeout(), new Object[0]);
            error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            sb.append(",timeout=");
            sb.append(this.f31896b.getTimeout());
        }
        if (!com.haier.library.common.util.u.h(this.f31896b.getUplusIdList())) {
            for (String str : new ArrayList(this.f31896b.getUplusIdList())) {
                if (!TextUtils.isEmpty(str) && str.length() != 32 && str.length() != 64) {
                    error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
                    sb.append(",typeId=");
                    sb.append(str);
                    break;
                }
            }
        }
        if (!error.a(ErrorConst.ERR_USDK_INVALID_PARAM)) {
            return super.g();
        }
        error.a(sb.toString().replaceFirst(",", ""));
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(int i7) {
        String password = this.f31896b.getPassword();
        if (password == null) {
            password = "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i7);
        stringBuffer.append(password);
        return com.haier.library.common.util.a.i(stringBuffer.toString());
    }

    private synchronized void a(final a aVar, final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        String ssid = this.f31896b.getSsid();
        String bssid = this.f31896b.getBssid();
        String password = this.f31896b.getPassword();
        final String deviceId = this.f31896b.getDeviceId();
        ArrayList<String> uplusIdList = this.f31896b.getUplusIdList();
        boolean zIsSecurity = this.f31896b.isSecurity();
        int iCeil = (int) Math.ceil(e() / 1000.0d);
        final com.haier.uhome.usdk.base.api.c<com.haier.uhome.usdk.api.w> cVar = new com.haier.uhome.usdk.base.api.c<>();
        uSDKError usdkerrorA = com.haier.uhome.config.a.c.a().a(ssid, bssid, password, deviceId, uplusIdList, zIsSecurity, aVar.f31918c, iCeil);
        e3.a.e("send smart config info " + usdkerrorA, new Object[0]);
        if (!usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.config.a.c.a().b();
            cVar.a(usdkerrorA);
            this.f31897c = cVar;
            iBindCallback.onFailure(usdkerrorA);
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        cVar.a(TraceProtocolConst.PRO_USN, "" + aVar.f31918c);
        cVar.a(ErrorConst.ERR_USDK_TIMEOUT.toError());
        com.haier.uhome.search.a.n.a().a(new com.haier.library.common.thread.e() { // from class: com.haier.uhome.usdk.bind.r1
            @Override // com.haier.library.common.thread.e
            public final boolean isTimeout() {
                return this.f31722a.j();
            }
        }, new com.haier.uhome.search.a.a() { // from class: com.haier.uhome.usdk.bind.s1
            @Override // com.haier.uhome.search.a.a
            public final void onReceive(String str, int i7, String str2, int i8, int i9) {
                this.f31803a.a(aVar, iBindCallback, cVar, str, i7, str2, i8, i9);
            }
        }, new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.usdk.bind.t1
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                this.f31817a.a(cVar, iBindCallback, deviceId, jCurrentTimeMillis, aVar, usdkerror);
            }
        });
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected boolean f() {
        super.f();
        return f31895a.compareAndSet(false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, final IBindCallback iBindCallback, final com.haier.uhome.usdk.base.api.c cVar, String str, int i7, String str2, int i8, int i9) {
        e3.a.e("receive smlk ack info deviceId = %s seedId = %d uplusId = %s secVer = %d configMode = %d", str, Integer.valueOf(i7), str2, Integer.valueOf(i8), Integer.valueOf(i9));
        if (aVar.a(str, str2, i7)) {
            a(iBindCallback, BindProgress.BIND_DEVICE);
            k();
            a(str, str2);
            b(r());
            cVar.a(TraceProtocolConst.PRO_DEVICE_ID, str);
            cVar.a(TraceProtocolConst.PRO_CONFIG_SCM, Integer.valueOf(i9));
            if (this.f31900h) {
                com.haier.uhome.usdk.c.f.a().b();
                s sVarA = s.a();
                BindCodeInfo bindCodeInfo = this.f31899g;
                sVarA.a(str, str2, bindCodeInfo != null ? bindCodeInfo.getBindCode() : 0L, 1, e(), u(), new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.y.2
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                        if (wVar != null) {
                            cVar.a(ErrorConst.RET_USDK_OK.toError());
                            cVar.a(wVar);
                            y.this.f31897c = cVar;
                            iBindCallback.onSuccess(wVar);
                        }
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        cVar.a(usdkerror);
                        y.this.f31897c = cVar;
                        iBindCallback.onFailure(cVar.b());
                    }
                });
                return;
            }
            ErrorConst errorConst = ErrorConst.RET_USDK_OK;
            cVar.a(errorConst.toError());
            cVar.a(a(str, str2, uSDKDeviceNetTypeConst.NET_LOCAL));
            this.f31897c = cVar;
            if (cVar.b().a(errorConst) && cVar.c() != null) {
                iBindCallback.onSuccess(cVar.c());
            } else {
                a(this.f31898f, b(i7));
                iBindCallback.onFailure(cVar.b());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.haier.uhome.usdk.base.api.c cVar, final IBindCallback iBindCallback, String str, long j7, final a aVar, uSDKError usdkerror) {
        if (!usdkerror.a(ErrorConst.RET_USDK_OK)) {
            k();
            cVar.a(usdkerror);
            this.f31897c = cVar;
            iBindCallback.onFailure(cVar.b());
            return;
        }
        if (this.f31900h) {
            a(iBindCallback, str, cVar, j7);
        } else {
            new com.haier.uhome.usdk.a.a(new AtomicLong(x()), false) { // from class: com.haier.uhome.usdk.bind.y.3
                @Override // com.haier.uhome.usdk.a.a
                public void a() {
                    y.this.k();
                    y yVar = y.this;
                    yVar.a(yVar.f31898f, y.this.b(aVar.f31918c));
                    cVar.a(ErrorConst.ERR_USDK_NOT_RECV_ACK.toError());
                    y.this.f31897c = cVar;
                    iBindCallback.onFailure(cVar.b());
                }
            }.b();
        }
    }

    private void a(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback, String str, final com.haier.uhome.usdk.base.api.c<com.haier.uhome.usdk.api.w> cVar, long j7) {
        com.haier.uhome.usdk.c.f fVarA = com.haier.uhome.usdk.c.f.a();
        BindCodeInfo bindCodeInfo = this.f31899g;
        fVarA.a(str, bindCodeInfo != null ? bindCodeInfo.getBindCode() : 0L, 1, e(), u(), w(), j7, q(), new ICallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.y.4
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                y.this.k();
                if (wVar != null) {
                    cVar.a(ErrorConst.RET_USDK_OK.toError());
                    cVar.a(wVar);
                    y.this.f31897c = cVar;
                    iBindCallback.onSuccess(wVar);
                }
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                y.this.k();
                if (usdkerror != null && usdkerror.a(ErrorConst.ERR_USDK_DEVICE_LOCAL_NOT_EXIST_AND_GET_BIND_RESULT_TIMEOUT)) {
                    usdkerror = ErrorConst.ERR_USDK_NOT_RECV_ACK.toError();
                }
                cVar.a(usdkerror);
                y.this.f31897c = cVar;
                iBindCallback.onFailure(usdkerror);
            }
        });
    }

    private com.haier.uhome.usdk.api.w a(@c.m0 String str, String str2, uSDKDeviceNetTypeConst usdkdevicenettypeconst) {
        uSDKDevice usdkdeviceA = uSDKDeviceManager.getSingleInstance().a(str, str2, usdkdevicenettypeconst);
        if (usdkdeviceA == null) {
            return null;
        }
        com.haier.uhome.usdk.api.w wVar = new com.haier.uhome.usdk.api.w();
        wVar.a(usdkdeviceA);
        return wVar;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(com.haier.uhome.usdk.api.w wVar, ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        TraceNode traceNodeU = this.f31898f;
        s sVarA = s.a();
        String deviceId = wVar.a().getDeviceId();
        String uplusId = wVar.a().getUplusId();
        BindCodeInfo bindCodeInfo = this.f31899g;
        long bindCode = bindCodeInfo != null ? bindCodeInfo.getBindCode() : 0L;
        long jE = e();
        if (traceNodeU == null) {
            traceNodeU = u();
        }
        sVarA.a(deviceId, uplusId, bindCode, 1, jE, traceNodeU, iCallback);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(int i7) {
        super.a(i7);
        f31895a.set(false);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        a(iBindCallback, BindProgress.SEND_CONFIG_INFO);
        com.haier.library.json.e eVarT = com.haier.library.json.a.t(SDKBaseNative.genPasswdMd5(this.f31896b.getPassword()));
        if (eVarT == null) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, ErrorConst.ERR_INTERNAL.toError());
            e3.a.h("parseObject passwordMd5 error!", new Object[0]);
            return;
        }
        int iIntValue = eVarT.J0("errNo").intValue();
        if (iIntValue != 0) {
            e3.a.h("genPasswdMd5 error<%d>", Integer.valueOf(iIntValue));
            uSDKError usdkerror = new uSDKError();
            usdkerror.setCode(iIntValue);
            usdkerror.a("genPasswdMd5 error");
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, usdkerror);
            return;
        }
        s.a().a(e(), eVarT.R0("password"), t(), new ICallback<BindCodeInfo>() { // from class: com.haier.uhome.usdk.bind.y.5
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(BindCodeInfo bindCodeInfo) {
                y.this.f31899g = bindCodeInfo;
                y.this.b(iBindCallback);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror2) {
                y.this.f31899g = null;
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iBindCallback, usdkerror2);
            }
        });
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
        if (this.f31897c == null) {
            e3.a.h("fail to send bindDeviceBySmartLinkSS trace!!", new Object[0]);
            return;
        }
        String str = usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL);
        if (str == null || str.isEmpty()) {
            str = "local";
        }
        String str2 = str;
        com.haier.uhome.trace.api.b.a().a(usdkerror.getCode(), r(), this.f31897c.c() == null ? null : this.f31897c.c().a().getDeviceId(), u(), str2);
    }

    private TraceNode a(String str) {
        TraceNode traceNodeA = com.haier.uhome.trace.api.b.a().a(this.f31896b.getDeviceId(), this.f31896b.isSecurity(), u(), str);
        this.f31898f = traceNodeA;
        return traceNodeA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TraceNode traceNode, String str) {
        com.haier.uhome.usdk.base.api.c<com.haier.uhome.usdk.api.w> cVar = this.f31897c;
        if (cVar != null && traceNode != null) {
            try {
                com.haier.uhome.trace.api.b.a().a(cVar.b().getCode(), cVar.c() == null ? (String) cVar.a(TraceProtocolConst.PRO_DEVICE_ID) : cVar.c().a().getDeviceId(), cVar.c() == null ? -1 : cVar.c().a().getSecurityVersion(), String.valueOf(cVar.a(TraceProtocolConst.PRO_CONFIG_SCM)), String.valueOf(cVar.a(TraceProtocolConst.PRO_USN)), traceNode, str);
                return;
            } catch (Exception e8) {
                e3.a.h("smartLinkCR get excp : %s", e8.getMessage());
                return;
            }
        }
        e3.a.h("fail to send smartLinkCR trace!!", new Object[0]);
    }
}
