package okio;

import kotlin.b1;

/* JADX INFO: loaded from: classes3.dex */
@kotlin.k(message = "changed in Okio 2.x")
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f38428a = new e();

    private e() {
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "string.utf8Size()", imports = {"okio.utf8Size"}))
    public final long a(@a7.d String string) {
        kotlin.jvm.internal.l0.p(string, "string");
        return r0.l(string, 0, 0, 3, null);
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "moved to extension function", replaceWith = @b1(expression = "string.utf8Size(beginIndex, endIndex)", imports = {"okio.utf8Size"}))
    public final long b(@a7.d String string, int i7, int i8) {
        kotlin.jvm.internal.l0.p(string, "string");
        return r0.k(string, i7, i8);
    }
}
