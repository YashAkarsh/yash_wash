package kotlinx.coroutines.debug.internal;

import i5.p;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.a0;
import kotlin.collections.b1;
import kotlin.collections.g0;
import kotlin.collections.z;
import kotlin.d1;
import kotlin.e1;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t1;
import kotlin.l2;
import kotlin.p1;
import kotlin.ranges.q;
import kotlin.sequences.u;
import kotlin.text.b0;
import kotlin.text.h0;
import kotlin.u0;
import kotlinx.coroutines.internal.q0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.t0;
import kotlinx.coroutines.w2;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final g f35950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final String f35951b = "Coroutine creation stacktrace";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private static final SimpleDateFormat f35952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.e
    private static Thread f35953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private static final kotlinx.coroutines.debug.internal.b<a<?>, Boolean> f35954e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @a7.d
    private static final /* synthetic */ kotlinx.coroutines.debug.internal.h f35955f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f35956g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @a7.d
    private static final ReentrantReadWriteLock f35957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f35958i;
    private static volatile int installations;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f35959j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @a7.e
    private static final i5.l<Boolean, l2> f35960k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @a7.d
    private static final kotlinx.coroutines.debug.internal.b<kotlin.coroutines.jvm.internal.e, kotlinx.coroutines.debug.internal.e> f35961l;

    private static final class a<T> implements kotlin.coroutines.d<T>, kotlin.coroutines.jvm.internal.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        @h5.e
        public final kotlin.coroutines.d<T> f35962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        @h5.e
        public final kotlinx.coroutines.debug.internal.e f35963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @a7.e
        private final kotlin.coroutines.jvm.internal.e f35964c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@a7.d kotlin.coroutines.d<? super T> dVar, @a7.d kotlinx.coroutines.debug.internal.e eVar, @a7.e kotlin.coroutines.jvm.internal.e eVar2) {
            this.f35962a = dVar;
            this.f35963b = eVar;
            this.f35964c = eVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.e
        @a7.e
        public StackTraceElement I() {
            kotlin.coroutines.jvm.internal.e eVar = this.f35964c;
            if (eVar == null) {
                return null;
            }
            return eVar.I();
        }

        @Override // kotlin.coroutines.d
        @a7.d
        public kotlin.coroutines.g d() {
            return this.f35962a.d();
        }

        @Override // kotlin.coroutines.jvm.internal.e
        @a7.e
        public kotlin.coroutines.jvm.internal.e i() {
            kotlin.coroutines.jvm.internal.e eVar = this.f35964c;
            if (eVar == null) {
                return null;
            }
            return eVar.i();
        }

        @a7.d
        public String toString() {
            return this.f35962a.toString();
        }

        @Override // kotlin.coroutines.d
        public void w(@a7.d Object obj) {
            g.f35950a.E(this);
            this.f35962a.w(obj);
        }
    }

    static final class b extends n0 implements i5.l<a<?>, kotlinx.coroutines.debug.internal.d> {
        public b() {
            super(1);
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlinx.coroutines.debug.internal.d z(@a7.d a<?> aVar) {
            kotlin.coroutines.g gVarC;
            if (g.f35950a.y(aVar) || (gVarC = aVar.f35963b.c()) == null) {
                return null;
            }
            return new kotlinx.coroutines.debug.internal.d(aVar.f35963b, gVarC);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    static final class c<R> extends n0 implements i5.l<a<?>, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p<a<?>, kotlin.coroutines.g, R> f35965a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(p<? super a<?>, ? super kotlin.coroutines.g, ? extends R> pVar) {
            super(1);
            this.f35965a = pVar;
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final R z(@a7.d a<?> aVar) {
            kotlin.coroutines.g gVarC;
            if (g.f35950a.y(aVar) || (gVarC = aVar.f35963b.c()) == null) {
                return null;
            }
            return this.f35965a.a0(aVar, gVarC);
        }
    }

    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            return kotlin.comparisons.b.g(Long.valueOf(((a) t7).f35963b.f35932b), Long.valueOf(((a) t8).f35963b.f35932b));
        }
    }

    static final class e extends n0 implements i5.l<a<?>, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f35966a = new e();

        e() {
            super(1);
        }

        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean z(@a7.d a<?> aVar) {
            return Boolean.valueOf(!g.f35950a.y(aVar));
        }
    }

    public static final class f<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            return kotlin.comparisons.b.g(Long.valueOf(((a) t7).f35963b.f35932b), Long.valueOf(((a) t8).f35963b.f35932b));
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.debug.internal.g$g, reason: collision with other inner class name */
    static final class C0453g extends n0 implements i5.l<a<?>, j> {
        public C0453g() {
            super(1);
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final j z(@a7.d a<?> aVar) {
            kotlin.coroutines.g gVarC;
            if (g.f35950a.y(aVar) || (gVarC = aVar.f35963b.c()) == null) {
                return null;
            }
            return new j(aVar.f35963b, gVarC);
        }
    }

    static final class h extends n0 implements i5.a<l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f35967a = new h();

        h() {
            super(0);
        }

        public final void b() {
            g.f35961l.m();
        }

        @Override // i5.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            b();
            return l2.f34958a;
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [kotlinx.coroutines.debug.internal.h] */
    static {
        g gVar = new g();
        f35950a = gVar;
        f35952c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        f35954e = new kotlinx.coroutines.debug.internal.b<>(false, 1, null);
        final long j7 = 0;
        f35955f = new Object(j7) { // from class: kotlinx.coroutines.debug.internal.h
            volatile long sequenceNumber;

            {
                this.sequenceNumber = j7;
            }
        };
        f35957h = new ReentrantReadWriteLock();
        f35958i = true;
        f35959j = true;
        f35960k = gVar.t();
        f35961l = new kotlinx.coroutines.debug.internal.b<>(true);
        f35956g = AtomicLongFieldUpdater.newUpdater(kotlinx.coroutines.debug.internal.h.class, "sequenceNumber");
    }

    private g() {
    }

    private final boolean A(StackTraceElement stackTraceElement) {
        return b0.u2(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, null);
    }

    private final a<?> B(kotlin.coroutines.d<?> dVar) {
        kotlin.coroutines.jvm.internal.e eVar = dVar instanceof kotlin.coroutines.jvm.internal.e ? (kotlin.coroutines.jvm.internal.e) dVar : null;
        if (eVar == null) {
            return null;
        }
        return C(eVar);
    }

    private final a<?> C(kotlin.coroutines.jvm.internal.e eVar) {
        while (!(eVar instanceof a)) {
            eVar = eVar.i();
            if (eVar == null) {
                return null;
            }
        }
        return (a) eVar;
    }

    private final void D(PrintStream printStream, List<StackTraceElement> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            printStream.print(l0.C("\n\tat ", (StackTraceElement) it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(a<?> aVar) {
        f35954e.remove(aVar);
        kotlin.coroutines.jvm.internal.e eVarF = aVar.f35963b.f();
        kotlin.coroutines.jvm.internal.e eVarI = eVarF == null ? null : I(eVarF);
        if (eVarI == null) {
            return;
        }
        f35961l.remove(eVarI);
    }

    private final kotlin.coroutines.jvm.internal.e I(kotlin.coroutines.jvm.internal.e eVar) {
        do {
            eVar = eVar.i();
            if (eVar == null) {
                return null;
            }
        } while (eVar.I() == null);
        return eVar;
    }

    private final <T extends Throwable> List<StackTraceElement> J(T t7) {
        StackTraceElement[] stackTrace = t7.getStackTrace();
        int length = stackTrace.length;
        int i7 = -1;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i8 = length2 - 1;
                if (l0.g(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i7 = length2;
                    break;
                }
                if (i8 < 0) {
                    break;
                }
                length2 = i8;
            }
        }
        if (!f35958i) {
            int i9 = length - i7;
            ArrayList arrayList = new ArrayList(i9);
            int i10 = 0;
            while (i10 < i9) {
                int i11 = i10 + 1;
                arrayList.add(i10 == 0 ? q0.d(f35951b) : stackTrace[i10 + i7]);
                i10 = i11;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i7) + 1);
        arrayList2.add(q0.d(f35951b));
        while (true) {
            i7++;
            while (i7 < length) {
                if (A(stackTrace[i7])) {
                    arrayList2.add(stackTrace[i7]);
                    int i12 = i7 + 1;
                    while (i12 < length && A(stackTrace[i12])) {
                        i12++;
                    }
                    int i13 = i12 - 1;
                    int i14 = i13;
                    while (i14 > i7 && stackTrace[i14].getFileName() == null) {
                        i14--;
                    }
                    if (i14 > i7 && i14 < i13) {
                        arrayList2.add(stackTrace[i14]);
                    }
                    arrayList2.add(stackTrace[i13]);
                    i7 = i12;
                } else {
                    arrayList2.add(stackTrace[i7]);
                }
            }
            return arrayList2;
        }
    }

    private final void M() {
        f35953d = kotlin.concurrent.b.c(false, true, null, "Coroutines Debugger Cleaner", 0, h.f35967a, 21, null);
    }

    private final void N() throws InterruptedException {
        Thread thread = f35953d;
        if (thread == null) {
            return;
        }
        f35953d = null;
        thread.interrupt();
        thread.join();
    }

    private final m O(List<StackTraceElement> list) {
        m mVar = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                mVar = new m(mVar, listIterator.previous());
            }
        }
        return mVar;
    }

    private final String P(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(h0.f35376b);
        sb.append(obj);
        sb.append(h0.f35376b);
        return sb.toString();
    }

    private final void R(kotlin.coroutines.jvm.internal.e eVar, String str) {
        ReentrantReadWriteLock.ReadLock lock = f35957h.readLock();
        lock.lock();
        try {
            g gVar = f35950a;
            if (gVar.z()) {
                kotlinx.coroutines.debug.internal.b<kotlin.coroutines.jvm.internal.e, kotlinx.coroutines.debug.internal.e> bVar = f35961l;
                kotlinx.coroutines.debug.internal.e eVarRemove = bVar.remove(eVar);
                if (eVarRemove == null) {
                    a<?> aVarC = gVar.C(eVar);
                    kotlin.coroutines.jvm.internal.e eVarI = null;
                    eVarRemove = aVarC == null ? null : aVarC.f35963b;
                    if (eVarRemove == null) {
                        return;
                    }
                    kotlin.coroutines.jvm.internal.e eVarF = eVarRemove.f();
                    if (eVarF != null) {
                        eVarI = gVar.I(eVarF);
                    }
                    if (eVarI != null) {
                        bVar.remove(eVarI);
                    }
                }
                eVarRemove.j(str, (kotlin.coroutines.d) eVar);
                kotlin.coroutines.jvm.internal.e eVarI2 = gVar.I(eVar);
                if (eVarI2 == null) {
                    return;
                }
                bVar.put(eVarI2, eVarRemove);
                l2 l2Var = l2.f34958a;
            }
        } finally {
            lock.unlock();
        }
    }

    private final void S(kotlin.coroutines.d<?> dVar, String str) {
        if (z()) {
            if (l0.g(str, kotlinx.coroutines.debug.internal.f.f35948b) && a0.f34441g.f(1, 3, 30)) {
                kotlin.coroutines.jvm.internal.e eVar = dVar instanceof kotlin.coroutines.jvm.internal.e ? (kotlin.coroutines.jvm.internal.e) dVar : null;
                if (eVar == null) {
                    return;
                }
                R(eVar, str);
                return;
            }
            a<?> aVarB = B(dVar);
            if (aVarB == null) {
                return;
            }
            T(aVarB, dVar, str);
        }
    }

    private final void T(a<?> aVar, kotlin.coroutines.d<?> dVar, String str) {
        ReentrantReadWriteLock.ReadLock lock = f35957h.readLock();
        lock.lock();
        try {
            if (f35950a.z()) {
                aVar.f35963b.j(str, dVar);
                l2 l2Var = l2.f34958a;
            }
        } finally {
            lock.unlock();
        }
    }

    private final void d(o2 o2Var, Map<o2, kotlinx.coroutines.debug.internal.e> map, StringBuilder sb, String str) {
        kotlinx.coroutines.debug.internal.e eVar = map.get(o2Var);
        if (eVar != null) {
            StackTraceElement stackTraceElement = (StackTraceElement) g0.B2(eVar.h());
            sb.append(str + r(o2Var) + ", continuation is " + eVar.g() + " at line " + stackTraceElement + '\n');
            str = l0.C(str, "\t");
        } else if (!(o2Var instanceof kotlinx.coroutines.internal.n0)) {
            sb.append(str + r(o2Var) + '\n');
            str = l0.C(str, "\t");
        }
        Iterator<o2> it = o2Var.E().iterator();
        while (it.hasNext()) {
            d(it.next(), map, sb, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> kotlin.coroutines.d<T> e(kotlin.coroutines.d<? super T> dVar, m mVar) {
        if (!z()) {
            return dVar;
        }
        a<?> aVar = new a<>(dVar, new kotlinx.coroutines.debug.internal.e(dVar.d(), mVar, f35956g.incrementAndGet(f35955f)), mVar);
        kotlinx.coroutines.debug.internal.b<a<?>, Boolean> bVar = f35954e;
        bVar.put(aVar, Boolean.TRUE);
        if (!z()) {
            bVar.clear();
        }
        return aVar;
    }

    private final <R> List<R> i(p<? super a<?>, ? super kotlin.coroutines.g, ? extends R> pVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = f35957h;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i7 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        int i8 = 0;
        while (i8 < readHoldCount) {
            i8++;
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            g gVar = f35950a;
            if (!gVar.z()) {
                throw new IllegalStateException("Debug probes are not installed".toString());
            }
            List<R> listC3 = u.c3(u.p1(u.K2(g0.v1(gVar.q()), new d()), new c(pVar)));
            i0.d(1);
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
            i0.c(1);
            return listC3;
        } catch (Throwable th) {
            i0.d(1);
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
            i0.c(1);
            throw th;
        }
    }

    private final void j(PrintStream printStream) {
        ReentrantReadWriteLock reentrantReadWriteLock = f35957h;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i7 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        int i8 = 0;
        while (i8 < readHoldCount) {
            i8++;
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            g gVar = f35950a;
            if (!gVar.z()) {
                throw new IllegalStateException("Debug probes are not installed".toString());
            }
            printStream.print(l0.C("Coroutines dump ", f35952c.format(Long.valueOf(System.currentTimeMillis()))));
            for (a aVar : u.K2(u.p0(g0.v1(gVar.q()), e.f35966a), new f())) {
                kotlinx.coroutines.debug.internal.e eVar = aVar.f35963b;
                List<StackTraceElement> listH = eVar.h();
                g gVar2 = f35950a;
                List<StackTraceElement> listN = gVar2.n(eVar.g(), eVar.f35935e, listH);
                printStream.print("\n\nCoroutine " + aVar.f35962a + ", state: " + ((l0.g(eVar.g(), kotlinx.coroutines.debug.internal.f.f35948b) && listN == listH) ? l0.C(eVar.g(), " (Last suspension stacktrace, not an actual stacktrace)") : eVar.g()));
                if (listH.isEmpty()) {
                    printStream.print(l0.C("\n\tat ", q0.d(f35951b)));
                    gVar2.D(printStream, eVar.e());
                } else {
                    gVar2.D(printStream, listN);
                }
            }
            l2 l2Var = l2.f34958a;
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
            throw th;
        }
    }

    private final List<StackTraceElement> n(String str, Thread thread, List<StackTraceElement> list) {
        Object objB;
        if (!l0.g(str, kotlinx.coroutines.debug.internal.f.f35948b) || thread == null) {
            return list;
        }
        try {
            d1.a aVar = d1.f34719b;
            objB = d1.b(thread.getStackTrace());
        } catch (Throwable th) {
            d1.a aVar2 = d1.f34719b;
            objB = d1.b(e1.a(th));
        }
        if (d1.i(objB)) {
            objB = null;
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) objB;
        if (stackTraceElementArr == null) {
            return list;
        }
        int length = stackTraceElementArr.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                i7 = -1;
                break;
            }
            int i8 = i7 + 1;
            StackTraceElement stackTraceElement = stackTraceElementArr[i7];
            if (l0.g(stackTraceElement.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && l0.g(stackTraceElement.getMethodName(), "resumeWith") && l0.g(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                break;
            }
            i7 = i8;
        }
        u0<Integer, Integer> u0VarO = o(i7, stackTraceElementArr, list);
        int iIntValue = u0VarO.a().intValue();
        int iIntValue2 = u0VarO.b().intValue();
        if (iIntValue == -1) {
            return list;
        }
        ArrayList arrayList = new ArrayList((((list.size() + i7) - iIntValue) - 1) - iIntValue2);
        int i9 = i7 - iIntValue2;
        for (int i10 = 0; i10 < i9; i10++) {
            arrayList.add(stackTraceElementArr[i10]);
        }
        int size = list.size();
        for (int i11 = iIntValue + 1; i11 < size; i11++) {
            arrayList.add(list.get(i11));
        }
        return arrayList;
    }

    private final u0<Integer, Integer> o(int i7, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        int i8 = 0;
        while (i8 < 3) {
            int i9 = i8 + 1;
            int iP = f35950a.p((i7 - 1) - i8, stackTraceElementArr, list);
            if (iP != -1) {
                return p1.a(Integer.valueOf(iP), Integer.valueOf(i8));
            }
            i8 = i9;
        }
        return p1.a(-1, 0);
    }

    private final int p(int i7, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) kotlin.collections.p.qf(stackTraceElementArr, i7);
        if (stackTraceElement == null) {
            return -1;
        }
        int i8 = 0;
        for (StackTraceElement stackTraceElement2 : list) {
            if (l0.g(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && l0.g(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && l0.g(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    private final Set<a<?>> q() {
        return f35954e.keySet();
    }

    private final String r(o2 o2Var) {
        return o2Var instanceof w2 ? ((w2) o2Var).u1() : o2Var.toString();
    }

    private static /* synthetic */ void s(o2 o2Var) {
    }

    private final i5.l<Boolean, l2> t() {
        Object objB;
        try {
            d1.a aVar = d1.f34719b;
            Object objNewInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            if (objNewInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            }
            objB = d1.b((i5.l) t1.q(objNewInstance, 1));
            if (d1.i(objB)) {
                objB = null;
            }
            return (i5.l) objB;
        } catch (Throwable th) {
            d1.a aVar2 = d1.f34719b;
            objB = d1.b(e1.a(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean y(a<?> aVar) {
        kotlin.coroutines.g gVarC = aVar.f35963b.c();
        o2 o2Var = gVarC == null ? null : (o2) gVarC.get(o2.f37103s0);
        if (o2Var == null || !o2Var.r()) {
            return false;
        }
        f35954e.remove(aVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.d
    public final <T> kotlin.coroutines.d<T> F(@a7.d kotlin.coroutines.d<? super T> dVar) {
        if (z() && B(dVar) == null) {
            return e(dVar, f35959j ? O(J(new Exception())) : null);
        }
        return dVar;
    }

    public final void G(@a7.d kotlin.coroutines.d<?> dVar) {
        S(dVar, kotlinx.coroutines.debug.internal.f.f35948b);
    }

    public final void H(@a7.d kotlin.coroutines.d<?> dVar) {
        S(dVar, kotlinx.coroutines.debug.internal.f.f35949c);
    }

    public final void K(boolean z7) {
        f35959j = z7;
    }

    public final void L(boolean z7) {
        f35958i = z7;
    }

    public final void Q() {
        ReentrantReadWriteLock reentrantReadWriteLock = f35957h;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i7 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        int i8 = 0;
        while (i8 < readHoldCount) {
            i8++;
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            g gVar = f35950a;
            if (!gVar.z()) {
                throw new IllegalStateException("Agent was not installed".toString());
            }
            installations--;
            if (installations != 0) {
                while (i7 < readHoldCount) {
                    i7++;
                    lock.lock();
                }
                writeLock.unlock();
                return;
            }
            gVar.N();
            f35954e.clear();
            f35961l.clear();
            if (kotlinx.coroutines.debug.internal.a.f35896a.a()) {
                while (i7 < readHoldCount) {
                    i7++;
                    lock.lock();
                }
                writeLock.unlock();
                return;
            }
            i5.l<Boolean, l2> lVar = f35960k;
            if (lVar != null) {
                lVar.z(Boolean.FALSE);
            }
            l2 l2Var = l2.f34958a;
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final void f(@a7.d PrintStream printStream) {
        synchronized (printStream) {
            f35950a.j(printStream);
            l2 l2Var = l2.f34958a;
        }
    }

    @a7.d
    public final List<kotlinx.coroutines.debug.internal.d> g() {
        ReentrantReadWriteLock reentrantReadWriteLock = f35957h;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i7 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        int i8 = 0;
        while (i8 < readHoldCount) {
            i8++;
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            g gVar = f35950a;
            if (!gVar.z()) {
                throw new IllegalStateException("Debug probes are not installed".toString());
            }
            List<kotlinx.coroutines.debug.internal.d> listC3 = u.c3(u.p1(u.K2(g0.v1(gVar.q()), new d()), new b()));
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
            return listC3;
        } catch (Throwable th) {
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
            throw th;
        }
    }

    @a7.d
    public final Object[] h() {
        String strA1;
        List<kotlinx.coroutines.debug.internal.d> listG = g();
        int size = listG.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList(size);
        for (kotlinx.coroutines.debug.internal.d dVar : listG) {
            kotlin.coroutines.g gVarA = dVar.a();
            kotlinx.coroutines.u0 u0Var = (kotlinx.coroutines.u0) gVarA.get(kotlinx.coroutines.u0.f37321b);
            Long lValueOf = null;
            String strP = (u0Var == null || (strA1 = u0Var.a1()) == null) ? null : P(strA1);
            o0 o0Var = (o0) gVarA.get(o0.f37100a);
            String strP2 = o0Var == null ? null : P(o0Var);
            StringBuilder sb = new StringBuilder();
            sb.append("\n                {\n                    \"name\": ");
            sb.append((Object) strP);
            sb.append(",\n                    \"id\": ");
            t0 t0Var = (t0) gVarA.get(t0.f37299b);
            if (t0Var != null) {
                lValueOf = Long.valueOf(t0Var.a1());
            }
            sb.append(lValueOf);
            sb.append(",\n                    \"dispatcher\": ");
            sb.append((Object) strP2);
            sb.append(",\n                    \"sequenceNumber\": ");
            sb.append(dVar.f());
            sb.append(",\n                    \"state\": \"");
            sb.append(dVar.g());
            sb.append("\"\n                } \n                ");
            arrayList3.add(kotlin.text.u.p(sb.toString()));
            arrayList2.add(dVar.d());
            arrayList.add(dVar.e());
        }
        Object[] objArr = new Object[4];
        objArr[0] = '[' + g0.h3(arrayList3, null, null, null, 0, null, null, 63, null) + ']';
        Object[] array = arrayList.toArray(new Thread[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        objArr[1] = array;
        Object[] array2 = arrayList2.toArray(new kotlin.coroutines.jvm.internal.e[0]);
        if (array2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        objArr[2] = array2;
        Object[] array3 = listG.toArray(new kotlinx.coroutines.debug.internal.d[0]);
        if (array3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        objArr[3] = array3;
        return objArr;
    }

    @a7.d
    public final List<j> k() {
        ReentrantReadWriteLock reentrantReadWriteLock = f35957h;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i7 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        int i8 = 0;
        while (i8 < readHoldCount) {
            i8++;
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            g gVar = f35950a;
            if (!gVar.z()) {
                throw new IllegalStateException("Debug probes are not installed".toString());
            }
            List<j> listC3 = u.c3(u.p1(u.K2(g0.v1(gVar.q()), new d()), new C0453g()));
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
            return listC3;
        } catch (Throwable th) {
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
            throw th;
        }
    }

    @a7.d
    public final List<StackTraceElement> l(@a7.d kotlinx.coroutines.debug.internal.d dVar, @a7.d List<StackTraceElement> list) {
        return n(dVar.g(), dVar.e(), list);
    }

    @a7.d
    public final String m(@a7.d kotlinx.coroutines.debug.internal.d dVar) {
        List<StackTraceElement> listL = l(dVar, dVar.h());
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : listL) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n                {\n                    \"declaringClass\": \"");
            sb.append((Object) stackTraceElement.getClassName());
            sb.append("\",\n                    \"methodName\": \"");
            sb.append((Object) stackTraceElement.getMethodName());
            sb.append("\",\n                    \"fileName\": ");
            String fileName = stackTraceElement.getFileName();
            sb.append((Object) (fileName == null ? null : P(fileName)));
            sb.append(",\n                    \"lineNumber\": ");
            sb.append(stackTraceElement.getLineNumber());
            sb.append("\n                }\n                ");
            arrayList.add(kotlin.text.u.p(sb.toString()));
        }
        return '[' + g0.h3(arrayList, null, null, null, 0, null, null, 63, null) + ']';
    }

    public final boolean u() {
        return f35959j;
    }

    public final boolean v() {
        return f35958i;
    }

    @a7.d
    public final String w(@a7.d o2 o2Var) {
        ReentrantReadWriteLock reentrantReadWriteLock = f35957h;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i7 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        int i8 = 0;
        while (i8 < readHoldCount) {
            i8++;
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            g gVar = f35950a;
            if (!gVar.z()) {
                throw new IllegalStateException("Debug probes are not installed".toString());
            }
            Set<a<?>> setQ = gVar.q();
            ArrayList arrayList = new ArrayList();
            for (Object obj : setQ) {
                if (((a) obj).f35962a.d().get(o2.f37103s0) != null) {
                    arrayList.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(b1.j(z.Z(arrayList, 10)), 16));
            for (Object obj2 : arrayList) {
                linkedHashMap.put(s2.B(((a) obj2).f35962a.d()), ((a) obj2).f35963b);
            }
            StringBuilder sb = new StringBuilder();
            f35950a.d(o2Var, linkedHashMap, sb, "");
            String string = sb.toString();
            l0.o(string, "StringBuilder().apply(builderAction).toString()");
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
            return string;
        } catch (Throwable th) {
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final void x() {
        ReentrantReadWriteLock reentrantReadWriteLock = f35957h;
        ReentrantReadWriteLock.ReadLock lock = reentrantReadWriteLock.readLock();
        int i7 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        int i8 = 0;
        while (i8 < readHoldCount) {
            i8++;
            lock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            installations++;
            if (installations > 1) {
                while (i7 < readHoldCount) {
                    i7++;
                    lock.lock();
                }
                writeLock.unlock();
                return;
            }
            f35950a.M();
            if (kotlinx.coroutines.debug.internal.a.f35896a.a()) {
                while (i7 < readHoldCount) {
                    i7++;
                    lock.lock();
                }
                writeLock.unlock();
                return;
            }
            i5.l<Boolean, l2> lVar = f35960k;
            if (lVar != null) {
                lVar.z(Boolean.TRUE);
            }
            l2 l2Var = l2.f34958a;
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i7 < readHoldCount) {
                i7++;
                lock.lock();
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final boolean z() {
        return installations > 0;
    }
}
