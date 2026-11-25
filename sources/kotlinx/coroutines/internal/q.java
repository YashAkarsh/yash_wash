package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
@h5.f
public final class q<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.e
    private final Object f37016a;

    private /* synthetic */ q(Object obj) {
        this.f37016a = obj;
    }

    public static final /* synthetic */ q a(Object obj) {
        return new q(obj);
    }

    @a7.d
    public static <E> Object b(@a7.e Object obj) {
        return obj;
    }

    public static /* synthetic */ Object c(Object obj, int i7, kotlin.jvm.internal.w wVar) {
        if ((i7 & 1) != 0) {
            obj = null;
        }
        return b(obj);
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof q) && kotlin.jvm.internal.l0.g(obj, ((q) obj2).j());
    }

    public static final boolean e(Object obj, Object obj2) {
        return kotlin.jvm.internal.l0.g(obj, obj2);
    }

    public static final void f(Object obj, @a7.d i5.l<? super E, l2> lVar) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            lVar.z(obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i7 = size - 1;
            lVar.z((Object) arrayList.get(size));
            if (i7 < 0) {
                return;
            } else {
                size = i7;
            }
        }
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @a7.d
    public static final Object h(Object obj, E e8) {
        if (obj == null) {
            return b(e8);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e8);
            return b(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e8);
        return b(arrayList);
    }

    public static String i(Object obj) {
        return "InlineList(holder=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f37016a, obj);
    }

    public int hashCode() {
        return g(this.f37016a);
    }

    public final /* synthetic */ Object j() {
        return this.f37016a;
    }

    public String toString() {
        return i(this.f37016a);
    }
}
