package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.n2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class Slide extends Visibility {
    private static final String H0 = "android:slide:screenPosition";
    private g D0;
    private int E0;
    private static final TimeInterpolator F0 = new DecelerateInterpolator();
    private static final TimeInterpolator G0 = new AccelerateInterpolator();
    private static final g I0 = new a();
    private static final g J0 = new b();
    private static final g K0 = new c();
    private static final g L0 = new d();
    private static final g M0 = new e();
    private static final g N0 = new f();

    static class a extends h {
        a() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    }

    static class b extends h {
        b() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return n2.Z(viewGroup) == 1 ? view.getTranslationX() + viewGroup.getWidth() : view.getTranslationX() - viewGroup.getWidth();
        }
    }

    static class c extends i {
        c() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    }

    static class d extends h {
        d() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    }

    static class e extends h {
        e() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return n2.Z(viewGroup) == 1 ? view.getTranslationX() - viewGroup.getWidth() : view.getTranslationX() + viewGroup.getWidth();
        }
    }

    static class f extends i {
        f() {
            super(null);
        }

        @Override // androidx.transition.Slide.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    }

    private interface g {
        float a(ViewGroup viewGroup, View view);

        float b(ViewGroup viewGroup, View view);
    }

    private static abstract class h implements g {
        private h() {
        }

        @Override // androidx.transition.Slide.g
        public float a(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }

        /* synthetic */ h(a aVar) {
            this();
        }
    }

    private static abstract class i implements g {
        private i() {
        }

        @Override // androidx.transition.Slide.g
        public float b(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }

    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface j {
    }

    public Slide() {
        this.D0 = N0;
        this.E0 = 80;
        N0(80);
    }

    private void D0(d0 d0Var) {
        int[] iArr = new int[2];
        d0Var.f10675b.getLocationOnScreen(iArr);
        d0Var.f10674a.put(H0, iArr);
    }

    @Override // androidx.transition.Visibility
    public Animator H0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        if (d0Var2 == null) {
            return null;
        }
        int[] iArr = (int[]) d0Var2.f10674a.get(H0);
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return f0.a(view, d0Var2, iArr[0], iArr[1], this.D0.b(viewGroup, view), this.D0.a(viewGroup, view), translationX, translationY, F0, this);
    }

    @Override // androidx.transition.Visibility
    public Animator J0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        if (d0Var == null) {
            return null;
        }
        int[] iArr = (int[]) d0Var.f10674a.get(H0);
        return f0.a(view, d0Var, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.D0.b(viewGroup, view), this.D0.a(viewGroup, view), G0, this);
    }

    public int M0() {
        return this.E0;
    }

    public void N0(int i7) {
        if (i7 == 3) {
            this.D0 = I0;
        } else if (i7 == 5) {
            this.D0 = L0;
        } else if (i7 == 48) {
            this.D0 = K0;
        } else if (i7 == 80) {
            this.D0 = N0;
        } else if (i7 == 8388611) {
            this.D0 = J0;
        } else {
            if (i7 != 8388613) {
                throw new IllegalArgumentException("Invalid slide direction");
            }
            this.D0 = M0;
        }
        this.E0 = i7;
        v vVar = new v();
        vVar.k(i7);
        y0(vVar);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void k(@c.m0 d0 d0Var) {
        super.k(d0Var);
        D0(d0Var);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void n(@c.m0 d0 d0Var) {
        super.n(d0Var);
        D0(d0Var);
    }

    public Slide(int i7) {
        this.D0 = N0;
        this.E0 = 80;
        N0(i7);
    }

    @SuppressLint({"RestrictedApi"})
    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D0 = N0;
        this.E0 = 80;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.f10789h);
        int iK = androidx.core.content.res.q.k(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        typedArrayObtainStyledAttributes.recycle();
        N0(iK);
    }
}
