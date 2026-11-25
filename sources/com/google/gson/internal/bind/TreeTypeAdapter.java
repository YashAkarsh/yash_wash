package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.internal.m;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.p;
import com.google.gson.s;
import com.google.gson.stream.d;
import com.google.gson.t;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class TreeTypeAdapter<T> extends x<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t<T> f23073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k<T> f23074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final f f23075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.gson.reflect.a<T> f23076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final y f23077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TreeTypeAdapter<T>.b f23078f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private x<T> f23079g;

    private static final class SingleTypeFactory implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.google.gson.reflect.a<?> f23080a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f23081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Class<?> f23082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final t<?> f23083d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final k<?> f23084e;

        SingleTypeFactory(Object obj, com.google.gson.reflect.a<?> aVar, boolean z7, Class<?> cls) {
            t<?> tVar = obj instanceof t ? (t) obj : null;
            this.f23083d = tVar;
            k<?> kVar = obj instanceof k ? (k) obj : null;
            this.f23084e = kVar;
            com.google.gson.internal.a.a((tVar == null && kVar == null) ? false : true);
            this.f23080a = aVar;
            this.f23081b = z7;
            this.f23082c = cls;
        }

        @Override // com.google.gson.y
        public <T> x<T> a(f fVar, com.google.gson.reflect.a<T> aVar) {
            boolean zIsAssignableFrom;
            com.google.gson.reflect.a<?> aVar2 = this.f23080a;
            if (aVar2 != null) {
                zIsAssignableFrom = aVar2.equals(aVar) || (this.f23081b && this.f23080a.getType() == aVar.getRawType());
            } else {
                zIsAssignableFrom = this.f23082c.isAssignableFrom(aVar.getRawType());
            }
            if (zIsAssignableFrom) {
                return new TreeTypeAdapter(this.f23083d, this.f23084e, fVar, aVar, this);
            }
            return null;
        }
    }

    private final class b implements s, j {
        private b() {
        }

        @Override // com.google.gson.j
        public <R> R a(l lVar, Type type) throws p {
            return (R) TreeTypeAdapter.this.f23075c.j(lVar, type);
        }

        @Override // com.google.gson.s
        public l b(Object obj, Type type) {
            return TreeTypeAdapter.this.f23075c.H(obj, type);
        }

        @Override // com.google.gson.s
        public l c(Object obj) {
            return TreeTypeAdapter.this.f23075c.G(obj);
        }
    }

    public TreeTypeAdapter(t<T> tVar, k<T> kVar, f fVar, com.google.gson.reflect.a<T> aVar, y yVar) {
        this.f23073a = tVar;
        this.f23074b = kVar;
        this.f23075c = fVar;
        this.f23076d = aVar;
        this.f23077e = yVar;
    }

    private x<T> j() {
        x<T> xVar = this.f23079g;
        if (xVar != null) {
            return xVar;
        }
        x<T> xVarR = this.f23075c.r(this.f23077e, this.f23076d);
        this.f23079g = xVarR;
        return xVarR;
    }

    public static y k(com.google.gson.reflect.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, false, null);
    }

    public static y l(com.google.gson.reflect.a<?> aVar, Object obj) {
        return new SingleTypeFactory(obj, aVar, aVar.getType() == aVar.getRawType(), null);
    }

    public static y m(Class<?> cls, Object obj) {
        return new SingleTypeFactory(obj, null, false, cls);
    }

    @Override // com.google.gson.x
    public T e(com.google.gson.stream.a aVar) throws IOException {
        if (this.f23074b == null) {
            return j().e(aVar);
        }
        l lVarA = m.a(aVar);
        if (lVarA.w()) {
            return null;
        }
        return this.f23074b.a(lVarA, this.f23076d.getType(), this.f23078f);
    }

    @Override // com.google.gson.x
    public void i(d dVar, T t7) throws IOException {
        t<T> tVar = this.f23073a;
        if (tVar == null) {
            j().i(dVar, t7);
        } else if (t7 == null) {
            dVar.g0();
        } else {
            m.b(tVar.a(t7, this.f23076d.getType(), this.f23078f), dVar);
        }
    }
}
