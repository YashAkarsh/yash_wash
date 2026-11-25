package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import org.junit.runners.model.c;

/* JADX INFO: loaded from: classes3.dex */
class b extends Exception {
    public b(c<?> cVar, Class<? extends Annotation> cls, String str) {
        super(String.format("The @%s '%s' %s", cls.getSimpleName(), cVar.c(), str));
    }
}
