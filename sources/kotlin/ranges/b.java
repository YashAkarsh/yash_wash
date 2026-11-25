package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends kotlin.collections.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f35016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f35017d;

    public b(char c8, char c9, int i7) {
        this.f35014a = i7;
        this.f35015b = c9;
        boolean z7 = true;
        if (i7 <= 0 ? l0.t(c8, c9) < 0 : l0.t(c8, c9) > 0) {
            z7 = false;
        }
        this.f35016c = z7;
        this.f35017d = z7 ? c8 : c9;
    }

    @Override // kotlin.collections.u
    public char b() {
        int i7 = this.f35017d;
        if (i7 != this.f35015b) {
            this.f35017d = this.f35014a + i7;
        } else {
            if (!this.f35016c) {
                throw new NoSuchElementException();
            }
            this.f35016c = false;
        }
        return (char) i7;
    }

    public final int d() {
        return this.f35014a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f35016c;
    }
}
