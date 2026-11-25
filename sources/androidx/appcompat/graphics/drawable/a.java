package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.appcompat.resources.R;
import androidx.appcompat.widget.w0;
import androidx.collection.j;
import androidx.core.content.res.q;
import androidx.core.graphics.drawable.r;
import androidx.vectordrawable.graphics.drawable.i;
import c.l;
import c.m0;
import c.o0;
import c.t0;
import c.u;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class a extends androidx.appcompat.graphics.drawable.e implements r {
    private static final String A = "item";
    private static final String B = ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable";
    private static final String C = ": <transition> tag requires 'fromId' & 'toId' attributes";
    private static final String D = ": <item> tag requires a 'drawable' attribute or child tag defining a drawable";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f927y = "a";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f928z = "transition";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private c f929t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private g f930u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f931v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f932w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private boolean f933x;

    private static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Animatable f934a;

        b(Animatable animatable) {
            super();
            this.f934a = animatable;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void c() {
            this.f934a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void d() {
            this.f934a.stop();
        }
    }

    static class c extends androidx.appcompat.graphics.drawable.e.a {
        private static final long M = 4294967296L;
        private static final long N = 8589934592L;
        androidx.collection.f<Long> K;
        j<Integer> L;

        c(@o0 c cVar, @m0 a aVar, @o0 Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
            } else {
                this.K = new androidx.collection.f<>();
                this.L = new j<>();
            }
        }

        private static long H(int i7, int i8) {
            return ((long) i8) | (((long) i7) << 32);
        }

        int F(@m0 int[] iArr, @m0 Drawable drawable, int i7) {
            int iD = super.D(iArr, drawable);
            this.L.s(iD, Integer.valueOf(i7));
            return iD;
        }

        int G(int i7, int i8, @m0 Drawable drawable, boolean z7) {
            int iA = super.a(drawable);
            long jH = H(i7, i8);
            long j7 = z7 ? N : 0L;
            long j8 = iA;
            this.K.a(jH, Long.valueOf(j8 | j7));
            if (z7) {
                this.K.a(H(i8, i7), Long.valueOf(M | j8 | j7));
            }
            return iA;
        }

        int I(int i7) {
            if (i7 < 0) {
                return 0;
            }
            return this.L.n(i7, 0).intValue();
        }

        int J(@m0 int[] iArr) {
            int iE = super.E(iArr);
            return iE >= 0 ? iE : super.E(StateSet.WILD_CARD);
        }

        int K(int i7, int i8) {
            return (int) this.K.n(H(i7, i8), -1L).longValue();
        }

        boolean L(int i7, int i8) {
            return (this.K.n(H(i7, i8), -1L).longValue() & M) != 0;
        }

        boolean M(int i7, int i8) {
            return (this.K.n(H(i7, i8), -1L).longValue() & N) != 0;
        }

        @Override // androidx.appcompat.graphics.drawable.e.a, android.graphics.drawable.Drawable.ConstantState
        @m0
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // androidx.appcompat.graphics.drawable.e.a, androidx.appcompat.graphics.drawable.b.d
        void v() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // androidx.appcompat.graphics.drawable.e.a, android.graphics.drawable.Drawable.ConstantState
        @m0
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    private static class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final androidx.vectordrawable.graphics.drawable.c f935a;

        d(androidx.vectordrawable.graphics.drawable.c cVar) {
            super();
            this.f935a = cVar;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void c() {
            this.f935a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void d() {
            this.f935a.stop();
        }
    }

    private static class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ObjectAnimator f936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f937b;

        e(AnimationDrawable animationDrawable, boolean z7, boolean z8) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i7 = z7 ? numberOfFrames - 1 : 0;
            int i8 = z7 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z7);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i7, i8);
            f.a.b.a(objectAnimatorOfInt, true);
            objectAnimatorOfInt.setDuration(fVar.a());
            objectAnimatorOfInt.setInterpolator(fVar);
            this.f937b = z8;
            this.f936a = objectAnimatorOfInt;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public boolean a() {
            return this.f937b;
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void b() {
            this.f936a.reverse();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void c() {
            this.f936a.start();
        }

        @Override // androidx.appcompat.graphics.drawable.a.g
        public void d() {
            this.f936a.cancel();
        }
    }

    private static class f implements TimeInterpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f940c;

        f(AnimationDrawable animationDrawable, boolean z7) {
            b(animationDrawable, z7);
        }

        int a() {
            return this.f940c;
        }

        int b(AnimationDrawable animationDrawable, boolean z7) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f939b = numberOfFrames;
            int[] iArr = this.f938a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f938a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f938a;
            int i7 = 0;
            for (int i8 = 0; i8 < numberOfFrames; i8++) {
                int duration = animationDrawable.getDuration(z7 ? (numberOfFrames - i8) - 1 : i8);
                iArr2[i8] = duration;
                i7 += duration;
            }
            this.f940c = i7;
            return i7;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f8) {
            int i7 = (int) ((f8 * this.f940c) + 0.5f);
            int i8 = this.f939b;
            int[] iArr = this.f938a;
            int i9 = 0;
            while (i9 < i8) {
                int i10 = iArr[i9];
                if (i7 < i10) {
                    break;
                }
                i7 -= i10;
                i9++;
            }
            return (i9 / i8) + (i9 < i8 ? i7 / this.f940c : 0.0f);
        }
    }

    private static abstract class g {
        private g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    @o0
    public static a B(@m0 Context context, @u int i7, @o0 Resources.Theme theme) {
        int next;
        try {
            Resources resources = context.getResources();
            XmlResourceParser xml = resources.getXml(i7);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return C(context, resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e8) {
            Log.e(f927y, "parser error", e8);
            return null;
        } catch (XmlPullParserException e9) {
            Log.e(f927y, "parser error", e9);
            return null;
        }
    }

    @m0
    public static a C(@m0 Context context, @m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.v(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    private void D() {
        onStateChange(getState());
    }

    private int E(@m0 Context context, @m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayS = q.s(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = typedArrayS.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayS.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableJ = resourceId2 > 0 ? w0.h().j(context, resourceId2) : null;
        typedArrayS.recycle();
        int[] iArrP = p(attributeSet);
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + D);
            }
            drawableJ = xmlPullParser.getName().equals("vector") ? i.f(resources, xmlPullParser, attributeSet, theme) : f.a.c.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (drawableJ != null) {
            return this.f929t.F(iArrP, drawableJ, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + D);
    }

    private int F(@m0 Context context, @m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayS = q.s(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayS.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayS.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayS.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableJ = resourceId3 > 0 ? w0.h().j(context, resourceId3) : null;
        boolean z7 = typedArrayS.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayS.recycle();
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + B);
            }
            drawableJ = xmlPullParser.getName().equals("animated-vector") ? androidx.vectordrawable.graphics.drawable.c.f(context, resources, xmlPullParser, attributeSet, theme) : f.a.c.a(resources, xmlPullParser, attributeSet, theme);
        }
        if (drawableJ == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + B);
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.f929t.G(resourceId, resourceId2, drawableJ, z7);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + C);
    }

    private boolean G(int i7) {
        int iD;
        int iK;
        g bVar;
        g gVar = this.f930u;
        if (gVar == null) {
            iD = d();
        } else {
            if (i7 == this.f931v) {
                return true;
            }
            if (i7 == this.f932w && gVar.a()) {
                gVar.b();
                this.f931v = this.f932w;
                this.f932w = i7;
                return true;
            }
            iD = this.f931v;
            gVar.d();
        }
        this.f930u = null;
        this.f932w = -1;
        this.f931v = -1;
        c cVar = this.f929t;
        int I = cVar.I(iD);
        int I2 = cVar.I(i7);
        if (I2 == 0 || I == 0 || (iK = cVar.K(I, I2)) < 0) {
            return false;
        }
        boolean zM = cVar.M(I, I2);
        h(iK);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.L(I, I2), zM);
        } else {
            if (!(current instanceof androidx.vectordrawable.graphics.drawable.c)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((androidx.vectordrawable.graphics.drawable.c) current);
        }
        bVar.c();
        this.f930u = bVar;
        this.f932w = iD;
        this.f931v = i7;
        return true;
    }

    private void w(@m0 Context context, @m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals(A)) {
                    E(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals(f928z)) {
                    F(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private void x(TypedArray typedArray) {
        c cVar = this.f929t;
        cVar.f961d |= f.a.c.b(typedArray);
        cVar.B(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f966i));
        cVar.x(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, cVar.f969l));
        cVar.y(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.z(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, cVar.f981x));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.graphics.drawable.e
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c o() {
        return new c(this.f929t, this, null);
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @t0(21)
    public /* bridge */ /* synthetic */ void applyTheme(@m0 Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b
    void b() {
        super.b();
        this.f933x = false;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @t0(21)
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(@m0 Canvas canvas) {
        super.draw(canvas);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @m0
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(@m0 Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @t0(21)
    public /* bridge */ /* synthetic */ void getOutline(@m0 Outline outline) {
        super.getOutline(outline);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(@m0 Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b
    void i(@m0 androidx.appcompat.graphics.drawable.b.d dVar) {
        super.i(dVar);
        if (dVar instanceof c) {
            this.f929t = (c) dVar;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(@m0 Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f930u;
        if (gVar != null) {
            gVar.d();
            this.f930u = null;
            h(this.f931v);
            this.f931v = -1;
            this.f932w = -1;
        }
    }

    @Override // androidx.appcompat.graphics.drawable.b
    public /* bridge */ /* synthetic */ void k(int i7) {
        super.k(i7);
    }

    @Override // androidx.appcompat.graphics.drawable.b
    public /* bridge */ /* synthetic */ void l(int i7) {
        super.l(i7);
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    @m0
    public Drawable mutate() {
        if (!this.f933x && super.mutate() == this) {
            this.f929t.v();
            this.f933x = true;
        }
        return this;
    }

    @Override // androidx.appcompat.graphics.drawable.e
    public /* bridge */ /* synthetic */ void n(int[] iArr, Drawable drawable) {
        super.n(iArr, drawable);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i7) {
        return super.onLayoutDirectionChanged(i7);
    }

    @Override // androidx.appcompat.graphics.drawable.e, androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(@m0 int[] iArr) {
        int iJ = this.f929t.J(iArr);
        boolean z7 = iJ != d() && (G(iJ) || h(iJ));
        Drawable current = getCurrent();
        return current != null ? z7 | current.setState(iArr) : z7;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable, long j7) {
        super.scheduleDrawable(drawable, runnable, j7);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i7) {
        super.setAlpha(i7);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z7) {
        super.setAutoMirrored(z7);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z7) {
        super.setDither(z7);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f8, float f9) {
        super.setHotspot(f8, f9);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i7, int i8, int i9, int i10) {
        super.setHotspotBounds(i7, i8, i9, i10);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public /* bridge */ /* synthetic */ void setTint(@l int i7) {
        super.setTint(i7);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public /* bridge */ /* synthetic */ void setTintMode(@m0 PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        boolean visible = super.setVisible(z7, z8);
        g gVar = this.f930u;
        if (gVar != null && (visible || z8)) {
            if (z7) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // androidx.appcompat.graphics.drawable.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(@m0 Drawable drawable, @m0 Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    @Override // androidx.appcompat.graphics.drawable.e
    public void v(@m0 Context context, @m0 Resources resources, @m0 XmlPullParser xmlPullParser, @m0 AttributeSet attributeSet, @o0 Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayS = q.s(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(typedArrayS.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        x(typedArrayS);
        m(resources);
        typedArrayS.recycle();
        w(context, resources, xmlPullParser, attributeSet, theme);
        D();
    }

    public void y(@m0 int[] iArr, @m0 Drawable drawable, int i7) {
        androidx.core.util.r.d(drawable);
        this.f929t.F(iArr, drawable, i7);
        onStateChange(getState());
    }

    public <T extends Drawable & Animatable> void z(int i7, int i8, @m0 T t7, boolean z7) {
        androidx.core.util.r.d(t7);
        this.f929t.G(i7, i8, t7, z7);
    }

    a(@o0 c cVar, @o0 Resources resources) {
        super(null);
        this.f931v = -1;
        this.f932w = -1;
        i(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
