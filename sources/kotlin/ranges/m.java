package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f35041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f35042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f35043d;

    public m(long j7, long j8, long j9) {
        this.f35040a = j9;
        this.f35041b = j8;
        boolean z7 = true;
        if (j9 <= 0 ? j7 < j8 : j7 > j8) {
            z7 = false;
        }
        this.f35042c = z7;
        this.f35043d = z7 ? j7 : j8;
    }

    @Override // kotlin.collections.v0
    public long b() {
        long j7 = this.f35043d;
        if (j7 != this.f35041b) {
            this.f35043d = this.f35040a + j7;
        } else {
            if (!this.f35042c) {
                throw new NoSuchElementException();
            }
            this.f35042c = false;
        }
        return j7;
    }

    public final long d() {
        return this.f35040a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f35042c;
    }
}
