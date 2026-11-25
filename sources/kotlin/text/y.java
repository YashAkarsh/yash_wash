package kotlin.text;

import kotlin.b1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes2.dex */
class y extends x {
    @kotlin.k(level = kotlin.m.WARNING, message = "Use append(value: Any?) instead", replaceWith = @b1(expression = "append(value = obj)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder h0(StringBuilder sb, Object obj) {
        l0.p(sb, "<this>");
        sb.append(obj);
        l0.o(sb, "this.append(obj)");
        return sb;
    }

    @a7.d
    public static final StringBuilder i0(@a7.d StringBuilder sb, @a7.d Object... value) {
        l0.p(sb, "<this>");
        l0.p(value, "value");
        for (Object obj : value) {
            sb.append(obj);
        }
        return sb;
    }

    @a7.d
    public static final StringBuilder j0(@a7.d StringBuilder sb, @a7.d String... value) {
        l0.p(sb, "<this>");
        l0.p(value, "value");
        for (String str : value) {
            sb.append(str);
        }
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder k0(StringBuilder sb) {
        l0.p(sb, "<this>");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder l0(StringBuilder sb, char c8) {
        l0.p(sb, "<this>");
        sb.append(c8);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder m0(StringBuilder sb, CharSequence charSequence) {
        l0.p(sb, "<this>");
        sb.append(charSequence);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder n0(StringBuilder sb, Object obj) {
        l0.p(sb, "<this>");
        sb.append(obj);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder o0(StringBuilder sb, String str) {
        l0.p(sb, "<this>");
        sb.append(str);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder p0(StringBuilder sb, boolean z7) {
        l0.p(sb, "<this>");
        sb.append(z7);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder q0(StringBuilder sb, char[] value) {
        l0.p(sb, "<this>");
        l0.p(value, "value");
        sb.append(value);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final String r0(int i7, i5.l<? super StringBuilder, l2> builderAction) {
        l0.p(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder(i7);
        builderAction.z(sb);
        String string = sb.toString();
        l0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    @kotlin.internal.f
    private static final String s0(i5.l<? super StringBuilder, l2> builderAction) {
        l0.p(builderAction, "builderAction");
        StringBuilder sb = new StringBuilder();
        builderAction.z(sb);
        String string = sb.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
