package androidx.navigation.ui;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import c.a1;
import c.m0;
import c.x0;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
class b extends a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AppCompatActivity f8943f;

    b(@m0 AppCompatActivity appCompatActivity, @m0 c cVar) {
        super(appCompatActivity.c().e(), cVar);
        this.f8943f = appCompatActivity;
    }

    @Override // androidx.navigation.ui.a
    protected void c(Drawable drawable, @a1 int i7) {
        ActionBar actionBarJ = this.f8943f.J();
        if (drawable == null) {
            actionBarJ.Y(false);
        } else {
            actionBarJ.Y(true);
            this.f8943f.c().a(drawable, i7);
        }
    }

    @Override // androidx.navigation.ui.a
    protected void d(CharSequence charSequence) {
        this.f8943f.J().A0(charSequence);
    }
}
