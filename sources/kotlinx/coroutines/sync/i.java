package kotlinx.coroutines.sync;

import com.google.common.util.concurrent.h2;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.internal.o0;

/* JADX INFO: loaded from: classes3.dex */
final class i extends o0<i> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    /* synthetic */ AtomicReferenceArray f37298e;

    public i(long j7, @a7.e i iVar, int i7) {
        super(j7, iVar, i7);
        this.f37298e = new AtomicReferenceArray(h.f37293f);
    }

    @Override // kotlinx.coroutines.internal.o0
    public int p() {
        return h.f37293f;
    }

    public final void s(int i7) {
        this.f37298e.set(i7, h.f37292e);
        q();
    }

    public final boolean t(int i7, @a7.e Object obj, @a7.e Object obj2) {
        return h2.a(this.f37298e, i7, obj, obj2);
    }

    @a7.d
    public String toString() {
        return "SemaphoreSegment[id=" + o() + ", hashCode=" + hashCode() + ']';
    }

    @a7.e
    public final Object u(int i7) {
        return this.f37298e.get(i7);
    }

    @a7.e
    public final Object v(int i7, @a7.e Object obj) {
        return this.f37298e.getAndSet(i7, obj);
    }

    public final void w(int i7, @a7.e Object obj) {
        this.f37298e.set(i7, obj);
    }
}
