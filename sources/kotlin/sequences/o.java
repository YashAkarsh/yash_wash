package kotlin.sequences;

import java.util.Collection;
import java.util.Iterator;
import kotlin.g1;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.coroutines.j
@g1(version = "1.3")
public abstract class o<T> {
    @a7.e
    public abstract Object a(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar);

    @a7.e
    public final Object f(@a7.d Iterable<? extends T> iterable, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return l2.f34958a;
        }
        Object objG = g(iterable.iterator(), dVar);
        return objG == kotlin.coroutines.intrinsics.d.h() ? objG : l2.f34958a;
    }

    @a7.e
    public abstract Object g(@a7.d Iterator<? extends T> it, @a7.d kotlin.coroutines.d<? super l2> dVar);

    @a7.e
    public final Object h(@a7.d m<? extends T> mVar, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        Object objG = g(mVar.iterator(), dVar);
        return objG == kotlin.coroutines.intrinsics.d.h() ? objG : l2.f34958a;
    }
}
