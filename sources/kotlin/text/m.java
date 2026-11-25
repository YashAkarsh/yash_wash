package kotlin.text;

import java.util.List;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public interface m {

    public static final class a {
        @a7.d
        public static b a(@a7.d m mVar) {
            return new b(mVar);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @a7.d
        private final m f35403a;

        public b(@a7.d m match) {
            l0.p(match, "match");
            this.f35403a = match;
        }

        @kotlin.internal.f
        private final String a() {
            return k().b().get(1);
        }

        @kotlin.internal.f
        private final String b() {
            return k().b().get(10);
        }

        @kotlin.internal.f
        private final String c() {
            return k().b().get(2);
        }

        @kotlin.internal.f
        private final String d() {
            return k().b().get(3);
        }

        @kotlin.internal.f
        private final String e() {
            return k().b().get(4);
        }

        @kotlin.internal.f
        private final String f() {
            return k().b().get(5);
        }

        @kotlin.internal.f
        private final String g() {
            return k().b().get(6);
        }

        @kotlin.internal.f
        private final String h() {
            return k().b().get(7);
        }

        @kotlin.internal.f
        private final String i() {
            return k().b().get(8);
        }

        @kotlin.internal.f
        private final String j() {
            return k().b().get(9);
        }

        @a7.d
        public final m k() {
            return this.f35403a;
        }

        @a7.d
        public final List<String> l() {
            return this.f35403a.b().subList(1, this.f35403a.b().size());
        }
    }

    @a7.d
    b a();

    @a7.d
    List<String> b();

    @a7.d
    k c();

    @a7.d
    kotlin.ranges.k d();

    @a7.d
    String getValue();

    @a7.e
    m next();
}
