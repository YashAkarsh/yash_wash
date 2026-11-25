package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
final class g<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Comparator<T> f34664a;

    public g(@a7.d Comparator<T> comparator) {
        l0.p(comparator, "comparator");
        this.f34664a = comparator;
    }

    @a7.d
    public final Comparator<T> a() {
        return this.f34664a;
    }

    @Override // java.util.Comparator
    public int compare(T t7, T t8) {
        return this.f34664a.compare(t8, t7);
    }

    @Override // java.util.Comparator
    @a7.d
    public final Comparator<T> reversed() {
        return this.f34664a;
    }
}
