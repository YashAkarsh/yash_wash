package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
final class b<T, K> extends kotlin.collections.b<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final Iterator<T> f35103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final i5.l<T, K> f35104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private final HashSet<K> f35105e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@a7.d Iterator<? extends T> source, @a7.d i5.l<? super T, ? extends K> keySelector) {
        l0.p(source, "source");
        l0.p(keySelector, "keySelector");
        this.f35103c = source;
        this.f35104d = keySelector;
        this.f35105e = new HashSet<>();
    }

    @Override // kotlin.collections.b
    protected void a() {
        while (this.f35103c.hasNext()) {
            T next = this.f35103c.next();
            if (this.f35105e.add(this.f35104d.z(next))) {
                d(next);
                return;
            }
        }
        b();
    }
}
