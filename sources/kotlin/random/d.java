package kotlin.random;

import java.io.Serializable;
import java.util.Random;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;

/* JADX INFO: loaded from: classes2.dex */
final class d extends kotlin.random.a implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private static final a f34995d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    private static final long f34996e = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final Random f34997c;

    private static final class a {
        public /* synthetic */ a(w wVar) {
            this();
        }

        private a() {
        }
    }

    public d(@a7.d Random impl) {
        l0.p(impl, "impl");
        this.f34997c = impl;
    }

    @Override // kotlin.random.a
    @a7.d
    public Random r() {
        return this.f34997c;
    }
}
