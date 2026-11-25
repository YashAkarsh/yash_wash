package com.google.common.collect;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class x4<T> extends td<T> implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f21397d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final v7<T, Integer> f21398c;

    x4(List<T> list) {
        this(wb.V(list));
    }

    private int J(T t7) {
        Integer num = this.f21398c.get(t7);
        if (num != null) {
            return num.intValue();
        }
        throw new td.c(t7);
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    public int compare(T t7, T t8) {
        return J(t7) - J(t8);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj instanceof x4) {
            return this.f21398c.equals(((x4) obj).f21398c);
        }
        return false;
    }

    public int hashCode() {
        return this.f21398c.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.f21398c.keySet() + ")";
    }

    x4(v7<T, Integer> v7Var) {
        this.f21398c = v7Var;
    }
}
