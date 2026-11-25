package com.google.gson.internal.bind;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes2.dex */
public final class TypeAdapters {
    public static final com.google.gson.x<String> A;
    public static final com.google.gson.x<BigDecimal> B;
    public static final com.google.gson.x<BigInteger> C;
    public static final com.google.gson.y D;
    public static final com.google.gson.x<StringBuilder> E;
    public static final com.google.gson.y F;
    public static final com.google.gson.x<StringBuffer> G;
    public static final com.google.gson.y H;
    public static final com.google.gson.x<URL> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final com.google.gson.y f23086J;
    public static final com.google.gson.x<URI> K;
    public static final com.google.gson.y L;
    public static final com.google.gson.x<InetAddress> M;
    public static final com.google.gson.y N;
    public static final com.google.gson.x<UUID> O;
    public static final com.google.gson.y P;
    public static final com.google.gson.x<Currency> Q;
    public static final com.google.gson.y R;
    public static final com.google.gson.y S;
    public static final com.google.gson.x<Calendar> T;
    public static final com.google.gson.y U;
    public static final com.google.gson.x<Locale> V;
    public static final com.google.gson.y W;
    public static final com.google.gson.x<com.google.gson.l> X;
    public static final com.google.gson.y Y;
    public static final com.google.gson.y Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.gson.x<Class> f23087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.google.gson.y f23088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.gson.x<BitSet> f23089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.google.gson.y f23090d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.google.gson.x<Boolean> f23091e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.google.gson.x<Boolean> f23092f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.google.gson.y f23093g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.google.gson.x<Number> f23094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final com.google.gson.y f23095i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final com.google.gson.x<Number> f23096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final com.google.gson.y f23097k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final com.google.gson.x<Number> f23098l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final com.google.gson.y f23099m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final com.google.gson.x<AtomicInteger> f23100n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final com.google.gson.y f23101o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final com.google.gson.x<AtomicBoolean> f23102p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final com.google.gson.y f23103q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final com.google.gson.x<AtomicIntegerArray> f23104r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final com.google.gson.y f23105s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final com.google.gson.x<Number> f23106t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final com.google.gson.x<Number> f23107u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final com.google.gson.x<Number> f23108v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final com.google.gson.x<Number> f23109w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final com.google.gson.y f23110x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final com.google.gson.x<Character> f23111y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final com.google.gson.y f23112z;

