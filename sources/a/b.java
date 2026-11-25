package a;

import android.content.Context;
import c.m0;
import c.o0;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<c> f2a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Context f3b;

    public void a(@m0 c cVar) {
        if (this.f3b != null) {
            cVar.a(this.f3b);
        }
        this.f2a.add(cVar);
    }

    public void b() {
        this.f3b = null;
    }

    public void c(@m0 Context context) {
        this.f3b = context;
        Iterator<c> it = this.f2a.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }

    @o0
    public Context d() {
        return this.f3b;
    }

    public void e(@m0 c cVar) {
        this.f2a.remove(cVar);
    }
}
