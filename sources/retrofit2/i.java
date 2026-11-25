package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.a0;
import okio.o0;

/* JADX INFO: loaded from: classes3.dex */
final class i<T> implements retrofit2.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t<T, ?> f40176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Object[] f40177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f40178c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    private Call f40179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    @Nullable
    private Throwable f40180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f40181f;

    class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f40182a;

        a(d dVar) {
            this.f40182a = dVar;
        }

        private void a(Throwable th) {
            try {
                this.f40182a.onFailure(i.this, th);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        private void b(r<T> rVar) {
            try {
                this.f40182a.onResponse(i.this, rVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            try {
                this.f40182a.onFailure(i.this, iOException);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            try {
                b(i.this.i(response));
            } catch (Throwable th) {
                a(th);
            }
        }
    }

    static final class b extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ResponseBody f40184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        IOException f40185b;

        class a extends okio.s {
            a(o0 o0Var) {
                super(o0Var);
            }

            @Override // okio.s, okio.o0
            public long read(okio.m mVar, long j7) throws IOException {
                try {
                    return super.read(mVar, j7);
                } catch (IOException e8) {
                    b.this.f40185b = e8;
                    throw e8;
                }
            }
        }

        b(ResponseBody responseBody) {
            this.f40184a = responseBody;
        }

        void b() throws IOException {
            IOException iOException = this.f40185b;
            if (iOException != null) {
                throw iOException;
            }
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f40184a.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f40184a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f40184a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public okio.o source() {
            return a0.d(new a(this.f40184a.source()));
        }
    }

    static final class c extends ResponseBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MediaType f40187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f40188b;

        c(MediaType mediaType, long j7) {
            this.f40187a = mediaType;
            this.f40188b = j7;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f40188b;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.f40187a;
        }

        @Override // okhttp3.ResponseBody
        public okio.o source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    i(t<T, ?> tVar, @Nullable Object[] objArr) {
        this.f40176a = tVar;
        this.f40177b = objArr;
    }

    private Call h() throws IOException {
        Call callNewCall = this.f40176a.f40254a.newCall(this.f40176a.c(this.f40177b));
        if (callNewCall != null) {
            return callNewCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    @Override // retrofit2.b
    public void cancel() {
        Call call;
        this.f40178c = true;
        synchronized (this) {
            call = this.f40179d;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // retrofit2.b
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public i<T> clone() {
        return new i<>(this.f40176a, this.f40177b);
    }

    @Override // retrofit2.b
    public r<T> execute() throws IOException {
        Call callH;
        synchronized (this) {
            if (this.f40181f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f40181f = true;
            Throwable th = this.f40180e;
            if (th != null) {
                if (th instanceof IOException) {
                    throw ((IOException) th);
                }
                throw ((RuntimeException) th);
            }
            callH = this.f40179d;
            if (callH == null) {
                try {
                    callH = h();
                    this.f40179d = callH;
                } catch (IOException | RuntimeException e8) {
                    this.f40180e = e8;
                    throw e8;
                }
            }
        }
        if (this.f40178c) {
            callH.cancel();
        }
        return i(callH.execute());
    }

    @Override // retrofit2.b
    public void f(d<T> dVar) {
        Call call;
        Throwable th;
        u.b(dVar, "callback == null");
        synchronized (this) {
            if (this.f40181f) {
                throw new IllegalStateException("Already executed.");
            }
            this.f40181f = true;
            call = this.f40179d;
            th = this.f40180e;
            if (call == null && th == null) {
                try {
                    Call callH = h();
                    this.f40179d = callH;
                    call = callH;
                } catch (Throwable th2) {
                    th = th2;
                    this.f40180e = th;
                }
            }
        }
        if (th != null) {
            dVar.onFailure(this, th);
            return;
        }
        if (this.f40178c) {
            call.cancel();
        }
        call.enqueue(new a(dVar));
    }

    r<T> i(Response response) throws IOException {
        ResponseBody responseBodyBody = response.body();
        Response responseBuild = response.newBuilder().body(new c(responseBodyBody.contentType(), responseBodyBody.contentLength())).build();
        int iCode = responseBuild.code();
        if (iCode < 200 || iCode >= 300) {
            try {
                return r.d(u.a(responseBodyBody), responseBuild);
            } finally {
                responseBodyBody.close();
            }
        }
        if (iCode == 204 || iCode == 205) {
            responseBodyBody.close();
            return r.l(null, responseBuild);
        }
        b bVar = new b(responseBodyBody);
        try {
            return r.l(this.f40176a.d(bVar), responseBuild);
        } catch (RuntimeException e8) {
            bVar.b();
            throw e8;
        }
    }

    @Override // retrofit2.b
    public boolean isCanceled() {
        boolean z7 = true;
        if (this.f40178c) {
            return true;
        }
        synchronized (this) {
            Call call = this.f40179d;
            if (call == null || !call.isCanceled()) {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // retrofit2.b
    public synchronized boolean isExecuted() {
        return this.f40181f;
    }

    @Override // retrofit2.b
    public synchronized Request request() {
        Call call = this.f40179d;
        if (call != null) {
            return call.request();
        }
        Throwable th = this.f40180e;
        if (th != null) {
            if (th instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.f40180e);
            }
            throw ((RuntimeException) th);
        }
        try {
            Call callH = h();
            this.f40179d = callH;
            return callH.request();
        } catch (IOException e8) {
            this.f40180e = e8;
            throw new RuntimeException("Unable to create request.", e8);
        } catch (RuntimeException e9) {
            this.f40180e = e9;
            throw e9;
        }
    }
}
