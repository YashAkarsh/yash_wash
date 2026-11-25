package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final j.d f6118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final Handler f6119b;

    /* JADX INFO: renamed from: androidx.core.provider.a$a, reason: collision with other inner class name */
    class RunnableC0068a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j.d f6120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Typeface f6121b;

        RunnableC0068a(j.d dVar, Typeface typeface) {
            this.f6120a = dVar;
            this.f6121b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6120a.b(this.f6121b);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ j.d f6123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6124b;

        b(j.d dVar, int i7) {
            this.f6123a = dVar;
            this.f6124b = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6123a.a(this.f6124b);
        }
    }

    a(@m0 j.d dVar, @m0 Handler handler) {
        this.f6118a = dVar;
        this.f6119b = handler;
    }

    private void a(int i7) {
        this.f6119b.post(new b(this.f6118a, i7));
    }

    private void c(@m0 Typeface typeface) {
        this.f6119b.post(new RunnableC0068a(this.f6118a, typeface));
    }

    void b(@m0 i.e eVar) {
        if (eVar.a()) {
            c(eVar.f6149a);
        } else {
            a(eVar.f6150b);
        }
    }

    a(@m0 j.d dVar) {
        this.f6118a = dVar;
        this.f6119b = androidx.core.provider.b.a();
    }
}
