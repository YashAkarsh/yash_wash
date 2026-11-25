package com.google.common.collect;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Set;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
final class q4<C extends Comparable> extends i4<C> {

    @s1.c
    private static final class b<C extends Comparable> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f20972b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p4<C> f20973a;

        private Object readResolve() {
            return new q4(this.f20973a);
        }

        private b(p4<C> p4Var) {
            this.f20973a = p4Var;
        }
    }

    q4(p4<C> p4Var) {
        super(p4Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.i4, com.google.common.collect.s9
    /* JADX INFO: renamed from: T0 */
    public i4<C> q0(C c8, boolean z7) {
        return this;
    }

    @Override // com.google.common.collect.i4
    public i4<C> U0(i4<C> i4Var) {
        return this;
    }

    @Override // com.google.common.collect.i4
    public xd<C> V0() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.i4
    public xd<C> W0(s0 s0Var, s0 s0Var2) {
        throw new NoSuchElementException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.i4, com.google.common.collect.s9
    /* JADX INFO: renamed from: Z0 */
    public i4<C> F0(C c8, boolean z7, C c9, boolean z8) {
        return this;
    }

    @Override // com.google.common.collect.u8, com.google.common.collect.x6
    public d7<C> a() {
        return d7.x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.i4, com.google.common.collect.s9
    /* JADX INFO: renamed from: c1 */
    public i4<C> I0(C c8, boolean z7) {
        return this;
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return false;
    }

    @Override // com.google.common.collect.s9, java.util.SortedSet
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public C first() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.s9, java.util.SortedSet
    /* JADX INFO: renamed from: e1, reason: merged with bridge method [inline-methods] */
    public C last() {
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.u8, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj instanceof Set) {
            return ((Set) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return false;
    }

    @Override // com.google.common.collect.u8, java.util.Collection, java.util.Set
    public int hashCode() {
        return 0;
    }

    @Override // com.google.common.collect.i4, com.google.common.collect.s9
    @s1.c
    s9<C> i0() {
        return s9.m0(td.A().F());
    }

    @Override // com.google.common.collect.s9
    @s1.c
    int indexOf(Object obj) {
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.common.collect.s9, com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<C> iterator() {
        return ua.u();
    }

    @Override // com.google.common.collect.s9, java.util.NavigableSet
    @s1.c
    /* JADX INFO: renamed from: j0 */
    public ck<C> descendingIterator() {
        return ua.u();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 0;
    }

    @Override // com.google.common.collect.i4, java.util.AbstractCollection
    public String toString() {
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    @Override // com.google.common.collect.s9, com.google.common.collect.u8, com.google.common.collect.x6
    @s1.c
    Object writeReplace() {
        return new b(this.f20402m);
    }

    @Override // com.google.common.collect.u8
    @s1.c
    boolean x() {
        return true;
    }
}
