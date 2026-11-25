package org.junit.internal.runners.model;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public Object a() throws Throwable {
        try {
            return b();
        } catch (InvocationTargetException e8) {
            throw e8.getTargetException();
        }
    }

    protected abstract Object b() throws Throwable;
}
