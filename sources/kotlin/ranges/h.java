package kotlin.ranges;

import java.lang.Comparable;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
class h<T extends Comparable<? super T>> implements g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final T f35024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final T f35025b;

    public h(@a7.d T start, @a7.d T endInclusive) {
        l0.p(start, "start");
        l0.p(endInclusive, "endInclusive");
        this.f35024a = start;
        this.f35025b = endInclusive;
    }

    @Override // kotlin.ranges.g
    public boolean a(@a7.d T t7) {
        return g.a.a(this, t7);
    }

    @Override // kotlin.ranges.g
    @a7.d
    public T d() {
        return this.f35024a;
    }

    public boolean equals(@a7.e Object obj) {
        if (obj instanceof h) {
            if (!isEmpty() || !((h) obj).isEmpty()) {
                h hVar = (h) obj;
                if (!l0.g(d(), hVar.d()) || !l0.g(f(), hVar.f())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.g
    @a7.d
    public T f() {
        return this.f35025b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (d().hashCode() * 31) + f().hashCode();
    }

    @Override // kotlin.ranges.g
    public boolean isEmpty() {
        return g.a.b(this);
    }

    @a7.d
    public String toString() {
        return d() + ".." + f();
    }
}
