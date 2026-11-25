package okhttp3.internal.cache2;

import a7.d;
import h5.e;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.l2;
import okio.m;
import okio.o0;
import okio.p;
import okio.q0;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f37698k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f37699l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @d
    @e
    public static final p f37700m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @d
    @e
    public static final p f37701n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final long f37702o = 32;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f37703p = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private Thread f37704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d
    private final m f37705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @d
    private final m f37707d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37708e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.e
    private RandomAccessFile f37709f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @a7.e
    private o0 f37710g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f37711h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final p f37712i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f37713j;

    public static final class a {
        private a() {
        }

        @d
        public final b a(@d File file, @d o0 upstream, @d p metadata, long j7) throws IOException {
            l0.p(file, "file");
            l0.p(upstream, "upstream");
            l0.p(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            b bVar = new b(randomAccessFile, upstream, 0L, metadata, j7, null);
            randomAccessFile.setLength(0L);
            bVar.u(b.f37701n, -1L, -1L);
            return bVar;
        }

        @d
        public final b b(@d File file) throws IOException {
            l0.p(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            l0.o(channel, "randomAccessFile.channel");
            okhttp3.internal.cache2.a aVar = new okhttp3.internal.cache2.a(channel);
            m mVar = new m();
            aVar.a(0L, mVar, 32L);
            p pVar = b.f37700m;
            if (!l0.g(mVar.l(pVar.a0()), pVar)) {
                throw new IOException("unreadable cache file");
            }
            long j7 = mVar.readLong();
            long j8 = mVar.readLong();
            m mVar2 = new m();
            aVar.a(j7 + 32, mVar2, j8);
            return new b(randomAccessFile, null, j7, mVar2.E0(), 0L, null);
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.cache2.b$b, reason: collision with other inner class name */
    public final class C0502b implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q0 f37714a = new q0();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private okhttp3.internal.cache2.a f37715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f37716c;

        public C0502b() {
            RandomAccessFile randomAccessFileF = b.this.f();
            l0.m(randomAccessFileF);
            FileChannel channel = randomAccessFileF.getChannel();
            l0.o(channel, "file!!.channel");
            this.f37715b = new okhttp3.internal.cache2.a(channel);
        }

        @Override // okio.o0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f37715b == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.f37715b = null;
            synchronized (b.this) {
                b bVar = b.this;
                bVar.q(bVar.g() - 1);
                if (b.this.g() == 0) {
                    RandomAccessFile randomAccessFileF = b.this.f();
                    b.this.p(null);
                    randomAccessFile = randomAccessFileF;
                }
                l2 l2Var = l2.f34958a;
            }
            if (randomAccessFile != null) {
                okhttp3.internal.d.l(randomAccessFile);
            }
        }

        @Override // okio.o0
        public long read(@d m sink, long j7) throws IOException {
            l0.p(sink, "sink");
            char c8 = 1;
            if (!(this.f37715b != null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            synchronized (b.this) {
                while (true) {
                    if (this.f37716c == b.this.j()) {
                        if (!b.this.e()) {
                            if (b.this.k() == null) {
                                b.this.t(Thread.currentThread());
                                break;
                            }
                            this.f37714a.k(b.this);
                        } else {
                            return -1L;
                        }
                    } else {
                        long j8 = b.this.j() - b.this.c().B1();
                        if (this.f37716c < j8) {
                            c8 = 2;
                            break;
                        }
                        long jMin = Math.min(j7, b.this.j() - this.f37716c);
                        b.this.c().Q(sink, this.f37716c - j8, jMin);
                        this.f37716c += jMin;
                        return jMin;
                    }
                }
                if (c8 == 2) {
                    long jMin2 = Math.min(j7, b.this.j() - this.f37716c);
                    okhttp3.internal.cache2.a aVar = this.f37715b;
                    l0.m(aVar);
                    aVar.a(this.f37716c + 32, sink, jMin2);
                    this.f37716c += jMin2;
                    return jMin2;
                }
                try {
                    o0 o0VarH = b.this.h();
                    l0.m(o0VarH);
                    long j9 = o0VarH.read(b.this.i(), b.this.d());
                    if (j9 == -1) {
                        b bVar = b.this;
                        bVar.b(bVar.j());
                        synchronized (b.this) {
                            b.this.t(null);
                            b bVar2 = b.this;
                            if (bVar2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            bVar2.notifyAll();
                            l2 l2Var = l2.f34958a;
                        }
                        return -1L;
                    }
                    long jMin3 = Math.min(j9, j7);
                    b.this.i().Q(sink, 0L, jMin3);
                    this.f37716c += jMin3;
                    okhttp3.internal.cache2.a aVar2 = this.f37715b;
                    l0.m(aVar2);
                    aVar2.b(b.this.j() + 32, b.this.i().clone(), j9);
                    synchronized (b.this) {
                        b.this.c().write(b.this.i(), j9);
                        if (b.this.c().B1() > b.this.d()) {
                            b.this.c().skip(b.this.c().B1() - b.this.d());
                        }
                        b bVar3 = b.this;
                        bVar3.s(bVar3.j() + j9);
                        l2 l2Var2 = l2.f34958a;
                    }
                    synchronized (b.this) {
                        b.this.t(null);
                        b bVar4 = b.this;
                        if (bVar4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        bVar4.notifyAll();
                    }
                    return jMin3;
                } catch (Throwable th) {
                    synchronized (b.this) {
                        b.this.t(null);
                        b bVar5 = b.this;
                        if (bVar5 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        }
                        bVar5.notifyAll();
                        l2 l2Var3 = l2.f34958a;
                        throw th;
                    }
                }
            }
        }

        @Override // okio.o0
        @d
        public q0 timeout() {
            return this.f37714a;
        }
    }

    static {
        p.a aVar = p.f38508f;
        f37700m = aVar.l("OkHttp cache v1\n");
        f37701n = aVar.l("OkHttp DIRTY :(\n");
    }

    private b(RandomAccessFile randomAccessFile, o0 o0Var, long j7, p pVar, long j8) {
        this.f37709f = randomAccessFile;
        this.f37710g = o0Var;
        this.f37711h = j7;
        this.f37712i = pVar;
        this.f37713j = j8;
        this.f37705b = new m();
        this.f37706c = this.f37710g == null;
        this.f37707d = new m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(p pVar, long j7, long j8) throws IOException {
        m mVar = new m();
        mVar.p1(pVar);
        mVar.writeLong(j7);
        mVar.writeLong(j8);
        if (!(mVar.B1() == 32)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        RandomAccessFile randomAccessFile = this.f37709f;
        l0.m(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        l0.o(channel, "file!!.channel");
        new okhttp3.internal.cache2.a(channel).b(0L, mVar, 32L);
    }

    private final void v(long j7) throws IOException {
        m mVar = new m();
        mVar.p1(this.f37712i);
        RandomAccessFile randomAccessFile = this.f37709f;
        l0.m(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        l0.o(channel, "file!!.channel");
        new okhttp3.internal.cache2.a(channel).b(32 + j7, mVar, this.f37712i.a0());
    }

    public final void b(long j7) throws IOException {
        v(j7);
        RandomAccessFile randomAccessFile = this.f37709f;
        l0.m(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        u(f37700m, j7, this.f37712i.a0());
        RandomAccessFile randomAccessFile2 = this.f37709f;
        l0.m(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.f37706c = true;
            l2 l2Var = l2.f34958a;
        }
        o0 o0Var = this.f37710g;
        if (o0Var != null) {
            okhttp3.internal.d.l(o0Var);
        }
        this.f37710g = null;
    }

    @d
    public final m c() {
        return this.f37707d;
    }

    public final long d() {
        return this.f37713j;
    }

    public final boolean e() {
        return this.f37706c;
    }

    @a7.e
    public final RandomAccessFile f() {
        return this.f37709f;
    }

    public final int g() {
        return this.f37708e;
    }

    @a7.e
    public final o0 h() {
        return this.f37710g;
    }

    @d
    public final m i() {
        return this.f37705b;
    }

    public final long j() {
        return this.f37711h;
    }

    @a7.e
    public final Thread k() {
        return this.f37704a;
    }

    public final boolean l() {
        return this.f37709f == null;
    }

    @d
    public final p m() {
        return this.f37712i;
    }

    @a7.e
    public final o0 n() {
        synchronized (this) {
            if (this.f37709f == null) {
                return null;
            }
            this.f37708e++;
            return new C0502b();
        }
    }

    public final void o(boolean z7) {
        this.f37706c = z7;
    }

    public final void p(@a7.e RandomAccessFile randomAccessFile) {
        this.f37709f = randomAccessFile;
    }

    public final void q(int i7) {
        this.f37708e = i7;
    }

    public final void r(@a7.e o0 o0Var) {
        this.f37710g = o0Var;
    }

    public final void s(long j7) {
        this.f37711h = j7;
    }

    public final void t(@a7.e Thread thread) {
        this.f37704a = thread;
    }

    public /* synthetic */ b(RandomAccessFile randomAccessFile, o0 o0Var, long j7, p pVar, long j8, w wVar) {
        this(randomAccessFile, o0Var, j7, pVar, j8);
    }
}
