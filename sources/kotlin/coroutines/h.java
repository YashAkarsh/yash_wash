package kotlin.coroutines;

import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.s;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    /* JADX WARN: Multi-variable type inference failed */
    @g1(version = "1.3")
    @s
    @a7.e
    public static final <E extends g.b> E a(@a7.d g.b bVar, @a7.d g.c<E> key) {
        l0.p(bVar, "<this>");
        l0.p(key, "key");
        if (!(key instanceof b)) {
            if (bVar.getKey() == key) {
                return bVar;
            }
            return null;
        }
        b bVar2 = (b) key;
        if (!bVar2.a(bVar.getKey())) {
            return null;
        }
        E e8 = (E) bVar2.b(bVar);
        if (e8 instanceof g.b) {
            return e8;
        }
        return null;
    }

    @a7.d
    @g1(version = "1.3")
    @s
    public static final g b(@a7.d g.b bVar, @a7.d g.c<?> key) {
        l0.p(bVar, "<this>");
        l0.p(key, "key");
        if (!(key instanceof b)) {
            return bVar.getKey() == key ? i.f34682a : bVar;
        }
        b bVar2 = (b) key;
        return (!bVar2.a(bVar.getKey()) || bVar2.b(bVar) == null) ? bVar : i.f34682a;
    }
}
