package com.google.common.util.concurrent;

import com.google.common.collect.af;
import com.google.common.collect.ib;
import com.google.common.collect.nb;
import com.google.common.collect.u8;
import com.google.common.collect.wb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@u1.a
@s1.c
public class m0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, h>> f22832b = new nb().l().i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f22833c = Logger.getLogger(m0.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ThreadLocal<ArrayList<h>> f22834d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final j f22835a;

    static class a extends ThreadLocal<ArrayList<h>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ArrayList<h> initialValue() {
            return ib.u(3);
        }
    }

    private interface b {
        h a();

        boolean b();
    }

    final class c extends ReentrantLock implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final h f22836a;

        /* synthetic */ c(m0 m0Var, h hVar, boolean z7, a aVar) {
            this(hVar, z7);
        }

        @Override // com.google.common.util.concurrent.m0.b
        public h a() {
            return this.f22836a;
        }

        @Override // com.google.common.util.concurrent.m0.b
        public boolean b() {
            return isHeldByCurrentThread();
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lock() {
            m0.this.a(this);
            try {
                super.lock();
            } finally {
                m0.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            m0.this.a(this);
            try {
                super.lockInterruptibly();
            } finally {
                m0.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            m0.this.a(this);
            try {
                return super.tryLock();
            } finally {
                m0.h(this);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                m0.h(this);
            }
        }

        private c(h hVar, boolean z7) {
            super(z7);
            this.f22836a = (h) com.google.common.base.e0.E(hVar);
        }

        @Override // java.util.concurrent.locks.ReentrantLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j7, TimeUnit timeUnit) throws InterruptedException {
            m0.this.a(this);
            try {
                return super.tryLock(j7, timeUnit);
            } finally {
                m0.h(this);
            }
        }
    }

    final class e extends ReentrantReadWriteLock implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f22840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f f22841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final h f22842c;

        /* synthetic */ e(m0 m0Var, h hVar, boolean z7, a aVar) {
            this(hVar, z7);
        }

        @Override // com.google.common.util.concurrent.m0.b
        public h a() {
            return this.f22842c;
        }

        @Override // com.google.common.util.concurrent.m0.b
        public boolean b() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        private e(h hVar, boolean z7) {
            super(z7);
            this.f22840a = m0.this.new d(this);
            this.f22841b = m0.this.new f(this);
            this.f22842c = (h) com.google.common.base.e0.E(hVar);
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.f22840a;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock, java.util.concurrent.locks.ReadWriteLock
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.f22841b;
        }
    }

    private static class g extends IllegalStateException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final StackTraceElement[] f22846a = new StackTraceElement[0];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final u8<String> f22847b = u8.F(m0.class.getName(), g.class.getName(), h.class.getName());

        g(h hVar, h hVar2) {
            super(hVar.d() + " -> " + hVar2.d());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i7 = 0; i7 < length; i7++) {
                if (l.class.getName().equals(stackTrace[i7].getClassName())) {
                    setStackTrace(f22846a);
                    return;
                } else {
                    if (!f22847b.contains(stackTrace[i7].getClassName())) {
                        setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i7, length));
                        return;
                    }
                }
            }
        }
    }

    private static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<h, g> f22848a = new nb().l().i();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<h, k> f22849b = new nb().l().i();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f22850c;

        h(String str) {
            this.f22850c = (String) com.google.common.base.e0.E(str);
        }

        private g c(h hVar, Set<h> set) {
            if (!set.add(this)) {
                return null;
            }
            g gVar = this.f22848a.get(hVar);
            if (gVar != null) {
                return gVar;
            }
            for (Map.Entry<h, g> entry : this.f22848a.entrySet()) {
                h key = entry.getKey();
                g gVarC = key.c(hVar, set);
                if (gVarC != null) {
                    g gVar2 = new g(key, this);
                    gVar2.setStackTrace(entry.getValue().getStackTrace());
                    gVar2.initCause(gVarC);
                    return gVar2;
                }
            }
            return null;
        }

        void a(j jVar, h hVar) {
            com.google.common.base.e0.x0(this != hVar, "Attempted to acquire multiple locks with the same rank %s", hVar.d());
            if (this.f22848a.containsKey(hVar)) {
                return;
            }
            k kVar = this.f22849b.get(hVar);
            a aVar = null;
            if (kVar != null) {
                jVar.a(new k(hVar, this, kVar.a(), aVar));
                return;
            }
            g gVarC = hVar.c(this, af.z());
            if (gVarC == null) {
                this.f22848a.put(hVar, new g(hVar, this));
                return;
            }
            k kVar2 = new k(hVar, this, gVarC, aVar);
            this.f22849b.put(hVar, kVar2);
            jVar.a(kVar2);
        }

        void b(j jVar, List<h> list) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                a(jVar, list.get(i7));
            }
        }

        String d() {
            return this.f22850c;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @s1.a
    public static abstract class i implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f22851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final i f22852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f22853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ i[] f22854d;

        static enum a extends i {
            a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.util.concurrent.m0.j
            public void a(k kVar) {
                throw kVar;
            }
        }

        static enum b extends i {
            b(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.util.concurrent.m0.j
            public void a(k kVar) {
                m0.f22833c.log(Level.SEVERE, "Detected potential deadlock", (Throwable) kVar);
            }
        }

        static enum c extends i {
            c(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.util.concurrent.m0.j
            public void a(k kVar) {
            }
        }

        static {
            a aVar = new a("THROW", 0);
            f22851a = aVar;
            b bVar = new b("WARN", 1);
            f22852b = bVar;
            c cVar = new c("DISABLED", 2);
            f22853c = cVar;
            f22854d = new i[]{aVar, bVar, cVar};
        }

        private i(String str, int i7) {
            super(str, i7);
        }

        public static i valueOf(String str) {
            return (i) Enum.valueOf(i.class, str);
        }

        public static i[] values() {
            return (i[]) f22854d.clone();
        }

        /* synthetic */ i(String str, int i7, a aVar) {
            this(str, i7);
        }
    }

    @s1.a
    public interface j {
        void a(k kVar);
    }

    @s1.a
    public static final class k extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final g f22855c;

        /* synthetic */ k(h hVar, h hVar2, g gVar, a aVar) {
            this(hVar, hVar2, gVar);
        }

        public g a() {
            return this.f22855c;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder sb = new StringBuilder(super.getMessage());
            for (Throwable cause = this.f22855c; cause != null; cause = cause.getCause()) {
                sb.append(", ");
                sb.append(cause.getMessage());
            }
            return sb.toString();
        }

        private k(h hVar, h hVar2, g gVar) {
            super(hVar, hVar2);
            this.f22855c = gVar;
            initCause(gVar);
        }
    }

    @s1.a
    public static final class l<E extends Enum<E>> extends m0 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Map<E, h> f22856e;

        @s1.d
        l(j jVar, Map<E, h> map) {
            super(jVar, null);
            this.f22856e = map;
        }

        public ReentrantLock o(E e8) {
            return p(e8, false);
        }

        public ReentrantLock p(E e8, boolean z7) {
            return this.f22835a == i.f22853c ? new ReentrantLock(z7) : new c(this, this.f22856e.get(e8), z7, null);
        }

        public ReentrantReadWriteLock q(E e8) {
            return r(e8, false);
        }

        public ReentrantReadWriteLock r(E e8, boolean z7) {
            return this.f22835a == i.f22853c ? new ReentrantReadWriteLock(z7) : new e(this, this.f22856e.get(e8), z7, null);
        }
    }

    /* synthetic */ m0(j jVar, a aVar) {
        this(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (bVar.b()) {
            return;
        }
        ArrayList<h> arrayList = f22834d.get();
        h hVarA = bVar.a();
        hVarA.b(this.f22835a, arrayList);
        arrayList.add(hVarA);
    }

    @s1.d
    static <E extends Enum<E>> Map<E, h> e(Class<E> cls) {
        EnumMap enumMapG0 = wb.g0(cls);
        E[] enumConstants = cls.getEnumConstants();
        int length = enumConstants.length;
        ArrayList arrayListU = ib.u(length);
        int i7 = 0;
        for (E e8 : enumConstants) {
            h hVar = new h(f(e8));
            arrayListU.add(hVar);
            enumMapG0.put(e8, hVar);
        }
        for (int i8 = 1; i8 < length; i8++) {
            ((h) arrayListU.get(i8)).b(i.f22851a, arrayListU.subList(0, i8));
        }
        while (i7 < length - 1) {
            i7++;
            ((h) arrayListU.get(i7)).b(i.f22853c, arrayListU.subList(i7, length));
        }
        return Collections.unmodifiableMap(enumMapG0);
    }

    private static String f(Enum<?> r7) {
        return r7.getDeclaringClass().getSimpleName() + com.alibaba.android.arouter.utils.b.f12515h + r7.name();
    }

    private static Map<? extends Enum, h> g(Class<? extends Enum> cls) {
        ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, h>> concurrentMap = f22832b;
        Map<? extends Enum, h> map = concurrentMap.get(cls);
        if (map != null) {
            return map;
        }
        Map<? extends Enum, h> mapE = e(cls);
        return (Map) com.google.common.base.x.a(concurrentMap.putIfAbsent(cls, mapE), mapE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(b bVar) {
        if (bVar.b()) {
            return;
        }
        ArrayList<h> arrayList = f22834d.get();
        h hVarA = bVar.a();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == hVarA) {
                arrayList.remove(size);
                return;
            }
        }
    }

    public static m0 i(j jVar) {
        return new m0(jVar);
    }

    public static <E extends Enum<E>> l<E> j(Class<E> cls, j jVar) {
        com.google.common.base.e0.E(cls);
        com.google.common.base.e0.E(jVar);
        return new l<>(jVar, g(cls));
    }

    public ReentrantLock k(String str) {
        return l(str, false);
    }

    public ReentrantLock l(String str, boolean z7) {
        return this.f22835a == i.f22853c ? new ReentrantLock(z7) : new c(this, new h(str), z7, null);
    }

    public ReentrantReadWriteLock m(String str) {
        return n(str, false);
    }

    public ReentrantReadWriteLock n(String str, boolean z7) {
        return this.f22835a == i.f22853c ? new ReentrantReadWriteLock(z7) : new e(this, new h(str), z7, null);
    }

    private m0(j jVar) {
        this.f22835a = (j) com.google.common.base.e0.E(jVar);
    }

    private class d extends ReentrantReadWriteLock.ReadLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @y1.i
        final e f22838a;

        d(e eVar) {
            super(eVar);
            this.f22838a = eVar;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lock() {
            m0.this.a(this.f22838a);
            try {
                super.lock();
            } finally {
                m0.h(this.f22838a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            m0.this.a(this.f22838a);
            try {
                super.lockInterruptibly();
            } finally {
                m0.h(this.f22838a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            m0.this.a(this.f22838a);
            try {
                return super.tryLock();
            } finally {
                m0.h(this.f22838a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                m0.h(this.f22838a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j7, TimeUnit timeUnit) throws InterruptedException {
            m0.this.a(this.f22838a);
            try {
                return super.tryLock(j7, timeUnit);
            } finally {
                m0.h(this.f22838a);
            }
        }
    }

    private class f extends ReentrantReadWriteLock.WriteLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @y1.i
        final e f22844a;

        f(e eVar) {
            super(eVar);
            this.f22844a = eVar;
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lock() {
            m0.this.a(this.f22844a);
            try {
                super.lock();
            } finally {
                m0.h(this.f22844a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
            m0.this.a(this.f22844a);
            try {
                super.lockInterruptibly();
            } finally {
                m0.h(this.f22844a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock() {
            m0.this.a(this.f22844a);
            try {
                return super.tryLock();
            } finally {
                m0.h(this.f22844a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public void unlock() {
            try {
                super.unlock();
            } finally {
                m0.h(this.f22844a);
            }
        }

        @Override // java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock, java.util.concurrent.locks.Lock
        public boolean tryLock(long j7, TimeUnit timeUnit) throws InterruptedException {
            m0.this.a(this.f22844a);
            try {
                return super.tryLock(j7, timeUnit);
            } finally {
                m0.h(this.f22844a);
            }
        }
    }
}
