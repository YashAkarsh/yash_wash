package com.haier.globalwasher.view.custom_view.mlistview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;

/* JADX INFO: loaded from: classes2.dex */
public class MListviewElastic extends ListView implements GestureDetector.OnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f25863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    GestureDetector f25867e;

    public MListviewElastic(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f25863a = null;
        this.f25864b = false;
        this.f25867e = new GestureDetector(this.f25863a, this);
        this.f25863a = context;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && this.f25864b) {
            this.f25864b = false;
        }
        if (this.f25867e.onTouchEvent(motionEvent)) {
            this.f25864b = true;
        } else {
            this.f25864b = false;
        }
        Rect rect = new Rect();
        getLocalVisibleRect(rect);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -rect.top, 0.0f);
        translateAnimation.setDuration(300L);
        startAnimation(translateAnimation);
        scrollTo(0, 0);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f8, float f9) {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        int count = getCount();
        if (this.f25864b && firstVisiblePosition != 0 && lastVisiblePosition != count - 1) {
            scrollTo(0, 0);
            return false;
        }
        View childAt = getChildAt(firstVisiblePosition);
        if (!this.f25864b) {
            this.f25866d = (int) motionEvent2.getRawY();
        }
        if (childAt == null || !(this.f25864b || (firstVisiblePosition == 0 && childAt.getTop() == 0 && f9 < 0.0f))) {
            return false;
        }
        int rawY = this.f25866d - ((int) motionEvent2.getRawY());
        this.f25865c = rawY;
        scrollTo(0, rawY / 2);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public MListviewElastic(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f25863a = null;
        this.f25864b = false;
        this.f25867e = new GestureDetector(this.f25863a, this);
        this.f25863a = context;
    }

    public MListviewElastic(Context context) {
        super(context);
        this.f25863a = null;
        this.f25864b = false;
        this.f25867e = new GestureDetector(this.f25863a, this);
        this.f25863a = context;
    }
}
