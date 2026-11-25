package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import androidx.core.view.n2;
import c.i1;
import c.m0;
import c.o0;
import c.v;
import c.x0;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f5708a = new ThreadLocal<>();

    private c() {
    }

    @m0
    public static ColorStateList a(@m0 Resources resources, @m0 XmlPullParser xmlPullParser, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @m0
    public static ColorStateList b(@m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    @m0
    private static TypedValue c() {
        ThreadLocal<TypedValue> threadLocal = f5708a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @o0
    public static ColorStateList d(@m0 Resources resources, @i1 int i7, @o0 Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i7), theme);
        } catch (Exception e8) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e8);
            return null;
        }
    }

    private static ColorStateList e(@m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int color;
        int i7 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrA = new int[20];
        int i8 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i7 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayH = h(resources, theme, attributeSet, R.styleable.ColorStateListItem);
                int resourceId = typedArrayH.getResourceId(R.styleable.ColorStateListItem_android_color, -1);
                if (resourceId == -1 || f(resources, resourceId)) {
                    color = typedArrayH.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                } else {
                    try {
                        color = a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = typedArrayH.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                    }
                }
                float f8 = 1.0f;
                if (typedArrayH.hasValue(R.styleable.ColorStateListItem_android_alpha)) {
                    f8 = typedArrayH.getFloat(R.styleable.ColorStateListItem_android_alpha, 1.0f);
                } else if (typedArrayH.hasValue(R.styleable.ColorStateListItem_alpha)) {
                    f8 = typedArrayH.getFloat(R.styleable.ColorStateListItem_alpha, 1.0f);
                }
                float f9 = (Build.VERSION.SDK_INT < 31 || !typedArrayH.hasValue(R.styleable.ColorStateListItem_android_lStar)) ? typedArrayH.getFloat(R.styleable.ColorStateListItem_lStar, -1.0f) : typedArrayH.getFloat(R.styleable.ColorStateListItem_android_lStar, -1.0f);
                typedArrayH.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr2 = new int[attributeCount];
                int i9 = 0;
                for (int i10 = 0; i10 < attributeCount; i10++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i10);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha && attributeNameResource != R.attr.lStar) {
                        int i11 = i9 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i10, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr2[i9] = attributeNameResource;
                        i9 = i11;
                    }
                }
                int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i9);
                iArrA = h.a(iArrA, i8, g(color, f8, f9));
                iArr = (int[][]) h.c(iArr, i8, iArrTrimStateSet);
                i8++;
            }
            i7 = 1;
        }
        int[] iArr3 = new int[i8];
        int[][] iArr4 = new int[i8][];
        System.arraycopy(iArrA, 0, iArr3, 0, i8);
        System.arraycopy(iArr, 0, iArr4, 0, i8);
        return new ColorStateList(iArr4, iArr3);
    }

    private static boolean f(@m0 Resources resources, @c.n int i7) {
        TypedValue typedValueC = c();
        resources.getValue(i7, typedValueC, true);
        int i8 = typedValueC.type;
        return i8 >= 28 && i8 <= 31;
    }

    @c.l
    private static int g(@c.l int i7, @v(from = 0.0d, to = 1.0d) float f8, @v(from = 0.0d, to = 100.0d) float f9) {
        boolean z7 = f9 >= 0.0f && f9 <= 100.0f;
        if (f8 == 1.0f && !z7) {
            return i7;
        }
        int iE = m.a.e((int) ((Color.alpha(i7) * f8) + 0.5f), 0, 255);
        if (z7) {
            a aVarC = a.c(i7);
            i7 = a.p(aVarC.j(), aVarC.i(), f9);
        }
        return (i7 & n2.f6742s) | (iE << 24);
    }

    private static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
