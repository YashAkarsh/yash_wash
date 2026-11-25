package kotlin.text;

import java.io.IOException;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.q2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class t {
    @a7.d
    public static final <T extends Appendable> T a(@a7.d T t7, @a7.d CharSequence... value) throws IOException {
        l0.p(t7, "<this>");
        l0.p(value, "value");
        for (CharSequence charSequence : value) {
            t7.append(charSequence);
        }
        return t7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void b(@a7.d Appendable appendable, T t7, @a7.e i5.l<? super T, ? extends CharSequence> lVar) {
        l0.p(appendable, "<this>");
        if (lVar != null) {
            appendable.append(lVar.z(t7));
            return;
        }
        if (t7 == 0 ? true : t7 instanceof CharSequence) {
            appendable.append((CharSequence) t7);
        } else if (t7 instanceof Character) {
            appendable.append(((Character) t7).charValue());
        } else {
            appendable.append(String.valueOf(t7));
        }
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final Appendable c(Appendable appendable) throws IOException {
        l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append('\n');
        l0.o(appendableAppend, "append('\\n')");
        return appendableAppend;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final Appendable d(Appendable appendable, char c8) throws IOException {
        l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(c8);
        l0.o(appendableAppend, "append(value)");
        Appendable appendableAppend2 = appendableAppend.append('\n');
        l0.o(appendableAppend2, "append('\\n')");
        return appendableAppend2;
    }

    @g1(version = "1.4")
    @kotlin.internal.f
    private static final Appendable e(Appendable appendable, CharSequence charSequence) throws IOException {
        l0.p(appendable, "<this>");
        Appendable appendableAppend = appendable.append(charSequence);
        l0.o(appendableAppend, "append(value)");
        Appendable appendableAppend2 = appendableAppend.append('\n');
        l0.o(appendableAppend2, "append('\\n')");
        return appendableAppend2;
    }

    @a7.d
    @g1(version = "1.4")
    @q2(markerClass = {kotlin.s.class})
    public static final <T extends Appendable> T f(@a7.d T t7, @a7.d CharSequence value, int i7, int i8) {
        l0.p(t7, "<this>");
        l0.p(value, "value");
        T t8 = (T) t7.append(value, i7, i8);
        l0.n(t8, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return t8;
    }
}
