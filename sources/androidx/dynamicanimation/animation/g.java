package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
public abstract class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f7419a;

    static class a extends g<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FloatProperty f7420b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, FloatProperty floatProperty) {
            super(str);
            this.f7420b = floatProperty;
        }

        @Override // androidx.dynamicanimation.animation.g
        public float b(T t7) {
            return ((Float) this.f7420b.get(t7)).floatValue();
        }

        @Override // androidx.dynamicanimation.animation.g
        public void c(T t7, float f8) {
            this.f7420b.setValue(t7, f8);
        }
    }

    public g(String str) {
        this.f7419a = str;
    }

    @t0(24)
    public static <T> g<T> a(FloatProperty<T> floatProperty) {
        return new a(floatProperty.getName(), floatProperty);
    }

    public abstract float b(T t7);

    public abstract void c(T t7, float f8);
}
