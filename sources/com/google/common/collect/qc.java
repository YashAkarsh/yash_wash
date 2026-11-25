package com.google.common.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.b
public final class qc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Collector<Object, ?, Optional<Object>> f20985a = Collector.of(new Supplier() { // from class: com.google.common.collect.kc
        @Override // java.util.function.Supplier
        public final Object get() {
            return new qc.a();
        }
    }, new BiConsumer() { // from class: com.google.common.collect.lc
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((qc.a) obj).a(obj2);
        }
    }, new BinaryOperator() { // from class: com.google.common.collect.mc
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((qc.a) obj).b((qc.a) obj2);
        }
    }, new Function() { // from class: com.google.common.collect.nc
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((qc.a) obj).d();
        }
    }, Collector.Characteristics.UNORDERED);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f20986b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Collector<Object, ?, Object> f20987c = Collector.of(new Supplier() { // from class: com.google.common.collect.kc
        @Override // java.util.function.Supplier
        public final Object get() {
            return new qc.a();
        }
    }, new BiConsumer() { // from class: com.google.common.collect.oc
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            qc.c((qc.a) obj, obj2);
        }
    }, new BinaryOperator() { // from class: com.google.common.collect.mc
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((qc.a) obj).b((qc.a) obj2);
        }
    }, new Function() { // from class: com.google.common.collect.pc
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return qc.d((qc.a) obj);
        }
    }, Collector.Characteristics.UNORDERED);

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int f20988c = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f20989a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<Object> f20990b = null;

        a() {
        }

        void a(Object obj) {
            com.google.common.base.e0.E(obj);
            if (this.f20989a == null) {
                this.f20989a = obj;
                return;
            }
            List<Object> list = this.f20990b;
            if (list == null) {
                ArrayList arrayList = new ArrayList(4);
                this.f20990b = arrayList;
                arrayList.add(obj);
            } else {
                if (list.size() >= 4) {
                    throw e(true);
                }
                this.f20990b.add(obj);
            }
        }

        a b(a aVar) {
            if (this.f20989a == null) {
                return aVar;
            }
            if (aVar.f20989a == null) {
                return this;
            }
            if (this.f20990b == null) {
                this.f20990b = new ArrayList();
            }
            this.f20990b.add(aVar.f20989a);
            List<Object> list = aVar.f20990b;
            if (list != null) {
                this.f20990b.addAll(list);
            }
            if (this.f20990b.size() <= 4) {
                return this;
            }
            List<Object> list2 = this.f20990b;
            list2.subList(4, list2.size()).clear();
            throw e(true);
        }

        Object c() {
            Object obj = this.f20989a;
            if (obj == null) {
                throw new NoSuchElementException();
            }
            if (this.f20990b == null) {
                return obj;
            }
            throw e(false);
        }

        Optional<Object> d() {
            if (this.f20990b == null) {
                return Optional.ofNullable(this.f20989a);
            }
            throw e(false);
        }

        IllegalArgumentException e(boolean z7) {
            StringBuilder sb = new StringBuilder();
            sb.append("expected one element but was: <");
            sb.append(this.f20989a);
            for (Object obj : this.f20990b) {
                sb.append(", ");
                sb.append(obj);
            }
            if (z7) {
                sb.append(", ...");
            }
            sb.append(kotlin.text.h0.f35380f);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private qc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(a aVar, Object obj) {
        if (obj == null) {
            obj = f20986b;
        }
        aVar.a(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object d(a aVar) {
        Object objC = aVar.c();
        if (objC == f20986b) {
            return null;
        }
        return objC;
    }

    public static <T> Collector<T, ?, T> e() {
        return (Collector<T, ?, T>) f20987c;
    }

    public static <T> Collector<T, ?, Optional<T>> f() {
        return (Collector<T, ?, Optional<T>>) f20985a;
    }
}
