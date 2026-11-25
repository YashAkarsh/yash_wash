package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import c.e0;
import c.m0;
import c.t0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
@x0({x0.a.LIBRARY_GROUP})
@c.d
public class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7624d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7625e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7626f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ThreadLocal<androidx.emoji2.text.flatbuffer.o> f7627g = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final p f7629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f7630c = 0;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    i(@m0 p pVar, @e0(from = 0) int i7) {
        this.f7629b = pVar;
        this.f7628a = i7;
    }

    private androidx.emoji2.text.flatbuffer.o h() {
        ThreadLocal<androidx.emoji2.text.flatbuffer.o> threadLocal = f7627g;
        androidx.emoji2.text.flatbuffer.o oVar = threadLocal.get();
        if (oVar == null) {
            oVar = new androidx.emoji2.text.flatbuffer.o();
            threadLocal.set(oVar);
        }
        this.f7629b.g().J(oVar, this.f7628a);
        return oVar;
    }

    public void a(@m0 Canvas canvas, float f8, float f9, @m0 Paint paint) {
        Typeface typefaceJ = this.f7629b.j();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(typefaceJ);
        canvas.drawText(this.f7629b.f(), this.f7628a * 2, 2, f8, f9, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i7) {
        return h().F(i7);
    }

    public int c() {
        return h().I();
    }

    public short d() {
        return h().L();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int e() {
        return this.f7630c;
    }

    public short f() {
        return h().S();
    }

    public int g() {
        return h().T();
    }

    public short i() {
        return h().U();
    }

    @m0
    public Typeface j() {
        return this.f7629b.j();
    }

    public short k() {
        return h().X();
    }

    public boolean l() {
        return h().O();
    }

    @x0({x0.a.TESTS})
    public void m() {
        this.f7630c = 0;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void n(boolean z7) {
        this.f7630c = z7 ? 2 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(g()));
        sb.append(", codepoints:");
        int iC = c();
        for (int i7 = 0; i7 < iC; i7++) {
            sb.append(Integer.toHexString(b(i7)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
