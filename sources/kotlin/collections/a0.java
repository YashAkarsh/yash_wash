package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class a0 extends z {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterator<T>, j5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Enumeration<T> f34460a;

        a(Enumeration<T> enumeration) {
            this.f34460a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f34460a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f34460a.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @a7.d
    public static <T> Iterator<T> d0(@a7.d Enumeration<T> enumeration) {
        kotlin.jvm.internal.l0.p(enumeration, "<this>");
        return new a(enumeration);
    }
}
