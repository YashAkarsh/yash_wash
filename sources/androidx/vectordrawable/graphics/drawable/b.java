package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import c.m0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public interface b extends Animatable {

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Animatable2.AnimationCallback f10887a;

        /* JADX INFO: renamed from: androidx.vectordrawable.graphics.drawable.b$a$a, reason: collision with other inner class name */
        class C0130a extends Animatable2.AnimationCallback {
            C0130a() {
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                a.this.b(drawable);
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public void onAnimationStart(Drawable drawable) {
                a.this.c(drawable);
            }
        }

        @t0(23)
        Animatable2.AnimationCallback a() {
            if (this.f10887a == null) {
                this.f10887a = new C0130a();
            }
            return this.f10887a;
        }

        public void b(Drawable drawable) {
        }

        public void c(Drawable drawable) {
        }
    }

    void b(@m0 a aVar);

    void c();

    boolean d(@m0 a aVar);
}
