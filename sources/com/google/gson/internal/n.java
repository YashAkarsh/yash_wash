package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class n {

    class a extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f23236b;

        a(Method method, Object obj) {
            this.f23235a = method;
            this.f23236b = obj;
        }

        @Override // com.google.gson.internal.n
        public <T> T c(Class<T> cls) throws Exception {
            n.a(cls);
            return (T) this.f23235a.invoke(this.f23236b, cls);
        }
    }

    class b extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f23238b;

        b(Method method, int i7) {
            this.f23237a = method;
            this.f23238b = i7;
        }

        @Override // com.google.gson.internal.n
        public <T> T c(Class<T> cls) throws Exception {
            n.a(cls);
            return (T) this.f23237a.invoke(null, cls, Integer.valueOf(this.f23238b));
        }
    }

    class c extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f23239a;

        c(Method method) {
            this.f23239a = method;
        }

        @Override // com.google.gson.internal.n
        public <T> T c(Class<T> cls) throws Exception {
            n.a(cls);
            return (T) this.f23239a.invoke(null, cls, Object.class);
        }
    }

    class d extends n {
        d() {
        }

        @Override // com.google.gson.internal.n
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static n b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    public abstract <T> T c(Class<T> cls) throws Exception;
}
