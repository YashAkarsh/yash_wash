package com.google.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: classes2.dex */
public final class q {
    @Deprecated
    public q() {
    }

    public static l d(com.google.gson.stream.a aVar) throws v, m {
        boolean zK = aVar.K();
        aVar.Y0(true);
        try {
            try {
                l lVarA = com.google.gson.internal.m.a(aVar);
                aVar.Y0(zK);
                return lVarA;
            } catch (OutOfMemoryError e8) {
                throw new p("Failed parsing JSON source: " + aVar + " to Json", e8);
            } catch (StackOverflowError e9) {
                throw new p("Failed parsing JSON source: " + aVar + " to Json", e9);
            }
        } catch (Throwable th) {
            aVar.Y0(zK);
            throw th;
        }
    }

    public static l e(Reader reader) throws v, m {
        try {
            com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
            l lVarD = d(aVar);
            if (!lVarD.w() && aVar.J0() != com.google.gson.stream.c.END_DOCUMENT) {
                throw new v("Did not consume the entire document.");
            }
            return lVarD;
        } catch (com.google.gson.stream.e e8) {
            throw new v(e8);
        } catch (IOException e9) {
            throw new m(e9);
        } catch (NumberFormatException e10) {
            throw new v(e10);
        }
    }

    public static l f(String str) throws v {
        return e(new StringReader(str));
    }

    @Deprecated
    public l a(com.google.gson.stream.a aVar) throws v, m {
        return d(aVar);
    }

    @Deprecated
    public l b(Reader reader) throws v, m {
        return e(reader);
    }

    @Deprecated
    public l c(String str) throws v {
        return f(str);
    }
}
