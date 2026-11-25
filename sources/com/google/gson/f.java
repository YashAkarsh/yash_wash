package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    static final boolean A = false;
    static final boolean B = false;
    private static final com.google.gson.reflect.a<?> C = com.google.gson.reflect.a.get(Object.class);
    private static final String D = ")]}'\n";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final boolean f22962v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final boolean f22963w = false;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final boolean f22964x = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final boolean f22965y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final boolean f22966z = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadLocal<Map<com.google.gson.reflect.a<?>, C0303f<?>>> f22967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.google.gson.reflect.a<?>, x<?>> f22968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.gson.internal.c f22969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f22970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<y> f22971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Excluder f22972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final com.google.gson.e f22973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Map<Type, h<?>> f22974h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f22975i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f22976j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f22977k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final boolean f22978l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final boolean f22979m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final boolean f22980n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final boolean f22981o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final String f22982p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final int f22983q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final int f22984r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final w f22985s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final List<y> f22986t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final List<y> f22987u;

    class a extends x<Number> {
        a() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Double e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return Double.valueOf(aVar.l0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.g0();
            } else {
                f.d(number.doubleValue());
                dVar.Q0(number);
            }
        }
    }

    class b extends x<Number> {
        b() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Float e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return Float.valueOf((float) aVar.l0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.g0();
            } else {
                f.d(number.floatValue());
                dVar.Q0(number);
            }
        }
    }

    class c extends x<Number> {
        c() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Number e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return Long.valueOf(aVar.p0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Number number) throws IOException {
            if (number == null) {
                dVar.g0();
            } else {
                dVar.T0(number.toString());
            }
        }
    }

    class d extends x<AtomicLong> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f22990a;

        d(x xVar) {
            this.f22990a = xVar;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public AtomicLong e(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicLong(((Number) this.f22990a.e(aVar)).longValue());
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, AtomicLong atomicLong) throws IOException {
            this.f22990a.i(dVar, Long.valueOf(atomicLong.get()));
        }
    }

    class e extends x<AtomicLongArray> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x f22991a;

        e(x xVar) {
            this.f22991a = xVar;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray e(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.b();
            while (aVar.H()) {
                arrayList.add(Long.valueOf(((Number) this.f22991a.e(aVar)).longValue()));
            }
            aVar.C();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i7 = 0; i7 < size; i7++) {
                atomicLongArray.set(i7, ((Long) arrayList.get(i7)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, AtomicLongArray atomicLongArray) throws IOException {
            dVar.q();
            int length = atomicLongArray.length();
            for (int i7 = 0; i7 < length; i7++) {
                this.f22991a.i(dVar, Long.valueOf(atomicLongArray.get(i7)));
            }
            dVar.u();
        }
    }

    /* JADX INFO: renamed from: com.google.gson.f$f, reason: collision with other inner class name */
    static class C0303f<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private x<T> f22992a;

        C0303f() {
        }

        @Override // com.google.gson.x
        public T e(com.google.gson.stream.a aVar) throws IOException {
            x<T> xVar = this.f22992a;
            if (xVar != null) {
                return xVar.e(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.google.gson.x
        public void i(com.google.gson.stream.d dVar, T t7) throws IOException {
            x<T> xVar = this.f22992a;
            if (xVar == null) {
                throw new IllegalStateException();
            }
            xVar.i(dVar, t7);
        }

        public void j(x<T> xVar) {
            if (this.f22992a != null) {
                throw new AssertionError();
            }
            this.f22992a = xVar;
        }
    }

    public f() {
        this(Excluder.f23011h, com.google.gson.d.f22955a, Collections.emptyMap(), false, false, false, true, false, false, false, w.f23310a, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    private static void a(Object obj, com.google.gson.stream.a aVar) {
        if (obj != null) {
            try {
                if (aVar.J0() == com.google.gson.stream.c.END_DOCUMENT) {
                } else {
                    throw new m("JSON document was not fully consumed.");
                }
            } catch (com.google.gson.stream.e e8) {
                throw new v(e8);
            } catch (IOException e9) {
                throw new m(e9);
            }
        }
    }

    private static x<AtomicLong> b(x<Number> xVar) {
        return new d(xVar).d();
    }

    private static x<AtomicLongArray> c(x<Number> xVar) {
        return new e(xVar).d();
    }

    static void d(double d8) {
        if (Double.isNaN(d8) || Double.isInfinite(d8)) {
            throw new IllegalArgumentException(d8 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private x<Number> e(boolean z7) {
        return z7 ? TypeAdapters.f23108v : new a();
    }

    private x<Number> h(boolean z7) {
        return z7 ? TypeAdapters.f23107u : new b();
    }

    private static x<Number> t(w wVar) {
        return wVar == w.f23310a ? TypeAdapters.f23106t : new c();
    }

    public String A(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        F(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void B(l lVar, com.google.gson.stream.d dVar) throws m {
        boolean zG = dVar.G();
        dVar.v0(true);
        boolean zF = dVar.F();
        dVar.r0(this.f22978l);
        boolean zE = dVar.E();
        dVar.x0(this.f22975i);
        try {
            try {
                com.google.gson.internal.m.b(lVar, dVar);
                dVar.v0(zG);
                dVar.r0(zF);
                dVar.x0(zE);
            } catch (IOException e8) {
                throw new m(e8);
            } catch (AssertionError e9) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e9.getMessage());
                assertionError.initCause(e9);
                throw assertionError;
            }
        } catch (Throwable th) {
            dVar.v0(zG);
            dVar.r0(zF);
            dVar.x0(zE);
            throw th;
        }
    }

    public void C(l lVar, Appendable appendable) throws m {
        try {
            B(lVar, w(com.google.gson.internal.m.c(appendable)));
        } catch (IOException e8) {
            throw new m(e8);
        }
    }

    public void D(Object obj, Appendable appendable) throws m {
        if (obj != null) {
            F(obj, obj.getClass(), appendable);
        } else {
            C(n.f23245a, appendable);
        }
    }

    public void E(Object obj, Type type, com.google.gson.stream.d dVar) throws m {
        x xVarP = p(com.google.gson.reflect.a.get(type));
        boolean zG = dVar.G();
        dVar.v0(true);
        boolean zF = dVar.F();
        dVar.r0(this.f22978l);
        boolean zE = dVar.E();
        dVar.x0(this.f22975i);
        try {
            try {
                xVarP.i(dVar, obj);
                dVar.v0(zG);
                dVar.r0(zF);
                dVar.x0(zE);
            } catch (IOException e8) {
                throw new m(e8);
            } catch (AssertionError e9) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e9.getMessage());
                assertionError.initCause(e9);
                throw assertionError;
            }
        } catch (Throwable th) {
            dVar.v0(zG);
            dVar.r0(zF);
            dVar.x0(zE);
            throw th;
        }
    }

    public void F(Object obj, Type type, Appendable appendable) throws m {
        try {
            E(obj, type, w(com.google.gson.internal.m.c(appendable)));
        } catch (IOException e8) {
            throw new m(e8);
        }
    }

    public l G(Object obj) {
        return obj == null ? n.f23245a : H(obj, obj.getClass());
    }

    public l H(Object obj, Type type) {
        com.google.gson.internal.bind.b bVar = new com.google.gson.internal.bind.b();
        E(obj, type, bVar);
        return bVar.a1();
    }

    public Excluder f() {
        return this.f22972f;
    }

    public com.google.gson.e g() {
        return this.f22973g;
    }

    public <T> T i(l lVar, Class<T> cls) throws v {
        return (T) com.google.gson.internal.l.d(cls).cast(j(lVar, cls));
    }

    public <T> T j(l lVar, Type type) throws v {
        if (lVar == null) {
            return null;
        }
        return (T) k(new com.google.gson.internal.bind.a(lVar), type);
    }

    public <T> T k(com.google.gson.stream.a aVar, Type type) throws v, m {
        boolean zK = aVar.K();
        boolean z7 = true;
        aVar.Y0(true);
        try {
            try {
                try {
                    aVar.J0();
                    z7 = false;
                    T tE = p(com.google.gson.reflect.a.get(type)).e(aVar);
                    aVar.Y0(zK);
                    return tE;
                } catch (AssertionError e8) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.6): " + e8.getMessage());
                    assertionError.initCause(e8);
                    throw assertionError;
                } catch (IllegalStateException e9) {
                    throw new v(e9);
                }
            } catch (EOFException e10) {
                if (!z7) {
                    throw new v(e10);
                }
                aVar.Y0(zK);
                return null;
            } catch (IOException e11) {
                throw new v(e11);
            }
        } catch (Throwable th) {
            aVar.Y0(zK);
            throw th;
        }
    }

    public <T> T l(Reader reader, Class<T> cls) throws v, m {
        com.google.gson.stream.a aVarV = v(reader);
        Object objK = k(aVarV, cls);
        a(objK, aVarV);
        return (T) com.google.gson.internal.l.d(cls).cast(objK);
    }

    public <T> T m(Reader reader, Type type) throws v, m {
        com.google.gson.stream.a aVarV = v(reader);
        T t7 = (T) k(aVarV, type);
        a(t7, aVarV);
        return t7;
    }

    public <T> T n(String str, Class<T> cls) throws v {
        return (T) com.google.gson.internal.l.d(cls).cast(o(str, cls));
    }

    public <T> T o(String str, Type type) throws v {
        if (str == null) {
            return null;
        }
        return (T) m(new StringReader(str), type);
    }

    public <T> x<T> p(com.google.gson.reflect.a<T> aVar) {
        boolean z7;
        x<T> xVar = (x) this.f22968b.get(aVar == null ? C : aVar);
        if (xVar != null) {
            return xVar;
        }
        Map<com.google.gson.reflect.a<?>, C0303f<?>> map = this.f22967a.get();
        if (map == null) {
            map = new HashMap<>();
            this.f22967a.set(map);
            z7 = true;
        } else {
            z7 = false;
        }
        C0303f<?> c0303f = map.get(aVar);
        if (c0303f != null) {
            return c0303f;
        }
        try {
            C0303f<?> c0303f2 = new C0303f<>();
            map.put(aVar, c0303f2);
            Iterator<y> it = this.f22971e.iterator();
            while (it.hasNext()) {
                x<T> xVarA = it.next().a(this, aVar);
                if (xVarA != null) {
                    c0303f2.j(xVarA);
                    this.f22968b.put(aVar, xVarA);
                    map.remove(aVar);
                    if (z7) {
                        this.f22967a.remove();
                    }
                    return xVarA;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + aVar);
        } catch (Throwable th) {
            map.remove(aVar);
            if (z7) {
                this.f22967a.remove();
            }
            throw th;
        }
    }

    public <T> x<T> q(Class<T> cls) {
        return p(com.google.gson.reflect.a.get((Class) cls));
    }

    public <T> x<T> r(y yVar, com.google.gson.reflect.a<T> aVar) {
        if (!this.f22971e.contains(yVar)) {
            yVar = this.f22970d;
        }
        boolean z7 = false;
        for (y yVar2 : this.f22971e) {
            if (z7) {
                x<T> xVarA = yVar2.a(this, aVar);
                if (xVarA != null) {
                    return xVarA;
                }
            } else if (yVar2 == yVar) {
                z7 = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public boolean s() {
        return this.f22978l;
    }

    public String toString() {
        return "{serializeNulls:" + this.f22975i + ",factories:" + this.f22971e + ",instanceCreators:" + this.f22969c + com.alipay.sdk.util.j.f13808d;
    }

    public g u() {
        return new g(this);
    }

    public com.google.gson.stream.a v(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.Y0(this.f22980n);
        return aVar;
    }

    public com.google.gson.stream.d w(Writer writer) throws IOException {
        if (this.f22977k) {
            writer.write(D);
        }
        com.google.gson.stream.d dVar = new com.google.gson.stream.d(writer);
        if (this.f22979m) {
            dVar.s0("  ");
        }
        dVar.x0(this.f22975i);
        return dVar;
    }

    public boolean x() {
        return this.f22975i;
    }

    public String y(l lVar) {
        StringWriter stringWriter = new StringWriter();
        C(lVar, stringWriter);
        return stringWriter.toString();
    }

    public String z(Object obj) {
        return obj == null ? y(n.f23245a) : A(obj, obj.getClass());
    }

    f(Excluder excluder, com.google.gson.e eVar, Map<Type, h<?>> map, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, w wVar, String str, int i7, int i8, List<y> list, List<y> list2, List<y> list3) {
        this.f22967a = new ThreadLocal<>();
        this.f22968b = new ConcurrentHashMap();
        this.f22972f = excluder;
        this.f22973g = eVar;
        this.f22974h = map;
        com.google.gson.internal.c cVar = new com.google.gson.internal.c(map);
        this.f22969c = cVar;
        this.f22975i = z7;
        this.f22976j = z8;
        this.f22977k = z9;
        this.f22978l = z10;
        this.f22979m = z11;
        this.f22980n = z12;
        this.f22981o = z13;
        this.f22985s = wVar;
        this.f22982p = str;
        this.f22983q = i7;
        this.f22984r = i8;
        this.f22986t = list;
        this.f22987u = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.Y);
        arrayList.add(ObjectTypeAdapter.f23049b);
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.D);
        arrayList.add(TypeAdapters.f23099m);
        arrayList.add(TypeAdapters.f23093g);
        arrayList.add(TypeAdapters.f23095i);
        arrayList.add(TypeAdapters.f23097k);
        x<Number> xVarT = t(wVar);
        arrayList.add(TypeAdapters.c(Long.TYPE, Long.class, xVarT));
        arrayList.add(TypeAdapters.c(Double.TYPE, Double.class, e(z13)));
        arrayList.add(TypeAdapters.c(Float.TYPE, Float.class, h(z13)));
        arrayList.add(TypeAdapters.f23110x);
        arrayList.add(TypeAdapters.f23101o);
        arrayList.add(TypeAdapters.f23103q);
        arrayList.add(TypeAdapters.b(AtomicLong.class, b(xVarT)));
        arrayList.add(TypeAdapters.b(AtomicLongArray.class, c(xVarT)));
        arrayList.add(TypeAdapters.f23105s);
        arrayList.add(TypeAdapters.f23112z);
        arrayList.add(TypeAdapters.F);
        arrayList.add(TypeAdapters.H);
        arrayList.add(TypeAdapters.b(BigDecimal.class, TypeAdapters.B));
        arrayList.add(TypeAdapters.b(BigInteger.class, TypeAdapters.C));
        arrayList.add(TypeAdapters.f23086J);
        arrayList.add(TypeAdapters.L);
        arrayList.add(TypeAdapters.P);
        arrayList.add(TypeAdapters.R);
        arrayList.add(TypeAdapters.W);
        arrayList.add(TypeAdapters.N);
        arrayList.add(TypeAdapters.f23090d);
        arrayList.add(DateTypeAdapter.f23040b);
        arrayList.add(TypeAdapters.U);
        arrayList.add(TimeTypeAdapter.f23071b);
        arrayList.add(SqlDateTypeAdapter.f23069b);
        arrayList.add(TypeAdapters.S);
        arrayList.add(ArrayTypeAdapter.f23034c);
        arrayList.add(TypeAdapters.f23088b);
        arrayList.add(new CollectionTypeAdapterFactory(cVar));
        arrayList.add(new MapTypeAdapterFactory(cVar, z8));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(cVar);
        this.f22970d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.Z);
        arrayList.add(new ReflectiveTypeAdapterFactory(cVar, eVar, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.f22971e = Collections.unmodifiableList(arrayList);
    }
}
