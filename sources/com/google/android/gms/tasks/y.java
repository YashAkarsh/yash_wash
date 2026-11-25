package com.google.android.gms.tasks;

/* JADX INFO: loaded from: classes.dex */
final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f16841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ z f16842b;

    y(z zVar, m mVar) {
        this.f16842b = zVar;
        this.f16841a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f16841a.t()) {
            this.f16842b.f16845c.A();
            return;
        }
        try {
            this.f16842b.f16845c.z(this.f16842b.f16844b.a(this.f16841a));
        } catch (k e8) {
            if (e8.getCause() instanceof Exception) {
                this.f16842b.f16845c.y((Exception) e8.getCause());
            } else {
                this.f16842b.f16845c.y(e8);
            }
        } catch (Exception e9) {
            this.f16842b.f16845c.y(e9);
        }
    }
}
