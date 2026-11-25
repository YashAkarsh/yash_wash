package androidx.core.content.res;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import c.c1;
import c.t;
import c.t0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
@t0(26)
final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final o f5752a = new o();

    private o() {
    }

    @a7.d
    @t
    @h5.l
    public static final Typeface a(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "typedArray");
        Typeface font = typedArray.getFont(i7);
        l0.m(font);
        return font;
    }
}
