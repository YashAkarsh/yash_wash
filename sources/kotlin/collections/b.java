package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> implements Iterator<T>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private r1 f34461a = r1.NotReady;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.e
    private T f34462b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34463a;

        static {
            int[] iArr = new int[r1.values().length];
            iArr[r1.Done.ordinal()] = 1;
            iArr[r1.Ready.ordinal()] = 2;
            f34463a = iArr;
        }
    }

    private final boolean e() {
        this.f34461a = r1.Failed;
        a();
        return this.f34461a == r1.Ready;
    }

    protected abstract void a();

    protected final void b() {
        this.f34461a = r1.Done;
    }

    protected final void d(T t7) {
        this.f34462b = t7;
        this.f34461a = r1.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        r1 r1Var = this.f34461a;
        if (!(r1Var != r1.Failed)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i7 = a.f34463a[r1Var.ordinal()];
        if (i7 == 1) {
            return false;
        }
        if (i7 != 2) {
            return e();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f34461a = r1.NotReady;
        return this.f34462b;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
