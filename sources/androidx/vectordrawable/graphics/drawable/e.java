package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.constraintlayout.core.motion.utils.w;
import androidx.core.content.res.q;
import androidx.core.graphics.g2;
import c.x0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f10908a = "AnimatorInflater";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f10909b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f10910c = 100;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f10911d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f10912e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f10913f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f10914g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f10915h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f10916i = false;

    private static class a implements TypeEvaluator<g2.b[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private g2.b[] f10917a;

        a() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g2.b[] evaluate(float f8, g2.b[] bVarArr, g2.b[] bVarArr2) {
            if (!g2.b(bVarArr, bVarArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (!g2.b(this.f10917a, bVarArr)) {
                this.f10917a = g2.f(bVarArr);
            }
            for (int i7 = 0; i7 < bVarArr.length; i7++) {
                this.f10917a[i7].d(bVarArr[i7], bVarArr2[i7], f8);
            }
            return this.f10917a;
        }

        a(g2.b[] bVarArr) {
            this.f10917a = bVarArr;
        }
    }

    private e() {
    }

    private static Animator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f8) throws XmlPullParserException, IOException {
        return b(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f8);
    }

    private static Animator b(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i7, float f8) throws XmlPullParserException, IOException {
        int i8;
        int depth = xmlPullParser.getDepth();
        Animator animatorM = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            i8 = 0;
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    animatorM = o(context, resources, theme, attributeSet, f8, xmlPullParser);
                } else {
                    if (name.equals("animator")) {
                        animatorM = m(context, resources, theme, attributeSet, null, f8, xmlPullParser);
                    } else if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray typedArrayS = q.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f10836a0);
                        b(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, q.k(typedArrayS, xmlPullParser, "ordering", 0, 0), f8);
                        typedArrayS.recycle();
                        animatorM = animatorSet2;
                    } else {
                        if (!name.equals("propertyValuesHolder")) {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                        PropertyValuesHolder[] propertyValuesHolderArrQ = q(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (propertyValuesHolderArrQ != null && (animatorM instanceof ValueAnimator)) {
                            ((ValueAnimator) animatorM).setValues(propertyValuesHolderArrQ);
                        }
                        i8 = 1;
                    }
                    if (animatorSet == null && i8 == 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animatorM);
                    }
                }
                if (animatorSet == null) {
                }
            }
        }
        if (animatorSet != null && arrayList != null) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i8] = (Animator) it.next();
                i8++;
            }
            if (i7 == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animatorM;
    }

    private static Keyframe c(Keyframe keyframe, float f8) {
        if (keyframe.getType() == Float.TYPE) {
            return Keyframe.ofFloat(f8);
        }
        return keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f8) : Keyframe.ofObject(f8);
    }

    private static void d(Keyframe[] keyframeArr, float f8, int i7, int i8) {
        float f9 = f8 / ((i8 - i7) + 2);
        while (i7 <= i8) {
            keyframeArr[i7].setFraction(keyframeArr[i7 - 1].getFraction() + f9);
            i7++;
        }
    }

    private static void e(Object[] objArr, String str) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        Log.d(f10908a, str);
        int length = objArr.length;
        for (int i7 = 0; i7 < length; i7++) {
            Keyframe keyframe = (Keyframe) objArr[i7];
            StringBuilder sb = new StringBuilder();
            sb.append("Keyframe ");
            sb.append(i7);
            sb.append(": fraction ");
            Object value = "null";
            sb.append(keyframe.getFraction() < 0.0f ? "null" : Float.valueOf(keyframe.getFraction()));
            sb.append(", , value : ");
            if (keyframe.hasValue()) {
                value = keyframe.getValue();
            }
            sb.append(value);
            Log.d(f10908a, sb.toString());
        }
    }

    private static PropertyValuesHolder f(TypedArray typedArray, int i7, int i8, int i9, String str) {
        int color;
        int color2;
        int color3;
        PropertyValuesHolder propertyValuesHolderOfFloat;
        PropertyValuesHolder propertyValuesHolderOfObject;
        TypedValue typedValuePeekValue = typedArray.peekValue(i8);
        boolean z7 = typedValuePeekValue != null;
        int i10 = z7 ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i9);
        boolean z8 = typedValuePeekValue2 != null;
        int i11 = z8 ? typedValuePeekValue2.type : 0;
        if (i7 == 4) {
            i7 = ((z7 && i(i10)) || (z8 && i(i11))) ? 3 : 0;
        }
        boolean z9 = i7 == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        if (i7 == 2) {
            String string = typedArray.getString(i8);
            String string2 = typedArray.getString(i9);
            g2.b[] bVarArrD = g2.d(string);
            g2.b[] bVarArrD2 = g2.d(string2);
            if (bVarArrD == null && bVarArrD2 == null) {
                return null;
            }
            if (bVarArrD == null) {
                if (bVarArrD2 != null) {
                    return PropertyValuesHolder.ofObject(str, new a(), bVarArrD2);
                }
                return null;
            }
            a aVar = new a();
            if (bVarArrD2 == null) {
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, bVarArrD);
            } else {
                if (!g2.b(bVarArrD, bVarArrD2)) {
                    throw new InflateException(" Can't morph from " + string + " to " + string2);
                }
                propertyValuesHolderOfObject = PropertyValuesHolder.ofObject(str, aVar, bVarArrD, bVarArrD2);
            }
            return propertyValuesHolderOfObject;
        }
        f fVarA = i7 == 3 ? f.a() : null;
        if (z9) {
            if (z7) {
                float dimension = i10 == 5 ? typedArray.getDimension(i8, 0.0f) : typedArray.getFloat(i8, 0.0f);
                if (z8) {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i11 == 5 ? typedArray.getDimension(i9, 0.0f) : typedArray.getFloat(i9, 0.0f));
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i11 == 5 ? typedArray.getDimension(i9, 0.0f) : typedArray.getFloat(i9, 0.0f));
            }
            propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
        } else if (z7) {
            if (i10 == 5) {
                color2 = (int) typedArray.getDimension(i8, 0.0f);
            } else {
                color2 = i(i10) ? typedArray.getColor(i8, 0) : typedArray.getInt(i8, 0);
            }
            if (z8) {
                if (i11 == 5) {
                    color3 = (int) typedArray.getDimension(i9, 0.0f);
                } else {
                    color3 = i(i11) ? typedArray.getColor(i9, 0) : typedArray.getInt(i9, 0);
                }
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2, color3);
            } else {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color2);
            }
        } else if (z8) {
            if (i11 == 5) {
                color = (int) typedArray.getDimension(i9, 0.0f);
            } else {
                color = i(i11) ? typedArray.getColor(i9, 0) : typedArray.getInt(i9, 0);
            }
            propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, color);
        }
        if (propertyValuesHolderOfInt == null || fVarA == null) {
            return propertyValuesHolderOfInt;
        }
        propertyValuesHolderOfInt.setEvaluator(fVarA);
        return propertyValuesHolderOfInt;
    }

    private static int g(TypedArray typedArray, int i7, int i8) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i7);
        boolean z7 = typedValuePeekValue != null;
        int i9 = z7 ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i8);
        boolean z8 = typedValuePeekValue2 != null;
        return ((z7 && i(i9)) || (z8 && i(z8 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    private static int h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayS = q.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f10850h0);
        int i7 = 0;
        TypedValue typedValueT = q.t(typedArrayS, xmlPullParser, "value", 0);
        if ((typedValueT != null) && i(typedValueT.type)) {
            i7 = 3;
        }
        typedArrayS.recycle();
        return i7;
    }

    private static boolean i(int i7) {
        return i7 >= 28 && i7 <= 31;
    }

    public static Animator j(Context context, @c.b int i7) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i7) : k(context, context.getResources(), context.getTheme(), i7);
    }

    public static Animator k(Context context, Resources resources, Resources.Theme theme, @c.b int i7) throws Resources.NotFoundException {
        return l(context, resources, theme, i7, 1.0f);
    }

    public static Animator l(Context context, Resources resources, Resources.Theme theme, @c.b int i7, float f8) throws Resources.NotFoundException {
        XmlResourceParser animation = null;
        try {
            try {
                try {
                    animation = resources.getAnimation(i7);
                    Animator animatorA = a(context, resources, theme, animation, f8);
                    if (animation != null) {
                        animation.close();
                    }
                    return animatorA;
                } catch (XmlPullParserException e8) {
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i7));
                    notFoundException.initCause(e8);
                    throw notFoundException;
                }
            } catch (IOException e9) {
                Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i7));
                notFoundException2.initCause(e9);
                throw notFoundException2;
            }
        } catch (Throwable th) {
            if (animation != null) {
                animation.close();
            }
            throw th;
        }
    }

    private static ValueAnimator m(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f8, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        TypedArray typedArrayS = q.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.R);
        TypedArray typedArrayS2 = q.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f10860m0);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        r(valueAnimator, typedArrayS, typedArrayS2, f8, xmlPullParser);
        int iL = q.l(typedArrayS, xmlPullParser, "interpolator", 0, 0);
        if (iL > 0) {
            valueAnimator.setInterpolator(d.b(context, iL));
        }
        typedArrayS.recycle();
        if (typedArrayS2 != null) {
            typedArrayS2.recycle();
        }
        return valueAnimator;
    }

    private static Keyframe n(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i7, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Keyframe keyframeOfFloat;
        TypedArray typedArrayS = q.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f10850h0);
        float fJ = q.j(typedArrayS, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue typedValueT = q.t(typedArrayS, xmlPullParser, "value", 0);
        boolean z7 = typedValueT != null;
        if (i7 == 4) {
            i7 = (z7 && i(typedValueT.type)) ? 3 : 0;
        }
        if (!z7) {
            keyframeOfFloat = i7 == 0 ? Keyframe.ofFloat(fJ) : Keyframe.ofInt(fJ);
        } else if (i7 != 0) {
            keyframeOfFloat = (i7 == 1 || i7 == 3) ? Keyframe.ofInt(fJ, q.k(typedArrayS, xmlPullParser, "value", 0, 0)) : null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(fJ, q.j(typedArrayS, xmlPullParser, "value", 0, 0.0f));
        }
        int iL = q.l(typedArrayS, xmlPullParser, "interpolator", 1, 0);
        if (iL > 0) {
            keyframeOfFloat.setInterpolator(d.b(context, iL));
        }
        typedArrayS.recycle();
        return keyframeOfFloat;
    }

    private static ObjectAnimator o(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f8, XmlPullParser xmlPullParser) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        m(context, resources, theme, attributeSet, objectAnimator, f8, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder p(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i7) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolderOfKeyframe = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (i7 == 4) {
                    i7 = h(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe keyframeN = n(context, resources, theme, Xml.asAttributeSet(xmlPullParser), i7, xmlPullParser);
                if (keyframeN != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(keyframeN);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), c(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, c(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i8 = 0; i8 < size; i8++) {
                Keyframe keyframe3 = keyframeArr[i8];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i8 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i9 = size - 1;
                        if (i8 == i9) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i10 = i8;
                            for (int i11 = i8 + 1; i11 < i9 && keyframeArr[i11].getFraction() < 0.0f; i11++) {
                                i10 = i11;
                            }
                            d(keyframeArr, keyframeArr[i10 + 1].getFraction() - keyframeArr[i8 - 1].getFraction(), i8, i10);
                        }
                    }
                }
            }
            propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (i7 == 3) {
                propertyValuesHolderOfKeyframe.setEvaluator(f.a());
            }
        }
        return propertyValuesHolderOfKeyframe;
    }

    private static PropertyValuesHolder[] q(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i7;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType != 2) {
                xmlPullParser.next();
            } else {
                if (xmlPullParser.getName().equals("propertyValuesHolder")) {
                    TypedArray typedArrayS = q.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f10840c0);
                    String strM = q.m(typedArrayS, xmlPullParser, "propertyName", 3);
                    int iK = q.k(typedArrayS, xmlPullParser, "valueType", 2, 4);
                    PropertyValuesHolder propertyValuesHolderP = p(context, resources, theme, xmlPullParser, strM, iK);
                    if (propertyValuesHolderP == null) {
                        propertyValuesHolderP = f(typedArrayS, iK, 0, 1, strM);
                    }
                    if (propertyValuesHolderP != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(propertyValuesHolderP);
                    }
                    typedArrayS.recycle();
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i7 = 0; i7 < size; i7++) {
                propertyValuesHolderArr[i7] = (PropertyValuesHolder) arrayList.get(i7);
            }
        }
        return propertyValuesHolderArr;
    }

    private static void r(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f8, XmlPullParser xmlPullParser) {
        long jK = q.k(typedArray, xmlPullParser, w.h.f3144b, 1, 300);
        long jK2 = q.k(typedArray, xmlPullParser, "startOffset", 2, 0);
        int iK = q.k(typedArray, xmlPullParser, "valueType", 7, 4);
        if (q.r(xmlPullParser, "valueFrom") && q.r(xmlPullParser, "valueTo")) {
            if (iK == 4) {
                iK = g(typedArray, 5, 6);
            }
            PropertyValuesHolder propertyValuesHolderF = f(typedArray, iK, 5, 6, "");
            if (propertyValuesHolderF != null) {
                valueAnimator.setValues(propertyValuesHolderF);
            }
        }
        valueAnimator.setDuration(jK);
        valueAnimator.setStartDelay(jK2);
        valueAnimator.setRepeatCount(q.k(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(q.k(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            s(valueAnimator, typedArray2, iK, f8, xmlPullParser);
        }
    }

    private static void s(ValueAnimator valueAnimator, TypedArray typedArray, int i7, float f8, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String strM = q.m(typedArray, xmlPullParser, "pathData", 1);
        if (strM == null) {
            objectAnimator.setPropertyName(q.m(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        String strM2 = q.m(typedArray, xmlPullParser, "propertyXName", 2);
        String strM3 = q.m(typedArray, xmlPullParser, "propertyYName", 3);
        if (i7 != 2) {
        }
        if (strM2 != null || strM3 != null) {
            t(g2.e(strM), objectAnimator, f8 * 0.5f, strM2, strM3);
            return;
        }
        throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    private static void t(Path path, ObjectAnimator objectAnimator, float f8, String str, String str2) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        float f9 = 0.0f;
        arrayList.add(Float.valueOf(0.0f));
        float length = 0.0f;
        do {
            length += pathMeasure.getLength();
            arrayList.add(Float.valueOf(length));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int iMin = Math.min(100, ((int) (length / f8)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        float f10 = length / (iMin - 1);
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i7 >= iMin) {
                break;
            }
            pathMeasure2.getPosTan(f9 - ((Float) arrayList.get(i8)).floatValue(), fArr3, null);
            fArr[i7] = fArr3[0];
            fArr2[i7] = fArr3[1];
            f9 += f10;
            int i9 = i8 + 1;
            if (i9 < arrayList.size() && f9 > ((Float) arrayList.get(i9)).floatValue()) {
                pathMeasure2.nextContour();
                i8 = i9;
            }
            i7++;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (propertyValuesHolderOfFloat == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat2);
        } else if (propertyValuesHolderOfFloat2 == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat);
        } else {
            objectAnimator.setValues(propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        }
    }
}
