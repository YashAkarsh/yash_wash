package com.google.common.util.concurrent;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public final class g0<K> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<K, Long> f22678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient Map<K, Long> f22679b;

    private g0(ConcurrentHashMap<K, Long> concurrentHashMap) {
        this.f22678a = (ConcurrentHashMap) com.google.common.base.e0.E(concurrentHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ long A(LongBinaryOperator longBinaryOperator, long j7, long j8) {
        return longBinaryOperator.applyAsLong(j8, j7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long B(AtomicLong atomicLong, LongUnaryOperator longUnaryOperator, Object obj, Long l7) {
        long jLongValue = l7 == null ? 0L : l7.longValue();
        atomicLong.set(jLongValue);
        return Long.valueOf(longUnaryOperator.applyAsLong(jLongValue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ long C(long j7, long j8) {
        return j7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long D(AtomicBoolean atomicBoolean, long j7, Object obj, Long l7) {
        if (l7 != null && l7.longValue() != 0) {
            return l7;
        }
        atomicBoolean.set(true);
        return Long.valueOf(j7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean E(Long l7) {
        return l7.longValue() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long F(LongUnaryOperator longUnaryOperator, Object obj, Long l7) {
        return Long.valueOf(longUnaryOperator.applyAsLong(l7 == null ? 0L : l7.longValue()));
    }

    public static <K> g0<K> m() {
        return new g0<>(new ConcurrentHashMap());
    }

    public static <K> g0<K> n(Map<? extends K, ? extends Long> map) {
        g0<K> g0VarM = m();
        g0VarM.I(map);
        return g0VarM;
    }

    private Map<K, Long> o() {
        return Collections.unmodifiableMap(this.f22678a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ long z(LongBinaryOperator longBinaryOperator, long j7, long j8) {
        return longBinaryOperator.applyAsLong(j8, j7);
    }

    @u1.a
    public long H(K k7, final long j7) {
        return w(k7, new LongUnaryOperator() { // from class: com.google.common.util.concurrent.c0
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j8) {
                return g0.C(j7, j8);
            }
        });
    }

    public void I(Map<? extends K, ? extends Long> map) {
        map.forEach(new BiConsumer() { // from class: com.google.common.util.concurrent.a0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f22531a.H(obj, ((Long) obj2).longValue());
            }
        });
    }

    long J(K k7, final long j7) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Long l7 = (Long) this.f22678a.compute(k7, new BiFunction() { // from class: com.google.common.util.concurrent.e0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return g0.D(atomicBoolean, j7, obj, (Long) obj2);
            }
        });
        if (atomicBoolean.get()) {
            return 0L;
        }
        return l7.longValue();
    }

    @u1.a
    public long K(K k7) {
        Long lRemove = this.f22678a.remove(k7);
        if (lRemove == null) {
            return 0L;
        }
        return lRemove.longValue();
    }

    boolean L(K k7, long j7) {
        return this.f22678a.remove(k7, Long.valueOf(j7));
    }

    public void M() {
        this.f22678a.values().removeIf(new Predicate() { // from class: com.google.common.util.concurrent.z
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return g0.E((Long) obj);
            }
        });
    }

    @s1.a
    @u1.a
    public boolean N(K k7) {
        return L(k7, 0L);
    }

    boolean O(K k7, long j7, long j8) {
        if (j7 == 0) {
            return J(k7, j8) == 0;
        }
        return this.f22678a.replace(k7, Long.valueOf(j7), Long.valueOf(j8));
    }

    public int P() {
        return this.f22678a.size();
    }

    public long R() {
        return this.f22678a.values().stream().mapToLong(new ToLongFunction() { // from class: com.google.common.util.concurrent.x
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ((Long) obj).longValue();
            }
        }).sum();
    }

    @u1.a
    public long S(K k7, final LongUnaryOperator longUnaryOperator) {
        com.google.common.base.e0.E(longUnaryOperator);
        return ((Long) this.f22678a.compute(k7, new BiFunction() { // from class: com.google.common.util.concurrent.d0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return g0.F(longUnaryOperator, obj, (Long) obj2);
            }
        })).longValue();
    }

    @u1.a
    public long h(K k7, final long j7, final LongBinaryOperator longBinaryOperator) {
        com.google.common.base.e0.E(longBinaryOperator);
        return S(k7, new LongUnaryOperator() { // from class: com.google.common.util.concurrent.y
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j8) {
                return g0.z(longBinaryOperator, j7, j8);
            }
        });
    }

    @u1.a
    public long i(K k7, long j7) {
        return h(k7, j7, new w());
    }

    public Map<K, Long> j() {
        Map<K, Long> map = this.f22679b;
        if (map != null) {
            return map;
        }
        Map<K, Long> mapO = o();
        this.f22679b = mapO;
        return mapO;
    }

    public void k() {
        this.f22678a.clear();
    }

    public boolean l(Object obj) {
        return this.f22678a.containsKey(obj);
    }

    @u1.a
    public long p(K k7) {
        return i(k7, -1L);
    }

    public long q(K k7) {
        return ((Long) this.f22678a.getOrDefault(k7, 0L)).longValue();
    }

    @u1.a
    public long r(K k7, final long j7, final LongBinaryOperator longBinaryOperator) {
        com.google.common.base.e0.E(longBinaryOperator);
        return w(k7, new LongUnaryOperator() { // from class: com.google.common.util.concurrent.b0
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j8) {
                return g0.A(longBinaryOperator, j7, j8);
            }
        });
    }

    @u1.a
    public long t(K k7, long j7) {
        return r(k7, j7, new w());
    }

    public String toString() {
        return this.f22678a.toString();
    }

    @u1.a
    public long u(K k7) {
        return t(k7, -1L);
    }

    @u1.a
    public long v(K k7) {
        return t(k7, 1L);
    }

    @u1.a
    public long w(K k7, final LongUnaryOperator longUnaryOperator) {
        com.google.common.base.e0.E(longUnaryOperator);
        final AtomicLong atomicLong = new AtomicLong();
        this.f22678a.compute(k7, new BiFunction() { // from class: com.google.common.util.concurrent.f0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return g0.B(atomicLong, longUnaryOperator, obj, (Long) obj2);
            }
        });
        return atomicLong.get();
    }

    @u1.a
    public long x(K k7) {
        return i(k7, 1L);
    }

    public boolean y() {
        return this.f22678a.isEmpty();
    }
}
