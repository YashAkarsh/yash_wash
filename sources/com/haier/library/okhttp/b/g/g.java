package com.haier.library.okhttp.b.g;

import com.haier.library.a.t;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Closeable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final int f27222u = 16777216;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final ExecutorService f27223v = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.haier.library.okhttp.n.d.p("OkHttp Http2Connection", true));

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final /* synthetic */ boolean f27224w = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f27225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h f27226b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f27228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f27229e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f27230f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f27231g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ScheduledExecutorService f27232h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ExecutorService f27233i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final l f27234j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f27235k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    long f27237m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final m f27239o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f27240p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final Socket f27241q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final com.haier.library.okhttp.b.g.j f27242r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final j f27243s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final Set<Integer> f27244t;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map<Integer, com.haier.library.okhttp.b.g.i> f27227c = new LinkedHashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    long f27236l = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    m f27238n = new m();

    class a extends com.haier.library.okhttp.n.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.haier.library.okhttp.b.g.b f27246c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i7, com.haier.library.okhttp.b.g.b bVar) {
            super(str, objArr);
            this.f27245b = i7;
            this.f27246c = bVar;
        }

        @Override // com.haier.library.okhttp.n.c
        public void k() {
            try {
                g.this.o0(this.f27245b, this.f27246c);
            } catch (IOException unused) {
                g.this.V0();
            }
        }
    }

    class b extends com.haier.library.okhttp.n.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f27249c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i7, long j7) {
            super(str, objArr);
            this.f27248b = i7;
            this.f27249c = j7;
        }

        @Override // com.haier.library.okhttp.n.c
        public void k() {
            try {
                g.this.f27242r.g(this.f27248b, this.f27249c);
            } catch (IOException unused) {
                g.this.V0();
            }
        }
    }

    class c extends com.haier.library.okhttp.n.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f27252c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Object[] objArr, int i7, List list) {
            super(str, objArr);
            this.f27251b = i7;
            this.f27252c = list;
        }

        @Override // com.haier.library.okhttp.n.c
        public void k() {
            if (g.this.f27234j.c(this.f27251b, this.f27252c)) {
                try {
                    g.this.f27242r.m(this.f27251b, com.haier.library.okhttp.b.g.b.CANCEL);
                    synchronized (g.this) {
                        try {
                            g.this.f27244t.remove(Integer.valueOf(this.f27251b));
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    class d extends com.haier.library.okhttp.n.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f27255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f27256d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i7, List list, boolean z7) {
            super(str, objArr);
            this.f27254b = i7;
            this.f27255c = list;
            this.f27256d = z7;
        }

        @Override // com.haier.library.okhttp.n.c
        public void k() {
            boolean zB = g.this.f27234j.b(this.f27254b, this.f27255c, this.f27256d);
            if (zB) {
                try {
                    g.this.f27242r.m(this.f27254b, com.haier.library.okhttp.b.g.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (zB || this.f27256d) {
                synchronized (g.this) {
                    try {
                        g.this.f27244t.remove(Integer.valueOf(this.f27254b));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    class e extends com.haier.library.okhttp.n.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27258b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.haier.library.a.g f27259c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f27260d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f27261e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i7, com.haier.library.a.g gVar, int i8, boolean z7) {
            super(str, objArr);
            this.f27258b = i7;
            this.f27259c = gVar;
            this.f27260d = i8;
            this.f27261e = z7;
        }

        @Override // com.haier.library.okhttp.n.c
        public void k() {
            try {
                boolean zD = g.this.f27234j.d(this.f27258b, this.f27259c, this.f27260d, this.f27261e);
                if (zD) {
                    g.this.f27242r.m(this.f27258b, com.haier.library.okhttp.b.g.b.CANCEL);
                }
                if (zD || this.f27261e) {
                    synchronized (g.this) {
                        g.this.f27244t.remove(Integer.valueOf(this.f27258b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    class f extends com.haier.library.okhttp.n.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.haier.library.okhttp.b.g.b f27264c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i7, com.haier.library.okhttp.b.g.b bVar) {
            super(str, objArr);
            this.f27263b = i7;
            this.f27264c = bVar;
        }

        @Override // com.haier.library.okhttp.n.c
        public void k() {
            g.this.f27234j.a(this.f27263b, this.f27264c);
            synchronized (g.this) {
                g.this.f27244t.remove(Integer.valueOf(this.f27263b));
            }
        }
    }

    /* JADX INFO: renamed from: com.haier.library.okhttp.b.g.g$g, reason: collision with other inner class name */
    public static class C0358g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Socket f27266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f27267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        com.haier.library.a.i f27268c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.haier.library.a.h f27269d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        h f27270e = h.f27274a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        l f27271f = l.f27338a;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f27272g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f27273h;

        public C0358g(boolean z7) {
            this.f27272g = z7;
        }

        public C0358g a(int i7) {
            this.f27273h = i7;
            return this;
        }

        public C0358g b(h hVar) {
            this.f27270e = hVar;
            return this;
        }

        public C0358g c(l lVar) {
            this.f27271f = lVar;
            return this;
        }

        public C0358g d(Socket socket) throws IOException {
            return e(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), t.b(t.n(socket)), t.a(t.f(socket)));
        }

        public C0358g e(Socket socket, String str, com.haier.library.a.i iVar, com.haier.library.a.h hVar) {
            this.f27266a = socket;
            this.f27267b = str;
            this.f27268c = iVar;
            this.f27269d = hVar;
            return this;
        }

        public g f() {
            return new g(this);
        }
    }

    public static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f27274a = new a();

        static class a extends h {
            a() {
            }

            @Override // com.haier.library.okhttp.b.g.g.h
            public void b(com.haier.library.okhttp.b.g.i iVar) throws IOException {
                iVar.e(com.haier.library.okhttp.b.g.b.REFUSED_STREAM);
            }
        }

        public void a(g gVar) {
        }

        public abstract void b(com.haier.library.okhttp.b.g.i iVar) throws IOException;
    }

    final class i extends com.haier.library.okhttp.n.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f27275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f27276c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f27277d;

        i(boolean z7, int i7, int i8) {
            super("OkHttp %s ping %08x%08x", g.this.f27228d, Integer.valueOf(i7), Integer.valueOf(i8));
            this.f27275b = z7;
            this.f27276c = i7;
            this.f27277d = i8;
        }

        @Override // com.haier.library.okhttp.n.c
        public void k() {
            g.this.K(this.f27275b, this.f27276c, this.f27277d);
        }
    }

    class j extends com.haier.library.okhttp.n.c implements com.haier.library.okhttp.b.g.h.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.haier.library.okhttp.b.g.h f27279b;

        class a extends com.haier.library.okhttp.n.c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.haier.library.okhttp.b.g.i f27281b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, com.haier.library.okhttp.b.g.i iVar) {
                super(str, objArr);
                this.f27281b = iVar;
            }

            @Override // com.haier.library.okhttp.n.c
            public void k() {
                try {
                    g.this.f27226b.b(this.f27281b);
                } catch (IOException e8) {
                    com.haier.library.okhttp.b.i.f.r().h(4, "Http2Connection.Listener failure for " + g.this.f27228d, e8);
                    try {
                        this.f27281b.e(com.haier.library.okhttp.b.g.b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        class b extends com.haier.library.okhttp.n.c {
            b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // com.haier.library.okhttp.n.c
            public void k() {
                g gVar = g.this;
                gVar.f27226b.a(gVar);
            }
        }

        class c extends com.haier.library.okhttp.n.c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ m f27284b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            c(String str, Object[] objArr, m mVar) {
                super(str, objArr);
                this.f27284b = mVar;
            }

            @Override // com.haier.library.okhttp.n.c
            public void k() {
                try {
                    g.this.f27242r.u(this.f27284b);
                } catch (IOException unused) {
                    g.this.V0();
                }
            }
        }

        j(com.haier.library.okhttp.b.g.h hVar) {
            super("OkHttp %s", g.this.f27228d);
            this.f27279b = hVar;
        }

        private void l(m mVar) {
            try {
                g.this.f27232h.execute(new c("OkHttp %s ACK Settings", new Object[]{g.this.f27228d}, mVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // com.haier.library.okhttp.b.g.h.b
        public void a() {
        }

        @Override // com.haier.library.okhttp.b.g.h.b
        public void b(boolean z7, int i7, int i8) {
            if (!z7) {
                try {
                    g.this.f27232h.execute(g.this.new i(true, i7, i8));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (g.this) {
                    g.this.f27235k = false;
                    g.this.notifyAll();
                }
            }
        }

        @Override // com.haier.library.okhttp.b.g.h.b
        public void c(int i7, int i8, List<com.haier.library.okhttp.b.g.c> list) {
            g.this.r(i8, list);
        }

        @Override // com.haier.library.okhttp.b.g.h.b
        public void d(boolean z7, int i7, int i8, List<com.haier.library.okhttp.b.g.c> list) {
            if (g.this.x0(i7)) {
                g.this.p0(i7, list, z7);
                return;
            }
            synchronized (g.this) {
                com.haier.library.okhttp.b.g.i iVarC = g.this.c(i7);
                if (iVarC != null) {
                    iVarC.g(list);
                    if (z7) {
                        iVarC.v();
                        return;
                    }
                    return;
                }
                g gVar = g.this;
                if (gVar.f27231g) {
                    return;
                }
                if (i7 <= gVar.f27229e) {
                    return;
                }
                if (i7 % 2 == gVar.f27230f % 2) {
                    return;
                }
                com.haier.library.okhttp.b.g.i iVar = new com.haier.library.okhttp.b.g.i(i7, g.this, false, z7, com.haier.library.okhttp.n.d.E(list));
                g gVar2 = g.this;
                gVar2.f27229e = i7;
                gVar2.f27227c.put(Integer.valueOf(i7), iVar);
                g.f27223v.execute(new a("OkHttp %s stream %d", new Object[]{g.this.f27228d, Integer.valueOf(i7)}, iVar));
            }
        }

        @Override // com.haier.library.okhttp.b.g.h.b
        public void e(int i7, com.haier.library.okhttp.b.g.b bVar, com.haier.library.a.j jVar) {
            com.haier.library.okhttp.b.g.i[] iVarArr;
            jVar.Z();
            synchronized (g.this) {
                iVarArr = (com.haier.library.okhttp.b.g.i[]) g.this.f27227c.values().toArray(new com.haier.library.okhttp.b.g.i[g.this.f27227c.size()]);
                g.this.f27231g = true;
            }
            for (com.haier.library.okhttp.b.g.i iVar : iVarArr) {
                if (iVar.a() > i7 && iVar.m()) {
                    iVar.l(com.haier.library.okhttp.b.g.b.REFUSED_STREAM);
                    g.this.h0(iVar.a());
                }
            }
        }

        @Override // com.haier.library.okhttp.b.g.h.b
        public void f(int i7, int i8, int i9, boolean z7) {
        }

        @Override // com.haier.library.okhttp.b.g.h.b
        public void g(boolean z7, int i7, com.haier.library.a.i iVar, int i8) throws IOException {
            if (g.this.x0(i7)) {
                g.this.m(i7, iVar, i8, z7);
                return;
            }
            com.haier.library.okhttp.b.g.i iVarC = g.this.c(i7);
            if (iVarC == null) {
                g.this.q(i7, com.haier.library.okhttp.b.g.b.PROTOCOL_ERROR);
                long j7 = i8;
                g.this.a(j7);
                iVar.j0(j7);
                return;
            }
            iVarC.d(iVar, i8);
            if (z7) {
                iVarC.v();
            }
        }

        @Override // com.haier.library.okhttp.b.g.h.b
        public void h(int i7, String str, com.haier.library.a.j jVar, String str2, int i8, long j7) {
        }

        @Override // com.haier.library.okhttp.b.g.h.b
        public void i(boolean z7, m mVar) {
            com.haier.library.okhttp.b.g.i[] iVarArr;
            long j7;
            int i7;
            synchronized (g.this) {
                int iJ = g.this.f27239o.j();
                if (z7) {
                    g.this.f27239o.b();
                }
                g.this.f27239o.c(mVar);
                l(mVar);
                int iJ2 = g.this.f27239o.j();
                iVarArr = null;
                if (iJ2 == -1 || iJ2 == iJ) {
                    j7 = 0;
                } else {
                    j7 = iJ2 - iJ;
                    g gVar = g.this;
                    if (!gVar.f27240p) {
                        gVar.f27240p = true;
                    }
                    if (!gVar.f27227c.isEmpty()) {
                        iVarArr = (com.haier.library.okhttp.b.g.i[]) g.this.f27227c.values().toArray(new com.haier.library.okhttp.b.g.i[g.this.f27227c.size()]);
                    }
                }
                g.f27223v.execute(new b("OkHttp %s settings", g.this.f27228d));
            }
            if (iVarArr == null || j7 == 0) {
                return;
            }
            for (com.haier.library.okhttp.b.g.i iVar : iVarArr) {
                synchronized (iVar) {
                    iVar.c(j7);
                }
            }
        }

        @Override // com.haier.library.okhttp.b.g.h.b
        public void j(int i7, long j7) {
            if (i7 == 0) {
                synchronized (g.this) {
                    g gVar = g.this;
                    gVar.f27237m += j7;
                    gVar.notifyAll();
                }
                return;
            }
            com.haier.library.okhttp.b.g.i iVarC = g.this.c(i7);
            if (iVarC != null) {
                synchronized (iVarC) {
                    iVarC.c(j7);
                }
            }
        }

        @Override // com.haier.library.okhttp.n.c
        protected void k() throws Throwable {
            com.haier.library.okhttp.b.g.b bVar;
            com.haier.library.okhttp.b.g.b bVar2 = com.haier.library.okhttp.b.g.b.INTERNAL_ERROR;
            try {
                try {
                    this.f27279b.f(this);
                    while (this.f27279b.q(false, this)) {
                    }
                    bVar = com.haier.library.okhttp.b.g.b.NO_ERROR;
                    try {
                        try {
                            g.this.E(bVar, com.haier.library.okhttp.b.g.b.CANCEL);
                        } catch (IOException unused) {
                            com.haier.library.okhttp.b.g.b bVar3 = com.haier.library.okhttp.b.g.b.PROTOCOL_ERROR;
                            g.this.E(bVar3, bVar3);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            g.this.E(bVar, bVar2);
                        } catch (IOException unused2) {
                        }
                        com.haier.library.okhttp.n.d.s(this.f27279b);
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
                bVar = bVar2;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                g.this.E(bVar, bVar2);
                com.haier.library.okhttp.n.d.s(this.f27279b);
                throw th;
            }
            com.haier.library.okhttp.n.d.s(this.f27279b);
        }

        @Override // com.haier.library.okhttp.b.g.h.b
        public void a(int i7, com.haier.library.okhttp.b.g.b bVar) {
            if (g.this.x0(i7)) {
                g.this.v0(i7, bVar);
                return;
            }
            com.haier.library.okhttp.b.g.i iVarH0 = g.this.h0(i7);
            if (iVarH0 != null) {
                iVarH0.l(bVar);
            }
        }
    }

    g(C0358g c0358g) {
        m mVar = new m();
        this.f27239o = mVar;
        this.f27240p = false;
        this.f27244t = new LinkedHashSet();
        this.f27234j = c0358g.f27271f;
        boolean z7 = c0358g.f27272g;
        this.f27225a = z7;
        this.f27226b = c0358g.f27270e;
        int i7 = z7 ? 1 : 2;
        this.f27230f = i7;
        if (z7) {
            this.f27230f = i7 + 2;
        }
        if (z7) {
            this.f27238n.a(7, 16777216);
        }
        String str = c0358g.f27267b;
        this.f27228d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, com.haier.library.okhttp.n.d.p(com.haier.library.okhttp.n.d.j("OkHttp %s Writer", str), false));
        this.f27232h = scheduledThreadPoolExecutor;
        if (c0358g.f27273h != 0) {
            i iVar = new i(false, 0, 0);
            int i8 = c0358g.f27273h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, i8, i8, TimeUnit.MILLISECONDS);
        }
        this.f27233i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.haier.library.okhttp.n.d.p(com.haier.library.okhttp.n.d.j("OkHttp %s Push Observer", str), true));
        mVar.a(7, 65535);
        mVar.a(5, 16384);
        this.f27237m = mVar.j();
        this.f27241q = c0358g.f27266a;
        this.f27242r = new com.haier.library.okhttp.b.g.j(c0358g.f27269d, z7);
        this.f27243s = new j(new com.haier.library.okhttp.b.g.h(c0358g.f27268c, z7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        try {
            com.haier.library.okhttp.b.g.b bVar = com.haier.library.okhttp.b.g.b.PROTOCOL_ERROR;
            E(bVar, bVar);
        } catch (IOException unused) {
        }
    }

    private com.haier.library.okhttp.b.g.i s0(int i7, List<com.haier.library.okhttp.b.g.c> list, boolean z7) throws IOException {
        int i8;
        com.haier.library.okhttp.b.g.i iVar;
        boolean z8;
        boolean z9 = !z7;
        synchronized (this.f27242r) {
            synchronized (this) {
                if (this.f27230f > 1073741823) {
                    C(com.haier.library.okhttp.b.g.b.REFUSED_STREAM);
                }
                if (this.f27231g) {
                    throw new com.haier.library.okhttp.b.g.a();
                }
                i8 = this.f27230f;
                this.f27230f = i8 + 2;
                iVar = new com.haier.library.okhttp.b.g.i(i8, this, z9, false, null);
                z8 = !z7 || this.f27237m == 0 || iVar.f27299b == 0;
                if (iVar.k()) {
                    this.f27227c.put(Integer.valueOf(i8), iVar);
                }
            }
            if (i7 == 0) {
                this.f27242r.C(z9, i8, i7, list);
            } else {
                if (this.f27225a) {
                    throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                }
                this.f27242r.f(i7, i8, list);
            }
        }
        if (z8) {
            this.f27242r.G();
        }
        return iVar;
    }

    private synchronized void v(com.haier.library.okhttp.n.c cVar) {
        if (!Q0()) {
            this.f27233i.execute(cVar);
        }
    }

    public void C(com.haier.library.okhttp.b.g.b bVar) throws IOException {
        synchronized (this.f27242r) {
            synchronized (this) {
                if (this.f27231g) {
                    return;
                }
                this.f27231g = true;
                this.f27242r.q(this.f27229e, bVar, com.haier.library.okhttp.n.d.f27686a);
            }
        }
    }

    void E(com.haier.library.okhttp.b.g.b bVar, com.haier.library.okhttp.b.g.b bVar2) throws IOException {
        if (!f27224w && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        com.haier.library.okhttp.b.g.i[] iVarArr = null;
        try {
            C(bVar);
            e = null;
        } catch (IOException e8) {
            e = e8;
        }
        synchronized (this) {
            if (!this.f27227c.isEmpty()) {
                iVarArr = (com.haier.library.okhttp.b.g.i[]) this.f27227c.values().toArray(new com.haier.library.okhttp.b.g.i[this.f27227c.size()]);
                this.f27227c.clear();
            }
        }
        if (iVarArr != null) {
            for (com.haier.library.okhttp.b.g.i iVar : iVarArr) {
                try {
                    iVar.e(bVar2);
                } catch (IOException e9) {
                    if (e != null) {
                        e = e9;
                    }
                }
            }
        }
        try {
            this.f27242r.close();
        } catch (IOException e10) {
            if (e == null) {
                e = e10;
            }
        }
        try {
            this.f27241q.close();
        } catch (IOException e11) {
            e = e11;
        }
        this.f27232h.shutdown();
        this.f27233i.shutdown();
        if (e != null) {
            throw e;
        }
    }

    public void G(m mVar) throws IOException {
        synchronized (this.f27242r) {
            synchronized (this) {
                if (this.f27231g) {
                    throw new com.haier.library.okhttp.b.g.a();
                }
                this.f27238n.c(mVar);
            }
            this.f27242r.K(mVar);
        }
    }

    void G0() throws InterruptedException {
        K(false, 1330343787, -257978967);
        I0();
    }

    void H(boolean z7) throws IOException {
        if (z7) {
            this.f27242r.b();
            this.f27242r.K(this.f27238n);
            int iJ = this.f27238n.j();
            if (iJ != 65535) {
                this.f27242r.g(0, iJ - 65535);
            }
        }
        new Thread(this.f27243s).start();
    }

    synchronized void I0() throws InterruptedException {
        while (this.f27235k) {
            wait();
        }
    }

    public void J0() throws IOException {
        this.f27242r.G();
    }

    void K(boolean z7, int i7, int i8) {
        boolean z8;
        if (!z7) {
            synchronized (this) {
                z8 = this.f27235k;
                this.f27235k = true;
            }
            if (z8) {
                V0();
                return;
            }
        }
        try {
            this.f27242r.v(z7, i7, i8);
        } catch (IOException unused) {
            V0();
        }
    }

    public void L0() throws IOException {
        H(true);
    }

    public synchronized boolean Q0() {
        return this.f27231g;
    }

    synchronized void a(long j7) {
        long j8 = this.f27236l + j7;
        this.f27236l = j8;
        if (j8 >= this.f27238n.j() / 2) {
            g(0, this.f27236l);
            this.f27236l = 0L;
        }
    }

    public com.haier.library.okhttp.d b() {
        return com.haier.library.okhttp.d.HTTP_2;
    }

    synchronized com.haier.library.okhttp.b.g.i c(int i7) {
        return this.f27227c.get(Integer.valueOf(i7));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        E(com.haier.library.okhttp.b.g.b.NO_ERROR, com.haier.library.okhttp.b.g.b.CANCEL);
    }

    public com.haier.library.okhttp.b.g.i e(int i7, List<com.haier.library.okhttp.b.g.c> list, boolean z7) throws IOException {
        if (this.f27225a) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return s0(i7, list, z7);
    }

    public com.haier.library.okhttp.b.g.i f(List<com.haier.library.okhttp.b.g.c> list, boolean z7) throws IOException {
        return s0(0, list, z7);
    }

    void g(int i7, long j7) {
        try {
            this.f27232h.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.f27228d, Integer.valueOf(i7)}, i7, j7));
        } catch (RejectedExecutionException unused) {
        }
    }

    public synchronized int g0() {
        return this.f27227c.size();
    }

    synchronized com.haier.library.okhttp.b.g.i h0(int i7) {
        com.haier.library.okhttp.b.g.i iVarRemove;
        iVarRemove = this.f27227c.remove(Integer.valueOf(i7));
        notifyAll();
        return iVarRemove;
    }

    void m(int i7, com.haier.library.a.i iVar, int i8, boolean z7) throws IOException {
        com.haier.library.a.g gVar = new com.haier.library.a.g();
        long j7 = i8;
        iVar.a(j7);
        iVar.P0(gVar, j7);
        if (gVar.Y0() == j7) {
            v(new e("OkHttp %s Push Data[%s]", new Object[]{this.f27228d, Integer.valueOf(i7)}, i7, gVar, i8, z7));
            return;
        }
        throw new IOException(gVar.Y0() + " != " + i8);
    }

    void o0(int i7, com.haier.library.okhttp.b.g.b bVar) throws IOException {
        this.f27242r.m(i7, bVar);
    }

    void p0(int i7, List<com.haier.library.okhttp.b.g.c> list, boolean z7) {
        try {
            v(new d("OkHttp %s Push Headers[%s]", new Object[]{this.f27228d, Integer.valueOf(i7)}, i7, list, z7));
        } catch (RejectedExecutionException unused) {
        }
    }

    void q(int i7, com.haier.library.okhttp.b.g.b bVar) {
        try {
            this.f27232h.execute(new a("OkHttp %s stream %d", new Object[]{this.f27228d, Integer.valueOf(i7)}, i7, bVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    void r(int i7, List<com.haier.library.okhttp.b.g.c> list) {
        synchronized (this) {
            if (this.f27244t.contains(Integer.valueOf(i7))) {
                q(i7, com.haier.library.okhttp.b.g.b.PROTOCOL_ERROR);
                return;
            }
            this.f27244t.add(Integer.valueOf(i7));
            try {
                v(new c("OkHttp %s Push Request[%s]", new Object[]{this.f27228d, Integer.valueOf(i7)}, i7, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public synchronized int r0() {
        return this.f27239o.i(Integer.MAX_VALUE);
    }

    public void s(int i7, boolean z7, com.haier.library.a.g gVar, long j7) throws IOException {
        long j8;
        int iMin;
        long j9;
        if (j7 == 0) {
            this.f27242r.E(z7, i7, gVar, 0);
            return;
        }
        while (j7 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j8 = this.f27237m;
                        if (j8 <= 0) {
                            if (!this.f27227c.containsKey(Integer.valueOf(i7))) {
                                throw new IOException("stream closed");
                            }
                            wait();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j7, j8), this.f27242r.g0());
                j9 = iMin;
                this.f27237m -= j9;
            }
            j7 -= j9;
            this.f27242r.E(z7 && j7 == 0, i7, gVar, iMin);
        }
    }

    void u(int i7, boolean z7, List<com.haier.library.okhttp.b.g.c> list) throws IOException {
        this.f27242r.F(z7, i7, list);
    }

    void v0(int i7, com.haier.library.okhttp.b.g.b bVar) {
        v(new f("OkHttp %s Push Reset[%s]", new Object[]{this.f27228d, Integer.valueOf(i7)}, i7, bVar));
    }

    boolean x0(int i7) {
        return i7 != 0 && (i7 & 1) == 0;
    }
}
