package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@s1.b(serializable = true)
final class b0<T> extends l<Iterable<T>> implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f19298b = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final l<? super T> f19299a;

    b0(l<? super T> lVar) {
        this.f19299a = (l) e0.E(lVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof b0) {
            return this.f19299a.equals(((b0) obj).f19299a);
        }
        return false;
    }

    public int hashCode() {
        return this.f19299a.hashCode() ^ 1185147655;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.base.l
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public boolean a(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> it = iterable.iterator();
        Iterator<T> it2 = iterable2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.f19299a.d(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.base.l
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public int b(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        int iF = 78721;
        while (it.hasNext()) {
            iF = (iF * 24943) + this.f19299a.f(it.next());
        }
        return iF;
    }

    public String toString() {
        return this.f19299a + ".pairwise()";
    }
}
