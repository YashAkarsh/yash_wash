package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public final class r6<E> extends u<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @s1.c
    private static final long f21000f = 0;

    private r6() {
        super(new HashMap());
    }

    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int iH = se.h(objectInputStream);
        r(wb.i0());
        se.g(this, objectInputStream, iH);
    }

    public static <E> r6<E> t() {
        return new r6<>();
    }

    public static <E> r6<E> u(int i7) {
        return new r6<>(i7);
    }

    public static <E> r6<E> v(Iterable<? extends E> iterable) {
        r6<E> r6VarU = u(md.n(iterable));
        ma.a(r6VarU, iterable);
        return r6VarU;
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        se.k(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public /* bridge */ /* synthetic */ boolean E(Object obj, int i7, int i8) {
        return super.E(obj, i7, i8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.u, com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public /* bridge */ /* synthetic */ int add(Object obj, int i7) {
        return super.add(obj, i7);
    }

    @Override // com.google.common.collect.u, com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ Set e() {
        return super.e();
    }

    @Override // com.google.common.collect.u, com.google.common.collect.y, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.u, com.google.common.collect.y, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ void h0(ObjIntConsumer objIntConsumer) {
        super.h0(objIntConsumer);
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.u, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // com.google.common.collect.u, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ int l0(Object obj) {
        return super.l0(obj);
    }

    @Override // com.google.common.collect.u, com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public /* bridge */ /* synthetic */ int remove(Object obj, int i7) {
        return super.remove(obj, i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.u, com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public /* bridge */ /* synthetic */ int setCount(Object obj, int i7) {
        return super.setCount(obj, i7);
    }

    @Override // com.google.common.collect.u, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    private r6(int i7) {
        super(wb.k0(i7));
    }
}
