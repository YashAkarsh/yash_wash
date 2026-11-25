package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
class m0 {
    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal a(BigDecimal bigDecimal) {
        kotlin.jvm.internal.l0.p(bigDecimal, "<this>");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(BigDecimal.ONE);
        kotlin.jvm.internal.l0.o(bigDecimalSubtract, "this.subtract(BigDecimal.ONE)");
        return bigDecimalSubtract;
    }

    @kotlin.internal.f
    private static final BigDecimal b(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.l0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigDecimal bigDecimalDivide = bigDecimal.divide(other, RoundingMode.HALF_EVEN);
        kotlin.jvm.internal.l0.o(bigDecimalDivide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return bigDecimalDivide;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal c(BigDecimal bigDecimal) {
        kotlin.jvm.internal.l0.p(bigDecimal, "<this>");
        BigDecimal bigDecimalAdd = bigDecimal.add(BigDecimal.ONE);
        kotlin.jvm.internal.l0.o(bigDecimalAdd, "this.add(BigDecimal.ONE)");
        return bigDecimalAdd;
    }

    @kotlin.internal.f
    private static final BigDecimal d(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.l0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigDecimal bigDecimalSubtract = bigDecimal.subtract(other);
        kotlin.jvm.internal.l0.o(bigDecimalSubtract, "this.subtract(other)");
        return bigDecimalSubtract;
    }

    @kotlin.internal.f
    private static final BigDecimal e(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.l0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigDecimal bigDecimalAdd = bigDecimal.add(other);
        kotlin.jvm.internal.l0.o(bigDecimalAdd, "this.add(other)");
        return bigDecimalAdd;
    }

    @kotlin.internal.f
    private static final BigDecimal f(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.l0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigDecimal bigDecimalRemainder = bigDecimal.remainder(other);
        kotlin.jvm.internal.l0.o(bigDecimalRemainder, "this.remainder(other)");
        return bigDecimalRemainder;
    }

    @kotlin.internal.f
    private static final BigDecimal g(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.l0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigDecimal bigDecimalMultiply = bigDecimal.multiply(other);
        kotlin.jvm.internal.l0.o(bigDecimalMultiply, "this.multiply(other)");
        return bigDecimalMultiply;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal h(double d8) {
        return new BigDecimal(String.valueOf(d8));
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal i(double d8, MathContext mathContext) {
        kotlin.jvm.internal.l0.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(d8), mathContext);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal j(float f8) {
        return new BigDecimal(String.valueOf(f8));
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal k(float f8, MathContext mathContext) {
        kotlin.jvm.internal.l0.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(f8), mathContext);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal l(int i7) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(i7);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        return bigDecimalValueOf;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal m(int i7, MathContext mathContext) {
        kotlin.jvm.internal.l0.p(mathContext, "mathContext");
        return new BigDecimal(i7, mathContext);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal n(long j7) {
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(j7);
        kotlin.jvm.internal.l0.o(bigDecimalValueOf, "valueOf(this)");
        return bigDecimalValueOf;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal o(long j7, MathContext mathContext) {
        kotlin.jvm.internal.l0.p(mathContext, "mathContext");
        return new BigDecimal(j7, mathContext);
    }

    @kotlin.internal.f
    private static final BigDecimal p(BigDecimal bigDecimal) {
        kotlin.jvm.internal.l0.p(bigDecimal, "<this>");
        BigDecimal bigDecimalNegate = bigDecimal.negate();
        kotlin.jvm.internal.l0.o(bigDecimalNegate, "this.negate()");
        return bigDecimalNegate;
    }
}
