package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(serializable = true)
public class m6<R, C, V> extends gg<R, C, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f20602i = 0;

    private static class a<C, V> implements com.google.common.base.p0<Map<C, V>>, Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f20603b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f20604a;

        a(int i7) {
            this.f20604a = i7;
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<C, V> get() {
            return wb.o0(this.f20604a);
        }
    }

    m6(Map<R, Map<C, V>> map, a<C, V> aVar) {
        super(map, aVar);
    }

    public static <R, C, V> m6<R, C, V> B() {
        return new m6<>(new LinkedHashMap(), new a(0));
    }

    public static <R, C, V> m6<R, C, V> C(int i7, int i8) {
        f2.b(i8, "expectedCellsPerRow");
        return new m6<>(wb.o0(i7), new a(i8));
    }

    public static <R, C, V> m6<R, C, V> D(oj<? extends R, ? extends C, ? extends V> ojVar) {
        m6<R, C, V> m6VarB = B();
        m6VarB.O(ojVar);
        return m6VarB;
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Set L() {
        return super.L();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public boolean M(Object obj) {
        return super.M(obj);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ void O(oj ojVar) {
        super.O(ojVar);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public boolean P(Object obj, Object obj2) {
        return super.P(obj, obj2);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Map S() {
        return super.S();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.gg, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Map X(Object obj) {
        return super.X(obj);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Map f() {
        return super.f();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Set g() {
        return super.g();
    }

    @Override // com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public V k(Object obj, Object obj2) {
        return (V) super.k(obj, obj2);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public boolean m(Object obj) {
        return super.m(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.gg, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Map n(Object obj) {
        return super.n(obj);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Set r() {
        return super.r();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    @u1.a
    public V remove(Object obj, Object obj2) {
        return (V) super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    @u1.a
    public /* bridge */ /* synthetic */ Object t(Object obj, Object obj2, Object obj3) {
        return super.t(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.h0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.gg, com.google.common.collect.h0, com.google.common.collect.oj
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }
}
