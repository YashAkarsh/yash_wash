package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import c.b1;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static final /* synthetic */ <T> T a(Context context) {
        l0.p(context, "<this>");
        l0.y(4, "T");
        return (T) d.o(context, Object.class);
    }

    public static final void b(@a7.d Context context, @b1 int i7, @a7.d int[] attrs, @a7.d i5.l<? super TypedArray, l2> block) {
        l0.p(context, "<this>");
        l0.p(attrs, "attrs");
        l0.p(block, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i7, attrs);
        l0.o(typedArrayObtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
        block.z(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final void c(@a7.d Context context, @a7.e AttributeSet attributeSet, @a7.d int[] attrs, @c.f int i7, @b1 int i8, @a7.d i5.l<? super TypedArray, l2> block) {
        l0.p(context, "<this>");
        l0.p(attrs, "attrs");
        l0.p(block, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, attrs, i7, i8);
        l0.o(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        block.z(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void d(Context context, AttributeSet attributeSet, int[] attrs, int i7, int i8, i5.l block, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            attributeSet = null;
        }
        if ((i9 & 4) != 0) {
            i7 = 0;
        }
        if ((i9 & 8) != 0) {
            i8 = 0;
        }
        l0.p(context, "<this>");
        l0.p(attrs, "attrs");
        l0.p(block, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, attrs, i7, i8);
        l0.o(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        block.z(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }
}
