package org.apache.commons.lang3.math;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class Fraction extends Number implements Comparable<Fraction> {
    private static final long serialVersionUID = 65382027393090L;
    private final int denominator;
    private final int numerator;
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction ONE = new Fraction(1, 1);
    public static final Fraction ONE_HALF = new Fraction(1, 2);
    public static final Fraction ONE_THIRD = new Fraction(1, 3);
    public static final Fraction TWO_THIRDS = new Fraction(2, 3);
    public static final Fraction ONE_QUARTER = new Fraction(1, 4);
    public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
    public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
    public static final Fraction ONE_FIFTH = new Fraction(1, 5);
    public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
    public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
    public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
    private transient int hashCode = 0;
    private transient String toString = null;
    private transient String toProperString = null;

    private Fraction(int i7, int i8) {
        this.numerator = i7;
        this.denominator = i8;
    }

    private static int addAndCheck(int i7, int i8) {
        long j7 = ((long) i7) + ((long) i8);
        if (j7 < -2147483648L || j7 > 2147483647L) {
            throw new ArithmeticException("overflow: add");
        }
        return (int) j7;
    }

    private Fraction addSub(Fraction fraction, boolean z7) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        }
        if (this.numerator == 0) {
            return z7 ? fraction : fraction.negate();
        }
        if (fraction.numerator == 0) {
            return this;
        }
        int iGreatestCommonDivisor = greatestCommonDivisor(this.denominator, fraction.denominator);
        if (iGreatestCommonDivisor == 1) {
            int iMulAndCheck = mulAndCheck(this.numerator, fraction.denominator);
            int iMulAndCheck2 = mulAndCheck(fraction.numerator, this.denominator);
            return new Fraction(z7 ? addAndCheck(iMulAndCheck, iMulAndCheck2) : subAndCheck(iMulAndCheck, iMulAndCheck2), mulPosAndCheck(this.denominator, fraction.denominator));
        }
        BigInteger bigIntegerMultiply = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(fraction.denominator / iGreatestCommonDivisor));
        BigInteger bigIntegerMultiply2 = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf(this.denominator / iGreatestCommonDivisor));
        BigInteger bigIntegerAdd = z7 ? bigIntegerMultiply.add(bigIntegerMultiply2) : bigIntegerMultiply.subtract(bigIntegerMultiply2);
        int iIntValue = bigIntegerAdd.mod(BigInteger.valueOf(iGreatestCommonDivisor)).intValue();
        int iGreatestCommonDivisor2 = iIntValue == 0 ? iGreatestCommonDivisor : greatestCommonDivisor(iIntValue, iGreatestCommonDivisor);
        BigInteger bigIntegerDivide = bigIntegerAdd.divide(BigInteger.valueOf(iGreatestCommonDivisor2));
        if (bigIntegerDivide.bitLength() <= 31) {
            return new Fraction(bigIntegerDivide.intValue(), mulPosAndCheck(this.denominator / iGreatestCommonDivisor, fraction.denominator / iGreatestCommonDivisor2));
        }
        throw new ArithmeticException("overflow: numerator too large after multiply");
    }

    public static Fraction getFraction(int i7, int i8) {
        if (i8 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i8 < 0) {
            if (i7 == Integer.MIN_VALUE || i8 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: can't negate");
            }
            i7 = -i7;
            i8 = -i8;
        }
        return new Fraction(i7, i8);
    }

    public static Fraction getReducedFraction(int i7, int i8) {
        if (i8 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i7 == 0) {
            return ZERO;
        }
        if (i8 == Integer.MIN_VALUE && (i7 & 1) == 0) {
            i7 /= 2;
            i8 /= 2;
        }
        if (i8 < 0) {
            if (i7 == Integer.MIN_VALUE || i8 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: can't negate");
            }
            i7 = -i7;
            i8 = -i8;
        }
        int iGreatestCommonDivisor = greatestCommonDivisor(i7, i8);
        return new Fraction(i7 / iGreatestCommonDivisor, i8 / iGreatestCommonDivisor);
    }

    private static int greatestCommonDivisor(int i7, int i8) {
        int i9;
        if (i7 == 0 || i8 == 0) {
            if (i7 == Integer.MIN_VALUE || i8 == Integer.MIN_VALUE) {
                throw new ArithmeticException("overflow: gcd is 2^31");
            }
            return Math.abs(i7) + Math.abs(i8);
        }
        if (Math.abs(i7) == 1 || Math.abs(i8) == 1) {
            return 1;
        }
        if (i7 > 0) {
            i7 = -i7;
        }
        if (i8 > 0) {
            i8 = -i8;
        }
        int i10 = 0;
        while (true) {
            i9 = i7 & 1;
            if (i9 != 0 || (i8 & 1) != 0 || i10 >= 31) {
                break;
            }
            i7 /= 2;
            i8 /= 2;
            i10++;
        }
        if (i10 == 31) {
            throw new ArithmeticException("overflow: gcd is 2^31");
        }
        int i11 = i9 == 1 ? i8 : -(i7 / 2);
        while (true) {
            if ((i11 & 1) == 0) {
                i11 /= 2;
            } else {
                if (i11 > 0) {
                    i7 = -i11;
                } else {
                    i8 = i11;
                }
                i11 = (i8 - i7) / 2;
                if (i11 == 0) {
                    return (-i7) * (1 << i10);
                }
            }
        }
    }

    private static int mulAndCheck(int i7, int i8) {
        long j7 = ((long) i7) * ((long) i8);
        if (j7 < -2147483648L || j7 > 2147483647L) {
            throw new ArithmeticException("overflow: mul");
        }
        return (int) j7;
    }

    private static int mulPosAndCheck(int i7, int i8) {
        long j7 = ((long) i7) * ((long) i8);
        if (j7 <= 2147483647L) {
            return (int) j7;
        }
        throw new ArithmeticException("overflow: mulPos");
    }

    private static int subAndCheck(int i7, int i8) {
        long j7 = ((long) i7) - ((long) i8);
        if (j7 < -2147483648L || j7 > 2147483647L) {
            throw new ArithmeticException("overflow: add");
        }
        return (int) j7;
    }

    public Fraction abs() {
        return this.numerator >= 0 ? this : negate();
    }

    public Fraction add(Fraction fraction) {
        return addSub(fraction, true);
    }

    public Fraction divideBy(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        }
        if (fraction.numerator != 0) {
            return multiplyBy(fraction.invert());
        }
        throw new ArithmeticException("The fraction to divide by must not be zero");
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction fraction = (Fraction) obj;
        return getNumerator() == fraction.getNumerator() && getDenominator() == fraction.getDenominator();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.numerator / this.denominator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((getNumerator() + 629) * 37) + getDenominator();
        }
        return this.hashCode;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.numerator / this.denominator;
    }

    public Fraction invert() {
        int i7 = this.numerator;
        if (i7 == 0) {
            throw new ArithmeticException("Unable to invert zero.");
        }
        if (i7 != Integer.MIN_VALUE) {
            return i7 < 0 ? new Fraction(-this.denominator, -i7) : new Fraction(this.denominator, i7);
        }
        throw new ArithmeticException("overflow: can't negate numerator");
    }

    @Override // java.lang.Number
    public long longValue() {
        return ((long) this.numerator) / ((long) this.denominator);
    }

    public Fraction multiplyBy(Fraction fraction) {
        if (fraction == null) {
            throw new IllegalArgumentException("The fraction must not be null");
        }
        int i7 = this.numerator;
        if (i7 == 0 || fraction.numerator == 0) {
            return ZERO;
        }
        int iGreatestCommonDivisor = greatestCommonDivisor(i7, fraction.denominator);
        int iGreatestCommonDivisor2 = greatestCommonDivisor(fraction.numerator, this.denominator);
        return getReducedFraction(mulAndCheck(this.numerator / iGreatestCommonDivisor, fraction.numerator / iGreatestCommonDivisor2), mulPosAndCheck(this.denominator / iGreatestCommonDivisor2, fraction.denominator / iGreatestCommonDivisor));
    }

    public Fraction negate() {
        int i7 = this.numerator;
        if (i7 != Integer.MIN_VALUE) {
            return new Fraction(-i7, this.denominator);
        }
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction pow(int i7) {
        if (i7 == 1) {
            return this;
        }
        if (i7 == 0) {
            return ONE;
        }
        if (i7 < 0) {
            return i7 == Integer.MIN_VALUE ? invert().pow(2).pow(-(i7 / 2)) : invert().pow(-i7);
        }
        Fraction fractionMultiplyBy = multiplyBy(this);
        return i7 % 2 == 0 ? fractionMultiplyBy.pow(i7 / 2) : fractionMultiplyBy.pow(i7 / 2).multiplyBy(this);
    }

    public Fraction reduce() {
        int i7 = this.numerator;
        if (i7 == 0) {
            Fraction fraction = ZERO;
            return equals(fraction) ? this : fraction;
        }
        int iGreatestCommonDivisor = greatestCommonDivisor(Math.abs(i7), this.denominator);
        return iGreatestCommonDivisor == 1 ? this : getFraction(this.numerator / iGreatestCommonDivisor, this.denominator / iGreatestCommonDivisor);
    }

    public Fraction subtract(Fraction fraction) {
        return addSub(fraction, false);
    }

    public String toProperString() {
        if (this.toProperString == null) {
            int i7 = this.numerator;
            if (i7 == 0) {
                this.toProperString = "0";
            } else {
                int i8 = this.denominator;
                if (i7 == i8) {
                    this.toProperString = "1";
                } else if (i7 == i8 * (-1)) {
                    this.toProperString = "-1";
                } else {
                    if (i7 > 0) {
                        i7 = -i7;
                    }
                    if (i7 < (-i8)) {
                        int properNumerator = getProperNumerator();
                        if (properNumerator == 0) {
                            this.toProperString = Integer.toString(getProperWhole());
                        } else {
                            StringBuilder sb = new StringBuilder(32);
                            sb.append(getProperWhole());
                            sb.append(' ');
                            sb.append(properNumerator);
                            sb.append('/');
                            sb.append(getDenominator());
                            this.toProperString = sb.toString();
                        }
                    } else {
                        StringBuilder sb2 = new StringBuilder(32);
                        sb2.append(getNumerator());
                        sb2.append('/');
                        sb2.append(getDenominator());
                        this.toProperString = sb2.toString();
                    }
                }
            }
        }
        return this.toProperString;
    }

    public String toString() {
        if (this.toString == null) {
            StringBuilder sb = new StringBuilder(32);
            sb.append(getNumerator());
            sb.append('/');
            sb.append(getDenominator());
            this.toString = sb.toString();
        }
        return this.toString;
    }

    @Override // java.lang.Comparable
    public int compareTo(Fraction fraction) {
        if (this == fraction) {
            return 0;
        }
        int i7 = this.numerator;
        int i8 = fraction.numerator;
        if (i7 == i8 && this.denominator == fraction.denominator) {
            return 0;
        }
        long j7 = ((long) i7) * ((long) fraction.denominator);
        long j8 = ((long) i8) * ((long) this.denominator);
        if (j7 == j8) {
            return 0;
        }
        return j7 < j8 ? -1 : 1;
    }

    public static Fraction getFraction(int i7, int i8, int i9) {
        if (i9 == 0) {
            throw new ArithmeticException("The denominator must not be zero");
        }
        if (i9 < 0) {
            throw new ArithmeticException("The denominator must not be negative");
        }
        if (i8 < 0) {
            throw new ArithmeticException("The numerator must not be negative");
        }
        long j7 = i7 < 0 ? (((long) i7) * ((long) i9)) - ((long) i8) : (((long) i7) * ((long) i9)) + ((long) i8);
        if (j7 >= -2147483648L && j7 <= 2147483647L) {
            return new Fraction((int) j7, i9);
        }
        throw new ArithmeticException("Numerator too large to represent as an Integer.");
    }

    public static Fraction getFraction(double d8) {
        int i7;
        int i8 = d8 < 0.0d ? -1 : 1;
        double dAbs = Math.abs(d8);
        if (dAbs > 2.147483647E9d || Double.isNaN(dAbs)) {
            throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
        }
        int i9 = (int) dAbs;
        double d9 = dAbs - ((double) i9);
        int i10 = (int) d9;
        double d10 = d9 - ((double) i10);
        double d11 = d9;
        double d12 = Double.MAX_VALUE;
        int i11 = 1;
        int i12 = 1;
        double d13 = 1.0d;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1;
        while (true) {
            int i16 = (int) (d13 / d10);
            double d14 = d13 - (((double) i16) * d10);
            int i17 = (i10 * i15) + i13;
            int i18 = (i10 * i14) + i11;
            double d15 = d10;
            double d16 = d11;
            double dAbs2 = Math.abs(d16 - (((double) i17) / ((double) i18)));
            i7 = i12 + 1;
            if (d12 <= dAbs2 || i18 > 10000 || i18 <= 0 || i7 >= 25) {
                break;
            }
            d12 = dAbs2;
            d11 = d16;
            i11 = i14;
            i12 = i7;
            d10 = d14;
            i14 = i18;
            i10 = i16;
            i13 = i15;
            i15 = i17;
            d13 = d15;
        }
        if (i7 != 25) {
            return getReducedFraction((i15 + (i9 * i14)) * i8, i14);
        }
        throw new ArithmeticException("Unable to convert double to fraction");
    }

    public static Fraction getFraction(String str) {
        if (str != null) {
            if (str.indexOf(46) >= 0) {
                return getFraction(Double.parseDouble(str));
            }
            int iIndexOf = str.indexOf(32);
            if (iIndexOf > 0) {
                int i7 = Integer.parseInt(str.substring(0, iIndexOf));
                String strSubstring = str.substring(iIndexOf + 1);
                int iIndexOf2 = strSubstring.indexOf(47);
                if (iIndexOf2 >= 0) {
                    return getFraction(i7, Integer.parseInt(strSubstring.substring(0, iIndexOf2)), Integer.parseInt(strSubstring.substring(iIndexOf2 + 1)));
                }
                throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
            }
            int iIndexOf3 = str.indexOf(47);
            if (iIndexOf3 < 0) {
                return getFraction(Integer.parseInt(str), 1);
            }
            return getFraction(Integer.parseInt(str.substring(0, iIndexOf3)), Integer.parseInt(str.substring(iIndexOf3 + 1)));
        }
        throw new IllegalArgumentException("The string must not be null");
    }
}
