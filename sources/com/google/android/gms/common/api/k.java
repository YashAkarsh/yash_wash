package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import c.m0;
import c.o0;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.g3;
import com.google.android.gms.common.api.internal.j1;
import com.google.android.gms.common.api.internal.p3;
import com.google.android.gms.common.api.internal.y3;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@Deprecated
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c1.a
    @m0
    public static final String f15493a = "<<default account>>";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f15494b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f15495c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("sAllClients")
    private static final Set<k> f15496d = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    public interface b extends com.google.android.gms.common.api.internal.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f15515b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f15516c = 2;
    }

    @Deprecated
    public interface c extends com.google.android.gms.common.api.internal.q {
    }

    public static void k(@m0 String str, @m0 FileDescriptor fileDescriptor, @m0 PrintWriter printWriter, @m0 String[] strArr) {
        Set<k> set = f15496d;
        synchronized (set) {
            String strConcat = String.valueOf(str).concat("  ");
            int i7 = 0;
            for (k kVar : set) {
                printWriter.append((CharSequence) str).append("GoogleApiClient#").println(i7);
                kVar.j(strConcat, fileDescriptor, printWriter, strArr);
                i7++;
            }
        }
    }

    @c1.a
    @m0
    public static Set<k> n() {
        Set<k> set = f15496d;
        synchronized (set) {
        }
        return set;
    }

    public abstract void A();

    public abstract void B(@m0 b bVar);

    public abstract void C(@m0 c cVar);

    @c1.a
    @m0
    public <L> com.google.android.gms.common.api.internal.n<L> D(@m0 L l7) {
        throw new UnsupportedOperationException();
    }

    public abstract void E(@m0 FragmentActivity fragmentActivity);

    public abstract void F(@m0 b bVar);

    public abstract void G(@m0 c cVar);

    public void H(g3 g3Var) {
        throw new UnsupportedOperationException();
    }

    public void I(g3 g3Var) {
        throw new UnsupportedOperationException();
    }

    @m0
    public abstract ConnectionResult d();

    @m0
    public abstract ConnectionResult e(long j7, @m0 TimeUnit timeUnit);

    @m0
    public abstract n<Status> f();

    public abstract void g();

    public void h(int i7) {
        throw new UnsupportedOperationException();
    }

    public abstract void i();

    public abstract void j(@m0 String str, @m0 FileDescriptor fileDescriptor, @m0 PrintWriter printWriter, @m0 String[] strArr);

    @c1.a
    @m0
    public <A extends com.google.android.gms.common.api.a.b, R extends t, T extends com.google.android.gms.common.api.internal.e.a<R, A>> T l(@m0 T t7) {
        throw new UnsupportedOperationException();
    }

    @c1.a
    @m0
    public <A extends com.google.android.gms.common.api.a.b, T extends com.google.android.gms.common.api.internal.e.a<? extends t, A>> T m(@m0 T t7) {
        throw new UnsupportedOperationException();
    }

    @c1.a
    @m0
    public <C extends com.google.android.gms.common.api.a.f> C o(@m0 com.google.android.gms.common.api.a.c<C> cVar) {
        throw new UnsupportedOperationException();
    }

    @m0
    public abstract ConnectionResult p(@m0 com.google.android.gms.common.api.a<?> aVar);

    @c1.a
    @m0
    public Context q() {
        throw new UnsupportedOperationException();
    }

    @c1.a
    @m0
    public Looper r() {
        throw new UnsupportedOperationException();
    }

    @c1.a
    public boolean s(@m0 com.google.android.gms.common.api.a<?> aVar) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean t(@m0 com.google.android.gms.common.api.a<?> aVar);

    public abstract boolean u();

    public abstract boolean v();

    public abstract boolean w(@m0 b bVar);

    public abstract boolean x(@m0 c cVar);

    @c1.a
    public boolean y(@m0 com.google.android.gms.common.api.internal.w wVar) {
        throw new UnsupportedOperationException();
    }

    @c1.a
    public void z() {
        throw new UnsupportedOperationException();
    }

    @c1.a
    @Deprecated
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @o0
        private Account f15497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<Scope> f15498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<Scope> f15499c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f15500d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f15501e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f15502f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f15503g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Map<com.google.android.gms.common.api.a<?>, com.google.android.gms.common.internal.i0> f15504h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Context f15505i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Map<com.google.android.gms.common.api.a<?>, com.google.android.gms.common.api.a.d> f15506j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private com.google.android.gms.common.api.internal.l f15507k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f15508l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @o0
        private c f15509m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Looper f15510n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private com.google.android.gms.common.g f15511o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private com.google.android.gms.common.api.a.AbstractC0179a<? extends com.google.android.gms.signin.f, com.google.android.gms.signin.a> f15512p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private final ArrayList<b> f15513q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private final ArrayList<c> f15514r;

        @c1.a
        public a(@m0 Context context) {
            this.f15498b = new HashSet();
            this.f15499c = new HashSet();
            this.f15504h = new androidx.collection.a();
            this.f15506j = new androidx.collection.a();
            this.f15508l = -1;
            this.f15511o = com.google.android.gms.common.g.x();
            this.f15512p = com.google.android.gms.signin.e.f16760c;
            this.f15513q = new ArrayList<>();
            this.f15514r = new ArrayList<>();
            this.f15505i = context;
            this.f15510n = context.getMainLooper();
            this.f15502f = context.getPackageName();
            this.f15503g = context.getClass().getName();
        }

        private final <O extends com.google.android.gms.common.api.a.d> void q(com.google.android.gms.common.api.a<O> aVar, @o0 O o7, Scope... scopeArr) {
            HashSet hashSet = new HashSet(((com.google.android.gms.common.api.a.e) com.google.android.gms.common.internal.u.l(aVar.c(), "Base client builder must not be null")).a(o7));
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.f15504h.put(aVar, new com.google.android.gms.common.internal.i0(hashSet));
        }

        @m0
        public a a(@m0 com.google.android.gms.common.api.a<? extends com.google.android.gms.common.api.a.d.e> aVar) {
            com.google.android.gms.common.internal.u.l(aVar, "Api must not be null");
            this.f15506j.put(aVar, null);
            List<Scope> listA = ((com.google.android.gms.common.api.a.e) com.google.android.gms.common.internal.u.l(aVar.c(), "Base client builder must not be null")).a(null);
            this.f15499c.addAll(listA);
            this.f15498b.addAll(listA);
            return this;
        }

        @m0
        public <O extends com.google.android.gms.common.api.a.d.c> a b(@m0 com.google.android.gms.common.api.a<O> aVar, @m0 O o7) {
            com.google.android.gms.common.internal.u.l(aVar, "Api must not be null");
            com.google.android.gms.common.internal.u.l(o7, "Null options are not permitted for this Api");
            this.f15506j.put(aVar, o7);
            List<Scope> listA = ((com.google.android.gms.common.api.a.e) com.google.android.gms.common.internal.u.l(aVar.c(), "Base client builder must not be null")).a(o7);
            this.f15499c.addAll(listA);
            this.f15498b.addAll(listA);
            return this;
        }

        @m0
        public <O extends com.google.android.gms.common.api.a.d.c> a c(@m0 com.google.android.gms.common.api.a<O> aVar, @m0 O o7, @m0 Scope... scopeArr) {
            com.google.android.gms.common.internal.u.l(aVar, "Api must not be null");
            com.google.android.gms.common.internal.u.l(o7, "Null options are not permitted for this Api");
            this.f15506j.put(aVar, o7);
            q(aVar, o7, scopeArr);
            return this;
        }

        @m0
        public <T extends com.google.android.gms.common.api.a.d.e> a d(@m0 com.google.android.gms.common.api.a<? extends com.google.android.gms.common.api.a.d.e> aVar, @m0 Scope... scopeArr) {
            com.google.android.gms.common.internal.u.l(aVar, "Api must not be null");
            this.f15506j.put(aVar, null);
            q(aVar, null, scopeArr);
            return this;
        }

        @m0
        public a e(@m0 b bVar) {
            com.google.android.gms.common.internal.u.l(bVar, "Listener must not be null");
            this.f15513q.add(bVar);
            return this;
        }

        @m0
        public a f(@m0 c cVar) {
            com.google.android.gms.common.internal.u.l(cVar, "Listener must not be null");
            this.f15514r.add(cVar);
            return this;
        }

        @m0
        public a g(@m0 Scope scope) {
            com.google.android.gms.common.internal.u.l(scope, "Scope must not be null");
            this.f15498b.add(scope);
            return this;
        }

        @m0
        public k h() {
            com.google.android.gms.common.internal.u.b(!this.f15506j.isEmpty(), "must call addApi() to add at least one API");
            com.google.android.gms.common.internal.f fVarP = p();
            Map<com.google.android.gms.common.api.a<?>, com.google.android.gms.common.internal.i0> mapN = fVarP.n();
            androidx.collection.a aVar = new androidx.collection.a();
            androidx.collection.a aVar2 = new androidx.collection.a();
            ArrayList arrayList = new ArrayList();
            com.google.android.gms.common.api.a<?> aVar3 = null;
            boolean z7 = false;
            for (com.google.android.gms.common.api.a<?> aVar4 : this.f15506j.keySet()) {
                com.google.android.gms.common.api.a.d dVar = this.f15506j.get(aVar4);
                boolean z8 = mapN.get(aVar4) != null;
                aVar.put(aVar4, Boolean.valueOf(z8));
                y3 y3Var = new y3(aVar4, z8);
                arrayList.add(y3Var);
                com.google.android.gms.common.api.a.AbstractC0179a abstractC0179a = (com.google.android.gms.common.api.a.AbstractC0179a) com.google.android.gms.common.internal.u.k(aVar4.a());
                com.google.android.gms.common.api.a.f fVarC = abstractC0179a.c(this.f15505i, this.f15510n, fVarP, dVar, y3Var, y3Var);
                aVar2.put(aVar4.b(), fVarC);
                if (abstractC0179a.b() == 1) {
                    z7 = dVar != null;
                }
                if (fVarC.d()) {
                    if (aVar3 != null) {
                        String strD = aVar4.d();
                        String strD2 = aVar3.d();
                        StringBuilder sb = new StringBuilder(String.valueOf(strD).length() + 21 + String.valueOf(strD2).length());
                        sb.append(strD);
                        sb.append(" cannot be used with ");
                        sb.append(strD2);
                        throw new IllegalStateException(sb.toString());
                    }
                    aVar3 = aVar4;
                }
            }
            if (aVar3 != null) {
                if (z7) {
                    String strD3 = aVar3.d();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strD3).length() + 82);
                    sb2.append("With using ");
                    sb2.append(strD3);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
                com.google.android.gms.common.internal.u.s(this.f15497a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", aVar3.d());
                com.google.android.gms.common.internal.u.s(this.f15498b.equals(this.f15499c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", aVar3.d());
            }
            j1 j1Var = new j1(this.f15505i, new ReentrantLock(), this.f15510n, fVarP, this.f15511o, this.f15512p, aVar, this.f15513q, this.f15514r, aVar2, this.f15508l, j1.K(aVar2.values(), true), arrayList);
            synchronized (k.f15496d) {
                k.f15496d.add(j1Var);
            }
            if (this.f15508l >= 0) {
                p3.u(this.f15507k).v(this.f15508l, j1Var, this.f15509m);
            }
            return j1Var;
        }

        @m0
        public a i(@m0 FragmentActivity fragmentActivity, int i7, @o0 c cVar) {
            com.google.android.gms.common.api.internal.l lVar = new com.google.android.gms.common.api.internal.l((Activity) fragmentActivity);
            com.google.android.gms.common.internal.u.b(i7 >= 0, "clientId must be non-negative");
            this.f15508l = i7;
            this.f15509m = cVar;
            this.f15507k = lVar;
            return this;
        }

        @m0
        public a j(@m0 FragmentActivity fragmentActivity, @o0 c cVar) {
            i(fragmentActivity, 0, cVar);
            return this;
        }

        @m0
        public a k(@m0 String str) {
            this.f15497a = str == null ? null : new Account(str, com.google.android.gms.common.internal.b.f15664a);
            return this;
        }

        @m0
        public a l(int i7) {
            this.f15500d = i7;
            return this;
        }

        @m0
        public a m(@m0 Handler handler) {
            com.google.android.gms.common.internal.u.l(handler, "Handler must not be null");
            this.f15510n = handler.getLooper();
            return this;
        }

        @m0
        public a n(@m0 View view) {
            com.google.android.gms.common.internal.u.l(view, "View must not be null");
            this.f15501e = view;
            return this;
        }

        @m0
        public a o() {
            k("<<default account>>");
            return this;
        }

        @g1.d0
        @m0
        public final com.google.android.gms.common.internal.f p() {
            com.google.android.gms.signin.a aVar = com.google.android.gms.signin.a.f16748j;
            Map<com.google.android.gms.common.api.a<?>, com.google.android.gms.common.api.a.d> map = this.f15506j;
            com.google.android.gms.common.api.a<com.google.android.gms.signin.a> aVar2 = com.google.android.gms.signin.e.f16764g;
            if (map.containsKey(aVar2)) {
                aVar = (com.google.android.gms.signin.a) this.f15506j.get(aVar2);
            }
            return new com.google.android.gms.common.internal.f(this.f15497a, this.f15498b, this.f15504h, this.f15500d, this.f15501e, this.f15502f, this.f15503g, aVar, false);
        }

        @c1.a
        public a(@m0 Context context, @m0 b bVar, @m0 c cVar) {
            this(context);
            com.google.android.gms.common.internal.u.l(bVar, "Must provide a connected listener");
            this.f15513q.add(bVar);
            com.google.android.gms.common.internal.u.l(cVar, "Must provide a connection failed listener");
            this.f15514r.add(cVar);
        }
    }
}