    class a extends com.google.gson.x<AtomicIntegerArray> {
        a() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public AtomicIntegerArray e(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.b();
            while (aVar.H()) {
                try {
                    arrayList.add(Integer.valueOf(aVar.o0()));
                } catch (NumberFormatException e8) {
                    throw new com.google.gson.v(e8);
                }
            }
            aVar.C();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i7 = 0; i7 < size; i7++) {
                atomicIntegerArray.set(i7, ((Integer) arrayList.get(i7)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
            dVar.q();
            int length = atomicIntegerArray.length();
            for (int i7 = 0; i7 < length; i7++) {
                dVar.J0(atomicIntegerArray.get(i7));
            }
            dVar.u();
        }
    }

    class a0 extends com.google.gson.x<Number> {
        a0() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Number e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            try {
                return Integer.valueOf(aVar.o0());
            } catch (NumberFormatException e8) {
                throw new com.google.gson.v(e8);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Number number) throws IOException {
            dVar.Q0(number);
        }
    }

    class b extends com.google.gson.x<Number> {
        b() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Number e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            try {
                return Long.valueOf(aVar.p0());
            } catch (NumberFormatException e8) {
                throw new com.google.gson.v(e8);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Number number) throws IOException {
            dVar.Q0(number);
        }
    }

    class b0 extends com.google.gson.x<AtomicInteger> {
        b0() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public AtomicInteger e(com.google.gson.stream.a aVar) throws IOException {
            try {
                return new AtomicInteger(aVar.o0());
            } catch (NumberFormatException e8) {
                throw new com.google.gson.v(e8);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, AtomicInteger atomicInteger) throws IOException {
            dVar.J0(atomicInteger.get());
        }
    }

    class c extends com.google.gson.x<Number> {
        c() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Number e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return Float.valueOf((float) aVar.l0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Number number) throws IOException {
            dVar.Q0(number);
        }
    }

    class c0 extends com.google.gson.x<AtomicBoolean> {
        c0() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public AtomicBoolean e(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicBoolean(aVar.h0());
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, AtomicBoolean atomicBoolean) throws IOException {
            dVar.V0(atomicBoolean.get());
        }
    }

    class d extends com.google.gson.x<Number> {
        d() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Number e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return Double.valueOf(aVar.l0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Number number) throws IOException {
            dVar.Q0(number);
        }
    }

    private static final class d0<T extends Enum<T>> extends com.google.gson.x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, T> f23129a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<T, String> f23130b = new HashMap();

        public d0(Class<T> cls) {
            try {
                for (T t7 : cls.getEnumConstants()) {
                    String strName = t7.name();
                    w1.c cVar = (w1.c) cls.getField(strName).getAnnotation(w1.c.class);
                    if (cVar != null) {
                        strName = cVar.value();
                        for (String str : cVar.alternate()) {
                            this.f23129a.put(str, t7);
                        }
                    }
                    this.f23129a.put(strName, t7);
                    this.f23130b.put(t7, strName);
                }
            } catch (NoSuchFieldException e8) {
                throw new AssertionError(e8);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public T e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return this.f23129a.get(aVar.G0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, T t7) throws IOException {
            dVar.T0(t7 == null ? null : this.f23130b.get(t7));
        }
    }

    class e extends com.google.gson.x<Number> {
        e() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Number e(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.c cVarJ0 = aVar.J0();
            int i7 = v.f23137a[cVarJ0.ordinal()];
            if (i7 == 1 || i7 == 3) {
                return new com.google.gson.internal.g(aVar.G0());
            }
            if (i7 == 4) {
                aVar.v0();
                return null;
            }
            throw new com.google.gson.v("Expecting number, got: " + cVarJ0);
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Number number) throws IOException {
            dVar.Q0(number);
        }
    }

    class f extends com.google.gson.x<Character> {
        f() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Character e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            String strG0 = aVar.G0();
            if (strG0.length() == 1) {
                return Character.valueOf(strG0.charAt(0));
            }
            throw new com.google.gson.v("Expecting character, got: " + strG0);
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Character ch) throws IOException {
            dVar.T0(ch == null ? null : String.valueOf(ch));
        }
    }

    class g extends com.google.gson.x<String> {
        g() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public String e(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.c cVarJ0 = aVar.J0();
            if (cVarJ0 != com.google.gson.stream.c.NULL) {
                return cVarJ0 == com.google.gson.stream.c.BOOLEAN ? Boolean.toString(aVar.h0()) : aVar.G0();
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, String str) throws IOException {
            dVar.T0(str);
        }
    }

    class h extends com.google.gson.x<BigDecimal> {
        h() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public BigDecimal e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            try {
                return new BigDecimal(aVar.G0());
            } catch (NumberFormatException e8) {
                throw new com.google.gson.v(e8);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, BigDecimal bigDecimal) throws IOException {
            dVar.Q0(bigDecimal);
        }
    }

    class i extends com.google.gson.x<BigInteger> {
        i() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public BigInteger e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            try {
                return new BigInteger(aVar.G0());
            } catch (NumberFormatException e8) {
                throw new com.google.gson.v(e8);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, BigInteger bigInteger) throws IOException {
            dVar.Q0(bigInteger);
        }
    }

    class j extends com.google.gson.x<StringBuilder> {
        j() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public StringBuilder e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return new StringBuilder(aVar.G0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, StringBuilder sb) throws IOException {
            dVar.T0(sb == null ? null : sb.toString());
        }
    }

    class k extends com.google.gson.x<Class> {
        k() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Class e(com.google.gson.stream.a aVar) throws IOException {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Class cls) throws IOException {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
        }
    }

    class l extends com.google.gson.x<StringBuffer> {
        l() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public StringBuffer e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return new StringBuffer(aVar.G0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, StringBuffer stringBuffer) throws IOException {
            dVar.T0(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    class m extends com.google.gson.x<URL> {
        m() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public URL e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            String strG0 = aVar.G0();
            if ("null".equals(strG0)) {
                return null;
            }
            return new URL(strG0);
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, URL url) throws IOException {
            dVar.T0(url == null ? null : url.toExternalForm());
        }
    }

    class n extends com.google.gson.x<URI> {
        n() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public URI e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            try {
                String strG0 = aVar.G0();
                if ("null".equals(strG0)) {
                    return null;
                }
                return new URI(strG0);
            } catch (URISyntaxException e8) {
                throw new com.google.gson.m(e8);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, URI uri) throws IOException {
            dVar.T0(uri == null ? null : uri.toASCIIString());
        }
    }

    class o extends com.google.gson.x<InetAddress> {
        o() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public InetAddress e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return InetAddress.getByName(aVar.G0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, InetAddress inetAddress) throws IOException {
            dVar.T0(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    class p extends com.google.gson.x<UUID> {
        p() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public UUID e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return UUID.fromString(aVar.G0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, UUID uuid) throws IOException {
            dVar.T0(uuid == null ? null : uuid.toString());
        }
    }

    class q extends com.google.gson.x<Currency> {
        q() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Currency e(com.google.gson.stream.a aVar) throws IOException {
            return Currency.getInstance(aVar.G0());
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Currency currency) throws IOException {
            dVar.T0(currency.getCurrencyCode());
        }
    }

    class r extends com.google.gson.x<Calendar> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f23131a = "year";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String f23132b = "month";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f23133c = "dayOfMonth";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final String f23134d = "hourOfDay";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final String f23135e = "minute";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final String f23136f = "second";

        r() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Calendar e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            aVar.e();
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (aVar.J0() != com.google.gson.stream.c.END_OBJECT) {
                String strR0 = aVar.r0();
                int iO0 = aVar.o0();
                if (f23131a.equals(strR0)) {
                    i7 = iO0;
                } else if (f23132b.equals(strR0)) {
                    i8 = iO0;
                } else if (f23133c.equals(strR0)) {
                    i9 = iO0;
                } else if (f23134d.equals(strR0)) {
                    i10 = iO0;
                } else if (f23135e.equals(strR0)) {
                    i11 = iO0;
                } else if (f23136f.equals(strR0)) {
                    i12 = iO0;
                }
            }
            aVar.E();
            return new GregorianCalendar(i7, i8, i9, i10, i11, i12);
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Calendar calendar) throws IOException {
            if (calendar == null) {
                dVar.g0();
                return;
            }
            dVar.r();
            dVar.K(f23131a);
            dVar.J0(calendar.get(1));
            dVar.K(f23132b);
            dVar.J0(calendar.get(2));
            dVar.K(f23133c);
            dVar.J0(calendar.get(5));
            dVar.K(f23134d);
            dVar.J0(calendar.get(11));
            dVar.K(f23135e);
            dVar.J0(calendar.get(12));
            dVar.K(f23136f);
            dVar.J0(calendar.get(13));
            dVar.C();
        }
    }

    class s extends com.google.gson.x<Locale> {
        s() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Locale e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(aVar.G0(), "_");
            String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (strNextToken2 == null && strNextToken3 == null) {
                return new Locale(strNextToken);
            }
            return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Locale locale) throws IOException {
            dVar.T0(locale == null ? null : locale.toString());
        }
    }

    class t extends com.google.gson.x<com.google.gson.l> {
        t() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public com.google.gson.l e(com.google.gson.stream.a aVar) throws IOException {
            switch (v.f23137a[aVar.J0().ordinal()]) {
                case 1:
                    return new com.google.gson.r(new com.google.gson.internal.g(aVar.G0()));
                case 2:
                    return new com.google.gson.r(Boolean.valueOf(aVar.h0()));
                case 3:
                    return new com.google.gson.r(aVar.G0());
                case 4:
                    aVar.v0();
                    return com.google.gson.n.f23245a;
                case 5:
                    com.google.gson.i iVar = new com.google.gson.i();
                    aVar.b();
                    while (aVar.H()) {
                        iVar.A(e(aVar));
                    }
                    aVar.C();
                    return iVar;
                case 6:
                    com.google.gson.o oVar = new com.google.gson.o();
                    aVar.e();
                    while (aVar.H()) {
                        oVar.A(aVar.r0(), e(aVar));
                    }
                    aVar.E();
                    return oVar;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, com.google.gson.l lVar) throws IOException {
            if (lVar == null || lVar.w()) {
                dVar.g0();
                return;
            }
            if (lVar.z()) {
                com.google.gson.r rVarP = lVar.p();
                if (rVarP.F()) {
                    dVar.Q0(rVarP.s());
                    return;
                } else if (rVarP.B()) {
                    dVar.V0(rVarP.f());
                    return;
                } else {
                    dVar.T0(rVarP.u());
                    return;
                }
            }
            if (lVar.v()) {
                dVar.q();
                Iterator<com.google.gson.l> it = lVar.m().iterator();
                while (it.hasNext()) {
                    i(dVar, it.next());
                }
                dVar.u();
                return;
            }
            if (!lVar.x()) {
                throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
            }
            dVar.r();
            for (Map.Entry<String, com.google.gson.l> entry : lVar.o().entrySet()) {
                dVar.K(entry.getKey());
                i(dVar, entry.getValue());
            }
            dVar.C();
        }
    }

    class u extends com.google.gson.x<BitSet> {
        u() {
        }

        /* JADX WARN: Code duplicated, block: B:15:0x002e  */
        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public BitSet e(com.google.gson.stream.a aVar) throws IOException {
            BitSet bitSet = new BitSet();
            aVar.b();
            com.google.gson.stream.c cVarJ0 = aVar.J0();
            int i7 = 0;
            while (cVarJ0 != com.google.gson.stream.c.END_ARRAY) {
                int i8 = v.f23137a[cVarJ0.ordinal()];
                boolean zH0 = true;
                if (i8 != 1) {
                    if (i8 == 2) {
                        zH0 = aVar.h0();
                    } else {
                        if (i8 != 3) {
                            throw new com.google.gson.v("Invalid bitset value type: " + cVarJ0);
                        }
                        String strG0 = aVar.G0();
                        try {
                            if (Integer.parseInt(strG0) == 0) {
                                zH0 = false;
                            }
                        } catch (NumberFormatException unused) {
                            throw new com.google.gson.v("Error: Expecting: bitset number value (1, 0), Found: " + strG0);
                        }
                    }
                } else if (aVar.o0() == 0) {
                    zH0 = false;
                }
                if (zH0) {
                    bitSet.set(i7);
                }
                i7++;
                cVarJ0 = aVar.J0();
            }
            aVar.C();
            return bitSet;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, BitSet bitSet) throws IOException {
            dVar.q();
            int length = bitSet.length();
            for (int i7 = 0; i7 < length; i7++) {
                dVar.J0(bitSet.get(i7) ? 1L : 0L);
            }
            dVar.u();
        }
    }

    static /* synthetic */ class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23137a;

        static {
            int[] iArr = new int[com.google.gson.stream.c.values().length];
            f23137a = iArr;
            try {
                iArr[com.google.gson.stream.c.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23137a[com.google.gson.stream.c.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23137a[com.google.gson.stream.c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23137a[com.google.gson.stream.c.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23137a[com.google.gson.stream.c.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23137a[com.google.gson.stream.c.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f23137a[com.google.gson.stream.c.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f23137a[com.google.gson.stream.c.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f23137a[com.google.gson.stream.c.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f23137a[com.google.gson.stream.c.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    class w extends com.google.gson.x<Boolean> {
        w() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Boolean e(com.google.gson.stream.a aVar) throws IOException {
            com.google.gson.stream.c cVarJ0 = aVar.J0();
            if (cVarJ0 != com.google.gson.stream.c.NULL) {
                return cVarJ0 == com.google.gson.stream.c.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.G0())) : Boolean.valueOf(aVar.h0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Boolean bool) throws IOException {
            dVar.L0(bool);
        }
    }

    class x extends com.google.gson.x<Boolean> {
        x() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Boolean e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() != com.google.gson.stream.c.NULL) {
                return Boolean.valueOf(aVar.G0());
            }
            aVar.v0();
            return null;
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Boolean bool) throws IOException {
            dVar.T0(bool == null ? "null" : bool.toString());
        }
    }

    class y extends com.google.gson.x<Number> {
        y() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Number e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            try {
                return Byte.valueOf((byte) aVar.o0());
            } catch (NumberFormatException e8) {
                throw new com.google.gson.v(e8);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Number number) throws IOException {
            dVar.Q0(number);
        }
    }

    class z extends com.google.gson.x<Number> {
        z() {
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Number e(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.J0() == com.google.gson.stream.c.NULL) {
                aVar.v0();
                return null;
            }
            try {
                return Short.valueOf((short) aVar.o0());
            } catch (NumberFormatException e8) {
                throw new com.google.gson.v(e8);
            }
        }

        @Override // com.google.gson.x
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void i(com.google.gson.stream.d dVar, Number number) throws IOException {
            dVar.Q0(number);
        }
    }

    static {
        com.google.gson.x<Class> xVarD = new k().d();
        f23087a = xVarD;
        f23088b = b(Class.class, xVarD);
        com.google.gson.x<BitSet> xVarD2 = new u().d();
        f23089c = xVarD2;
        f23090d = b(BitSet.class, xVarD2);
        w wVar = new w();
        f23091e = wVar;
        f23092f = new x();
        f23093g = c(Boolean.TYPE, Boolean.class, wVar);
        y yVar = new y();
        f23094h = yVar;
        f23095i = c(Byte.TYPE, Byte.class, yVar);
        z zVar = new z();
        f23096j = zVar;
        f23097k = c(Short.TYPE, Short.class, zVar);
        a0 a0Var = new a0();
        f23098l = a0Var;
        f23099m = c(Integer.TYPE, Integer.class, a0Var);
        com.google.gson.x<AtomicInteger> xVarD3 = new b0().d();
        f23100n = xVarD3;
        f23101o = b(AtomicInteger.class, xVarD3);
        com.google.gson.x<AtomicBoolean> xVarD4 = new c0().d();
        f23102p = xVarD4;
        f23103q = b(AtomicBoolean.class, xVarD4);
        com.google.gson.x<AtomicIntegerArray> xVarD5 = new a().d();
        f23104r = xVarD5;
        f23105s = b(AtomicIntegerArray.class, xVarD5);
        f23106t = new b();
        f23107u = new c();
        f23108v = new d();
        e eVar = new e();
        f23109w = eVar;
        f23110x = b(Number.class, eVar);
        f fVar = new f();
        f23111y = fVar;
        f23112z = c(Character.TYPE, Character.class, fVar);
        g gVar = new g();
        A = gVar;
        B = new h();
        C = new i();
        D = b(String.class, gVar);
        j jVar = new j();
        E = jVar;
        F = b(StringBuilder.class, jVar);
        l lVar = new l();
        G = lVar;
        H = b(StringBuffer.class, lVar);
        m mVar = new m();
        I = mVar;
        f23086J = b(URL.class, mVar);
        n nVar = new n();
        K = nVar;
        L = b(URI.class, nVar);
        o oVar = new o();
        M = oVar;
        N = e(InetAddress.class, oVar);
        p pVar = new p();
        O = pVar;
        P = b(UUID.class, pVar);
        com.google.gson.x<Currency> xVarD6 = new q().d();
        Q = xVarD6;
        R = b(Currency.class, xVarD6);
        S = new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters.26

            /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$26$a */
            class a extends com.google.gson.x<Timestamp> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ com.google.gson.x f23113a;

                a(com.google.gson.x xVar) {
                    this.f23113a = xVar;
                }

                @Override // com.google.gson.x
                /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
                public Timestamp e(com.google.gson.stream.a aVar) throws IOException {
                    Date date = (Date) this.f23113a.e(aVar);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.gson.x
                /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
                public void i(com.google.gson.stream.d dVar, Timestamp timestamp) throws IOException {
                    this.f23113a.i(dVar, timestamp);
                }
            }

            @Override // com.google.gson.y
            public <T> com.google.gson.x<T> a(com.google.gson.f fVar2, com.google.gson.reflect.a<T> aVar) {
                if (aVar.getRawType() != Timestamp.class) {
                    return null;
                }
                return new a(fVar2.q(Date.class));
            }
        };
        r rVar = new r();
        T = rVar;
        U = d(Calendar.class, GregorianCalendar.class, rVar);
        s sVar = new s();
        V = sVar;
        W = b(Locale.class, sVar);
        t tVar = new t();
        X = tVar;
        Y = e(com.google.gson.l.class, tVar);
        Z = new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            @Override // com.google.gson.y
            public <T> com.google.gson.x<T> a(com.google.gson.f fVar2, com.google.gson.reflect.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new d0(rawType);
            }
        };
    }

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    public static <TT> com.google.gson.y a(final com.google.gson.reflect.a<TT> aVar, final com.google.gson.x<TT> xVar) {
        return new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // com.google.gson.y
            public <T> com.google.gson.x<T> a(com.google.gson.f fVar, com.google.gson.reflect.a<T> aVar2) {
                if (aVar2.equals(aVar)) {
                    return xVar;
                }
                return null;
            }
        };
    }

    public static <TT> com.google.gson.y b(final Class<TT> cls, final com.google.gson.x<TT> xVar) {
        return new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            @Override // com.google.gson.y
            public <T> com.google.gson.x<T> a(com.google.gson.f fVar, com.google.gson.reflect.a<T> aVar) {
                if (aVar.getRawType() == cls) {
                    return xVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + xVar + "]";
            }
        };
    }

    public static <TT> com.google.gson.y c(final Class<TT> cls, final Class<TT> cls2, final com.google.gson.x<? super TT> xVar) {
        return new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            @Override // com.google.gson.y
            public <T> com.google.gson.x<T> a(com.google.gson.f fVar, com.google.gson.reflect.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return xVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + xVar + "]";
            }
        };
    }

    public static <TT> com.google.gson.y d(final Class<TT> cls, final Class<? extends TT> cls2, final com.google.gson.x<? super TT> xVar) {
        return new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // com.google.gson.y
            public <T> com.google.gson.x<T> a(com.google.gson.f fVar, com.google.gson.reflect.a<T> aVar) {
                Class<? super T> rawType = aVar.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return xVar;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + xVar + "]";
            }
        };
    }

    public static <T1> com.google.gson.y e(final Class<T1> cls, final com.google.gson.x<T1> xVar) {
        return new com.google.gson.y() { // from class: com.google.gson.internal.bind.TypeAdapters.35

            /* JADX INFO: Add missing generic type declarations: [T1] */
            /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$35$a */
            class a<T1> extends com.google.gson.x<T1> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Class f23127a;

                a(Class cls) {
                    this.f23127a = cls;
                }

                @Override // com.google.gson.x
                public T1 e(com.google.gson.stream.a aVar) throws IOException {
                    T1 t7 = (T1) xVar.e(aVar);
                    if (t7 == null || this.f23127a.isInstance(t7)) {
                        return t7;
                    }
                    throw new com.google.gson.v("Expected a " + this.f23127a.getName() + " but was " + t7.getClass().getName());
                }

                @Override // com.google.gson.x
                public void i(com.google.gson.stream.d dVar, T1 t7) throws IOException {
                    xVar.i(dVar, t7);
                }
            }

            @Override // com.google.gson.y
            public <T2> com.google.gson.x<T2> a(com.google.gson.f fVar, com.google.gson.reflect.a<T2> aVar) {
                Class<? super T2> rawType = aVar.getRawType();
                if (cls.isAssignableFrom(rawType)) {
                    return new a(rawType);
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + xVar + "]";
            }
        };
    }
}
