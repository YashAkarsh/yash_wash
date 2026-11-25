package org.apache.commons.lang3;

import java.util.Random;
import okio.r0;

/* JADX INFO: loaded from: classes3.dex */
public class RandomStringUtils {
    private static final Random RANDOM = new Random();

    public static String random(int i7) {
        return random(i7, false, false);
    }

    public static String randomAlphabetic(int i7) {
        return random(i7, true, false);
    }

    public static String randomAlphanumeric(int i7) {
        return random(i7, true, true);
    }

    public static String randomAscii(int i7) {
        return random(i7, 32, 127, false, false);
    }

    public static String randomNumeric(int i7) {
        return random(i7, false, true);
    }

    public static String random(int i7, boolean z7, boolean z8) {
        return random(i7, 0, 0, z7, z8);
    }

    public static String random(int i7, int i8, int i9, boolean z7, boolean z8) {
        return random(i7, i8, i9, z7, z8, null, RANDOM);
    }

    public static String random(int i7, int i8, int i9, boolean z7, boolean z8, char... cArr) {
        return random(i7, i8, i9, z7, z8, cArr, RANDOM);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    public static String random(int i7, int i8, int i9, boolean z7, boolean z8, char[] cArr, Random random) {
        char cNextInt;
        if (i7 == 0) {
            return "";
        }
        if (i7 >= 0) {
            if (cArr != null && cArr.length == 0) {
                throw new IllegalArgumentException("The chars array must not be empty");
            }
            if (i8 == 0 && i9 == 0) {
                if (cArr != null) {
                    i9 = cArr.length;
                } else if (z7 || z8) {
                    i9 = 123;
                    i8 = 32;
                } else {
                    i9 = Integer.MAX_VALUE;
                }
            } else if (i9 <= i8) {
                throw new IllegalArgumentException("Parameter end (" + i9 + ") must be greater than start (" + i8 + ")");
            }
            char[] cArr2 = new char[i7];
            int i10 = i9 - i8;
            while (true) {
                int i11 = i7 - 1;
                if (i7 != 0) {
                    if (cArr == null) {
                        cNextInt = (char) (random.nextInt(i10) + i8);
                    } else {
                        cNextInt = cArr[random.nextInt(i10) + i8];
                    }
                    if (!(z7 && Character.isLetter(cNextInt)) && (!(z8 && Character.isDigit(cNextInt)) && (z7 || z8))) {
                        i11++;
                    } else if (cNextInt < 56320 || cNextInt > 57343) {
                        if (cNextInt < 55296 || cNextInt > 56191) {
                            if (cNextInt < 56192 || cNextInt > 56319) {
                                cArr2[i11] = cNextInt;
                            } else {
                                i11++;
                            }
                        } else if (i11 == 0) {
                            i11++;
                        } else {
                            cArr2[i11] = (char) (random.nextInt(128) + r0.f38532e);
                            i11--;
                            cArr2[i11] = cNextInt;
                        }
                    } else if (i11 == 0) {
                        i11++;
                    } else {
                        cArr2[i11] = cNextInt;
                        i11--;
                        cArr2[i11] = (char) (random.nextInt(128) + 55296);
                    }
                    i7 = i11;
                } else {
                    return new String(cArr2);
                }
            }
        } else {
            throw new IllegalArgumentException("Requested random string length " + i7 + " is less than 0.");
        }
    }

    public static String random(int i7, String str) {
        if (str == null) {
            return random(i7, 0, 0, false, false, null, RANDOM);
        }
        return random(i7, str.toCharArray());
    }

    public static String random(int i7, char... cArr) {
        if (cArr == null) {
            return random(i7, 0, 0, false, false, null, RANDOM);
        }
        return random(i7, 0, cArr.length, false, false, cArr, RANDOM);
    }
}
