package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
@SuppressLint({"AppCompatCustomView"})
public class VisibilityAwareImageButton extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17754a;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public final void c(int i7, boolean z7) {
        super.setVisibility(i7);
        if (z7) {
            this.f17754a = i7;
        }
    }

    public final int getUserSetVisibility() {
        return this.f17754a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i7) {
        c(i7, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f17754a = getVisibility();
    }
}
