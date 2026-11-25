package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 {
    @a7.d
    public static final String a(@a7.d Object obj) {
        return obj.getClass().getSimpleName();
    }

    @a7.d
    public static final String b(@a7.d Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @a7.d
    public static final String c(@a7.d kotlin.coroutines.d<?> dVar) {
        Object objB;
        if (dVar instanceof kotlinx.coroutines.internal.l) {
            return dVar.toString();
        }
        try {
            kotlin.d1.a aVar = kotlin.d1.f34719b;
            objB = kotlin.d1.b(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            kotlin.d1.a aVar2 = kotlin.d1.f34719b;
            objB = kotlin.d1.b(kotlin.e1.a(th));
        }
        if (kotlin.d1.e(objB) != null) {
            objB = ((Object) dVar.getClass().getName()) + '@' + b(dVar);
        }
        return (String) objB;
    }
}
