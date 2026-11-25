package kotlin.reflect;

import java.util.List;
import java.util.Map;
import kotlin.g1;

/* JADX INFO: loaded from: classes2.dex */
public interface c<R> extends b {

    public static final class a {
        @g1(version = "1.1")
        public static /* synthetic */ void a() {
        }

        @g1(version = "1.1")
        public static /* synthetic */ void b() {
        }

        @g1(version = "1.1")
        public static /* synthetic */ void c() {
        }

        @g1(version = "1.1")
        public static /* synthetic */ void d() {
        }

        @g1(version = "1.1")
        public static /* synthetic */ void e() {
        }

        @g1(version = "1.3")
        public static /* synthetic */ void f() {
        }
    }

    R O(@a7.d Map<n, ? extends Object> map);

    boolean b();

    boolean e();

    @a7.e
    w f();

    @a7.d
    s g0();

    @a7.d
    String getName();

    @a7.d
    List<n> getParameters();

    @a7.d
    List<t> getTypeParameters();

    boolean h();

    boolean isOpen();

    R o0(@a7.d Object... objArr);
}
