package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import c.c1;
import c.m0;
import c.o0;
import c.x0;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5753a = "http://schemas.android.com/apk/res/android";

    private q() {
    }

    public static int a(@m0 Context context, int i7, int i8) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i7, typedValue, true);
        return typedValue.resourceId != 0 ? i7 : i8;
    }

    public static boolean b(@m0 TypedArray typedArray, @c1 int i7, @c1 int i8, boolean z7) {
        return typedArray.getBoolean(i7, typedArray.getBoolean(i8, z7));
    }

    @o0
    public static Drawable c(@m0 TypedArray typedArray, @c1 int i7, @c1 int i8) {
        Drawable drawable = typedArray.getDrawable(i7);
        return drawable == null ? typedArray.getDrawable(i8) : drawable;
    }

    public static int d(@m0 TypedArray typedArray, @c1 int i7, @c1 int i8, int i9) {
        return typedArray.getInt(i7, typedArray.getInt(i8, i9));
    }

    public static boolean e(@m0 TypedArray typedArray, @m0 XmlPullParser xmlPullParser, @m0 String str, @c1 int i7, boolean z7) {
        return !r(xmlPullParser, str) ? z7 : typedArray.getBoolean(i7, z7);
    }

    @c.l
    public static int f(@m0 TypedArray typedArray, @m0 XmlPullParser xmlPullParser, @m0 String str, @c1 int i7, @c.l int i8) {
        return !r(xmlPullParser, str) ? i8 : typedArray.getColor(i7, i8);
    }

    @o0
    public static ColorStateList g(@m0 TypedArray typedArray, @m0 XmlPullParser xmlPullParser, @o0 Resources.Theme theme, @m0 String str, @c1 int i7) {
        if (!r(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i7, typedValue);
        int i8 = typedValue.type;
        if (i8 != 2) {
            return (i8 < 28 || i8 > 31) ? c.d(typedArray.getResources(), typedArray.getResourceId(i7, 0), theme) : h(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i7 + ": " + typedValue);
    }

    @m0
    private static ColorStateList h(@m0 TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static d i(@m0 TypedArray typedArray, @m0 XmlPullParser xmlPullParser, @o0 Resources.Theme theme, @m0 String str, @c1 int i7, @c.l int i8) {
        if (r(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i7, typedValue);
            int i9 = typedValue.type;
            if (i9 >= 28 && i9 <= 31) {
                return d.b(typedValue.data);
            }
            d dVarG = d.g(typedArray.getResources(), typedArray.getResourceId(i7, 0), theme);
            if (dVarG != null) {
                return dVarG;
            }
        }
        return d.b(i8);
    }

    public static float j(@m0 TypedArray typedArray, @m0 XmlPullParser xmlPullParser, @m0 String str, @c1 int i7, float f8) {
        return !r(xmlPullParser, str) ? f8 : typedArray.getFloat(i7, f8);
    }

    public static int k(@m0 TypedArray typedArray, @m0 XmlPullParser xmlPullParser, @m0 String str, @c1 int i7, int i8) {
        return !r(xmlPullParser, str) ? i8 : typedArray.getInt(i7, i8);
    }

    @c.c
    public static int l(@m0 TypedArray typedArray, @m0 XmlPullParser xmlPullParser, @m0 String str, @c1 int i7, @c.c int i8) {
        return !r(xmlPullParser, str) ? i8 : typedArray.getResourceId(i7, i8);
    }

    @o0
    public static String m(@m0 TypedArray typedArray, @m0 XmlPullParser xmlPullParser, @m0 String str, @c1 int i7) {
        if (r(xmlPullParser, str)) {
            return typedArray.getString(i7);
        }
        return null;
    }

    @c.c
    public static int n(@m0 TypedArray typedArray, @c1 int i7, @c1 int i8, @c.c int i9) {
        return typedArray.getResourceId(i7, typedArray.getResourceId(i8, i9));
    }

    @o0
    public static String o(@m0 TypedArray typedArray, @c1 int i7, @c1 int i8) {
        String string = typedArray.getString(i7);
        return string == null ? typedArray.getString(i8) : string;
    }

    @o0
    public static CharSequence p(@m0 TypedArray typedArray, @c1 int i7, @c1 int i8) {
        CharSequence text = typedArray.getText(i7);
        return text == null ? typedArray.getText(i8) : text;
    }

    @o0
    public static CharSequence[] q(@m0 TypedArray typedArray, @c1 int i7, @c1 int i8) {
        CharSequence[] textArray = typedArray.getTextArray(i7);
        return textArray == null ? typedArray.getTextArray(i8) : textArray;
    }

    public static boolean r(@m0 XmlPullParser xmlPullParser, @m0 String str) {
        return xmlPullParser.getAttributeValue(f5753a, str) != null;
    }

    @m0
    public static TypedArray s(@m0 Resources resources, @o0 Resources.Theme theme, @m0 AttributeSet attributeSet, @m0 int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @o0
    public static TypedValue t(@m0 TypedArray typedArray, @m0 XmlPullParser xmlPullParser, @m0 String str, int i7) {
        if (r(xmlPullParser, str)) {
            return typedArray.peekValue(i7);
        }
        return null;
    }
}
