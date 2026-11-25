package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import c.m0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@t0(19)
@x0({x0.a.LIBRARY})
final class e implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyListener f7714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f7715b;

    public static class a {
        public boolean a(@m0 Editable editable, int i7, @m0 KeyEvent keyEvent) {
            return androidx.emoji2.text.f.h(editable, i7, keyEvent);
        }
    }

    e(KeyListener keyListener) {
        this(keyListener, new a());
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i7) {
        this.f7714a.clearMetaKeyState(view, editable, i7);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f7714a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i7, KeyEvent keyEvent) {
        return this.f7715b.a(editable, i7, keyEvent) || this.f7714a.onKeyDown(view, editable, i7, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f7714a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i7, KeyEvent keyEvent) {
        return this.f7714a.onKeyUp(view, editable, i7, keyEvent);
    }

    e(KeyListener keyListener, a aVar) {
        this.f7714a = keyListener;
        this.f7715b = aVar;
    }
}
