package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.view.n2;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
class b0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f1722l = "ACTVAutoSizeHelper";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f1724n = 12;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f1725o = 112;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f1726p = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final float f1729s = -1.0f;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f1730t = 1048576;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1731a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1732b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f1733c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f1734d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f1735e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f1736f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1737g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextPaint f1738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @c.m0
    private final TextView f1739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f1740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final f f1741k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final RectF f1723m = new RectF();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Method> f1727q = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    private static ConcurrentHashMap<String, Field> f1728r = new ConcurrentHashMap<>();

    @c.t0(16)
    private static final class a {
        private a() {
        }

        @c.m0
        @c.t
        static StaticLayout a(@c.m0 CharSequence charSequence, @c.m0 Layout.Alignment alignment, int i7, @c.m0 TextView textView, @c.m0 TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i7, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        @c.t
        static int b(@c.m0 TextView textView) {
            return textView.getMaxLines();
        }
    }

    @c.t0(18)
    private static final class b {
        private b() {
        }

        @c.t
        static boolean a(@c.m0 View view) {
            return view.isInLayout();
        }
    }

    @c.t0(23)
    private static final class c {
        private c() {
        }

        @c.m0
        @c.t
        static StaticLayout a(@c.m0 CharSequence charSequence, @c.m0 Layout.Alignment alignment, int i7, int i8, @c.m0 TextView textView, @c.m0 TextPaint textPaint, @c.m0 f fVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i7);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i8 == -1) {
                i8 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i8);
            try {
                fVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w(b0.f1722l, "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    @c.t0(23)
    private static class d extends f {
        d() {
        }

        @Override // androidx.appcompat.widget.b0.f
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) b0.p(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    @c.t0(29)
    private static class e extends d {
        e() {
        }

        @Override // androidx.appcompat.widget.b0.d, androidx.appcompat.widget.b0.f
        void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.b0.f
        boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    private static class f {
        f() {
        }

        void a(StaticLayout.Builder builder, TextView textView) {
        }

        boolean b(TextView textView) {
            return ((Boolean) b0.p(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    b0(@c.m0 TextView textView) {
        this.f1739i = textView;
        this.f1740j = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.f1741k = new e();
        } else {
            this.f1741k = new d();
        }
    }

    private boolean A(int i7, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1739i.getText();
        TransformationMethod transformationMethod = this.f1739i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1739i)) != null) {
            text = transformation;
        }
        int iB = a.b(this.f1739i);
        o(i7);
        StaticLayout staticLayoutE = e(text, (Layout.Alignment) p(this.f1739i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), iB);
        return (iB == -1 || (staticLayoutE.getLineCount() <= iB && staticLayoutE.getLineEnd(staticLayoutE.getLineCount() - 1) == text.length())) && ((float) staticLayoutE.getHeight()) <= rectF.bottom;
    }

    private boolean B() {
        return !(this.f1739i instanceof AppCompatEditText);
    }

    private void C(float f8, float f9, float f10) throws IllegalArgumentException {
        if (f8 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f8 + "px) is less or equal to (0px)");
        }
        if (f9 <= f8) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f9 + "px) is less or equal to minimum auto-size text size (" + f8 + "px)");
        }
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f10 + "px) is less or equal to (0px)");
        }
        this.f1731a = 1;
        this.f1734d = f8;
        this.f1735e = f9;
        this.f1733c = f10;
        this.f1737g = false;
    }

    private static <T> T a(@c.m0 Object obj, @c.m0 String str, @c.m0 T t7) {
        try {
            Field fieldM = m(str);
            return fieldM == null ? t7 : (T) fieldM.get(obj);
        } catch (IllegalAccessException e8) {
            Log.w(f1722l, "Failed to access TextView#" + str + " member", e8);
            return t7;
        }
    }

    private int[] c(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i7 : iArr) {
            if (i7 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i7)) < 0) {
                arrayList.add(Integer.valueOf(i7));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i8 = 0; i8 < size; i8++) {
            iArr2[i8] = ((Integer) arrayList.get(i8)).intValue();
        }
        return iArr2;
    }

    private void d() {
        this.f1731a = 0;
        this.f1734d = -1.0f;
        this.f1735e = -1.0f;
        this.f1733c = -1.0f;
        this.f1736f = new int[0];
        this.f1732b = false;
    }

    private StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i7) {
        return new StaticLayout(charSequence, this.f1738h, i7, alignment, ((Float) a(this.f1739i, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.f1739i, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) a(this.f1739i, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    private int g(RectF rectF) {
        int length = this.f1736f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i7 = 1;
        int i8 = length - 1;
        int i9 = 0;
        while (i7 <= i8) {
            int i10 = (i7 + i8) / 2;
            if (A(this.f1736f[i10], rectF)) {
                int i11 = i10 + 1;
                i9 = i7;
                i7 = i11;
            } else {
                i9 = i10 - 1;
                i8 = i9;
            }
        }
        return this.f1736f[i9];
    }

    @c.o0
    private static Field m(@c.m0 String str) {
        try {
            Field declaredField = f1728r.get(str);
            if (declaredField == null && (declaredField = TextView.class.getDeclaredField(str)) != null) {
                declaredField.setAccessible(true);
                f1728r.put(str, declaredField);
            }
            return declaredField;
        } catch (NoSuchFieldException e8) {
            Log.w(f1722l, "Failed to access TextView#" + str + " member", e8);
            return null;
        }
    }

    @c.o0
    private static Method n(@c.m0 String str) {
        try {
            Method declaredMethod = f1727q.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f1727q.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e8) {
            Log.w(f1722l, "Failed to retrieve TextView#" + str + "() method", e8);
            return null;
        }
    }

    static <T> T p(@c.m0 Object obj, @c.m0 String str, @c.m0 T t7) {
        try {
            return (T) n(str).invoke(obj, new Object[0]);
        } catch (Exception e8) {
            Log.w(f1722l, "Failed to invoke TextView#" + str + "() method", e8);
            return t7;
        }
    }

    private void v(float f8) {
        if (f8 != this.f1739i.getPaint().getTextSize()) {
            this.f1739i.getPaint().setTextSize(f8);
            boolean zA = b.a(this.f1739i);
            if (this.f1739i.getLayout() != null) {
                this.f1732b = false;
                try {
                    Method methodN = n("nullLayouts");
                    if (methodN != null) {
                        methodN.invoke(this.f1739i, new Object[0]);
                    }
                } catch (Exception e8) {
                    Log.w(f1722l, "Failed to invoke TextView#nullLayouts() method", e8);
                }
                if (zA) {
                    this.f1739i.forceLayout();
                } else {
                    this.f1739i.requestLayout();
                }
                this.f1739i.invalidate();
            }
        }
    }

    private boolean x() {
        if (B() && this.f1731a == 1) {
            if (!this.f1737g || this.f1736f.length == 0) {
                int iFloor = ((int) Math.floor((this.f1735e - this.f1734d) / this.f1733c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i7 = 0; i7 < iFloor; i7++) {
                    iArr[i7] = Math.round(this.f1734d + (i7 * this.f1733c));
                }
                this.f1736f = c(iArr);
            }
            this.f1732b = true;
        } else {
            this.f1732b = false;
        }
        return this.f1732b;
    }

    private void y(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i7 = 0; i7 < length; i7++) {
                iArr[i7] = typedArray.getDimensionPixelSize(i7, -1);
            }
            this.f1736f = c(iArr);
            z();
        }
    }

    private boolean z() {
        int[] iArr = this.f1736f;
        int length = iArr.length;
        boolean z7 = length > 0;
        this.f1737g = z7;
        if (z7) {
            this.f1731a = 1;
            this.f1734d = iArr[0];
            this.f1735e = iArr[length - 1];
            this.f1733c = -1.0f;
        }
        return z7;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    void b() {
        if (q()) {
            if (this.f1732b) {
                if (this.f1739i.getMeasuredHeight() <= 0 || this.f1739i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f1741k.b(this.f1739i) ? 1048576 : (this.f1739i.getMeasuredWidth() - this.f1739i.getTotalPaddingLeft()) - this.f1739i.getTotalPaddingRight();
                int height = (this.f1739i.getHeight() - this.f1739i.getCompoundPaddingBottom()) - this.f1739i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f1723m;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float fG = g(rectF);
                    if (fG != this.f1739i.getTextSize()) {
                        w(0, fG);
                    }
                }
            }
            this.f1732b = true;
        }
    }

    @c.m0
    @c.g1
    StaticLayout e(@c.m0 CharSequence charSequence, @c.m0 Layout.Alignment alignment, int i7, int i8) {
        return c.a(charSequence, alignment, i7, i8, this.f1739i, this.f1738h, this.f1741k);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    int h() {
        return Math.round(this.f1735e);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    int i() {
        return Math.round(this.f1734d);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    int j() {
        return Math.round(this.f1733c);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    int[] k() {
        return this.f1736f;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    int l() {
        return this.f1731a;
    }

    @c.g1
    void o(int i7) {
        TextPaint textPaint = this.f1738h;
        if (textPaint == null) {
            this.f1738h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1738h.set(this.f1739i.getPaint());
        this.f1738h.setTextSize(i7);
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    boolean q() {
        return B() && this.f1731a != 0;
    }

    void r(@c.o0 AttributeSet attributeSet, int i7) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f1740j.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i7, 0);
        TextView textView = this.f1739i;
        n2.z1(textView, textView.getContext(), R.styleable.AppCompatTextView, attributeSet, typedArrayObtainStyledAttributes, i7, 0);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.f1731a = typedArrayObtainStyledAttributes.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            y(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!B()) {
            this.f1731a = 0;
            return;
        }
        if (this.f1731a == 1) {
            if (!this.f1737g) {
                DisplayMetrics displayMetrics = this.f1740j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                C(dimension2, dimension3, dimension);
            }
            x();
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    void s(int i7, int i8, int i9, int i10) throws IllegalArgumentException {
        if (B()) {
            DisplayMetrics displayMetrics = this.f1740j.getResources().getDisplayMetrics();
            C(TypedValue.applyDimension(i10, i7, displayMetrics), TypedValue.applyDimension(i10, i8, displayMetrics), TypedValue.applyDimension(i10, i9, displayMetrics));
            if (x()) {
                b();
            }
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    void t(@c.m0 int[] iArr, int i7) throws IllegalArgumentException {
        if (B()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i7 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1740j.getResources().getDisplayMetrics();
                    for (int i8 = 0; i8 < length; i8++) {
                        iArrCopyOf[i8] = Math.round(TypedValue.applyDimension(i7, iArr[i8], displayMetrics));
                    }
                }
                this.f1736f = c(iArrCopyOf);
                if (!z()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1737g = false;
            }
            if (x()) {
                b();
            }
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    void u(int i7) {
        if (B()) {
            if (i7 == 0) {
                d();
                return;
            }
            if (i7 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i7);
            }
            DisplayMetrics displayMetrics = this.f1740j.getResources().getDisplayMetrics();
            C(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (x()) {
                b();
            }
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    void w(int i7, float f8) {
        Context context = this.f1740j;
        v(TypedValue.applyDimension(i7, f8, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }
}
