package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* JADX INFO: loaded from: classes2.dex */
class n0 extends m0 {
    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger A(BigInteger bigInteger, int i7) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerShiftRight = bigInteger.shiftRight(i7);
        kotlin.jvm.internal.l0.o(bigIntegerShiftRight, "this.shiftRight(n)");
        return bigIntegerShiftRight;
    }

    @kotlin.internal.f
    private static final BigInteger B(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigInteger bigIntegerMultiply = bigInteger.multiply(other);
        kotlin.jvm.internal.l0.o(bigIntegerMultiply, "this.multiply(other)");
        return bigIntegerMultiply;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal C(BigInteger bigInteger) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        return new BigDecimal(bigInteger);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigDecimal D(BigInteger bigInteger, int i7, MathContext mathContext) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        kotlin.jvm.internal.l0.p(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i7, mathContext);
    }

    static /* synthetic */ BigDecimal E(BigInteger bigInteger, int i7, MathContext mathContext, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 0;
        }
        if ((i8 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            kotlin.jvm.internal.l0.o(mathContext, "UNLIMITED");
        }
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        kotlin.jvm.internal.l0.p(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i7, mathContext);
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger F(int i7) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i7);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        return bigIntegerValueOf;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger G(long j7) {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(j7);
        kotlin.jvm.internal.l0.o(bigIntegerValueOf, "valueOf(this)");
        return bigIntegerValueOf;
    }

    @kotlin.internal.f
    private static final BigInteger H(BigInteger bigInteger) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerNegate = bigInteger.negate();
        kotlin.jvm.internal.l0.o(bigIntegerNegate, "this.negate()");
        return bigIntegerNegate;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger I(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigInteger bigIntegerXor = bigInteger.xor(other);
        kotlin.jvm.internal.l0.o(bigIntegerXor, "this.xor(other)");
        return bigIntegerXor;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger q(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigInteger bigIntegerAnd = bigInteger.and(other);
        kotlin.jvm.internal.l0.o(bigIntegerAnd, "this.and(other)");
        return bigIntegerAnd;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger r(BigInteger bigInteger) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerSubtract = bigInteger.subtract(BigInteger.ONE);
        kotlin.jvm.internal.l0.o(bigIntegerSubtract, "this.subtract(BigInteger.ONE)");
        return bigIntegerSubtract;
    }

    @kotlin.internal.f
    private static final BigInteger s(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigInteger bigIntegerDivide = bigInteger.divide(other);
        kotlin.jvm.internal.l0.o(bigIntegerDivide, "this.divide(other)");
        return bigIntegerDivide;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger t(BigInteger bigInteger) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerAdd = bigInteger.add(BigInteger.ONE);
        kotlin.jvm.internal.l0.o(bigIntegerAdd, "this.add(BigInteger.ONE)");
        return bigIntegerAdd;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger u(BigInteger bigInteger) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerNot = bigInteger.not();
        kotlin.jvm.internal.l0.o(bigIntegerNot, "this.not()");
        return bigIntegerNot;
    }

    @kotlin.internal.f
    private static final BigInteger v(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigInteger bigIntegerSubtract = bigInteger.subtract(other);
        kotlin.jvm.internal.l0.o(bigIntegerSubtract, "this.subtract(other)");
        return bigIntegerSubtract;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger w(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigInteger bigIntegerOr = bigInteger.or(other);
        kotlin.jvm.internal.l0.o(bigIntegerOr, "this.or(other)");
        return bigIntegerOr;
    }

    @kotlin.internal.f
    private static final BigInteger x(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigInteger bigIntegerAdd = bigInteger.add(other);
        kotlin.jvm.internal.l0.o(bigIntegerAdd, "this.add(other)");
        return bigIntegerAdd;
    }

    @g1(version = "1.1")
    @kotlin.internal.f
    private static final BigInteger y(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        kotlin.jvm.internal.l0.p(other, "other");
        BigInteger bigIntegerRemainder = bigInteger.remainder(other);
        kotlin.jvm.internal.l0.o(bigIntegerRemainder, "this.remainder(other)");
        return bigIntegerRemainder;
    }

    @g1(version = "1.2")
    @kotlin.internal.f
    private static final BigInteger z(BigInteger bigInteger, int i7) {
        kotlin.jvm.internal.l0.p(bigInteger, "<this>");
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(i7);
        kotlin.jvm.internal.l0.o(bigIntegerShiftLeft, "this.shiftLeft(n)");
        return bigIntegerShiftLeft;
    }
}
