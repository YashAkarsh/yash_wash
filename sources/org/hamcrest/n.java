package org.hamcrest;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class n extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Appendable f39739b;

    public n() {
        this(new StringBuilder());
    }

    public static String n(m mVar) {
        return o(mVar);
    }

    public static String o(m mVar) {
        return new n().b(mVar).toString();
    }

    @Override // org.hamcrest.a
    protected void g(char c8) {
        try {
            this.f39739b.append(c8);
        } catch (IOException e8) {
            throw new RuntimeException("Could not write description", e8);
        }
    }

    @Override // org.hamcrest.a
    protected void h(String str) {
        try {
            this.f39739b.append(str);
        } catch (IOException e8) {
            throw new RuntimeException("Could not write description", e8);
        }
    }

    public String toString() {
        return this.f39739b.toString();
    }

    public n(Appendable appendable) {
        this.f39739b = appendable;
    }
}
