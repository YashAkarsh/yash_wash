package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class k<T> extends WeakReference<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @h5.e
    public final int f35976a;

    public k(T t7, @a7.e ReferenceQueue<T> referenceQueue) {
        super(t7, referenceQueue);
        this.f35976a = t7 == null ? 0 : t7.hashCode();
    }
}
