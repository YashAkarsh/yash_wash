package com.google.common.collect;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
final class r3<T> extends td<T> implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f20996d = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Comparator<T> f20997c;

    r3(Comparator<T> comparator) {
        this.f20997c = (Comparator) com.google.common.base.e0.E(comparator);
    }

    @Override // com.google.common.collect.td, java.util.Comparator
    public int compare(T t7, T t8) {
        return this.f20997c.compare(t7, t8);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r3) {
            return this.f20997c.equals(((r3) obj).f20997c);
        }
        return false;
    }

    public int hashCode() {
        return this.f20997c.hashCode();
    }

    public String toString() {
        return this.f20997c.toString();
    }
}
