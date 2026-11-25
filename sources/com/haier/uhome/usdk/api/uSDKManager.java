package com.haier.uhome.usdk.api;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.haier.uhome.mesh.api.MeshNetworkManager;
import com.haier.uhome.nfc.service.HttpHelper;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKManagerListener;
import com.haier.uhome.usdk.base.annotation.Keep;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.r;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKManager {
    public static final int IDC_AREA_CHINA = 0;
    public static final int IDC_AREA_EUROPE = 2;
    public static final int IDC_AREA_NORTH_AMERICA = 1;
    public static final int IDC_AREA_SOUTHEAST_ASIA = 3;

    @Deprecated
    public static final int SDK_FEATURE_DEFAULT;
    public static final int SDK_FEATURE_NONE;
    public static final int SDK_FEATURE_SAFE_DNS;

    @Deprecated
    public static final int SDK_FEATURE_TRACE;

    @Deprecated
    public static final int SDK_FEATURE_TRACE_DNS;

    @Deprecated
    public static final int SDK_FEATURE_TRACE_NET_SITUATION;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f30925a = 5;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicReference<uSDKState> f30926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.haier.uhome.usdk.base.api.p f30927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f30928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IuSDKManagerListener f30929e;

    /* JADX INFO: renamed from: com.haier.uhome.usdk.api.uSDKManager$1, reason: invalid class name */
    class AnonymousClass1 extends com.haier.uhome.usdk.base.api.p {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(boolean z7) {
            if (!z7) {
                com.haier.uhome.search.service.f.c().b((ICallback<Void>) null);
            } else if (com.haier.library.common.util.w.a(com.haier.uhome.usdk.base.service.e.a().b()) == 1 || com.haier.library.common.util.w.l(com.haier.uhome.usdk.base.service.e.a().b())) {
                com.haier.uhome.search.service.f.c().a((ICallback<Void>) null);
            }
        }

        @Override // com.haier.uhome.usdk.base.api.p
        public void a(final boolean z7) {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.api.l6
                @Override // java.lang.Runnable
                public final void run() {
                    uSDKManager.AnonymousClass1.c(z7);
                }
            });
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static uSDKManager f30947a = new uSDKManager(null);

        private a() {
        }
    }

    static {
        int i7 = uSDKFeature.TRACE_DNS.mask;
        SDK_FEATURE_DEFAULT = i7;
        SDK_FEATURE_TRACE = uSDKFeature.TRACE.mask;
        SDK_FEATURE_TRACE_DNS = i7;
        SDK_FEATURE_TRACE_NET_SITUATION = uSDKFeature.TRACE_NET_SITUATION.mask;
        SDK_FEATURE_NONE = uSDKFeature.NONE.mask;
        SDK_FEATURE_SAFE_DNS = uSDKFeature.SAFE_DNS.mask;
    }

    /* synthetic */ uSDKManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized uSDKErrorConst e() {
        e3.a.e("stop sdk now!", new Object[0]);
        if (!getSingleInstance().a()) {
            e3.a.h("sdk is not start so stopSDK OK!!", new Object[0]);
            return uSDKErrorConst.RET_USDK_OK;
        }
        c.a().b();
        com.haier.library.common.util.w.f();
        com.haier.uhome.search.a.n nVarA = com.haier.uhome.search.a.n.a();
        int i7 = nVarA.b() ? 7 : 6;
        final CopyOnWriteArrayList<ErrorConst> copyOnWriteArrayList = new CopyOnWriteArrayList();
        final CountDownLatch countDownLatch = new CountDownLatch(i7);
        com.haier.uhome.usdk.base.api.o oVar = new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.i6
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                uSDKManager.a(copyOnWriteArrayList, countDownLatch, errorConst);
            }
        };
        ICallback<Void> iCallback = new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKManager.6
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                copyOnWriteArrayList.add(ErrorConst.RET_USDK_OK);
                countDownLatch.countDown();
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                copyOnWriteArrayList.add(ErrorConst.getErrorConstById(usdkerror.getCode()));
                countDownLatch.countDown();
            }
        };
        nVarA.d(iCallback);
        if (nVarA.b()) {
            nVarA.f(iCallback);
        }
        uSDKDeviceManager.getSingleInstance().disconnectToCloud(new com.haier.uhome.usdk.b.a(iCallback));
        com.haier.uhome.search.a.l.a().b(oVar);
        com.haier.uhome.config.a.c.a().b(oVar);
        com.haier.uhome.config.a.c.a().b();
        com.haier.uhome.config.a.c.a().d(oVar);
        MeshNetworkManager.getInstance().stopMeshModule(oVar);
        try {
            e3.a.e("stopSDK await count reached zero ? %s", Boolean.valueOf(countDownLatch.await(7L, TimeUnit.SECONDS)));
        } catch (InterruptedException e8) {
            e3.a.g("signalLatch get excp %s ", e8);
            Thread.currentThread().interrupt();
        }
        uSDKDeviceManager.getSingleInstance().g();
        if (copyOnWriteArrayList.size() < 5) {
            return uSDKErrorConst.ERR_USDK_TIMEOUT;
        }
        for (ErrorConst errorConst : copyOnWriteArrayList) {
            if (errorConst != ErrorConst.RET_USDK_OK) {
                return uSDKErrorConst.getErrorConst(errorConst);
            }
        }
        a(uSDKState.STATE_UNSTART);
        return uSDKErrorConst.RET_USDK_OK;
    }

    public static uSDKManager getSingleInstance() {
        return a.f30947a;
    }

    @Deprecated
    public void enableFeatures(int i7) {
        e3.a.v("call Deprecated fun<enableFeatures>，please use the \"startSDK(uSDKStartOptions options, ICallback<Void> callback)\" ", new Object[0]);
    }

    @Deprecated
    public String getClientId(Context context) {
        return getClientId();
    }

    public int getFeatures() {
        return this.f30928d;
    }

    public IuSDKManagerListener getManagerListener() {
        return this.f30929e;
    }

    public uSDKState getSDKState() {
        return this.f30926b.get();
    }

    public String getuReleaseDate() {
        return r.a().f();
    }

    public String getuSDKVersion() {
        return r.a().e() + "_" + r.a().f().substring(0, 10);
    }

    public uSDKErrorConst init(Context context) {
        if (!(context instanceof Application)) {
            e3.a.h("uSDK init error, the context is not application Context!", new Object[0]);
            return uSDKErrorConst.ERR_USDK_INVALID_PARAM;
        }
        if (!a(context)) {
            e3.a.v("uSDK init warn, startHotPatch false", new Object[0]);
        }
        e3.a.p(VersionManager.getInstance().getSDKTypeName(), 1, r.a().e());
        com.haier.uhome.usdk.base.service.e.a().a(context);
        com.haier.uhome.usdk.base.service.e.a().d(com.haier.library.common.util.v.b(context, "APP_ID"));
        com.haier.uhome.usdk.base.service.e.a().c(com.haier.library.common.util.v.b(context, "APP_KEY"));
        com.haier.library.common.util.f.r(context);
        e3.a.e("sdk start init,version is %s", getuSDKVersion());
        return uSDKErrorConst.getErrorConst(r.a().b());
    }

    public void initLog(uSDKLogLevelConst usdkloglevelconst, boolean z7, final IuSDKCallback iuSDKCallback) {
        if (usdkloglevelconst == null) {
            e3.a.h("InitLog error,level can not be null!", new Object[0]);
            com.haier.uhome.usdk.c.h.a(iuSDKCallback, uSDKErrorConst.ERR_USDK_INVALID_PARAM);
        } else if (!a()) {
            e3.a.h("InitLog error, sdk not started!", new Object[0]);
            com.haier.uhome.usdk.c.h.a(iuSDKCallback, uSDKErrorConst.ERR_USDK_UNSTARTED);
        } else {
            e3.a.e("InitLog to %s", usdkloglevelconst);
            e3.a.s(usdkloglevelconst.getLevelId());
            com.haier.uhome.usdk.base.service.d.p().a(usdkloglevelconst.getLevelId(), new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.k6
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    uSDKManager.a(iuSDKCallback, errorConst);
                }
            });
            MeshNetworkManager.getInstance().setLogLevel(usdkloglevelconst.getLevelId());
        }
    }

    @Keep
    public void setClientId(String str) {
        com.haier.uhome.usdk.base.service.e.a().g(str);
        a(str, false);
    }

    public void setManagerListener(IuSDKManagerListener iuSDKManagerListener) {
        e3.a.e("setManagerListener <%s>", iuSDKManagerListener);
        this.f30929e = iuSDKManagerListener;
    }

    @Deprecated
    public uSDKErrorConst setProfileServiceUrl(String str) {
        return uSDKErrorConst.getErrorConst(com.haier.uhome.usdk.base.service.e.a().h(str));
    }

    @Deprecated
    public void startSDK(IuSDKCallback iuSDKCallback) {
        startSDK(SDK_FEATURE_SAFE_DNS, iuSDKCallback);
    }

    public void stopSDK(final IuSDKCallback iuSDKCallback) {
        new com.haier.library.common.thread.m<Void, Void, uSDKErrorConst>() { // from class: com.haier.uhome.usdk.api.uSDKManager.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKErrorConst doInBackground(Void... voidArr) {
                return uSDKManager.this.e();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(uSDKErrorConst usdkerrorconst) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 != null) {
                    iuSDKCallback2.onCallback(usdkerrorconst);
                } else {
                    e3.a.o("stopSDK callback is null", new Object[0]);
                }
            }
        }.execute(new Void[0]);
    }

    private uSDKManager() {
        this.f30926b = new AtomicReference<>(uSDKState.STATE_UNSTART);
        VersionManager.getInstance().init(1, b.f30449i, b.f30450j, b.f30447g);
    }

    private void b() {
        if (this.f30927c == null) {
            this.f30927c = new AnonymousClass1();
        }
        r.a().a(this.f30927c);
    }

    private void c() {
        if (this.f30927c == null) {
            e3.a.h("unRegisterSystemListener with a null SystemListener object", new Object[0]);
        } else {
            r.a().b(this.f30927c);
        }
    }

    private void d() {
        a(uSDKState.STATE_STARTED);
        e3.a.e(String.format("uSDK start ok, version is %s, Release date is %s ClientId is %s", getuSDKVersion(), r.a().f(), com.haier.uhome.usdk.base.service.e.a().k()), new Object[0]);
    }

    public String getClientId() {
        return com.haier.uhome.usdk.base.service.e.a().l();
    }

    @Deprecated
    public void startSDK(int i7, final IuSDKCallback iuSDKCallback) {
        startSDK(new uSDKStartOptions.Builder().setArea(0).setFeatures(i7).build(), new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKManager.4
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 == null) {
                    return;
                }
                iuSDKCallback2.onCallback(uSDKErrorConst.RET_USDK_OK);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                IuSDKCallback iuSDKCallback2 = iuSDKCallback;
                if (iuSDKCallback2 == null) {
                    return;
                }
                iuSDKCallback2.onCallback(uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
            }
        });
    }

    private boolean a(Context context) {
        try {
            Class<?> cls = Class.forName("com.haier.uhome.usdk.hotpatch.HotPatch");
            cls.getMethod("start", Context.class).invoke(cls.newInstance(), context);
            return true;
        } catch (ClassNotFoundException e8) {
            e3.a.v("startHotPatch get ClassNotFoundException:%s", e8.getMessage());
            return false;
        } catch (IllegalAccessException e9) {
            e3.a.v("startHotPatch get IllegalAccessException:%s", e9.getMessage());
            return false;
        } catch (InstantiationException e10) {
            e3.a.v("startHotPatch get InstantiationException:%s", e10.getMessage());
            return false;
        } catch (NoSuchMethodException e11) {
            e3.a.v("startHotPatch get NoSuchMethodException:%s", e11.getMessage());
            return false;
        } catch (InvocationTargetException e12) {
            e3.a.v("startHotPatch get InvocationTargetException:%s", e12.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(List list, CountDownLatch countDownLatch, ErrorConst errorConst) {
        e3.a.e("start startModule : <%s> ", errorConst);
        list.add(errorConst);
        countDownLatch.countDown();
    }

    @Keep
    public void startSDK(final uSDKStartOptions usdkstartoptions, final ICallback<Void> iCallback) {
        if (usdkstartoptions == null) {
            e3.a.h("startSDK with null uSDKStartOptions", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (!com.haier.uhome.usdk.base.service.e.a().a(usdkstartoptions.a())) {
            e3.a.h("startSDK with illegal area", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (!a(usdkstartoptions.b())) {
            e3.a.h("feature not support", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_FEATURE_NOT_SUPPORT.toError());
            return;
        }
        if (!TextUtils.isEmpty(usdkstartoptions.c())) {
            com.haier.uhome.usdk.base.service.e.a().d(usdkstartoptions.c());
        }
        if (!TextUtils.isEmpty(usdkstartoptions.d())) {
            com.haier.uhome.usdk.base.service.e.a().c(usdkstartoptions.d());
        }
        e3.a.e("startSDK with options :" + usdkstartoptions, new Object[0]);
        new com.haier.library.common.thread.m<Void, Void, uSDKError>() { // from class: com.haier.uhome.usdk.api.uSDKManager.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKError doInBackground(Void... voidArr) {
                return uSDKManager.this.a(usdkstartoptions);
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

    private void b(uSDKState usdkstate) {
        if (usdkstate == uSDKState.STATE_STARTED) {
            b();
            com.haier.uhome.search.service.f.c().e();
        } else if (usdkstate == uSDKState.STATE_UNSTART) {
            c();
            com.haier.uhome.search.service.f.c().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized uSDKError a(uSDKStartOptions usdkstartoptions) {
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        if (contextB == null) {
            e3.a.h("uSDK start error, not call init", new Object[0]);
            return uSDKErrorConst.ERR_USDK_NOT_CALL_INIT.toError();
        }
        if (getSDKState() == uSDKState.STATE_STARTED) {
            return uSDKErrorConst.RET_USDK_OK.toError();
        }
        a(uSDKState.STATE_STARTING);
        com.haier.library.common.util.w.k(contextB);
        c.a().a(new d());
        uSDKError usdkerrorC = r.a().c();
        ErrorConst errorConst = ErrorConst.RET_USDK_OK;
        if (!usdkerrorC.a(errorConst)) {
            e3.a.h("init start server fail!!!", new Object[0]);
            return usdkerrorC;
        }
        final CopyOnWriteArrayList<ErrorConst> copyOnWriteArrayList = new CopyOnWriteArrayList();
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        com.haier.uhome.usdk.base.api.o oVar = new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.j6
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst2) {
                uSDKManager.b(copyOnWriteArrayList, countDownLatch, errorConst2);
            }
        };
        ICallback<Void> iCallback = new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKManager.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                e3.a.e("start startModule : <%s> ", uSDKErrorConst.RET_USDK_OK.toError());
                copyOnWriteArrayList.add(ErrorConst.RET_USDK_OK);
                countDownLatch.countDown();
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.e("start startModule : <%s> ", usdkerror);
                copyOnWriteArrayList.add(ErrorConst.getErrorConstById(usdkerror.getCode()));
                countDownLatch.countDown();
            }
        };
        ICallback<Void> iCallback2 = new ICallback<Void>() { // from class: com.haier.uhome.usdk.api.uSDKManager.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                e3.a.e("start search Module: <%s> ", uSDKErrorConst.RET_USDK_OK.toError());
                a();
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.e("start search Module: <%s> ", usdkerror);
                a();
            }

            private void a() {
                copyOnWriteArrayList.add(ErrorConst.RET_USDK_OK);
                countDownLatch.countDown();
            }
        };
        r.a().a(oVar);
        com.haier.uhome.search.a.l.a().a(oVar);
        com.haier.uhome.search.a.n.a().c(iCallback2);
        if (usdkstartoptions.e()) {
            com.haier.uhome.search.a.n.a().e(iCallback);
        } else {
            copyOnWriteArrayList.add(errorConst);
            countDownLatch.countDown();
        }
        com.haier.uhome.config.a.c.a().a(oVar);
        com.haier.uhome.config.a.c.a().f();
        uSDKDeviceManager.getSingleInstance();
        try {
            e3.a.e("tryStartSDK await count reached zero ? %s", Boolean.valueOf(countDownLatch.await(7L, TimeUnit.SECONDS)));
        } catch (InterruptedException e8) {
            e3.a.g("signalLatch get excp %s ", e8);
            Thread.currentThread().interrupt();
        }
        if (copyOnWriteArrayList.size() < 5) {
            e3.a.h("start usdk fail error ,errorConsts.size() =  " + copyOnWriteArrayList.size(), new Object[0]);
            uSDKErrorConst usdkerrorconst = uSDKErrorConst.ERR_USDK_TIMEOUT;
            a(usdkerrorconst);
            return usdkerrorconst.toError();
        }
        for (ErrorConst errorConst2 : copyOnWriteArrayList) {
            if (errorConst2 != ErrorConst.RET_USDK_OK) {
                e3.a.h("start usdk fail error : " + errorConst2.toString(), new Object[0]);
                uSDKErrorConst errorConst3 = uSDKErrorConst.getErrorConst(errorConst2);
                a(errorConst3);
                return errorConst3.toError();
            }
        }
        e3.a.e("start usdk success", new Object[0]);
        uSDKErrorConst usdkerrorconst2 = uSDKErrorConst.RET_USDK_OK;
        d();
        if (VersionManager.getInstance().isSmartDevice()) {
            uSDKDeviceManager.getSingleInstance().c();
        }
        return usdkerrorconst2.toError();
    }

    public boolean a() {
        return uSDKState.STATE_STARTED == getSDKState();
    }

    void a(String str, boolean z7) {
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            return;
        }
        DITraceNode dITraceNode = new DITraceNode("common", HttpHelper.a.f29520d, null, "00000", VersionManager.getInstance().getSDKVersion());
        HashMap map = new HashMap(1);
        map.put("user", Integer.valueOf(z7 ? 1 : 0));
        dITraceNode.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        dITraceNode.add(TraceProtocolConst.PRO_IPM, com.haier.library.json.a.Z(map));
        dITraceNode.add(TraceProtocolConst.PRO_TOKEN, com.haier.uhome.usdk.base.service.e.a().g());
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        dITraceNode.add("mdl", String.format("%s|%s", Build.BRAND, Build.MODEL));
        dITraceNode.add("mver", Build.VERSION.RELEASE);
        dITraceNode.add(HttpHelper.a.f29520d, str);
        StringBuilder sb = new StringBuilder();
        sb.append(z7 ? com.haier.library.common.util.f.b() : 5);
        sb.append("");
        dITraceNode.add(androidx.constraintlayout.core.motion.utils.w.h.f3145c, sb.toString());
        traceCreateDITrace.addDITraceNode(dITraceNode);
    }

    private void a(uSDKErrorConst usdkerrorconst) {
        a(uSDKState.STATE_UNSTART);
        e3.a.e("uSDK start failed, result is " + usdkerrorconst, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(List list, CountDownLatch countDownLatch, ErrorConst errorConst) {
        list.add(ErrorConst.RET_USDK_OK);
        countDownLatch.countDown();
    }

    protected void a(uSDKState usdkstate) {
        e3.a.e("setState to :" + usdkstate.name(), new Object[0]);
        this.f30926b.set(usdkstate);
        b(usdkstate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        com.haier.uhome.usdk.c.h.a(iuSDKCallback, uSDKErrorConst.getErrorConst(errorConst));
    }

    private boolean a(int i7) {
        e3.a.o("features set to " + i7, new Object[0]);
        int iC = com.haier.uhome.usdk.base.service.e.a().c();
        if (iC == 0) {
            this.f30928d = i7;
            com.haier.library.okhttp.a.b.a().d((this.f30928d & uSDKFeature.SAFE_DNS.mask) != 0);
            com.haier.uhome.trace.b.g.a().a(true);
            com.haier.uhome.trace.b.g.a().b(true);
            com.haier.uhome.usdk.b.b.a().a(true);
            com.haier.uhome.usdk.b.c.a().a(true);
        } else if (iC == 3) {
            this.f30928d = SDK_FEATURE_NONE;
            com.haier.library.okhttp.a.b.a().d(false);
            com.haier.uhome.trace.b.g.a().a(true);
            com.haier.uhome.trace.b.g.a().b(true);
            com.haier.uhome.usdk.b.b.a().a(false);
            com.haier.uhome.usdk.b.c.a().a(true);
        } else {
            int i8 = SDK_FEATURE_NONE;
            if (i7 != i8) {
                e3.a.v("not support any features out of china", new Object[0]);
                return false;
            }
            this.f30928d = i8;
            com.haier.library.okhttp.a.b.a().d(false);
            com.haier.uhome.trace.b.g.a().a(false);
            com.haier.uhome.trace.b.g.a().b(false);
            com.haier.uhome.usdk.b.b.a().a(false);
            com.haier.uhome.usdk.b.c.a().a(false);
        }
        return true;
    }
}
