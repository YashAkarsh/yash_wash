package com.haier.uhome.control.local.api;

import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d extends c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f29313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f29314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f29315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f29316d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        com.haier.uhome.control.base.api.p f29317e;

        public a a(String str) {
            this.f29315c = str;
            return this;
        }

        public a b(String str) {
            this.f29313a = str;
            return this;
        }

        public a c(String str) {
            this.f29314b = str;
            return this;
        }

        public a a(int i7) {
            this.f29316d = i7;
            return this;
        }

        public a a(com.haier.uhome.control.base.api.p pVar) {
            this.f29317e = pVar;
            return this;
        }

        public d a() {
            return new d(this.f29313a, this.f29315c, this.f29314b, null, this.f29316d, this.f29317e);
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    protected boolean E() {
        return true;
    }

    @Override // com.haier.uhome.control.base.api.a
    protected String F() {
        return com.haier.uhome.usdk.base.a.as;
    }

    @Override // com.haier.uhome.control.local.api.a, com.haier.uhome.control.base.api.a
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public com.haier.uhome.control.local.e.a s() {
        return ((c) this).f29306a;
    }

    @Override // com.haier.uhome.control.local.api.c
    DeviceStatus N() {
        return com.haier.uhome.control.local.d.f.a().a(d());
    }

    @Override // com.haier.uhome.control.local.api.c
    protected String O() {
        return X();
    }

    public int Q() {
        return ((c) this).f29308c.a();
    }

    public boolean R() {
        return Q() == d();
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
    }

    @Override // com.haier.uhome.control.local.api.c, com.haier.uhome.control.base.api.a
    public void b(com.haier.uhome.usdk.base.api.o oVar) {
    }

    @Override // com.haier.uhome.control.local.api.c, com.haier.uhome.control.base.api.o
    public int d() {
        return ((c) this).f29307b;
    }

    @Override // com.haier.uhome.control.base.api.a
    public String e() {
        return "mesh";
    }

    @Override // com.haier.uhome.control.base.api.a, com.haier.uhome.usdk.base.api.b
    public String toString() {
        return "BleMeshDevice{" + X() + com.alipay.sdk.util.j.f13808d;
    }

    private d(String str, String str2, String str3, String str4, int i7, com.haier.uhome.control.base.api.p pVar) {
        super(str, str2, str3, str4, i7, pVar, com.haier.uhome.control.local.e.f.l());
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, int i7, Trace trace, ICallback<String> iCallback) {
        e3.a.d("BleMeshDevice<%s>\u3000readAttribute <%s>...", X(), str, new Object[0]);
        ((c) this).f29306a.a(X(), U(), m(), str, i7, trace, iCallback);
    }

    public void b(ICallback<Void> iCallback) {
        ((com.haier.uhome.control.local.e.f) ((c) this).f29306a).b(X(), d(), iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public synchronized com.haier.uhome.control.base.api.a.C0367a b(int i7) {
        return new com.haier.uhome.control.base.api.a.C0367a(i7) { // from class: com.haier.uhome.control.local.api.d.1
            @Override // com.haier.uhome.control.base.api.a.C0367a
            public uSDKError a() {
                super.a();
                return ErrorConst.RET_USDK_OK.toError();
            }
        };
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, String str2, int i7, Trace trace, ICallback<Void> iCallback) {
        e3.a.d("BleMeshDevice<%s>\u3000writeAttribute <%s> ", X(), str, new Object[0]);
        ((c) this).f29306a.a(X(), U(), m(), str, str2, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.local.api.a
    public void b(String str, ICallback<com.haier.uhome.control.local.b.c> iCallback) {
        ((c) this).f29306a.a(X(), J(), G(), str, String.valueOf(((c) this).f29307b), 1, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, List<com.haier.uhome.control.base.api.c> list, int i7, Trace trace, String str2, ICallback<Void> iCallback) {
        e3.a.d("BleMeshDevice<%s> execDeviceOperation <%s> args <%s> ", X(), str, list);
        ((c) this).f29306a.a(X(), U(), m(), str, list, i7, trace, str2, iCallback);
    }

    public void a(int i7, String str, int i8, ICallback<com.haier.uhome.control.cloud.api.f> iCallback) {
        ((com.haier.uhome.control.local.e.f) ((c) this).f29306a).a(i7, str, i8, iCallback);
    }
}
