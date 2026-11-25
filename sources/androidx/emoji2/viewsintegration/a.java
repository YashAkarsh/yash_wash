package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.w;
import c.e0;
import c.m0;
import c.o0;
import c.t0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f7700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7702c;

    /* JADX INFO: renamed from: androidx.emoji2.viewsintegration.a$a, reason: collision with other inner class name */
    @t0(19)
    private static class C0095a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EditText f7703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f7704b;

        C0095a(@m0 EditText editText, boolean z7) {
            this.f7703a = editText;
            g gVar = new g(editText, z7);
            this.f7704b = gVar;
            editText.addTextChangedListener(gVar);
            editText.setEditableFactory(androidx.emoji2.viewsintegration.b.getInstance());
        }

        @Override // androidx.emoji2.viewsintegration.a.b
        KeyListener a(@o0 KeyListener keyListener) {
            if (keyListener instanceof e) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new e(keyListener);
        }

        @Override // androidx.emoji2.viewsintegration.a.b
        boolean b() {
            return this.f7704b.d();
        }

        @Override // androidx.emoji2.viewsintegration.a.b
        InputConnection c(@m0 InputConnection inputConnection, @m0 EditorInfo editorInfo) {
            return inputConnection instanceof c ? inputConnection : new c(this.f7703a, inputConnection, editorInfo);
        }

        @Override // androidx.emoji2.viewsintegration.a.b
        void d(int i7) {
            this.f7704b.f(i7);
        }

        @Override // androidx.emoji2.viewsintegration.a.b
        void e(boolean z7) {
            this.f7704b.g(z7);
        }

        @Override // androidx.emoji2.viewsintegration.a.b
        void f(int i7) {
            this.f7704b.h(i7);
        }
    }

    static class b {
        b() {
        }

        @o0
        KeyListener a(@o0 KeyListener keyListener) {
            return keyListener;
        }

        boolean b() {
            return false;
        }

        InputConnection c(@m0 InputConnection inputConnection, @m0 EditorInfo editorInfo) {
            return inputConnection;
        }

        void d(int i7) {
        }

        void e(boolean z7) {
        }

        void f(int i7) {
        }
    }

    public a(@m0 EditText editText) {
        this(editText, true);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public int a() {
        return this.f7702c;
    }

    @o0
    public KeyListener b(@o0 KeyListener keyListener) {
        return this.f7700a.a(keyListener);
    }

    public int c() {
        return this.f7701b;
    }

    public boolean d() {
        return this.f7700a.b();
    }

    @o0
    public InputConnection e(@o0 InputConnection inputConnection, @m0 EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f7700a.c(inputConnection, editorInfo);
    }

    @x0({x0.a.LIBRARY_GROUP})
    public void f(int i7) {
        this.f7702c = i7;
        this.f7700a.d(i7);
    }

    public void g(boolean z7) {
        this.f7700a.e(z7);
    }

    public void h(@e0(from = 0) int i7) {
        w.j(i7, "maxEmojiCount should be greater than 0");
        this.f7701b = i7;
        this.f7700a.f(i7);
    }

    public a(@m0 EditText editText, boolean z7) {
        this.f7701b = Integer.MAX_VALUE;
        this.f7702c = 0;
        w.m(editText, "editText cannot be null");
        this.f7700a = new C0095a(editText, z7);
    }
}
