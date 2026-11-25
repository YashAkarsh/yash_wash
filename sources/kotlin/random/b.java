package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends kotlin.random.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final a f34990c = new a();

    public static final class a extends ThreadLocal<Random> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @a7.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // kotlin.random.a
    @a7.d
    public Random r() {
        Random random = this.f34990c.get();
        l0.o(random, "implStorage.get()");
        return random;
    }
}
