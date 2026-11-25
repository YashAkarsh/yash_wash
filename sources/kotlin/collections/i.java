package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.g1(version = "1.1")
public abstract class i<E> extends kotlin.collections.a<E> implements Set<E>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final a f34534a = new a(null);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        public final boolean a(@a7.d Set<?> c8, @a7.d Set<?> other) {
            kotlin.jvm.internal.l0.p(c8, "c");
            kotlin.jvm.internal.l0.p(other, "other");
            if (c8.size() != other.size()) {
                return false;
            }
            return c8.containsAll(other);
        }

        public final int b(@a7.d Collection<?> c8) {
            kotlin.jvm.internal.l0.p(c8, "c");
            Iterator<?> it = c8.iterator();
            int iHashCode = 0;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode += next != null ? next.hashCode() : 0;
            }
            return iHashCode;
        }

        private a() {
        }
    }

    protected i() {
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@a7.e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            return f34534a.a(this, (Set) obj);
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return f34534a.b(this);
    }

    @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
