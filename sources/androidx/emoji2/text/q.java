package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.w;
import c.m0;
import c.o0;
import c.x0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class q extends SpannableStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Class<?> f7693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final List<a> f7694b;

    private static class a implements TextWatcher, SpanWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f7695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicInteger f7696b = new AtomicInteger(0);

        a(Object obj) {
            this.f7695a = obj;
        }

        private boolean b(Object obj) {
            return obj instanceof k;
        }

        final void a() {
            this.f7696b.incrementAndGet();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            ((TextWatcher) this.f7695a).afterTextChanged(editable);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            ((TextWatcher) this.f7695a).beforeTextChanged(charSequence, i7, i8, i9);
        }

        final void c() {
            this.f7696b.decrementAndGet();
        }

        @Override // android.text.SpanWatcher
        public void onSpanAdded(Spannable spannable, Object obj, int i7, int i8) {
            if (this.f7696b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f7695a).onSpanAdded(spannable, obj, i7, i8);
            }
        }

        /* JADX WARN: Code duplicated, block: B:14:0x001e A[PHI: r11
          0x001e: PHI (r11v1 int) = (r11v0 int), (r11v3 int) binds: [B:8:0x0013, B:12:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // android.text.SpanWatcher
        public void onSpanChanged(Spannable spannable, Object obj, int i7, int i8, int i9, int i10) {
            int i11;
            int i12;
            if (this.f7696b.get() <= 0 || !b(obj)) {
                if (Build.VERSION.SDK_INT >= 28) {
                    i11 = i7;
                    i12 = i9;
                } else {
                    if (i7 > i8) {
                        i7 = 0;
                    }
                    if (i9 > i10) {
                        i11 = i7;
                        i12 = 0;
                    } else {
                        i11 = i7;
                        i12 = i9;
                    }
                }
                ((SpanWatcher) this.f7695a).onSpanChanged(spannable, obj, i11, i8, i12, i10);
            }
        }

        @Override // android.text.SpanWatcher
        public void onSpanRemoved(Spannable spannable, Object obj, int i7, int i8) {
            if (this.f7696b.get() <= 0 || !b(obj)) {
                ((SpanWatcher) this.f7695a).onSpanRemoved(spannable, obj, i7, i8);
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            ((TextWatcher) this.f7695a).onTextChanged(charSequence, i7, i8, i9);
        }
    }

    @x0({x0.a.LIBRARY})
    q(@m0 Class<?> cls) {
        this.f7694b = new ArrayList();
        w.m(cls, "watcherClass cannot be null");
        this.f7693a = cls;
    }

    private void b() {
        for (int i7 = 0; i7 < this.f7694b.size(); i7++) {
            this.f7694b.get(i7).a();
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @m0
    public static q c(@m0 Class<?> cls, @m0 CharSequence charSequence) {
        return new q(cls, charSequence);
    }

    private void e() {
        for (int i7 = 0; i7 < this.f7694b.size(); i7++) {
            this.f7694b.get(i7).onTextChanged(this, 0, length(), length());
        }
    }

    private a f(Object obj) {
        for (int i7 = 0; i7 < this.f7694b.size(); i7++) {
            a aVar = this.f7694b.get(i7);
            if (aVar.f7695a == obj) {
                return aVar;
            }
        }
        return null;
    }

    private boolean g(@m0 Class<?> cls) {
        return this.f7693a == cls;
    }

    private boolean h(@o0 Object obj) {
        return obj != null && g(obj.getClass());
    }

    private void i() {
        for (int i7 = 0; i7 < this.f7694b.size(); i7++) {
            this.f7694b.get(i7).c();
        }
    }

    @x0({x0.a.LIBRARY})
    public void a() {
        b();
    }

    @x0({x0.a.LIBRARY})
    public void d() {
        i();
        e();
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanEnd(@o0 Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanFlags(@o0 Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int getSpanStart(@o0 Object obj) {
        a aVarF;
        if (h(obj) && (aVarF = f(obj)) != null) {
            obj = aVarF;
        }
        return super.getSpanStart(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    @SuppressLint({"UnknownNullness"})
    public <T> T[] getSpans(int i7, int i8, @m0 Class<T> cls) {
        if (!g(cls)) {
            return (T[]) super.getSpans(i7, i8, cls);
        }
        a[] aVarArr = (a[]) super.getSpans(i7, i8, a.class);
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, aVarArr.length));
        for (int i9 = 0; i9 < aVarArr.length; i9++) {
            tArr[i9] = aVarArr[i9].f7695a;
        }
        return tArr;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spanned
    public int nextSpanTransition(int i7, int i8, @o0 Class cls) {
        if (cls == null || g(cls)) {
            cls = a.class;
        }
        return super.nextSpanTransition(i7, i8, cls);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void removeSpan(@o0 Object obj) {
        a aVarF;
        if (h(obj)) {
            aVarF = f(obj);
            if (aVarF != null) {
                obj = aVarF;
            }
        } else {
            aVarF = null;
        }
        super.removeSpan(obj);
        if (aVarF != null) {
            this.f7694b.remove(aVarF);
        }
    }

    @Override // android.text.SpannableStringBuilder, android.text.Spannable
    public void setSpan(@o0 Object obj, int i7, int i8, int i9) {
        if (h(obj)) {
            a aVar = new a(obj);
            this.f7694b.add(aVar);
            obj = aVar;
        }
        super.setSpan(obj, i7, i8, i9);
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    @SuppressLint({"UnknownNullness"})
    public CharSequence subSequence(int i7, int i8) {
        return new q(this.f7693a, this, i7, i8);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder delete(int i7, int i8) {
        super.delete(i7, i8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i7, CharSequence charSequence) {
        super.insert(i7, charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i7, int i8, CharSequence charSequence) {
        b();
        super.replace(i7, i8, charSequence);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder insert(int i7, CharSequence charSequence, int i8, int i9) {
        super.insert(i7, charSequence, i8, i9);
        return this;
    }

    @x0({x0.a.LIBRARY})
    q(@m0 Class<?> cls, @m0 CharSequence charSequence) {
        super(charSequence);
        this.f7694b = new ArrayList();
        w.m(cls, "watcherClass cannot be null");
        this.f7693a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder replace(int i7, int i8, CharSequence charSequence, int i9, int i10) {
        b();
        super.replace(i7, i8, charSequence, i9, i10);
        i();
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @m0
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @m0
    public SpannableStringBuilder append(char c8) {
        super.append(c8);
        return this;
    }

    @x0({x0.a.LIBRARY})
    q(@m0 Class<?> cls, @m0 CharSequence charSequence, int i7, int i8) {
        super(charSequence, i7, i8);
        this.f7694b = new ArrayList();
        w.m(cls, "watcherClass cannot be null");
        this.f7693a = cls;
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable, java.lang.Appendable
    @m0
    public SpannableStringBuilder append(@SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i7, int i8) {
        super.append(charSequence, i7, i8);
        return this;
    }

    @Override // android.text.SpannableStringBuilder
    @SuppressLint({"UnknownNullness"})
    public SpannableStringBuilder append(CharSequence charSequence, Object obj, int i7) {
        super.append(charSequence, obj, i7);
        return this;
    }
}
