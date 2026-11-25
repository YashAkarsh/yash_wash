package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(17)
class a extends c {

    /* JADX INFO: renamed from: androidx.cardview.widget.a$a, reason: collision with other inner class name */
    class C0032a implements g.a {
        C0032a() {
        }

        @Override // androidx.cardview.widget.g.a
        public void a(Canvas canvas, RectF rectF, float f8, Paint paint) {
            canvas.drawRoundRect(rectF, f8, f8, paint);
        }
    }

    a() {
    }

    @Override // androidx.cardview.widget.c, androidx.cardview.widget.e
    public void j() {
        g.f2238s = new C0032a();
    }
}
