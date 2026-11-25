package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.n4;
import androidx.core.view.o4;
import androidx.core.view.p4;
import c.x0;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f1072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    o4 f1073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1074e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1071b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final p4 f1075f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList<n4> f1070a = new ArrayList<>();

    class a extends p4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1076a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1077b = 0;

        a() {
        }

        @Override // androidx.core.view.p4, androidx.core.view.o4
        public void b(View view) {
            int i7 = this.f1077b + 1;
            this.f1077b = i7;
            if (i7 == h.this.f1070a.size()) {
                o4 o4Var = h.this.f1073d;
                if (o4Var != null) {
                    o4Var.b(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.p4, androidx.core.view.o4
        public void c(View view) {
            if (this.f1076a) {
                return;
            }
            this.f1076a = true;
            o4 o4Var = h.this.f1073d;
            if (o4Var != null) {
                o4Var.c(null);
            }
        }

        void d() {
            this.f1077b = 0;
            this.f1076a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f1074e) {
            Iterator<n4> it = this.f1070a.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            this.f1074e = false;
        }
    }

    void b() {
        this.f1074e = false;
    }

    public h c(n4 n4Var) {
        if (!this.f1074e) {
            this.f1070a.add(n4Var);
        }
        return this;
    }

    public h d(n4 n4Var, n4 n4Var2) {
        this.f1070a.add(n4Var);
        n4Var2.w(n4Var.e());
        this.f1070a.add(n4Var2);
        return this;
    }

    public h e(long j7) {
        if (!this.f1074e) {
            this.f1071b = j7;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f1074e) {
            this.f1072c = interpolator;
        }
        return this;
    }

    public h g(o4 o4Var) {
        if (!this.f1074e) {
            this.f1073d = o4Var;
        }
        return this;
    }

    public void h() {
        if (this.f1074e) {
            return;
        }
        for (n4 n4Var : this.f1070a) {
            long j7 = this.f1071b;
            if (j7 >= 0) {
                n4Var.s(j7);
            }
            Interpolator interpolator = this.f1072c;
            if (interpolator != null) {
                n4Var.t(interpolator);
            }
            if (this.f1073d != null) {
                n4Var.u(this.f1075f);
            }
            n4Var.y();
        }
        this.f1074e = true;
    }
}
