package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
final class v extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Drawable.ConstantState f5840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ColorStateList f5841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    PorterDuff.Mode f5842d;

    v(@o0 v vVar) {
        this.f5841c = null;
        this.f5842d = t.f5830g;
        if (vVar != null) {
            this.f5839a = vVar.f5839a;
            this.f5840b = vVar.f5840b;
            this.f5841c = vVar.f5841c;
            this.f5842d = vVar.f5842d;
        }
    }

    boolean a() {
        return this.f5840b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i7 = this.f5839a;
        Drawable.ConstantState constantState = this.f5840b;
        return i7 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @m0
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @m0
    public Drawable newDrawable(@o0 Resources resources) {
        return new u(this, resources);
    }
}
