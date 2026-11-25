package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.h1;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
public class TabItem extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f18505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f18506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18507c;

    public TabItem(Context context) {
        this(context, null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h1 h1VarF = h1.F(context, attributeSet, R.styleable.TabItem);
        this.f18505a = h1VarF.x(R.styleable.TabItem_android_text);
        this.f18506b = h1VarF.h(R.styleable.TabItem_android_icon);
        this.f18507c = h1VarF.u(R.styleable.TabItem_android_layout, 0);
        h1VarF.I();
    }
}
