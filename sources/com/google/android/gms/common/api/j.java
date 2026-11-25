package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import c.h1;
import c.j0;
import c.m0;
import c.o0;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.a2;
import com.google.android.gms.common.api.internal.v1;
import com.google.android.gms.common.api.internal.y2;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class j<O extends com.google.android.gms.common.api.a.d> implements l<O> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final String f15479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.gms.common.api.a<O> f15480c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final O f15481d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.c<O> f15482e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Looper f15483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f15484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @d6.c
    private final k f15485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.y f15486i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @m0
    protected final com.google.android.gms.common.api.internal.i f15487j;

    @c1.a
    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @c1.a
        @m0
        public static final a f15488c = new C0182a().a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        public final com.google.android.gms.common.api.internal.y f15489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        public final Looper f15490b;

        /* JADX INFO: renamed from: com.google.android.gms.common.api.j$a$a, reason: collision with other inner class name */
        @c1.a
        public static class C0182a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private com.google.android.gms.common.api.internal.y f15491a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Looper f15492b;

            @c1.a
            public C0182a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @c1.a
            @m0
            public a a() {
                if (this.f15491a == null) {
                    this.f15491a = new com.google.android.gms.common.api.internal.b();
                }
                if (this.f15492b == null) {
                    this.f15492b = Looper.getMainLooper();
                }
                return new a(this.f15491a, this.f15492b);
            }

            @c1.a
            @m0
            public C0182a b(@m0 Looper looper) {
                com.google.android.gms.common.internal.u.l(looper, "Looper must not be null.");
                this.f15492b = looper;
                return this;
            }

            @c1.a
            @m0
            public C0182a c(@m0 com.google.android.gms.common.api.internal.y yVar) {
                com.google.android.gms.common.internal.u.l(yVar, "StatusExceptionMapper must not be null.");
                this.f15491a = yVar;
                return this;
            }
        }

        @c1.a
        private a(com.google.android.gms.common.api.internal.y yVar, Account account, Looper looper) {
            this.f15489a = yVar;
            this.f15490b = looper;
        }
    }

    @c1.a
    @j0
    public j(@m0 Activity activity, @m0 com.google.android.gms.common.api.a<O> aVar, @m0 O o7, @m0 a aVar2) {
        this(activity, activity, aVar, o7, aVar2);
    }

    private final <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.e.a<? extends t, A>> T y(int i7, @m0 T t7) {
        t7.s();
        this.f15487j.J(this, i7, t7);
        return t7;
    }

    private final <TResult, A extends com.google.android.gms.common.api.a.b> com.google.android.gms.tasks.m<TResult> z(int i7, @m0 com.google.android.gms.common.api.internal.a0<A, TResult> a0Var) {
        com.google.android.gms.tasks.n nVar = new com.google.android.gms.tasks.n();
        this.f15487j.K(this, i7, a0Var, nVar, this.f15486i);
        return nVar.a();
    }

    @Override // com.google.android.gms.common.api.l
    @m0
    public final com.google.android.gms.common.api.internal.c<O> b() {
        return this.f15482e;
    }

    @c1.a
    @m0
    public k c() {
        return this.f15485h;
    }

    @c1.a
    @m0
    protected com.google.android.gms.common.internal.f.a d() {
        Account accountF;
        GoogleSignInAccount googleSignInAccountE;
        GoogleSignInAccount googleSignInAccountE2;
        com.google.android.gms.common.internal.f.a aVar = new com.google.android.gms.common.internal.f.a();
        O o7 = this.f15481d;
        if (!(o7 instanceof com.google.android.gms.common.api.a.d.b) || (googleSignInAccountE2 = ((com.google.android.gms.common.api.a.d.b) o7).E()) == null) {
            O o8 = this.f15481d;
            accountF = o8 instanceof com.google.android.gms.common.api.a.d.InterfaceC0180a ? ((com.google.android.gms.common.api.a.d.InterfaceC0180a) o8).F() : null;
        } else {
            accountF = googleSignInAccountE2.F();
        }
        aVar.d(accountF);
        O o9 = this.f15481d;
        Set<Scope> setEmptySet = (!(o9 instanceof com.google.android.gms.common.api.a.d.b) || (googleSignInAccountE = ((com.google.android.gms.common.api.a.d.b) o9).E()) == null) ? Collections.emptySet() : googleSignInAccountE.L0();
        aVar.c(setEmptySet);
        aVar.e(this.f15478a.getClass().getName());
        aVar.b(this.f15478a.getPackageName());
        return aVar;
    }

    @c1.a
    @m0
    protected com.google.android.gms.tasks.m<Boolean> e() {
        return this.f15487j.C(this);
    }

    @c1.a
    @m0
    public <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.e.a<? extends t, A>> T f(@m0 T t7) {
        y(2, t7);
        return t7;
    }

    @c1.a
    @m0
    public <TResult, A extends com.google.android.gms.common.api.a.b> com.google.android.gms.tasks.m<TResult> g(@m0 com.google.android.gms.common.api.internal.a0<A, TResult> a0Var) {
        return z(2, a0Var);
    }

    @c1.a
    @m0
    public <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.e.a<? extends t, A>> T h(@m0 T t7) {
        y(0, t7);
        return t7;
    }

    @c1.a
    @m0
    public <TResult, A extends com.google.android.gms.common.api.a.b> com.google.android.gms.tasks.m<TResult> i(@m0 com.google.android.gms.common.api.internal.a0<A, TResult> a0Var) {
        return z(0, a0Var);
    }

    @c1.a
    @m0
    @Deprecated
    public <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.t<A, ?>, U extends com.google.android.gms.common.api.internal.c0<A, ?>> com.google.android.gms.tasks.m<Void> j(@m0 T t7, @m0 U u7) {
        com.google.android.gms.common.internal.u.k(t7);
        com.google.android.gms.common.internal.u.k(u7);
        com.google.android.gms.common.internal.u.l(t7.b(), "Listener has already been released.");
        com.google.android.gms.common.internal.u.l(u7.a(), "Listener has already been released.");
        com.google.android.gms.common.internal.u.b(com.google.android.gms.common.internal.s.b(t7.b(), u7.a()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.f15487j.D(this, t7, u7, new Runnable() { // from class: com.google.android.gms.common.api.c0
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @c1.a
    @m0
    public <A extends com.google.android.gms.common.api.a.b> com.google.android.gms.tasks.m<Void> k(@m0 com.google.android.gms.common.api.internal.u<A, ?> uVar) {
        com.google.android.gms.common.internal.u.k(uVar);
        com.google.android.gms.common.internal.u.l(uVar.f15415a.b(), "Listener has already been released.");
        com.google.android.gms.common.internal.u.l(uVar.f15416b.a(), "Listener has already been released.");
        return this.f15487j.D(this, uVar.f15415a, uVar.f15416b, uVar.f15417c);
    }

    @c1.a
    @m0
    public com.google.android.gms.tasks.m<Boolean> l(@m0 com.google.android.gms.common.api.internal.n.a<?> aVar) {
        return m(aVar, 0);
    }

    @c1.a
    @m0
    public com.google.android.gms.tasks.m<Boolean> m(@m0 com.google.android.gms.common.api.internal.n.a<?> aVar, int i7) {
        com.google.android.gms.common.internal.u.l(aVar, "Listener key cannot be null.");
        return this.f15487j.E(this, aVar, i7);
    }

    @c1.a
    @m0
    public <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.e.a<? extends t, A>> T n(@m0 T t7) {
        y(1, t7);
        return t7;
    }

    @c1.a
    @m0
    public <TResult, A extends com.google.android.gms.common.api.a.b> com.google.android.gms.tasks.m<TResult> o(@m0 com.google.android.gms.common.api.internal.a0<A, TResult> a0Var) {
        return z(1, a0Var);
    }

    @c1.a
    @m0
    public O p() {
        return this.f15481d;
    }

    @c1.a
    @m0
    public Context q() {
        return this.f15478a;
    }

    @o0
    @c1.a
    protected String r() {
        return this.f15479b;
    }

    @o0
    @c1.a
    @Deprecated
    protected String s() {
        return this.f15479b;
    }

    @c1.a
    @m0
    public Looper t() {
        return this.f15483f;
    }

    @c1.a
    @m0
    public <L> com.google.android.gms.common.api.internal.n<L> u(@m0 L l7, @m0 String str) {
        return com.google.android.gms.common.api.internal.o.a(l7, this.f15483f, str);
    }

    public final int v() {
        return this.f15484g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h1
    public final com.google.android.gms.common.api.a.f w(Looper looper, v1<O> v1Var) {
        com.google.android.gms.common.api.a.f fVarC = ((com.google.android.gms.common.api.a.AbstractC0179a) com.google.android.gms.common.internal.u.k(this.f15480c.a())).c(this.f15478a, looper, d().a(), this.f15481d, v1Var, v1Var);
        String strR = r();
        if (strR != null && (fVarC instanceof com.google.android.gms.common.internal.e)) {
            ((com.google.android.gms.common.internal.e) fVarC).X(strR);
        }
        if (strR != null && (fVarC instanceof com.google.android.gms.common.api.internal.p)) {
            ((com.google.android.gms.common.api.internal.p) fVarC).A(strR);
        }
        return fVarC;
    }

    public final y2 x(Context context, Handler handler) {
        return new y2(context, handler, d().a());
    }

    @c1.a
    @Deprecated
    public j(@m0 Activity activity, @m0 com.google.android.gms.common.api.a<O> aVar, @m0 O o7, @m0 com.google.android.gms.common.api.internal.y yVar) {
        a.C0182a c0182a = new a.C0182a();
        c0182a.c(yVar);
        c0182a.b(activity.getMainLooper());
        this(activity, (com.google.android.gms.common.api.a) aVar, (com.google.android.gms.common.api.a.d) o7, c0182a.a());
    }

    private j(@m0 Context context, @o0 Activity activity, com.google.android.gms.common.api.a<O> aVar, O o7, a aVar2) {
        com.google.android.gms.common.internal.u.l(context, "Null context is not permitted.");
        com.google.android.gms.common.internal.u.l(aVar, "Api must not be null.");
        com.google.android.gms.common.internal.u.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f15478a = context.getApplicationContext();
        String str = null;
        if (g1.v.q()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.f15479b = str;
        this.f15480c = aVar;
        this.f15481d = o7;
        this.f15483f = aVar2.f15490b;
        com.google.android.gms.common.api.internal.c<O> cVarA = com.google.android.gms.common.api.internal.c.a(aVar, o7, str);
        this.f15482e = cVarA;
        this.f15485h = new a2(this);
        com.google.android.gms.common.api.internal.i iVarZ = com.google.android.gms.common.api.internal.i.z(this.f15478a);
        this.f15487j = iVarZ;
        this.f15484g = iVarZ.n();
        this.f15486i = aVar2.f15489a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            com.google.android.gms.common.api.internal.i0.v(activity, iVarZ, cVarA);
        }
        iVarZ.c(this);
    }

    @c1.a
    @Deprecated
    public j(@m0 Context context, @m0 com.google.android.gms.common.api.a<O> aVar, @m0 O o7, @m0 Looper looper, @m0 com.google.android.gms.common.api.internal.y yVar) {
        a.C0182a c0182a = new a.C0182a();
        c0182a.b(looper);
        c0182a.c(yVar);
        this(context, aVar, o7, c0182a.a());
    }

    @c1.a
    public j(@m0 Context context, @m0 com.google.android.gms.common.api.a<O> aVar, @m0 O o7, @m0 a aVar2) {
        this(context, (Activity) null, aVar, o7, aVar2);
    }

    @c1.a
    @Deprecated
    public j(@m0 Context context, @m0 com.google.android.gms.common.api.a<O> aVar, @m0 O o7, @m0 com.google.android.gms.common.api.internal.y yVar) {
        a.C0182a c0182a = new a.C0182a();
        c0182a.c(yVar);
        this(context, aVar, o7, c0182a.a());
    }
}
