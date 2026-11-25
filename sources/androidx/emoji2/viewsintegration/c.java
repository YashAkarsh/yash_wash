package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import c.e0;
import c.m0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
@x0({x0.a.LIBRARY})
final class c extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f7708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f7709b;

    public static class a {
        public boolean a(@m0 InputConnection inputConnection, @m0 Editable editable, @e0(from = 0) int i7, @e0(from = 0) int i8, boolean z7) {
            return androidx.emoji2.text.f.g(inputConnection, editable, i7, i8, z7);
        }

        public void b(@m0 EditorInfo editorInfo) {
            if (androidx.emoji2.text.f.n()) {
                androidx.emoji2.text.f.b().D(editorInfo);
            }
        }
    }

    c(@m0 TextView textView, @m0 InputConnection inputConnection, @m0 EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new a());
    }

    private Editable a() {
        return this.f7708a.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i7, int i8) {
        return this.f7709b.a(this, a(), i7, i8, false) || super.deleteSurroundingText(i7, i8);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i7, int i8) {
        return this.f7709b.a(this, a(), i7, i8, true) || super.deleteSurroundingTextInCodePoints(i7, i8);
    }

    c(@m0 TextView textView, @m0 InputConnection inputConnection, @m0 EditorInfo editorInfo, @m0 a aVar) {
        super(inputConnection, false);
        this.f7708a = textView;
        this.f7709b = aVar;
        aVar.b(editorInfo);
    }
}
