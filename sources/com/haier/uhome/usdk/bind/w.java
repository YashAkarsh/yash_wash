package com.haier.uhome.usdk.bind;

import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class w extends com.haier.uhome.usdk.c.d<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    uSDKError f31851a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f31852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f31853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f31854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f31855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f31856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f31857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f31858i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ICallback<Void> f31859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f31860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f31861c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f31862d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f31863e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f31864f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f31865g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f31866h;

        public a a(ICallback<Void> iCallback) {
            this.f31859a = iCallback;
            return this;
        }

        public a b(String str) {
            this.f31866h = str;
            return this;
        }

        public a c(String str) {
            this.f31862d = str;
            return this;
        }

        public a d(String str) {
            this.f31863e = str;
            return this;
        }

        public a e(String str) {
            this.f31865g = str;
            return this;
        }

        public a a(long j7) {
            this.f31860b = j7;
            return this;
        }

        public a a(String str) {
            this.f31861c = str;
            return this;
        }

        public a a(int i7) {
            this.f31864f = i7;
            return this;
        }

        public w a() {
            w wVar = new w(this.f31859a);
            wVar.f31852c = this.f31860b;
            wVar.f31853d = this.f31861c;
            wVar.f31854e = this.f31862d;
            wVar.f31855f = this.f31863e;
            wVar.f31856g = this.f31864f;
            wVar.f31857h = this.f31865g;
            wVar.f31858i = this.f31866h;
            return wVar;
        }
    }

    public w(ICallback<Void> iCallback) {
        super(iCallback);
        this.f31851a = ErrorConst.ERR_USDK_TIMEOUT.toError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.haier.uhome.control.cloud.api.d dVarE = uSDKDeviceManager.getSingleInstance().e();
        if (dVarE == null) {
            onFailure(ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST.toError());
        } else {
            dVarE.a(this.f31853d, this.f31854e, this.f31855f, this.f31856g, this.f31857h, 15, this.f31858i, new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.usdk.bind.o1
                @Override // com.haier.uhome.usdk.base.api.o
                public final void onCallback(ErrorConst errorConst) {
                    this.f31695a.a(errorConst);
                }
            });
        }
    }

    private boolean c() {
        return System.currentTimeMillis() >= this.f31852c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        onFailure(this.f31851a);
    }

    public void a() {
        b();
        long jCurrentTimeMillis = this.f31852c - System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            jCurrentTimeMillis = 0;
        }
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.n1
            @Override // java.lang.Runnable
            public final void run() {
                this.f31672a.d();
            }
        }, jCurrentTimeMillis, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ErrorConst errorConst) {
        if (errorConst == ErrorConst.RET_USDK_OK) {
            onSuccess(null);
        } else if (c()) {
            onFailure(this.f31851a);
            e3.a.v("onSaveVersionResult already timeout!", new Object[0]);
        } else {
            this.f31851a = errorConst.toError();
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.bind.p1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31711a.b();
                }
            }, 1000L, TimeUnit.MILLISECONDS);
        }
    }
}
