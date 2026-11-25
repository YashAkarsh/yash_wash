package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    public abstract l a();

    public BigDecimal b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    @Deprecated
    public char h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double j() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float k() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int l() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public i m() {
        if (v()) {
            return (i) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public n n() {
        if (w()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Null: " + this);
    }

    public o o() {
        if (x()) {
            return (o) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public r p() {
        if (z()) {
            return (r) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long r() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number s() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short t() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            com.google.gson.stream.d dVar = new com.google.gson.stream.d(stringWriter);
            dVar.v0(true);
            com.google.gson.internal.m.b(this, dVar);
            return stringWriter.toString();
        } catch (IOException e8) {
            throw new AssertionError(e8);
        }
    }

    public String u() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean v() {
        return this instanceof i;
    }

    public boolean w() {
        return this instanceof n;
    }

    public boolean x() {
        return this instanceof o;
    }

    public boolean z() {
        return this instanceof r;
    }
}
