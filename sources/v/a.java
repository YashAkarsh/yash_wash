package v;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final Map<b<?>, Object> f40424a = new LinkedHashMap();

    /* JADX INFO: renamed from: v.a$a, reason: collision with other inner class name */
    public static final class C0550a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @a7.d
        public static final C0550a f40425b = new C0550a();

        private C0550a() {
        }

        @Override // v.a
        @a7.e
        public <T> T a(@a7.d b<T> key) {
            l0.p(key, "key");
            return null;
        }
    }

    public interface b<T> {
    }

    @a7.e
    public abstract <T> T a(@a7.d b<T> bVar);

    @a7.d
    public final Map<b<?>, Object> b() {
        return this.f40424a;
    }
}
