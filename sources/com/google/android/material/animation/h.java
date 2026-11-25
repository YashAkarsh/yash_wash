package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Property;
import c.c1;
import c.m0;
import c.o0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f16859c = "MotionSpec";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.collection.i<String, i> f16860a = new androidx.collection.i<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final androidx.collection.i<String, PropertyValuesHolder[]> f16861b = new androidx.collection.i<>();

    private static void a(@m0 h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.l(objectAnimator.getPropertyName(), objectAnimator.getValues());
            hVar.m(objectAnimator.getPropertyName(), i.b(objectAnimator));
        } else {
            throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
        }
    }

    @m0
    private PropertyValuesHolder[] b(@m0 PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i7 = 0; i7 < propertyValuesHolderArr.length; i7++) {
            propertyValuesHolderArr2[i7] = propertyValuesHolderArr[i7].clone();
        }
        return propertyValuesHolderArr2;
    }

    @o0
    public static h c(@m0 Context context, @m0 TypedArray typedArray, @c1 int i7) {
        int resourceId;
        if (!typedArray.hasValue(i7) || (resourceId = typedArray.getResourceId(i7, 0)) == 0) {
            return null;
        }
        return d(context, resourceId);
    }

    @o0
    public static h d(@m0 Context context, @c.b int i7) {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i7);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return e(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return e(arrayList);
        } catch (Exception e8) {
            Log.w(f16859c, "Can't load animation resource ID #0x" + Integer.toHexString(i7), e8);
            return null;
        }
    }

    @m0
    private static h e(@m0 List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            a(hVar, list.get(i7));
        }
        return hVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.f16860a.equals(((h) obj).f16860a);
        }
        return false;
    }

    @m0
    public <T> ObjectAnimator f(@m0 String str, @m0 T t7, @m0 Property<T, ?> property) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t7, g(str));
        objectAnimatorOfPropertyValuesHolder.setProperty(property);
        h(str).a(objectAnimatorOfPropertyValuesHolder);
        return objectAnimatorOfPropertyValuesHolder;
    }

    @m0
    public PropertyValuesHolder[] g(String str) {
        if (j(str)) {
            return b(this.f16861b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public i h(String str) {
        if (k(str)) {
            return this.f16860a.get(str);
        }
        throw new IllegalArgumentException();
    }

    public int hashCode() {
        return this.f16860a.hashCode();
    }

    public long i() {
        int size = this.f16860a.size();
        long jMax = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i iVarO = this.f16860a.o(i7);
            jMax = Math.max(jMax, iVarO.c() + iVarO.d());
        }
        return jMax;
    }

    public boolean j(String str) {
        return this.f16861b.get(str) != null;
    }

    public boolean k(String str) {
        return this.f16860a.get(str) != null;
    }

    public void l(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f16861b.put(str, propertyValuesHolderArr);
    }

    public void m(String str, @o0 i iVar) {
        this.f16860a.put(str, iVar);
    }

    @m0
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f16860a + "}\n";
    }
}
