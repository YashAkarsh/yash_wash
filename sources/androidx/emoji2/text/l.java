package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.graphics.a4;
import androidx.core.os.r0;
import androidx.core.util.w;
import c.h1;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import c.z;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class l extends f.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final b f7655j = new b();

    public static class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f7656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f7657b;

        public a(long j7) {
            this.f7656a = j7;
        }

        @Override // androidx.emoji2.text.l.d
        public long a() {
            if (this.f7657b == 0) {
                this.f7657b = SystemClock.uptimeMillis();
                return 0L;
            }
            long jUptimeMillis = SystemClock.uptimeMillis() - this.f7657b;
            if (jUptimeMillis > this.f7656a) {
                return -1L;
            }
            return Math.min(Math.max(jUptimeMillis, 1000L), this.f7656a - jUptimeMillis);
        }
    }

    @x0({x0.a.LIBRARY})
    public static class b {
        @o0
        public Typeface a(@m0 Context context, @m0 androidx.core.provider.j.c cVar) throws PackageManager.NameNotFoundException {
            return androidx.core.provider.j.a(context, null, new androidx.core.provider.j.c[]{cVar});
        }

        @m0
        public androidx.core.provider.j.b b(@m0 Context context, @m0 androidx.core.provider.h hVar) throws PackageManager.NameNotFoundException {
            return androidx.core.provider.j.b(context, null, hVar);
        }

        public void c(@m0 Context context, @m0 Uri uri, @m0 ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void d(@m0 Context context, @m0 ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements f.i {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final String f7658l = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final Context f7659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        private final androidx.core.provider.h f7660b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @m0
        private final b f7661c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @m0
        private final Object f7662d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @o0
        @z("mLock")
        private Handler f7663e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @o0
        @z("mLock")
        private Executor f7664f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @o0
        @z("mLock")
        private ThreadPoolExecutor f7665g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @o0
        @z("mLock")
        private d f7666h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @o0
        @z("mLock")
        f.j f7667i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @o0
        @z("mLock")
        private ContentObserver f7668j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @o0
        @z("mLock")
        private Runnable f7669k;

        class a extends ContentObserver {
            a(Handler handler) {
                super(handler);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z7, Uri uri) {
                c.this.d();
            }
        }

        c(@m0 Context context, @m0 androidx.core.provider.h hVar, @m0 b bVar) {
            w.m(context, "Context cannot be null");
            w.m(hVar, "FontRequest cannot be null");
            this.f7659a = context.getApplicationContext();
            this.f7660b = hVar;
            this.f7661c = bVar;
        }

        private void b() {
            synchronized (this.f7662d) {
                this.f7667i = null;
                ContentObserver contentObserver = this.f7668j;
                if (contentObserver != null) {
                    this.f7661c.d(this.f7659a, contentObserver);
                    this.f7668j = null;
                }
                Handler handler = this.f7663e;
                if (handler != null) {
                    handler.removeCallbacks(this.f7669k);
                }
                this.f7663e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f7665g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f7664f = null;
                this.f7665g = null;
            }
        }

        @h1
        private androidx.core.provider.j.c e() {
            try {
                androidx.core.provider.j.b bVarB = this.f7661c.b(this.f7659a, this.f7660b);
                if (bVarB.c() == 0) {
                    androidx.core.provider.j.c[] cVarArrB = bVarB.b();
                    if (cVarArrB == null || cVarArrB.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return cVarArrB[0];
                }
                throw new RuntimeException("fetchFonts failed (" + bVarB.c() + ")");
            } catch (PackageManager.NameNotFoundException e8) {
                throw new RuntimeException("provider not found", e8);
            }
        }

        @h1
        @t0(19)
        private void f(Uri uri, long j7) {
            synchronized (this.f7662d) {
                Handler handlerE = this.f7663e;
                if (handlerE == null) {
                    handlerE = androidx.emoji2.text.c.e();
                    this.f7663e = handlerE;
                }
                if (this.f7668j == null) {
                    a aVar = new a(handlerE);
                    this.f7668j = aVar;
                    this.f7661c.c(this.f7659a, uri, aVar);
                }
                if (this.f7669k == null) {
                    this.f7669k = new Runnable() { // from class: androidx.emoji2.text.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f7672a.d();
                        }
                    };
                }
                handlerE.postDelayed(this.f7669k, j7);
            }
        }

        @Override // androidx.emoji2.text.f.i
        @t0(19)
        public void a(@m0 f.j jVar) {
            w.m(jVar, "LoaderCallback cannot be null");
            synchronized (this.f7662d) {
                this.f7667i = jVar;
            }
            d();
        }

        @h1
        @t0(19)
        void c() {
            synchronized (this.f7662d) {
                if (this.f7667i == null) {
                    return;
                }
                try {
                    androidx.core.provider.j.c cVarE = e();
                    int iB = cVarE.b();
                    if (iB == 2) {
                        synchronized (this.f7662d) {
                            d dVar = this.f7666h;
                            if (dVar != null) {
                                long jA = dVar.a();
                                if (jA >= 0) {
                                    f(cVarE.d(), jA);
                                    return;
                                }
                            }
                        }
                    }
                    if (iB != 0) {
                        throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                    }
                    try {
                        r0.b(f7658l);
                        Typeface typefaceA = this.f7661c.a(this.f7659a, cVarE);
                        ByteBuffer byteBufferF = a4.f(this.f7659a, null, cVarE.d());
                        if (byteBufferF == null || typefaceA == null) {
                            throw new RuntimeException("Unable to open file.");
                        }
                        p pVarE = p.e(typefaceA, byteBufferF);
                        r0.d();
                        synchronized (this.f7662d) {
                            f.j jVar = this.f7667i;
                            if (jVar != null) {
                                jVar.b(pVarE);
                            }
                        }
                        b();
                    } catch (Throwable th) {
                        r0.d();
                        throw th;
                    }
                } catch (Throwable th2) {
                    synchronized (this.f7662d) {
                        f.j jVar2 = this.f7667i;
                        if (jVar2 != null) {
                            jVar2.a(th2);
                        }
                        b();
                    }
                }
            }
        }

        @t0(19)
        void d() {
            synchronized (this.f7662d) {
                if (this.f7667i == null) {
                    return;
                }
                if (this.f7664f == null) {
                    ThreadPoolExecutor threadPoolExecutorC = androidx.emoji2.text.c.c("emojiCompat");
                    this.f7665g = threadPoolExecutorC;
                    this.f7664f = threadPoolExecutorC;
                }
                this.f7664f.execute(new Runnable() { // from class: androidx.emoji2.text.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7671a.c();
                    }
                });
            }
        }

        public void g(@m0 Executor executor) {
            synchronized (this.f7662d) {
                this.f7664f = executor;
            }
        }

        public void h(@o0 d dVar) {
            synchronized (this.f7662d) {
                this.f7666h = dVar;
            }
        }
    }

    public static abstract class d {
        public abstract long a();
    }

    public l(@m0 Context context, @m0 androidx.core.provider.h hVar) {
        super(new c(context, hVar, f7655j));
    }

    @m0
    @Deprecated
    public l k(@o0 Handler handler) {
        if (handler == null) {
            return this;
        }
        l(androidx.emoji2.text.c.b(handler));
        return this;
    }

    @m0
    public l l(@m0 Executor executor) {
        ((c) a()).g(executor);
        return this;
    }

    @m0
    public l m(@o0 d dVar) {
        ((c) a()).h(dVar);
        return this;
    }

    @x0({x0.a.LIBRARY})
    public l(@m0 Context context, @m0 androidx.core.provider.h hVar, @m0 b bVar) {
        super(new c(context, hVar, bVar));
    }
}
