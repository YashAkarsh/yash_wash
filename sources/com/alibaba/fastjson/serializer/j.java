package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import sun.reflect.annotation.AnnotationType;

/* JADX INFO: loaded from: classes.dex */
public class j implements y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j f13083a = new j();

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
            Map mapMembers = AnnotationType.getInstance(interfaces[0]).members();
            com.alibaba.fastjson.e eVar = new com.alibaba.fastjson.e(mapMembers.size());
            Object objInvoke = null;
            for (Map.Entry entry : mapMembers.entrySet()) {
                try {
                    objInvoke = ((Method) entry.getValue()).invoke(obj, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
                eVar.put((String) entry.getKey(), com.alibaba.fastjson.a.i0(objInvoke));
            }
            n0Var.S(eVar);
        }
    }
}
