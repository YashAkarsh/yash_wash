package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.core.util.w;
import c.i;
import c.m0;
import c.o0;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.animation.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f17642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final ExtendedFloatingActionButton f17643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<Animator.AnimatorListener> f17644c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.a f17645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private h f17646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private h f17647f;

    class a extends Property<ExtendedFloatingActionButton, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(com.google.android.material.animation.a.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.N.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f17643b.N.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f8) {
            int colorForState = extendedFloatingActionButton.N.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f17643b.N.getDefaultColor());
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (com.google.android.material.animation.a.a(0.0f, Color.alpha(colorForState) / 255.0f, f8.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f8.floatValue() == 1.0f) {
                extendedFloatingActionButton.W(extendedFloatingActionButton.N);
            } else {
                extendedFloatingActionButton.W(colorStateListValueOf);
            }
        }
    }

    b(@m0 ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.a aVar) {
        this.f17643b = extendedFloatingActionButton;
        this.f17642a = extendedFloatingActionButton.getContext();
        this.f17645d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @i
    public void a() {
        this.f17645d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final h b() {
        h hVar = this.f17647f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f17646e == null) {
            this.f17646e = h.d(this.f17642a, c());
        }
        return (h) w.l(this.f17646e);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @o0
    public h e() {
        return this.f17647f;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void g(@m0 Animator.AnimatorListener animatorListener) {
        this.f17644c.remove(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void h(@m0 Animator.AnimatorListener animatorListener) {
        this.f17644c.add(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @i
    public void i() {
        this.f17645d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void j(@o0 h hVar) {
        this.f17647f = hVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public AnimatorSet k() {
        return o(b());
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @m0
    public final List<Animator.AnimatorListener> l() {
        return this.f17644c;
    }

    @m0
    AnimatorSet o(@m0 h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.j("opacity")) {
            arrayList.add(hVar.f("opacity", this.f17643b, View.ALPHA));
        }
        if (hVar.j("scale")) {
            arrayList.add(hVar.f("scale", this.f17643b, View.SCALE_Y));
            arrayList.add(hVar.f("scale", this.f17643b, View.SCALE_X));
        }
        if (hVar.j(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
            arrayList.add(hVar.f(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f17643b, ExtendedFloatingActionButton.S));
        }
        if (hVar.j(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
            arrayList.add(hVar.f(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f17643b, ExtendedFloatingActionButton.T));
        }
        if (hVar.j("paddingStart")) {
            arrayList.add(hVar.f("paddingStart", this.f17643b, ExtendedFloatingActionButton.U));
        }
        if (hVar.j("paddingEnd")) {
            arrayList.add(hVar.f("paddingEnd", this.f17643b, ExtendedFloatingActionButton.V));
        }
        if (hVar.j("labelOpacity")) {
            arrayList.add(hVar.f("labelOpacity", this.f17643b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.animation.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    @i
    public void onAnimationStart(Animator animator) {
        this.f17645d.c(animator);
    }
}
