package org.junit.runner;

/* JADX INFO: loaded from: classes3.dex */
public interface e {

    public static class a extends Exception {
        public a(Exception exc) {
            super(exc.getMessage(), exc);
        }
    }

    org.junit.runner.manipulation.a a(f fVar) throws a;
}
