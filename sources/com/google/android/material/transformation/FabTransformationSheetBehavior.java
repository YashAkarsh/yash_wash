package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.n2;
import c.i;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.animation.h;
import com.google.android.material.animation.j;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @o0
    private Map<View, Integer> f18906l;

    public FabTransformationSheetBehavior() {
    }

    private void j0(@m0 View view, boolean z7) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z7) {
                this.f18906l = new HashMap(childCount);
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = coordinatorLayout.getChildAt(i7);
                boolean z8 = (childAt.getLayoutParams() instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z8) {
                    if (z7) {
                        this.f18906l.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        n2.R1(childAt, 4);
                    } else {
                        Map<View, Integer> map = this.f18906l;
                        if (map != null && map.containsKey(childAt)) {
                            n2.R1(childAt, this.f18906l.get(childAt).intValue());
                        }
                    }
                }
            }
            if (z7) {
                return;
            }
            this.f18906l = null;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    @i
    protected boolean K(@m0 View view, @m0 View view2, boolean z7, boolean z8) {
        j0(view2, z7);
        return super.K(view, view2, z7, z8);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    @m0
    protected FabTransformationBehavior.e h0(Context context, boolean z7) {
        int i7 = z7 ? R.animator.mtrl_fab_transformation_sheet_expand_spec : R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationBehavior.e eVar = new FabTransformationBehavior.e();
        eVar.f18895a = h.d(context, i7);
        eVar.f18896b = new j(17, 0.0f, 0.0f);
        return eVar;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
