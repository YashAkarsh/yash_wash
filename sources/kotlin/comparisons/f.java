package kotlin.comparisons;

import java.util.Comparator;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
final class f implements Comparator<Comparable<? super Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final f f34663a = new f();

    private f() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@a7.d Comparable<Object> a8, @a7.d Comparable<Object> b8) {
        l0.p(a8, "a");
        l0.p(b8, "b");
        return b8.compareTo(a8);
    }

    @Override // java.util.Comparator
    @a7.d
    public final Comparator<Comparable<? super Object>> reversed() {
        return e.f34662a;
    }
}
