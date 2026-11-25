package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
class b extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ActionBarContainer f1721a;

    @c.t0(21)
    private static class a {
        private a() {
        }

        public static void a(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }

    public b(ActionBarContainer actionBarContainer) {
        this.f1721a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f1721a;
        if (actionBarContainer.f1295h) {
            Drawable drawable = actionBarContainer.f1294g;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f1292e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f1721a;
        Drawable drawable3 = actionBarContainer2.f1293f;
        if (drawable3 == null || !actionBarContainer2.f1296i) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    @c.t0(21)
    public void getOutline(@c.m0 Outline outline) {
        ActionBarContainer actionBarContainer = this.f1721a;
        if (actionBarContainer.f1295h) {
            if (actionBarContainer.f1294g != null) {
                a.a(actionBarContainer.f1292e, outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f1292e;
            if (drawable != null) {
                a.a(drawable, outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
