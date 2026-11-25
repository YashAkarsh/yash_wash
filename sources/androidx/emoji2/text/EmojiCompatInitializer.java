package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.r0;
import androidx.lifecycle.ProcessLifecycleInitializer;
import c.h1;
import c.m0;
import c.o0;
import c.t0;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements androidx.startup.b<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f7443a = 500;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7444b = "EmojiCompatInitializer";

    @t0(19)
    static class a extends f.d {
        protected a(Context context) {
            super(new b(context));
            f(1);
        }
    }

    @t0(19)
    static class b implements f.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f7447a;

        class a extends f.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ f.j f7448a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f7449b;

            a(f.j jVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f7448a = jVar;
                this.f7449b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.f.j
            public void a(@o0 Throwable th) {
                try {
                    this.f7448a.a(th);
                } finally {
                    this.f7449b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.f.j
            public void b(@m0 p pVar) {
                try {
                    this.f7448a.b(pVar);
                } finally {
                    this.f7449b.shutdown();
                }
            }
        }

        b(Context context) {
            this.f7447a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.f.i
        public void a(@m0 final f.j jVar) {
            final ThreadPoolExecutor threadPoolExecutorC = androidx.emoji2.text.c.c(EmojiCompatInitializer.f7444b);
            threadPoolExecutorC.execute(new Runnable() { // from class: androidx.emoji2.text.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7620a.d(jVar, threadPoolExecutorC);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @h1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(@m0 f.j jVar, @m0 ThreadPoolExecutor threadPoolExecutor) {
            try {
                l lVarA = d.a(this.f7447a);
                if (lVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                lVarA.l(threadPoolExecutor);
                lVarA.a().a(new a(jVar, threadPoolExecutor));
            } catch (Throwable th) {
                jVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                r0.b("EmojiCompat.EmojiCompatInitializer.run");
                if (f.n()) {
                    f.b().q();
                }
            } finally {
                r0.d();
            }
        }
    }

    @Override // androidx.startup.b
    @m0
    public List<Class<? extends androidx.startup.b<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // androidx.startup.b
    @m0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean b(@m0 Context context) {
        f.m(new a(context));
        d(context);
        return Boolean.TRUE;
    }

    @t0(19)
    void d(@m0 Context context) {
        final androidx.lifecycle.m lifecycle = ((androidx.lifecycle.q) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new androidx.lifecycle.f() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.f, androidx.lifecycle.h
            public void a(@m0 androidx.lifecycle.q qVar) {
                EmojiCompatInitializer.this.e();
                lifecycle.c(this);
            }

            @Override // androidx.lifecycle.f, androidx.lifecycle.h
            public /* synthetic */ void b(androidx.lifecycle.q qVar) {
                androidx.lifecycle.e.a(this, qVar);
            }

            @Override // androidx.lifecycle.f, androidx.lifecycle.h
            public /* synthetic */ void c(androidx.lifecycle.q qVar) {
                androidx.lifecycle.e.c(this, qVar);
            }

            @Override // androidx.lifecycle.f, androidx.lifecycle.h
            public /* synthetic */ void d(androidx.lifecycle.q qVar) {
                androidx.lifecycle.e.f(this, qVar);
            }

            @Override // androidx.lifecycle.f, androidx.lifecycle.h
            public /* synthetic */ void e(androidx.lifecycle.q qVar) {
                androidx.lifecycle.e.b(this, qVar);
            }

            @Override // androidx.lifecycle.f, androidx.lifecycle.h
            public /* synthetic */ void f(androidx.lifecycle.q qVar) {
                androidx.lifecycle.e.e(this, qVar);
            }
        });
    }

    @t0(19)
    void e() {
        androidx.emoji2.text.c.e().postDelayed(new c(), f7443a);
    }
}
