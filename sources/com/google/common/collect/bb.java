package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class bb<T> extends td<Iterable<T>> implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f19963d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Comparator<? super T> f19964c;

    bb(Comparator<? super T> comparator) {
        this.f19964c = comparator;
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public int compare(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> it = iterable.iterator();
        Iterator<T> it2 = iterable2.iterator();
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return 1;
            }
            int iCompare = this.f19964c.compare(it.next(), it2.next());
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return it2.hasNext() ? -1 : 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bb) {
            return this.f19964c.equals(((bb) obj).f19964c);
        }
        return false;
    }

    public int hashCode() {
        return this.f19964c.hashCode() ^ 2075626741;
    }

    public String toString() {
        return this.f19964c + ".lexicographical()";
    }
}
