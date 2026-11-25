package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class z extends y {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterable<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.a<Iterator<T>> f34636a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(i5.a<? extends Iterator<? extends T>> aVar) {
            this.f34636a = aVar;
        }

        @Override // java.lang.Iterable
        @a7.d
        public Iterator<T> iterator() {
            return this.f34636a.invoke();
        }
    }

    @kotlin.internal.f
    private static final <T> Iterable<T> Y(i5.a<? extends Iterator<? extends T>> iterator) {
        kotlin.jvm.internal.l0.p(iterator, "iterator");
        return new a(iterator);
    }

    @kotlin.a1
    public static <T> int Z(@a7.d Iterable<? extends T> iterable, int i7) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i7;
    }

    @a7.e
    @kotlin.a1
    public static final <T> Integer a0(@a7.d Iterable<? extends T> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    @a7.d
    public static final <T> List<T> b0(@a7.d Iterable<? extends Iterable<? extends T>> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends Iterable<? extends T>> it = iterable.iterator();
        while (it.hasNext()) {
            d0.o0(arrayList, it.next());
        }
        return arrayList;
    }

    @a7.d
    public static final <T, R> kotlin.u0<List<T>, List<R>> c0(@a7.d Iterable<? extends kotlin.u0<? extends T, ? extends R>> iterable) {
        kotlin.jvm.internal.l0.p(iterable, "<this>");
        int iZ = Z(iterable, 10);
        ArrayList arrayList = new ArrayList(iZ);
        ArrayList arrayList2 = new ArrayList(iZ);
        for (kotlin.u0<? extends T, ? extends R> u0Var : iterable) {
            arrayList.add(u0Var.e());
            arrayList2.add(u0Var.f());
        }
        return kotlin.p1.a(arrayList, arrayList2);
    }
}
