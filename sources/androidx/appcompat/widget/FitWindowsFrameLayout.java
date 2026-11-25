package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
@c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
public class FitWindowsFrameLayout extends FrameLayout implements o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o0.a f1499a;

    public FitWindowsFrameLayout(@c.m0 Context context) {
        super(context);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        o0.a aVar = this.f1499a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.o0
    public void setOnFitSystemWindowsListener(o0.a aVar) {
        this.f1499a = aVar;
    }

    public FitWindowsFrameLayout(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
