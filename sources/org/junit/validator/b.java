package org.junit.validator;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<f, a> f40068a = new ConcurrentHashMap<>();

    public a a(f fVar) {
        ConcurrentHashMap<f, a> concurrentHashMap = f40068a;
        a aVar = concurrentHashMap.get(fVar);
        if (aVar != null) {
            return aVar;
        }
        Class<? extends a> clsValue = fVar.value();
        if (clsValue == null) {
            throw new IllegalArgumentException("Can't create validator, value is null in annotation " + fVar.getClass().getName());
        }
        try {
            concurrentHashMap.putIfAbsent(fVar, clsValue.newInstance());
            return concurrentHashMap.get(fVar);
        } catch (Exception e8) {
            throw new RuntimeException("Exception received when creating AnnotationValidator class " + clsValue.getName(), e8);
        }
    }
}
