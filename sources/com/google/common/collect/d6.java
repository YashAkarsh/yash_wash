package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public abstract class d6<E> extends j5<E> implements Set<E> {
    protected d6() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || w0().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return w0().hashCode();
    }

    @Override // com.google.common.collect.j5
    protected boolean n0(Collection<?> collection) {
        return af.I(this, (Collection) com.google.common.base.e0.E(collection));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.j5
    public abstract Set<E> z0();

    protected boolean x0(Object obj) {
        return af.g(this, obj);
    }

    protected int y0() {
        return af.k(this);
    }
}
