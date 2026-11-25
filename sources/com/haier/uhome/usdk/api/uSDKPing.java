package com.haier.uhome.usdk.api;

import com.haier.uhome.usdk.api.interfaces.IuSDKCallback;
import com.haier.uhome.usdk.api.interfaces.IuSDKResultCallback;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class uSDKPing {
    private com.haier.uhome.usdk.api.b.a<List<uSDKPingResult>> callbackActuator;
    private com.haier.library.common.b.n mPingClient;
    private int pingPkgCount;
    private int pingPkgLength;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static uSDKPing f30953a = new uSDKPing();

        private a() {
        }
    }

    public static uSDKPing getInstance() {
        return a.f30953a;
    }

    public synchronized void pingWithURLs(List<String> list, final IuSDKResultCallback<List<uSDKPingResult>> iuSDKResultCallback) {
        final ArrayList arrayList = new ArrayList();
        if (!uSDKManager.getSingleInstance().a()) {
            if (iuSDKResultCallback != null) {
                iuSDKResultCallback.onFail(uSDKErrorConst.ERR_USDK_UNSTARTED);
            }
        } else {
            this.callbackActuator = new com.haier.uhome.usdk.api.b.a<>(new ICallback<List<uSDKPingResult>>() { // from class: com.haier.uhome.usdk.api.uSDKPing.1
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(List<uSDKPingResult> list2) {
                    IuSDKResultCallback iuSDKResultCallback2 = iuSDKResultCallback;
                    if (iuSDKResultCallback2 != null) {
                        iuSDKResultCallback2.onSuccess(list2);
                    } else {
                        e3.a.v("callback is null", new Object[0]);
                    }
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    IuSDKResultCallback iuSDKResultCallback2 = iuSDKResultCallback;
                    if (iuSDKResultCallback2 != null) {
                        iuSDKResultCallback2.onFail(uSDKErrorConst.getErrorConst(ErrorConst.getErrorConstById(usdkerror.getCode())));
                    } else {
                        e3.a.v("callback is null", new Object[0]);
                    }
                }
            });
            com.haier.library.common.b.n nVarE = new com.haier.library.common.b.n.b().c(list).f(5000L).a(this.pingPkgCount, this.pingPkgLength).d(false).e();
            this.mPingClient = nVarE;
            nVarE.l(new com.haier.library.common.b.n.c() { // from class: com.haier.uhome.usdk.api.uSDKPing.2
                @Override // com.haier.library.common.b.n.c
                public void a(double d8) {
                }

                @Override // com.haier.library.common.b.n.c
                public void a(List<com.haier.library.common.b.o> list2) {
                    Iterator<com.haier.library.common.b.o> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new uSDKPingResult(it.next()));
                    }
                    IuSDKResultCallback iuSDKResultCallback2 = iuSDKResultCallback;
                    if (iuSDKResultCallback2 != null) {
                        iuSDKResultCallback2.onSuccess(arrayList);
                    }
                }

                @Override // com.haier.library.common.b.n.c
                public void a(String str) {
                    if ("in ping".equalsIgnoreCase(str)) {
                        IuSDKResultCallback iuSDKResultCallback2 = iuSDKResultCallback;
                        if (iuSDKResultCallback2 != null) {
                            iuSDKResultCallback2.onFail(uSDKErrorConst.ERR_USDK_PING_IS_IN_WORKING);
                            return;
                        }
                        return;
                    }
                    if ("ping stop".equalsIgnoreCase(str)) {
                        IuSDKResultCallback iuSDKResultCallback3 = iuSDKResultCallback;
                        if (iuSDKResultCallback3 != null) {
                            iuSDKResultCallback3.onFail(uSDKErrorConst.ERR_USDK_PING_IS_STOPED);
                            return;
                        }
                        return;
                    }
                    "ping fail".equalsIgnoreCase(str);
                }
            });
        }
    }

    public void stopPing(IuSDKCallback iuSDKCallback) {
        if (!uSDKManager.getSingleInstance().a() && iuSDKCallback != null) {
            iuSDKCallback.onCallback(uSDKErrorConst.ERR_USDK_UNSTARTED);
            return;
        }
        com.haier.library.common.b.n nVar = this.mPingClient;
        if (nVar == null || !nVar.w()) {
            if (iuSDKCallback != null) {
                iuSDKCallback.onCallback(uSDKErrorConst.RET_USDK_OK);
            }
        } else {
            this.mPingClient.t("ping stop");
            if (iuSDKCallback != null) {
                iuSDKCallback.onCallback(uSDKErrorConst.ERR_USDK_PING_IS_STOPED);
            }
        }
    }

    private uSDKPing() {
        this.pingPkgCount = 3;
        this.pingPkgLength = 64;
    }
}
