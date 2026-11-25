package com.google.android.material.internal;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import c.e0;
import c.m0;
import c.o0;
import c.x0;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
final class j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f17852n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final float f17853o = 0.0f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final float f17854p = 1.0f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f17855q = "android.text.TextDirectionHeuristic";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f17856r = "android.text.TextDirectionHeuristics";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f17857s = "LTR";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f17858t = "RTL";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static boolean f17859u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @o0
    private static Constructor<StaticLayout> f17860v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @o0
    private static Object f17861w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f17862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextPaint f17863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17864c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f17866e;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17873l;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f17865d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Layout.Alignment f17867f = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f17868g = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f17869h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f17870i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f17871j = f17852n;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f17872k = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @o0
    private TextUtils.TruncateAt f17874m = null;

    static class a extends Exception {
        a(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    private j(CharSequence charSequence, TextPaint textPaint, int i7) {
        this.f17862a = charSequence;
        this.f17863b = textPaint;
        this.f17864c = i7;
        this.f17866e = charSequence.length();
    }

    private void b() throws a {
        if (f17859u) {
            return;
        }
        try {
            f17861w = this.f17873l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            f17860v = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f17859u = true;
        } catch (Exception e8) {
            throw new a(e8);
        }
    }

    @m0
    public static j c(@m0 CharSequence charSequence, @m0 TextPaint textPaint, @e0(from = 0) int i7) {
        return new j(charSequence, textPaint, i7);
    }

    public StaticLayout a() throws a {
        if (this.f17862a == null) {
            this.f17862a = "";
        }
        int iMax = Math.max(0, this.f17864c);
        CharSequence charSequenceEllipsize = this.f17862a;
        if (this.f17868g == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f17863b, iMax, this.f17874m);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f17866e);
        this.f17866e = iMin;
        if (this.f17873l && this.f17868g == 1) {
            this.f17867f = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.f17865d, iMin, this.f17863b, iMax);
        builderObtain.setAlignment(this.f17867f);
        builderObtain.setIncludePad(this.f17872k);
        builderObtain.setTextDirection(this.f17873l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f17874m;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.f17868g);
        float f8 = this.f17869h;
        if (f8 != 0.0f || this.f17870i != 1.0f) {
            builderObtain.setLineSpacing(f8, this.f17870i);
        }
        if (this.f17868g > 1) {
            builderObtain.setHyphenationFrequency(this.f17871j);
        }
        return builderObtain.build();
    }

    @m0
    public j d(@m0 Layout.Alignment alignment) {
        this.f17867f = alignment;
        return this;
    }

    @m0
    public j e(@o0 TextUtils.TruncateAt truncateAt) {
        this.f17874m = truncateAt;
        return this;
    }

    @m0
    public j f(@e0(from = 0) int i7) {
        this.f17866e = i7;
        return this;
    }

    @m0
    public j g(int i7) {
        this.f17871j = i7;
        return this;
    }

    @m0
    public j h(boolean z7) {
        this.f17872k = z7;
        return this;
    }

    public j i(boolean z7) {
        this.f17873l = z7;
        return this;
    }

    @m0
    public j j(float f8, float f9) {
        this.f17869h = f8;
        this.f17870i = f9;
        return this;
    }

    @m0
    public j k(@e0(from = 0) int i7) {
        this.f17868g = i7;
        return this;
    }

    @m0
    public j l(@e0(from = 0) int i7) {
        this.f17865d = i7;
        return this;
    }
}
