package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.d;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CircularFlow extends VirtualLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f3752v = "CircularFlow";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static int f3753w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static float f3754x;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ConstraintLayout f3755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f3756m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float[] f3757n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int[] f3758o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f3759p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f3760q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f3761r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f3762s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Float f3763t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Integer f3764u;

    public CircularFlow(Context context) {
        super(context);
    }

    private void K(String angleString) {
        float[] fArr;
        if (angleString == null || angleString.length() == 0 || this.f4481c == null || (fArr = this.f3757n) == null) {
            return;
        }
        if (this.f3760q + 1 > fArr.length) {
            this.f3757n = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.f3757n[this.f3760q] = Integer.parseInt(angleString);
        this.f3760q++;
    }

    private void L(String radiusString) {
        int[] iArr;
        if (radiusString == null || radiusString.length() == 0 || this.f4481c == null || (iArr = this.f3758o) == null) {
            return;
        }
        if (this.f3759p + 1 > iArr.length) {
            this.f3758o = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.f3758o[this.f3759p] = (int) (Integer.parseInt(radiusString) * this.f4481c.getResources().getDisplayMetrics().density);
        this.f3759p++;
    }

    private void N() {
        this.f3755l = (ConstraintLayout) getParent();
        for (int i7 = 0; i7 < this.f4480b; i7++) {
            View viewT = this.f3755l.t(this.f4479a[i7]);
            if (viewT != null) {
                int i8 = f3753w;
                float f8 = f3754x;
                int[] iArr = this.f3758o;
                if (iArr == null || i7 >= iArr.length) {
                    Integer num = this.f3764u;
                    if (num == null || num.intValue() == -1) {
                        Log.e(f3752v, "Added radius to view with id: " + this.f4487i.get(Integer.valueOf(viewT.getId())));
                    } else {
                        this.f3759p++;
                        if (this.f3758o == null) {
                            this.f3758o = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f3758o = radius;
                        radius[this.f3759p - 1] = i8;
                    }
                } else {
                    i8 = iArr[i7];
                }
                float[] fArr = this.f3757n;
                if (fArr == null || i7 >= fArr.length) {
                    Float f9 = this.f3763t;
                    if (f9 == null || f9.floatValue() == -1.0f) {
                        Log.e(f3752v, "Added angle to view with id: " + this.f4487i.get(Integer.valueOf(viewT.getId())));
                    } else {
                        this.f3760q++;
                        if (this.f3757n == null) {
                            this.f3757n = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f3757n = angles;
                        angles[this.f3760q - 1] = f8;
                    }
                } else {
                    f8 = fArr[i7];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewT.getLayoutParams();
                layoutParams.f4552r = f8;
                layoutParams.f4548p = this.f3756m;
                layoutParams.f4550q = i8;
                viewT.setLayoutParams(layoutParams);
            }
        }
        p();
    }

    private float[] P(float[] angles, int index) {
        return (angles == null || index < 0 || index >= this.f3760q) ? angles : Q(angles, index);
    }

    public static float[] Q(float[] array, int index) {
        float[] fArr = new float[array.length - 1];
        int i7 = 0;
        for (int i8 = 0; i8 < array.length; i8++) {
            if (i8 != index) {
                fArr[i7] = array[i8];
                i7++;
            }
        }
        return fArr;
    }

    public static int[] R(int[] array, int index) {
        int[] iArr = new int[array.length - 1];
        int i7 = 0;
        for (int i8 = 0; i8 < array.length; i8++) {
            if (i8 != index) {
                iArr[i7] = array[i8];
                i7++;
            }
        }
        return iArr;
    }

    private int[] S(int[] radius, int index) {
        return (radius == null || index < 0 || index >= this.f3759p) ? radius : R(radius, index);
    }

    private void setAngles(String idList) {
        if (idList == null) {
            return;
        }
        int i7 = 0;
        this.f3760q = 0;
        while (true) {
            int iIndexOf = idList.indexOf(44, i7);
            if (iIndexOf == -1) {
                K(idList.substring(i7).trim());
                return;
            } else {
                K(idList.substring(i7, iIndexOf).trim());
                i7 = iIndexOf + 1;
            }
        }
    }

    private void setRadius(String idList) {
        if (idList == null) {
            return;
        }
        int i7 = 0;
        this.f3759p = 0;
        while (true) {
            int iIndexOf = idList.indexOf(44, i7);
            if (iIndexOf == -1) {
                L(idList.substring(i7).trim());
                return;
            } else {
                L(idList.substring(i7, iIndexOf).trim());
                i7 = iIndexOf + 1;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public int A(View view) {
        int iA = super.A(view);
        if (iA == -1) {
            return iA;
        }
        d dVar = new d();
        dVar.H(this.f3755l);
        dVar.F(view.getId(), 8);
        dVar.r(this.f3755l);
        float[] fArr = this.f3757n;
        if (iA < fArr.length) {
            this.f3757n = P(fArr, iA);
            this.f3760q--;
        }
        int[] iArr = this.f3758o;
        if (iA < iArr.length) {
            this.f3758o = S(iArr, iA);
            this.f3759p--;
        }
        N();
        return iA;
    }

    public void M(View view, int radius, float angle) {
        if (s(view.getId())) {
            return;
        }
        o(view);
        this.f3760q++;
        float[] angles = getAngles();
        this.f3757n = angles;
        angles[this.f3760q - 1] = angle;
        this.f3759p++;
        int[] radius2 = getRadius();
        this.f3758o = radius2;
        radius2[this.f3759p - 1] = (int) (radius * this.f4481c.getResources().getDisplayMetrics().density);
        N();
    }

    public boolean O(View view) {
        return s(view.getId()) && x(view.getId()) != -1;
    }

    public void T(View view, float angle) {
        if (!O(view)) {
            Log.e(f3752v, "It was not possible to update angle to view with id: " + view.getId());
            return;
        }
        int iX = x(view.getId());
        if (iX > this.f3757n.length) {
            return;
        }
        float[] angles = getAngles();
        this.f3757n = angles;
        angles[iX] = angle;
        N();
    }

    public void U(View view, int radius) {
        if (!O(view)) {
            Log.e(f3752v, "It was not possible to update radius to view with id: " + view.getId());
            return;
        }
        int iX = x(view.getId());
        if (iX > this.f3758o.length) {
            return;
        }
        int[] radius2 = getRadius();
        this.f3758o = radius2;
        radius2[iX] = (int) (radius * this.f4481c.getResources().getDisplayMetrics().density);
        N();
    }

    public void V(View view, int radius, float angle) {
        if (!O(view)) {
            Log.e(f3752v, "It was not possible to update radius and angle to view with id: " + view.getId());
            return;
        }
        int iX = x(view.getId());
        if (getAngles().length > iX) {
            float[] angles = getAngles();
            this.f3757n = angles;
            angles[iX] = angle;
        }
        if (getRadius().length > iX) {
            int[] radius2 = getRadius();
            this.f3758o = radius2;
            radius2[iX] = (int) (radius * this.f4481c.getResources().getDisplayMetrics().density);
        }
        N();
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f3757n, this.f3760q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f3758o, this.f3759p);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f3761r;
        if (str != null) {
            this.f3757n = new float[1];
            setAngles(str);
        }
        String str2 = this.f3762s;
        if (str2 != null) {
            this.f3758o = new int[1];
            setRadius(str2);
        }
        Float f8 = this.f3763t;
        if (f8 != null) {
            setDefaultAngle(f8.floatValue());
        }
        Integer num = this.f3764u;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        N();
    }

    public void setDefaultAngle(float angle) {
        f3754x = angle;
    }

    public void setDefaultRadius(int radius) {
        f3753w = radius;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void y(AttributeSet attrs) {
        super.y(attrs);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f3756m = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f3761r = string;
                    setAngles(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f3762s = string2;
                    setRadius(string2);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, f3754x));
                    this.f3763t = fValueOf;
                    setDefaultAngle(fValueOf.floatValue());
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer numValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, f3753w));
                    this.f3764u = numValueOf;
                    setDefaultRadius(numValueOf.intValue());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public CircularFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircularFlow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
