package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
@j2
public abstract class d<T> extends j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f36970a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_consensus");

    @a7.d
    private volatile /* synthetic */ Object _consensus = c.f36964a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.j0
    @a7.d
    public d<?> a() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.j0
    @a7.e
    public final Object c(@a7.e Object obj) {
        Object objE = this._consensus;
        if (objE == c.f36964a) {
            objE = e(i(obj));
        }
        d(obj, objE);
        return objE;
    }

    public abstract void d(T t7, @a7.e Object obj);

    @a7.e
    public final Object e(@a7.e Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = c.f36964a;
        if (obj2 != obj3) {
            return obj2;
        }
        return androidx.concurrent.futures.b.a(f36970a, this, obj3, obj) ? obj : this._consensus;
    }

    @a7.e
    public final Object f() {
        return this._consensus;
    }

    public long g() {
        return 0L;
    }

    public final boolean h() {
        return this._consensus != c.f36964a;
    }

    @a7.e
    public abstract Object i(T t7);
}
