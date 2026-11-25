package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import c.e0;
import c.m0;
import c.o0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
@x0({x0.a.LIBRARY_GROUP})
public final class r extends k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private static Paint f7697f;

    public r(@m0 i iVar) {
        super(iVar);
    }

    @m0
    private static Paint f() {
        if (f7697f == null) {
            TextPaint textPaint = new TextPaint();
            f7697f = textPaint;
            textPaint.setColor(f.b().e());
            f7697f.setStyle(Paint.Style.FILL);
        }
        return f7697f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@m0 Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, @e0(from = 0) int i7, @e0(from = 0) int i8, float f8, int i9, int i10, int i11, @m0 Paint paint) {
        if (f.b().o()) {
            canvas.drawRect(f8, i9, f8 + e(), i11, f());
        }
        c().a(canvas, f8, i10, paint);
    }
}
