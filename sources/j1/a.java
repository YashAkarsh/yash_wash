package j1;

import android.graphics.Canvas;
import android.graphics.RectF;
import c.m0;
import c.o0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class a {
    private a() {
    }

    public static int a(@m0 Canvas canvas, float f8, float f9, float f10, float f11, int i7) {
        return canvas.saveLayerAlpha(f8, f9, f10, f11, i7);
    }

    public static int b(@m0 Canvas canvas, @o0 RectF rectF, int i7) {
        return canvas.saveLayerAlpha(rectF, i7);
    }
}
