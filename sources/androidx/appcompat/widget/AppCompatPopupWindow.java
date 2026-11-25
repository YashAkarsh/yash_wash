package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f1441b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1442a;

    public AppCompatPopupWindow(@c.m0 Context context, @c.o0 AttributeSet attributeSet, @c.f int i7) {
        super(context, attributeSet, i7);
        a(context, attributeSet, i7, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i7, int i8) {
        h1 h1VarG = h1.G(context, attributeSet, R.styleable.PopupWindow, i7, i8);
        if (h1VarG.C(R.styleable.PopupWindow_overlapAnchor)) {
            b(h1VarG.a(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(h1VarG.h(R.styleable.PopupWindow_android_popupBackground));
        h1VarG.I();
    }

    private void b(boolean z7) {
        if (f1441b) {
            this.f1442a = z7;
        } else {
            androidx.core.widget.s.c(this, z7);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i7, int i8) {
        if (f1441b && this.f1442a) {
            i8 -= view.getHeight();
        }
        super.showAsDropDown(view, i7, i8);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i7, int i8, int i9, int i10) {
        if (f1441b && this.f1442a) {
            i8 -= view.getHeight();
        }
        super.update(view, i7, i8, i9, i10);
    }

    public AppCompatPopupWindow(@c.m0 Context context, @c.o0 AttributeSet attributeSet, @c.f int i7, @c.b1 int i8) {
        super(context, attributeSet, i7, i8);
        a(context, attributeSet, i7, i8);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i7, int i8, int i9) {
        if (f1441b && this.f1442a) {
            i8 -= view.getHeight();
        }
        super.showAsDropDown(view, i7, i8, i9);
    }
}
