package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.core.graphics.d2;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
@c.d
class e implements f.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f7458b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f7459c = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f7460a;

    e() {
        TextPaint textPaint = new TextPaint();
        this.f7460a = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder b() {
        ThreadLocal<StringBuilder> threadLocal = f7459c;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.f.e
    public boolean a(@m0 CharSequence charSequence, int i7, int i8, int i9) {
        StringBuilder sbB = b();
        sbB.setLength(0);
        while (i7 < i8) {
            sbB.append(charSequence.charAt(i7));
            i7++;
        }
        return d2.a(this.f7460a, sbB.toString());
    }
}
