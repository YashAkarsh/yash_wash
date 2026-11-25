package okhttp3.internal.http2;

import com.facebook.share.internal.ShareConstants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.l2;
import okio.a0;
import okio.o;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Closeable {
    public static final int D = 16777216;

    @a7.d
    private static final m E;
    public static final int F = 1;
    public static final int G = 2;
    public static final int H = 3;
    public static final int I = 1000000000;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final c f38024J = new c(null);

    @a7.d
    private final okhttp3.internal.http2.j A;

    @a7.d
    private final e B;
    private final Set<Integer> C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f38025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final d f38026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final Map<Integer, okhttp3.internal.http2.i> f38027c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final String f38028d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f38029e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f38030f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f38031g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final okhttp3.internal.concurrent.d f38032h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final okhttp3.internal.concurrent.c f38033i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final okhttp3.internal.concurrent.c f38034j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final okhttp3.internal.concurrent.c f38035k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final okhttp3.internal.http2.l f38036l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f38037m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f38038n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f38039o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f38040p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f38041q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f38042r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f38043s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @a7.d
    private final m f38044t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @a7.d
    private m f38045u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private long f38046v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f38047w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f38048x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f38049y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @a7.d
    private final Socket f38050z;

    public static final class a extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f38051e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f38052f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f38053g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, f fVar, long j7) {
            super(str2, false, 2, null);
            this.f38051e = str;
            this.f38052f = fVar;
            this.f38053g = j7;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            boolean z7;
            synchronized (this.f38052f) {
                if (this.f38052f.f38038n < this.f38052f.f38037m) {
                    z7 = true;
                } else {
                    this.f38052f.f38037m++;
                    z7 = false;
                }
            }
            if (z7) {
                this.f38052f.s0(null);
                return -1L;
            }
            this.f38052f.p2(false, 1, 0);
            return this.f38053g;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        public Socket f38054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        public String f38055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        public o f38056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @a7.d
        public okio.n f38057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @a7.d
        private d f38058e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @a7.d
        private okhttp3.internal.http2.l f38059f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f38060g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f38061h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @a7.d
        private final okhttp3.internal.concurrent.d f38062i;

        public b(boolean z7, @a7.d okhttp3.internal.concurrent.d taskRunner) {
            l0.p(taskRunner, "taskRunner");
            this.f38061h = z7;
            this.f38062i = taskRunner;
            this.f38058e = d.f38063a;
            this.f38059f = okhttp3.internal.http2.l.f38202a;
        }

        public static /* synthetic */ b z(b bVar, Socket socket, String str, o oVar, okio.n nVar, int i7, Object obj) throws IOException {
            if ((i7 & 2) != 0) {
                str = okhttp3.internal.d.O(socket);
            }
            if ((i7 & 4) != 0) {
                oVar = a0.d(a0.n(socket));
            }
            if ((i7 & 8) != 0) {
                nVar = a0.c(a0.i(socket));
            }
            return bVar.y(socket, str, oVar, nVar);
        }

        @a7.d
        public final f a() {
            return new f(this);
        }

        public final boolean b() {
            return this.f38061h;
        }

        @a7.d
        public final String c() {
            String str = this.f38055b;
            if (str == null) {
                l0.S("connectionName");
            }
            return str;
        }

        @a7.d
        public final d d() {
            return this.f38058e;
        }

        public final int e() {
            return this.f38060g;
        }

        @a7.d
        public final okhttp3.internal.http2.l f() {
            return this.f38059f;
        }

        @a7.d
        public final okio.n g() {
            okio.n nVar = this.f38057d;
            if (nVar == null) {
                l0.S("sink");
            }
            return nVar;
        }

        @a7.d
        public final Socket h() {
            Socket socket = this.f38054a;
            if (socket == null) {
                l0.S("socket");
            }
            return socket;
        }

        @a7.d
        public final o i() {
            o oVar = this.f38056c;
            if (oVar == null) {
                l0.S(ShareConstants.FEED_SOURCE_PARAM);
            }
            return oVar;
        }

        @a7.d
        public final okhttp3.internal.concurrent.d j() {
            return this.f38062i;
        }

        @a7.d
        public final b k(@a7.d d listener) {
            l0.p(listener, "listener");
            this.f38058e = listener;
            return this;
        }

        @a7.d
        public final b l(int i7) {
            this.f38060g = i7;
            return this;
        }

        @a7.d
        public final b m(@a7.d okhttp3.internal.http2.l pushObserver) {
            l0.p(pushObserver, "pushObserver");
            this.f38059f = pushObserver;
            return this;
        }

        public final void n(boolean z7) {
            this.f38061h = z7;
        }

        public final void o(@a7.d String str) {
            l0.p(str, "<set-?>");
            this.f38055b = str;
        }

        public final void p(@a7.d d dVar) {
            l0.p(dVar, "<set-?>");
            this.f38058e = dVar;
        }

        public final void q(int i7) {
            this.f38060g = i7;
        }

        public final void r(@a7.d okhttp3.internal.http2.l lVar) {
            l0.p(lVar, "<set-?>");
            this.f38059f = lVar;
        }

        public final void s(@a7.d okio.n nVar) {
            l0.p(nVar, "<set-?>");
            this.f38057d = nVar;
        }

        public final void t(@a7.d Socket socket) {
            l0.p(socket, "<set-?>");
            this.f38054a = socket;
        }

        public final void u(@a7.d o oVar) {
            l0.p(oVar, "<set-?>");
            this.f38056c = oVar;
        }

        @a7.d
        @h5.i
        public final b v(@a7.d Socket socket) throws IOException {
            return z(this, socket, null, null, null, 14, null);
        }

        @a7.d
        @h5.i
        public final b w(@a7.d Socket socket, @a7.d String str) throws IOException {
            return z(this, socket, str, null, null, 12, null);
        }

        @a7.d
        @h5.i
        public final b x(@a7.d Socket socket, @a7.d String str, @a7.d o oVar) throws IOException {
            return z(this, socket, str, oVar, null, 8, null);
        }

        @a7.d
        @h5.i
        public final b y(@a7.d Socket socket, @a7.d String peerName, @a7.d o source, @a7.d okio.n sink) throws IOException {
            String str;
            l0.p(socket, "socket");
            l0.p(peerName, "peerName");
            l0.p(source, "source");
            l0.p(sink, "sink");
            this.f38054a = socket;
            if (this.f38061h) {
                str = okhttp3.internal.d.f37862i + ' ' + peerName;
            } else {
                str = "MockWebServer " + peerName;
            }
            this.f38055b = str;
            this.f38056c = source;
            this.f38057d = sink;
            return this;
        }
    }

    public static final class c {
        private c() {
        }

        @a7.d
        public final m a() {
            return f.E;
        }

        public /* synthetic */ c(w wVar) {
            this();
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f38064b = new b(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        @h5.e
        public static final d f38063a = new a();

        public static final class a extends d {
            a() {
            }

            @Override // okhttp3.internal.http2.f.d
            public void b(@a7.d okhttp3.internal.http2.i stream) throws IOException {
                l0.p(stream, "stream");
                stream.d(okhttp3.internal.http2.b.REFUSED_STREAM, null);
            }
        }

        public static final class b {
            private b() {
            }

            public /* synthetic */ b(w wVar) {
                this();
            }
        }

        public void a(@a7.d f connection, @a7.d m settings) {
            l0.p(connection, "connection");
            l0.p(settings, "settings");
        }

        public abstract void b(@a7.d okhttp3.internal.http2.i iVar) throws IOException;
    }

    public final class e implements okhttp3.internal.http2.h.c, i5.a<l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final okhttp3.internal.http2.h f38065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f38066b;

        public static final class a extends okhttp3.internal.concurrent.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f38067e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f38068f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f38069g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ k1.h f38070h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ boolean f38071i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ m f38072j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ k1.g f38073k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ k1.h f38074l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z7, String str2, boolean z8, e eVar, k1.h hVar, boolean z9, m mVar, k1.g gVar, k1.h hVar2) {
                super(str2, z8);
                this.f38067e = str;
                this.f38068f = z7;
                this.f38069g = eVar;
                this.f38070h = hVar;
                this.f38071i = z9;
                this.f38072j = mVar;
                this.f38073k = gVar;
                this.f38074l = hVar2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // okhttp3.internal.concurrent.a
            public long f() {
                this.f38069g.f38066b.I0().a(this.f38069g.f38066b, (m) this.f38070h.f34872a);
                return -1L;
            }
        }

        public static final class b extends okhttp3.internal.concurrent.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f38075e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f38076f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ okhttp3.internal.http2.i f38077g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ e f38078h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ okhttp3.internal.http2.i f38079i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            final /* synthetic */ int f38080j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ List f38081k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ boolean f38082l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z7, String str2, boolean z8, okhttp3.internal.http2.i iVar, e eVar, okhttp3.internal.http2.i iVar2, int i7, List list, boolean z9) {
                super(str2, z8);
                this.f38075e = str;
                this.f38076f = z7;
                this.f38077g = iVar;
                this.f38078h = eVar;
                this.f38079i = iVar2;
                this.f38080j = i7;
                this.f38081k = list;
                this.f38082l = z9;
            }

            @Override // okhttp3.internal.concurrent.a
            public long f() {
                try {
                    this.f38078h.f38066b.I0().b(this.f38077g);
                    return -1L;
                } catch (IOException e8) {
                    okhttp3.internal.platform.k.f38284e.g().m("Http2Connection.Listener failure for " + this.f38078h.f38066b.x0(), 4, e8);
                    try {
                        this.f38077g.d(okhttp3.internal.http2.b.PROTOCOL_ERROR, e8);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        public static final class c extends okhttp3.internal.concurrent.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f38083e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f38084f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f38085g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f38086h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f38087i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z7, String str2, boolean z8, e eVar, int i7, int i8) {
                super(str2, z8);
                this.f38083e = str;
                this.f38084f = z7;
                this.f38085g = eVar;
                this.f38086h = i7;
                this.f38087i = i8;
            }

            @Override // okhttp3.internal.concurrent.a
            public long f() {
                this.f38085g.f38066b.p2(true, this.f38086h, this.f38087i);
                return -1L;
            }
        }

        public static final class d extends okhttp3.internal.concurrent.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f38088e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f38089f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f38090g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ boolean f38091h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ m f38092i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(String str, boolean z7, String str2, boolean z8, e eVar, boolean z9, m mVar) {
                super(str2, z8);
                this.f38088e = str;
                this.f38089f = z7;
                this.f38090g = eVar;
                this.f38091h = z9;
                this.f38092i = mVar;
            }

            @Override // okhttp3.internal.concurrent.a
            public long f() {
                this.f38090g.t(this.f38091h, this.f38092i);
                return -1L;
            }
        }

        public e(@a7.d f fVar, okhttp3.internal.http2.h reader) {
            l0.p(reader, "reader");
            this.f38066b = fVar;
            this.f38065a = reader;
        }

        @Override // okhttp3.internal.http2.h.c
        public void b() {
        }

        @Override // okhttp3.internal.http2.h.c
        public void d(boolean z7, @a7.d m settings) {
            l0.p(settings, "settings");
            okhttp3.internal.concurrent.c cVar = this.f38066b.f38033i;
            String str = this.f38066b.x0() + " applyAndAckSettings";
            cVar.n(new d(str, true, str, true, this, z7, settings), 0L);
        }

        @Override // okhttp3.internal.http2.h.c
        public void e(boolean z7, int i7, int i8, @a7.d List<okhttp3.internal.http2.c> headerBlock) {
            l0.p(headerBlock, "headerBlock");
            if (this.f38066b.Z1(i7)) {
                this.f38066b.R1(i7, headerBlock, z7);
                return;
            }
            synchronized (this.f38066b) {
                okhttp3.internal.http2.i iVarD1 = this.f38066b.d1(i7);
                if (iVarD1 != null) {
                    l2 l2Var = l2.f34958a;
                    iVarD1.z(okhttp3.internal.d.X(headerBlock), z7);
                    return;
                }
                if (this.f38066b.f38031g) {
                    return;
                }
                if (i7 <= this.f38066b.G0()) {
                    return;
                }
                if (i7 % 2 == this.f38066b.J0() % 2) {
                    return;
                }
                okhttp3.internal.http2.i iVar = new okhttp3.internal.http2.i(i7, this.f38066b, false, z7, okhttp3.internal.d.X(headerBlock));
                this.f38066b.c2(i7);
                this.f38066b.e1().put(Integer.valueOf(i7), iVar);
                okhttp3.internal.concurrent.c cVarJ = this.f38066b.f38032h.j();
                String str = this.f38066b.x0() + '[' + i7 + "] onStream";
                cVarJ.n(new b(str, true, str, true, iVar, this, iVarD1, i7, headerBlock, z7), 0L);
            }
        }

        @Override // okhttp3.internal.http2.h.c
        public void f(int i7, long j7) {
            if (i7 != 0) {
                okhttp3.internal.http2.i iVarD1 = this.f38066b.d1(i7);
                if (iVarD1 != null) {
                    synchronized (iVarD1) {
                        iVarD1.a(j7);
                        l2 l2Var = l2.f34958a;
                    }
                    return;
                }
                return;
            }
            synchronized (this.f38066b) {
                f fVar = this.f38066b;
                fVar.f38049y = fVar.i1() + j7;
                f fVar2 = this.f38066b;
                if (fVar2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                }
                fVar2.notifyAll();
                l2 l2Var2 = l2.f34958a;
            }
        }

        @Override // okhttp3.internal.http2.h.c
        public void g(int i7, @a7.d String origin, @a7.d p protocol, @a7.d String host, int i8, long j7) {
            l0.p(origin, "origin");
            l0.p(protocol, "protocol");
            l0.p(host, "host");
        }

        @Override // okhttp3.internal.http2.h.c
        public void i(boolean z7, int i7, @a7.d o source, int i8) throws IOException {
            l0.p(source, "source");
            if (this.f38066b.Z1(i7)) {
                this.f38066b.N1(i7, source, i8, z7);
                return;
            }
            okhttp3.internal.http2.i iVarD1 = this.f38066b.d1(i7);
            if (iVarD1 == null) {
                this.f38066b.s2(i7, okhttp3.internal.http2.b.PROTOCOL_ERROR);
                long j7 = i8;
                this.f38066b.l2(j7);
                source.skip(j7);
                return;
            }
            iVarD1.y(source, i8);
            if (z7) {
                iVarD1.z(okhttp3.internal.d.f37855b, true);
            }
        }

        @Override // i5.a
        public /* bridge */ /* synthetic */ l2 invoke() throws Throwable {
            x();
            return l2.f34958a;
        }

        @Override // okhttp3.internal.http2.h.c
        public void j(boolean z7, int i7, int i8) {
            if (!z7) {
                okhttp3.internal.concurrent.c cVar = this.f38066b.f38033i;
                String str = this.f38066b.x0() + " ping";
                cVar.n(new c(str, true, str, true, this, i7, i8), 0L);
                return;
            }
            synchronized (this.f38066b) {
                try {
                    if (i7 == 1) {
                        this.f38066b.f38038n++;
                    } else if (i7 != 2) {
                        if (i7 == 3) {
                            this.f38066b.f38042r++;
                            f fVar = this.f38066b;
                            if (fVar == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                            fVar.notifyAll();
                        }
                        l2 l2Var = l2.f34958a;
                    } else {
                        this.f38066b.f38040p++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // okhttp3.internal.http2.h.c
        public void m(int i7, int i8, int i9, boolean z7) {
        }

        @Override // okhttp3.internal.http2.h.c
        public void q(int i7, @a7.d okhttp3.internal.http2.b errorCode) {
            l0.p(errorCode, "errorCode");
            if (this.f38066b.Z1(i7)) {
                this.f38066b.X1(i7, errorCode);
                return;
            }
            okhttp3.internal.http2.i iVarA2 = this.f38066b.a2(i7);
            if (iVarA2 != null) {
                iVarA2.A(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.h.c
        public void r(int i7, int i8, @a7.d List<okhttp3.internal.http2.c> requestHeaders) {
            l0.p(requestHeaders, "requestHeaders");
            this.f38066b.W1(i8, requestHeaders);
        }

        @Override // okhttp3.internal.http2.h.c
        public void s(int i7, @a7.d okhttp3.internal.http2.b errorCode, @a7.d p debugData) {
            int i8;
            okhttp3.internal.http2.i[] iVarArr;
            l0.p(errorCode, "errorCode");
            l0.p(debugData, "debugData");
            debugData.a0();
            synchronized (this.f38066b) {
                Object[] array = this.f38066b.e1().values().toArray(new okhttp3.internal.http2.i[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                iVarArr = (okhttp3.internal.http2.i[]) array;
                this.f38066b.f38031g = true;
                l2 l2Var = l2.f34958a;
            }
            for (okhttp3.internal.http2.i iVar : iVarArr) {
                if (iVar.k() > i7 && iVar.v()) {
                    iVar.A(okhttp3.internal.http2.b.REFUSED_STREAM);
                    this.f38066b.a2(iVar.k());
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, okhttp3.internal.http2.m] */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        public final void t(boolean z7, @a7.d m settings) {
            f fVar;
            ?? r7;
            T t7;
            l0.p(settings, "settings");
            k1.g gVar = new k1.g();
            k1.h hVar = new k1.h();
            k1.h hVar2 = new k1.h();
            synchronized (this.f38066b.s1()) {
                f fVar2 = this.f38066b;
                synchronized (fVar2) {
                    try {
                        m mVarQ0 = this.f38066b.Q0();
                        if (z7) {
                            r7 = settings;
                        } else {
                            m mVar = new m();
                            mVar.j(mVarQ0);
                            mVar.j(settings);
                            l2 l2Var = l2.f34958a;
                            r7 = mVar;
                        }
                        hVar2.f34872a = r7;
                        long jE = ((long) r7.e()) - ((long) mVarQ0.e());
                        gVar.f34871a = jE;
                        if (jE == 0 || this.f38066b.e1().isEmpty()) {
                            t7 = 0;
                        } else {
                            Object[] array = this.f38066b.e1().values().toArray(new okhttp3.internal.http2.i[0]);
                            if (array == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                            t7 = (okhttp3.internal.http2.i[]) array;
                        }
                        hVar.f34872a = t7;
                        this.f38066b.e2((m) hVar2.f34872a);
                        okhttp3.internal.concurrent.c cVar = this.f38066b.f38035k;
                        String str = this.f38066b.x0() + " onSettings";
                        fVar = fVar2;
                        try {
                            cVar.n(new a(str, true, str, true, this, hVar2, z7, settings, gVar, hVar), 0L);
                            l2 l2Var2 = l2.f34958a;
                            try {
                                this.f38066b.s1().b((m) hVar2.f34872a);
                            } catch (IOException e8) {
                                this.f38066b.s0(e8);
                            }
                            l2 l2Var3 = l2.f34958a;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fVar = fVar2;
                    }
                }
            }
            T t8 = hVar.f34872a;
            if (((okhttp3.internal.http2.i[]) t8) != null) {
                okhttp3.internal.http2.i[] iVarArr = (okhttp3.internal.http2.i[]) t8;
                l0.m(iVarArr);
                for (okhttp3.internal.http2.i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(gVar.f34871a);
                        l2 l2Var4 = l2.f34958a;
                    }
                }
            }
        }

        @a7.d
        public final okhttp3.internal.http2.h w() {
            return this.f38065a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.b] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, okhttp3.internal.http2.h] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void x() throws Throwable {
            okhttp3.internal.http2.b bVar;
            okhttp3.internal.http2.b bVar2 = okhttp3.internal.http2.b.INTERNAL_ERROR;
            IOException e8 = null;
            try {
                try {
                    this.f38065a.e(this);
                    while (this.f38065a.c(false, this)) {
                    }
                    okhttp3.internal.http2.b bVar3 = okhttp3.internal.http2.b.NO_ERROR;
                    try {
                        this.f38066b.r0(bVar3, okhttp3.internal.http2.b.CANCEL, null);
                        bVar = bVar3;
                    } catch (IOException e9) {
                        e8 = e9;
                        okhttp3.internal.http2.b bVar4 = okhttp3.internal.http2.b.PROTOCOL_ERROR;
                        f fVar = this.f38066b;
                        fVar.r0(bVar4, bVar4, e8);
                        bVar = fVar;
                    }
                } catch (Throwable th) {
                    th = th;
                    this.f38066b.r0(bVar, bVar2, e8);
                    okhttp3.internal.d.l(this.f38065a);
                    throw th;
                }
            } catch (IOException e10) {
                e8 = e10;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                this.f38066b.r0(bVar, bVar2, e8);
                okhttp3.internal.d.l(this.f38065a);
                throw th;
            }
            bVar2 = this.f38065a;
            okhttp3.internal.d.l(bVar2);
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.http2.f$f, reason: collision with other inner class name */
    public static final class C0507f extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f38093e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f38094f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f38095g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f38096h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ okio.m f38097i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f38098j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ boolean f38099k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0507f(String str, boolean z7, String str2, boolean z8, f fVar, int i7, okio.m mVar, int i8, boolean z9) {
            super(str2, z8);
            this.f38093e = str;
            this.f38094f = z7;
            this.f38095g = fVar;
            this.f38096h = i7;
            this.f38097i = mVar;
            this.f38098j = i8;
            this.f38099k = z9;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            try {
                boolean zD = this.f38095g.f38036l.d(this.f38096h, this.f38097i, this.f38098j, this.f38099k);
                if (zD) {
                    this.f38095g.s1().E(this.f38096h, okhttp3.internal.http2.b.CANCEL);
                }
                if (!zD && !this.f38099k) {
                    return -1L;
                }
                synchronized (this.f38095g) {
                    this.f38095g.C.remove(Integer.valueOf(this.f38096h));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class g extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f38100e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f38101f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f38102g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f38103h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f38104i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ boolean f38105j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z7, String str2, boolean z8, f fVar, int i7, List list, boolean z9) {
            super(str2, z8);
            this.f38100e = str;
            this.f38101f = z7;
            this.f38102g = fVar;
            this.f38103h = i7;
            this.f38104i = list;
            this.f38105j = z9;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            boolean zB = this.f38102g.f38036l.b(this.f38103h, this.f38104i, this.f38105j);
            if (zB) {
                try {
                    this.f38102g.s1().E(this.f38103h, okhttp3.internal.http2.b.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!zB && !this.f38105j) {
                return -1L;
            }
            synchronized (this.f38102g) {
                this.f38102g.C.remove(Integer.valueOf(this.f38103h));
            }
            return -1L;
        }
    }

    public static final class h extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f38106e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f38107f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f38108g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f38109h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ List f38110i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z7, String str2, boolean z8, f fVar, int i7, List list) {
            super(str2, z8);
            this.f38106e = str;
            this.f38107f = z7;
            this.f38108g = fVar;
            this.f38109h = i7;
            this.f38110i = list;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            if (!this.f38108g.f38036l.a(this.f38109h, this.f38110i)) {
                return -1L;
            }
            try {
                this.f38108g.s1().E(this.f38109h, okhttp3.internal.http2.b.CANCEL);
                synchronized (this.f38108g) {
                    this.f38108g.C.remove(Integer.valueOf(this.f38109h));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class i extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f38111e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f38112f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f38113g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f38114h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ okhttp3.internal.http2.b f38115i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z7, String str2, boolean z8, f fVar, int i7, okhttp3.internal.http2.b bVar) {
            super(str2, z8);
            this.f38111e = str;
            this.f38112f = z7;
            this.f38113g = fVar;
            this.f38114h = i7;
            this.f38115i = bVar;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            this.f38113g.f38036l.c(this.f38114h, this.f38115i);
            synchronized (this.f38113g) {
                this.f38113g.C.remove(Integer.valueOf(this.f38114h));
                l2 l2Var = l2.f34958a;
            }
            return -1L;
        }
    }

    public static final class j extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f38116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f38117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f38118g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, boolean z7, String str2, boolean z8, f fVar) {
            super(str2, z8);
            this.f38116e = str;
            this.f38117f = z7;
            this.f38118g = fVar;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            this.f38118g.p2(false, 2, 0);
            return -1L;
        }
    }

    public static final class k extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f38119e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f38120f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f38121g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f38122h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ okhttp3.internal.http2.b f38123i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z7, String str2, boolean z8, f fVar, int i7, okhttp3.internal.http2.b bVar) {
            super(str2, z8);
            this.f38119e = str;
            this.f38120f = z7;
            this.f38121g = fVar;
            this.f38122h = i7;
            this.f38123i = bVar;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            try {
                this.f38121g.r2(this.f38122h, this.f38123i);
                return -1L;
            } catch (IOException e8) {
                this.f38121g.s0(e8);
                return -1L;
            }
        }
    }

    public static final class l extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f38124e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f38125f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f38126g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f38127h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f38128i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z7, String str2, boolean z8, f fVar, int i7, long j7) {
            super(str2, z8);
            this.f38124e = str;
            this.f38125f = z7;
            this.f38126g = fVar;
            this.f38127h = i7;
            this.f38128i = j7;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            try {
                this.f38126g.s1().G(this.f38127h, this.f38128i);
                return -1L;
            } catch (IOException e8) {
                this.f38126g.s0(e8);
                return -1L;
            }
        }
    }

    static {
        m mVar = new m();
        mVar.k(7, 65535);
        mVar.k(5, 16384);
        E = mVar;
    }

    public f(@a7.d b builder) {
        l0.p(builder, "builder");
        boolean zB = builder.b();
        this.f38025a = zB;
        this.f38026b = builder.d();
        this.f38027c = new LinkedHashMap();
        String strC = builder.c();
        this.f38028d = strC;
        this.f38030f = builder.b() ? 3 : 2;
        okhttp3.internal.concurrent.d dVarJ = builder.j();
        this.f38032h = dVarJ;
        okhttp3.internal.concurrent.c cVarJ = dVarJ.j();
        this.f38033i = cVarJ;
        this.f38034j = dVarJ.j();
        this.f38035k = dVarJ.j();
        this.f38036l = builder.f();
        m mVar = new m();
        if (builder.b()) {
            mVar.k(7, 16777216);
        }
        l2 l2Var = l2.f34958a;
        this.f38044t = mVar;
        m mVar2 = E;
        this.f38045u = mVar2;
        this.f38049y = mVar2.e();
        this.f38050z = builder.h();
        this.A = new okhttp3.internal.http2.j(builder.g(), zB);
        this.B = new e(this, new okhttp3.internal.http2.h(builder.i(), zB));
        this.C = new LinkedHashSet();
        if (builder.e() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.e());
            String str = strC + " ping";
            cVarJ.n(new a(str, str, this, nanos), nanos);
        }
    }

    public static /* synthetic */ void k2(f fVar, boolean z7, okhttp3.internal.concurrent.d dVar, int i7, Object obj) throws IOException {
        if ((i7 & 1) != 0) {
            z7 = true;
        }
        if ((i7 & 2) != 0) {
            dVar = okhttp3.internal.concurrent.d.f37734h;
        }
        fVar.j2(z7, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s0(IOException iOException) {
        okhttp3.internal.http2.b bVar = okhttp3.internal.http2.b.PROTOCOL_ERROR;
        r0(bVar, bVar, iOException);
    }

    private final okhttp3.internal.http2.i z1(int i7, List<okhttp3.internal.http2.c> list, boolean z7) throws IOException {
        int i8;
        okhttp3.internal.http2.i iVar;
        boolean z8;
        boolean z9 = !z7;
        synchronized (this.A) {
            synchronized (this) {
                if (this.f38030f > 1073741823) {
                    g2(okhttp3.internal.http2.b.REFUSED_STREAM);
                }
                if (this.f38031g) {
                    throw new okhttp3.internal.http2.a();
                }
                i8 = this.f38030f;
                this.f38030f = i8 + 2;
                iVar = new okhttp3.internal.http2.i(i8, this, z9, false, null);
                z8 = !z7 || this.f38048x >= this.f38049y || iVar.t() >= iVar.s();
                if (iVar.w()) {
                    this.f38027c.put(Integer.valueOf(i8), iVar);
                }
                l2 l2Var = l2.f34958a;
            }
            if (i7 == 0) {
                this.A.s(z9, i8, list);
            } else {
                if (!(true ^ this.f38025a)) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                }
                this.A.C(i7, i8, list);
            }
        }
        if (z8) {
            this.A.flush();
        }
        return iVar;
    }

    @a7.d
    public final okhttp3.internal.http2.i A1(@a7.d List<okhttp3.internal.http2.c> requestHeaders, boolean z7) throws IOException {
        l0.p(requestHeaders, "requestHeaders");
        return z1(0, requestHeaders, z7);
    }

    public final synchronized int B1() {
        return this.f38027c.size();
    }

    public final int G0() {
        return this.f38029e;
    }

    @a7.d
    public final d I0() {
        return this.f38026b;
    }

    public final int J0() {
        return this.f38030f;
    }

    @a7.d
    public final m L0() {
        return this.f38044t;
    }

    public final void N1(int i7, @a7.d o source, int i8, boolean z7) throws IOException {
        l0.p(source, "source");
        okio.m mVar = new okio.m();
        long j7 = i8;
        source.G1(j7);
        source.read(mVar, j7);
        okhttp3.internal.concurrent.c cVar = this.f38034j;
        String str = this.f38028d + '[' + i7 + "] onData";
        cVar.n(new C0507f(str, true, str, true, this, i7, mVar, i8, z7), 0L);
    }

    @a7.d
    public final m Q0() {
        return this.f38045u;
    }

    public final void R1(int i7, @a7.d List<okhttp3.internal.http2.c> requestHeaders, boolean z7) {
        l0.p(requestHeaders, "requestHeaders");
        okhttp3.internal.concurrent.c cVar = this.f38034j;
        String str = this.f38028d + '[' + i7 + "] onHeaders";
        cVar.n(new g(str, true, str, true, this, i7, requestHeaders, z7), 0L);
    }

    public final long T0() {
        return this.f38047w;
    }

    public final long V0() {
        return this.f38046v;
    }

    public final void W1(int i7, @a7.d List<okhttp3.internal.http2.c> requestHeaders) {
        l0.p(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.C.contains(Integer.valueOf(i7))) {
                s2(i7, okhttp3.internal.http2.b.PROTOCOL_ERROR);
                return;
            }
            this.C.add(Integer.valueOf(i7));
            okhttp3.internal.concurrent.c cVar = this.f38034j;
            String str = this.f38028d + '[' + i7 + "] onRequest";
            cVar.n(new h(str, true, str, true, this, i7, requestHeaders), 0L);
        }
    }

    public final void X1(int i7, @a7.d okhttp3.internal.http2.b errorCode) {
        l0.p(errorCode, "errorCode");
        okhttp3.internal.concurrent.c cVar = this.f38034j;
        String str = this.f38028d + '[' + i7 + "] onReset";
        cVar.n(new i(str, true, str, true, this, i7, errorCode), 0L);
    }

    @a7.d
    public final e Y0() {
        return this.B;
    }

    @a7.d
    public final okhttp3.internal.http2.i Y1(int i7, @a7.d List<okhttp3.internal.http2.c> requestHeaders, boolean z7) throws IOException {
        l0.p(requestHeaders, "requestHeaders");
        if (!this.f38025a) {
            return z1(i7, requestHeaders, z7);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final boolean Z1(int i7) {
        return i7 != 0 && (i7 & 1) == 0;
    }

    @a7.d
    public final Socket a1() {
        return this.f38050z;
    }

    @a7.e
    public final synchronized okhttp3.internal.http2.i a2(int i7) {
        okhttp3.internal.http2.i iVarRemove;
        iVarRemove = this.f38027c.remove(Integer.valueOf(i7));
        notifyAll();
        return iVarRemove;
    }

    public final void b2() {
        synchronized (this) {
            long j7 = this.f38040p;
            long j8 = this.f38039o;
            if (j7 < j8) {
                return;
            }
            this.f38039o = j8 + 1;
            this.f38043s = System.nanoTime() + ((long) 1000000000);
            l2 l2Var = l2.f34958a;
            okhttp3.internal.concurrent.c cVar = this.f38033i;
            String str = this.f38028d + " ping";
            cVar.n(new j(str, true, str, true, this), 0L);
        }
    }

    public final void c2(int i7) {
        this.f38029e = i7;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        r0(okhttp3.internal.http2.b.NO_ERROR, okhttp3.internal.http2.b.CANCEL, null);
    }

    @a7.e
    public final synchronized okhttp3.internal.http2.i d1(int i7) {
        return this.f38027c.get(Integer.valueOf(i7));
    }

    public final void d2(int i7) {
        this.f38030f = i7;
    }

    @a7.d
    public final Map<Integer, okhttp3.internal.http2.i> e1() {
        return this.f38027c;
    }

    public final void e2(@a7.d m mVar) {
        l0.p(mVar, "<set-?>");
        this.f38045u = mVar;
    }

    public final void f2(@a7.d m settings) throws IOException {
        l0.p(settings, "settings");
        synchronized (this.A) {
            synchronized (this) {
                if (this.f38031g) {
                    throw new okhttp3.internal.http2.a();
                }
                this.f38044t.j(settings);
                l2 l2Var = l2.f34958a;
            }
            this.A.F(settings);
        }
    }

    public final void flush() throws IOException {
        this.A.flush();
    }

    public final void g2(@a7.d okhttp3.internal.http2.b statusCode) throws IOException {
        l0.p(statusCode, "statusCode");
        synchronized (this.A) {
            synchronized (this) {
                if (this.f38031g) {
                    return;
                }
                this.f38031g = true;
                int i7 = this.f38029e;
                l2 l2Var = l2.f34958a;
                this.A.r(i7, statusCode, okhttp3.internal.d.f37854a);
            }
        }
    }

    @h5.i
    public final void h2() throws IOException {
        k2(this, false, null, 3, null);
    }

    public final long i1() {
        return this.f38049y;
    }

    @h5.i
    public final void i2(boolean z7) throws IOException {
        k2(this, z7, null, 2, null);
    }

    @h5.i
    public final void j2(boolean z7, @a7.d okhttp3.internal.concurrent.d taskRunner) throws IOException {
        l0.p(taskRunner, "taskRunner");
        if (z7) {
            this.A.e();
            this.A.F(this.f38044t);
            int iE = this.f38044t.e();
            if (iE != 65535) {
                this.A.G(0, iE - 65535);
            }
        }
        okhttp3.internal.concurrent.c cVarJ = taskRunner.j();
        String str = this.f38028d;
        cVarJ.n(new okhttp3.internal.concurrent.c.b(this.B, str, true, str, true), 0L);
    }

    public final synchronized void l2(long j7) {
        long j8 = this.f38046v + j7;
        this.f38046v = j8;
        long j9 = j8 - this.f38047w;
        if (j9 >= this.f38044t.e() / 2) {
            t2(0, j9);
            this.f38047w += j9;
        }
    }

    public final void m2(int i7, boolean z7, @a7.e okio.m mVar, long j7) throws IOException {
        long j8;
        long j9;
        int iMin;
        long j10;
        if (j7 == 0) {
            this.A.f(z7, i7, mVar, 0);
            return;
        }
        while (j7 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j8 = this.f38048x;
                        j9 = this.f38049y;
                        if (j8 >= j9) {
                            if (!this.f38027c.containsKey(Integer.valueOf(i7))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                    throw th;
                }
                iMin = Math.min((int) Math.min(j7, j9 - j8), this.A.u());
                j10 = iMin;
                this.f38048x += j10;
                l2 l2Var = l2.f34958a;
            }
            j7 -= j10;
            this.A.f(z7 && j7 == 0, i7, mVar, iMin);
        }
    }

    public final void n2(int i7, boolean z7, @a7.d List<okhttp3.internal.http2.c> alternating) throws IOException {
        l0.p(alternating, "alternating");
        this.A.s(z7, i7, alternating);
    }

    public final void o2() throws InterruptedException {
        synchronized (this) {
            this.f38041q++;
        }
        p2(false, 3, 1330343787);
    }

    public final synchronized void p0() throws InterruptedException {
        while (this.f38042r < this.f38041q) {
            wait();
        }
    }

    public final void p2(boolean z7, int i7, int i8) {
        try {
            this.A.v(z7, i7, i8);
        } catch (IOException e8) {
            s0(e8);
        }
    }

    public final long q1() {
        return this.f38048x;
    }

    public final void q2() throws InterruptedException {
        o2();
        p0();
    }

    public final void r0(@a7.d okhttp3.internal.http2.b connectionCode, @a7.d okhttp3.internal.http2.b streamCode, @a7.e IOException iOException) {
        int i7;
        okhttp3.internal.http2.i[] iVarArr;
        l0.p(connectionCode, "connectionCode");
        l0.p(streamCode, "streamCode");
        if (okhttp3.internal.d.f37861h && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            l0.o(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        try {
            g2(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (!this.f38027c.isEmpty()) {
                Object[] array = this.f38027c.values().toArray(new okhttp3.internal.http2.i[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                iVarArr = (okhttp3.internal.http2.i[]) array;
                this.f38027c.clear();
            } else {
                iVarArr = null;
            }
            l2 l2Var = l2.f34958a;
        }
        if (iVarArr != null) {
            for (okhttp3.internal.http2.i iVar : iVarArr) {
                try {
                    iVar.d(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.A.close();
        } catch (IOException unused3) {
        }
        try {
            this.f38050z.close();
        } catch (IOException unused4) {
        }
        this.f38033i.u();
        this.f38034j.u();
        this.f38035k.u();
    }

    public final void r2(int i7, @a7.d okhttp3.internal.http2.b statusCode) throws IOException {
        l0.p(statusCode, "statusCode");
        this.A.E(i7, statusCode);
    }

    @a7.d
    public final okhttp3.internal.http2.j s1() {
        return this.A;
    }

    public final void s2(int i7, @a7.d okhttp3.internal.http2.b errorCode) {
        l0.p(errorCode, "errorCode");
        okhttp3.internal.concurrent.c cVar = this.f38033i;
        String str = this.f38028d + '[' + i7 + "] writeSynReset";
        cVar.n(new k(str, true, str, true, this, i7, errorCode), 0L);
    }

    public final void t2(int i7, long j7) {
        okhttp3.internal.concurrent.c cVar = this.f38033i;
        String str = this.f38028d + '[' + i7 + "] windowUpdate";
        cVar.n(new l(str, true, str, true, this, i7, j7), 0L);
    }

    public final boolean v0() {
        return this.f38025a;
    }

    public final synchronized boolean w1(long j7) {
        if (this.f38031g) {
            return false;
        }
        return this.f38040p >= this.f38039o || j7 < this.f38043s;
    }

    @a7.d
    public final String x0() {
        return this.f38028d;
    }
}
