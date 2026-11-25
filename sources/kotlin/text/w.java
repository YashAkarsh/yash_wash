package kotlin.text;

import java.util.Set;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
class w extends v {
    @kotlin.internal.f
    private static final o t(String str) {
        l0.p(str, "<this>");
        return new o(str);
    }

    @kotlin.internal.f
    private static final o u(String str, Set<? extends q> options) {
        l0.p(str, "<this>");
        l0.p(options, "options");
        return new o(str, options);
    }

    @kotlin.internal.f
    private static final o v(String str, q option) {
        l0.p(str, "<this>");
        l0.p(option, "option");
        return new o(str, option);
    }
}
