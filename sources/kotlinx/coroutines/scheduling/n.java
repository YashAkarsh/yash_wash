package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.a1;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    @h5.e
    public final Runnable f37188c;

    public n(@a7.d Runnable runnable, long j7, @a7.d l lVar) {
        super(j7, lVar);
        this.f37188c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f37188c.run();
        } finally {
            this.f37186b.G();
        }
    }

    @a7.d
    public String toString() {
        return "Task[" + a1.a(this.f37188c) + '@' + a1.b(this.f37188c) + ", " + this.f37185a + ", " + this.f37186b + ']';
    }
}
