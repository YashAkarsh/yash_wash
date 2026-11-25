package okio;

import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
@h5.h(name = "Utf8")
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f38528a = 63;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char f38529b = 65533;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38530c = 65533;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f38531d = 55232;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f38532e = 56320;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f38533f = 3968;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f38534g = -123008;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f38535h = 3678080;

    public static final boolean a(int i7) {
        return (i7 >= 0 && 31 >= i7) || (127 <= i7 && 159 >= i7);
    }

    public static final boolean b(byte b8) {
        return (b8 & 192) == 128;
    }

    public static final int c(@a7.d byte[] process2Utf8Bytes, int i7, int i8, @a7.d i5.l<? super Integer, l2> yield) {
        kotlin.jvm.internal.l0.p(process2Utf8Bytes, "$this$process2Utf8Bytes");
        kotlin.jvm.internal.l0.p(yield, "yield");
        int i9 = i7 + 1;
        Integer numValueOf = Integer.valueOf(f38530c);
        if (i8 <= i9) {
            yield.z(numValueOf);
            return 1;
        }
        byte b8 = process2Utf8Bytes[i7];
        byte b9 = process2Utf8Bytes[i9];
        if (!((b9 & 192) == 128)) {
            yield.z(numValueOf);
            return 1;
        }
        int i10 = (b9 ^ 3968) ^ (b8 << 6);
        if (i10 < 128) {
            yield.z(numValueOf);
            return 2;
        }
        yield.z(Integer.valueOf(i10));
        return 2;
    }

    public static final int d(@a7.d byte[] process3Utf8Bytes, int i7, int i8, @a7.d i5.l<? super Integer, l2> yield) {
        kotlin.jvm.internal.l0.p(process3Utf8Bytes, "$this$process3Utf8Bytes");
        kotlin.jvm.internal.l0.p(yield, "yield");
        int i9 = i7 + 2;
        Integer numValueOf = Integer.valueOf(f38530c);
        if (i8 <= i9) {
            yield.z(numValueOf);
            int i10 = i7 + 1;
            if (i8 > i10) {
                if ((process3Utf8Bytes[i10] & 192) == 128) {
                    return 2;
                }
            }
            return 1;
        }
        byte b8 = process3Utf8Bytes[i7];
        byte b9 = process3Utf8Bytes[i7 + 1];
        if (!((b9 & 192) == 128)) {
            yield.z(numValueOf);
            return 1;
        }
        byte b10 = process3Utf8Bytes[i9];
        if (!((b10 & 192) == 128)) {
            yield.z(numValueOf);
            return 2;
        }
        int i11 = ((b10 ^ (-123008)) ^ (b9 << 6)) ^ (b8 << com.google.common.base.c.f19314n);
        if (i11 < 2048) {
            yield.z(numValueOf);
            return 3;
        }
        if (55296 <= i11 && 57343 >= i11) {
            yield.z(numValueOf);
            return 3;
        }
        yield.z(Integer.valueOf(i11));
        return 3;
    }

    public static final int e(@a7.d byte[] process4Utf8Bytes, int i7, int i8, @a7.d i5.l<? super Integer, l2> yield) {
        kotlin.jvm.internal.l0.p(process4Utf8Bytes, "$this$process4Utf8Bytes");
        kotlin.jvm.internal.l0.p(yield, "yield");
        int i9 = i7 + 3;
        Integer numValueOf = Integer.valueOf(f38530c);
        if (i8 <= i9) {
            yield.z(numValueOf);
            int i10 = i7 + 1;
            if (i8 > i10) {
                if ((process4Utf8Bytes[i10] & 192) == 128) {
                    int i11 = i7 + 2;
                    if (i8 > i11) {
                        if ((process4Utf8Bytes[i11] & 192) == 128) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b8 = process4Utf8Bytes[i7];
        byte b9 = process4Utf8Bytes[i7 + 1];
        if (!((b9 & 192) == 128)) {
            yield.z(numValueOf);
            return 1;
        }
        byte b10 = process4Utf8Bytes[i7 + 2];
        if (!((b10 & 192) == 128)) {
            yield.z(numValueOf);
            return 2;
        }
        byte b11 = process4Utf8Bytes[i9];
        if (!((b11 & 192) == 128)) {
            yield.z(numValueOf);
            return 3;
        }
        int i12 = (((b11 ^ 3678080) ^ (b10 << 6)) ^ (b9 << com.google.common.base.c.f19314n)) ^ (b8 << com.google.common.base.c.f19321u);
        if (i12 > 1114111) {
            yield.z(numValueOf);
            return 4;
        }
        if (55296 <= i12 && 57343 >= i12) {
            yield.z(numValueOf);
            return 4;
        }
        if (i12 < 65536) {
            yield.z(numValueOf);
            return 4;
        }
        yield.z(Integer.valueOf(i12));
        return 4;
    }

    public static final void f(@a7.d byte[] processUtf16Chars, int i7, int i8, @a7.d i5.l<? super Character, l2> yield) {
        int i9;
        kotlin.jvm.internal.l0.p(processUtf16Chars, "$this$processUtf16Chars");
        kotlin.jvm.internal.l0.p(yield, "yield");
        int i10 = i7;
        while (i10 < i8) {
            byte b8 = processUtf16Chars[i10];
            if (b8 >= 0) {
                yield.z(Character.valueOf((char) b8));
                i10++;
                while (i10 < i8) {
                    byte b9 = processUtf16Chars[i10];
                    if (b9 < 0) {
                        break;
                    }
                    i10++;
                    yield.z(Character.valueOf((char) b9));
                }
            } else {
                if ((b8 >> 5) == -2) {
                    int i11 = i10 + 1;
                    if (i8 > i11) {
                        byte b10 = processUtf16Chars[i11];
                        if ((b10 & 192) == 128) {
                            int i12 = (b8 << 6) ^ (b10 ^ 3968);
                            yield.z(Character.valueOf(i12 < 128 ? (char) f38530c : (char) i12));
                            l2 l2Var = l2.f34958a;
                            i9 = 2;
                            i10 += i9;
                        }
                    }
                    yield.z(Character.valueOf((char) f38530c));
                    l2 l2Var2 = l2.f34958a;
                    i9 = 1;
                    i10 += i9;
                } else if ((b8 >> 4) == -2) {
                    int i13 = i10 + 2;
                    if (i8 <= i13) {
                        yield.z(Character.valueOf((char) f38530c));
                        l2 l2Var3 = l2.f34958a;
                        int i14 = i10 + 1;
                        if (i8 > i14) {
                            if ((processUtf16Chars[i14] & 192) == 128) {
                                i9 = 2;
                            }
                        }
                        i9 = 1;
                    } else {
                        byte b11 = processUtf16Chars[i10 + 1];
                        if ((b11 & 192) == 128) {
                            byte b12 = processUtf16Chars[i13];
                            if ((b12 & 192) == 128) {
                                int i15 = (b8 << com.google.common.base.c.f19314n) ^ ((b12 ^ (-123008)) ^ (b11 << 6));
                                yield.z(Character.valueOf((i15 >= 2048 && (55296 > i15 || 57343 < i15)) ? (char) i15 : (char) f38530c));
                                l2 l2Var4 = l2.f34958a;
                                i9 = 3;
                            } else {
                                yield.z(Character.valueOf((char) f38530c));
                                l2 l2Var5 = l2.f34958a;
                                i9 = 2;
                            }
                        } else {
                            yield.z(Character.valueOf((char) f38530c));
                            l2 l2Var6 = l2.f34958a;
                            i9 = 1;
                        }
                    }
                    i10 += i9;
                } else if ((b8 >> 3) == -2) {
                    int i16 = i10 + 3;
                    if (i8 <= i16) {
                        yield.z(Character.valueOf(f38529b));
                        l2 l2Var7 = l2.f34958a;
                        int i17 = i10 + 1;
                        if (i8 > i17) {
                            if ((processUtf16Chars[i17] & 192) == 128) {
                                int i18 = i10 + 2;
                                if (i8 > i18) {
                                    if ((processUtf16Chars[i18] & 192) == 128) {
                                        i9 = 3;
                                    }
                                }
                                i9 = 2;
                            }
                        }
                        i9 = 1;
                    } else {
                        byte b13 = processUtf16Chars[i10 + 1];
                        if ((b13 & 192) == 128) {
                            byte b14 = processUtf16Chars[i10 + 2];
                            if ((b14 & 192) == 128) {
                                byte b15 = processUtf16Chars[i16];
                                if ((b15 & 192) == 128) {
                                    int i19 = (b8 << com.google.common.base.c.f19321u) ^ (((b15 ^ 3678080) ^ (b14 << 6)) ^ (b13 << com.google.common.base.c.f19314n));
                                    if (i19 <= 1114111 && ((55296 > i19 || 57343 < i19) && i19 >= 65536 && i19 != 65533)) {
                                        yield.z(Character.valueOf((char) ((i19 >>> 10) + f38531d)));
                                        yield.z(Character.valueOf((char) ((i19 & 1023) + f38532e)));
                                    } else {
                                        yield.z(Character.valueOf(f38529b));
                                    }
                                    l2 l2Var8 = l2.f34958a;
                                    i9 = 4;
                                } else {
                                    yield.z(Character.valueOf(f38529b));
                                    l2 l2Var9 = l2.f34958a;
                                    i9 = 3;
                                }
                            } else {
                                yield.z(Character.valueOf(f38529b));
                                l2 l2Var10 = l2.f34958a;
                                i9 = 2;
                            }
                        } else {
                            yield.z(Character.valueOf(f38529b));
                            l2 l2Var11 = l2.f34958a;
                            i9 = 1;
                        }
                    }
                    i10 += i9;
                } else {
                    yield.z(Character.valueOf(f38529b));
                    i10++;
                }
            }
        }
    }

    public static final void g(@a7.d String processUtf8Bytes, int i7, int i8, @a7.d i5.l<? super Byte, l2> yield) {
        int i9;
        char cCharAt;
        kotlin.jvm.internal.l0.p(processUtf8Bytes, "$this$processUtf8Bytes");
        kotlin.jvm.internal.l0.p(yield, "yield");
        while (i7 < i8) {
            char cCharAt2 = processUtf8Bytes.charAt(i7);
            if (kotlin.jvm.internal.l0.t(cCharAt2, 128) < 0) {
                yield.z(Byte.valueOf((byte) cCharAt2));
                i7++;
                while (i7 < i8 && kotlin.jvm.internal.l0.t(processUtf8Bytes.charAt(i7), 128) < 0) {
                    yield.z(Byte.valueOf((byte) processUtf8Bytes.charAt(i7)));
                    i7++;
                }
            } else {
                if (kotlin.jvm.internal.l0.t(cCharAt2, 2048) < 0) {
                    yield.z(Byte.valueOf((byte) ((cCharAt2 >> 6) | com.alibaba.fastjson.asm.j.f12606c0)));
                    yield.z(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (55296 > cCharAt2 || 57343 < cCharAt2) {
                    yield.z(Byte.valueOf((byte) ((cCharAt2 >> '\f') | 224)));
                    yield.z(Byte.valueOf((byte) (((cCharAt2 >> 6) & 63) | 128)));
                    yield.z(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (kotlin.jvm.internal.l0.t(cCharAt2, 56319) > 0 || i8 <= (i9 = i7 + 1) || 56320 > (cCharAt = processUtf8Bytes.charAt(i9)) || 57343 < cCharAt) {
                    yield.z(Byte.valueOf(f38528a));
                } else {
                    int iCharAt = ((cCharAt2 << '\n') + processUtf8Bytes.charAt(i9)) - 56613888;
                    yield.z(Byte.valueOf((byte) ((iCharAt >> 18) | 240)));
                    yield.z(Byte.valueOf((byte) (((iCharAt >> 12) & 63) | 128)));
                    yield.z(Byte.valueOf((byte) (((iCharAt >> 6) & 63) | 128)));
                    yield.z(Byte.valueOf((byte) ((iCharAt & 63) | 128)));
                    i7 += 2;
                }
                i7++;
            }
        }
    }

    public static final void h(@a7.d byte[] processUtf8CodePoints, int i7, int i8, @a7.d i5.l<? super Integer, l2> yield) {
        int i9;
        kotlin.jvm.internal.l0.p(processUtf8CodePoints, "$this$processUtf8CodePoints");
        kotlin.jvm.internal.l0.p(yield, "yield");
        int i10 = i7;
        while (i10 < i8) {
            byte b8 = processUtf8CodePoints[i10];
            if (b8 >= 0) {
                yield.z(Integer.valueOf(b8));
                i10++;
                while (i10 < i8) {
                    byte b9 = processUtf8CodePoints[i10];
                    if (b9 < 0) {
                        break;
                    }
                    i10++;
                    yield.z(Integer.valueOf(b9));
                }
            } else {
                if ((b8 >> 5) == -2) {
                    int i11 = i10 + 1;
                    if (i8 > i11) {
                        byte b10 = processUtf8CodePoints[i11];
                        if ((b10 & 192) == 128) {
                            int i12 = (b8 << 6) ^ (b10 ^ 3968);
                            yield.z(i12 < 128 ? Integer.valueOf(f38530c) : Integer.valueOf(i12));
                            l2 l2Var = l2.f34958a;
                            i9 = 2;
                            i10 += i9;
                        }
                    }
                    yield.z(Integer.valueOf(f38530c));
                    l2 l2Var2 = l2.f34958a;
                    i9 = 1;
                    i10 += i9;
                } else if ((b8 >> 4) == -2) {
                    int i13 = i10 + 2;
                    if (i8 <= i13) {
                        yield.z(Integer.valueOf(f38530c));
                        l2 l2Var3 = l2.f34958a;
                        int i14 = i10 + 1;
                        if (i8 > i14) {
                            if ((processUtf8CodePoints[i14] & 192) == 128) {
                                i9 = 2;
                            }
                        }
                        i9 = 1;
                    } else {
                        byte b11 = processUtf8CodePoints[i10 + 1];
                        if ((b11 & 192) == 128) {
                            byte b12 = processUtf8CodePoints[i13];
                            if ((b12 & 192) == 128) {
                                int i15 = (b8 << com.google.common.base.c.f19314n) ^ ((b12 ^ (-123008)) ^ (b11 << 6));
                                yield.z((i15 >= 2048 && (55296 > i15 || 57343 < i15)) ? Integer.valueOf(i15) : Integer.valueOf(f38530c));
                                l2 l2Var4 = l2.f34958a;
                                i9 = 3;
                            } else {
                                yield.z(Integer.valueOf(f38530c));
                                l2 l2Var5 = l2.f34958a;
                                i9 = 2;
                            }
                        } else {
                            yield.z(Integer.valueOf(f38530c));
                            l2 l2Var6 = l2.f34958a;
                            i9 = 1;
                        }
                    }
                    i10 += i9;
                } else if ((b8 >> 3) == -2) {
                    int i16 = i10 + 3;
                    if (i8 <= i16) {
                        yield.z(Integer.valueOf(f38530c));
                        l2 l2Var7 = l2.f34958a;
                        int i17 = i10 + 1;
                        if (i8 > i17) {
                            if ((processUtf8CodePoints[i17] & 192) == 128) {
                                int i18 = i10 + 2;
                                if (i8 > i18) {
                                    if ((processUtf8CodePoints[i18] & 192) == 128) {
                                        i9 = 3;
                                    }
                                }
                                i9 = 2;
                            }
                        }
                        i9 = 1;
                    } else {
                        byte b13 = processUtf8CodePoints[i10 + 1];
                        if ((b13 & 192) == 128) {
                            byte b14 = processUtf8CodePoints[i10 + 2];
                            if ((b14 & 192) == 128) {
                                byte b15 = processUtf8CodePoints[i16];
                                if ((b15 & 192) == 128) {
                                    int i19 = (b8 << com.google.common.base.c.f19321u) ^ (((b15 ^ 3678080) ^ (b14 << 6)) ^ (b13 << com.google.common.base.c.f19314n));
                                    yield.z((i19 <= 1114111 && (55296 > i19 || 57343 < i19) && i19 >= 65536) ? Integer.valueOf(i19) : Integer.valueOf(f38530c));
                                    l2 l2Var8 = l2.f34958a;
                                    i9 = 4;
                                } else {
                                    yield.z(Integer.valueOf(f38530c));
                                    l2 l2Var9 = l2.f34958a;
                                    i9 = 3;
                                }
                            } else {
                                yield.z(Integer.valueOf(f38530c));
                                l2 l2Var10 = l2.f34958a;
                                i9 = 2;
                            }
                        } else {
                            yield.z(Integer.valueOf(f38530c));
                            l2 l2Var11 = l2.f34958a;
                            i9 = 1;
                        }
                    }
                    i10 += i9;
                } else {
                    yield.z(Integer.valueOf(f38530c));
                    i10++;
                }
            }
        }
    }

    @h5.i
    @h5.h(name = "size")
    public static final long i(@a7.d String str) {
        return l(str, 0, 0, 3, null);
    }

    @h5.i
    @h5.h(name = "size")
    public static final long j(@a7.d String str, int i7) {
        return l(str, i7, 0, 2, null);
    }

    @h5.i
    @h5.h(name = "size")
    public static final long k(@a7.d String utf8Size, int i7, int i8) {
        int i9;
        kotlin.jvm.internal.l0.p(utf8Size, "$this$utf8Size");
        if (!(i7 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i7).toString());
        }
        if (!(i8 >= i7)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i8 + " < " + i7).toString());
        }
        if (!(i8 <= utf8Size.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i8 + " > " + utf8Size.length()).toString());
        }
        long j7 = 0;
        while (i7 < i8) {
            char cCharAt = utf8Size.charAt(i7);
            if (cCharAt < 128) {
                j7++;
            } else {
                if (cCharAt < 2048) {
                    i9 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i9 = 3;
                } else {
                    int i10 = i7 + 1;
                    char cCharAt2 = i10 < i8 ? utf8Size.charAt(i10) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j7++;
                        i7 = i10;
                    } else {
                        j7 += (long) 4;
                        i7 += 2;
                    }
                }
                j7 += (long) i9;
            }
            i7++;
        }
        return j7;
    }

    public static /* synthetic */ long l(String str, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i7 = 0;
        }
        if ((i9 & 2) != 0) {
            i8 = str.length();
        }
        return k(str, i7, i8);
    }
}
