package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import c.o0;
import c.t0;
import c.x0;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
@x0({x0.a.LIBRARY})
final class g implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EditText f7721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.emoji2.text.f.AbstractC0093f f7723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7724d = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7725e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7726f = true;

    @t0(19)
    private static class a extends androidx.emoji2.text.f.AbstractC0093f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference<EditText> f7727a;

        a(EditText editText) {
            this.f7727a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.f.AbstractC0093f
        public void b() {
            super.b();
            g.e(this.f7727a.get(), 1);
        }
    }

    g(EditText editText, boolean z7) {
        this.f7721a = editText;
        this.f7722b = z7;
    }

    private androidx.emoji2.text.f.AbstractC0093f b() {
        if (this.f7723c == null) {
            this.f7723c = new a(this.f7721a);
        }
        return this.f7723c;
    }

    static void e(@o0 EditText editText, int i7) {
        if (i7 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.f.b().u(editableText);
            d.b(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean i() {
        return (this.f7726f && (this.f7722b || androidx.emoji2.text.f.n())) ? false : true;
    }

    int a() {
        return this.f7725e;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
    }

    int c() {
        return this.f7724d;
    }

    public boolean d() {
        return this.f7726f;
    }

    void f(int i7) {
        this.f7725e = i7;
    }

    public void g(boolean z7) {
        if (this.f7726f != z7) {
            if (this.f7723c != null) {
                androidx.emoji2.text.f.b().C(this.f7723c);
            }
            this.f7726f = z7;
            if (z7) {
                e(this.f7721a, androidx.emoji2.text.f.b().f());
            }
        }
    }

    void h(int i7) {
        this.f7724d = i7;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        if (this.f7721a.isInEditMode() || i() || i8 > i9 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iF = androidx.emoji2.text.f.b().f();
        if (iF != 0) {
            if (iF == 1) {
                androidx.emoji2.text.f.b().x((Spannable) charSequence, i7, i7 + i9, this.f7724d, this.f7725e);
                return;
            } else if (iF != 3) {
                return;
            }
        }
        androidx.emoji2.text.f.b().y(b());
    }
}
