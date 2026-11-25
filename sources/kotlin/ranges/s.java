package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.g1;
import kotlin.o2;
import kotlin.w1;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
final class s implements Iterator<w1>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f35051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f35053d;

    public /* synthetic */ s(int i7, int i8, int i9, kotlin.jvm.internal.w wVar) {
        this(i7, i8, i9);
    }

    public int a() {
        int i7 = this.f35053d;
        if (i7 != this.f35050a) {
            this.f35053d = w1.h(this.f35052c + i7);
        } else {
            if (!this.f35051b) {
                throw new NoSuchElementException();
            }
            this.f35051b = false;
        }
        return i7;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f35051b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ w1 next() {
        return w1.b(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private s(int i7, int i8, int i9) {
        this.f35050a = i8;
        boolean z7 = true;
        int iC = o2.c(i7, i8);
        if (i9 <= 0 ? iC < 0 : iC > 0) {
            z7 = false;
        }
        this.f35051b = z7;
        this.f35052c = w1.h(i9);
        this.f35053d = this.f35051b ? i7 : i8;
    }
}
