package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class q0 extends p0 {
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <T, K, R> Map<K, R> c(@a7.d n0<T, ? extends K> n0Var, @a7.d i5.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(n0Var, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = n0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = n0Var.a(next);
            a1.c cVar = (Object) linkedHashMap.get(objA);
            linkedHashMap.put(objA, operation.K(objA, cVar, next, Boolean.valueOf(cVar == null && !linkedHashMap.containsKey(objA))));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M d(@a7.d n0<T, ? extends K> n0Var, @a7.d M destination, @a7.d i5.r<? super K, ? super R, ? super T, ? super Boolean, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(n0Var, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(operation, "operation");
        Iterator<T> itB = n0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = n0Var.a(next);
            a1.c cVar = (Object) destination.get(objA);
            destination.put(objA, operation.K(objA, cVar, next, Boolean.valueOf(cVar == null && !destination.containsKey(objA))));
        }
        return destination;
    }

    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <T, K, M extends Map<? super K, Integer>> M e(@a7.d n0<T, ? extends K> n0Var, @a7.d M destination) {
        kotlin.jvm.internal.l0.p(n0Var, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        Iterator<T> itB = n0Var.b();
        while (itB.hasNext()) {
            K kA = n0Var.a(itB.next());
            Object obj = destination.get(kA);
            if (obj == null && !destination.containsKey(kA)) {
                obj = 0;
            }
            destination.put(kA, Integer.valueOf(((Number) obj).intValue() + 1));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <T, K, R> Map<K, R> f(@a7.d n0<T, ? extends K> n0Var, @a7.d i5.p<? super K, ? super T, ? extends R> initialValueSelector, @a7.d i5.q<? super K, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(n0Var, "<this>");
        kotlin.jvm.internal.l0.p(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.l0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = n0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = n0Var.a(next);
            R rA0 = (Object) linkedHashMap.get(objA);
            if (rA0 == null && !linkedHashMap.containsKey(objA)) {
                rA0 = initialValueSelector.a0(objA, next);
            }
            linkedHashMap.put(objA, operation.v(objA, rA0, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <T, K, R> Map<K, R> g(@a7.d n0<T, ? extends K> n0Var, R r7, @a7.d i5.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(n0Var, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> itB = n0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            K kA = n0Var.a(next);
            a1.d dVar = (Object) linkedHashMap.get(kA);
            if (dVar == null && !linkedHashMap.containsKey(kA)) {
                dVar = (Object) r7;
            }
            linkedHashMap.put(kA, operation.a0(dVar, next));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M h(@a7.d n0<T, ? extends K> n0Var, @a7.d M destination, @a7.d i5.p<? super K, ? super T, ? extends R> initialValueSelector, @a7.d i5.q<? super K, ? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(n0Var, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(initialValueSelector, "initialValueSelector");
        kotlin.jvm.internal.l0.p(operation, "operation");
        Iterator<T> itB = n0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            Object objA = n0Var.a(next);
            R rA0 = (Object) destination.get(objA);
            if (rA0 == null && !destination.containsKey(objA)) {
                rA0 = initialValueSelector.a0(objA, next);
            }
            destination.put(objA, operation.v(objA, rA0, next));
        }
        return destination;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <T, K, R, M extends Map<? super K, R>> M i(@a7.d n0<T, ? extends K> n0Var, @a7.d M destination, R r7, @a7.d i5.p<? super R, ? super T, ? extends R> operation) {
        kotlin.jvm.internal.l0.p(n0Var, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(operation, "operation");
        Iterator<T> itB = n0Var.b();
        while (itB.hasNext()) {
            ?? next = itB.next();
            K kA = n0Var.a(next);
            a1.d dVar = (Object) destination.get(kA);
            if (dVar == null && !destination.containsKey(kA)) {
                dVar = (Object) r7;
            }
            destination.put(kA, operation.a0(dVar, next));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <S, T extends S, K> Map<K, S> j(@a7.d n0<T, ? extends K> n0Var, @a7.d i5.q<? super K, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(n0Var, "<this>");
        kotlin.jvm.internal.l0.p(operation, "operation");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator itB = n0Var.b();
        while (itB.hasNext()) {
            S sV = (Object) itB.next();
            Object objA = n0Var.a(sV);
            a1.c cVar = (Object) linkedHashMap.get(objA);
            if (!(cVar == null && !linkedHashMap.containsKey(objA))) {
                sV = operation.v(objA, cVar, sV);
            }
            linkedHashMap.put(objA, sV);
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    @kotlin.g1(version = "1.1")
    public static final <S, T extends S, K, M extends Map<? super K, S>> M k(@a7.d n0<T, ? extends K> n0Var, @a7.d M destination, @a7.d i5.q<? super K, ? super S, ? super T, ? extends S> operation) {
        kotlin.jvm.internal.l0.p(n0Var, "<this>");
        kotlin.jvm.internal.l0.p(destination, "destination");
        kotlin.jvm.internal.l0.p(operation, "operation");
        Iterator itB = n0Var.b();
        while (itB.hasNext()) {
            S sV = (Object) itB.next();
            Object objA = n0Var.a(sV);
            a1.c cVar = (Object) destination.get(objA);
            if (!(cVar == null && !destination.containsKey(objA))) {
                sV = operation.v(objA, cVar, sV);
            }
            destination.put(objA, sV);
        }
        return destination;
    }
}
