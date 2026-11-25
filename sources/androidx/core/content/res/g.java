package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.R;
import c.m0;
import c.o0;
import c.x0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f5730a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f5731b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f5732c = 2;

    private g() {
    }

    private static a a(@o0 a aVar, @c.l int i7, @c.l int i8, boolean z7, @c.l int i9) {
        if (aVar != null) {
            return aVar;
        }
        return z7 ? new a(i7, i9, i8) : new a(i7, i8);
    }

    static Shader b(@m0 Resources resources, @m0 XmlPullParser xmlPullParser, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return c(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    static Shader c(@m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayS = q.s(resources, theme, attributeSet, R.styleable.GradientColor);
        float fJ = q.j(typedArrayS, xmlPullParser, "startX", R.styleable.GradientColor_android_startX, 0.0f);
        float fJ2 = q.j(typedArrayS, xmlPullParser, "startY", R.styleable.GradientColor_android_startY, 0.0f);
        float fJ3 = q.j(typedArrayS, xmlPullParser, "endX", R.styleable.GradientColor_android_endX, 0.0f);
        float fJ4 = q.j(typedArrayS, xmlPullParser, "endY", R.styleable.GradientColor_android_endY, 0.0f);
        float fJ5 = q.j(typedArrayS, xmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
        float fJ6 = q.j(typedArrayS, xmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
        int iK = q.k(typedArrayS, xmlPullParser, "type", R.styleable.GradientColor_android_type, 0);
        int iF = q.f(typedArrayS, xmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
        boolean zR = q.r(xmlPullParser, "centerColor");
        int iF2 = q.f(typedArrayS, xmlPullParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
        int iF3 = q.f(typedArrayS, xmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
        int iK2 = q.k(typedArrayS, xmlPullParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
        float fJ7 = q.j(typedArrayS, xmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
        typedArrayS.recycle();
        a aVarA = a(d(resources, xmlPullParser, attributeSet, theme), iF, iF3, zR, iF2);
        if (iK != 1) {
            return iK != 2 ? new LinearGradient(fJ, fJ2, fJ3, fJ4, aVarA.f5733a, aVarA.f5734b, e(iK2)) : new SweepGradient(fJ5, fJ6, aVarA.f5733a, aVarA.f5734b);
        }
        if (fJ7 > 0.0f) {
            return new RadialGradient(fJ5, fJ6, fJ7, aVarA.f5733a, aVarA.f5734b, e(iK2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    private static a d(@m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayS = q.s(resources, theme, attributeSet, R.styleable.GradientColorItem);
                boolean zHasValue = typedArrayS.hasValue(R.styleable.GradientColorItem_android_color);
                boolean zHasValue2 = typedArrayS.hasValue(R.styleable.GradientColorItem_android_offset);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color = typedArrayS.getColor(R.styleable.GradientColorItem_android_color, 0);
                float f8 = typedArrayS.getFloat(R.styleable.GradientColorItem_android_offset, 0.0f);
                typedArrayS.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f8));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode e(int i7) {
        if (i7 != 1) {
            return i7 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR;
        }
        return Shader.TileMode.REPEAT;
    }

    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f5733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final float[] f5734b;

        a(@m0 List<Integer> list, @m0 List<Float> list2) {
            int size = list.size();
            this.f5733a = new int[size];
            this.f5734b = new float[size];
            for (int i7 = 0; i7 < size; i7++) {
                this.f5733a[i7] = list.get(i7).intValue();
                this.f5734b[i7] = list2.get(i7).floatValue();
            }
        }

        a(@c.l int i7, @c.l int i8) {
            this.f5733a = new int[]{i7, i8};
            this.f5734b = new float[]{0.0f, 1.0f};
        }

        a(@c.l int i7, @c.l int i8, @c.l int i9) {
            this.f5733a = new int[]{i7, i8, i9};
            this.f5734b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
