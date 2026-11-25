package kotlin.text;

import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final String f35401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final kotlin.ranges.k f35402b;

    public j(@a7.d String value, @a7.d kotlin.ranges.k range) {
        l0.p(value, "value");
        l0.p(range, "range");
        this.f35401a = value;
        this.f35402b = range;
    }

    public static /* synthetic */ j d(j jVar, String str, kotlin.ranges.k kVar, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = jVar.f35401a;
        }
        if ((i7 & 2) != 0) {
            kVar = jVar.f35402b;
        }
        return jVar.c(str, kVar);
    }

    @a7.d
    public final String a() {
        return this.f35401a;
    }

    @a7.d
    public final kotlin.ranges.k b() {
        return this.f35402b;
    }

    @a7.d
    public final j c(@a7.d String value, @a7.d kotlin.ranges.k range) {
        l0.p(value, "value");
        l0.p(range, "range");
        return new j(value, range);
    }

    @a7.d
    public final kotlin.ranges.k e() {
        return this.f35402b;
    }

    public boolean equals(@a7.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return l0.g(this.f35401a, jVar.f35401a) && l0.g(this.f35402b, jVar.f35402b);
    }

    @a7.d
    public final String f() {
        return this.f35401a;
    }

    public int hashCode() {
        return (this.f35401a.hashCode() * 31) + this.f35402b.hashCode();
    }

    @a7.d
    public String toString() {
        return "MatchGroup(value=" + this.f35401a + ", range=" + this.f35402b + ')';
    }
}
