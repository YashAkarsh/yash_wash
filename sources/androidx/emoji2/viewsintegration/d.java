package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
@x0({x0.a.LIBRARY})
final class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f7710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private androidx.emoji2.text.f.AbstractC0093f f7711b;

    @t0(19)
    private static class a extends androidx.emoji2.text.f.AbstractC0093f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference<TextView> f7712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Reference<d> f7713b;

        a(TextView textView, d dVar) {
            this.f7712a = new WeakReference(textView);
            this.f7713b = new WeakReference(dVar);
        }

        private boolean c(@o0 TextView textView, @o0 InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.emoji2.text.f.AbstractC0093f
        public void b() {
            CharSequence text;
            CharSequence charSequenceU;
            super.b();
            TextView textView = this.f7712a.get();
            if (c(textView, this.f7713b.get()) && textView.isAttachedToWindow() && text != (charSequenceU = androidx.emoji2.text.f.b().u((text = textView.getText())))) {
                int selectionStart = Selection.getSelectionStart(charSequenceU);
                int selectionEnd = Selection.getSelectionEnd(charSequenceU);
                textView.setText(charSequenceU);
                if (charSequenceU instanceof Spannable) {
                    d.b((Spannable) charSequenceU, selectionStart, selectionEnd);
                }
            }
        }
    }

    d(@m0 TextView textView) {
        this.f7710a = textView;
    }

    private androidx.emoji2.text.f.AbstractC0093f a() {
        if (this.f7711b == null) {
            this.f7711b = new a(this.f7710a, this);
        }
        return this.f7711b;
    }

    static void b(Spannable spannable, int i7, int i8) {
        if (i7 >= 0 && i8 >= 0) {
            Selection.setSelection(spannable, i7, i8);
        } else if (i7 >= 0) {
            Selection.setSelection(spannable, i7);
        } else if (i8 >= 0) {
            Selection.setSelection(spannable, i8);
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i7, int i8, Spanned spanned, int i9, int i10) {
        if (this.f7710a.isInEditMode()) {
            return charSequence;
        }
        int iF = androidx.emoji2.text.f.b().f();
        if (iF != 0) {
            boolean z7 = true;
            if (iF == 1) {
                if (i10 == 0 && i9 == 0 && spanned.length() == 0 && charSequence == this.f7710a.getText()) {
                    z7 = false;
                }
                if (!z7 || charSequence == null) {
                    return charSequence;
                }
                if (i7 != 0 || i8 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i7, i8);
                }
                return androidx.emoji2.text.f.b().v(charSequence, 0, charSequence.length());
            }
            if (iF != 3) {
                return charSequence;
            }
        }
        androidx.emoji2.text.f.b().y(a());
        return charSequence;
    }
}
