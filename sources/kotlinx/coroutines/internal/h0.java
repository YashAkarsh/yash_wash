package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.a3;
import kotlinx.coroutines.j2;

/* JADX INFO: loaded from: classes3.dex */
@j2
public final class h0 implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final h0 f36988a = new h0();

    private h0() {
    }

    @Override // kotlinx.coroutines.internal.d0
    @a7.d
    public a3 createDispatcher(@a7.d List<? extends d0> list) {
        return new g0(null, null, 2, null);
    }

    @Override // kotlinx.coroutines.internal.d0
    public int getLoadPriority() {
        return -1;
    }

    @Override // kotlinx.coroutines.internal.d0
    @a7.e
    public String hintOnError() {
        return d0.a.a(this);
    }
}
