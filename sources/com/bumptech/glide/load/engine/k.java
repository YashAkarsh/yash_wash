package com.bumptech.glide.load.engine;

/* JADX INFO: loaded from: classes.dex */
public class k extends Exception {
    public k(Error error) {
        super(error);
        if (error == null) {
            throw new NullPointerException("The causing error must not be null");
        }
    }

    @Override // java.lang.Throwable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Error getCause() {
        return (Error) super.getCause();
    }
}
