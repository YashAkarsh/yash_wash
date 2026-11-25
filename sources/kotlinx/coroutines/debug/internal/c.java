package kotlinx.coroutines.debug.internal;

import kotlin.jvm.internal.l0;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f35918a = -1640531527;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f35919b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private static final r0 f35920c = new r0("REHASH");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private static final l f35921d = new l(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.d
    private static final l f35922e = new l(Boolean.TRUE);

    /* JADX INFO: Access modifiers changed from: private */
    public static final l d(Object obj) {
        if (obj == null) {
            return f35921d;
        }
        return l0.g(obj, Boolean.TRUE) ? f35922e : new l(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
