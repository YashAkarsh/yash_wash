package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import c.o0;
import com.airbnb.lottie.animation.content.s;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p implements com.airbnb.lottie.model.content.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private final com.airbnb.lottie.model.animatable.b f12049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<com.airbnb.lottie.model.animatable.b> f12050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.a f12051d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.d f12052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.model.animatable.b f12053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f12054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c f12055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f12056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f12057j;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12059b;

        static {
            int[] iArr = new int[c.values().length];
            f12059b = iArr;
            try {
                iArr[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12059b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12059b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            f12058a = iArr2;
            try {
                iArr2[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12058a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12058a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap a() {
            int i7 = a.f12058a[ordinal()];
            if (i7 != 1) {
                return i7 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join a() {
            int i7 = a.f12059b[ordinal()];
            if (i7 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i7 == 2) {
                return Paint.Join.MITER;
            }
            if (i7 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public p(String str, @o0 com.airbnb.lottie.model.animatable.b bVar, List<com.airbnb.lottie.model.animatable.b> list, com.airbnb.lottie.model.animatable.a aVar, com.airbnb.lottie.model.animatable.d dVar, com.airbnb.lottie.model.animatable.b bVar2, b bVar3, c cVar, float f8, boolean z7) {
        this.f12048a = str;
        this.f12049b = bVar;
        this.f12050c = list;
        this.f12051d = aVar;
        this.f12052e = dVar;
        this.f12053f = bVar2;
        this.f12054g = bVar3;
        this.f12055h = cVar;
        this.f12056i = f8;
        this.f12057j = z7;
    }

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.animation.content.c a(com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new s(hVar, aVar, this);
    }

    public b b() {
        return this.f12054g;
    }

    public com.airbnb.lottie.model.animatable.a c() {
        return this.f12051d;
    }

    public com.airbnb.lottie.model.animatable.b d() {
        return this.f12049b;
    }

    public c e() {
        return this.f12055h;
    }

    public List<com.airbnb.lottie.model.animatable.b> f() {
        return this.f12050c;
    }

    public float g() {
        return this.f12056i;
    }

    public String h() {
        return this.f12048a;
    }

    public com.airbnb.lottie.model.animatable.d i() {
        return this.f12052e;
    }

    public com.airbnb.lottie.model.animatable.b j() {
        return this.f12053f;
    }

    public boolean k() {
        return this.f12057j;
    }
}
