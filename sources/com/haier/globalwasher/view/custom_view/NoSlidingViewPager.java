package com.haier.globalwasher.view.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes2.dex */
public class NoSlidingViewPager extends ViewPager {

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    private boolean f25825c1;

    public NoSlidingViewPager(Context context) {
        super(context);
        this.f25825c1 = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f25825c1 && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f25825c1 && super.onTouchEvent(motionEvent);
    }

    public void setSlide(boolean z7) {
        this.f25825c1 = z7;
    }

    public NoSlidingViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25825c1 = false;
    }
}
