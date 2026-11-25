package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.res.q;
import c.m0;
import c.o0;
import c.t0;
import c.u;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class c extends h implements androidx.vectordrawable.graphics.drawable.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10889i = "AnimatedVDCompat";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f10890j = "animated-vector";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f10891k = "target";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final boolean f10892l = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0131c f10893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f10894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArgbEvaluator f10895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    d f10896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Animator.AnimatorListener f10897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ArrayList<androidx.vectordrawable.graphics.drawable.b.a> f10898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Drawable.Callback f10899h;

    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j7) {
            c.this.scheduleSelf(runnable, j7);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f10898g);
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((androidx.vectordrawable.graphics.drawable.b.a) arrayList.get(i7)).b(c.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(c.this.f10898g);
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                ((androidx.vectordrawable.graphics.drawable.b.a) arrayList.get(i7)).c(c.this);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.c$c, reason: collision with other inner class name */
    private static class C0131c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f10902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        i f10903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        AnimatorSet f10904c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList<Animator> f10905d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        androidx.collection.a<Animator, String> f10906e;

        public C0131c(Context context, C0131c c0131c, Drawable.Callback callback, Resources resources) {
            if (c0131c != null) {
                this.f10902a = c0131c.f10902a;
                i iVar = c0131c.f10903b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f10903b = (i) constantState.newDrawable(resources);
                    } else {
                        this.f10903b = (i) constantState.newDrawable();
                    }
                    i iVar2 = (i) this.f10903b.mutate();
                    this.f10903b = iVar2;
                    iVar2.setCallback(callback);
                    this.f10903b.setBounds(c0131c.f10903b.getBounds());
                    this.f10903b.m(false);
                }
                ArrayList<Animator> arrayList = c0131c.f10905d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f10905d = new ArrayList<>(size);
                    this.f10906e = new androidx.collection.a<>(size);
                    for (int i7 = 0; i7 < size; i7++) {
                        Animator animator = c0131c.f10905d.get(i7);
                        Animator animatorClone = animator.clone();
                        String str = c0131c.f10906e.get(animator);
                        animatorClone.setTarget(this.f10903b.h(str));
                        this.f10905d.add(animatorClone);
                        this.f10906e.put(animatorClone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f10904c == null) {
                this.f10904c = new AnimatorSet();
            }
            this.f10904c.playTogether(this.f10905d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f10902a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    c() {
        this(null, null, null);
    }

    public static void a(Drawable drawable) {
        if (drawable instanceof Animatable) {
            if (Build.VERSION.SDK_INT >= 24) {
                ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            } else {
                ((c) drawable).c();
            }
        }
    }

    @o0
    public static c e(@m0 Context context, @u int i7) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            c cVar = new c(context);
            Drawable drawableG = androidx.core.content.res.i.g(context.getResources(), i7, context.getTheme());
            cVar.f10924a = drawableG;
            drawableG.setCallback(cVar.f10899h);
            cVar.f10896e = new d(cVar.f10924a.getConstantState());
            return cVar;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(i7);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return f(context, context.getResources(), xml, attributeSetAsAttributeSet, context.getTheme());
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e8) {
            Log.e(f10889i, "parser error", e8);
            return null;
        } catch (XmlPullParserException e9) {
            Log.e(f10889i, "parser error", e9);
            return null;
        }
    }

    public static c f(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    public static void g(Drawable drawable, androidx.vectordrawable.graphics.drawable.b.a aVar) {
        if (drawable == null || aVar == null || !(drawable instanceof Animatable)) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            h((AnimatedVectorDrawable) drawable, aVar);
        } else {
            ((c) drawable).b(aVar);
        }
    }

    @t0(23)
    private static void h(@m0 AnimatedVectorDrawable animatedVectorDrawable, @m0 androidx.vectordrawable.graphics.drawable.b.a aVar) {
        animatedVectorDrawable.registerAnimationCallback(aVar.a());
    }

    private void i() {
        Animator.AnimatorListener animatorListener = this.f10897f;
        if (animatorListener != null) {
            this.f10893b.f10904c.removeListener(animatorListener);
            this.f10897f = null;
        }
    }

    private void j(String str, Animator animator) {
        animator.setTarget(this.f10893b.f10903b.h(str));
        C0131c c0131c = this.f10893b;
        if (c0131c.f10905d == null) {
            c0131c.f10905d = new ArrayList<>();
            this.f10893b.f10906e = new androidx.collection.a<>();
        }
        this.f10893b.f10905d.add(animator);
        this.f10893b.f10906e.put(animator, str);
    }

    private void k(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i7 = 0; i7 < childAnimations.size(); i7++) {
                k(childAnimations.get(i7));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f10895d == null) {
                    this.f10895d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f10895d);
            }
        }
    }

    public static boolean l(Drawable drawable, androidx.vectordrawable.graphics.drawable.b.a aVar) {
        if (drawable == null || aVar == null || !(drawable instanceof Animatable)) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 24 ? m((AnimatedVectorDrawable) drawable, aVar) : ((c) drawable).d(aVar);
    }

    @t0(23)
    private static boolean m(AnimatedVectorDrawable animatedVectorDrawable, androidx.vectordrawable.graphics.drawable.b.a aVar) {
        return animatedVectorDrawable.unregisterAnimationCallback(aVar.a());
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.a(drawable, theme);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.b
    public void b(@m0 androidx.vectordrawable.graphics.drawable.b.a aVar) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            h((AnimatedVectorDrawable) drawable, aVar);
            return;
        }
        if (aVar == null) {
            return;
        }
        if (this.f10898g == null) {
            this.f10898g = new ArrayList<>();
        }
        if (this.f10898g.contains(aVar)) {
            return;
        }
        this.f10898g.add(aVar);
        if (this.f10897f == null) {
            this.f10897f = new b();
        }
        this.f10893b.f10904c.addListener(this.f10897f);
    }

    @Override // androidx.vectordrawable.graphics.drawable.b
    public void c() {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).clearAnimationCallbacks();
            return;
        }
        i();
        ArrayList<androidx.vectordrawable.graphics.drawable.b.a> arrayList = this.f10898g;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.d.b(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // androidx.vectordrawable.graphics.drawable.b
    public boolean d(@m0 androidx.vectordrawable.graphics.drawable.b.a aVar) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            m((AnimatedVectorDrawable) drawable, aVar);
        }
        ArrayList<androidx.vectordrawable.graphics.drawable.b.a> arrayList = this.f10898g;
        if (arrayList == null || aVar == null) {
            return false;
        }
        boolean zRemove = arrayList.remove(aVar);
        if (this.f10898g.size() == 0) {
            i();
        }
        return zRemove;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f10893b.f10903b.draw(canvas);
        if (this.f10893b.f10904c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f10924a;
        return drawable != null ? androidx.core.graphics.drawable.d.d(drawable) : this.f10893b.f10903b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f10893b.f10902a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f10924a;
        return drawable != null ? androidx.core.graphics.drawable.d.e(drawable) : this.f10893b.f10903b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f10924a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new d(this.f10924a.getConstantState());
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f10893b.f10903b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f10893b.f10903b.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.getOpacity() : this.f10893b.f10903b.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (f10890j.equals(name)) {
                    TypedArray typedArrayS = q.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.M);
                    int resourceId = typedArrayS.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i iVarE = i.e(resources, resourceId, theme);
                        iVarE.m(false);
                        iVarE.setCallback(this.f10899h);
                        i iVar = this.f10893b.f10903b;
                        if (iVar != null) {
                            iVar.setCallback(null);
                        }
                        this.f10893b.f10903b = iVarE;
                    }
                    typedArrayS.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.O);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f10894c;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        j(string, e.j(context, resourceId2));
                    }
                    typedArrayObtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f10893b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f10924a;
        return drawable != null ? androidx.core.graphics.drawable.d.h(drawable) : this.f10893b.f10903b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f10924a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f10893b.f10904c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.isStateful() : this.f10893b.f10903b.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f10893b.f10903b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i7) {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.setLevel(i7) : this.f10893b.f10903b.setLevel(i7);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f10924a;
        return drawable != null ? drawable.setState(iArr) : this.f10893b.f10903b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.setAlpha(i7);
        } else {
            this.f10893b.f10903b.setAlpha(i7);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z7) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.j(drawable, z7);
        } else {
            this.f10893b.f10903b.setAutoMirrored(z7);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i7) {
        super.setChangingConfigurations(i7);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i7, PorterDuff.Mode mode) {
        super.setColorFilter(i7, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z7) {
        super.setFilterBitmap(z7);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f8, float f9) {
        super.setHotspot(f8, f9);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i7, int i8, int i9, int i10) {
        super.setHotspotBounds(i7, i8, i9, i10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTint(int i7) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.n(drawable, i7);
        } else {
            this.f10893b.f10903b.setTint(i7);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.o(drawable, colorStateList);
        } else {
            this.f10893b.f10903b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.r
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            androidx.core.graphics.drawable.d.p(drawable, mode);
        } else {
            this.f10893b.f10903b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            return drawable.setVisible(z7, z8);
        }
        this.f10893b.f10903b.setVisible(z7, z8);
        return super.setVisible(z7, z8);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f10893b.f10904c.isStarted()) {
                return;
            }
            this.f10893b.f10904c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f10893b.f10904c.end();
        }
    }

    private c(@o0 Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f10924a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f10893b.f10903b.setColorFilter(colorFilter);
        }
    }

    @t0(24)
    private static class d extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f10907a;

        public d(Drawable.ConstantState constantState) {
            this.f10907a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f10907a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f10907a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f10907a.newDrawable();
            cVar.f10924a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f10899h);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f10907a.newDrawable(resources);
            cVar.f10924a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f10899h);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable drawableNewDrawable = this.f10907a.newDrawable(resources, theme);
            cVar.f10924a = drawableNewDrawable;
            drawableNewDrawable.setCallback(cVar.f10899h);
            return cVar;
        }
    }

    private c(@o0 Context context, @o0 C0131c c0131c, @o0 Resources resources) {
        this.f10895d = null;
        this.f10897f = null;
        this.f10898g = null;
        a aVar = new a();
        this.f10899h = aVar;
        this.f10894c = context;
        if (c0131c != null) {
            this.f10893b = c0131c;
        } else {
            this.f10893b = new C0131c(context, c0131c, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
