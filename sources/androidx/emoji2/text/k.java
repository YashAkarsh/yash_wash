package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.w;
import c.m0;
import c.o0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
public abstract class k extends ReplacementSpan {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final i f7651b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint.FontMetricsInt f7650a = new Paint.FontMetricsInt();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private short f7652c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private short f7653d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f7654e = 1.0f;

    @x0({x0.a.LIBRARY})
    k(@m0 i iVar) {
        w.m(iVar, "metadata cannot be null");
        this.f7651b = iVar;
    }

    @x0({x0.a.TESTS})
    public final int a() {
        return this.f7653d;
    }

    @x0({x0.a.TESTS})
    public final int b() {
        return c().g();
    }

    @x0({x0.a.LIBRARY_GROUP})
    @m0
    public final i c() {
        return this.f7651b;
    }

    @x0({x0.a.LIBRARY})
    final float d() {
        return this.f7654e;
    }

    @x0({x0.a.LIBRARY})
    final int e() {
        return this.f7652c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@m0 Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i7, int i8, @o0 Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f7650a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f7650a;
        this.f7654e = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f7651b.f();
        this.f7653d = (short) (this.f7651b.f() * this.f7654e);
        short sK = (short) (this.f7651b.k() * this.f7654e);
        this.f7652c = sK;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f7650a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return sK;
    }
}
