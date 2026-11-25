package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import c.b0;
import c.h;
import c.m0;
import c.o0;
import c.p;
import c.q;
import com.google.android.material.R;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.n;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ChipGroup extends FlowLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f17340n = R.style.Widget_MaterialComponents_ChipGroup;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @q
    private int f17341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @q
    private int f17342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f17344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private c f17345i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b f17346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @m0
    private d f17347k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @b0
    private int f17348l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f17349m;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i7, int i8) {
            super(i7, i8);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    private class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(@m0 CompoundButton compoundButton, boolean z7) {
            if (ChipGroup.this.f17349m) {
                return;
            }
            if (ChipGroup.this.getCheckedChipIds().isEmpty() && ChipGroup.this.f17344h) {
                ChipGroup.this.s(compoundButton.getId(), true);
                ChipGroup.this.r(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (!z7) {
                if (ChipGroup.this.f17348l == id) {
                    ChipGroup.this.setCheckedId(-1);
                }
            } else {
                if (ChipGroup.this.f17348l != -1 && ChipGroup.this.f17348l != id && ChipGroup.this.f17343g) {
                    ChipGroup chipGroup = ChipGroup.this;
                    chipGroup.s(chipGroup.f17348l, false);
                }
                ChipGroup.this.setCheckedId(id);
            }
        }
    }

    public interface c {
        void a(ChipGroup chipGroup, @b0 int i7);
    }

    private class d implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f17351a;

        private d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(n2.D());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).m(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.f17346j);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f17351a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f17351a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    private int getChipCount() {
        int i7 = 0;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            if (getChildAt(i8) instanceof Chip) {
                i7++;
            }
        }
        return i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i7, boolean z7) {
        this.f17348l = i7;
        c cVar = this.f17345i;
        if (cVar != null && this.f17343g && z7) {
            cVar.a(this, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(@b0 int i7, boolean z7) {
        View viewFindViewById = findViewById(i7);
        if (viewFindViewById instanceof Chip) {
            this.f17349m = true;
            ((Chip) viewFindViewById).setChecked(z7);
            this.f17349m = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i7) {
        r(i7, true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i8 = this.f17348l;
                if (i8 != -1 && this.f17343g) {
                    s(i8, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i7, layoutParams);
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @Override // android.view.ViewGroup
    @m0
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    @m0
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @b0
    public int getCheckedChipId() {
        if (this.f17343g) {
            return this.f17348l;
        }
        return -1;
    }

    @m0
    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f17343g) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    @q
    public int getChipSpacingHorizontal() {
        return this.f17341e;
    }

    @q
    public int getChipSpacingVertical() {
        return this.f17342f;
    }

    public void m(@b0 int i7) {
        int i8 = this.f17348l;
        if (i7 == i8) {
            return;
        }
        if (i8 != -1 && this.f17343g) {
            s(i8, false);
        }
        if (i7 != -1) {
            s(i7, true);
        }
        setCheckedId(i7);
    }

    public void n() {
        this.f17349m = true;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.f17349m = false;
        setCheckedId(-1);
    }

    int o(@o0 View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            if (getChildAt(i8) instanceof Chip) {
                if (((Chip) getChildAt(i8)) == view) {
                    return i7;
                }
                i7++;
            }
        }
        return -1;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i7 = this.f17348l;
        if (i7 != -1) {
            s(i7, true);
            setCheckedId(this.f17348l);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@m0 AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        l0.X1(accessibilityNodeInfo).Y0(l0.b.f(getRowCount(), c() ? getChipCount() : -1, false, q() ? 1 : 2));
    }

    public boolean p() {
        return this.f17344h;
    }

    public boolean q() {
        return this.f17343g;
    }

    public void setChipSpacing(@q int i7) {
        setChipSpacingHorizontal(i7);
        setChipSpacingVertical(i7);
    }

    public void setChipSpacingHorizontal(@q int i7) {
        if (this.f17341e != i7) {
            this.f17341e = i7;
            setItemSpacing(i7);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@p int i7) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i7));
    }

    public void setChipSpacingResource(@p int i7) {
        setChipSpacing(getResources().getDimensionPixelOffset(i7));
    }

    public void setChipSpacingVertical(@q int i7) {
        if (this.f17342f != i7) {
            this.f17342f = i7;
            setLineSpacing(i7);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@p int i7) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i7));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@o0 Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i7) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(c cVar) {
        this.f17345i = cVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f17347k.f17351a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z7) {
        this.f17344h = z7;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i7) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i7) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z7) {
        super.setSingleLine(z7);
    }

    public void setSingleSelection(boolean z7) {
        if (this.f17343g != z7) {
            this.f17343g = z7;
            n();
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    @Override // android.view.ViewGroup
    @m0
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(@h int i7) {
        setSingleLine(getResources().getBoolean(i7));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet, int i7) {
        int i8 = f17340n;
        super(q1.a.c(context, attributeSet, i7, i8), attributeSet, i7);
        this.f17346j = new b();
        this.f17347k = new d();
        this.f17348l = -1;
        this.f17349m = false;
        TypedArray typedArrayJ = n.j(getContext(), attributeSet, R.styleable.ChipGroup, i7, i8, new int[0]);
        int dimensionPixelOffset = typedArrayJ.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayJ.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayJ.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayJ.getBoolean(R.styleable.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayJ.getBoolean(R.styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayJ.getBoolean(R.styleable.ChipGroup_selectionRequired, false));
        int resourceId = typedArrayJ.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
        if (resourceId != -1) {
            this.f17348l = resourceId;
        }
        typedArrayJ.recycle();
        super.setOnHierarchyChangeListener(this.f17347k);
        n2.R1(this, 1);
    }

    public void setSingleSelection(@h int i7) {
        setSingleSelection(getResources().getBoolean(i7));
    }
}
