package com.alibaba.fastjson.util;

import com.alibaba.fastjson.n;
import com.alibaba.fastjson.serializer.a0;
import com.alibaba.fastjson.serializer.b1;
import com.alibaba.fastjson.serializer.c1;
import com.alibaba.fastjson.serializer.e1;
import com.alibaba.fastjson.serializer.f1;
import com.alibaba.fastjson.serializer.g1;
import com.alibaba.fastjson.serializer.h1;
import com.alibaba.fastjson.serializer.i1;
import com.alibaba.fastjson.serializer.j1;
import com.alibaba.fastjson.serializer.k1;
import com.alibaba.fastjson.serializer.n0;
import com.alibaba.fastjson.serializer.p;
import com.alibaba.fastjson.serializer.p0;
import com.alibaba.fastjson.serializer.p1;
import com.alibaba.fastjson.serializer.q;
import com.alibaba.fastjson.serializer.q0;
import com.alibaba.fastjson.serializer.r0;
import com.alibaba.fastjson.serializer.w0;
import com.alibaba.fastjson.serializer.y0;
import com.alibaba.fastjson.serializer.z;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends ClassLoader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, Class<?>> f13257b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ProtectionDomain f13256a = (ProtectionDomain) AccessController.doPrivileged(new C0152a());

    /* JADX INFO: renamed from: com.alibaba.fastjson.util.a$a, reason: collision with other inner class name */
    static class C0152a implements PrivilegedAction<Object> {
        C0152a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return a.class.getProtectionDomain();
        }
    }

    static {
        Class<?>[] clsArr = {com.alibaba.fastjson.a.class, com.alibaba.fastjson.e.class, com.alibaba.fastjson.b.class, com.alibaba.fastjson.g.class, com.alibaba.fastjson.c.class, com.alibaba.fastjson.d.class, com.alibaba.fastjson.h.class, com.alibaba.fastjson.i.class, com.alibaba.fastjson.j.class, com.alibaba.fastjson.l.class, n.class, e.class, l.class, f.class, g.class, i.class, h.class, y0.class, p0.class, i1.class, f1.class, n0.class, j1.class, h1.class, r0.class, q0.class, a0.class, com.alibaba.fastjson.serializer.i.class, q.class, w0.class, b1.class, c1.class, p1.class, k1.class, z.class, e1.class, g1.class, com.alibaba.fastjson.parser.deserializer.n.class, com.alibaba.fastjson.parser.j.class, com.alibaba.fastjson.parser.b.class, com.alibaba.fastjson.parser.d.class, com.alibaba.fastjson.parser.e.class, com.alibaba.fastjson.parser.i.class, com.alibaba.fastjson.parser.h.class, com.alibaba.fastjson.parser.k.class, com.alibaba.fastjson.parser.c.class, com.alibaba.fastjson.parser.g.class, com.alibaba.fastjson.parser.f.class, com.alibaba.fastjson.parser.deserializer.d.class, com.alibaba.fastjson.parser.deserializer.e1.class, com.alibaba.fastjson.parser.deserializer.i.class, com.alibaba.fastjson.parser.deserializer.h.class, com.alibaba.fastjson.parser.deserializer.j.class, p.class, com.alibaba.fastjson.parser.deserializer.k.class, com.alibaba.fastjson.parser.deserializer.f.class};
        for (int i7 = 0; i7 < 56; i7++) {
            Class<?> cls = clsArr[i7];
            f13257b.put(cls.getName(), cls);
        }
    }

    public a() {
        super(b());
    }

    static ClassLoader b() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                contextClassLoader.loadClass(com.alibaba.fastjson.a.class.getName());
                return contextClassLoader;
            } catch (ClassNotFoundException unused) {
            }
        }
        return com.alibaba.fastjson.a.class.getClassLoader();
    }

    public Class<?> a(String str, byte[] bArr, int i7, int i8) throws ClassFormatError {
        return defineClass(str, bArr, i7, i8, f13256a);
    }

    public boolean c(Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        for (ClassLoader parent = this; parent != null; parent = parent.getParent()) {
            if (parent == classLoader) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z7) throws ClassNotFoundException {
        Class<?> cls = f13257b.get(str);
        return cls != null ? cls : super.loadClass(str, z7);
    }

    public a(ClassLoader classLoader) {
        super(classLoader);
    }
}
