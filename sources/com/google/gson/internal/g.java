package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23174a;

    public g(String str) {
        this.f23174a = str;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.f23174a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f23174a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        String str = this.f23174a;
        String str2 = ((g) obj).f23174a;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f23174a);
    }

    public int hashCode() {
        return this.f23174a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f23174a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f23174a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f23174a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f23174a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f23174a).longValue();
        }
    }

    public String toString() {
        return this.f23174a;
    }
}
