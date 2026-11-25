package kotlinx.coroutines;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 {
    @a7.d
    public static final <T> Object a(@a7.e Object obj, @a7.d kotlin.coroutines.d<? super T> dVar) {
        if (obj instanceof e0) {
            kotlin.d1.a aVar = kotlin.d1.f34719b;
            return kotlin.d1.b(kotlin.e1.a(((e0) obj).f35988a));
        }
        kotlin.d1.a aVar2 = kotlin.d1.f34719b;
        return kotlin.d1.b(obj);
    }

    @a7.e
    public static final <T> Object b(@a7.d Object obj, @a7.e i5.l<? super Throwable, kotlin.l2> lVar) {
        Throwable thE = kotlin.d1.e(obj);
        if (thE == null) {
            return lVar != null ? new f0(obj, lVar) : obj;
        }
        return new e0(thE, false, 2, null);
    }

    @a7.e
    public static final <T> Object c(@a7.d Object obj, @a7.d q<?> qVar) {
        Throwable thE = kotlin.d1.e(obj);
        return thE == null ? obj : new e0(thE, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, i5.l lVar, int i7, Object obj2) {
        if ((i7 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
