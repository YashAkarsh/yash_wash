package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import c.m0;
import c.o0;
import c.x0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f17877c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private com.google.android.material.resources.d f17880f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f17875a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.material.resources.f f17876b = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17878d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private WeakReference<b> f17879e = new WeakReference<>(null);

    class a extends com.google.android.material.resources.f {
        a() {
        }

        @Override // com.google.android.material.resources.f
        public void a(int i7) {
            k.this.f17878d = true;
            b bVar = (b) k.this.f17879e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.google.android.material.resources.f
        public void b(@m0 Typeface typeface, boolean z7) {
            if (z7) {
                return;
            }
            k.this.f17878d = true;
            b bVar = (b) k.this.f17879e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public interface b {
        void a();

        @m0
        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public k(@o0 b bVar) {
        h(bVar);
    }

    private float c(@o0 CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f17875a.measureText(charSequence, 0, charSequence.length());
    }

    @o0
    public com.google.android.material.resources.d d() {
        return this.f17880f;
    }

    @m0
    public TextPaint e() {
        return this.f17875a;
    }

    public float f(String str) {
        if (!this.f17878d) {
            return this.f17877c;
        }
        float fC = c(str);
        this.f17877c = fC;
        this.f17878d = false;
        return fC;
    }

    public boolean g() {
        return this.f17878d;
    }

    public void h(@o0 b bVar) {
        this.f17879e = new WeakReference<>(bVar);
    }

    public void i(@o0 com.google.android.material.resources.d dVar, Context context) {
        if (this.f17880f != dVar) {
            this.f17880f = dVar;
            if (dVar != null) {
                dVar.k(context, this.f17875a, this.f17876b);
                b bVar = this.f17879e.get();
                if (bVar != null) {
                    this.f17875a.drawableState = bVar.getState();
                }
                dVar.j(context, this.f17875a, this.f17876b);
                this.f17878d = true;
            }
            b bVar2 = this.f17879e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void j(boolean z7) {
        this.f17878d = z7;
    }

    public void k(Context context) {
        this.f17880f.j(context, this.f17875a, this.f17876b);
    }
}
