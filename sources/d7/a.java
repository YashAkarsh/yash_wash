package d7;

import org.junit.runner.i;
import org.junit.runner.l;

/* JADX INFO: loaded from: classes3.dex */
public class a extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f33506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f33507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f33508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile l f33509d;

    public a(Class<?> cls, boolean z7) {
        this.f33506a = new Object();
        this.f33507b = cls;
        this.f33508c = z7;
    }

    @Override // org.junit.runner.i
    public l h() {
        if (this.f33509d == null) {
            synchronized (this.f33506a) {
                if (this.f33509d == null) {
                    this.f33509d = new org.junit.internal.builders.a(this.f33508c).g(this.f33507b);
                }
            }
        }
        return this.f33509d;
    }

    public a(Class<?> cls) {
        this(cls, true);
    }
}
