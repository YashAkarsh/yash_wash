package org.chromium.base.task;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes3.dex */
final class e implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Choreographer f38912a;

    class a implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f38913a;

        a(Runnable runnable) {
            this.f38913a = runnable;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j7) {
            this.f38913a.run();
        }
    }

    class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f38915a;

        b(Runnable runnable) {
            this.f38915a = runnable;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j7) {
            this.f38915a.run();
        }
    }

    e(Choreographer choreographer) {
        this.f38912a = choreographer;
    }

    @Override // org.chromium.base.task.r
    public void a() {
    }

    @Override // org.chromium.base.task.r
    public void b(Runnable runnable, long j7) {
        this.f38912a.postFrameCallbackDelayed(new b(runnable), j7);
    }

    @Override // org.chromium.base.task.r
    public void c(Runnable runnable) {
        this.f38912a.postFrameCallback(new a(runnable));
    }

    @Override // org.chromium.base.task.r
    public void d() {
    }

    @Override // org.chromium.base.task.n
    public boolean e() {
        try {
            return this.f38912a == Choreographer.getInstance();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // org.chromium.base.task.r
    public void f() {
    }
}
