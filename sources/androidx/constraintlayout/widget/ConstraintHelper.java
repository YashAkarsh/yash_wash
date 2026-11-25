package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.i;
import androidx.constraintlayout.core.widgets.j;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ConstraintHelper extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int[] f4479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f4480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f4481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected i f4482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f4483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f4484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f4485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View[] f4486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected HashMap<Integer, String> f4487i;

    public ConstraintHelper(Context context) {
        super(context);
        this.f4479a = new int[32];
        this.f4483e = false;
        this.f4486h = null;
        this.f4487i = new HashMap<>();
        this.f4481c = context;
        y(null);
    }

    private void l(String idString) {
        if (idString == null || idString.length() == 0 || this.f4481c == null) {
            return;
        }
        String strTrim = idString.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iV = v(strTrim);
        if (iV != 0) {
            this.f4487i.put(Integer.valueOf(iV), strTrim);
            m(iV);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    private void m(int id) {
        if (id == getId()) {
            return;
        }
        int i7 = this.f4480b + 1;
        int[] iArr = this.f4479a;
        if (i7 > iArr.length) {
            this.f4479a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f4479a;
        int i8 = this.f4480b;
        iArr2[i8] = id;
        this.f4480b = i8 + 1;
    }

    private void n(String tagString) {
        if (tagString == null || tagString.length() == 0 || this.f4481c == null) {
            return;
        }
        String strTrim = tagString.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && strTrim.equals(((ConstraintLayout.LayoutParams) layoutParams).f4523c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    m(childAt.getId());
                }
            }
        }
    }

    private int[] t(View view, String referenceIdString) {
        String[] strArrSplit = referenceIdString.split(",");
        view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i7 = 0;
        for (String str : strArrSplit) {
            int iV = v(str.trim());
            if (iV != 0) {
                iArr[i7] = iV;
                i7++;
            }
        }
        return i7 != strArrSplit.length ? Arrays.copyOf(iArr, i7) : iArr;
    }

    private int u(ConstraintLayout container, String idString) {
        Resources resources;
        String resourceEntryName;
        if (idString == null || container == null || (resources = this.f4481c.getResources()) == null) {
            return 0;
        }
        int childCount = container.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = container.getChildAt(i7);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (idString.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int v(String referenceId) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iU = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object objN = constraintLayout.n(0, referenceId);
            if (objN instanceof Integer) {
                iU = ((Integer) objN).intValue();
            }
        }
        if (iU == 0 && constraintLayout != null) {
            iU = u(constraintLayout, referenceId);
        }
        if (iU == 0) {
            try {
                iU = R.id.class.getField(referenceId).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iU == 0 ? this.f4481c.getResources().getIdentifier(referenceId, "id", this.f4481c.getPackageName()) : iU;
    }

    public int A(View view) {
        int i7;
        int id = view.getId();
        int i8 = -1;
        if (id == -1) {
            return -1;
        }
        this.f4484f = null;
        for (int i9 = 0; i9 < this.f4480b; i9++) {
            if (this.f4479a[i9] == id) {
                int i10 = i9;
                while (true) {
                    i7 = this.f4480b;
                    if (i10 >= i7 - 1) {
                        break;
                    }
                    int[] iArr = this.f4479a;
                    int i11 = i10 + 1;
                    iArr[i10] = iArr[i11];
                    i10 = i11;
                }
                this.f4479a[i7 - 1] = 0;
                this.f4480b = i7 - 1;
                i8 = i9;
                break;
            }
        }
        requestLayout();
        return i8;
    }

    public void B(androidx.constraintlayout.core.widgets.e widget, boolean isRtl) {
    }

    public void C(ConstraintLayout container) {
    }

    public void D(ConstraintLayout container) {
    }

    public void E(ConstraintLayout container) {
    }

    public void F(ConstraintLayout container) {
    }

    public void G(androidx.constraintlayout.core.widgets.f container, i helper, SparseArray<androidx.constraintlayout.core.widgets.e> map) {
        helper.a();
        for (int i7 = 0; i7 < this.f4480b; i7++) {
            helper.b(map.get(this.f4479a[i7]));
        }
    }

    public void H(ConstraintLayout container) {
        String str;
        int iU;
        if (isInEditMode()) {
            setIds(this.f4484f);
        }
        i iVar = this.f4482d;
        if (iVar == null) {
            return;
        }
        iVar.a();
        for (int i7 = 0; i7 < this.f4480b; i7++) {
            int i8 = this.f4479a[i7];
            View viewT = container.t(i8);
            if (viewT == null && (iU = u(container, (str = this.f4487i.get(Integer.valueOf(i8))))) != 0) {
                this.f4479a[i7] = iU;
                this.f4487i.put(Integer.valueOf(iU), str);
                viewT = container.t(iU);
            }
            if (viewT != null) {
                this.f4482d.b(container.u(viewT));
            }
        }
        this.f4482d.c(container.f4491c);
    }

    public void I() {
        if (this.f4482d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).f4561v0 = (androidx.constraintlayout.core.widgets.e) this.f4482d;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f4479a, this.f4480b);
    }

    public void o(View view) {
        if (view == this) {
            return;
        }
        if (view.getId() == -1) {
            Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
        } else {
            if (view.getParent() == null) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
                return;
            }
            this.f4484f = null;
            m(view.getId());
            requestLayout();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f4484f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f4485g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f4483e) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    protected void p() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        q((ConstraintLayout) parent);
    }

    protected void q(ConstraintLayout container) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i7 = 0; i7 < this.f4480b; i7++) {
            View viewT = container.t(this.f4479a[i7]);
            if (viewT != null) {
                viewT.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewT.setTranslationZ(viewT.getTranslationZ() + elevation);
                }
            }
        }
    }

    protected void r(ConstraintLayout container) {
    }

    public boolean s(final int id) {
        for (int i7 : this.f4479a) {
            if (i7 == id) {
                return true;
            }
        }
        return false;
    }

    protected void setIds(String idList) {
        this.f4484f = idList;
        if (idList == null) {
            return;
        }
        int i7 = 0;
        this.f4480b = 0;
        while (true) {
            int iIndexOf = idList.indexOf(44, i7);
            if (iIndexOf == -1) {
                l(idList.substring(i7));
                return;
            } else {
                l(idList.substring(i7, iIndexOf));
                i7 = iIndexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String tagList) {
        this.f4485g = tagList;
        if (tagList == null) {
            return;
        }
        int i7 = 0;
        this.f4480b = 0;
        while (true) {
            int iIndexOf = tagList.indexOf(44, i7);
            if (iIndexOf == -1) {
                n(tagList.substring(i7));
                return;
            } else {
                n(tagList.substring(i7, iIndexOf));
                i7 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] ids) {
        this.f4484f = null;
        this.f4480b = 0;
        for (int i7 : ids) {
            m(i7);
        }
    }

    @Override // android.view.View
    public void setTag(int key, Object tag) {
        super.setTag(key, tag);
        if (tag == null && this.f4484f == null) {
            m(key);
        }
    }

    protected View[] w(ConstraintLayout layout) {
        View[] viewArr = this.f4486h;
        if (viewArr == null || viewArr.length != this.f4480b) {
            this.f4486h = new View[this.f4480b];
        }
        for (int i7 = 0; i7 < this.f4480b; i7++) {
            this.f4486h[i7] = layout.t(this.f4479a[i7]);
        }
        return this.f4486h;
    }

    public int x(final int id) {
        int i7 = -1;
        for (int i8 : this.f4479a) {
            i7++;
            if (i8 == id) {
                return i7;
            }
        }
        return i7;
    }

    protected void y(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f4484f = string;
                    setIds(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f4485g = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void z(d.a constraint, j child, ConstraintLayout.LayoutParams layoutParams, SparseArray<androidx.constraintlayout.core.widgets.e> mapIdToWidget) {
        d.b bVar = constraint.f4769e;
        int[] iArr = bVar.f4846k0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = bVar.f4848l0;
            if (str != null) {
                if (str.length() > 0) {
                    d.b bVar2 = constraint.f4769e;
                    bVar2.f4846k0 = t(this, bVar2.f4848l0);
                } else {
                    constraint.f4769e.f4846k0 = null;
                }
            }
        }
        if (child == null) {
            return;
        }
        child.a();
        if (constraint.f4769e.f4846k0 == null) {
            return;
        }
        int i7 = 0;
        while (true) {
            int[] iArr2 = constraint.f4769e.f4846k0;
            if (i7 >= iArr2.length) {
                return;
            }
            androidx.constraintlayout.core.widgets.e eVar = mapIdToWidget.get(iArr2[i7]);
            if (eVar != null) {
                child.b(eVar);
            }
            i7++;
        }
    }

    public ConstraintHelper(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4479a = new int[32];
        this.f4483e = false;
        this.f4486h = null;
        this.f4487i = new HashMap<>();
        this.f4481c = context;
        y(attrs);
    }

    public ConstraintHelper(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4479a = new int[32];
        this.f4483e = false;
        this.f4486h = null;
        this.f4487i = new HashMap<>();
        this.f4481c = context;
        y(attrs);
    }
}
