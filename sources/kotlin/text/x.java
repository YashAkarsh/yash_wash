package kotlin.text;

import java.io.IOException;
import kotlin.b1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.q2;

/* JADX INFO: loaded from: classes2.dex */
class x extends w {
    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder A(StringBuilder sb, long j7) {
        l0.p(sb, "<this>");
        sb.append(j7);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder B(StringBuilder sb, StringBuffer stringBuffer) {
        l0.p(sb, "<this>");
        sb.append(stringBuffer);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder C(StringBuilder sb, StringBuilder sb2) {
        l0.p(sb, "<this>");
        sb.append((CharSequence) sb2);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder D(StringBuilder sb, short s7) {
        l0.p(sb, "<this>");
        sb.append((int) s7);
        l0.o(sb, "append(value.toInt())");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final StringBuilder E(StringBuilder sb, CharSequence value, int i7, int i8) {
        l0.p(sb, "<this>");
        l0.p(value, "value");
        sb.append(value, i7, i8);
        l0.o(sb, "this.append(value, startIndex, endIndex)");
        return sb;
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final StringBuilder F(StringBuilder sb, char[] value, int i7, int i8) {
        l0.p(sb, "<this>");
        l0.p(value, "value");
        sb.append(value, i7, i8 - i7);
        l0.o(sb, "this.append(value, start…x, endIndex - startIndex)");
        return sb;
    }

    @a7.d
    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine()", imports = {}))
    public static final Appendable G(@a7.d Appendable appendable) throws IOException {
        l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(f0.f35363b);
        l0.o(appendableAppend, "append(SystemProperties.LINE_SEPARATOR)");
        return appendableAppend;
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final Appendable H(Appendable appendable, char c8) throws IOException {
        l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(c8);
        l0.o(appendableAppend, "append(value)");
        return G(appendableAppend);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final Appendable I(Appendable appendable, CharSequence charSequence) throws IOException {
        l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(charSequence);
        l0.o(appendableAppend, "append(value)");
        return G(appendableAppend);
    }

    @a7.d
    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine()", imports = {}))
    public static final StringBuilder J(@a7.d StringBuilder sb) {
        l0.p(sb, "<this>");
        sb.append(f0.f35363b);
        l0.o(sb, "append(SystemProperties.LINE_SEPARATOR)");
        return sb;
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder K(StringBuilder sb, byte b8) {
        l0.p(sb, "<this>");
        sb.append((int) b8);
        l0.o(sb, "append(value.toInt())");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder L(StringBuilder sb, char c8) {
        l0.p(sb, "<this>");
        sb.append(c8);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder M(StringBuilder sb, double d8) {
        l0.p(sb, "<this>");
        sb.append(d8);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder N(StringBuilder sb, float f8) {
        l0.p(sb, "<this>");
        sb.append(f8);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder O(StringBuilder sb, int i7) {
        l0.p(sb, "<this>");
        sb.append(i7);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder P(StringBuilder sb, long j7) {
        l0.p(sb, "<this>");
        sb.append(j7);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder Q(StringBuilder sb, CharSequence charSequence) {
        l0.p(sb, "<this>");
        sb.append(charSequence);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder R(StringBuilder sb, Object obj) {
        l0.p(sb, "<this>");
        sb.append(obj);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder S(StringBuilder sb, String str) {
        l0.p(sb, "<this>");
        sb.append(str);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder T(StringBuilder sb, StringBuffer stringBuffer) {
        l0.p(sb, "<this>");
        sb.append(stringBuffer);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder U(StringBuilder sb, StringBuilder sb2) {
        l0.p(sb, "<this>");
        sb.append((CharSequence) sb2);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder V(StringBuilder sb, short s7) {
        l0.p(sb, "<this>");
        sb.append((int) s7);
        l0.o(sb, "append(value.toInt())");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder W(StringBuilder sb, boolean z7) {
        l0.p(sb, "<this>");
        sb.append(z7);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @kotlin.k(level = kotlin.m.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @b1(expression = "appendLine(value)", imports = {}))
    @kotlin.internal.f
    private static final StringBuilder X(StringBuilder sb, char[] value) {
        l0.p(sb, "<this>");
        l0.p(value, "value");
        sb.append(value);
        l0.o(sb, "append(value)");
        return J(sb);
    }

    @a7.d
    @g1(version = "1.3")
    public static final StringBuilder Y(@a7.d StringBuilder sb) {
        l0.p(sb, "<this>");
        sb.setLength(0);
        return sb;
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final StringBuilder Z(StringBuilder sb, int i7) {
        l0.p(sb, "<this>");
        StringBuilder sbDeleteCharAt = sb.deleteCharAt(i7);
        l0.o(sbDeleteCharAt, "this.deleteCharAt(index)");
        return sbDeleteCharAt;
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final StringBuilder a0(StringBuilder sb, int i7, int i8) {
        l0.p(sb, "<this>");
        StringBuilder sbDelete = sb.delete(i7, i8);
        l0.o(sbDelete, "this.delete(startIndex, endIndex)");
        return sbDelete;
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final StringBuilder b0(StringBuilder sb, int i7, CharSequence value, int i8, int i9) {
        l0.p(sb, "<this>");
        l0.p(value, "value");
        StringBuilder sbInsert = sb.insert(i7, value, i8, i9);
        l0.o(sbInsert, "this.insert(index, value, startIndex, endIndex)");
        return sbInsert;
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final StringBuilder c0(StringBuilder sb, int i7, char[] value, int i8, int i9) {
        l0.p(sb, "<this>");
        l0.p(value, "value");
        StringBuilder sbInsert = sb.insert(i7, value, i8, i9 - i8);
        l0.o(sbInsert, "this.insert(index, value…x, endIndex - startIndex)");
        return sbInsert;
    }

    @kotlin.internal.f
    private static final void d0(StringBuilder sb, int i7, char c8) {
        l0.p(sb, "<this>");
        sb.setCharAt(i7, c8);
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final StringBuilder e0(StringBuilder sb, int i7, int i8, String value) {
        l0.p(sb, "<this>");
        l0.p(value, "value");
        StringBuilder sbReplace = sb.replace(i7, i8, value);
        l0.o(sbReplace, "this.replace(startIndex, endIndex, value)");
        return sbReplace;
    }

    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    @kotlin.internal.f
    private static final void f0(StringBuilder sb, char[] destination, int i7, int i8, int i9) {
        l0.p(sb, "<this>");
        l0.p(destination, "destination");
        sb.getChars(i8, i9, destination, i7);
    }

    static /* synthetic */ void g0(StringBuilder sb, char[] destination, int i7, int i8, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i7 = 0;
        }
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = sb.length();
        }
        l0.p(sb, "<this>");
        l0.p(destination, "destination");
        sb.getChars(i8, i9, destination, i7);
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder w(StringBuilder sb, byte b8) {
        l0.p(sb, "<this>");
        sb.append((int) b8);
        l0.o(sb, "append(value.toInt())");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder x(StringBuilder sb, double d8) {
        l0.p(sb, "<this>");
        sb.append(d8);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder y(StringBuilder sb, float f8) {
        l0.p(sb, "<this>");
        sb.append(f8);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final StringBuilder z(StringBuilder sb, int i7) {
        l0.p(sb, "<this>");
        sb.append(i7);
        l0.o(sb, "append(value)");
        sb.append('\n');
        l0.o(sb, "append('\\n')");
        return sb;
    }
}
