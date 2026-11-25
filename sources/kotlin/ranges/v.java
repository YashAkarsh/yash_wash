package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.a2;
import kotlin.g1;
import kotlin.o2;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
final class v implements Iterator<a2>, j5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f35061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f35062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f35063d;

    public /* synthetic */ v(long j7, long j8, long j9, kotlin.jvm.internal.w wVar) {
        this(j7, j8, j9);
    }

    public long a() {
        long j7 = this.f35063d;
        if (j7 != this.f35060a) {
            this.f35063d = a2.h(this.f35062c + j7);
        } else {
            if (!this.f35061b) {
                throw new NoSuchElementException();
            }
            this.f35061b = false;
        }
        return j7;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f35061b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ a2 next() {
        return a2.b(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private v(long j7, long j8, long j9) {
        this.f35060a = j8;
        boolean z7 = true;
        if (j9 <= 0 ? o2.g(j7, j8) < 0 : o2.g(j7, j8) > 0) {
            z7 = false;
        }
        this.f35061b = z7;
        this.f35062c = a2.h(j9);
        this.f35063d = this.f35061b ? j7 : j8;
    }
}
