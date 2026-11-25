package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    private final TextView f1850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.m0
    private final androidx.emoji2.viewsintegration.f f1851b;

    i(@c.m0 TextView textView) {
        this.f1850a = textView;
        this.f1851b = new androidx.emoji2.viewsintegration.f(textView, false);
    }

    @c.m0
    InputFilter[] a(@c.m0 InputFilter[] inputFilterArr) {
        return this.f1851b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f1851b.b();
    }

    void c(@c.o0 AttributeSet attributeSet, int i7) {
        TypedArray typedArrayObtainStyledAttributes = this.f1850a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i7, 0);
        try {
            boolean z7 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z7);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void d(boolean z7) {
        this.f1851b.c(z7);
    }

    void e(boolean z7) {
        this.f1851b.d(z7);
    }

    @c.o0
    public TransformationMethod f(@c.o0 TransformationMethod transformationMethod) {
        return this.f1851b.f(transformationMethod);
    }
}
