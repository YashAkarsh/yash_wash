package androidx.core.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.os.r0;
import c.f1;
import c.t0;
import c.x0;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class i0 implements Spannable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char f6262e = '\n';

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f6263f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c.z("sLock")
    @c.m0
    private static Executor f6264g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    private final Spannable f6265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.m0
    private final a f6266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.m0
    private final int[] f6267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    private final PrecomputedText f6268d;

    private static class b extends FutureTask<i0> {

        private static class a implements Callable<i0> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private a f6278a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private CharSequence f6279b;

            a(@c.m0 a aVar, @c.m0 CharSequence charSequence) {
                this.f6278a = aVar;
                this.f6279b = charSequence;
            }

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public i0 call() throws Exception {
                return i0.a(this.f6279b, this.f6278a);
            }
        }

        b(@c.m0 a aVar, @c.m0 CharSequence charSequence) {
            super(new a(aVar, charSequence));
        }
    }

    private i0(@c.m0 CharSequence charSequence, @c.m0 a aVar, @c.m0 int[] iArr) {
        this.f6265a = new SpannableString(charSequence);
        this.f6266b = aVar;
        this.f6267c = iArr;
        this.f6268d = null;
    }

    @SuppressLint({"WrongConstant"})
    public static i0 a(@c.m0 CharSequence charSequence, @c.m0 a aVar) {
        PrecomputedText.Params params;
        androidx.core.util.w.l(charSequence);
        androidx.core.util.w.l(aVar);
        try {
            r0.b("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && (params = aVar.f6273e) != null) {
                return new i0(PrecomputedText.create(charSequence, params), aVar);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i7 = 0;
            while (i7 < length) {
                int iIndexOf = TextUtils.indexOf(charSequence, '\n', i7, length);
                i7 = iIndexOf < 0 ? length : iIndexOf + 1;
                arrayList.add(Integer.valueOf(i7));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                iArr[i8] = ((Integer) arrayList.get(i8)).intValue();
            }
            StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), aVar.e(), Integer.MAX_VALUE).setBreakStrategy(aVar.b()).setHyphenationFrequency(aVar.c()).setTextDirection(aVar.d()).build();
            return new i0(charSequence, aVar, iArr);
        } finally {
            r0.d();
        }
    }

    @f1
    public static Future<i0> g(@c.m0 CharSequence charSequence, @c.m0 a aVar, @c.o0 Executor executor) {
        b bVar = new b(aVar, charSequence);
        if (executor == null) {
            synchronized (f6263f) {
                if (f6264g == null) {
                    f6264g = Executors.newFixedThreadPool(1);
                }
                executor = f6264g;
            }
        }
        executor.execute(bVar);
        return bVar;
    }

    @c.e0(from = 0)
    public int b() {
        return Build.VERSION.SDK_INT >= 29 ? this.f6268d.getParagraphCount() : this.f6267c.length;
    }

    @c.e0(from = 0)
    public int c(@c.e0(from = 0) int i7) {
        androidx.core.util.w.g(i7, 0, b(), "paraIndex");
        return Build.VERSION.SDK_INT >= 29 ? this.f6268d.getParagraphEnd(i7) : this.f6267c[i7];
    }

    @Override // java.lang.CharSequence
    public char charAt(int i7) {
        return this.f6265a.charAt(i7);
    }

    @c.e0(from = 0)
    public int d(@c.e0(from = 0) int i7) {
        androidx.core.util.w.g(i7, 0, b(), "paraIndex");
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f6268d.getParagraphStart(i7);
        }
        if (i7 == 0) {
            return 0;
        }
        return this.f6267c[i7 - 1];
    }

    @c.m0
    public a e() {
        return this.f6266b;
    }

    @c.o0
    @t0(28)
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public PrecomputedText f() {
        if (n.a(this.f6265a)) {
            return o.a(this.f6265a);
        }
        return null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f6265a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f6265a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f6265a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i7, int i8, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? (T[]) this.f6268d.getSpans(i7, i8, cls) : (T[]) this.f6265a.getSpans(i7, i8, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f6265a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i7, int i8, Class cls) {
        return this.f6265a.nextSpanTransition(i7, i8, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6268d.removeSpan(obj);
        } else {
            this.f6265a.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i7, int i8, int i9) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6268d.setSpan(obj, i7, i8, i9);
        } else {
            this.f6265a.setSpan(obj, i7, i8, i9);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i7, int i8) {
        return this.f6265a.subSequence(i7, i8);
    }

    @Override // java.lang.CharSequence
    @c.m0
    public String toString() {
        return this.f6265a.toString();
    }

    @t0(28)
    private i0(@c.m0 PrecomputedText precomputedText, @c.m0 a aVar) {
        this.f6265a = precomputedText;
        this.f6266b = aVar;
        this.f6267c = null;
        this.f6268d = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.m0
        private final TextPaint f6269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @c.o0
        private final TextDirectionHeuristic f6270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f6271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f6272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f6273e;

        /* JADX INFO: renamed from: androidx.core.text.i0$a$a, reason: collision with other inner class name */
        public static class C0073a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @c.m0
            private final TextPaint f6274a;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f6276c = 1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f6277d = 1;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private TextDirectionHeuristic f6275b = TextDirectionHeuristics.FIRSTSTRONG_LTR;

            public C0073a(@c.m0 TextPaint textPaint) {
                this.f6274a = textPaint;
            }

            @c.m0
            public a a() {
                return new a(this.f6274a, this.f6275b, this.f6276c, this.f6277d);
            }

            @t0(23)
            public C0073a b(int i7) {
                this.f6276c = i7;
                return this;
            }

            @t0(23)
            public C0073a c(int i7) {
                this.f6277d = i7;
                return this;
            }

            @t0(18)
            public C0073a d(@c.m0 TextDirectionHeuristic textDirectionHeuristic) {
                this.f6275b = textDirectionHeuristic;
                return this;
            }
        }

        a(@c.m0 TextPaint textPaint, @c.m0 TextDirectionHeuristic textDirectionHeuristic, int i7, int i8) {
            if (Build.VERSION.SDK_INT >= 29) {
                y.a();
                this.f6273e = x.a(textPaint).setBreakStrategy(i7).setHyphenationFrequency(i8).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f6273e = null;
            }
            this.f6269a = textPaint;
            this.f6270b = textDirectionHeuristic;
            this.f6271c = i7;
            this.f6272d = i8;
        }

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        public boolean a(@c.m0 a aVar) {
            int i7 = Build.VERSION.SDK_INT;
            if (this.f6271c != aVar.b() || this.f6272d != aVar.c() || this.f6269a.getTextSize() != aVar.e().getTextSize() || this.f6269a.getTextScaleX() != aVar.e().getTextScaleX() || this.f6269a.getTextSkewX() != aVar.e().getTextSkewX() || this.f6269a.getLetterSpacing() != aVar.e().getLetterSpacing() || !TextUtils.equals(this.f6269a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings()) || this.f6269a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i7 >= 24) {
                if (!this.f6269a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else if (!this.f6269a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            if (this.f6269a.getTypeface() == null) {
                return aVar.e().getTypeface() == null;
            }
            return this.f6269a.getTypeface().equals(aVar.e().getTypeface());
        }

        @t0(23)
        public int b() {
            return this.f6271c;
        }

        @t0(23)
        public int c() {
            return this.f6272d;
        }

        @c.o0
        @t0(18)
        public TextDirectionHeuristic d() {
            return this.f6270b;
        }

        @c.m0
        public TextPaint e() {
            return this.f6269a;
        }

        public boolean equals(@c.o0 Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f6270b == aVar.d();
        }

        public int hashCode() {
            return Build.VERSION.SDK_INT >= 24 ? androidx.core.util.r.b(Float.valueOf(this.f6269a.getTextSize()), Float.valueOf(this.f6269a.getTextScaleX()), Float.valueOf(this.f6269a.getTextSkewX()), Float.valueOf(this.f6269a.getLetterSpacing()), Integer.valueOf(this.f6269a.getFlags()), this.f6269a.getTextLocales(), this.f6269a.getTypeface(), Boolean.valueOf(this.f6269a.isElegantTextHeight()), this.f6270b, Integer.valueOf(this.f6271c), Integer.valueOf(this.f6272d)) : androidx.core.util.r.b(Float.valueOf(this.f6269a.getTextSize()), Float.valueOf(this.f6269a.getTextScaleX()), Float.valueOf(this.f6269a.getTextSkewX()), Float.valueOf(this.f6269a.getLetterSpacing()), Integer.valueOf(this.f6269a.getFlags()), this.f6269a.getTextLocale(), this.f6269a.getTypeface(), Boolean.valueOf(this.f6269a.isElegantTextHeight()), this.f6270b, Integer.valueOf(this.f6271c), Integer.valueOf(this.f6272d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f6269a.getTextSize());
            sb.append(", textScaleX=" + this.f6269a.getTextScaleX());
            sb.append(", textSkewX=" + this.f6269a.getTextSkewX());
            int i7 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.f6269a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f6269a.isElegantTextHeight());
            if (i7 >= 24) {
                sb.append(", textLocale=" + this.f6269a.getTextLocales());
            } else {
                sb.append(", textLocale=" + this.f6269a.getTextLocale());
            }
            sb.append(", typeface=" + this.f6269a.getTypeface());
            if (i7 >= 26) {
                sb.append(", variationSettings=" + this.f6269a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f6270b);
            sb.append(", breakStrategy=" + this.f6271c);
            sb.append(", hyphenationFrequency=" + this.f6272d);
            sb.append(com.alipay.sdk.util.j.f13808d);
            return sb.toString();
        }

        @t0(28)
        public a(@c.m0 PrecomputedText.Params params) {
            this.f6269a = params.getTextPaint();
            this.f6270b = params.getTextDirection();
            this.f6271c = params.getBreakStrategy();
            this.f6272d = params.getHyphenationFrequency();
            this.f6273e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
