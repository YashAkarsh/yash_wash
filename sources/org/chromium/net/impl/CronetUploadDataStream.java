package org.chromium.net.impl;

import android.annotation.SuppressLint;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.s0;
import org.chromium.net.q0;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("cronet")
@s0
public final class CronetUploadDataStream extends org.chromium.net.s0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f39214n = "CronetUploadDataStream";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f39215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VersionSafeCallbacks.f f39216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CronetUrlRequest f39217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f39218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f39219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f39220f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ByteBuffer f39222h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @GuardedBy("mLock")
    private long f39224j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @GuardedBy("mLock")
    private boolean f39226l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Runnable f39227m;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f39221g = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f39223i = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("mLock")
    private int f39225k = 3;

    class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ boolean f39228b = false;

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.f39223i) {
                if (CronetUploadDataStream.this.f39224j == 0) {
                    return;
                }
                CronetUploadDataStream.this.p(3);
                if (CronetUploadDataStream.this.f39222h == null) {
                    throw new IllegalStateException("Unexpected readData call. Buffer is null");
                }
                CronetUploadDataStream.this.f39225k = 0;
                try {
                    CronetUploadDataStream.this.o();
                    VersionSafeCallbacks.f fVar = CronetUploadDataStream.this.f39216b;
                    CronetUploadDataStream cronetUploadDataStream = CronetUploadDataStream.this;
                    fVar.c(cronetUploadDataStream, cronetUploadDataStream.f39222h);
                } catch (Exception e8) {
                    CronetUploadDataStream.this.u(e8);
                }
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (CronetUploadDataStream.this.f39223i) {
                if (CronetUploadDataStream.this.f39224j == 0) {
                    return;
                }
                CronetUploadDataStream.this.p(3);
                CronetUploadDataStream.this.f39225k = 1;
                try {
                    CronetUploadDataStream.this.o();
                    CronetUploadDataStream.this.f39216b.e(CronetUploadDataStream.this);
                } catch (Exception e8) {
                    CronetUploadDataStream.this.u(e8);
                }
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                CronetUploadDataStream.this.o();
                CronetUploadDataStream.this.f39216b.close();
            } catch (Exception e8) {
                org.chromium.base.t.j(CronetUploadDataStream.f39214n, "Exception thrown when closing", e8);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface d {
        public static final int H6 = 0;
        public static final int I6 = 1;
        public static final int J6 = 2;
        public static final int K6 = 3;
    }

    public CronetUploadDataStream(q0 q0Var, Executor executor, CronetUrlRequest cronetUrlRequest) {
        this.f39215a = executor;
        this.f39216b = new VersionSafeCallbacks.f(q0Var);
        this.f39217c = cronetUrlRequest;
    }

    private native long nativeAttachUploadDataToRequest(long j7, long j8);

    private native long nativeCreateAdapterForTesting();

    private native long nativeCreateUploadDataStreamForTesting(long j7, long j8);

    @x6.f("CronetUploadDataStreamAdapter")
    private static native void nativeDestroy(long j7);

    @x6.f("CronetUploadDataStreamAdapter")
    private native void nativeOnReadSucceeded(long j7, int i7, boolean z7);

    @x6.f("CronetUploadDataStreamAdapter")
    private native void nativeOnRewindSucceeded(long j7);

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        this.f39217c.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @GuardedBy("mLock")
    public void p(int i7) {
        if (this.f39225k == i7) {
            return;
        }
        throw new IllegalStateException("Expected " + i7 + ", but was " + this.f39225k);
    }

    private void r() {
        synchronized (this.f39223i) {
            if (this.f39225k == 0) {
                this.f39226l = true;
                return;
            }
            long j7 = this.f39224j;
            if (j7 == 0) {
                return;
            }
            nativeDestroy(j7);
            this.f39224j = 0L;
            Runnable runnable = this.f39227m;
            if (runnable != null) {
                runnable.run();
            }
            v(new c());
        }
    }

    private void s() {
        synchronized (this.f39223i) {
            if (this.f39225k == 0) {
                throw new IllegalStateException("Method should not be called when read has not completed.");
            }
            if (this.f39226l) {
                r();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Throwable th) {
        boolean z7;
        synchronized (this.f39223i) {
            int i7 = this.f39225k;
            if (i7 == 3) {
                throw new IllegalStateException("There is no read or rewind or length check in progress.");
            }
            z7 = i7 == 2;
            this.f39225k = 3;
            this.f39222h = null;
            s();
        }
        if (z7) {
            try {
                this.f39216b.close();
            } catch (Exception e8) {
                org.chromium.base.t.j(f39214n, "Failure closing data provider", e8);
            }
        }
        this.f39217c.I(th);
    }

    @Override // org.chromium.net.s0
    public void a(Exception exc) {
        synchronized (this.f39223i) {
            p(0);
            u(exc);
        }
    }

    @Override // org.chromium.net.s0
    @SuppressLint({"DefaultLocale"})
    public void b(boolean z7) {
        synchronized (this.f39223i) {
            p(0);
            if (this.f39220f != this.f39222h.limit()) {
                throw new IllegalStateException("ByteBuffer limit changed");
            }
            if (z7 && this.f39218d >= 0) {
                throw new IllegalArgumentException("Non-chunked upload can't have last chunk");
            }
            int iPosition = this.f39222h.position();
            long j7 = this.f39219e - ((long) iPosition);
            this.f39219e = j7;
            if (j7 < 0 && this.f39218d >= 0) {
                throw new IllegalArgumentException(String.format("Read upload data length %d exceeds expected length %d", Long.valueOf(this.f39218d - this.f39219e), Long.valueOf(this.f39218d)));
            }
            this.f39222h.position(0);
            this.f39222h = null;
            this.f39225k = 3;
            s();
            long j8 = this.f39224j;
            if (j8 == 0) {
                return;
            }
            nativeOnReadSucceeded(j8, iPosition, z7);
        }
    }

    @Override // org.chromium.net.s0
    public void c(Exception exc) {
        synchronized (this.f39223i) {
            p(1);
            u(exc);
        }
    }

    @Override // org.chromium.net.s0
    public void d() {
        synchronized (this.f39223i) {
            p(1);
            this.f39225k = 3;
            this.f39219e = this.f39218d;
            long j7 = this.f39224j;
            if (j7 == 0) {
                return;
            }
            nativeOnRewindSucceeded(j7);
        }
    }

    void n(long j7) {
        synchronized (this.f39223i) {
            this.f39224j = nativeAttachUploadDataToRequest(j7, this.f39218d);
        }
    }

    @CalledByNative
    void onUploadDataStreamDestroyed() {
        r();
    }

    @s0
    public long q() throws IOException {
        long jNativeCreateUploadDataStreamForTesting;
        synchronized (this.f39223i) {
            this.f39224j = nativeCreateAdapterForTesting();
            long jB = this.f39216b.b();
            this.f39218d = jB;
            this.f39219e = jB;
            jNativeCreateUploadDataStreamForTesting = nativeCreateUploadDataStreamForTesting(jB, this.f39224j);
        }
        return jNativeCreateUploadDataStreamForTesting;
    }

    @CalledByNative
    void readData(ByteBuffer byteBuffer) {
        this.f39222h = byteBuffer;
        this.f39220f = byteBuffer.limit();
        v(this.f39221g);
    }

    @CalledByNative
    void rewind() {
        v(new b());
    }

    void t() {
        synchronized (this.f39223i) {
            this.f39225k = 2;
        }
        try {
            this.f39217c.y();
            long jB = this.f39216b.b();
            this.f39218d = jB;
            this.f39219e = jB;
        } catch (Throwable th) {
            u(th);
        }
        synchronized (this.f39223i) {
            this.f39225k = 3;
        }
    }

    void v(Runnable runnable) {
        try {
            this.f39215a.execute(runnable);
        } catch (Throwable th) {
            this.f39217c.I(th);
        }
    }

    @s0
    void w(Runnable runnable) {
        this.f39227m = runnable;
    }
}
