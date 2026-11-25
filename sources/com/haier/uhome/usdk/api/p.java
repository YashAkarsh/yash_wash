package com.haier.uhome.usdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.haier.uhome.smart.api.SmartDevice;
import com.haier.uhome.smart.api.SmartDeviceManager;
import com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener;
import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30682a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f30683b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ISmartDeviceManagerListener f30684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, o> f30685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SmartDeviceManager f30686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.haier.uhome.usdk.api.interfaces.g f30687f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static p f30689a = new p();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (errorConst == ErrorConst.RET_USDK_OK) {
            this.f30685d.clear();
        }
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        e3.a.e("SmartDevice start callback <%d>,Version is <%s>,ReleaseData is <%s>", Integer.valueOf(errorConst.getErrorId()), r.a().e(), r.a().f());
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    @Deprecated
    public void b(final o oVar, final ICallback<String> iCallback) {
        this.f30686e.addSlaveDevice(a(oVar), new com.haier.uhome.usdk.base.api.i() { // from class: com.haier.uhome.usdk.api.g2
            @Override // com.haier.uhome.usdk.base.api.i
            public final void onCallback(com.haier.uhome.usdk.base.api.c cVar) {
                this.f30559a.b(oVar, iCallback, cVar);
            }
        });
    }

    private p() {
        this.f30684c = new ISmartDeviceManagerListener() { // from class: com.haier.uhome.usdk.api.p.1
            @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener
            public void onAuthToken(int i7, String str) {
                e3.a.e("USmartDeviceManager : onAuthToken %s : Listener %s", str, p.this.f30687f);
            }

            @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener
            public void onCloudState(int i7) {
                e3.a.e("USmartDeviceManager : onCloudState %d : Listener %s", Integer.valueOf(i7), p.this.f30687f);
                if (p.this.f30687f != null) {
                    p.this.f30687f.a(i7);
                }
            }

            @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener
            public void onDeviceAdd(String str) {
                e3.a.e("USmartDeviceManager : onDeviceAdd %s : Listener %s", str, p.this.f30687f);
                if (p.this.f30687f != null) {
                    p.this.f30687f.a(str);
                }
            }

            @Override // com.haier.uhome.smart.api.interfaces.ISmartDeviceManagerListener
            public void onDeviceRemove(String str) {
                e3.a.e("USmartDeviceManager : onDeviceRemove %s : Listener %s", str, p.this.f30687f);
                if (p.this.f30687f != null) {
                    p.this.f30687f.b(str);
                }
            }
        };
        this.f30685d = new ConcurrentHashMap<>();
        this.f30686e = SmartDeviceManager.getInstance();
    }

    public static p a() {
        return a.f30689a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(o oVar, ICallback iCallback, com.haier.uhome.usdk.base.api.c cVar) {
        if (cVar.a() != ErrorConst.RET_USDK_OK) {
            if (iCallback != null) {
                iCallback.onFailure(cVar.a().toError());
            }
        } else {
            oVar.h().setDevId((String) cVar.c());
            this.f30685d.put((String) cVar.c(), oVar);
            if (iCallback != null) {
                iCallback.onSuccess(cVar.c());
            }
        }
    }

    public ArrayList<o> e() {
        return new ArrayList<>(this.f30685d.values());
    }

    public uSDKState f() {
        return uSDKState.getInstance(this.f30686e.getRunningState().name());
    }

    @Deprecated
    public void a(Context context, String str, int i7, final IuSDKCallback iuSDKCallback) {
        e3.a.t(r.a().e());
        this.f30686e.startService(context, str, i7, new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.d2
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                p.d(iuSDKCallback, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(o oVar, ICallback iCallback, com.haier.uhome.usdk.base.api.c cVar) {
        if (cVar.a() != ErrorConst.RET_USDK_OK) {
            if (iCallback != null) {
                iCallback.onFailure(cVar.a().toError());
            }
        } else {
            oVar.h().setDevId((String) cVar.c());
            this.f30685d.put((String) cVar.c(), oVar);
            if (iCallback != null) {
                iCallback.onSuccess(cVar.c());
            }
        }
    }

    @Deprecated
    public void a(boolean z7) {
        e3.a.v("setDebug is deprecated", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(o oVar, ICallback iCallback, com.haier.uhome.usdk.base.api.c cVar) {
        if (cVar.a() != ErrorConst.RET_USDK_OK) {
            if (iCallback != null) {
                iCallback.onFailure(cVar.a().toError());
            }
        } else {
            oVar.h().setDevId((String) cVar.c());
            this.f30685d.put((String) cVar.c(), oVar);
            if (iCallback != null) {
                iCallback.onSuccess(cVar.c());
            }
        }
    }

    public void a(final IuSDKCallback iuSDKCallback) {
        this.f30686e.stopService(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.a2
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f30434a.c(iuSDKCallback, errorConst);
            }
        });
    }

    @Deprecated
    private void a(final o oVar, boolean z7, final ICallback<String> iCallback) {
        this.f30686e.addDeviceByRandomPrefix(a(oVar), z7, new com.haier.uhome.usdk.base.api.i() { // from class: com.haier.uhome.usdk.api.z1
            @Override // com.haier.uhome.usdk.base.api.i
            public final void onCallback(com.haier.uhome.usdk.base.api.c cVar) {
                this.f31030a.d(oVar, iCallback, cVar);
            }
        });
    }

    @Deprecated
    public void b(final IuSDKCallback iuSDKCallback) {
        this.f30686e.refreshMdns(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.x1
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                p.b(iuSDKCallback, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    @Deprecated
    public void a(final o oVar, final ICallback<String> iCallback) {
        this.f30686e.addDevice(a(oVar), new com.haier.uhome.usdk.base.api.i() { // from class: com.haier.uhome.usdk.api.c2
            @Override // com.haier.uhome.usdk.base.api.i
            public final void onCallback(com.haier.uhome.usdk.base.api.c cVar) {
                this.f30471a.c(oVar, iCallback, cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(o oVar, ICallback iCallback, com.haier.uhome.usdk.base.api.c cVar) {
        if (cVar.a() != ErrorConst.RET_USDK_OK) {
            if (iCallback != null) {
                iCallback.onFailure(cVar.a().toError());
            }
        } else {
            oVar.h().setDevId((String) cVar.c());
            this.f30685d.put((String) cVar.c(), oVar);
            if (iCallback != null) {
                iCallback.onSuccess(cVar.c());
            }
        }
    }

    @Deprecated
    private void c(final o oVar, final ICallback<String> iCallback) {
        this.f30686e.addAuthSlaveDevice(a(oVar), new com.haier.uhome.usdk.base.api.i() { // from class: com.haier.uhome.usdk.api.w1
            @Override // com.haier.uhome.usdk.base.api.i
            public final void onCallback(com.haier.uhome.usdk.base.api.c cVar) {
                this.f30998a.a(oVar, iCallback, cVar);
            }
        });
    }

    public String b() {
        return this.f30686e.getDevIdPrefix();
    }

    @Deprecated
    public void c(final IuSDKCallback iuSDKCallback) {
        this.f30686e.restartDevGW(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.e2
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                p.a(iuSDKCallback, errorConst);
            }
        });
    }

    public int c() {
        return this.f30686e.getCloudState();
    }

    public synchronized com.haier.uhome.usdk.api.interfaces.g d() {
        return this.f30687f;
    }

    @Deprecated
    public void a(String str, final IuSDKCallback iuSDKCallback) {
        this.f30686e.delDevice(str, new com.haier.uhome.usdk.base.api.i() { // from class: com.haier.uhome.usdk.api.f2
            @Override // com.haier.uhome.usdk.base.api.i
            public final void onCallback(com.haier.uhome.usdk.base.api.c cVar) {
                this.f30525a.a(iuSDKCallback, cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(IuSDKCallback iuSDKCallback, com.haier.uhome.usdk.base.api.c cVar) {
        if (cVar.a() == ErrorConst.RET_USDK_OK) {
            this.f30685d.remove(cVar.c());
        }
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(cVar.a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(IuSDKCallback iuSDKCallback, ErrorConst errorConst) {
        if (iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.getErrorConst(errorConst));
        }
    }

    @Deprecated
    public synchronized void a(com.haier.uhome.usdk.api.interfaces.g gVar) {
        try {
            if (gVar == null) {
                this.f30686e.removeListener(this.f30684c);
                this.f30687f = null;
            } else {
                if (gVar == this.f30687f) {
                    return;
                }
                this.f30687f = gVar;
                this.f30686e.addListener(this.f30684c);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public o a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry entry : new HashMap(this.f30685d).entrySet()) {
            String str2 = (String) entry.getKey();
            if (str2 != null && str2.toUpperCase().endsWith(str.toUpperCase())) {
                return (o) entry.getValue();
            }
        }
        return null;
    }

    private SmartDevice a(o oVar) {
        SmartDevice smartDevice = new SmartDevice(oVar.a(), oVar.b(), oVar.c(), oVar.d(), oVar.e(), oVar.f(), oVar.g());
        smartDevice.setListener(oVar.i());
        return smartDevice;
    }

    public void a(String str, final o oVar, double d8, final ICallback<o> iCallback) {
        this.f30686e.bindDevice(str, oVar.a(), d8, new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.api.b2
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                p.a(iCallback, oVar, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, o oVar, ErrorConst errorConst) {
        if (iCallback == null) {
            e3.a.o("bindDevice callback is null,so give up this callback. ", new Object[0]);
        } else if (errorConst == ErrorConst.RET_USDK_OK) {
            iCallback.onSuccess(oVar);
        } else {
            iCallback.onFailure(uSDKErrorConst.getErrorConst(errorConst).toError());
        }
    }

    public void a(o oVar, double d8, final ICallback iCallback) {
        this.f30686e.getBindQRCode(oVar.h(), d8, new com.haier.uhome.usdk.base.api.i() { // from class: com.haier.uhome.usdk.api.y1
            @Override // com.haier.uhome.usdk.base.api.i
            public final void onCallback(com.haier.uhome.usdk.base.api.c cVar) {
                p.a(iCallback, cVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, com.haier.uhome.usdk.base.api.c cVar) {
        if (iCallback == null) {
            e3.a.o("getBindQRCode callback is null,so give up this callback. ", new Object[0]);
        } else if (cVar.a() == ErrorConst.RET_USDK_OK) {
            iCallback.onSuccess(cVar.c());
        } else {
            iCallback.onFailure(cVar.a().toError());
        }
    }
}
