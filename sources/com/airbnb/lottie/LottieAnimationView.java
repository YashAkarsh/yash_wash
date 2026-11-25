package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.n2;
import c.j0;
import c.m0;
import c.o0;
import c.s0;
import c.v;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f11534v = "LottieAnimationView";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final j<Throwable> f11535w = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j<f> f11536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final j<Throwable> f11537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private j<Throwable> f11538f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c.u
    private int f11539g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final h f11540h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11541i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f11542j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @s0
    private int f11543k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f11544l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f11545m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f11546n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f11547o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f11548p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private s f11549q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Set<l> f11550r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f11551s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @o0
    private o<f> f11552t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @o0
    private f f11553u;

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f11554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f11555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f11556c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11557d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f11558e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f11559f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f11560g;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeString(this.f11554a);
            parcel.writeFloat(this.f11556c);
            parcel.writeInt(this.f11557d ? 1 : 0);
            parcel.writeString(this.f11558e);
            parcel.writeInt(this.f11559f);
            parcel.writeInt(this.f11560g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f11554a = parcel.readString();
            this.f11556c = parcel.readFloat();
            this.f11557d = parcel.readInt() == 1;
            this.f11558e = parcel.readString();
            this.f11559f = parcel.readInt();
            this.f11560g = parcel.readInt();
        }
    }

    class a implements j<Throwable> {
        a() {
        }

        @Override // com.airbnb.lottie.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (!com.airbnb.lottie.utils.j.k(th)) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
            com.airbnb.lottie.utils.f.f("Unable to load composition.", th);
        }
    }

    class b implements j<f> {
        b() {
        }

        @Override // com.airbnb.lottie.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(f fVar) {
            LottieAnimationView.this.setComposition(fVar);
        }
    }

    class c implements j<Throwable> {
        c() {
        }

        @Override // com.airbnb.lottie.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Throwable th) {
            if (LottieAnimationView.this.f11539g != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f11539g);
            }
            (LottieAnimationView.this.f11538f == null ? LottieAnimationView.f11535w : LottieAnimationView.this.f11538f).onResult(th);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class d<T> extends com.airbnb.lottie.value.j<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.value.l f11563d;

        d(com.airbnb.lottie.value.l lVar) {
            this.f11563d = lVar;
        }

        @Override // com.airbnb.lottie.value.j
        public T a(com.airbnb.lottie.value.b<T> bVar) {
            return (T) this.f11563d.a(bVar);
        }
    }

    static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11565a;

        static {
            int[] iArr = new int[s.values().length];
            f11565a = iArr;
            try {
                iArr[s.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11565a[s.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11565a[s.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.f11536d = new b();
        this.f11537e = new c();
        this.f11539g = 0;
        this.f11540h = new h();
        this.f11544l = false;
        this.f11545m = false;
        this.f11546n = false;
        this.f11547o = false;
        this.f11548p = true;
        this.f11549q = s.AUTOMATIC;
        this.f11550r = new HashSet();
        this.f11551s = 0;
        s(null);
    }

    private void l() {
        o<f> oVar = this.f11552t;
        if (oVar != null) {
            oVar.k(this.f11536d);
            this.f11552t.j(this.f11537e);
        }
    }

    private void m() {
        this.f11553u = null;
        this.f11540h.l();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    private void p() {
        f fVar;
        int i7 = e.f11565a[this.f11549q.ordinal()];
        int i8 = 2;
        if (i7 != 1) {
            if (i7 == 2 || i7 != 3) {
                i8 = 1;
            } else {
                f fVar2 = this.f11553u;
                boolean z7 = false;
                if ((fVar2 == null || !fVar2.r() || Build.VERSION.SDK_INT >= 28) && ((fVar = this.f11553u) == null || fVar.m() <= 4)) {
                    z7 = true;
                }
                if (!z7) {
                    i8 = 1;
                }
            }
        }
        if (i8 != getLayerType()) {
            setLayerType(i8, null);
        }
    }

    private void s(@o0 AttributeSet attributeSet) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.LottieAnimationView);
        if (!isInEditMode()) {
            this.f11548p = typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_cacheComposition, true);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_rawRes);
            boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_fileName);
            boolean zHasValue3 = typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_url);
            if (zHasValue && zHasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
            if (zHasValue) {
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (zHasValue2) {
                String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_fileName);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (zHasValue3 && (string = typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_url)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(typedArrayObtainStyledAttributes.getResourceId(R.styleable.LottieAnimationView_lottie_fallbackRes, 0));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_autoPlay, false)) {
            this.f11546n = true;
            this.f11547o = true;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_loop, false)) {
            this.f11540h.t0(-1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(typedArrayObtainStyledAttributes.getInt(R.styleable.LottieAnimationView_lottie_repeatCount, -1));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_speed)) {
            setSpeed(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_speed, 1.0f));
        }
        setImageAssetsFolder(typedArrayObtainStyledAttributes.getString(R.styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_progress, 0.0f));
        o(typedArrayObtainStyledAttributes.getBoolean(R.styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_colorFilter)) {
            i(new com.airbnb.lottie.model.e("**"), m.C, new com.airbnb.lottie.value.j(new t(typedArrayObtainStyledAttributes.getColor(R.styleable.LottieAnimationView_lottie_colorFilter, 0))));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_scale)) {
            this.f11540h.w0(typedArrayObtainStyledAttributes.getFloat(R.styleable.LottieAnimationView_lottie_scale, 1.0f));
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.LottieAnimationView_lottie_renderMode)) {
            int i7 = R.styleable.LottieAnimationView_lottie_renderMode;
            s sVar = s.AUTOMATIC;
            int iOrdinal = typedArrayObtainStyledAttributes.getInt(i7, sVar.ordinal());
            if (iOrdinal >= s.values().length) {
                iOrdinal = sVar.ordinal();
            }
            setRenderMode(s.values()[iOrdinal]);
        }
        if (getScaleType() != null) {
            this.f11540h.x0(getScaleType());
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f11540h.z0(Boolean.valueOf(com.airbnb.lottie.utils.j.f(getContext()) != 0.0f));
        p();
        this.f11541i = true;
    }

    private void setCompositionTask(o<f> oVar) {
        m();
        l();
        this.f11552t = oVar.f(this.f11536d).e(this.f11537e);
    }

    public void A() {
        this.f11540h.V();
    }

    public void B(Animator.AnimatorListener animatorListener) {
        this.f11540h.W(animatorListener);
    }

    public boolean C(@m0 l lVar) {
        return this.f11550r.remove(lVar);
    }

    public void D(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f11540h.X(animatorUpdateListener);
    }

    public List<com.airbnb.lottie.model.e> E(com.airbnb.lottie.model.e eVar) {
        return this.f11540h.Y(eVar);
    }

    @j0
    public void F() {
        if (isShown()) {
            this.f11540h.Z();
            p();
        } else {
            this.f11544l = false;
            this.f11545m = true;
        }
    }

    public void G() {
        this.f11540h.a0();
    }

    @o0
    public Bitmap H(String str, @o0 Bitmap bitmap) {
        return this.f11540h.B0(str, bitmap);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z7) {
        com.airbnb.lottie.e.a("buildDrawingCache");
        this.f11551s++;
        super.buildDrawingCache(z7);
        if (this.f11551s == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z7) == null) {
            setRenderMode(s.HARDWARE);
        }
        this.f11551s--;
        com.airbnb.lottie.e.b("buildDrawingCache");
    }

    public void f(Animator.AnimatorListener animatorListener) {
        this.f11540h.f(animatorListener);
    }

    public void g(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f11540h.g(animatorUpdateListener);
    }

    @o0
    public f getComposition() {
        return this.f11553u;
    }

    public long getDuration() {
        f fVar = this.f11553u;
        if (fVar != null) {
            return (long) fVar.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f11540h.w();
    }

    @o0
    public String getImageAssetsFolder() {
        return this.f11540h.z();
    }

    public float getMaxFrame() {
        return this.f11540h.A();
    }

    public float getMinFrame() {
        return this.f11540h.C();
    }

    @o0
    public q getPerformanceTracker() {
        return this.f11540h.D();
    }

    @v(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f11540h.E();
    }

    public int getRepeatCount() {
        return this.f11540h.F();
    }

    public int getRepeatMode() {
        return this.f11540h.G();
    }

    public float getScale() {
        return this.f11540h.H();
    }

    public float getSpeed() {
        return this.f11540h.I();
    }

    public boolean h(@m0 l lVar) {
        f fVar = this.f11553u;
        if (fVar != null) {
            lVar.a(fVar);
        }
        return this.f11550r.add(lVar);
    }

    public <T> void i(com.airbnb.lottie.model.e eVar, T t7, com.airbnb.lottie.value.j<T> jVar) {
        this.f11540h.h(eVar, t7, jVar);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@m0 Drawable drawable) {
        Drawable drawable2 = getDrawable();
        h hVar = this.f11540h;
        if (drawable2 == hVar) {
            super.invalidateDrawable(hVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public <T> void j(com.airbnb.lottie.model.e eVar, T t7, com.airbnb.lottie.value.l<T> lVar) {
        this.f11540h.h(eVar, t7, new d(lVar));
    }

    @j0
    public void k() {
        this.f11546n = false;
        this.f11545m = false;
        this.f11544l = false;
        this.f11540h.k();
        p();
    }

    public void n() {
        this.f11540h.m();
    }

    public void o(boolean z7) {
        this.f11540h.q(z7);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f11547o || this.f11546n) {
            x();
            this.f11547o = false;
            this.f11546n = false;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (t()) {
            k();
            this.f11546n = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f11554a;
        this.f11542j = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f11542j);
        }
        int i7 = savedState.f11555b;
        this.f11543k = i7;
        if (i7 != 0) {
            setAnimation(i7);
        }
        setProgress(savedState.f11556c);
        if (savedState.f11557d) {
            x();
        }
        this.f11540h.g0(savedState.f11558e);
        setRepeatMode(savedState.f11559f);
        setRepeatCount(savedState.f11560g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f11554a = this.f11542j;
        savedState.f11555b = this.f11543k;
        savedState.f11556c = this.f11540h.E();
        savedState.f11557d = this.f11540h.N() || (!n2.O0(this) && this.f11546n);
        savedState.f11558e = this.f11540h.z();
        savedState.f11559f = this.f11540h.G();
        savedState.f11560g = this.f11540h.F();
        return savedState;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@m0 View view, int i7) {
        if (this.f11541i) {
            if (!isShown()) {
                if (t()) {
                    w();
                    this.f11545m = true;
                    return;
                }
                return;
            }
            if (this.f11545m) {
                F();
            } else if (this.f11544l) {
                x();
            }
            this.f11545m = false;
            this.f11544l = false;
        }
    }

    public boolean q() {
        return this.f11540h.L();
    }

    public boolean r() {
        return this.f11540h.M();
    }

    public void setAnimation(@s0 int i7) {
        this.f11543k = i7;
        this.f11542j = null;
        setCompositionTask(this.f11548p ? g.s(getContext(), i7) : g.t(getContext(), i7, null));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f11548p ? g.w(getContext(), str) : g.x(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z7) {
        this.f11540h.b0(z7);
    }

    public void setCacheComposition(boolean z7) {
        this.f11548p = z7;
    }

    public void setComposition(@m0 f fVar) {
        if (com.airbnb.lottie.e.f11761a) {
            Log.v(f11534v, "Set Composition \n" + fVar);
        }
        this.f11540h.setCallback(this);
        this.f11553u = fVar;
        boolean zC0 = this.f11540h.c0(fVar);
        p();
        if (getDrawable() != this.f11540h || zC0) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<l> it = this.f11550r.iterator();
            while (it.hasNext()) {
                it.next().a(fVar);
            }
        }
    }

    public void setFailureListener(@o0 j<Throwable> jVar) {
        this.f11538f = jVar;
    }

    public void setFallbackResource(@c.u int i7) {
        this.f11539g = i7;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.c cVar) {
        this.f11540h.d0(cVar);
    }

    public void setFrame(int i7) {
        this.f11540h.e0(i7);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.d dVar) {
        this.f11540h.f0(dVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f11540h.g0(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        l();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        l();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i7) {
        l();
        super.setImageResource(i7);
    }

    public void setMaxFrame(int i7) {
        this.f11540h.h0(i7);
    }

    public void setMaxProgress(@v(from = 0.0d, to = 1.0d) float f8) {
        this.f11540h.j0(f8);
    }

    public void setMinAndMaxFrame(String str) {
        this.f11540h.l0(str);
    }

    public void setMinAndMaxProgress(@v(from = 0.0d, to = 1.0d) float f8, @v(from = 0.0d, to = 1.0d) float f9) {
        this.f11540h.n0(f8, f9);
    }

    public void setMinFrame(int i7) {
        this.f11540h.o0(i7);
    }

    public void setMinProgress(float f8) {
        this.f11540h.q0(f8);
    }

    public void setPerformanceTrackingEnabled(boolean z7) {
        this.f11540h.r0(z7);
    }

    public void setProgress(@v(from = 0.0d, to = 1.0d) float f8) {
        this.f11540h.s0(f8);
    }

    public void setRenderMode(s sVar) {
        this.f11549q = sVar;
        p();
    }

    public void setRepeatCount(int i7) {
        this.f11540h.t0(i7);
    }

    public void setRepeatMode(int i7) {
        this.f11540h.u0(i7);
    }

    public void setSafeMode(boolean z7) {
        this.f11540h.v0(z7);
    }

    public void setScale(float f8) {
        this.f11540h.w0(f8);
        if (getDrawable() == this.f11540h) {
            setImageDrawable(null);
            setImageDrawable(this.f11540h);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        h hVar = this.f11540h;
        if (hVar != null) {
            hVar.x0(scaleType);
        }
    }

    public void setSpeed(float f8) {
        this.f11540h.y0(f8);
    }

    public void setTextDelegate(u uVar) {
        this.f11540h.A0(uVar);
    }

    public boolean t() {
        return this.f11540h.N();
    }

    public boolean u() {
        return this.f11540h.Q();
    }

    @Deprecated
    public void v(boolean z7) {
        this.f11540h.t0(z7 ? -1 : 0);
    }

    @j0
    public void w() {
        this.f11547o = false;
        this.f11546n = false;
        this.f11545m = false;
        this.f11544l = false;
        this.f11540h.S();
        p();
    }

    @j0
    public void x() {
        if (!isShown()) {
            this.f11544l = true;
        } else {
            this.f11540h.T();
            p();
        }
    }

    public void y() {
        this.f11540h.U();
    }

    public void z() {
        this.f11550r.clear();
    }

    public void setAnimationFromJson(String str, @o0 String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.f11540h.i0(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z7) {
        this.f11540h.m0(str, str2, z7);
    }

    public void setMinFrame(String str) {
        this.f11540h.p0(str);
    }

    public void setMinAndMaxFrame(int i7, int i8) {
        this.f11540h.k0(i7, i8);
    }

    public void setAnimationFromUrl(String str, @o0 String str2) {
        setCompositionTask(g.x(getContext(), str, str2));
    }

    public void setAnimation(String str) {
        this.f11542j = str;
        this.f11543k = 0;
        setCompositionTask(this.f11548p ? g.e(getContext(), str) : g.f(getContext(), str, null));
    }

    public void setAnimation(InputStream inputStream, @o0 String str) {
        setCompositionTask(g.j(inputStream, str));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11536d = new b();
        this.f11537e = new c();
        this.f11539g = 0;
        this.f11540h = new h();
        this.f11544l = false;
        this.f11545m = false;
        this.f11546n = false;
        this.f11547o = false;
        this.f11548p = true;
        this.f11549q = s.AUTOMATIC;
        this.f11550r = new HashSet();
        this.f11551s = 0;
        s(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f11536d = new b();
        this.f11537e = new c();
        this.f11539g = 0;
        this.f11540h = new h();
        this.f11544l = false;
        this.f11545m = false;
        this.f11546n = false;
        this.f11547o = false;
        this.f11548p = true;
        this.f11549q = s.AUTOMATIC;
        this.f11550r = new HashSet();
        this.f11551s = 0;
        s(attributeSet);
    }
}
