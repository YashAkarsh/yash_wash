package androidx.activity;

import c.j0;
import c.m0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<a> f578b = new CopyOnWriteArrayList<>();

    public g(boolean z7) {
        this.f577a = z7;
    }

    void a(@m0 a aVar) {
        this.f578b.add(aVar);
    }

    @j0
    public abstract void b();

    @j0
    public final boolean c() {
        return this.f577a;
    }

    @j0
    public final void d() {
        Iterator<a> it = this.f578b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    void e(@m0 a aVar) {
        this.f578b.remove(aVar);
    }

    @j0
    public final void f(boolean z7) {
        this.f577a = z7;
    }
}
