package androidx.recyclerview.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class j extends RecyclerView.n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9553d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f9554e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9555f = "DividerItem";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f9556g = {R.attr.listDivider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f9557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f9559c = new Rect();

    public j(Context context, int i7) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f9556g);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f9557a = drawable;
        if (drawable == null) {
            Log.w(f9555f, "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        typedArrayObtainStyledAttributes.recycle();
        p(i7);
    }

    private void l(Canvas canvas, RecyclerView recyclerView) {
        int height;
        int paddingTop;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingTop = recyclerView.getPaddingTop();
            height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), paddingTop, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
        } else {
            height = recyclerView.getHeight();
            paddingTop = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = recyclerView.getChildAt(i7);
            recyclerView.getLayoutManager().X(childAt, this.f9559c);
            int iRound = this.f9559c.right + Math.round(childAt.getTranslationX());
            this.f9557a.setBounds(iRound - this.f9557a.getIntrinsicWidth(), paddingTop, iRound, height);
            this.f9557a.draw(canvas);
        }
        canvas.restore();
    }

    private void m(Canvas canvas, RecyclerView recyclerView) {
        int width;
        int paddingLeft;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            paddingLeft = recyclerView.getPaddingLeft();
            width = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(paddingLeft, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            width = recyclerView.getWidth();
            paddingLeft = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = recyclerView.getChildAt(i7);
            recyclerView.u0(childAt, this.f9559c);
            int iRound = this.f9559c.bottom + Math.round(childAt.getTranslationY());
            this.f9557a.setBounds(paddingLeft, iRound - this.f9557a.getIntrinsicHeight(), width, iRound);
            this.f9557a.draw(canvas);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        Drawable drawable = this.f9557a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f9558b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (recyclerView.getLayoutManager() == null || this.f9557a == null) {
            return;
        }
        if (this.f9558b == 1) {
            m(canvas, recyclerView);
        } else {
            l(canvas, recyclerView);
        }
    }

    @o0
    public Drawable n() {
        return this.f9557a;
    }

    public void o(@m0 Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.f9557a = drawable;
    }

    public void p(int i7) {
        if (i7 != 0 && i7 != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.f9558b = i7;
    }
}
