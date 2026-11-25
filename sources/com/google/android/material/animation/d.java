package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import c.m0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
public class d extends Property<ViewGroup, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Property<ViewGroup, Float> f16852a = new d("childrenAlpha");

    private d(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    @m0
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(@m0 ViewGroup viewGroup) {
        Float f8 = (Float) viewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
        return f8 != null ? f8 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(@m0 ViewGroup viewGroup, @m0 Float f8) {
        float fFloatValue = f8.floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(fFloatValue));
        int childCount = viewGroup.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            viewGroup.getChildAt(i7).setAlpha(fFloatValue);
        }
    }
}
