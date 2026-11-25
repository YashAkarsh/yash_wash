package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import androidx.core.view.s0;
import c.b0;
import c.g1;
import c.h;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.internal.n;
import com.google.android.material.internal.v;
import com.google.android.material.shape.o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f17234k = "MaterialButtonToggleGroup";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f17235l = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<d> f17236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f17237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f17238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashSet<e> f17239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Comparator<MaterialButton> f17240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer[] f17241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17242g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f17243h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f17244i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @b0
    private int f17245j;

    class a implements Comparator<MaterialButton> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    class b extends androidx.core.view.a {
        b() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            l0Var.Z0(l0.c.h(0, 1, MaterialButtonToggleGroup.this.p(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    private class c implements MaterialButton.b {
        private c() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(@m0 MaterialButton materialButton, boolean z7) {
            if (MaterialButtonToggleGroup.this.f17242g) {
                return;
            }
            if (MaterialButtonToggleGroup.this.f17243h) {
                MaterialButtonToggleGroup.this.f17245j = z7 ? materialButton.getId() : -1;
            }
            if (MaterialButtonToggleGroup.this.z(materialButton.getId(), z7)) {
                MaterialButtonToggleGroup.this.n(materialButton.getId(), materialButton.isChecked());
            }
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ c(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    private static class d {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final com.google.android.material.shape.d f17249e = new com.google.android.material.shape.a(0.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.google.android.material.shape.d f17250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        com.google.android.material.shape.d f17251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        com.google.android.material.shape.d f17252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.google.android.material.shape.d f17253d;

        d(com.google.android.material.shape.d dVar, com.google.android.material.shape.d dVar2, com.google.android.material.shape.d dVar3, com.google.android.material.shape.d dVar4) {
            this.f17250a = dVar;
            this.f17251b = dVar3;
            this.f17252c = dVar4;
            this.f17253d = dVar2;
        }

        public static d a(d dVar) {
            com.google.android.material.shape.d dVar2 = f17249e;
            return new d(dVar2, dVar.f17253d, dVar2, dVar.f17252c);
        }

        public static d b(d dVar, View view) {
            return v.j(view) ? c(dVar) : d(dVar);
        }

        public static d c(d dVar) {
            com.google.android.material.shape.d dVar2 = dVar.f17250a;
            com.google.android.material.shape.d dVar3 = dVar.f17253d;
            com.google.android.material.shape.d dVar4 = f17249e;
            return new d(dVar2, dVar3, dVar4, dVar4);
        }

        public static d d(d dVar) {
            com.google.android.material.shape.d dVar2 = f17249e;
            return new d(dVar2, dVar2, dVar.f17251b, dVar.f17252c);
        }

        public static d e(d dVar, View view) {
            return v.j(view) ? d(dVar) : c(dVar);
        }

        public static d f(d dVar) {
            com.google.android.material.shape.d dVar2 = dVar.f17250a;
            com.google.android.material.shape.d dVar3 = f17249e;
            return new d(dVar2, dVar3, dVar.f17251b, dVar3);
        }
    }

    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, @b0 int i7, boolean z7);
    }

    private class f implements MaterialButton.c {
        private f() {
        }

        @Override // com.google.android.material.button.MaterialButton.c
        public void a(@m0 MaterialButton materialButton, boolean z7) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ f(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(@m0 Context context) {
        this(context, null);
    }

    private void A() {
        TreeMap treeMap = new TreeMap(this.f17240e);
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            treeMap.put(o(i7), Integer.valueOf(i7));
        }
        this.f17241f = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            if (r(i7)) {
                return i7;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (r(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i7 = 0;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            if ((getChildAt(i8) instanceof MaterialButton) && r(i8)) {
                i7++;
            }
        }
        return i7;
    }

    private void h() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i7 = firstVisibleChildIndex + 1; i7 < getChildCount(); i7++) {
            MaterialButton materialButtonO = o(i7);
            int iMin = Math.min(materialButtonO.getStrokeWidth(), o(i7 - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsI = i(materialButtonO);
            if (getOrientation() == 0) {
                s0.g(layoutParamsI, 0);
                s0.h(layoutParamsI, -iMin);
                layoutParamsI.topMargin = 0;
            } else {
                layoutParamsI.bottomMargin = 0;
                layoutParamsI.topMargin = -iMin;
                s0.h(layoutParamsI, 0);
            }
            materialButtonO.setLayoutParams(layoutParamsI);
        }
        v(firstVisibleChildIndex);
    }

    @m0
    private LinearLayout.LayoutParams i(@m0 View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void k(int i7, boolean z7) {
        MaterialButton materialButton = (MaterialButton) findViewById(i7);
        if (materialButton != null) {
            materialButton.setChecked(z7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@b0 int i7, boolean z7) {
        Iterator<e> it = this.f17239d.iterator();
        while (it.hasNext()) {
            it.next().a(this, i7, z7);
        }
    }

    private MaterialButton o(int i7) {
        return (MaterialButton) getChildAt(i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p(@o0 View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            if (getChildAt(i8) == view) {
                return i7;
            }
            if ((getChildAt(i8) instanceof MaterialButton) && r(i8)) {
                i7++;
            }
        }
        return -1;
    }

    @o0
    private d q(int i7, int i8, int i9) {
        d dVar = this.f17236a.get(i7);
        if (i8 == i9) {
            return dVar;
        }
        boolean z7 = getOrientation() == 0;
        if (i7 == i8) {
            return z7 ? d.e(dVar, this) : d.f(dVar);
        }
        if (i7 == i9) {
            return z7 ? d.b(dVar, this) : d.a(dVar);
        }
        return null;
    }

    private boolean r(int i7) {
        return getChildAt(i7).getVisibility() != 8;
    }

    private void setCheckedId(int i7) {
        this.f17245j = i7;
        n(i7, true);
    }

    private void setGeneratedIdIfNeeded(@m0 MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(n2.D());
        }
    }

    private void setupButtonChild(@m0 MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.a(this.f17237b);
        materialButton.setOnPressedChangeListenerInternal(this.f17238c);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private void v(int i7) {
        if (getChildCount() == 0 || i7 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) o(i7).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            s0.g(layoutParams, 0);
            s0.h(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void w(@b0 int i7, boolean z7) {
        View viewFindViewById = findViewById(i7);
        if (viewFindViewById instanceof MaterialButton) {
            this.f17242g = true;
            ((MaterialButton) viewFindViewById).setChecked(z7);
            this.f17242g = false;
        }
    }

    private static void y(o.b bVar, @o0 d dVar) {
        if (dVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.L(dVar.f17250a).y(dVar.f17253d).Q(dVar.f17251b).D(dVar.f17252c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z(int i7, boolean z7) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.f17244i && checkedButtonIds.isEmpty()) {
            w(i7, true);
            this.f17245j = i7;
            return false;
        }
        if (z7 && this.f17243h) {
            checkedButtonIds.remove(Integer.valueOf(i7));
            Iterator<Integer> it = checkedButtonIds.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                w(iIntValue, false);
                n(iIntValue, false);
            }
        }
        return true;
    }

    @g1
    void B() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i7 = 0; i7 < childCount; i7++) {
            MaterialButton materialButtonO = o(i7);
            if (materialButtonO.getVisibility() != 8) {
                o.b bVarV = materialButtonO.getShapeAppearanceModel().v();
                y(bVarV, q(i7, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonO.setShapeAppearanceModel(bVarV.m());
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f17234k, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i7, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            z(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        o shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f17236a.add(new d(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        n2.B1(materialButton, new b());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@m0 Canvas canvas) {
        A();
        super.dispatchDraw(canvas);
    }

    public void g(@m0 e eVar) {
        this.f17239d.add(eVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @m0
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @b0
    public int getCheckedButtonId() {
        if (this.f17243h) {
            return this.f17245j;
        }
        return -1;
    }

    @m0
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            MaterialButton materialButtonO = o(i7);
            if (materialButtonO.isChecked()) {
                arrayList.add(Integer.valueOf(materialButtonO.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i7, int i8) {
        Integer[] numArr = this.f17241f;
        if (numArr != null && i8 < numArr.length) {
            return numArr[i8].intValue();
        }
        Log.w(f17234k, "Child order wasn't updated");
        return i8;
    }

    public void j(@b0 int i7) {
        if (i7 == this.f17245j) {
            return;
        }
        k(i7, true);
    }

    public void l() {
        this.f17242g = true;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            MaterialButton materialButtonO = o(i7);
            materialButtonO.setChecked(false);
            n(materialButtonO.getId(), false);
        }
        this.f17242g = false;
        setCheckedId(-1);
    }

    public void m() {
        this.f17239d.clear();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i7 = this.f17245j;
        if (i7 != -1) {
            k(i7, true);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@m0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        l0.X1(accessibilityNodeInfo).Y0(l0.b.f(1, getVisibleButtonCount(), false, t() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i7, int i8) {
        B();
        h();
        super.onMeasure(i7, i8);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.j(this.f17237b);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f17236a.remove(iIndexOfChild);
        }
        B();
        h();
    }

    public boolean s() {
        return this.f17244i;
    }

    public void setSelectionRequired(boolean z7) {
        this.f17244i = z7;
    }

    public void setSingleSelection(boolean z7) {
        if (this.f17243h != z7) {
            this.f17243h = z7;
            l();
        }
    }

    public boolean t() {
        return this.f17243h;
    }

    public void u(@m0 e eVar) {
        this.f17239d.remove(eVar);
    }

    public void x(@b0 int i7) {
        k(i7, false);
    }

    public MaterialButtonToggleGroup(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        int i8 = f17235l;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.f17236a = new ArrayList();
        a aVar = null;
        this.f17237b = new c(this, aVar);
        this.f17238c = new f(this, aVar);
        this.f17239d = new LinkedHashSet<>();
        this.f17240e = new a();
        this.f17242g = false;
        TypedArray typedArrayJ = n.j(getContext(), attributeSet, R.styleable.MaterialButtonToggleGroup, i7, i8, new int[0]);
        setSingleSelection(typedArrayJ.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.f17245j = typedArrayJ.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.f17244i = typedArrayJ.getBoolean(R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayJ.recycle();
        n2.R1(this, 1);
    }

    public void setSingleSelection(@h int i7) {
        setSingleSelection(getResources().getBoolean(i7));
    }
}
