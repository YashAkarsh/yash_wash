package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
abstract class t6<E> extends d7<E> {

    @s1.c
    static class a implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f21105b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final x6<?> f21106a;

        a(x6<?> x6Var) {
            this.f21106a = x6Var;
        }

        Object readResolve() {
            return this.f21106a.a();
        }
    }

    t6() {
    }

    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    abstract x6<E> W();

    @Override // com.google.common.collect.d7, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return W().contains(obj);
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return W().h();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return W().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return W().size();
    }

    @Override // com.google.common.collect.d7, com.google.common.collect.x6
    @s1.c
    Object writeReplace() {
        return new a(W());
    }
}
