package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.u0;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f35032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f35033d;

    public j(int i7, int i8, int i9) {
        this.f35030a = i9;
        this.f35031b = i8;
        boolean z7 = true;
        if (i9 <= 0 ? i7 < i8 : i7 > i8) {
            z7 = false;
        }
        this.f35032c = z7;
        this.f35033d = z7 ? i7 : i8;
    }

    @Override // kotlin.collections.u0
    public int b() {
        int i7 = this.f35033d;
        if (i7 != this.f35031b) {
            this.f35033d = this.f35030a + i7;
        } else {
            if (!this.f35032c) {
                throw new NoSuchElementException();
            }
            this.f35032c = false;
        }
        return i7;
    }

    public final int d() {
        return this.f35030a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f35032c;
    }
}
