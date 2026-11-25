package com.google.gson;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f23248a;

    public r(Boolean bool) {
        this.f23248a = com.google.gson.internal.a.b(bool);
    }

    private static boolean D(r rVar) {
        Object obj = rVar.f23248a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // com.google.gson.l
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public r a() {
        return this;
    }

    public boolean B() {
        return this.f23248a instanceof Boolean;
    }

    public boolean F() {
        return this.f23248a instanceof Number;
    }

    public boolean G() {
        return this.f23248a instanceof String;
    }

    @Override // com.google.gson.l
    public BigDecimal b() {
        Object obj = this.f23248a;
        return obj instanceof BigDecimal ? (BigDecimal) obj : new BigDecimal(this.f23248a.toString());
    }

    @Override // com.google.gson.l
    public BigInteger d() {
        Object obj = this.f23248a;
        return obj instanceof BigInteger ? (BigInteger) obj : new BigInteger(this.f23248a.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f23248a == null) {
            return rVar.f23248a == null;
        }
        if (D(this) && D(rVar)) {
            return s().longValue() == rVar.s().longValue();
        }
        Object obj2 = this.f23248a;
        if (!(obj2 instanceof Number) || !(rVar.f23248a instanceof Number)) {
            return obj2.equals(rVar.f23248a);
        }
        double dDoubleValue = s().doubleValue();
        double dDoubleValue2 = rVar.s().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    @Override // com.google.gson.l
    public boolean f() {
        return B() ? ((Boolean) this.f23248a).booleanValue() : Boolean.parseBoolean(u());
    }

    @Override // com.google.gson.l
    public byte g() {
        return F() ? s().byteValue() : Byte.parseByte(u());
    }

    @Override // com.google.gson.l
    public char h() {
        return u().charAt(0);
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f23248a == null) {
            return 31;
        }
        if (D(this)) {
            jDoubleToLongBits = s().longValue();
        } else {
            Object obj = this.f23248a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(s().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    @Override // com.google.gson.l
    public double j() {
        return F() ? s().doubleValue() : Double.parseDouble(u());
    }

    @Override // com.google.gson.l
    public float k() {
        return F() ? s().floatValue() : Float.parseFloat(u());
    }

    @Override // com.google.gson.l
    public int l() {
        return F() ? s().intValue() : Integer.parseInt(u());
    }

    @Override // com.google.gson.l
    public long r() {
        return F() ? s().longValue() : Long.parseLong(u());
    }

    @Override // com.google.gson.l
    public Number s() {
        Object obj = this.f23248a;
        return obj instanceof String ? new com.google.gson.internal.g((String) obj) : (Number) obj;
    }

    @Override // com.google.gson.l
    public short t() {
        return F() ? s().shortValue() : Short.parseShort(u());
    }

    @Override // com.google.gson.l
    public String u() {
        if (F()) {
            return s().toString();
        }
        return B() ? ((Boolean) this.f23248a).toString() : (String) this.f23248a;
    }

    public r(Number number) {
        this.f23248a = com.google.gson.internal.a.b(number);
    }

    public r(String str) {
        this.f23248a = com.google.gson.internal.a.b(str);
    }

    public r(Character ch) {
        this.f23248a = ((Character) com.google.gson.internal.a.b(ch)).toString();
    }
}
