package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.l0;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Interceptor.Chain {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f37880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final okhttp3.internal.connection.e f37881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<Interceptor> f37882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f37883d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.e
    private final okhttp3.internal.connection.c f37884e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private final Request f37885f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f37886g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f37887h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f37888i;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@a7.d okhttp3.internal.connection.e call, @a7.d List<? extends Interceptor> interceptors, int i7, @a7.e okhttp3.internal.connection.c cVar, @a7.d Request request, int i8, int i9, int i10) {
        l0.p(call, "call");
        l0.p(interceptors, "interceptors");
        l0.p(request, "request");
        this.f37881b = call;
        this.f37882c = interceptors;
        this.f37883d = i7;
        this.f37884e = cVar;
        this.f37885f = request;
        this.f37886g = i8;
        this.f37887h = i9;
        this.f37888i = i10;
    }

    public static /* synthetic */ g b(g gVar, int i7, okhttp3.internal.connection.c cVar, Request request, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i7 = gVar.f37883d;
        }
        if ((i11 & 2) != 0) {
            cVar = gVar.f37884e;
        }
        okhttp3.internal.connection.c cVar2 = cVar;
        if ((i11 & 4) != 0) {
            request = gVar.f37885f;
        }
        Request request2 = request;
        if ((i11 & 8) != 0) {
            i8 = gVar.f37886g;
        }
        int i12 = i8;
        if ((i11 & 16) != 0) {
            i9 = gVar.f37887h;
        }
        int i13 = i9;
        if ((i11 & 32) != 0) {
            i10 = gVar.f37888i;
        }
        return gVar.a(i7, cVar2, request2, i12, i13, i10);
    }

    @a7.d
    public final g a(int i7, @a7.e okhttp3.internal.connection.c cVar, @a7.d Request request, int i8, int i9, int i10) {
        l0.p(request, "request");
        return new g(this.f37881b, this.f37882c, i7, cVar, request, i8, i9, i10);
    }

    @a7.d
    public final okhttp3.internal.connection.e c() {
        return this.f37881b;
    }

    @Override // okhttp3.Interceptor.Chain
    @a7.d
    public Call call() {
        return this.f37881b;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.f37886g;
    }

    @Override // okhttp3.Interceptor.Chain
    @a7.e
    public Connection connection() {
        okhttp3.internal.connection.c cVar = this.f37884e;
        if (cVar != null) {
            return cVar.h();
        }
        return null;
    }

    public final int d() {
        return this.f37886g;
    }

    @a7.e
    public final okhttp3.internal.connection.c e() {
        return this.f37884e;
    }

    public final int f() {
        return this.f37887h;
    }

    @a7.d
    public final Request g() {
        return this.f37885f;
    }

    public final int h() {
        return this.f37888i;
    }

    @Override // okhttp3.Interceptor.Chain
    @a7.d
    public Response proceed(@a7.d Request request) throws IOException {
        l0.p(request, "request");
        if (!(this.f37883d < this.f37882c.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f37880a++;
        okhttp3.internal.connection.c cVar = this.f37884e;
        if (cVar != null) {
            if (!cVar.j().g(request.url())) {
                throw new IllegalStateException(("network interceptor " + this.f37882c.get(this.f37883d - 1) + " must retain the same host and port").toString());
            }
            if (!(this.f37880a == 1)) {
                throw new IllegalStateException(("network interceptor " + this.f37882c.get(this.f37883d - 1) + " must call proceed() exactly once").toString());
            }
        }
        g gVarB = b(this, this.f37883d + 1, null, request, 0, 0, 0, 58, null);
        Interceptor interceptor = this.f37882c.get(this.f37883d);
        Response responseIntercept = interceptor.intercept(gVarB);
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.f37884e != null) {
            if (!(this.f37883d + 1 >= this.f37882c.size() || gVarB.f37880a == 1)) {
                throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
            }
        }
        if (responseIntercept.body() != null) {
            return responseIntercept;
        }
        throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.f37887h;
    }

    @Override // okhttp3.Interceptor.Chain
    @a7.d
    public Request request() {
        return this.f37885f;
    }

    @Override // okhttp3.Interceptor.Chain
    @a7.d
    public Interceptor.Chain withConnectTimeout(int i7, @a7.d TimeUnit unit) {
        l0.p(unit, "unit");
        if (this.f37884e == null) {
            return b(this, 0, null, null, okhttp3.internal.d.j("connectTimeout", i7, unit), 0, 0, 55, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    @a7.d
    public Interceptor.Chain withReadTimeout(int i7, @a7.d TimeUnit unit) {
        l0.p(unit, "unit");
        if (this.f37884e == null) {
            return b(this, 0, null, null, 0, okhttp3.internal.d.j("readTimeout", i7, unit), 0, 47, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    @a7.d
    public Interceptor.Chain withWriteTimeout(int i7, @a7.d TimeUnit unit) {
        l0.p(unit, "unit");
        if (this.f37884e == null) {
            return b(this, 0, null, null, 0, 0, okhttp3.internal.d.j("writeTimeout", i7, unit), 31, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.f37888i;
    }
}
