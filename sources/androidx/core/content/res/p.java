package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import c.c1;
import c.t0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
public final class p {
    private static final void a(TypedArray typedArray, @c1 int i7) {
        if (!typedArray.hasValue(i7)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean b(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        return typedArray.getBoolean(i7, false);
    }

    @c.l
    public static final int c(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        return typedArray.getColor(i7, 0);
    }

    @a7.d
    public static final ColorStateList d(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        ColorStateList colorStateList = typedArray.getColorStateList(i7);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float e(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        return typedArray.getDimension(i7, 0.0f);
    }

    @c.q
    public static final int f(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        return typedArray.getDimensionPixelOffset(i7, 0);
    }

    @c.q
    public static final int g(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        return typedArray.getDimensionPixelSize(i7, 0);
    }

    @a7.d
    public static final Drawable h(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        Drawable drawable = typedArray.getDrawable(i7);
        l0.m(drawable);
        return drawable;
    }

    public static final float i(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        return typedArray.getFloat(i7, 0.0f);
    }

    @a7.d
    @t0(26)
    public static final Typeface j(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        return o.a(typedArray, i7);
    }

    public static final int k(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        return typedArray.getInt(i7, 0);
    }

    public static final int l(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        return typedArray.getInteger(i7, 0);
    }

    @c.c
    public static final int m(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        return typedArray.getResourceId(i7, 0);
    }

    @a7.d
    public static final String n(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        String string = typedArray.getString(i7);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @a7.d
    public static final CharSequence[] o(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        CharSequence[] textArray = typedArray.getTextArray(i7);
        l0.o(textArray, "getTextArray(index)");
        return textArray;
    }

    @a7.d
    public static final CharSequence p(@a7.d TypedArray typedArray, @c1 int i7) {
        l0.p(typedArray, "<this>");
        a(typedArray, i7);
        CharSequence text = typedArray.getText(i7);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R q(@a7.d TypedArray typedArray, @a7.d i5.l<? super TypedArray, ? extends R> block) {
        l0.p(typedArray, "<this>");
        l0.p(block, "block");
        R rZ = block.z(typedArray);
        typedArray.recycle();
        return rZ;
    }
}
