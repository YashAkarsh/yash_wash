package okhttp3.internal.cache;

import h5.i;
import i5.l;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.w;
import kotlin.l2;
import kotlin.text.b0;
import kotlin.text.c0;
import kotlin.text.h0;
import kotlin.text.o;
import kotlin.y;
import okhttp3.internal.platform.k;
import okio.a0;
import okio.m0;
import okio.n;
import okio.o0;
import okio.s;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f37644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f37645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f37646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f37647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f37648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private n f37649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.d
    private final LinkedHashMap<String, c> f37650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f37651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f37652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f37653j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f37654k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f37655l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f37656m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f37657n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f37658o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final okhttp3.internal.concurrent.c f37659p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final e f37660q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @a7.d
    private final okhttp3.internal.io.a f37661r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @a7.d
    private final File f37662s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f37663t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f37664u;
    public static final a G = new a(null);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final String f37639v = "journal";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final String f37640w = "journal.tmp";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final String f37641x = "journal.bkp";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final String f37642y = "libcore.io.DiskLruCache";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final String f37643z = "1";

    @h5.e
    public static final long A = -1;

    @a7.d
    @h5.e
    public static final o B = new o("[a-z0-9_-]{1,120}");

    @a7.d
    @h5.e
    public static final String C = "CLEAN";

    @a7.d
    @h5.e
    public static final String D = "DIRTY";

    @a7.d
    @h5.e
    public static final String E = "REMOVE";

    @a7.d
    @h5.e
    public static final String F = "READ";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.e
        private final boolean[] f37665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f37666b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        private final c f37667c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f37668d;

        static final class a extends n0 implements l<IOException, l2> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f37670b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i7) {
                super(1);
                this.f37670b = i7;
            }

            public final void b(@a7.d IOException it) {
                l0.p(it, "it");
                synchronized (b.this.f37668d) {
                    b.this.c();
                    l2 l2Var = l2.f34958a;
                }
            }

            @Override // i5.l
            public /* bridge */ /* synthetic */ l2 z(IOException iOException) {
                b(iOException);
                return l2.f34958a;
            }
        }

        public b(@a7.d d dVar, c entry) {
            l0.p(entry, "entry");
            this.f37668d = dVar;
            this.f37667c = entry;
            this.f37665a = entry.g() ? null : new boolean[dVar.I0()];
        }

        public final void a() throws IOException {
            synchronized (this.f37668d) {
                if (!(!this.f37666b)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (l0.g(this.f37667c.b(), this)) {
                    this.f37668d.K(this, false);
                }
                this.f37666b = true;
                l2 l2Var = l2.f34958a;
            }
        }

        public final void b() throws IOException {
            synchronized (this.f37668d) {
                if (!(!this.f37666b)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (l0.g(this.f37667c.b(), this)) {
                    this.f37668d.K(this, true);
                }
                this.f37666b = true;
                l2 l2Var = l2.f34958a;
            }
        }

        public final void c() throws IOException {
            if (l0.g(this.f37667c.b(), this)) {
                if (this.f37668d.f37653j) {
                    this.f37668d.K(this, false);
                } else {
                    this.f37667c.q(true);
                }
            }
        }

        @a7.d
        public final c d() {
            return this.f37667c;
        }

        @a7.e
        public final boolean[] e() {
            return this.f37665a;
        }

        @a7.d
        public final m0 f(int i7) {
            synchronized (this.f37668d) {
                if (!(!this.f37666b)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (!l0.g(this.f37667c.b(), this)) {
                    return a0.b();
                }
                if (!this.f37667c.g()) {
                    boolean[] zArr = this.f37665a;
                    l0.m(zArr);
                    zArr[i7] = true;
                }
                try {
                    return new okhttp3.internal.cache.e(this.f37668d.v0().b(this.f37667c.c().get(i7)), new a(i7));
                } catch (FileNotFoundException unused) {
                    return a0.b();
                }
            }
        }

        @a7.e
        public final o0 g(int i7) {
            synchronized (this.f37668d) {
                if (!(!this.f37666b)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                o0 o0VarA = null;
                if (!this.f37667c.g() || (!l0.g(this.f37667c.b(), this)) || this.f37667c.i()) {
                    return null;
                }
                try {
                    o0VarA = this.f37668d.v0().a(this.f37667c.a().get(i7));
                } catch (FileNotFoundException unused) {
                }
                return o0VarA;
            }
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final long[] f37671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private final List<File> f37672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        private final List<File> f37673c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f37674d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f37675e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @a7.e
        private b f37676f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f37677g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f37678h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @a7.d
        private final String f37679i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ d f37680j;

        public static final class a extends s {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f37681a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ o0 f37683c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(o0 o0Var, o0 o0Var2) {
                super(o0Var2);
                this.f37683c = o0Var;
            }

            @Override // okio.s, okio.o0, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                super.close();
                if (this.f37681a) {
                    return;
                }
                this.f37681a = true;
                synchronized (c.this.f37680j) {
                    c cVar = c.this;
                    cVar.n(cVar.f() - 1);
                    if (c.this.f() == 0 && c.this.i()) {
                        c cVar2 = c.this;
                        cVar2.f37680j.e1(cVar2);
                    }
                    l2 l2Var = l2.f34958a;
                }
            }
        }

        public c(@a7.d d dVar, String key) {
            l0.p(key, "key");
            this.f37680j = dVar;
            this.f37679i = key;
            this.f37671a = new long[dVar.I0()];
            this.f37672b = new ArrayList();
            this.f37673c = new ArrayList();
            StringBuilder sb = new StringBuilder(key);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            int length = sb.length();
            int iI0 = dVar.I0();
            for (int i7 = 0; i7 < iI0; i7++) {
                sb.append(i7);
                this.f37672b.add(new File(dVar.s0(), sb.toString()));
                sb.append(".tmp");
                this.f37673c.add(new File(dVar.s0(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final Void j(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final o0 k(int i7) throws FileNotFoundException {
            o0 o0VarA = this.f37680j.v0().a(this.f37672b.get(i7));
            if (this.f37680j.f37653j) {
                return o0VarA;
            }
            this.f37677g++;
            return new a(o0VarA, o0VarA);
        }

        @a7.d
        public final List<File> a() {
            return this.f37672b;
        }

        @a7.e
        public final b b() {
            return this.f37676f;
        }

        @a7.d
        public final List<File> c() {
            return this.f37673c;
        }

        @a7.d
        public final String d() {
            return this.f37679i;
        }

        @a7.d
        public final long[] e() {
            return this.f37671a;
        }

        public final int f() {
            return this.f37677g;
        }

        public final boolean g() {
            return this.f37674d;
        }

        public final long h() {
            return this.f37678h;
        }

        public final boolean i() {
            return this.f37675e;
        }

        public final void l(@a7.e b bVar) {
            this.f37676f = bVar;
        }

        public final void m(@a7.d List<String> strings) throws IOException {
            l0.p(strings, "strings");
            if (strings.size() != this.f37680j.I0()) {
                j(strings);
                throw new y();
            }
            try {
                int size = strings.size();
                for (int i7 = 0; i7 < size; i7++) {
                    this.f37671a[i7] = Long.parseLong(strings.get(i7));
                }
            } catch (NumberFormatException unused) {
                j(strings);
                throw new y();
            }
        }

        public final void n(int i7) {
            this.f37677g = i7;
        }

        public final void o(boolean z7) {
            this.f37674d = z7;
        }

        public final void p(long j7) {
            this.f37678h = j7;
        }

        public final void q(boolean z7) {
            this.f37675e = z7;
        }

        @a7.e
        public final C0501d r() {
            d dVar = this.f37680j;
            if (okhttp3.internal.d.f37861h && !Thread.holdsLock(dVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Thread ");
                Thread threadCurrentThread = Thread.currentThread();
                l0.o(threadCurrentThread, "Thread.currentThread()");
                sb.append(threadCurrentThread.getName());
                sb.append(" MUST hold lock on ");
                sb.append(dVar);
                throw new AssertionError(sb.toString());
            }
            if (!this.f37674d) {
                return null;
            }
            if (!this.f37680j.f37653j && (this.f37676f != null || this.f37675e)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.f37671a.clone();
            try {
                int iI0 = this.f37680j.I0();
                for (int i7 = 0; i7 < iI0; i7++) {
                    arrayList.add(k(i7));
                }
                return new C0501d(this.f37680j, this.f37679i, this.f37678h, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    okhttp3.internal.d.l((o0) it.next());
                }
                try {
                    this.f37680j.e1(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void s(@a7.d n writer) throws IOException {
            l0.p(writer, "writer");
            for (long j7 : this.f37671a) {
                writer.writeByte(32).H1(j7);
            }
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.cache.d$d, reason: collision with other inner class name */
    public final class C0501d implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f37684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f37685b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<o0> f37686c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long[] f37687d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f37688e;

        /* JADX WARN: Multi-variable type inference failed */
        public C0501d(@a7.d d dVar, String key, @a7.d long j7, @a7.d List<? extends o0> sources, long[] lengths) {
            l0.p(key, "key");
            l0.p(sources, "sources");
            l0.p(lengths, "lengths");
            this.f37688e = dVar;
            this.f37684a = key;
            this.f37685b = j7;
            this.f37686c = sources;
            this.f37687d = lengths;
        }

        @a7.e
        public final b b() throws IOException {
            return this.f37688e.h0(this.f37684a, this.f37685b);
        }

        public final long c(int i7) {
            return this.f37687d[i7];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<o0> it = this.f37686c.iterator();
            while (it.hasNext()) {
                okhttp3.internal.d.l(it.next());
            }
        }

        @a7.d
        public final o0 e(int i7) {
            return this.f37686c.get(i7);
        }

        @a7.d
        public final String q() {
            return this.f37684a;
        }
    }

    public static final class e extends okhttp3.internal.concurrent.a {
        e(String str) {
            super(str, false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            synchronized (d.this) {
                if (!d.this.f37654k || d.this.r0()) {
                    return -1L;
                }
                try {
                    d.this.A1();
                } catch (IOException unused) {
                    d.this.f37656m = true;
                }
                try {
                    if (d.this.L0()) {
                        d.this.a1();
                        d.this.f37651h = 0;
                    }
                } catch (IOException unused2) {
                    d.this.f37657n = true;
                    d.this.f37649f = a0.c(a0.b());
                }
                return -1L;
            }
        }
    }

    static final class f extends n0 implements l<IOException, l2> {
        f() {
            super(1);
        }

        public final void b(@a7.d IOException it) {
            l0.p(it, "it");
            d dVar = d.this;
            if (!okhttp3.internal.d.f37861h || Thread.holdsLock(dVar)) {
                d.this.f37652i = true;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(dVar);
            throw new AssertionError(sb.toString());
        }

        @Override // i5.l
        public /* bridge */ /* synthetic */ l2 z(IOException iOException) {
            b(iOException);
            return l2.f34958a;
        }
    }

    public static final class g implements Iterator<C0501d>, j5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator<c> f37691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private C0501d f37692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private C0501d f37693c;

        g() {
            Iterator<c> it = new ArrayList(d.this.x0().values()).iterator();
            l0.o(it, "ArrayList(lruEntries.values).iterator()");
            this.f37691a = it;
        }

        @Override // java.util.Iterator
        @a7.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0501d next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            C0501d c0501d = this.f37692b;
            this.f37693c = c0501d;
            this.f37692b = null;
            l0.m(c0501d);
            return c0501d;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            C0501d c0501dR;
            if (this.f37692b != null) {
                return true;
            }
            synchronized (d.this) {
                if (d.this.r0()) {
                    return false;
                }
                while (this.f37691a.hasNext()) {
                    c next = this.f37691a.next();
                    if (next != null && (c0501dR = next.r()) != null) {
                        this.f37692b = c0501dR;
                        return true;
                    }
                }
                l2 l2Var = l2.f34958a;
                return false;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            C0501d c0501d = this.f37693c;
            if (c0501d == null) {
                throw new IllegalStateException("remove() before next()".toString());
            }
            try {
                d.this.d1(c0501d.q());
            } catch (IOException unused) {
            } finally {
                this.f37693c = null;
            }
        }
    }

    public d(@a7.d okhttp3.internal.io.a fileSystem, @a7.d File directory, int i7, int i8, long j7, @a7.d okhttp3.internal.concurrent.d taskRunner) {
        l0.p(fileSystem, "fileSystem");
        l0.p(directory, "directory");
        l0.p(taskRunner, "taskRunner");
        this.f37661r = fileSystem;
        this.f37662s = directory;
        this.f37663t = i7;
        this.f37664u = i8;
        this.f37644a = j7;
        this.f37650g = new LinkedHashMap<>(0, 0.75f, true);
        this.f37659p = taskRunner.j();
        this.f37660q = new e(okhttp3.internal.d.f37862i + " Cache");
        if (!(j7 > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (!(i8 > 0)) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.f37645b = new File(directory, f37639v);
        this.f37646c = new File(directory, f37640w);
        this.f37647d = new File(directory, f37641x);
    }

    private final void B1(String str) {
        if (B.k(str)) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + h0.f35376b).toString());
    }

    private final synchronized void H() {
        if (!(!this.f37655l)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L0() {
        int i7 = this.f37651h;
        return i7 >= 2000 && i7 >= this.f37650g.size();
    }

    private final n Q0() throws FileNotFoundException {
        return a0.c(new okhttp3.internal.cache.e(this.f37661r.g(this.f37645b), new f()));
    }

    private final void T0() throws IOException {
        this.f37661r.f(this.f37646c);
        Iterator<c> it = this.f37650g.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            l0.o(next, "i.next()");
            c cVar = next;
            int i7 = 0;
            if (cVar.b() == null) {
                int i8 = this.f37664u;
                while (i7 < i8) {
                    this.f37648e += cVar.e()[i7];
                    i7++;
                }
            } else {
                cVar.l(null);
                int i9 = this.f37664u;
                while (i7 < i9) {
                    this.f37661r.f(cVar.a().get(i7));
                    this.f37661r.f(cVar.c().get(i7));
                    i7++;
                }
                it.remove();
            }
        }
    }

    private final void V0() throws IOException {
        okio.o oVarD = a0.d(this.f37661r.a(this.f37645b));
        try {
            String strX0 = oVarD.X0();
            String strX1 = oVarD.X0();
            String strX2 = oVarD.X0();
            String strX3 = oVarD.X0();
            String strX4 = oVarD.X0();
            if (!(!l0.g(f37642y, strX0)) && !(!l0.g(f37643z, strX1)) && !(!l0.g(String.valueOf(this.f37663t), strX2)) && !(!l0.g(String.valueOf(this.f37664u), strX3))) {
                int i7 = 0;
                if (!(strX4.length() > 0)) {
                    while (true) {
                        try {
                            Y0(oVarD.X0());
                            i7++;
                        } catch (EOFException unused) {
                            this.f37651h = i7 - this.f37650g.size();
                            if (oVarD.N()) {
                                this.f37649f = Q0();
                            } else {
                                a1();
                            }
                            l2 l2Var = l2.f34958a;
                            kotlin.io.c.a(oVarD, null);
                            return;
                        }
                    }
                }
            }
            throw new IOException("unexpected journal header: [" + strX0 + ", " + strX1 + ", " + strX3 + ", " + strX4 + ']');
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.c.a(oVarD, th);
                throw th2;
            }
        }
    }

    private final void Y0(String str) throws IOException {
        String strSubstring;
        int iQ3 = c0.q3(str, ' ', 0, false, 6, null);
        if (iQ3 == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i7 = iQ3 + 1;
        int iQ4 = c0.q3(str, ' ', i7, false, 4, null);
        if (iQ4 == -1) {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str.substring(i7);
            l0.o(strSubstring, "(this as java.lang.String).substring(startIndex)");
            String str2 = E;
            if (iQ3 == str2.length() && b0.u2(str, str2, false, 2, null)) {
                this.f37650g.remove(strSubstring);
                return;
            }
        } else {
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str.substring(i7, iQ4);
            l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        c cVar = this.f37650g.get(strSubstring);
        if (cVar == null) {
            cVar = new c(this, strSubstring);
            this.f37650g.put(strSubstring, cVar);
        }
        if (iQ4 != -1) {
            String str3 = C;
            if (iQ3 == str3.length() && b0.u2(str, str3, false, 2, null)) {
                int i8 = iQ4 + 1;
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String strSubstring2 = str.substring(i8);
                l0.o(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                List<String> listS4 = c0.S4(strSubstring2, new char[]{' '}, false, 0, 6, null);
                cVar.o(true);
                cVar.l(null);
                cVar.m(listS4);
                return;
            }
        }
        if (iQ4 == -1) {
            String str4 = D;
            if (iQ3 == str4.length() && b0.u2(str, str4, false, 2, null)) {
                cVar.l(new b(this, cVar));
                return;
            }
        }
        if (iQ4 == -1) {
            String str5 = F;
            if (iQ3 == str5.length() && b0.u2(str, str5, false, 2, null)) {
                return;
            }
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private final boolean i1() throws IOException {
        for (c toEvict : this.f37650g.values()) {
            if (!toEvict.i()) {
                l0.o(toEvict, "toEvict");
                e1(toEvict);
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ b l0(d dVar, String str, long j7, int i7, Object obj) throws IOException {
        if ((i7 & 2) != 0) {
            j7 = A;
        }
        return dVar.h0(str, j7);
    }

    public final void A1() throws IOException {
        while (this.f37648e > this.f37644a) {
            if (!i1()) {
                return;
            }
        }
        this.f37656m = false;
    }

    public final synchronized long G0() {
        return this.f37644a;
    }

    public final int I0() {
        return this.f37664u;
    }

    public final synchronized void J0() throws IOException {
        if (okhttp3.internal.d.f37861h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        if (this.f37654k) {
            return;
        }
        if (this.f37661r.d(this.f37647d)) {
            if (this.f37661r.d(this.f37645b)) {
                this.f37661r.f(this.f37647d);
            } else {
                this.f37661r.e(this.f37647d, this.f37645b);
            }
        }
        this.f37653j = okhttp3.internal.d.J(this.f37661r, this.f37647d);
        if (this.f37661r.d(this.f37645b)) {
            try {
                V0();
                T0();
                this.f37654k = true;
                return;
            } catch (IOException e8) {
                k.f38284e.g().m("DiskLruCache " + this.f37662s + " is corrupt: " + e8.getMessage() + ", removing", 5, e8);
                try {
                    Q();
                    this.f37655l = false;
                    a1();
                    this.f37654k = true;
                } catch (Throwable th) {
                    this.f37655l = false;
                    throw th;
                }
            }
        }
        a1();
        this.f37654k = true;
    }

    public final synchronized void K(@a7.d b editor, boolean z7) throws IOException {
        l0.p(editor, "editor");
        c cVarD = editor.d();
        if (!l0.g(cVarD.b(), editor)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (z7 && !cVarD.g()) {
            int i7 = this.f37664u;
            for (int i8 = 0; i8 < i7; i8++) {
                boolean[] zArrE = editor.e();
                l0.m(zArrE);
                if (!zArrE[i8]) {
                    editor.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i8);
                }
                if (!this.f37661r.d(cVarD.c().get(i8))) {
                    editor.a();
                    return;
                }
            }
        }
        int i9 = this.f37664u;
        for (int i10 = 0; i10 < i9; i10++) {
            File file = cVarD.c().get(i10);
            if (!z7 || cVarD.i()) {
                this.f37661r.f(file);
            } else if (this.f37661r.d(file)) {
                File file2 = cVarD.a().get(i10);
                this.f37661r.e(file, file2);
                long j7 = cVarD.e()[i10];
                long jH = this.f37661r.h(file2);
                cVarD.e()[i10] = jH;
                this.f37648e = (this.f37648e - j7) + jH;
            }
        }
        cVarD.l(null);
        if (cVarD.i()) {
            e1(cVarD);
            return;
        }
        this.f37651h++;
        n nVar = this.f37649f;
        l0.m(nVar);
        if (cVarD.g() || z7) {
            cVarD.o(true);
            nVar.q0(C).writeByte(32);
            nVar.q0(cVarD.d());
            cVarD.s(nVar);
            nVar.writeByte(10);
            if (z7) {
                long j8 = this.f37658o;
                this.f37658o = 1 + j8;
                cVarD.p(j8);
            }
        } else {
            this.f37650g.remove(cVarD.d());
            nVar.q0(E).writeByte(32);
            nVar.q0(cVarD.d());
            nVar.writeByte(10);
        }
        nVar.flush();
        if (this.f37648e > this.f37644a || L0()) {
            okhttp3.internal.concurrent.c.p(this.f37659p, this.f37660q, 0L, 2, null);
        }
    }

    public final void Q() throws IOException {
        close();
        this.f37661r.c(this.f37662s);
    }

    public final synchronized void a1() throws IOException {
        n nVar = this.f37649f;
        if (nVar != null) {
            nVar.close();
        }
        n nVarC = a0.c(this.f37661r.b(this.f37646c));
        try {
            nVarC.q0(f37642y).writeByte(10);
            nVarC.q0(f37643z).writeByte(10);
            nVarC.H1(this.f37663t).writeByte(10);
            nVarC.H1(this.f37664u).writeByte(10);
            nVarC.writeByte(10);
            for (c cVar : this.f37650g.values()) {
                if (cVar.b() != null) {
                    nVarC.q0(D).writeByte(32);
                    nVarC.q0(cVar.d());
                    nVarC.writeByte(10);
                } else {
                    nVarC.q0(C).writeByte(32);
                    nVarC.q0(cVar.d());
                    cVar.s(nVarC);
                    nVarC.writeByte(10);
                }
            }
            l2 l2Var = l2.f34958a;
            kotlin.io.c.a(nVarC, null);
            if (this.f37661r.d(this.f37645b)) {
                this.f37661r.e(this.f37645b, this.f37647d);
            }
            this.f37661r.e(this.f37646c, this.f37645b);
            this.f37661r.f(this.f37647d);
            this.f37649f = Q0();
            this.f37652i = false;
            this.f37657n = false;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.c.a(nVarC, th);
                throw th2;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        b bVarB;
        if (this.f37654k && !this.f37655l) {
            Collection<c> collectionValues = this.f37650g.values();
            l0.o(collectionValues, "lruEntries.values");
            Object[] array = collectionValues.toArray(new c[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            for (c cVar : (c[]) array) {
                if (cVar.b() != null && (bVarB = cVar.b()) != null) {
                    bVarB.c();
                }
            }
            A1();
            n nVar = this.f37649f;
            l0.m(nVar);
            nVar.close();
            this.f37649f = null;
            this.f37655l = true;
            return;
        }
        this.f37655l = true;
    }

    public final synchronized boolean d1(@a7.d String key) throws IOException {
        l0.p(key, "key");
        J0();
        H();
        B1(key);
        c cVar = this.f37650g.get(key);
        if (cVar == null) {
            return false;
        }
        l0.o(cVar, "lruEntries[key] ?: return false");
        boolean zE1 = e1(cVar);
        if (zE1 && this.f37648e <= this.f37644a) {
            this.f37656m = false;
        }
        return zE1;
    }

    public final boolean e1(@a7.d c entry) throws IOException {
        n nVar;
        l0.p(entry, "entry");
        if (!this.f37653j) {
            if (entry.f() > 0 && (nVar = this.f37649f) != null) {
                nVar.q0(D);
                nVar.writeByte(32);
                nVar.q0(entry.d());
                nVar.writeByte(10);
                nVar.flush();
            }
            if (entry.f() > 0 || entry.b() != null) {
                entry.q(true);
                return true;
            }
        }
        b bVarB = entry.b();
        if (bVarB != null) {
            bVarB.c();
        }
        int i7 = this.f37664u;
        for (int i8 = 0; i8 < i7; i8++) {
            this.f37661r.f(entry.a().get(i8));
            this.f37648e -= entry.e()[i8];
            entry.e()[i8] = 0;
        }
        this.f37651h++;
        n nVar2 = this.f37649f;
        if (nVar2 != null) {
            nVar2.q0(E);
            nVar2.writeByte(32);
            nVar2.q0(entry.d());
            nVar2.writeByte(10);
        }
        this.f37650g.remove(entry.d());
        if (L0()) {
            okhttp3.internal.concurrent.c.p(this.f37659p, this.f37660q, 0L, 2, null);
        }
        return true;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f37654k) {
            H();
            A1();
            n nVar = this.f37649f;
            l0.m(nVar);
            nVar.flush();
        }
    }

    @i
    @a7.e
    public final b g0(@a7.d String str) throws IOException {
        return l0(this, str, 0L, 2, null);
    }

    @i
    @a7.e
    public final synchronized b h0(@a7.d String key, long j7) throws IOException {
        l0.p(key, "key");
        J0();
        H();
        B1(key);
        c cVar = this.f37650g.get(key);
        if (j7 != A && (cVar == null || cVar.h() != j7)) {
            return null;
        }
        if ((cVar != null ? cVar.b() : null) != null) {
            return null;
        }
        if (cVar != null && cVar.f() != 0) {
            return null;
        }
        if (!this.f37656m && !this.f37657n) {
            n nVar = this.f37649f;
            l0.m(nVar);
            nVar.q0(D).writeByte(32).q0(key).writeByte(10);
            nVar.flush();
            if (this.f37652i) {
                return null;
            }
            if (cVar == null) {
                cVar = new c(this, key);
                this.f37650g.put(key, cVar);
            }
            b bVar = new b(this, cVar);
            cVar.l(bVar);
            return bVar;
        }
        okhttp3.internal.concurrent.c.p(this.f37659p, this.f37660q, 0L, 2, null);
        return null;
    }

    public final synchronized boolean isClosed() {
        return this.f37655l;
    }

    public final synchronized void o0() throws IOException {
        J0();
        Collection<c> collectionValues = this.f37650g.values();
        l0.o(collectionValues, "lruEntries.values");
        Object[] array = collectionValues.toArray(new c[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        for (c entry : (c[]) array) {
            l0.o(entry, "entry");
            e1(entry);
        }
        this.f37656m = false;
    }

    @a7.e
    public final synchronized C0501d p0(@a7.d String key) throws IOException {
        l0.p(key, "key");
        J0();
        H();
        B1(key);
        c cVar = this.f37650g.get(key);
        if (cVar == null) {
            return null;
        }
        l0.o(cVar, "lruEntries[key] ?: return null");
        C0501d c0501dR = cVar.r();
        if (c0501dR == null) {
            return null;
        }
        this.f37651h++;
        n nVar = this.f37649f;
        l0.m(nVar);
        nVar.q0(F).writeByte(32).q0(key).writeByte(10);
        if (L0()) {
            okhttp3.internal.concurrent.c.p(this.f37659p, this.f37660q, 0L, 2, null);
        }
        return c0501dR;
    }

    public final void q1(boolean z7) {
        this.f37655l = z7;
    }

    public final boolean r0() {
        return this.f37655l;
    }

    @a7.d
    public final File s0() {
        return this.f37662s;
    }

    public final synchronized void s1(long j7) {
        this.f37644a = j7;
        if (this.f37654k) {
            okhttp3.internal.concurrent.c.p(this.f37659p, this.f37660q, 0L, 2, null);
        }
    }

    @a7.d
    public final okhttp3.internal.io.a v0() {
        return this.f37661r;
    }

    public final synchronized long w1() throws IOException {
        J0();
        return this.f37648e;
    }

    @a7.d
    public final LinkedHashMap<String, c> x0() {
        return this.f37650g;
    }

    @a7.d
    public final synchronized Iterator<C0501d> z1() throws IOException {
        J0();
        return new g();
    }
}
