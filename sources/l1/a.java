package l1;

import android.R;
import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Dialog f37409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f37410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f37411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f37412d;

    public a(@m0 Dialog dialog, @m0 Rect rect) {
        this.f37409a = dialog;
        this.f37410b = rect.left;
        this.f37411c = rect.top;
        this.f37412d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(@m0 View view, @m0 MotionEvent motionEvent) {
        View viewFindViewById = view.findViewById(R.id.content);
        int left = this.f37410b + viewFindViewById.getLeft();
        int width = viewFindViewById.getWidth() + left;
        int top = this.f37411c + viewFindViewById.getTop();
        if (new RectF(left, top, width, viewFindViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            motionEventObtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            motionEventObtain.setAction(0);
            int i7 = this.f37412d;
            motionEventObtain.setLocation((-i7) - 1, (-i7) - 1);
        }
        view.performClick();
        return this.f37409a.onTouchEvent(motionEventObtain);
    }
}
