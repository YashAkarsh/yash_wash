package com.haier.library.okhttp.b.b;

import com.haier.library.a.b0;
import com.haier.library.a.c0;
import com.haier.library.a.h;
import com.haier.library.a.i;
import com.haier.library.a.t;
import com.haier.library.okhttp.n;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Closeable, Flushable {
    static final Pattern A = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final String B = "CLEAN";
    private static final String C = "DIRTY";
    private static final String D = "REMOVE";
    private static final String E = "READ";
    static final /* synthetic */ boolean F = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final String f26953u = "journal";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final String f26954v = "journal.tmp";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final String f26955w = "journal.bkp";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final String f26956x = "libcore.io.DiskLruCache";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final String f26957y = "1";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final long f26958z = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.haier.library.okhttp.b.h.a f26959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final File f26960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f26961c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f26962d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f26963e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f26964f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f26965g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f26966h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    h f26968j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f26970l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    boolean f26971m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f26972n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f26973o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f26974p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f26975q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Executor f26977s;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f26967i = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final LinkedHashMap<String, e> f26969k = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f26976r = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Runnable f26978t = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (d.this) {
                d dVar = d.this;
                if ((!dVar.f26972n) || dVar.f26973o) {
                    return;
                }
                try {
                    dVar.h0();
                } catch (IOException unused) {
                    d.this.f26974p = true;
                }
                try {
                    if (d.this.g0()) {
                        d.this.C();
                        d.this.f26970l = 0;
                    }
                } catch (IOException unused2) {
                    d dVar2 = d.this;
                    dVar2.f26975q = true;
                    dVar2.f26968j = t.a(t.c());
                }
            }
        }
    }

    class b extends com.haier.library.okhttp.b.b.e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final /* synthetic */ boolean f26980d = true;

        b(b0 b0Var) {
            super(b0Var);
        }

        @Override // com.haier.library.okhttp.b.b.e
        protected void c(IOException iOException) {
            if (!f26980d && !Thread.holdsLock(d.this)) {
                throw new AssertionError();
            }
            d.this.f26971m = true;
        }
    }

    class c implements Iterator<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<e> f26982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        f f26983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        f f26984c;

        c() {
            this.f26982a = new ArrayList(d.this.f26969k.values()).iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            f fVar = this.f26983b;
            this.f26984c = fVar;
            this.f26983b = null;
            return fVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f26983b != null) {
                return true;
            }
            synchronized (d.this) {
                if (d.this.f26973o) {
                    return false;
                }
                while (this.f26982a.hasNext()) {
                    f fVarA = this.f26982a.next().a();
                    if (fVarA != null) {
                        this.f26983b = fVarA;
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            f fVar = this.f26984c;
            if (fVar == null) {
                throw new IllegalStateException("remove() before next()");
            }
            try {
                d.this.F(fVar.f26999a);
            } catch (IOException unused) {
            } finally {
                this.f26984c = null;
            }
        }
    }

    /* JADX INFO: renamed from: com.haier.library.okhttp.b.b.d$d, reason: collision with other inner class name */
    public final class C0356d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final e f26986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean[] f26987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f26988c;

        /* JADX INFO: renamed from: com.haier.library.okhttp.b.b.d$d$a */
        class a extends com.haier.library.okhttp.b.b.e {
            a(b0 b0Var) {
                super(b0Var);
            }

            @Override // com.haier.library.okhttp.b.b.e
            protected void c(IOException iOException) {
                synchronized (d.this) {
                    C0356d.this.b();
                }
            }
        }

        C0356d(e eVar) {
            this.f26986a = eVar;
            this.f26987b = eVar.f26995e ? null : new boolean[d.this.f26966h];
        }

        public c0 a(int i7) {
            synchronized (d.this) {
                if (this.f26988c) {
                    throw new IllegalStateException();
                }
                e eVar = this.f26986a;
                if (!eVar.f26995e || eVar.f26996f != this) {
                    return null;
                }
                try {
                    return d.this.f26959a.h(eVar.f26993c[i7]);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }
        }

        void b() {
            if (this.f26986a.f26996f != this) {
                return;
            }
            int i7 = 0;
            while (true) {
                d dVar = d.this;
                if (i7 >= dVar.f26966h) {
                    this.f26986a.f26996f = null;
                    return;
                } else {
                    try {
                        dVar.f26959a.d(this.f26986a.f26994d[i7]);
                    } catch (IOException unused) {
                    }
                    i7++;
                }
            }
        }

        public b0 c(int i7) {
            synchronized (d.this) {
                if (this.f26988c) {
                    throw new IllegalStateException();
                }
                e eVar = this.f26986a;
                if (eVar.f26996f != this) {
                    return t.c();
                }
                if (!eVar.f26995e) {
                    this.f26987b[i7] = true;
                }
                try {
                    return new a(d.this.f26959a.a(eVar.f26994d[i7]));
                } catch (FileNotFoundException unused) {
                    return t.c();
                }
            }
        }

        public void d() throws IOException {
            synchronized (d.this) {
                if (this.f26988c) {
                    throw new IllegalStateException();
                }
                if (this.f26986a.f26996f == this) {
                    d.this.r(this, true);
                }
                this.f26988c = true;
            }
        }

        public void e() throws IOException {
            synchronized (d.this) {
                if (this.f26988c) {
                    throw new IllegalStateException();
                }
                if (this.f26986a.f26996f == this) {
                    d.this.r(this, false);
                }
                this.f26988c = true;
            }
        }

        public void f() {
            synchronized (d.this) {
                if (!this.f26988c && this.f26986a.f26996f == this) {
                    try {
                        d.this.r(this, false);
                    } catch (IOException unused) {
                    }
                }
            }
        }
    }

    private final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f26991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long[] f26992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final File[] f26993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final File[] f26994d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f26995e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        C0356d f26996f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f26997g;

        e(String str) {
            this.f26991a = str;
            int i7 = d.this.f26966h;
            this.f26992b = new long[i7];
            this.f26993c = new File[i7];
            this.f26994d = new File[i7];
            StringBuilder sb = new StringBuilder(str);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            int length = sb.length();
            for (int i8 = 0; i8 < d.this.f26966h; i8++) {
                sb.append(i8);
                this.f26993c[i8] = new File(d.this.f26960b, sb.toString());
                sb.append(".tmp");
                this.f26994d[i8] = new File(d.this.f26960b, sb.toString());
                sb.setLength(length);
            }
        }

        private IOException d(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        f a() {
            d dVar;
            c0 c0Var;
            if (!Thread.holdsLock(d.this)) {
                throw new AssertionError();
            }
            c0[] c0VarArr = new c0[d.this.f26966h];
            long[] jArr = (long[]) this.f26992b.clone();
            int i7 = 0;
            int i8 = 0;
            while (true) {
                try {
                    d dVar2 = d.this;
                    if (i8 >= dVar2.f26966h) {
                        return dVar2.new f(this.f26991a, this.f26997g, c0VarArr, jArr);
                    }
                    c0VarArr[i8] = dVar2.f26959a.h(this.f26993c[i8]);
                    i8++;
                } catch (FileNotFoundException unused) {
                    while (true) {
                        dVar = d.this;
                        if (i7 >= dVar.f26966h || (c0Var = c0VarArr[i7]) == null) {
                            break;
                        }
                        n.d.s(c0Var);
                        i7++;
                    }
                    try {
                        dVar.s(this);
                        return null;
                    } catch (IOException unused2) {
                        return null;
                    }
                }
            }
        }

        void b(h hVar) throws IOException {
            for (long j7 : this.f26992b) {
                hVar.y1(32).n(j7);
            }
        }

        void c(String[] strArr) throws IOException {
            if (strArr.length != d.this.f26966h) {
                throw d(strArr);
            }
            for (int i7 = 0; i7 < strArr.length; i7++) {
                try {
                    this.f26992b[i7] = Long.parseLong(strArr[i7]);
                } catch (NumberFormatException unused) {
                    throw d(strArr);
                }
            }
        }
    }

    public final class f implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f26999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f27000b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final c0[] f27001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long[] f27002d;

        f(String str, long j7, c0[] c0VarArr, long[] jArr) {
            this.f26999a = str;
            this.f27000b = j7;
            this.f27001c = c0VarArr;
            this.f27002d = jArr;
        }

        public c0 b(int i7) {
            return this.f27001c[i7];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (c0 c0Var : this.f27001c) {
                n.d.s(c0Var);
            }
        }

        public String e() {
            return this.f26999a;
        }

        public long g(int i7) {
            return this.f27002d[i7];
        }

        @Nullable
        public C0356d q() throws IOException {
            return d.this.b(this.f26999a, this.f27000b);
        }
    }

    d(com.haier.library.okhttp.b.h.a aVar, File file, int i7, int i8, long j7, Executor executor) {
        this.f26959a = aVar;
        this.f26960b = file;
        this.f26964f = i7;
        this.f26961c = new File(file, f26953u);
        this.f26962d = new File(file, f26954v);
        this.f26963e = new File(file, f26955w);
        this.f26966h = i8;
        this.f26965g = j7;
        this.f26977s = executor;
    }

    private void H(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i7 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i7);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i7);
            if (iIndexOf == 6 && str.startsWith(D)) {
                this.f26969k.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i7, iIndexOf2);
        }
        e eVar = this.f26969k.get(strSubstring);
        if (eVar == null) {
            eVar = new e(strSubstring);
            this.f26969k.put(strSubstring, eVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith(B)) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            eVar.f26995e = true;
            eVar.f26996f = null;
            eVar.c(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith(C)) {
            eVar.f26996f = new C0356d(eVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith(E)) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    private void Q(String str) {
        if (A.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public static d e(com.haier.library.okhttp.b.h.a aVar, File file, int i7, int i8, long j7) {
        if (j7 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i8 > 0) {
            return new d(aVar, file, i7, i8, j7, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), n.d.p("OkHttp DiskLruCache", true)));
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private void r0() throws IOException {
        i iVarB = t.b(this.f26959a.h(this.f26961c));
        try {
            String strV = iVarB.v();
            String strV2 = iVarB.v();
            String strV3 = iVarB.v();
            String strV4 = iVarB.v();
            String strV5 = iVarB.v();
            if (!f26956x.equals(strV) || !"1".equals(strV2) || !Integer.toString(this.f26964f).equals(strV3) || !Integer.toString(this.f26966h).equals(strV4) || !"".equals(strV5)) {
                throw new IOException("unexpected journal header: [" + strV + ", " + strV2 + ", " + strV4 + ", " + strV5 + "]");
            }
            int i7 = 0;
            while (true) {
                try {
                    H(iVarB.v());
                    i7++;
                } catch (EOFException unused) {
                    this.f26970l = i7 - this.f26969k.size();
                    if (iVarB.g()) {
                        this.f26968j = s0();
                    } else {
                        C();
                    }
                    n.d.s(iVarB);
                    return;
                }
            }
        } catch (Throwable th) {
            n.d.s(iVarB);
            throw th;
        }
    }

    private h s0() throws FileNotFoundException {
        return t.a(new b(this.f26959a.b(this.f26961c)));
    }

    private void v0() throws IOException {
        this.f26959a.d(this.f26962d);
        Iterator<e> it = this.f26969k.values().iterator();
        while (it.hasNext()) {
            e next = it.next();
            int i7 = 0;
            if (next.f26996f == null) {
                while (i7 < this.f26966h) {
                    this.f26967i += next.f26992b[i7];
                    i7++;
                }
            } else {
                next.f26996f = null;
                while (i7 < this.f26966h) {
                    this.f26959a.d(next.f26993c[i7]);
                    this.f26959a.d(next.f26994d[i7]);
                    i7++;
                }
                it.remove();
            }
        }
    }

    private synchronized void x0() {
        if (g()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    synchronized void C() throws IOException {
        h hVar = this.f26968j;
        if (hVar != null) {
            hVar.close();
        }
        h hVarA = t.a(this.f26959a.a(this.f26962d));
        try {
            hVarA.b(f26956x).y1(10);
            hVarA.b("1").y1(10);
            hVarA.n(this.f26964f).y1(10);
            hVarA.n(this.f26966h).y1(10);
            hVarA.y1(10);
            for (e eVar : this.f26969k.values()) {
                if (eVar.f26996f != null) {
                    hVarA.b(C).y1(32);
                    hVarA.b(eVar.f26991a);
                    hVarA.y1(10);
                } else {
                    hVarA.b(B).y1(32);
                    hVarA.b(eVar.f26991a);
                    eVar.b(hVarA);
                    hVarA.y1(10);
                }
            }
            hVarA.close();
            if (this.f26959a.e(this.f26961c)) {
                this.f26959a.c(this.f26961c, this.f26963e);
            }
            this.f26959a.c(this.f26962d, this.f26961c);
            this.f26959a.d(this.f26963e);
            this.f26968j = s0();
            this.f26971m = false;
            this.f26975q = false;
        } catch (Throwable th) {
            hVarA.close();
            throw th;
        }
    }

    public File E() {
        return this.f26960b;
    }

    public synchronized boolean F(String str) throws IOException {
        q();
        x0();
        Q(str);
        e eVar = this.f26969k.get(str);
        if (eVar == null) {
            return false;
        }
        boolean zS = s(eVar);
        if (zS && this.f26967i <= this.f26965g) {
            this.f26974p = false;
        }
        return zS;
    }

    public synchronized long G() {
        return this.f26965g;
    }

    public synchronized long K() throws IOException {
        q();
        return this.f26967i;
    }

    public synchronized void a(long j7) {
        this.f26965g = j7;
        if (this.f26972n) {
            this.f26977s.execute(this.f26978t);
        }
    }

    synchronized C0356d b(String str, long j7) throws IOException {
        q();
        x0();
        Q(str);
        e eVar = this.f26969k.get(str);
        if (j7 != -1 && (eVar == null || eVar.f26997g != j7)) {
            return null;
        }
        if (eVar != null && eVar.f26996f != null) {
            return null;
        }
        if (!this.f26974p && !this.f26975q) {
            this.f26968j.b(C).y1(32).b(str).y1(10);
            this.f26968j.flush();
            if (this.f26971m) {
                return null;
            }
            if (eVar == null) {
                eVar = new e(str);
                this.f26969k.put(str, eVar);
            }
            C0356d c0356d = new C0356d(eVar);
            eVar.f26996f = c0356d;
            return c0356d;
        }
        this.f26977s.execute(this.f26978t);
        return null;
    }

    public synchronized f c(String str) throws IOException {
        q();
        x0();
        Q(str);
        e eVar = this.f26969k.get(str);
        if (eVar != null && eVar.f26995e) {
            f fVarA = eVar.a();
            if (fVarA == null) {
                return null;
            }
            this.f26970l++;
            this.f26968j.b(E).y1(32).b(str).y1(10);
            if (g0()) {
                this.f26977s.execute(this.f26978t);
            }
            return fVarA;
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f26972n && !this.f26973o) {
            for (e eVar : (e[]) this.f26969k.values().toArray(new e[this.f26969k.size()])) {
                C0356d c0356d = eVar.f26996f;
                if (c0356d != null) {
                    c0356d.e();
                }
            }
            h0();
            this.f26968j.close();
            this.f26968j = null;
            this.f26973o = true;
            return;
        }
        this.f26973o = true;
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.f26972n) {
            x0();
            h0();
            this.f26968j.flush();
        }
    }

    public synchronized boolean g() {
        return this.f26973o;
    }

    boolean g0() {
        int i7 = this.f26970l;
        return i7 >= 2000 && i7 >= this.f26969k.size();
    }

    void h0() throws IOException {
        while (this.f26967i > this.f26965g) {
            s(this.f26969k.values().iterator().next());
        }
        this.f26974p = false;
    }

    public void l0() throws IOException {
        close();
        this.f26959a.g(this.f26960b);
    }

    public synchronized void o0() throws IOException {
        q();
        for (e eVar : (e[]) this.f26969k.values().toArray(new e[this.f26969k.size()])) {
            s(eVar);
        }
        this.f26974p = false;
    }

    public synchronized Iterator<f> p0() throws IOException {
        q();
        return new c();
    }

    public synchronized void q() throws IOException {
        if (!F && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (this.f26972n) {
            return;
        }
        if (this.f26959a.e(this.f26963e)) {
            if (this.f26959a.e(this.f26961c)) {
                this.f26959a.d(this.f26963e);
            } else {
                this.f26959a.c(this.f26963e, this.f26961c);
            }
        }
        if (this.f26959a.e(this.f26961c)) {
            try {
                r0();
                v0();
                this.f26972n = true;
                return;
            } catch (IOException e8) {
                com.haier.library.okhttp.b.i.f.r().h(5, "DiskLruCache " + this.f26960b + " is corrupt: " + e8.getMessage() + ", removing", e8);
                try {
                    l0();
                    this.f26973o = false;
                    C();
                    this.f26972n = true;
                } catch (Throwable th) {
                    this.f26973o = false;
                    throw th;
                }
            }
        }
        C();
        this.f26972n = true;
    }

    synchronized void r(C0356d c0356d, boolean z7) throws IOException {
        e eVar = c0356d.f26986a;
        if (eVar.f26996f != c0356d) {
            throw new IllegalStateException();
        }
        if (z7 && !eVar.f26995e) {
            for (int i7 = 0; i7 < this.f26966h; i7++) {
                if (!c0356d.f26987b[i7]) {
                    c0356d.e();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i7);
                }
                if (!this.f26959a.e(eVar.f26994d[i7])) {
                    c0356d.e();
                    return;
                }
            }
        }
        for (int i8 = 0; i8 < this.f26966h; i8++) {
            File file = eVar.f26994d[i8];
            if (!z7) {
                this.f26959a.d(file);
            } else if (this.f26959a.e(file)) {
                File file2 = eVar.f26993c[i8];
                this.f26959a.c(file, file2);
                long j7 = eVar.f26992b[i8];
                long jF = this.f26959a.f(file2);
                eVar.f26992b[i8] = jF;
                this.f26967i = (this.f26967i - j7) + jF;
            }
        }
        this.f26970l++;
        eVar.f26996f = null;
        if (eVar.f26995e || z7) {
            eVar.f26995e = true;
            this.f26968j.b(B).y1(32);
            this.f26968j.b(eVar.f26991a);
            eVar.b(this.f26968j);
            this.f26968j.y1(10);
            if (z7) {
                long j8 = this.f26976r;
                this.f26976r = 1 + j8;
                eVar.f26997g = j8;
            }
        } else {
            this.f26969k.remove(eVar.f26991a);
            this.f26968j.b(D).y1(32);
            this.f26968j.b(eVar.f26991a);
            this.f26968j.y1(10);
        }
        this.f26968j.flush();
        if (this.f26967i > this.f26965g || g0()) {
            this.f26977s.execute(this.f26978t);
        }
    }

    boolean s(e eVar) throws IOException {
        C0356d c0356d = eVar.f26996f;
        if (c0356d != null) {
            c0356d.b();
        }
        for (int i7 = 0; i7 < this.f26966h; i7++) {
            this.f26959a.d(eVar.f26993c[i7]);
            long j7 = this.f26967i;
            long[] jArr = eVar.f26992b;
            this.f26967i = j7 - jArr[i7];
            jArr[i7] = 0;
        }
        this.f26970l++;
        this.f26968j.b(D).y1(32).b(eVar.f26991a).y1(10);
        this.f26969k.remove(eVar.f26991a);
        if (g0()) {
            this.f26977s.execute(this.f26978t);
        }
        return true;
    }

    @Nullable
    public C0356d u(String str) throws IOException {
        return b(str, -1L);
    }
}
