package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import c.h1;
import c.o0;
import c.s0;
import c.x0;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, List<com.airbnb.lottie.model.layer.d>> f11771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, i> f11772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, com.airbnb.lottie.model.c> f11773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.airbnb.lottie.model.h> f11774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private androidx.collection.j<com.airbnb.lottie.model.d> f11775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private androidx.collection.f<com.airbnb.lottie.model.layer.d> f11776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<com.airbnb.lottie.model.layer.d> f11777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Rect f11778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f11779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f11780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f11781m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f11782n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f11769a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashSet<String> f11770b = new HashSet<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f11783o = 0;

    @Deprecated
    public static class b {

        private static final class a implements j<f>, com.airbnb.lottie.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final p f11784a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private boolean f11785b;

            @Override // com.airbnb.lottie.j
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(f fVar) {
                if (this.f11785b) {
                    return;
                }
                this.f11784a.a(fVar);
            }

            @Override // com.airbnb.lottie.b
            public void cancel() {
                this.f11785b = true;
            }

            private a(p pVar) {
                this.f11785b = false;
                this.f11784a = pVar;
            }
        }

        private b() {
        }

        @Deprecated
        public static com.airbnb.lottie.b a(Context context, String str, p pVar) {
            a aVar = new a(pVar);
            g.e(context, str).f(aVar);
            return aVar;
        }

        @h1
        @o0
        @Deprecated
        public static f b(Context context, String str) {
            return g.g(context, str).b();
        }

        @Deprecated
        public static com.airbnb.lottie.b c(InputStream inputStream, p pVar) {
            a aVar = new a(pVar);
            g.j(inputStream, null).f(aVar);
            return aVar;
        }

        @h1
        @o0
        @Deprecated
        public static f d(InputStream inputStream) {
            return g.k(inputStream, null).b();
        }

        @h1
        @o0
        @Deprecated
        public static f e(InputStream inputStream, boolean z7) {
            if (z7) {
                com.airbnb.lottie.utils.f.e("Lottie now auto-closes input stream!");
            }
            return g.k(inputStream, null).b();
        }

        @Deprecated
        public static com.airbnb.lottie.b f(com.airbnb.lottie.parser.moshi.c cVar, p pVar) {
            a aVar = new a(pVar);
            g.m(cVar, null).f(aVar);
            return aVar;
        }

        @Deprecated
        public static com.airbnb.lottie.b g(String str, p pVar) {
            a aVar = new a(pVar);
            g.p(str, null).f(aVar);
            return aVar;
        }

        @h1
        @o0
        @Deprecated
        public static f h(Resources resources, JSONObject jSONObject) {
            return g.r(jSONObject, null).b();
        }

        @h1
        @o0
        @Deprecated
        public static f i(com.airbnb.lottie.parser.moshi.c cVar) throws IOException {
            return g.n(cVar, null).b();
        }

        @h1
        @o0
        @Deprecated
        public static f j(String str) {
            return g.q(str, null).b();
        }

        @Deprecated
        public static com.airbnb.lottie.b k(Context context, @s0 int i7, p pVar) {
            a aVar = new a(pVar);
            g.s(context, i7).f(aVar);
            return aVar;
        }
    }

    @x0({x0.a.LIBRARY})
    public void a(String str) {
        com.airbnb.lottie.utils.f.e(str);
        this.f11770b.add(str);
    }

    public Rect b() {
        return this.f11778j;
    }

    public androidx.collection.j<com.airbnb.lottie.model.d> c() {
        return this.f11775g;
    }

    public float d() {
        return (long) ((e() / this.f11781m) * 1000.0f);
    }

    public float e() {
        return this.f11780l - this.f11779k;
    }

    @x0({x0.a.LIBRARY_GROUP})
    public float f() {
        return this.f11780l;
    }

    public Map<String, com.airbnb.lottie.model.c> g() {
        return this.f11773e;
    }

    public float h() {
        return this.f11781m;
    }

    public Map<String, i> i() {
        return this.f11772d;
    }

    public List<com.airbnb.lottie.model.layer.d> j() {
        return this.f11777i;
    }

    @o0
    public com.airbnb.lottie.model.h k(String str) {
        this.f11774f.size();
        for (int i7 = 0; i7 < this.f11774f.size(); i7++) {
            com.airbnb.lottie.model.h hVar = this.f11774f.get(i7);
            if (hVar.a(str)) {
                return hVar;
            }
        }
        return null;
    }

    public List<com.airbnb.lottie.model.h> l() {
        return this.f11774f;
    }

    @x0({x0.a.LIBRARY})
    public int m() {
        return this.f11783o;
    }

    public q n() {
        return this.f11769a;
    }

    @o0
    @x0({x0.a.LIBRARY})
    public List<com.airbnb.lottie.model.layer.d> o(String str) {
        return this.f11771c.get(str);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public float p() {
        return this.f11779k;
    }

    public ArrayList<String> q() {
        HashSet<String> hashSet = this.f11770b;
        return new ArrayList<>(Arrays.asList(hashSet.toArray(new String[hashSet.size()])));
    }

    @x0({x0.a.LIBRARY})
    public boolean r() {
        return this.f11782n;
    }

    public boolean s() {
        return !this.f11772d.isEmpty();
    }

    @x0({x0.a.LIBRARY})
    public void t(int i7) {
        this.f11783o += i7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.airbnb.lottie.model.layer.d> it = this.f11777i.iterator();
        while (it.hasNext()) {
            sb.append(it.next().w("\t"));
        }
        return sb.toString();
    }

    @x0({x0.a.LIBRARY})
    public void u(Rect rect, float f8, float f9, float f10, List<com.airbnb.lottie.model.layer.d> list, androidx.collection.f<com.airbnb.lottie.model.layer.d> fVar, Map<String, List<com.airbnb.lottie.model.layer.d>> map, Map<String, i> map2, androidx.collection.j<com.airbnb.lottie.model.d> jVar, Map<String, com.airbnb.lottie.model.c> map3, List<com.airbnb.lottie.model.h> list2) {
        this.f11778j = rect;
        this.f11779k = f8;
        this.f11780l = f9;
        this.f11781m = f10;
        this.f11777i = list;
        this.f11776h = fVar;
        this.f11771c = map;
        this.f11772d = map2;
        this.f11775g = jVar;
        this.f11773e = map3;
        this.f11774f = list2;
    }

    @x0({x0.a.LIBRARY})
    public com.airbnb.lottie.model.layer.d v(long j7) {
        return this.f11776h.m(j7);
    }

    @x0({x0.a.LIBRARY})
    public void w(boolean z7) {
        this.f11782n = z7;
    }

    public void x(boolean z7) {
        this.f11769a.g(z7);
    }
}
