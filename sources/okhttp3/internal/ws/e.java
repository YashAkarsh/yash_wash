package okhttp3.internal.ws;

import com.haier.uhome.account.api.Const;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.collections.x;
import kotlin.jvm.internal.k1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import kotlin.l2;
import kotlin.text.b0;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.n;
import okio.o;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements WebSocket, okhttp3.internal.ws.h.a {
    private static final long A = 16777216;
    private static final long B = 60000;
    public static final long C = 1024;
    public static final b D = new b(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final List<Protocol> f38306z = x.l(Protocol.HTTP_1_1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f38307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Call f38308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private okhttp3.internal.concurrent.a f38309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private okhttp3.internal.ws.h f38310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f38311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private okhttp3.internal.concurrent.c f38312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f38313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f38314h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ArrayDeque<p> f38315i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ArrayDeque<Object> f38316j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f38317k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f38318l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f38319m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f38320n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f38321o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f38322p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f38323q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f38324r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f38325s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final Request f38326t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @a7.d
    private final WebSocketListener f38327u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Random f38328v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final long f38329w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private okhttp3.internal.ws.f f38330x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f38331y;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f38332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.e
        private final p f38333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f38334c;

        public a(int i7, @a7.e p pVar, long j7) {
            this.f38332a = i7;
            this.f38333b = pVar;
            this.f38334c = j7;
        }

        public final long a() {
            return this.f38334c;
        }

        public final int b() {
            return this.f38332a;
        }

        @a7.e
        public final p c() {
            return this.f38333b;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(w wVar) {
            this();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f38335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private final p f38336b;

        public c(int i7, @a7.d p data) {
            l0.p(data, "data");
            this.f38335a = i7;
            this.f38336b = data;
        }

        @a7.d
        public final p a() {
            return this.f38336b;
        }

        public final int b() {
            return this.f38335a;
        }
    }

    public static abstract class d implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f38337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        private final o f38338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.d
        private final n f38339c;

        public d(boolean z7, @a7.d o source, @a7.d n sink) {
            l0.p(source, "source");
            l0.p(sink, "sink");
            this.f38337a = z7;
            this.f38338b = source;
            this.f38339c = sink;
        }

        public final boolean b() {
            return this.f38337a;
        }

        @a7.d
        public final n e() {
            return this.f38339c;
        }

        @a7.d
        public final o q() {
            return this.f38338b;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.ws.e$e, reason: collision with other inner class name */
    private final class C0512e extends okhttp3.internal.concurrent.a {
        public C0512e() {
            super(e.this.f38313g + " writer", false, 2, null);
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            try {
                return e.this.C() ? 0L : -1L;
            } catch (IOException e8) {
                e.this.p(e8, null);
                return -1L;
            }
        }
    }

    public static final class f implements Callback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Request f38342b;

        f(Request request) {
            this.f38342b = request;
        }

        @Override // okhttp3.Callback
        public void onFailure(@a7.d Call call, @a7.d IOException e8) {
            l0.p(call, "call");
            l0.p(e8, "e");
            e.this.p(e8, null);
        }

        @Override // okhttp3.Callback
        public void onResponse(@a7.d Call call, @a7.d Response response) throws IOException {
            l0.p(call, "call");
            l0.p(response, "response");
            okhttp3.internal.connection.c cVarExchange = response.exchange();
            try {
                e.this.m(response, cVarExchange);
                l0.m(cVarExchange);
                d dVarM = cVarExchange.m();
                okhttp3.internal.ws.f fVarA = okhttp3.internal.ws.f.f38361h.a(response.headers());
                e.this.f38330x = fVarA;
                if (!e.this.s(fVarA)) {
                    synchronized (e.this) {
                        e.this.f38316j.clear();
                        e.this.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                    }
                }
                try {
                    e.this.r(okhttp3.internal.d.f37862i + " WebSocket " + this.f38342b.url().redact(), dVarM);
                    e.this.q().onOpen(e.this, response);
                    e.this.t();
                } catch (Exception e8) {
                    e.this.p(e8, null);
                }
            } catch (IOException e9) {
                if (cVarExchange != null) {
                    cVarExchange.v();
                }
                e.this.p(e9, response);
                okhttp3.internal.d.l(response);
            }
        }
    }

    public static final class g extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f38343e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f38344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f38345g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f38346h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ d f38347i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ okhttp3.internal.ws.f f38348j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, String str2, long j7, e eVar, String str3, d dVar, okhttp3.internal.ws.f fVar) {
            super(str2, false, 2, null);
            this.f38343e = str;
            this.f38344f = j7;
            this.f38345g = eVar;
            this.f38346h = str3;
            this.f38347i = dVar;
            this.f38348j = fVar;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            this.f38345g.D();
            return this.f38344f;
        }
    }

    public static final class h extends okhttp3.internal.concurrent.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f38349e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f38350f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e f38351g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ i f38352h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ p f38353i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ k1.h f38354j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ k1.f f38355k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ k1.h f38356l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ k1.h f38357m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ k1.h f38358n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ k1.h f38359o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z7, String str2, boolean z8, e eVar, i iVar, p pVar, k1.h hVar, k1.f fVar, k1.h hVar2, k1.h hVar3, k1.h hVar4, k1.h hVar5) {
            super(str2, z8);
            this.f38349e = str;
            this.f38350f = z7;
            this.f38351g = eVar;
            this.f38352h = iVar;
            this.f38353i = pVar;
            this.f38354j = hVar;
            this.f38355k = fVar;
            this.f38356l = hVar2;
            this.f38357m = hVar3;
            this.f38358n = hVar4;
            this.f38359o = hVar5;
        }

        @Override // okhttp3.internal.concurrent.a
        public long f() {
            this.f38351g.cancel();
            return -1L;
        }
    }

    public e(@a7.d okhttp3.internal.concurrent.d taskRunner, @a7.d Request originalRequest, @a7.d WebSocketListener listener, @a7.d Random random, long j7, @a7.e okhttp3.internal.ws.f fVar, long j8) {
        l0.p(taskRunner, "taskRunner");
        l0.p(originalRequest, "originalRequest");
        l0.p(listener, "listener");
        l0.p(random, "random");
        this.f38326t = originalRequest;
        this.f38327u = listener;
        this.f38328v = random;
        this.f38329w = j7;
        this.f38330x = fVar;
        this.f38331y = j8;
        this.f38312f = taskRunner.j();
        this.f38315i = new ArrayDeque<>();
        this.f38316j = new ArrayDeque<>();
        this.f38319m = -1;
        if (!l0.g(Const.HTTP_REQUEST_TYPE_GET, originalRequest.method())) {
            throw new IllegalArgumentException(("Request must be GET: " + originalRequest.method()).toString());
        }
        p.a aVar = p.f38508f;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        l2 l2Var = l2.f34958a;
        this.f38307a = p.a.p(aVar, bArr, 0, 0, 3, null).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(okhttp3.internal.ws.f fVar) {
        if (fVar.f38367f || fVar.f38363b != null) {
            return false;
        }
        Integer num = fVar.f38365d;
        if (num == null) {
            return true;
        }
        int iIntValue = num.intValue();
        return 8 <= iIntValue && 15 >= iIntValue;
    }

    private final void y() {
        if (!okhttp3.internal.d.f37861h || Thread.holdsLock(this)) {
            okhttp3.internal.concurrent.a aVar = this.f38309c;
            if (aVar != null) {
                okhttp3.internal.concurrent.c.p(this.f38312f, aVar, 0L, 2, null);
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        l0.o(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    private final synchronized boolean z(p pVar, int i7) {
        if (!this.f38321o && !this.f38318l) {
            if (this.f38317k + ((long) pVar.a0()) > A) {
                close(1001, null);
                return false;
            }
            this.f38317k += (long) pVar.a0();
            this.f38316j.add(new c(i7, pVar));
            y();
            return true;
        }
        return false;
    }

    public final synchronized int A() {
        return this.f38322p;
    }

    public final void B() throws InterruptedException {
        this.f38312f.u();
        this.f38312f.l().await(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0172  */
    /* JADX WARN: Code duplicated, block: B:58:0x017d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0188  */
    /* JADX WARN: Code duplicated, block: B:77:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:80:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:83:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object, okhttp3.internal.ws.i] */
    /* JADX WARN: Type inference failed for: r1v13, types: [kotlin.jvm.internal.k1$h] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v15, types: [T, okhttp3.internal.ws.e$d] */
    /* JADX WARN: Type inference failed for: r2v16, types: [T, okhttp3.internal.ws.h] */
    /* JADX WARN: Type inference failed for: r2v17, types: [T, okhttp3.internal.ws.i] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r3v16, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [okio.p] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.String] */
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
    public final boolean C() throws Throwable {
        k1.h hVar;
        k1.h hVar2;
        k1.h hVar3;
        k1.h hVar4;
        d dVar;
        okhttp3.internal.ws.h hVar5;
        i iVar;
        k1.h hVar6;
        d dVar2;
        okhttp3.internal.ws.h hVar7;
        i iVar2;
        k1.h hVar8 = new k1.h();
        hVar8.f34872a = null;
        k1.f fVar = new k1.f();
        fVar.f34870a = -1;
        k1.h hVar9 = new k1.h();
        hVar9.f34872a = null;
        k1.h hVar10 = new k1.h();
        hVar10.f34872a = null;
        k1.h hVar11 = new k1.h();
        hVar11.f34872a = null;
        k1.h hVar12 = new k1.h();
        hVar12.f34872a = null;
        synchronized (this) {
            if (this.f38321o) {
                return false;
            }
            i iVar3 = this.f38311e;
            p pVarPoll = this.f38315i.poll();
            if (pVarPoll == null) {
                ?? Poll = this.f38316j.poll();
                hVar8.f34872a = Poll;
                if (Poll instanceof a) {
                    int i7 = this.f38319m;
                    fVar.f34870a = i7;
                    hVar9.f34872a = this.f38320n;
                    if (i7 != -1) {
                        hVar10.f34872a = this.f38314h;
                        this.f38314h = null;
                        hVar11.f34872a = this.f38310d;
                        this.f38310d = null;
                        hVar12.f34872a = this.f38311e;
                        this.f38311e = null;
                        this.f38312f.u();
                        hVar = hVar12;
                        hVar2 = hVar11;
                    } else {
                        T t7 = hVar8.f34872a;
                        if (t7 == 0) {
                            throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                        }
                        long jA = ((a) t7).a();
                        okhttp3.internal.concurrent.c cVar = this.f38312f;
                        String str = this.f38313g + " cancel";
                        hVar = hVar12;
                        hVar2 = hVar11;
                        cVar.n(new h(str, true, str, true, this, iVar3, pVarPoll, hVar8, fVar, hVar9, hVar10, hVar2, hVar), TimeUnit.MILLISECONDS.toNanos(jA));
                    }
                } else {
                    hVar = hVar12;
                    hVar2 = hVar11;
                    if (Poll == 0) {
                        return false;
                    }
                }
            } else {
                hVar = hVar12;
                hVar2 = hVar11;
            }
            l2 l2Var = l2.f34958a;
            k1.h hVar13 = pVarPoll;
            try {
                if (hVar13 == 0) {
                    hVar4 = iVar3;
                    T t8 = hVar8.f34872a;
                    if (!(t8 instanceof c)) {
                        hVar3 = t8 instanceof a;
                        try {
                            if (hVar3 == 0) {
                                throw new AssertionError();
                            }
                            if (t8 == 0) {
                                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                            }
                            a aVar = (a) t8;
                            l0.m(hVar4);
                            hVar4.f(aVar.b(), aVar.c());
                            hVar4 = hVar10;
                            try {
                                d dVar3 = (d) hVar4.f34872a;
                                hVar6 = hVar4;
                                if (dVar3 != null) {
                                    WebSocketListener webSocketListener = this.f38327u;
                                    int i8 = fVar.f34870a;
                                    String str2 = (String) hVar9.f34872a;
                                    l0.m(str2);
                                    webSocketListener.onClosed(this, i8, str2);
                                    hVar6 = hVar4;
                                }
                            } catch (Throwable th) {
                                th = th;
                                hVar13 = hVar;
                                hVar3 = hVar2;
                                dVar = (d) hVar4.f34872a;
                                if (dVar != null) {
                                    okhttp3.internal.d.l(dVar);
                                }
                                hVar5 = (okhttp3.internal.ws.h) hVar3.f34872a;
                                if (hVar5 != null) {
                                    okhttp3.internal.d.l(hVar5);
                                }
                                iVar = (i) hVar13.f34872a;
                                if (iVar != null) {
                                    okhttp3.internal.d.l(iVar);
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        if (t8 == 0) {
                            throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
                        }
                        c cVar2 = (c) t8;
                        l0.m(hVar4);
                        hVar4.m(cVar2.b(), cVar2.a());
                        synchronized (this) {
                            this.f38317k -= (long) cVar2.a().a0();
                        }
                    }
                    dVar2 = (d) hVar6.f34872a;
                    if (dVar2 != null) {
                        okhttp3.internal.d.l(dVar2);
                    }
                    hVar7 = (okhttp3.internal.ws.h) hVar2.f34872a;
                    if (hVar7 != null) {
                        okhttp3.internal.d.l(hVar7);
                    }
                    iVar2 = (i) hVar.f34872a;
                    if (iVar2 != null) {
                        return true;
                    }
                    okhttp3.internal.d.l(iVar2);
                    return true;
                }
                l0.m(iVar3);
                iVar3.r(hVar13);
                hVar6 = hVar10;
                dVar2 = (d) hVar6.f34872a;
                if (dVar2 != null) {
                    okhttp3.internal.d.l(dVar2);
                }
                hVar7 = (okhttp3.internal.ws.h) hVar2.f34872a;
                if (hVar7 != null) {
                    okhttp3.internal.d.l(hVar7);
                }
                iVar2 = (i) hVar.f34872a;
                if (iVar2 != null) {
                    return true;
                }
                okhttp3.internal.d.l(iVar2);
                return true;
            } catch (Throwable th3) {
                th = th3;
                hVar13 = hVar;
                hVar3 = hVar2;
                hVar4 = hVar10;
                dVar = (d) hVar4.f34872a;
                if (dVar != null) {
                    okhttp3.internal.d.l(dVar);
                }
                hVar5 = (okhttp3.internal.ws.h) hVar3.f34872a;
                if (hVar5 != null) {
                    okhttp3.internal.d.l(hVar5);
                }
                iVar = (i) hVar13.f34872a;
                if (iVar != null) {
                    okhttp3.internal.d.l(iVar);
                }
                throw th;
            }
        }
    }

    public final void D() {
        synchronized (this) {
            if (this.f38321o) {
                return;
            }
            i iVar = this.f38311e;
            if (iVar != null) {
                int i7 = this.f38325s ? this.f38322p : -1;
                this.f38322p++;
                this.f38325s = true;
                l2 l2Var = l2.f34958a;
                if (i7 == -1) {
                    try {
                        iVar.q(p.f38507e);
                        return;
                    } catch (IOException e8) {
                        p(e8, null);
                        return;
                    }
                }
                p(new SocketTimeoutException("sent ping but didn't receive pong within " + this.f38329w + "ms (after " + (i7 - 1) + " successful ping/pongs)"), null);
            }
        }
    }

    @Override // okhttp3.internal.ws.h.a
    public void a(@a7.d p bytes) throws IOException {
        l0.p(bytes, "bytes");
        this.f38327u.onMessage(this, bytes);
    }

    @Override // okhttp3.internal.ws.h.a
    public void b(@a7.d String text) throws IOException {
        l0.p(text, "text");
        this.f38327u.onMessage(this, text);
    }

    @Override // okhttp3.internal.ws.h.a
    public synchronized void c(@a7.d p payload) {
        l0.p(payload, "payload");
        if (!this.f38321o && (!this.f38318l || !this.f38316j.isEmpty())) {
            this.f38315i.add(payload);
            y();
            this.f38323q++;
        }
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        Call call = this.f38308b;
        l0.m(call);
        call.cancel();
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i7, @a7.e String str) {
        return n(i7, str, 60000L);
    }

    @Override // okhttp3.internal.ws.h.a
    public synchronized void d(@a7.d p payload) {
        l0.p(payload, "payload");
        this.f38324r++;
        this.f38325s = false;
    }

    @Override // okhttp3.internal.ws.h.a
    public void e(int i7, @a7.d String reason) {
        d dVar;
        okhttp3.internal.ws.h hVar;
        i iVar;
        l0.p(reason, "reason");
        boolean z7 = true;
        if (!(i7 != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            if (this.f38319m != -1) {
                z7 = false;
            }
            if (!z7) {
                throw new IllegalStateException("already closed".toString());
            }
            this.f38319m = i7;
            this.f38320n = reason;
            dVar = null;
            if (this.f38318l && this.f38316j.isEmpty()) {
                d dVar2 = this.f38314h;
                this.f38314h = null;
                hVar = this.f38310d;
                this.f38310d = null;
                iVar = this.f38311e;
                this.f38311e = null;
                this.f38312f.u();
                dVar = dVar2;
            } else {
                hVar = null;
                iVar = null;
            }
            l2 l2Var = l2.f34958a;
        }
        try {
            this.f38327u.onClosing(this, i7, reason);
            if (dVar != null) {
                this.f38327u.onClosed(this, i7, reason);
            }
        } finally {
            if (dVar != null) {
                okhttp3.internal.d.l(dVar);
            }
            if (hVar != null) {
                okhttp3.internal.d.l(hVar);
            }
            if (iVar != null) {
                okhttp3.internal.d.l(iVar);
            }
        }
    }

    public final void l(long j7, @a7.d TimeUnit timeUnit) throws InterruptedException {
        l0.p(timeUnit, "timeUnit");
        this.f38312f.l().await(j7, timeUnit);
    }

    public final void m(@a7.d Response response, @a7.e okhttp3.internal.connection.c cVar) throws IOException {
        l0.p(response, "response");
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
        String strHeader$default = Response.header$default(response, com.google.common.net.c.f22160o, null, 2, null);
        if (!b0.K1(com.google.common.net.c.L, strHeader$default, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strHeader$default + '\'');
        }
        String strHeader$default2 = Response.header$default(response, com.google.common.net.c.L, null, 2, null);
        if (!b0.K1("websocket", strHeader$default2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strHeader$default2 + '\'');
        }
        String strHeader$default3 = Response.header$default(response, "Sec-WebSocket-Accept", null, 2, null);
        String strD = p.f38508f.l(this.f38307a + okhttp3.internal.ws.g.f38368a).X().d();
        if (!(!l0.g(strD, strHeader$default3))) {
            if (cVar == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strD + "' but was '" + strHeader$default3 + '\'');
    }

    public final synchronized boolean n(int i7, @a7.e String str, long j7) {
        p pVarL;
        okhttp3.internal.ws.g.f38390w.d(i7);
        if (str != null) {
            pVarL = p.f38508f.l(str);
            if (!(((long) pVarL.a0()) <= 123)) {
                throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
            }
        } else {
            pVarL = null;
        }
        if (!this.f38321o && !this.f38318l) {
            this.f38318l = true;
            this.f38316j.add(new a(i7, pVarL, j7));
            y();
            return true;
        }
        return false;
    }

    public final void o(@a7.d OkHttpClient client) {
        l0.p(client, "client");
        if (this.f38326t.header("Sec-WebSocket-Extensions") != null) {
            p(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        OkHttpClient okHttpClientBuild = client.newBuilder().eventListener(EventListener.NONE).protocols(f38306z).build();
        Request requestBuild = this.f38326t.newBuilder().header(com.google.common.net.c.L, "websocket").header(com.google.common.net.c.f22160o, com.google.common.net.c.L).header("Sec-WebSocket-Key", this.f38307a).header("Sec-WebSocket-Version", "13").header("Sec-WebSocket-Extensions", "permessage-deflate").build();
        okhttp3.internal.connection.e eVar = new okhttp3.internal.connection.e(okHttpClientBuild, requestBuild, true);
        this.f38308b = eVar;
        l0.m(eVar);
        eVar.enqueue(new f(requestBuild));
    }

    public final void p(@a7.d Exception e8, @a7.e Response response) {
        l0.p(e8, "e");
        synchronized (this) {
            if (this.f38321o) {
                return;
            }
            this.f38321o = true;
            d dVar = this.f38314h;
            this.f38314h = null;
            okhttp3.internal.ws.h hVar = this.f38310d;
            this.f38310d = null;
            i iVar = this.f38311e;
            this.f38311e = null;
            this.f38312f.u();
            l2 l2Var = l2.f34958a;
            try {
                this.f38327u.onFailure(this, e8, response);
            } finally {
                if (dVar != null) {
                    okhttp3.internal.d.l(dVar);
                }
                if (hVar != null) {
                    okhttp3.internal.d.l(hVar);
                }
                if (iVar != null) {
                    okhttp3.internal.d.l(iVar);
                }
            }
        }
    }

    @a7.d
    public final WebSocketListener q() {
        return this.f38327u;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        return this.f38317k;
    }

    public final void r(@a7.d String name, @a7.d d streams) throws IOException {
        l0.p(name, "name");
        l0.p(streams, "streams");
        okhttp3.internal.ws.f fVar = this.f38330x;
        l0.m(fVar);
        synchronized (this) {
            this.f38313g = name;
            this.f38314h = streams;
            this.f38311e = new i(streams.b(), streams.e(), this.f38328v, fVar.f38362a, fVar.i(streams.b()), this.f38331y);
            this.f38309c = new C0512e();
            long j7 = this.f38329w;
            if (j7 != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j7);
                String str = name + " ping";
                this.f38312f.n(new g(str, str, nanos, this, name, streams, fVar), nanos);
            }
            if (!this.f38316j.isEmpty()) {
                y();
            }
            l2 l2Var = l2.f34958a;
        }
        this.f38310d = new okhttp3.internal.ws.h(streams.b(), streams.q(), this, fVar.f38362a, fVar.i(!streams.b()));
    }

    @Override // okhttp3.WebSocket
    @a7.d
    public Request request() {
        return this.f38326t;
    }

    @Override // okhttp3.WebSocket
    public boolean send(@a7.d String text) {
        l0.p(text, "text");
        return z(p.f38508f.l(text), 1);
    }

    public final void t() throws IOException {
        while (this.f38319m == -1) {
            okhttp3.internal.ws.h hVar = this.f38310d;
            l0.m(hVar);
            hVar.e();
        }
    }

    public final synchronized boolean u(@a7.d p payload) {
        l0.p(payload, "payload");
        if (!this.f38321o && (!this.f38318l || !this.f38316j.isEmpty())) {
            this.f38315i.add(payload);
            y();
            return true;
        }
        return false;
    }

    public final boolean v() throws IOException {
        try {
            okhttp3.internal.ws.h hVar = this.f38310d;
            l0.m(hVar);
            hVar.e();
            return this.f38319m == -1;
        } catch (Exception e8) {
            p(e8, null);
            return false;
        }
    }

    public final synchronized int w() {
        return this.f38323q;
    }

    public final synchronized int x() {
        return this.f38324r;
    }

    @Override // okhttp3.WebSocket
    public boolean send(@a7.d p bytes) {
        l0.p(bytes, "bytes");
        return z(bytes, 2);
    }
}
