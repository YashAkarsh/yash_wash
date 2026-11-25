package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.d1;
import kotlin.e1;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
final class n<T> extends o<T> implements Iterator<T>, kotlin.coroutines.d<l2>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f35146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private T f35147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.e
    private Iterator<? extends T> f35148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.e
    private kotlin.coroutines.d<? super l2> f35149d;

    private final Throwable i() {
        int i7 = this.f35146a;
        if (i7 == 4) {
            return new NoSuchElementException();
        }
        if (i7 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f35146a);
    }

    private final T k() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // kotlin.sequences.o
    @a7.e
    public Object a(T t7, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        this.f35147b = t7;
        this.f35146a = 3;
        this.f35149d = dVar;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        if (objH == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objH == kotlin.coroutines.intrinsics.d.h() ? objH : l2.f34958a;
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public kotlin.coroutines.g d() {
        return kotlin.coroutines.i.f34682a;
    }

    @Override // kotlin.sequences.o
    @a7.e
    public Object g(@a7.d Iterator<? extends T> it, @a7.d kotlin.coroutines.d<? super l2> dVar) {
        if (!it.hasNext()) {
            return l2.f34958a;
        }
        this.f35148c = it;
        this.f35146a = 2;
        this.f35149d = dVar;
        Object objH = kotlin.coroutines.intrinsics.d.h();
        if (objH == kotlin.coroutines.intrinsics.d.h()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objH == kotlin.coroutines.intrinsics.d.h() ? objH : l2.f34958a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i7 = this.f35146a;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 == 2 || i7 == 3) {
                        return true;
                    }
                    if (i7 == 4) {
                        return false;
                    }
                    throw i();
                }
                Iterator<? extends T> it = this.f35148c;
                l0.m(it);
                if (it.hasNext()) {
                    this.f35146a = 2;
                    return true;
                }
                this.f35148c = null;
            }
            this.f35146a = 5;
            kotlin.coroutines.d<? super l2> dVar = this.f35149d;
            l0.m(dVar);
            this.f35149d = null;
            d1.a aVar = d1.f34719b;
            dVar.w(d1.b(l2.f34958a));
        }
    }

    @a7.e
    public final kotlin.coroutines.d<l2> j() {
        return this.f35149d;
    }

    public final void l(@a7.e kotlin.coroutines.d<? super l2> dVar) {
        this.f35149d = dVar;
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i7 = this.f35146a;
        if (i7 == 0 || i7 == 1) {
            return k();
        }
        if (i7 == 2) {
            this.f35146a = 1;
            Iterator<? extends T> it = this.f35148c;
            l0.m(it);
            return it.next();
        }
        if (i7 != 3) {
            throw i();
        }
        this.f35146a = 0;
        T t7 = this.f35147b;
        this.f35147b = null;
        return t7;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.d
    public void w(@a7.d Object obj) {
        e1.n(obj);
        this.f35146a = 4;
    }
}
