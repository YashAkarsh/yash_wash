package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.e;
import com.nostra13.universalimageloader.core.assist.h;

/* JADX INFO: loaded from: classes2.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f32907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final e f32908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final h f32909c;

    public b(e eVar, h hVar) {
        this(null, eVar, hVar);
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public int a() {
        return TextUtils.isEmpty(this.f32907a) ? super.hashCode() : this.f32907a.hashCode();
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public int b() {
        return this.f32908b.b();
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public boolean c(Drawable drawable) {
        return true;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public View d() {
        return null;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public int e() {
        return this.f32908b.a();
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public boolean f() {
        return false;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public h g() {
        return this.f32909c;
    }

    @Override // com.nostra13.universalimageloader.core.imageaware.a
    public boolean h(Bitmap bitmap) {
        return true;
    }

    public b(String str, e eVar, h hVar) {
        this.f32907a = str;
        this.f32908b = eVar;
        this.f32909c = hVar;
    }
}
