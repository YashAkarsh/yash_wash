package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.core.util.j;
import androidx.lifecycle.k0;
import androidx.lifecycle.n0;
import androidx.lifecycle.p0;
import androidx.lifecycle.q;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import c.j0;
import c.m0;
import c.o0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
class b extends androidx.loader.app.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f8371c = "LoaderManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f8372d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final q f8373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final c f8374b;

    public static class a<D> extends w<D> implements androidx.loader.content.c.InterfaceC0106c<D> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private final int f8375m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @o0
        private final Bundle f8376n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @m0
        private final androidx.loader.content.c<D> f8377o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private q f8378p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private C0104b<D> f8379q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private androidx.loader.content.c<D> f8380r;

        a(int i7, @o0 Bundle bundle, @m0 androidx.loader.content.c<D> cVar, @o0 androidx.loader.content.c<D> cVar2) {
            this.f8375m = i7;
            this.f8376n = bundle;
            this.f8377o = cVar;
            this.f8380r = cVar2;
            cVar.u(i7, this);
        }

        @Override // androidx.loader.content.c.InterfaceC0106c
        public void a(@m0 androidx.loader.content.c<D> cVar, @o0 D d8) {
            if (b.f8372d) {
                Log.v(b.f8371c, "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                q(d8);
                return;
            }
            if (b.f8372d) {
                Log.w(b.f8371c, "onLoadComplete was incorrectly called on a background thread");
            }
            n(d8);
        }

        @Override // androidx.lifecycle.LiveData
        protected void l() {
            if (b.f8372d) {
                Log.v(b.f8371c, "  Starting: " + this);
            }
            this.f8377o.y();
        }

        @Override // androidx.lifecycle.LiveData
        protected void m() {
            if (b.f8372d) {
                Log.v(b.f8371c, "  Stopping: " + this);
            }
            this.f8377o.z();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void o(@m0 x<? super D> xVar) {
            super.o(xVar);
            this.f8378p = null;
            this.f8379q = null;
        }

        @Override // androidx.lifecycle.w, androidx.lifecycle.LiveData
        public void q(D d8) {
            super.q(d8);
            androidx.loader.content.c<D> cVar = this.f8380r;
            if (cVar != null) {
                cVar.w();
                this.f8380r = null;
            }
        }

        @j0
        androidx.loader.content.c<D> r(boolean z7) {
            if (b.f8372d) {
                Log.v(b.f8371c, "  Destroying: " + this);
            }
            this.f8377o.b();
            this.f8377o.a();
            C0104b<D> c0104b = this.f8379q;
            if (c0104b != null) {
                o(c0104b);
                if (z7) {
                    c0104b.d();
                }
            }
            this.f8377o.B(this);
            if ((c0104b == null || c0104b.c()) && !z7) {
                return this.f8377o;
            }
            this.f8377o.w();
            return this.f8380r;
        }

        public void s(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f8375m);
            printWriter.print(" mArgs=");
            printWriter.println(this.f8376n);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f8377o);
            this.f8377o.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f8379q != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f8379q);
                this.f8379q.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(t().d(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(h());
        }

        @m0
        androidx.loader.content.c<D> t() {
            return this.f8377o;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f8375m);
            sb.append(" : ");
            j.a(this.f8377o, sb);
            sb.append("}}");
            return sb.toString();
        }

        boolean u() {
            C0104b<D> c0104b;
            return (!h() || (c0104b = this.f8379q) == null || c0104b.c()) ? false : true;
        }

        void v() {
            q qVar = this.f8378p;
            C0104b<D> c0104b = this.f8379q;
            if (qVar == null || c0104b == null) {
                return;
            }
            super.o(c0104b);
            j(qVar, c0104b);
        }

        @m0
        @j0
        androidx.loader.content.c<D> w(@m0 q qVar, @m0 androidx.loader.app.a.InterfaceC0103a<D> interfaceC0103a) {
            C0104b<D> c0104b = new C0104b<>(this.f8377o, interfaceC0103a);
            j(qVar, c0104b);
            C0104b<D> c0104b2 = this.f8379q;
            if (c0104b2 != null) {
                o(c0104b2);
            }
            this.f8378p = qVar;
            this.f8379q = c0104b;
            return this.f8377o;
        }
    }

    /* JADX INFO: renamed from: androidx.loader.app.b$b, reason: collision with other inner class name */
    static class C0104b<D> implements x<D> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final androidx.loader.content.c<D> f8381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        private final androidx.loader.app.a.InterfaceC0103a<D> f8382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f8383c = false;

        C0104b(@m0 androidx.loader.content.c<D> cVar, @m0 androidx.loader.app.a.InterfaceC0103a<D> interfaceC0103a) {
            this.f8381a = cVar;
            this.f8382b = interfaceC0103a;
        }

        @Override // androidx.lifecycle.x
        public void a(@o0 D d8) {
            if (b.f8372d) {
                Log.v(b.f8371c, "  onLoadFinished in " + this.f8381a + ": " + this.f8381a.d(d8));
            }
            this.f8382b.a(this.f8381a, d8);
            this.f8383c = true;
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f8383c);
        }

        boolean c() {
            return this.f8383c;
        }

        @j0
        void d() {
            if (this.f8383c) {
                if (b.f8372d) {
                    Log.v(b.f8371c, "  Resetting: " + this.f8381a);
                }
                this.f8382b.c(this.f8381a);
            }
        }

        public String toString() {
            return this.f8382b.toString();
        }
    }

    static class c extends k0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final androidx.lifecycle.m0.b f8384f = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private androidx.collection.j<a> f8385d = new androidx.collection.j<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f8386e = false;

        static class a implements androidx.lifecycle.m0.b {
            a() {
            }

            @Override // androidx.lifecycle.m0.b
            @m0
            public <T extends k0> T a(@m0 Class<T> cls) {
                return new c();
            }

            @Override // androidx.lifecycle.m0.b
            public /* synthetic */ k0 b(Class cls, v.a aVar) {
                return n0.b(this, cls, aVar);
            }
        }

        c() {
        }

        @m0
        static c i(p0 p0Var) {
            return (c) new androidx.lifecycle.m0(p0Var, f8384f).a(c.class);
        }

        @Override // androidx.lifecycle.k0
        protected void e() {
            super.e();
            int iC = this.f8385d.C();
            for (int i7 = 0; i7 < iC; i7++) {
                this.f8385d.D(i7).r(true);
            }
            this.f8385d.e();
        }

        public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f8385d.C() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i7 = 0; i7 < this.f8385d.C(); i7++) {
                    a aVarD = this.f8385d.D(i7);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f8385d.r(i7));
                    printWriter.print(": ");
                    printWriter.println(aVarD.toString());
                    aVarD.s(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void h() {
            this.f8386e = false;
        }

        <D> a<D> j(int i7) {
            return this.f8385d.m(i7);
        }

        boolean k() {
            int iC = this.f8385d.C();
            for (int i7 = 0; i7 < iC; i7++) {
                if (this.f8385d.D(i7).u()) {
                    return true;
                }
            }
            return false;
        }

        boolean l() {
            return this.f8386e;
        }

        void m() {
            int iC = this.f8385d.C();
            for (int i7 = 0; i7 < iC; i7++) {
                this.f8385d.D(i7).v();
            }
        }

        void n(int i7, @m0 a aVar) {
            this.f8385d.s(i7, aVar);
        }

        void o(int i7) {
            this.f8385d.v(i7);
        }

        void p() {
            this.f8386e = true;
        }
    }

    b(@m0 q qVar, @m0 p0 p0Var) {
        this.f8373a = qVar;
        this.f8374b = c.i(p0Var);
    }

    @m0
    @j0
    private <D> androidx.loader.content.c<D> j(int i7, @o0 Bundle bundle, @m0 androidx.loader.app.a.InterfaceC0103a<D> interfaceC0103a, @o0 androidx.loader.content.c<D> cVar) {
        try {
            this.f8374b.p();
            androidx.loader.content.c<D> cVarB = interfaceC0103a.b(i7, bundle);
            if (cVarB == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (cVarB.getClass().isMemberClass() && !Modifier.isStatic(cVarB.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + cVarB);
            }
            a aVar = new a(i7, bundle, cVarB, cVar);
            if (f8372d) {
                Log.v(f8371c, "  Created new loader " + aVar);
            }
            this.f8374b.n(i7, aVar);
            this.f8374b.h();
            return aVar.w(this.f8373a, interfaceC0103a);
        } catch (Throwable th) {
            this.f8374b.h();
            throw th;
        }
    }

    @Override // androidx.loader.app.a
    @j0
    public void a(int i7) {
        if (this.f8374b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        if (f8372d) {
            Log.v(f8371c, "destroyLoader in " + this + " of " + i7);
        }
        a aVarJ = this.f8374b.j(i7);
        if (aVarJ != null) {
            aVarJ.r(true);
            this.f8374b.o(i7);
        }
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f8374b.g(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    @o0
    public <D> androidx.loader.content.c<D> e(int i7) {
        if (this.f8374b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a<D> aVarJ = this.f8374b.j(i7);
        if (aVarJ != null) {
            return aVarJ.t();
        }
        return null;
    }

    @Override // androidx.loader.app.a
    public boolean f() {
        return this.f8374b.k();
    }

    @Override // androidx.loader.app.a
    @m0
    @j0
    public <D> androidx.loader.content.c<D> g(int i7, @o0 Bundle bundle, @m0 androidx.loader.app.a.InterfaceC0103a<D> interfaceC0103a) {
        if (this.f8374b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a<D> aVarJ = this.f8374b.j(i7);
        if (f8372d) {
            Log.v(f8371c, "initLoader in " + this + ": args=" + bundle);
        }
        if (aVarJ == null) {
            return j(i7, bundle, interfaceC0103a, null);
        }
        if (f8372d) {
            Log.v(f8371c, "  Re-using existing loader " + aVarJ);
        }
        return aVarJ.w(this.f8373a, interfaceC0103a);
    }

    @Override // androidx.loader.app.a
    public void h() {
        this.f8374b.m();
    }

    @Override // androidx.loader.app.a
    @m0
    @j0
    public <D> androidx.loader.content.c<D> i(int i7, @o0 Bundle bundle, @m0 androidx.loader.app.a.InterfaceC0103a<D> interfaceC0103a) {
        if (this.f8374b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
        if (f8372d) {
            Log.v(f8371c, "restartLoader in " + this + ": args=" + bundle);
        }
        a<D> aVarJ = this.f8374b.j(i7);
        return j(i7, bundle, interfaceC0103a, aVarJ != null ? aVarJ.r(false) : null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        j.a(this.f8373a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
