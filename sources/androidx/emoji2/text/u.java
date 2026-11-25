package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.core.text.i0;
import c.m0;
import c.t0;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes.dex */
class u implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7698a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private Spannable f7699b;

    @t0(24)
    private static class a {
        private a() {
        }

        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    static class b {
        b() {
        }

        boolean a(CharSequence charSequence) {
            return charSequence instanceof i0;
        }
    }

    @t0(28)
    static class c extends b {
        c() {
        }

        @Override // androidx.emoji2.text.u.b
        boolean a(CharSequence charSequence) {
            return androidx.core.text.n.a(charSequence) || (charSequence instanceof i0);
        }
    }

    u(@m0 Spannable spannable) {
        this.f7699b = spannable;
    }

    private void a() {
        Spannable spannable = this.f7699b;
        if (!this.f7698a && c().a(spannable)) {
            this.f7699b = new SpannableString(spannable);
        }
        this.f7698a = true;
    }

    static b c() {
        return Build.VERSION.SDK_INT < 28 ? new b() : new c();
    }

    Spannable b() {
        return this.f7699b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i7) {
        return this.f7699b.charAt(i7);
    }

    @Override // java.lang.CharSequence
    @t0(api = 24)
    @m0
    public IntStream chars() {
        return a.a(this.f7699b);
    }

    @Override // java.lang.CharSequence
    @t0(api = 24)
    @m0
    public IntStream codePoints() {
        return a.b(this.f7699b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f7699b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f7699b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f7699b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i7, int i8, Class<T> cls) {
        return (T[]) this.f7699b.getSpans(i7, i8, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f7699b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i7, int i8, Class cls) {
        return this.f7699b.nextSpanTransition(i7, i8, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f7699b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i7, int i8, int i9) {
        a();
        this.f7699b.setSpan(obj, i7, i8, i9);
    }

    @Override // java.lang.CharSequence
    @m0
    public CharSequence subSequence(int i7, int i8) {
        return this.f7699b.subSequence(i7, i8);
    }

    @Override // java.lang.CharSequence
    @m0
    public String toString() {
        return this.f7699b.toString();
    }

    u(@m0 Spanned spanned) {
        this.f7699b = new SpannableString(spanned);
    }

    u(@m0 CharSequence charSequence) {
        this.f7699b = new SpannableString(charSequence);
    }
}
