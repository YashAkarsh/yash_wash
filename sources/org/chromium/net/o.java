package org.chromium.net;

import android.content.Context;
import c.g1;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f39472b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f39473c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39474d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f39475e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f39476f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f39477g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f39478h = 5;

    public static class a extends j.a {
        public a(Context context) {
            super(context);
        }

        public a A(String str) {
            this.f39443a.l(str);
            return this;
        }

        @Override // org.chromium.net.j.a
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public a n(j.a.b bVar) {
            super.n(bVar);
            return this;
        }

        @Override // org.chromium.net.j.a
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public a o(String str) {
            super.o(str);
            return this;
        }

        public a D(int i7) {
            this.f39443a.o(i7);
            return this;
        }

        @Override // org.chromium.net.j.a
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public a p(String str) {
            super.p(str);
            return this;
        }

        @Override // org.chromium.net.j.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a a(String str, Set<byte[]> set, boolean z7, Date date) {
            super.a(str, set, z7, date);
            return this;
        }

        @Override // org.chromium.net.j.a
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a b(String str, int i7, int i8) {
            super.b(str, i7, i8);
            return this;
        }

        @Override // org.chromium.net.j.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public o c() {
            return this.f39443a.c();
        }

        @Override // org.chromium.net.j.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public a g(boolean z7) {
            super.g(z7);
            return this;
        }

        @Override // org.chromium.net.j.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public a h(int i7, long j7) {
            super.h(i7, j7);
            return this;
        }

        public a v(boolean z7) {
            this.f39443a.g(z7);
            return this;
        }

        @Override // org.chromium.net.j.a
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public a i(boolean z7) {
            super.i(z7);
            return this;
        }

        @Override // org.chromium.net.j.a
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public a j(boolean z7) {
            super.j(z7);
            return this;
        }

        @Override // org.chromium.net.j.a
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public a k(boolean z7) {
            return this;
        }

        @g1
        public s z() {
            return this.f39443a;
        }

        public a(s sVar) {
            super(sVar);
        }
    }

    public void j(k0.a aVar) {
    }

    public void k(b0 b0Var) {
    }

    public void l(c0 c0Var) {
    }

    public void m(boolean z7, boolean z8, boolean z9) {
    }

    public int n() {
        return -1;
    }

    public int o() {
        return 0;
    }

    public int p() {
        return -1;
    }

    public int q() {
        return -1;
    }

    public abstract n.a r(String str, d.b bVar, Executor executor);

    @Override // org.chromium.net.j
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public abstract p.a e(String str, t0.b bVar, Executor executor);

    public URLConnection t(URL url, Proxy proxy) throws IOException {
        return url.openConnection(proxy);
    }

    public void u(k0.a aVar) {
    }

    public void v(b0 b0Var) {
    }

    public void w(c0 c0Var) {
    }

    public void x(String str, boolean z7, int i7) {
    }
}
