package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.m0
    private final EditText f1845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.m0
    private final androidx.emoji2.viewsintegration.a f1846b;

    h(@c.m0 EditText editText) {
        this.f1845a = editText;
        this.f1846b = new androidx.emoji2.viewsintegration.a(editText, false);
    }

    @c.o0
    KeyListener a(@c.o0 KeyListener keyListener) {
        return b(keyListener) ? this.f1846b.b(keyListener) : keyListener;
    }

    boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    boolean c() {
        return this.f1846b.d();
    }

    void d(@c.o0 AttributeSet attributeSet, int i7) {
        TypedArray typedArrayObtainStyledAttributes = this.f1845a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i7, 0);
        try {
            boolean z7 = typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled) ? typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            f(z7);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @c.o0
    InputConnection e(@c.o0 InputConnection inputConnection, @c.m0 EditorInfo editorInfo) {
        return this.f1846b.e(inputConnection, editorInfo);
    }

    void f(boolean z7) {
        this.f1846b.g(z7);
    }
}
