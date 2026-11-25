package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4671c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4672d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4673e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4674f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4675g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f4676h = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f4677i = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f4678j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f4679k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f4680l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f4681m = -2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f4682n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f4683o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ConstraintLayout.LayoutParams f4684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    View f4685b;

    public c(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ConstraintLayout.LayoutParams)) {
            throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
        }
        this.f4684a = (ConstraintLayout.LayoutParams) layoutParams;
        this.f4685b = view;
    }

    private String K(int side) {
        switch (side) {
            case 1:
                return ViewHierarchyConstants.DIMENSION_LEFT_KEY;
            case 2:
                return "right";
            case 3:
                return ViewHierarchyConstants.DIMENSION_TOP_KEY;
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public c A(float weight) {
        this.f4684a.L = weight;
        return this;
    }

    public c B(int anchor, int value) {
        switch (anchor) {
            case 1:
                ((ViewGroup.MarginLayoutParams) this.f4684a).leftMargin = value;
                return this;
            case 2:
                ((ViewGroup.MarginLayoutParams) this.f4684a).rightMargin = value;
                return this;
            case 3:
                ((ViewGroup.MarginLayoutParams) this.f4684a).topMargin = value;
                return this;
            case 4:
                ((ViewGroup.MarginLayoutParams) this.f4684a).bottomMargin = value;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.f4684a.setMarginStart(value);
                return this;
            case 7:
                this.f4684a.setMarginEnd(value);
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public c C(int anchor) {
        switch (anchor) {
            case 1:
                ConstraintLayout.LayoutParams layoutParams = this.f4684a;
                layoutParams.f4528f = -1;
                layoutParams.f4526e = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -1;
                layoutParams.f4562w = Integer.MIN_VALUE;
                return this;
            case 2:
                ConstraintLayout.LayoutParams layoutParams2 = this.f4684a;
                layoutParams2.f4532h = -1;
                layoutParams2.f4530g = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = -1;
                layoutParams2.f4565y = Integer.MIN_VALUE;
                return this;
            case 3:
                ConstraintLayout.LayoutParams layoutParams3 = this.f4684a;
                layoutParams3.f4536j = -1;
                layoutParams3.f4534i = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = -1;
                layoutParams3.f4564x = Integer.MIN_VALUE;
                return this;
            case 4:
                ConstraintLayout.LayoutParams layoutParams4 = this.f4684a;
                layoutParams4.f4538k = -1;
                layoutParams4.f4540l = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = -1;
                layoutParams4.f4566z = Integer.MIN_VALUE;
                return this;
            case 5:
                this.f4684a.f4542m = -1;
                return this;
            case 6:
                ConstraintLayout.LayoutParams layoutParams5 = this.f4684a;
                layoutParams5.f4554s = -1;
                layoutParams5.f4556t = -1;
                layoutParams5.setMarginStart(-1);
                this.f4684a.A = Integer.MIN_VALUE;
                return this;
            case 7:
                ConstraintLayout.LayoutParams layoutParams6 = this.f4684a;
                layoutParams6.f4558u = -1;
                layoutParams6.f4560v = -1;
                layoutParams6.setMarginEnd(-1);
                this.f4684a.B = Integer.MIN_VALUE;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public c D() {
        ConstraintLayout.LayoutParams layoutParams = this.f4684a;
        int i7 = layoutParams.f4528f;
        int i8 = layoutParams.f4530g;
        if (i7 == -1 && i8 == -1) {
            int i9 = layoutParams.f4554s;
            int i10 = layoutParams.f4558u;
            if (i9 != -1 || i10 != -1) {
                c cVar = new c(((ViewGroup) this.f4685b.getParent()).findViewById(i9));
                c cVar2 = new c(((ViewGroup) this.f4685b.getParent()).findViewById(i10));
                ConstraintLayout.LayoutParams layoutParams2 = this.f4684a;
                if (i9 != -1 && i10 != -1) {
                    cVar.m(7, i10, 6, 0);
                    cVar2.m(6, i7, 7, 0);
                } else if (i7 != -1 || i10 != -1) {
                    int i11 = layoutParams2.f4532h;
                    if (i11 != -1) {
                        cVar.m(7, i11, 7, 0);
                    } else {
                        int i12 = layoutParams2.f4526e;
                        if (i12 != -1) {
                            cVar2.m(6, i12, 6, 0);
                        }
                    }
                }
            }
            C(6);
            C(7);
        } else {
            c cVar3 = new c(((ViewGroup) this.f4685b.getParent()).findViewById(i7));
            c cVar4 = new c(((ViewGroup) this.f4685b.getParent()).findViewById(i8));
            ConstraintLayout.LayoutParams layoutParams3 = this.f4684a;
            if (i7 != -1 && i8 != -1) {
                cVar3.m(2, i8, 1, 0);
                cVar4.m(1, i7, 2, 0);
            } else if (i7 != -1 || i8 != -1) {
                int i13 = layoutParams3.f4532h;
                if (i13 != -1) {
                    cVar3.m(2, i13, 2, 0);
                } else {
                    int i14 = layoutParams3.f4526e;
                    if (i14 != -1) {
                        cVar4.m(1, i14, 1, 0);
                    }
                }
            }
            C(1);
            C(2);
        }
        return this;
    }

    public c E() {
        ConstraintLayout.LayoutParams layoutParams = this.f4684a;
        int i7 = layoutParams.f4536j;
        int i8 = layoutParams.f4538k;
        if (i7 != -1 || i8 != -1) {
            c cVar = new c(((ViewGroup) this.f4685b.getParent()).findViewById(i7));
            c cVar2 = new c(((ViewGroup) this.f4685b.getParent()).findViewById(i8));
            ConstraintLayout.LayoutParams layoutParams2 = this.f4684a;
            if (i7 != -1 && i8 != -1) {
                cVar.m(4, i8, 3, 0);
                cVar2.m(3, i7, 4, 0);
            } else if (i7 != -1 || i8 != -1) {
                int i9 = layoutParams2.f4540l;
                if (i9 != -1) {
                    cVar.m(4, i9, 4, 0);
                } else {
                    int i10 = layoutParams2.f4534i;
                    if (i10 != -1) {
                        cVar2.m(3, i10, 3, 0);
                    }
                }
            }
        }
        C(3);
        C(4);
        return this;
    }

    public c F(float rotation) {
        this.f4685b.setRotation(rotation);
        return this;
    }

    public c G(float rotationX) {
        this.f4685b.setRotationX(rotationX);
        return this;
    }

    public c H(float rotationY) {
        this.f4685b.setRotationY(rotationY);
        return this;
    }

    public c I(float scaleX) {
        this.f4685b.setScaleY(scaleX);
        return this;
    }

    public c J(float scaleY) {
        return this;
    }

    public c L(float transformPivotX, float transformPivotY) {
        this.f4685b.setPivotX(transformPivotX);
        this.f4685b.setPivotY(transformPivotY);
        return this;
    }

    public c M(float transformPivotX) {
        this.f4685b.setPivotX(transformPivotX);
        return this;
    }

    public c N(float transformPivotY) {
        this.f4685b.setPivotY(transformPivotY);
        return this;
    }

    public c O(float translationX, float translationY) {
        this.f4685b.setTranslationX(translationX);
        this.f4685b.setTranslationY(translationY);
        return this;
    }

    public c P(float translationX) {
        this.f4685b.setTranslationX(translationX);
        return this;
    }

    public c Q(float translationY) {
        this.f4685b.setTranslationY(translationY);
        return this;
    }

    public c R(float translationZ) {
        this.f4685b.setTranslationZ(translationZ);
        return this;
    }

    public c S(float bias) {
        this.f4684a.H = bias;
        return this;
    }

    public c T(int chainStyle) {
        this.f4684a.O = chainStyle;
        return this;
    }

    public c U(float weight) {
        this.f4684a.M = weight;
        return this;
    }

    public c V(int visibility) {
        this.f4685b.setVisibility(visibility);
        return this;
    }

    public c a(int leftId, int rightId) {
        m(1, leftId, leftId == 0 ? 1 : 2, 0);
        m(2, rightId, rightId == 0 ? 2 : 1, 0);
        if (leftId != 0) {
            new c(((ViewGroup) this.f4685b.getParent()).findViewById(leftId)).m(2, this.f4685b.getId(), 1, 0);
        }
        if (rightId != 0) {
            new c(((ViewGroup) this.f4685b.getParent()).findViewById(rightId)).m(1, this.f4685b.getId(), 2, 0);
        }
        return this;
    }

    public c b(int leftId, int rightId) {
        m(6, leftId, leftId == 0 ? 6 : 7, 0);
        m(7, rightId, rightId == 0 ? 7 : 6, 0);
        if (leftId != 0) {
            new c(((ViewGroup) this.f4685b.getParent()).findViewById(leftId)).m(7, this.f4685b.getId(), 6, 0);
        }
        if (rightId != 0) {
            new c(((ViewGroup) this.f4685b.getParent()).findViewById(rightId)).m(6, this.f4685b.getId(), 7, 0);
        }
        return this;
    }

    public c c(int topId, int bottomId) {
        m(3, topId, topId == 0 ? 3 : 4, 0);
        m(4, bottomId, bottomId == 0 ? 4 : 3, 0);
        if (topId != 0) {
            new c(((ViewGroup) this.f4685b.getParent()).findViewById(topId)).m(4, this.f4685b.getId(), 3, 0);
        }
        if (bottomId != 0) {
            new c(((ViewGroup) this.f4685b.getParent()).findViewById(bottomId)).m(3, this.f4685b.getId(), 4, 0);
        }
        return this;
    }

    public c d(float alpha) {
        this.f4685b.setAlpha(alpha);
        return this;
    }

    public void e() {
    }

    public c f(int firstID, int firstSide, int firstMargin, int secondId, int secondSide, int secondMargin, float bias) {
        if (firstMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (secondMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (bias <= 0.0f || bias > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (firstSide == 1 || firstSide == 2) {
            m(1, firstID, firstSide, firstMargin);
            m(2, secondId, secondSide, secondMargin);
            this.f4684a.G = bias;
        } else if (firstSide == 6 || firstSide == 7) {
            m(6, firstID, firstSide, firstMargin);
            m(7, secondId, secondSide, secondMargin);
            this.f4684a.G = bias;
        } else {
            m(3, firstID, firstSide, firstMargin);
            m(4, secondId, secondSide, secondMargin);
            this.f4684a.H = bias;
        }
        return this;
    }

    public c g(int toView) {
        if (toView == 0) {
            f(0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            f(toView, 2, 0, toView, 1, 0, 0.5f);
        }
        return this;
    }

    public c h(int leftId, int leftSide, int leftMargin, int rightId, int rightSide, int rightMargin, float bias) {
        m(1, leftId, leftSide, leftMargin);
        m(2, rightId, rightSide, rightMargin);
        this.f4684a.G = bias;
        return this;
    }

    public c i(int toView) {
        if (toView == 0) {
            f(0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            f(toView, 7, 0, toView, 6, 0, 0.5f);
        }
        return this;
    }

    public c j(int startId, int startSide, int startMargin, int endId, int endSide, int endMargin, float bias) {
        m(6, startId, startSide, startMargin);
        m(7, endId, endSide, endMargin);
        this.f4684a.G = bias;
        return this;
    }

    public c k(int toView) {
        if (toView == 0) {
            f(0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            f(toView, 4, 0, toView, 3, 0, 0.5f);
        }
        return this;
    }

    public c l(int topId, int topSide, int topMargin, int bottomId, int bottomSide, int bottomMargin, float bias) {
        m(3, topId, topSide, topMargin);
        m(4, bottomId, bottomSide, bottomMargin);
        this.f4684a.H = bias;
        return this;
    }

    public c m(int startSide, int endID, int endSide, int margin) {
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    ConstraintLayout.LayoutParams layoutParams = this.f4684a;
                    layoutParams.f4526e = endID;
                    layoutParams.f4528f = -1;
                } else {
                    if (endSide != 2) {
                        throw new IllegalArgumentException("Left to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams2 = this.f4684a;
                    layoutParams2.f4528f = endID;
                    layoutParams2.f4526e = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.f4684a).leftMargin = margin;
                return this;
            case 2:
                if (endSide == 1) {
                    ConstraintLayout.LayoutParams layoutParams3 = this.f4684a;
                    layoutParams3.f4530g = endID;
                    layoutParams3.f4532h = -1;
                } else {
                    if (endSide != 2) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams4 = this.f4684a;
                    layoutParams4.f4532h = endID;
                    layoutParams4.f4530g = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.f4684a).rightMargin = margin;
                return this;
            case 3:
                if (endSide == 3) {
                    ConstraintLayout.LayoutParams layoutParams5 = this.f4684a;
                    layoutParams5.f4534i = endID;
                    layoutParams5.f4536j = -1;
                    layoutParams5.f4542m = -1;
                    layoutParams5.f4544n = -1;
                    layoutParams5.f4546o = -1;
                } else {
                    if (endSide != 4) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams6 = this.f4684a;
                    layoutParams6.f4536j = endID;
                    layoutParams6.f4534i = -1;
                    layoutParams6.f4542m = -1;
                    layoutParams6.f4544n = -1;
                    layoutParams6.f4546o = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.f4684a).topMargin = margin;
                return this;
            case 4:
                if (endSide == 4) {
                    ConstraintLayout.LayoutParams layoutParams7 = this.f4684a;
                    layoutParams7.f4540l = endID;
                    layoutParams7.f4538k = -1;
                    layoutParams7.f4542m = -1;
                    layoutParams7.f4544n = -1;
                    layoutParams7.f4546o = -1;
                } else {
                    if (endSide != 3) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams8 = this.f4684a;
                    layoutParams8.f4538k = endID;
                    layoutParams8.f4540l = -1;
                    layoutParams8.f4542m = -1;
                    layoutParams8.f4544n = -1;
                    layoutParams8.f4546o = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.f4684a).bottomMargin = margin;
                return this;
            case 5:
                if (endSide == 5) {
                    ConstraintLayout.LayoutParams layoutParams9 = this.f4684a;
                    layoutParams9.f4542m = endID;
                    layoutParams9.f4540l = -1;
                    layoutParams9.f4538k = -1;
                    layoutParams9.f4534i = -1;
                    layoutParams9.f4536j = -1;
                }
                if (endSide == 3) {
                    ConstraintLayout.LayoutParams layoutParams10 = this.f4684a;
                    layoutParams10.f4544n = endID;
                    layoutParams10.f4540l = -1;
                    layoutParams10.f4538k = -1;
                    layoutParams10.f4534i = -1;
                    layoutParams10.f4536j = -1;
                } else {
                    if (endSide != 4) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams11 = this.f4684a;
                    layoutParams11.f4546o = endID;
                    layoutParams11.f4540l = -1;
                    layoutParams11.f4538k = -1;
                    layoutParams11.f4534i = -1;
                    layoutParams11.f4536j = -1;
                }
                this.f4684a.D = margin;
                return this;
            case 6:
                if (endSide == 6) {
                    ConstraintLayout.LayoutParams layoutParams12 = this.f4684a;
                    layoutParams12.f4556t = endID;
                    layoutParams12.f4554s = -1;
                } else {
                    if (endSide != 7) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams13 = this.f4684a;
                    layoutParams13.f4554s = endID;
                    layoutParams13.f4556t = -1;
                }
                this.f4684a.setMarginStart(margin);
                return this;
            case 7:
                if (endSide == 7) {
                    ConstraintLayout.LayoutParams layoutParams14 = this.f4684a;
                    layoutParams14.f4560v = endID;
                    layoutParams14.f4558u = -1;
                } else {
                    if (endSide != 6) {
                        throw new IllegalArgumentException("right to " + K(endSide) + " undefined");
                    }
                    ConstraintLayout.LayoutParams layoutParams15 = this.f4684a;
                    layoutParams15.f4558u = endID;
                    layoutParams15.f4560v = -1;
                }
                this.f4684a.setMarginEnd(margin);
                return this;
            default:
                throw new IllegalArgumentException(K(startSide) + " to " + K(endSide) + " unknown");
        }
    }

    public c n(int height) {
        this.f4684a.Q = height;
        return this;
    }

    public c o(int width) {
        this.f4684a.P = width;
        return this;
    }

    public c p(int height) {
        ((ViewGroup.MarginLayoutParams) this.f4684a).height = height;
        return this;
    }

    public c q(int height) {
        this.f4684a.U = height;
        return this;
    }

    public c r(int width) {
        this.f4684a.T = width;
        return this;
    }

    public c s(int height) {
        this.f4684a.S = height;
        return this;
    }

    public c t(int width) {
        this.f4684a.R = width;
        return this;
    }

    public c u(int width) {
        ((ViewGroup.MarginLayoutParams) this.f4684a).width = width;
        return this;
    }

    public c v(String ratio) {
        this.f4684a.I = ratio;
        return this;
    }

    public c w(float elevation) {
        this.f4685b.setElevation(elevation);
        return this;
    }

    public c x(int anchor, int value) {
        switch (anchor) {
            case 1:
                this.f4684a.f4562w = value;
                return this;
            case 2:
                this.f4684a.f4565y = value;
                return this;
            case 3:
                this.f4684a.f4564x = value;
                return this;
            case 4:
                this.f4684a.f4566z = value;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.f4684a.A = value;
                return this;
            case 7:
                this.f4684a.B = value;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public c y(float bias) {
        this.f4684a.G = bias;
        return this;
    }

    public c z(int chainStyle) {
        this.f4684a.N = chainStyle;
        return this;
    }
}
