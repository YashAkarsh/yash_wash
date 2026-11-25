package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import c.m0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
class o extends p {
    protected o(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // androidx.core.graphics.drawable.p
    void f(int i7, int i8, int i9, Rect rect, Rect rect2) {
        Gravity.apply(i7, i8, i9, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@m0 Outline outline) {
        t();
        outline.setRoundRect(this.f5823h, c());
    }

    @Override // androidx.core.graphics.drawable.p
    public boolean h() {
        Bitmap bitmap = this.f5816a;
        return bitmap != null && bitmap.hasMipMap();
    }

    @Override // androidx.core.graphics.drawable.p
    public void o(boolean z7) {
        Bitmap bitmap = this.f5816a;
        if (bitmap != null) {
            bitmap.setHasMipMap(z7);
            invalidateSelf();
        }
    }
}
