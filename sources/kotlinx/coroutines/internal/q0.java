package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.p1;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final String f37017a = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final String f37018b = "kotlinx.coroutines.internal.StackTraceRecoveryKt";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f37019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f37020d;

    static {
        Object objB;
        Object objB2;
        try {
            kotlin.d1.a aVar = kotlin.d1.f34719b;
            objB = kotlin.d1.b(kotlin.coroutines.jvm.internal.a.class.getCanonicalName());
        } catch (Throwable th) {
            kotlin.d1.a aVar2 = kotlin.d1.f34719b;
            objB = kotlin.d1.b(kotlin.e1.a(th));
        }
        if (kotlin.d1.e(objB) != null) {
            objB = f37017a;
        }
        f37019c = (String) objB;
        try {
            kotlin.d1.a aVar3 = kotlin.d1.f34719b;
            objB2 = kotlin.d1.b(q0.class.getCanonicalName());
        } catch (Throwable th2) {
            kotlin.d1.a aVar4 = kotlin.d1.f34719b;
            objB2 = kotlin.d1.b(kotlin.e1.a(th2));
        }
        if (kotlin.d1.e(objB2) != null) {
            objB2 = f37018b;
        }
        f37020d = (String) objB2;
    }

    public static /* synthetic */ void a() {
    }

    public static /* synthetic */ void b() {
    }

    @a7.d
    @j2
    public static final StackTraceElement d(@a7.d String str) {
        return new StackTraceElement(kotlin.jvm.internal.l0.C("\b\b\b(", str), "\b", "\b", -1);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002c  */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    private static final <E extends Throwable> kotlin.u0<E, StackTraceElement[]> e(E e8) {
        boolean z7;
        Throwable cause = e8.getCause();
        if (cause == null || !kotlin.jvm.internal.l0.g(cause.getClass(), e8.getClass())) {
            return p1.a(e8, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e8.getStackTrace();
        int length = stackTrace.length;
        int i7 = 0;
        while (i7 < length) {
            StackTraceElement stackTraceElement = stackTrace[i7];
            i7++;
            if (k(stackTraceElement)) {
                z7 = true;
                return z7 ? p1.a(cause, stackTrace) : p1.a(e8, new StackTraceElement[0]);
            }
        }
        z7 = false;
        if (z7) {
        }
    }

    private static final <E extends Throwable> E f(E e8, E e9, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(d("Coroutine boundary"));
        StackTraceElement[] stackTrace = e8.getStackTrace();
        int i7 = i(stackTrace, f37019c);
        int i8 = 0;
        if (i7 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            e9.setStackTrace((StackTraceElement[]) array);
            return e9;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + i7];
        for (int i9 = 0; i9 < i7; i9++) {
            stackTraceElementArr[i9] = stackTrace[i9];
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        while (it.hasNext()) {
            stackTraceElementArr[i8 + i7] = it.next();
            i8++;
        }
        e9.setStackTrace(stackTraceElementArr);
        return e9;
    }

    private static final ArrayDeque<StackTraceElement> g(kotlin.coroutines.jvm.internal.e eVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElementI = eVar.I();
        if (stackTraceElementI != null) {
            arrayDeque.add(stackTraceElementI);
        }
        while (true) {
            eVar = eVar.i();
            if (eVar == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElementI2 = eVar.I();
            if (stackTraceElementI2 != null) {
                arrayDeque.add(stackTraceElementI2);
            }
        }
    }

    private static final boolean h(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && kotlin.jvm.internal.l0.g(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && kotlin.jvm.internal.l0.g(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && kotlin.jvm.internal.l0.g(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int i(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        int i7 = 0;
        while (i7 < length) {
            int i8 = i7 + 1;
            if (kotlin.jvm.internal.l0.g(str, stackTraceElementArr[i7].getClassName())) {
                return i7;
            }
            i7 = i8;
        }
        return -1;
    }

    public static final void j(@a7.d Throwable th, @a7.d Throwable th2) {
        th.initCause(th2);
    }

    public static final boolean k(@a7.d StackTraceElement stackTraceElement) {
        return kotlin.text.b0.u2(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
    }

    private static final void l(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i7 = 0;
        while (true) {
            if (i7 >= length) {
                i7 = -1;
                break;
            }
            int i8 = i7 + 1;
            if (k(stackTraceElementArr[i7])) {
                break;
            } else {
                i7 = i8;
            }
        }
        int i9 = i7 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i9 > length2) {
            return;
        }
        while (true) {
            int i10 = length2 - 1;
            if (h(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i9) {
                return;
            } else {
                length2 = i10;
            }
        }
    }

    @a7.e
    public static final Object m(@a7.d Throwable th, @a7.d kotlin.coroutines.d<?> dVar) throws Throwable {
        throw th;
    }

    private static final Object n(Throwable th, kotlin.coroutines.d<?> dVar) throws Throwable {
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> E o(E e8, kotlin.coroutines.jvm.internal.e eVar) {
        kotlin.u0 u0VarE = e(e8);
        Throwable th = (Throwable) u0VarE.a();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) u0VarE.b();
        Throwable thS = s(th);
        if (thS == null) {
            return e8;
        }
        ArrayDeque<StackTraceElement> arrayDequeG = g(eVar);
        if (arrayDequeG.isEmpty()) {
            return e8;
        }
        if (th != e8) {
            l(stackTraceElementArr, arrayDequeG);
        }
        return (E) f(th, thS, arrayDequeG);
    }

    @a7.d
    public static final <E extends Throwable> E p(@a7.d E e8) {
        return e8;
    }

    @a7.d
    public static final <E extends Throwable> E q(@a7.d E e8, @a7.d kotlin.coroutines.d<?> dVar) {
        return e8;
    }

    private static final <E extends Throwable> E r(E e8) {
        StackTraceElement[] stackTrace = e8.getStackTrace();
        int length = stackTrace.length;
        int i7 = i(stackTrace, f37020d);
        int i8 = i7 + 1;
        int i9 = i(stackTrace, f37019c);
        int i10 = 0;
        int i11 = (length - i7) - (i9 == -1 ? 0 : length - i9);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i11];
        while (i10 < i11) {
            stackTraceElementArr[i10] = i10 == 0 ? d("Coroutine boundary") : stackTrace[(i8 + i10) - 1];
            i10++;
        }
        e8.setStackTrace(stackTraceElementArr);
        return e8;
    }

    private static final <E extends Throwable> E s(E e8) {
        E e9 = (E) n.h(e8);
        if (e9 == null) {
            return null;
        }
        if ((e8 instanceof kotlinx.coroutines.m0) || kotlin.jvm.internal.l0.g(e9.getMessage(), e8.getMessage())) {
            return e9;
        }
        return null;
    }

    @a7.d
    public static final <E extends Throwable> E t(@a7.d E e8) {
        return e8;
    }

    @a7.d
    public static final <E extends Throwable> E u(@a7.d E e8) {
        E e9 = (E) e8.getCause();
        if (e9 != null && kotlin.jvm.internal.l0.g(e9.getClass(), e8.getClass())) {
            StackTraceElement[] stackTrace = e8.getStackTrace();
            int length = stackTrace.length;
            boolean z7 = false;
            int i7 = 0;
            while (i7 < length) {
                StackTraceElement stackTraceElement = stackTrace[i7];
                i7++;
                if (k(stackTraceElement)) {
                    z7 = true;
                    break;
                }
            }
            if (z7) {
                return e9;
            }
        }
        return e8;
    }
}
