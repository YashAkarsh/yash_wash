package com.haier.library.okhttp;

import com.haier.uhome.account.api.Const;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final h0 f27540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f27541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final g0 f27542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    final g f27543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Map<Class<?>, Object> f27544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private volatile p f27545f;

    f(a aVar) {
        this.f27540a = aVar.f27546a;
        this.f27541b = aVar.f27547b;
        this.f27542c = aVar.f27548c.e();
        this.f27543d = aVar.f27549d;
        this.f27544e = n.d.o(aVar.f27550e);
    }

    public h0 a() {
        return this.f27540a;
    }

    @Nullable
    public <T> T b(Class<? extends T> cls) {
        return cls.cast(this.f27544e.get(cls));
    }

    @Nullable
    public String c(String str) {
        return this.f27542c.e(str);
    }

    public String d() {
        return this.f27541b;
    }

    public List<String> e(String str) {
        return this.f27542c.l(str);
    }

    public g0 f() {
        return this.f27542c;
    }

    @Nullable
    public g g() {
        return this.f27543d;
    }

    @Nullable
    public Object h() {
        return b(Object.class);
    }

    public a i() {
        return new a(this);
    }

    public p j() {
        p pVar = this.f27545f;
        if (pVar != null) {
            return pVar;
        }
        p pVarA = p.a(this.f27542c);
        this.f27545f = pVarA;
        return pVarA;
    }

    public boolean k() {
        return this.f27540a.w();
    }

    public String toString() {
        return "Request{method=" + this.f27541b + ", url=" + this.f27540a + ", tags=" + this.f27544e + '}';
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        h0 f27546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f27547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        g0.a f27548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        g f27549d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Map<Class<?>, Object> f27550e;

        public a() {
            this.f27550e = Collections.emptyMap();
            this.f27547b = Const.HTTP_REQUEST_TYPE_GET;
            this.f27548c = new g0.a();
        }

        public a a() {
            return i(Const.HTTP_REQUEST_TYPE_GET, null);
        }

        public a b(g gVar) {
            return i(Const.HTTP_REQUEST_TYPE_POST, gVar);
        }

        public a c(p pVar) {
            String string = pVar.toString();
            return string.isEmpty() ? n(com.google.common.net.c.f22132a) : j(com.google.common.net.c.f22132a, string);
        }

        public a d(g0 g0Var) {
            this.f27548c = g0Var.m();
            return this;
        }

        public a e(h0 h0Var) {
            if (h0Var == null) {
                throw new NullPointerException("url == null");
            }
            this.f27546a = h0Var;
            return this;
        }

        public <T> a f(Class<? super T> cls, @Nullable T t7) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            if (t7 == null) {
                this.f27550e.remove(cls);
            } else {
                if (this.f27550e.isEmpty()) {
                    this.f27550e = new LinkedHashMap();
                }
                this.f27550e.put(cls, cls.cast(t7));
            }
            return this;
        }

        public a g(@Nullable Object obj) {
            return f(Object.class, obj);
        }

        public a h(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return e(h0.D(str));
        }

        public a i(String str, @Nullable g gVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (gVar != null && !com.haier.library.okhttp.b.e.f.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (gVar != null || !com.haier.library.okhttp.b.e.f.b(str)) {
                this.f27547b = str;
                this.f27549d = gVar;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public a j(String str, String str2) {
            this.f27548c.k(str, str2);
            return this;
        }

        public a k(URL url) {
            if (url != null) {
                return e(h0.D(url.toString()));
            }
            throw new NullPointerException("url == null");
        }

        public a l() {
            return i("HEAD", null);
        }

        public a m(@Nullable g gVar) {
            return i("DELETE", gVar);
        }

        public a n(String str) {
            this.f27548c.i(str);
            return this;
        }

        public a o(String str, String str2) {
            this.f27548c.c(str, str2);
            return this;
        }

        public a p() {
            return m(n.d.f27689d);
        }

        public a q(g gVar) {
            return i("PUT", gVar);
        }

        public a r(g gVar) {
            return i(com.haier.globalwasher.mvp_api.volley.toolbox.h.a.f24990a, gVar);
        }

        public f s() {
            if (this.f27546a != null) {
                return new f(this);
            }
            throw new IllegalStateException("url == null");
        }

        a(f fVar) {
            this.f27550e = Collections.emptyMap();
            this.f27546a = fVar.f27540a;
            this.f27547b = fVar.f27541b;
            this.f27549d = fVar.f27543d;
            this.f27550e = fVar.f27544e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(fVar.f27544e);
            this.f27548c = fVar.f27542c.m();
        }
    }
}
