package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.view.j2;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements j2, androidx.core.widget.j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f1434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f1435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1436c;

    public AppCompatImageView(@c.m0 Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1434a;
        if (dVar != null) {
            dVar.b();
        }
        k kVar = this.f1435b;
        if (kVar != null) {
            kVar.c();
        }
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1434a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1434a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.j0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportImageTintList() {
        k kVar = this.f1435b;
        if (kVar != null) {
            return kVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.j0
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportImageTintMode() {
        k kVar = this.f1435b;
        if (kVar != null) {
            return kVar.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f1435b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@c.o0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1434a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@c.u int i7) {
        super.setBackgroundResource(i7);
        d dVar = this.f1434a;
        if (dVar != null) {
            dVar.g(i7);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        k kVar = this.f1435b;
        if (kVar != null) {
            kVar.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@c.o0 Drawable drawable) {
        k kVar = this.f1435b;
        if (kVar != null && drawable != null && !this.f1436c) {
            kVar.h(drawable);
        }
        super.setImageDrawable(drawable);
        k kVar2 = this.f1435b;
        if (kVar2 != null) {
            kVar2.c();
            if (this.f1436c) {
                return;
            }
            this.f1435b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i7) {
        super.setImageLevel(i7);
        this.f1436c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@c.u int i7) {
        k kVar = this.f1435b;
        if (kVar != null) {
            kVar.i(i7);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(@c.o0 Uri uri) {
        super.setImageURI(uri);
        k kVar = this.f1435b;
        if (kVar != null) {
            kVar.c();
        }
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@c.o0 ColorStateList colorStateList) {
        d dVar = this.f1434a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@c.o0 PorterDuff.Mode mode) {
        d dVar = this.f1434a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    @Override // androidx.core.widget.j0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintList(@c.o0 ColorStateList colorStateList) {
        k kVar = this.f1435b;
        if (kVar != null) {
            kVar.k(colorStateList);
        }
    }

    @Override // androidx.core.widget.j0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintMode(@c.o0 PorterDuff.Mode mode) {
        k kVar = this.f1435b;
        if (kVar != null) {
            kVar.l(mode);
        }
    }

    public AppCompatImageView(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        super(e1.b(context), attributeSet, i7);
        this.f1436c = false;
        c1.a(this, getContext());
        d dVar = new d(this);
        this.f1434a = dVar;
        dVar.e(attributeSet, i7);
        k kVar = new k(this);
        this.f1435b = kVar;
        kVar.g(attributeSet, i7);
    }
}
