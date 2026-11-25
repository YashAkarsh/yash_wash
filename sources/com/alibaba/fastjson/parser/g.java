package com.alibaba.fastjson.parser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TimeZone;
import kotlin.text.h0;
import org.chromium.base.TimeUtils;

/* JADX INFO: loaded from: classes.dex */
public final class g extends e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f12937u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f12938v;

    public g(String str) {
        this(str, com.alibaba.fastjson.a.f12532f);
    }

    static boolean P2(String str, int i7, char[] cArr) {
        int length = cArr.length;
        if (length + i7 > str.length()) {
            return false;
        }
        for (int i8 = 0; i8 < length; i8++) {
            if (cArr[i8] != str.charAt(i7 + i8)) {
                return false;
            }
        }
        return true;
    }

    static boolean Q2(char c8, char c9, char c10, char c11, char c12, char c13, int i7, int i8) {
        if (c8 >= '1' && c8 <= '3' && c9 >= '0' && c9 <= '9' && c10 >= '0' && c10 <= '9' && c11 >= '0' && c11 <= '9') {
            if (c12 == '0') {
                if (c13 < '1' || c13 > '9') {
                    return false;
                }
            } else if (c12 != '1' || (c13 != '0' && c13 != '1' && c13 != '2')) {
                return false;
            }
            if (i7 == 48) {
                return i8 >= 49 && i8 <= 57;
            }
            if (i7 != 49 && i7 != 50) {
                return i7 == 51 && (i8 == 48 || i8 == 49);
            }
            if (i8 >= 48 && i8 <= 57) {
                return true;
            }
        }
        return false;
    }

    private boolean R2(char c8, char c9, char c10, char c11, char c12, char c13) {
        if (c8 == '0') {
            if (c9 < '0' || c9 > '9') {
                return false;
            }
        } else {
            if (c8 != '1') {
                if (c8 == '2' && c9 >= '0' && c9 <= '4') {
                }
                return false;
            }
            if (c9 < '0' || c9 > '9') {
                return false;
            }
        }
        if (c10 < '0' || c10 > '5') {
            if (c10 != '6' || c11 != '0') {
                return false;
            }
        } else if (c11 < '0' || c11 > '9') {
            return false;
        }
        if (c12 < '0' || c12 > '5') {
            return c12 == '6' && c13 == '0';
        }
        return c13 >= '0' && c13 <= '9';
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:122:0x01f4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:124:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:126:0x0209  */
    /* JADX WARN: Code duplicated, block: B:161:0x02b6 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Code duplicated, block: B:163:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:171:0x031a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:173:0x031c  */
    /* JADX WARN: Code duplicated, block: B:175:0x0339  */
    /* JADX WARN: Code duplicated, block: B:177:0x033d A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Code duplicated, block: B:179:0x033f  */
    /* JADX WARN: Code duplicated, block: B:186:0x0355  */
    /* JADX WARN: Code duplicated, block: B:190:0x0369  */
    /* JADX WARN: Code duplicated, block: B:192:0x036c  */
    /* JADX WARN: Code duplicated, block: B:196:0x0382  */
    /* JADX WARN: Code duplicated, block: B:199:0x0398 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:210:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:212:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:245:0x045d  */
    /* JADX WARN: Code duplicated, block: B:252:0x0474 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:256:0x0478  */
    /* JADX WARN: Code duplicated, block: B:258:0x0491  */
    /* JADX WARN: Code duplicated, block: B:265:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:352:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00ff A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x0101  */
    /* JADX WARN: Code duplicated, block: B:66:0x012e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:72:0x0152  */
    /* JADX WARN: Code duplicated, block: B:74:0x0156  */
    /* JADX WARN: Code duplicated, block: B:76:0x015a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:81:0x0171  */
    /* JADX WARN: Code duplicated, block: B:88:0x017d  */
    private boolean U2(boolean z7, int i7) {
        char c8;
        int i8;
        char cM;
        char c9;
        char c10;
        char c11;
        int i9;
        int i10;
        int i11;
        int i12;
        char c12;
        char c13;
        char cM2;
        char c14;
        char c15;
        int i13;
        char cM3;
        int i14;
        char c16;
        char c17;
        char cM4;
        int i15;
        char cM5;
        char cM6;
        char cM7;
        char cM8;
        char cM9;
        char cM10;
        char cM11;
        int i16;
        char cM12;
        int i17;
        int i18;
        char cM13;
        char cM14;
        char cM15;
        char c18;
        char cM16;
        char cM17;
        char cM18;
        char cM19;
        if (i7 < 8) {
            return false;
        }
        char cM20 = m(this.f12922e);
        char cM21 = m(this.f12922e + 1);
        char cM22 = m(this.f12922e + 2);
        int i19 = 3;
        char cM23 = m(this.f12922e + 3);
        char cM24 = m(this.f12922e + 4);
        char cM25 = m(this.f12922e + 5);
        char cM26 = m(this.f12922e + 6);
        char cM27 = m(this.f12922e + 7);
        if (!z7 && i7 > 13) {
            char cM28 = m((this.f12922e + i7) - 1);
            char cM29 = m((this.f12922e + i7) - 2);
            if (cM20 == '/' && cM21 == 'D' && cM22 == 'a' && cM23 == 't' && cM24 == 'e' && cM25 == '(' && cM28 == '/' && cM29 == ')') {
                int i20 = -1;
                for (int i21 = 6; i21 < i7; i21++) {
                    char cM30 = m(this.f12922e + i21);
                    if (cM30 != '+') {
                        if (cM30 < '0' || cM30 > '9') {
                            break;
                        }
                    } else {
                        i20 = i21;
                    }
                }
                if (i20 == -1) {
                    return false;
                }
                int i22 = this.f12922e;
                int i23 = i22 + 6;
                long j7 = Long.parseLong(N2(i23, (i22 + i20) - i23));
                Calendar calendar = Calendar.getInstance(this.f12929l, this.f12930m);
                this.f12928k = calendar;
                calendar.setTimeInMillis(j7);
                this.f12918a = 5;
                return true;
            }
        }
        if (i7 == 8 || i7 == 14) {
            c8 = '9';
            i8 = 14;
        } else {
            if (i7 == 16) {
                char cM31 = m(this.f12922e + 10);
                if (cM31 == 'T') {
                    c8 = '9';
                    i8 = 14;
                } else if (cM31 != ' ') {
                    if (i7 == 17) {
                    }
                    if (i7 < 9) {
                        return false;
                    }
                    cM3 = m(this.f12922e + 8);
                    cM3 = m(this.f12922e + 9);
                    if (cM24 == '-') {
                        if (cM24 == '-') {
                            if (cM22 != '.') {
                                if (cM24 == 24180) {
                                }
                                if (cM27 != 26376) {
                                }
                                if (cM3 != 26085) {
                                }
                                cM3 = cM3;
                                cM23 = cM23;
                                cM20 = cM20;
                                i14 = 10;
                                c16 = '0';
                                c17 = cM26;
                                cM22 = cM22;
                            } else {
                                if (cM24 == 24180) {
                                }
                                if (cM27 != 26376) {
                                }
                                if (cM3 != 26085) {
                                }
                                cM3 = cM3;
                                cM23 = cM23;
                                cM20 = cM20;
                                i14 = 10;
                                c16 = '0';
                                c17 = cM26;
                                cM22 = cM22;
                            }
                        } else if (cM22 != '.') {
                            if (cM24 == 24180) {
                            }
                            if (cM27 != 26376) {
                            }
                            if (cM3 != 26085) {
                            }
                            cM3 = cM3;
                            cM23 = cM23;
                            cM20 = cM20;
                            i14 = 10;
                            c16 = '0';
                            c17 = cM26;
                            cM22 = cM22;
                        } else {
                            if (cM24 == 24180) {
                            }
                            if (cM27 != 26376) {
                            }
                            if (cM3 != 26085) {
                            }
                            cM3 = cM3;
                            cM23 = cM23;
                            cM20 = cM20;
                            i14 = 10;
                            c16 = '0';
                            c17 = cM26;
                            cM22 = cM22;
                        }
                    } else if (cM24 == '-') {
                        if (cM22 != '.') {
                            if (cM24 == 24180) {
                            }
                            if (cM27 != 26376) {
                            }
                            if (cM3 != 26085) {
                            }
                            cM3 = cM3;
                            cM23 = cM23;
                            cM20 = cM20;
                            i14 = 10;
                            c16 = '0';
                            c17 = cM26;
                            cM22 = cM22;
                        } else {
                            if (cM24 == 24180) {
                            }
                            if (cM27 != 26376) {
                            }
                            if (cM3 != 26085) {
                            }
                            cM3 = cM3;
                            cM23 = cM23;
                            cM20 = cM20;
                            i14 = 10;
                            c16 = '0';
                            c17 = cM26;
                            cM22 = cM22;
                        }
                    } else if (cM22 != '.') {
                        if (cM24 == 24180) {
                        }
                        if (cM27 != 26376) {
                        }
                        if (cM3 != 26085) {
                        }
                        cM3 = cM3;
                        cM23 = cM23;
                        cM20 = cM20;
                        i14 = 10;
                        c16 = '0';
                        c17 = cM26;
                        cM22 = cM22;
                    } else {
                        if (cM24 == 24180) {
                        }
                        if (cM27 != 26376) {
                        }
                        if (cM3 != 26085) {
                        }
                        cM3 = cM3;
                        cM23 = cM23;
                        cM20 = cM20;
                        i14 = 10;
                        c16 = '0';
                        c17 = cM26;
                        cM22 = cM22;
                    }
                    if (!Q2(cM20, cM21, cM22, cM23, cM25, c17, c16, cM3)) {
                        return false;
                    }
                    V2(cM20, cM21, cM22, cM23, cM25, c17, c16, cM3);
                    cM4 = m(this.f12922e + i14);
                    if (cM4 == 'T') {
                    }
                    i15 = i14 + 9;
                    if (i7 >= i15) {
                        return false;
                    }
                    cM5 = m(this.f12922e + i14 + 1);
                    cM6 = m(this.f12922e + i14 + 2);
                    cM7 = m(this.f12922e + i14 + 4);
                    cM8 = m(this.f12922e + i14 + 5);
                    cM9 = m(this.f12922e + i14 + 7);
                    cM10 = m(this.f12922e + i14 + 8);
                    if (!R2(cM5, cM6, cM7, cM8, cM9, cM10)) {
                        return false;
                    }
                    W2(cM5, cM6, cM7, cM8, cM9, cM10);
                    cM11 = m(this.f12922e + i14 + 9);
                    if (cM11 != '.') {
                        this.f12928k.set(14, 0);
                        int i24 = this.f12922e + i15;
                        this.f12922e = i24;
                        this.f12921d = m(i24);
                        this.f12918a = 5;
                        if (cM11 == 'Z') {
                            return true;
                        }
                        return true;
                    }
                    i16 = i14 + 11;
                    if (i7 >= i16) {
                        return false;
                    }
                    int i25 = cM12 - '0';
                    if (i7 > i16) {
                        i17 = 1;
                    } else {
                        i17 = 1;
                    }
                    if (i17 == 2) {
                        i18 = i17;
                    } else {
                        i18 = i17;
                    }
                    this.f12928k.set(14, i25);
                    cM13 = m(this.f12922e + i14 + 10 + i18);
                    if (cM13 != '+') {
                        cM14 = m(this.f12922e + i14 + 10 + i18 + 1);
                        if (cM14 >= '0') {
                            return false;
                        }
                        return false;
                    }
                    cM14 = m(this.f12922e + i14 + 10 + i18 + 1);
                    if (cM14 >= '0') {
                        return false;
                    }
                    return false;
                    int i26 = i14 + 10 + i18 + i19;
                    cM17 = m(this.f12922e + i26);
                    if (cM17 == 26) {
                    }
                    int i27 = this.f12922e + i26;
                    this.f12922e = i27;
                    this.f12921d = m(i27);
                    this.f12918a = 5;
                    return true;
                }
            } else if (i7 == 17 || m(this.f12922e + 6) == '-') {
                if (i7 < 9) {
                    return false;
                }
                cM3 = m(this.f12922e + 8);
                cM3 = m(this.f12922e + 9);
                if ((cM24 == '-' || cM27 != '-') && !(cM24 == '/' && cM27 == '/')) {
                    if (cM24 == '-' || cM26 != '-') {
                        if ((cM22 != '.' && cM25 == '.') || (cM22 == '-' && cM25 == '-')) {
                            cM21 = cM27;
                            cM23 = cM3;
                            cM25 = cM23;
                            c16 = cM20;
                            cM3 = cM21;
                            i14 = 10;
                            c17 = cM24;
                            cM20 = cM26;
                            cM22 = cM3;
                        } else {
                            if (cM24 == 24180 && cM24 != 45380) {
                                return false;
                            }
                            if (cM27 != 26376 || cM27 == 50900) {
                                if (cM3 != 26085 || cM3 == 51068) {
                                    cM3 = cM3;
                                    cM23 = cM23;
                                    cM20 = cM20;
                                    i14 = 10;
                                    c16 = '0';
                                } else {
                                    if (m(this.f12922e + 10) != 26085 && m(this.f12922e + 10) != 51068) {
                                        return false;
                                    }
                                    i14 = 11;
                                }
                                c17 = cM26;
                                cM22 = cM22;
                            } else {
                                if (cM26 != 26376 && cM26 != 50900) {
                                    return false;
                                }
                                if (cM3 == 26085 || cM3 == 51068) {
                                    cM22 = cM22;
                                    c17 = cM25;
                                    cM3 = cM27;
                                    cM23 = cM23;
                                    cM20 = cM20;
                                    cM21 = cM21;
                                    i14 = 10;
                                    cM25 = '0';
                                    c16 = '0';
                                } else {
                                    if (cM3 != 26085 && cM3 != 51068) {
                                        return false;
                                    }
                                    i14 = 10;
                                    cM25 = '0';
                                    c17 = cM25;
                                    cM21 = cM21;
                                    c16 = cM27;
                                    cM23 = cM23;
                                }
                            }
                        }
                    } else if (cM3 == ' ') {
                        cM22 = cM22;
                        c17 = cM25;
                        cM3 = cM27;
                        cM23 = cM23;
                        cM20 = cM20;
                        cM21 = cM21;
                        cM25 = '0';
                        c16 = '0';
                        i14 = 8;
                    } else {
                        cM25 = '0';
                        i14 = 9;
                        c17 = cM25;
                        cM21 = cM21;
                        c16 = cM27;
                        cM23 = cM23;
                    }
                    if (!Q2(cM20, cM21, cM22, cM23, cM25, c17, c16, cM3)) {
                        return false;
                    }
                    V2(cM20, cM21, cM22, cM23, cM25, c17, c16, cM3);
                    cM4 = m(this.f12922e + i14);
                    if (cM4 == 'T' && (cM4 != ' ' || z7)) {
                        if (cM4 == '\"' || cM4 == 26 || cM4 == 26085 || cM4 == 51068) {
                            this.f12928k.set(11, 0);
                            this.f12928k.set(12, 0);
                            this.f12928k.set(13, 0);
                            this.f12928k.set(14, 0);
                            int i28 = this.f12922e + i14;
                            this.f12922e = i28;
                            this.f12921d = m(i28);
                            this.f12918a = 5;
                            return true;
                        }
                        if ((cM4 != '+' && cM4 != '-') || this.f12938v != i14 + 6 || m(this.f12922e + i14 + 3) != ':' || m(this.f12922e + i14 + 4) != '0' || m(this.f12922e + i14 + 5) != '0') {
                            return false;
                        }
                        W2('0', '0', '0', '0', '0', '0');
                        this.f12928k.set(14, 0);
                        X2(cM4, m(this.f12922e + i14 + 1), m(this.f12922e + i14 + 2));
                        return true;
                    }
                    i15 = i14 + 9;
                    if (i7 >= i15 || m(this.f12922e + i14 + 3) != ':' || m(this.f12922e + i14 + 6) != ':') {
                        return false;
                    }
                    cM5 = m(this.f12922e + i14 + 1);
                    cM6 = m(this.f12922e + i14 + 2);
                    cM7 = m(this.f12922e + i14 + 4);
                    cM8 = m(this.f12922e + i14 + 5);
                    cM9 = m(this.f12922e + i14 + 7);
                    cM10 = m(this.f12922e + i14 + 8);
                    if (!R2(cM5, cM6, cM7, cM8, cM9, cM10)) {
                        return false;
                    }
                    W2(cM5, cM6, cM7, cM8, cM9, cM10);
                    cM11 = m(this.f12922e + i14 + 9);
                    if (cM11 != '.') {
                        this.f12928k.set(14, 0);
                        int i29 = this.f12922e + i15;
                        this.f12922e = i29;
                        this.f12921d = m(i29);
                        this.f12918a = 5;
                        if (cM11 == 'Z' || this.f12928k.getTimeZone().getRawOffset() == 0) {
                            return true;
                        }
                        String[] availableIDs = TimeZone.getAvailableIDs(0);
                        if (availableIDs.length <= 0) {
                            return true;
                        }
                        this.f12928k.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
                        return true;
                    }
                    i16 = i14 + 11;
                    if (i7 >= i16 || (cM12 = m(this.f12922e + i14 + 10)) < '0' || cM12 > '9') {
                        return false;
                    }
                    int i210 = cM12 - '0';
                    if (i7 > i16 || (cM19 = m(this.f12922e + i14 + 11)) < '0' || cM19 > '9') {
                        i17 = 1;
                    } else {
                        i210 = (i210 * 10) + (cM19 - '0');
                        i17 = 2;
                    }
                    if (i17 == 2 || (cM18 = m(this.f12922e + i14 + 12)) < '0' || cM18 > '9') {
                        i18 = i17;
                    } else {
                        i210 = (i210 * 10) + (cM18 - '0');
                        i18 = 3;
                    }
                    this.f12928k.set(14, i210);
                    cM13 = m(this.f12922e + i14 + 10 + i18);
                    if (cM13 != '+' || cM13 == '-') {
                        cM14 = m(this.f12922e + i14 + 10 + i18 + 1);
                        if (cM14 >= '0' || cM14 > '1' || (cM15 = m(this.f12922e + i14 + 10 + i18 + 2)) < '0' || cM15 > '9') {
                            return false;
                        }
                        char cM32 = m(this.f12922e + i14 + 10 + i18 + 3);
                        if (cM32 == ':') {
                            char cM33 = m(this.f12922e + i14 + 10 + i18 + 4);
                            if ((cM33 != '0' && cM33 != '3') || (cM16 = m(this.f12922e + i14 + 10 + i18 + 5)) != '0') {
                                return false;
                            }
                            c18 = cM33;
                            i19 = 6;
                        } else {
                            if (cM32 == '0') {
                                char cM34 = m(this.f12922e + i14 + 10 + i18 + 4);
                                if (cM34 != '0' && cM34 != '3') {
                                    return false;
                                }
                                c18 = cM34;
                                i19 = 5;
                            } else {
                                c18 = '0';
                            }
                            cM16 = '0';
                        }
                        Y2(cM13, cM14, cM15, c18, cM16);
                    } else if (cM13 == 'Z') {
                        if (this.f12928k.getTimeZone().getRawOffset() != 0) {
                            String[] availableIDs2 = TimeZone.getAvailableIDs(0);
                            if (availableIDs2.length > 0) {
                                this.f12928k.setTimeZone(TimeZone.getTimeZone(availableIDs2[0]));
                            }
                        }
                        i19 = 1;
                    } else {
                        i19 = 0;
                    }
                    int i211 = i14 + 10 + i18 + i19;
                    cM17 = m(this.f12922e + i211);
                    if (cM17 == 26 && cM17 != '\"') {
                        return false;
                    }
                    int i212 = this.f12922e + i211;
                    this.f12922e = i212;
                    this.f12921d = m(i212);
                    this.f12918a = 5;
                    return true;
                }
                i14 = 10;
                c16 = cM3;
                c17 = cM26;
                cM22 = cM22;
                if (!Q2(cM20, cM21, cM22, cM23, cM25, c17, c16, cM3)) {
                    return false;
                }
                V2(cM20, cM21, cM22, cM23, cM25, c17, c16, cM3);
                cM4 = m(this.f12922e + i14);
                if (cM4 == 'T') {
                }
                i15 = i14 + 9;
                if (i7 >= i15) {
                    return false;
                }
                cM5 = m(this.f12922e + i14 + 1);
                cM6 = m(this.f12922e + i14 + 2);
                cM7 = m(this.f12922e + i14 + 4);
                cM8 = m(this.f12922e + i14 + 5);
                cM9 = m(this.f12922e + i14 + 7);
                cM10 = m(this.f12922e + i14 + 8);
                if (!R2(cM5, cM6, cM7, cM8, cM9, cM10)) {
                    return false;
                }
                W2(cM5, cM6, cM7, cM8, cM9, cM10);
                cM11 = m(this.f12922e + i14 + 9);
                if (cM11 != '.') {
                    this.f12928k.set(14, 0);
                    int i213 = this.f12922e + i15;
                    this.f12922e = i213;
                    this.f12921d = m(i213);
                    this.f12918a = 5;
                    if (cM11 == 'Z') {
                        return true;
                    }
                    return true;
                }
                i16 = i14 + 11;
                if (i7 >= i16) {
                    return false;
                }
                int i214 = cM12 - '0';
                if (i7 > i16) {
                    i17 = 1;
                } else {
                    i17 = 1;
                }
                if (i17 == 2) {
                    i18 = i17;
                } else {
                    i18 = i17;
                }
                this.f12928k.set(14, i214);
                cM13 = m(this.f12922e + i14 + 10 + i18);
                if (cM13 != '+') {
                    cM14 = m(this.f12922e + i14 + 10 + i18 + 1);
                    if (cM14 >= '0') {
                        return false;
                    }
                    return false;
                }
                cM14 = m(this.f12922e + i14 + 10 + i18 + 1);
                if (cM14 >= '0') {
                    return false;
                }
                return false;
                int i215 = i14 + 10 + i18 + i19;
                cM17 = m(this.f12922e + i215);
                if (cM17 == 26) {
                }
                int i216 = this.f12922e + i215;
                this.f12922e = i216;
                this.f12921d = m(i216);
                this.f12918a = 5;
                return true;
            }
            c8 = '9';
            i8 = 14;
        }
        if (z7) {
            return false;
        }
        char cM35 = m(this.f12922e + 8);
        boolean z8 = cM24 == '-' && cM27 == '-';
        boolean z9 = z8 && i7 == 16;
        boolean z10 = z8 && i7 == 17;
        if (z10 || z9) {
            cM = m(this.f12922e + 9);
            c9 = cM25;
            c10 = cM26;
            c11 = cM35;
        } else {
            c9 = cM24;
            c10 = cM25;
            c11 = cM26;
            cM = cM27;
        }
        int i30 = i8;
        if (!Q2(cM20, cM21, cM22, cM23, c9, c10, c11, cM)) {
            return false;
        }
        V2(cM20, cM21, cM22, cM23, c9, c10, c11, cM);
        if (i7 != 8) {
            char cM36 = m(this.f12922e + 9);
            char cM37 = m(this.f12922e + 10);
            char cM38 = m(this.f12922e + 11);
            char cM39 = m(this.f12922e + 12);
            char cM40 = m(this.f12922e + 13);
            if ((z10 && cM37 == 'T' && cM40 == ':' && m(this.f12922e + 16) == 'Z') || (z9 && ((cM37 == ' ' || cM37 == 'T') && cM40 == ':'))) {
                char cM41 = m(this.f12922e + i30);
                cM2 = m(this.f12922e + 15);
                c13 = cM41;
                cM35 = cM38;
                c12 = cM39;
                c14 = '0';
                c15 = '0';
            } else {
                c12 = cM36;
                c13 = cM37;
                cM2 = cM38;
                c14 = cM39;
                c15 = cM40;
            }
            if (!R2(cM35, c12, c13, cM2, c14, c15)) {
                return false;
            }
            if (i7 != 17 || z10) {
                i13 = 0;
            } else {
                char cM42 = m(this.f12922e + i30);
                char cM43 = m(this.f12922e + 15);
                char cM44 = m(this.f12922e + 16);
                if (cM42 < '0' || cM42 > c8 || cM43 < '0' || cM43 > c8 || cM44 < '0' || cM44 > c8) {
                    return false;
                }
                i13 = ((cM42 - '0') * 100) + ((cM43 - '0') * 10) + (cM44 - '0');
            }
            i10 = ((c14 - '0') * 10) + (c15 - '0');
            i12 = ((cM35 - '0') * 10) + (c12 - '0');
            i11 = i13;
            i9 = ((c13 - '0') * 10) + (cM2 - '0');
        } else {
            i9 = 0;
            i10 = 0;
            i11 = 0;
            i12 = 0;
        }
        this.f12928k.set(11, i12);
        this.f12928k.set(12, i9);
        this.f12928k.set(13, i10);
        this.f12928k.set(i30, i11);
        this.f12918a = 5;
        return true;
    }

    private void V2(char c8, char c9, char c10, char c11, char c12, char c13, char c14, char c15) {
        Calendar calendar = Calendar.getInstance(this.f12929l, this.f12930m);
        this.f12928k = calendar;
        calendar.set(1, ((c8 - '0') * 1000) + ((c9 - '0') * 100) + ((c10 - '0') * 10) + (c11 - '0'));
        this.f12928k.set(2, (((c12 - '0') * 10) + (c13 - '0')) - 1);
        this.f12928k.set(5, ((c14 - '0') * 10) + (c15 - '0'));
    }

    @Override // com.alibaba.fastjson.parser.e
    public String[] A2(char[] cArr, int i7, k kVar) {
        int i8;
        char cCharAt;
        int i9 = this.f12922e;
        char c8 = this.f12921d;
        while (e.b2(this.f12921d)) {
            next();
        }
        if (cArr != null) {
            this.f12931n = 0;
            if (!g(cArr)) {
                this.f12931n = -2;
                return null;
            }
            int length = this.f12922e + cArr.length;
            int i10 = length + 1;
            char cCharAt2 = this.f12937u.charAt(length);
            while (e.b2(cCharAt2)) {
                cCharAt2 = this.f12937u.charAt(i10);
                i10++;
            }
            if (cCharAt2 != ':') {
                this.f12931n = -1;
                return null;
            }
            i8 = i10 + 1;
            cCharAt = this.f12937u.charAt(i10);
            while (e.b2(cCharAt)) {
                cCharAt = this.f12937u.charAt(i8);
                i8++;
            }
        } else {
            i8 = this.f12922e + 1;
            cCharAt = this.f12921d;
        }
        if (cCharAt != '[') {
            if (cCharAt != 'n' || !this.f12937u.startsWith("ull", this.f12922e + 1)) {
                this.f12931n = -1;
                return null;
            }
            int i11 = this.f12922e + 4;
            this.f12922e = i11;
            this.f12921d = this.f12937u.charAt(i11);
            return null;
        }
        this.f12922e = i8;
        this.f12921d = this.f12937u.charAt(i8);
        String[] strArr = i7 >= 0 ? new String[i7] : new String[4];
        int i12 = 0;
        while (true) {
            if (e.b2(this.f12921d)) {
                next();
            } else {
                if (this.f12921d != '\"') {
                    this.f12922e = i9;
                    this.f12921d = c8;
                    this.f12931n = -1;
                    return null;
                }
                String strG0 = g0(kVar, h0.f35376b);
                if (i12 == strArr.length) {
                    String[] strArr2 = new String[strArr.length + (strArr.length >> 1) + 1];
                    System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                    strArr = strArr2;
                }
                int i13 = i12 + 1;
                strArr[i12] = strG0;
                while (e.b2(this.f12921d)) {
                    next();
                }
                if (this.f12921d != ',') {
                    if (strArr.length != i13) {
                        String[] strArr3 = new String[i13];
                        System.arraycopy(strArr, 0, strArr3, 0, i13);
                        strArr = strArr3;
                    }
                    while (e.b2(this.f12921d)) {
                        next();
                    }
                    if (this.f12921d == ']') {
                        next();
                        return strArr;
                    }
                    this.f12922e = i9;
                    this.f12921d = c8;
                    this.f12931n = -1;
                    return null;
                }
                next();
                i12 = i13;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.e
    public long B2(char[] cArr) {
        this.f12931n = 0;
        if (!P2(this.f12937u, this.f12922e, cArr)) {
            this.f12931n = -2;
            return 0L;
        }
        int length = this.f12922e + cArr.length;
        int i7 = length + 1;
        if (m(length) != '\"') {
            this.f12931n = -1;
            return 0L;
        }
        long j7 = -3750763034362895579L;
        while (true) {
            int i8 = i7 + 1;
            char cM = m(i7);
            if (cM == '\"') {
                this.f12922e = i8;
                char cM2 = m(i8);
                this.f12921d = cM2;
                while (cM2 != ',') {
                    if (cM2 == '}') {
                        next();
                        q1();
                        char cD1 = d1();
                        if (cD1 == ',') {
                            this.f12918a = 16;
                            int i9 = this.f12922e + 1;
                            this.f12922e = i9;
                            this.f12921d = m(i9);
                        } else if (cD1 == ']') {
                            this.f12918a = 15;
                            int i10 = this.f12922e + 1;
                            this.f12922e = i10;
                            this.f12921d = m(i10);
                        } else if (cD1 == '}') {
                            this.f12918a = 13;
                            int i11 = this.f12922e + 1;
                            this.f12922e = i11;
                            this.f12921d = m(i11);
                        } else {
                            if (cD1 != 26) {
                                this.f12931n = -1;
                                return 0L;
                            }
                            this.f12918a = 20;
                        }
                        this.f12931n = 4;
                        return j7;
                    }
                    if (!e.b2(cM2)) {
                        this.f12931n = -1;
                        return 0L;
                    }
                    int i12 = this.f12922e + 1;
                    this.f12922e = i12;
                    cM2 = m(i12);
                }
                int i13 = this.f12922e + 1;
                this.f12922e = i13;
                this.f12921d = m(i13);
                this.f12931n = 3;
                return j7;
            }
            if (i8 > this.f12938v) {
                this.f12931n = -1;
                return 0L;
            }
            j7 = (j7 ^ ((long) cM)) * 1099511628211L;
            i7 = i8;
        }
    }

    @Override // com.alibaba.fastjson.parser.e
    public final String N2(int i7, int i8) {
        if (!com.alibaba.fastjson.util.b.f13259b) {
            return this.f12937u.substring(i7, i8 + i7);
        }
        char[] cArr = this.f12924g;
        if (i8 < cArr.length) {
            this.f12937u.getChars(i7, i7 + i8, cArr, 0);
            return new String(this.f12924g, 0, i8);
        }
        char[] cArr2 = new char[i8];
        this.f12937u.getChars(i7, i8 + i7, cArr2, 0);
        return new String(cArr2);
    }

    @Override // com.alibaba.fastjson.parser.e
    public final char[] O2(int i7, int i8) {
        if (com.alibaba.fastjson.util.b.f13259b) {
            char[] cArr = this.f12924g;
            if (i8 < cArr.length) {
                this.f12937u.getChars(i7, i8 + i7, cArr, 0);
                return this.f12924g;
            }
        }
        char[] cArr2 = new char[i8];
        this.f12937u.getChars(i7, i8 + i7, cArr2, 0);
        return cArr2;
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public final String R1() {
        char cM = m((this.f12926i + this.f12925h) - 1);
        int i7 = this.f12925h;
        if (cM == 'L' || cM == 'S' || cM == 'B' || cM == 'F' || cM == 'D') {
            i7--;
        }
        return N2(this.f12926i, i7);
    }

    public boolean S2() {
        return T2(true);
    }

    public boolean T2(boolean z7) {
        return U2(z7, this.f12938v - this.f12922e);
    }

    protected void W2(char c8, char c9, char c10, char c11, char c12, char c13) {
        this.f12928k.set(11, ((c8 - '0') * 10) + (c9 - '0'));
        this.f12928k.set(12, ((c10 - '0') * 10) + (c11 - '0'));
        this.f12928k.set(13, ((c12 - '0') * 10) + (c13 - '0'));
    }

    protected void X2(char c8, char c9, char c10) {
        Y2(c8, c9, c10, '0', '0');
    }

    @Override // com.alibaba.fastjson.parser.e
    public final int Y1(char c8, int i7) {
        return this.f12937u.indexOf(c8, i7);
    }

    protected void Y2(char c8, char c9, char c10, char c11, char c12) {
        int i7 = ((((c9 - '0') * 10) + (c10 - '0')) * TimeUtils.f38737c * 1000) + ((((c11 - '0') * 10) + (c12 - '0')) * 60 * 1000);
        if (c8 == '-') {
            i7 = -i7;
        }
        if (this.f12928k.getTimeZone().getRawOffset() != i7) {
            String[] availableIDs = TimeZone.getAvailableIDs(i7);
            if (availableIDs.length > 0) {
                this.f12928k.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.e
    public boolean Z1() {
        int i7 = this.f12922e;
        int i8 = this.f12938v;
        if (i7 != i8) {
            return this.f12921d == 26 && i7 + 1 == i8;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00c0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00c4 -> B:52:0x00b4). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public double a1(char r22) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.g.a1(char):double");
    }

    @Override // com.alibaba.fastjson.parser.e
    public final String c(int i7, int i8, int i9, k kVar) {
        return kVar.a(this.f12937u, i7, i8, i9);
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.f12922e);
        sb.append(", json : ");
        sb.append(this.f12937u.length() < 65536 ? this.f12937u : this.f12937u.substring(0, 65536));
        return sb.toString();
    }

    @Override // com.alibaba.fastjson.parser.e
    public boolean e2(char[] cArr) {
        while (e.b2(this.f12921d)) {
            next();
        }
        if (!g(cArr)) {
            this.f12931n = -2;
            return false;
        }
        int length = this.f12922e + cArr.length;
        int i7 = length + 1;
        char cCharAt = this.f12937u.charAt(length);
        while (e.b2(cCharAt)) {
            cCharAt = this.f12937u.charAt(i7);
            i7++;
        }
        if (cCharAt != ':') {
            this.f12931n = -2;
            return false;
        }
        this.f12922e = i7;
        this.f12921d = m(i7);
        return true;
    }

    @Override // com.alibaba.fastjson.parser.e
    protected final void f(int i7, char[] cArr, int i8, int i9) {
        this.f12937u.getChars(i7, i9 + i7, cArr, i8);
    }

    @Override // com.alibaba.fastjson.parser.e
    public final boolean g(char[] cArr) {
        return P2(this.f12937u, this.f12922e, cArr);
    }

    @Override // com.alibaba.fastjson.parser.e
    public Collection<String> g2(Class<?> cls) {
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception e8) {
            throw new com.alibaba.fastjson.d(e8.getMessage(), e8);
        }
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public final BigDecimal h0() {
        char cM = m((this.f12926i + this.f12925h) - 1);
        int i7 = this.f12925h;
        if (cM == 'L' || cM == 'S' || cM == 'B' || cM == 'F' || cM == 'D') {
            i7--;
        }
        int i8 = this.f12926i;
        char[] cArr = this.f12924g;
        if (i7 < cArr.length) {
            this.f12937u.getChars(i8, i8 + i7, cArr, 0);
            return new BigDecimal(this.f12924g, 0, i7);
        }
        char[] cArr2 = new char[i7];
        this.f12937u.getChars(i8, i7 + i8, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public final int l0(char c8) {
        int i7;
        char cM;
        this.f12931n = 0;
        int i8 = this.f12922e;
        int i9 = i8 + 1;
        char cM2 = m(i8);
        while (e.b2(cM2)) {
            int i10 = i9 + 1;
            char cM3 = m(i9);
            i9 = i10;
            cM2 = cM3;
        }
        boolean z7 = cM2 == '\"';
        if (z7) {
            int i11 = i9 + 1;
            char cM4 = m(i9);
            i9 = i11;
            cM2 = cM4;
        }
        boolean z8 = cM2 == '-';
        if (z8) {
            int i12 = i9 + 1;
            char cM5 = m(i9);
            i9 = i12;
            cM2 = cM5;
        }
        if (cM2 >= '0' && cM2 <= '9') {
            int i13 = cM2 - '0';
            while (true) {
                i7 = i9 + 1;
                cM = m(i9);
                if (cM < '0' || cM > '9') {
                    break;
                }
                i13 = (i13 * 10) + (cM - '0');
                i9 = i7;
            }
            if (cM == '.') {
                this.f12931n = -1;
                return 0;
            }
            if (z7) {
                if (cM != '\"') {
                    this.f12931n = -1;
                    return 0;
                }
                char cM6 = m(i7);
                i7++;
                cM = cM6;
            }
            if (i13 < 0) {
                this.f12931n = -1;
                return 0;
            }
            while (cM != c8) {
                if (!e.b2(cM)) {
                    this.f12931n = -1;
                    return z8 ? -i13 : i13;
                }
                cM = m(i7);
                i7++;
            }
            this.f12922e = i7;
            this.f12921d = m(i7);
            this.f12931n = 3;
            this.f12918a = 16;
            return z8 ? -i13 : i13;
        }
        if (cM2 == 'n') {
            int i14 = i9 + 1;
            if (m(i9) == 'u') {
                int i15 = i14 + 1;
                if (m(i14) == 'l') {
                    int i16 = i15 + 1;
                    if (m(i15) == 'l') {
                        this.f12931n = 5;
                        int i17 = i16 + 1;
                        char cM7 = m(i16);
                        if (z7 && cM7 == '\"') {
                            int i18 = i17 + 1;
                            char cM8 = m(i17);
                            i17 = i18;
                            cM7 = cM8;
                        }
                        while (cM7 != ',') {
                            if (cM7 == ']') {
                                this.f12922e = i17;
                                this.f12921d = m(i17);
                                this.f12931n = 5;
                                this.f12918a = 15;
                                return 0;
                            }
                            if (!e.b2(cM7)) {
                                this.f12931n = -1;
                                return 0;
                            }
                            int i19 = i17 + 1;
                            char cM9 = m(i17);
                            i17 = i19;
                            cM7 = cM9;
                        }
                        this.f12922e = i17;
                        this.f12921d = m(i17);
                        this.f12931n = 5;
                        this.f12918a = 16;
                        return 0;
                    }
                }
            }
        }
        this.f12931n = -1;
        return 0;
    }

    @Override // com.alibaba.fastjson.parser.e
    public Date l2(char c8) {
        char cM;
        long j7;
        Date date;
        int i7;
        boolean z7 = false;
        this.f12931n = 0;
        int i8 = this.f12922e;
        char c9 = this.f12921d;
        int i9 = i8 + 1;
        char cM2 = m(i8);
        if (cM2 == '\"') {
            int iY1 = Y1(h0.f35376b, i9);
            if (iY1 == -1) {
                throw new com.alibaba.fastjson.d("unclosed str");
            }
            this.f12922e = i9;
            if (!U2(false, iY1 - i9)) {
                this.f12922e = i8;
                this.f12921d = c9;
                this.f12931n = -1;
                return null;
            }
            date = this.f12928k.getTime();
            cM = m(iY1 + 1);
            this.f12922e = i8;
            while (cM != ',' && cM != ']') {
                if (!e.b2(cM)) {
                    this.f12922e = i8;
                    this.f12921d = c9;
                    this.f12931n = -1;
                    return null;
                }
                iY1++;
                cM = m(iY1 + 1);
            }
            this.f12922e = iY1 + 1;
            this.f12921d = cM;
        } else {
            char c10 = '9';
            if (cM2 != '-' && (cM2 < '0' || cM2 > '9')) {
                if (cM2 == 'n') {
                    int i10 = i9 + 1;
                    if (m(i9) == 'u') {
                        int i11 = i10 + 1;
                        if (m(i10) == 'l') {
                            int i12 = i11 + 1;
                            if (m(i11) == 'l') {
                                cM = m(i12);
                                this.f12922e = i12;
                                date = null;
                            }
                        }
                    }
                }
                this.f12922e = i8;
                this.f12921d = c9;
                this.f12931n = -1;
                return null;
            }
            if (cM2 == '-') {
                cM2 = m(i9);
                i9++;
                z7 = true;
            }
            if (cM2 < '0' || cM2 > '9') {
                cM = cM2;
                j7 = 0;
            } else {
                j7 = cM2 - '0';
                while (true) {
                    i7 = i9 + 1;
                    cM = m(i9);
                    if (cM < '0' || cM > c10) {
                        break;
                    }
                    j7 = (j7 * 10) + ((long) (cM - '0'));
                    i9 = i7;
                    c10 = '9';
                }
                if (cM == ',' || cM == ']') {
                    this.f12922e = i7 - 1;
                }
            }
            if (j7 < 0) {
                this.f12922e = i8;
                this.f12921d = c9;
                this.f12931n = -1;
                return null;
            }
            if (z7) {
                j7 = -j7;
            }
            date = new Date(j7);
        }
        if (cM == ',') {
            int i13 = this.f12922e + 1;
            this.f12922e = i13;
            this.f12921d = m(i13);
            this.f12931n = 3;
            return date;
        }
        int i14 = this.f12922e + 1;
        this.f12922e = i14;
        char cM3 = m(i14);
        if (cM3 == ',') {
            this.f12918a = 16;
            int i15 = this.f12922e + 1;
            this.f12922e = i15;
            this.f12921d = m(i15);
        } else if (cM3 == ']') {
            this.f12918a = 15;
            int i16 = this.f12922e + 1;
            this.f12922e = i16;
            this.f12921d = m(i16);
        } else if (cM3 == '}') {
            this.f12918a = 13;
            int i17 = this.f12922e + 1;
            this.f12922e = i17;
            this.f12921d = m(i17);
        } else {
            if (cM3 != 26) {
                this.f12922e = i8;
                this.f12921d = c9;
                this.f12931n = -1;
                return null;
            }
            this.f12921d = (char) 26;
            this.f12918a = 20;
        }
        this.f12931n = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.e
    public final char m(int i7) {
        if (i7 >= this.f12938v) {
            return (char) 26;
        }
        return this.f12937u.charAt(i7);
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public final char next() {
        int i7 = this.f12922e + 1;
        this.f12922e = i7;
        char cCharAt = i7 >= this.f12938v ? (char) 26 : this.f12937u.charAt(i7);
        this.f12921d = cCharAt;
        return cCharAt;
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public byte[] o0() {
        if (this.f12918a != 26) {
            return com.alibaba.fastjson.util.f.d(this.f12937u, this.f12926i + 1, this.f12925h);
        }
        int i7 = this.f12926i + 1;
        int i8 = this.f12925h;
        if (i8 % 2 != 0) {
            throw new com.alibaba.fastjson.d("illegal state. " + i8);
        }
        int i9 = i8 / 2;
        byte[] bArr = new byte[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            int i11 = (i10 * 2) + i7;
            char cCharAt = this.f12937u.charAt(i11);
            char cCharAt2 = this.f12937u.charAt(i11 + 1);
            char c8 = '0';
            int i12 = cCharAt - (cCharAt <= '9' ? '0' : '7');
            if (cCharAt2 > '9') {
                c8 = '7';
            }
            bArr[i10] = (byte) ((i12 << 4) | (cCharAt2 - c8));
        }
        return bArr;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0166  */
    /* JADX WARN: Code duplicated, block: B:103:0x016c A[LOOP:0: B:78:0x00ed->B:103:0x016c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x0163 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x014b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0104  */
    /* JADX WARN: Code duplicated, block: B:86:0x0121  */
    /* JADX WARN: Code duplicated, block: B:89:0x0135 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x0147  */
    /* JADX WARN: Code duplicated, block: B:96:0x0153  */
    /* JADX WARN: Code duplicated, block: B:98:0x0159 A[LOOP:1: B:84:0x0111->B:98:0x0159, LOOP_END] */
    @Override // com.alibaba.fastjson.parser.e
    public boolean o2(char[] cArr) {
        char cM;
        boolean z7;
        char cM2;
        this.f12931n = 0;
        if (!P2(this.f12937u, this.f12922e, cArr)) {
            this.f12931n = -2;
            return false;
        }
        int i7 = this.f12922e;
        int length = cArr.length + i7;
        int i8 = length + 1;
        char cM3 = m(length);
        boolean z8 = cM3 == '\"';
        if (z8) {
            int i9 = i8 + 1;
            char cM4 = m(i8);
            i8 = i9;
            cM3 = cM4;
        }
        if (cM3 != 't') {
            if (cM3 == 'f') {
                int i10 = i8 + 1;
                if (m(i8) != 'a') {
                    this.f12931n = -1;
                    return false;
                }
                int i11 = i10 + 1;
                if (m(i10) != 'l') {
                    this.f12931n = -1;
                    return false;
                }
                int i12 = i11 + 1;
                if (m(i11) != 's') {
                    this.f12931n = -1;
                    return false;
                }
                int i13 = i12 + 1;
                if (m(i12) != 'e') {
                    this.f12931n = -1;
                    return false;
                }
                if (z8) {
                    int i14 = i13 + 1;
                    if (m(i13) != '\"') {
                        this.f12931n = -1;
                        return false;
                    }
                    i13 = i14;
                }
                this.f12922e = i13;
                cM = m(i13);
            } else if (cM3 == '1') {
                if (z8) {
                    int i15 = i8 + 1;
                    if (m(i8) != '\"') {
                        this.f12931n = -1;
                        return false;
                    }
                    i8 = i15;
                }
                this.f12922e = i8;
                cM = m(i8);
            } else {
                if (cM3 != '0') {
                    this.f12931n = -1;
                    return false;
                }
                if (z8) {
                    int i16 = i8 + 1;
                    if (m(i8) != '\"') {
                        this.f12931n = -1;
                        return false;
                    }
                    i8 = i16;
                }
                this.f12922e = i8;
                cM = m(i8);
            }
            z7 = false;
            while (cM != ',') {
                if (cM == '}') {
                    int i17 = this.f12922e + 1;
                    this.f12922e = i17;
                    cM2 = m(i17);
                    while (cM2 != ',') {
                        if (cM2 == ']') {
                            this.f12918a = 15;
                            int i18 = this.f12922e + 1;
                            this.f12922e = i18;
                            this.f12921d = m(i18);
                        } else if (cM2 == '}') {
                            this.f12918a = 13;
                            int i19 = this.f12922e + 1;
                            this.f12922e = i19;
                            this.f12921d = m(i19);
                        } else if (cM2 == 26) {
                            this.f12918a = 20;
                        } else {
                            if (e.b2(cM2)) {
                                this.f12931n = -1;
                                return false;
                            }
                            int i20 = this.f12922e + 1;
                            this.f12922e = i20;
                            cM2 = m(i20);
                        }
                        this.f12931n = 4;
                        return z7;
                    }
                    this.f12918a = 16;
                    int i21 = this.f12922e + 1;
                    this.f12922e = i21;
                    this.f12921d = m(i21);
                    this.f12931n = 4;
                    return z7;
                }
                if (e.b2(cM)) {
                    this.f12922e = i7;
                    m(i7);
                    this.f12931n = -1;
                    return false;
                }
                int i22 = this.f12922e + 1;
                this.f12922e = i22;
                cM = m(i22);
            }
            int i23 = this.f12922e + 1;
            this.f12922e = i23;
            this.f12921d = m(i23);
            this.f12931n = 3;
            this.f12918a = 16;
            return z7;
        }
        int i24 = i8 + 1;
        if (m(i8) != 'r') {
            this.f12931n = -1;
            return false;
        }
        int i25 = i24 + 1;
        if (m(i24) != 'u') {
            this.f12931n = -1;
            return false;
        }
        int i26 = i25 + 1;
        if (m(i25) != 'e') {
            this.f12931n = -1;
            return false;
        }
        if (z8) {
            int i27 = i26 + 1;
            if (m(i26) != '\"') {
                this.f12931n = -1;
                return false;
            }
            i26 = i27;
        }
        this.f12922e = i26;
        cM = m(i26);
        z7 = true;
        while (cM != ',') {
            if (cM == '}') {
                int i110 = this.f12922e + 1;
                this.f12922e = i110;
                cM2 = m(i110);
                while (cM2 != ',') {
                    if (cM2 == ']') {
                        this.f12918a = 15;
                        int i111 = this.f12922e + 1;
                        this.f12922e = i111;
                        this.f12921d = m(i111);
                    } else if (cM2 == '}') {
                        this.f12918a = 13;
                        int i112 = this.f12922e + 1;
                        this.f12922e = i112;
                        this.f12921d = m(i112);
                    } else if (cM2 == 26) {
                        this.f12918a = 20;
                    } else {
                        if (e.b2(cM2)) {
                            this.f12931n = -1;
                            return false;
                        }
                        int i28 = this.f12922e + 1;
                        this.f12922e = i28;
                        cM2 = m(i28);
                    }
                    this.f12931n = 4;
                    return z7;
                }
                this.f12918a = 16;
                int i29 = this.f12922e + 1;
                this.f12922e = i29;
                this.f12921d = m(i29);
                this.f12931n = 4;
                return z7;
            }
            if (e.b2(cM)) {
                this.f12922e = i7;
                m(i7);
                this.f12931n = -1;
                return false;
            }
            int i210 = this.f12922e + 1;
            this.f12922e = i210;
            cM = m(i210);
        }
        int i211 = this.f12922e + 1;
        this.f12922e = i211;
        this.f12921d = m(i211);
        this.f12931n = 3;
        this.f12918a = 16;
        return z7;
    }

    @Override // com.alibaba.fastjson.parser.e
    public Date p2(char[] cArr) {
        char cM;
        long j7;
        char cM2;
        Date date;
        int i7;
        boolean z7 = false;
        this.f12931n = 0;
        int i8 = this.f12922e;
        char c8 = this.f12921d;
        if (!P2(this.f12937u, i8, cArr)) {
            this.f12931n = -2;
            return null;
        }
        int length = this.f12922e + cArr.length;
        int i9 = length + 1;
        char cM3 = m(length);
        if (cM3 == '\"') {
            int iY1 = Y1(h0.f35376b, i9);
            if (iY1 == -1) {
                throw new com.alibaba.fastjson.d("unclosed str");
            }
            this.f12922e = i9;
            if (!U2(false, iY1 - i9)) {
                this.f12922e = i8;
                this.f12931n = -1;
                return null;
            }
            date = this.f12928k.getTime();
            cM2 = m(iY1 + 1);
            this.f12922e = i8;
            while (cM2 != ',' && cM2 != '}') {
                if (!e.b2(cM2)) {
                    this.f12931n = -1;
                    return null;
                }
                iY1++;
                cM2 = m(iY1 + 1);
            }
            this.f12922e = iY1 + 1;
            this.f12921d = cM2;
        } else {
            char c9 = '9';
            char c10 = '0';
            if (cM3 != '-' && (cM3 < '0' || cM3 > '9')) {
                this.f12931n = -1;
                return null;
            }
            if (cM3 == '-') {
                cM3 = m(i9);
                i9++;
                z7 = true;
            }
            if (cM3 < '0' || cM3 > '9') {
                cM = cM3;
                j7 = 0;
            } else {
                j7 = cM3 - '0';
                while (true) {
                    i7 = i9 + 1;
                    cM = m(i9);
                    if (cM < c10 || cM > c9) {
                        break;
                    }
                    j7 = (j7 * 10) + ((long) (cM - '0'));
                    i9 = i7;
                    c9 = '9';
                    c10 = '0';
                }
                if (cM == ',' || cM == '}') {
                    this.f12922e = i7 - 1;
                }
            }
            if (j7 < 0) {
                this.f12931n = -1;
                return null;
            }
            if (z7) {
                j7 = -j7;
            }
            cM2 = cM;
            date = new Date(j7);
        }
        if (cM2 == ',') {
            int i10 = this.f12922e + 1;
            this.f12922e = i10;
            this.f12921d = m(i10);
            this.f12931n = 3;
            this.f12918a = 16;
            return date;
        }
        int i11 = this.f12922e + 1;
        this.f12922e = i11;
        char cM4 = m(i11);
        if (cM4 == ',') {
            this.f12918a = 16;
            int i12 = this.f12922e + 1;
            this.f12922e = i12;
            this.f12921d = m(i12);
        } else if (cM4 == ']') {
            this.f12918a = 15;
            int i13 = this.f12922e + 1;
            this.f12922e = i13;
            this.f12921d = m(i13);
        } else if (cM4 == '}') {
            this.f12918a = 13;
            int i14 = this.f12922e + 1;
            this.f12922e = i14;
            this.f12921d = m(i14);
        } else {
            if (cM4 != 26) {
                this.f12922e = i8;
                this.f12921d = c8;
                this.f12931n = -1;
                return null;
            }
            this.f12918a = 20;
        }
        this.f12931n = 4;
        return date;
    }

    @Override // com.alibaba.fastjson.parser.e
    protected final void s(int i7, int i8, char[] cArr) {
        this.f12937u.getChars(i7, i8 + i7, cArr, 0);
    }

    @Override // com.alibaba.fastjson.parser.e
    public int v2(char[] cArr) {
        int i7;
        char cM;
        this.f12931n = 0;
        int i8 = this.f12922e;
        char c8 = this.f12921d;
        if (!P2(this.f12937u, i8, cArr)) {
            this.f12931n = -2;
            return 0;
        }
        int length = this.f12922e + cArr.length;
        int i9 = length + 1;
        char cM2 = m(length);
        boolean z7 = cM2 == '\"';
        if (z7) {
            cM2 = m(i9);
            i9++;
        }
        boolean z8 = cM2 == '-';
        if (z8) {
            cM2 = m(i9);
            i9++;
        }
        if (cM2 < '0' || cM2 > '9') {
            this.f12931n = -1;
            return 0;
        }
        int i10 = cM2 - '0';
        while (true) {
            i7 = i9 + 1;
            cM = m(i9);
            if (cM < '0' || cM > '9') {
                break;
            }
            i10 = (i10 * 10) + (cM - '0');
            i9 = i7;
        }
        if (cM == '.') {
            this.f12931n = -1;
            return 0;
        }
        if (i10 < 0) {
            this.f12931n = -1;
            return 0;
        }
        if (z7) {
            if (cM != '\"') {
                this.f12931n = -1;
                return 0;
            }
            int i11 = i7 + 1;
            char cM3 = m(i7);
            i7 = i11;
            cM = cM3;
        }
        while (cM != ',' && cM != '}') {
            if (!e.b2(cM)) {
                this.f12931n = -1;
                return 0;
            }
            int i12 = i7 + 1;
            char cM4 = m(i7);
            i7 = i12;
            cM = cM4;
        }
        int i13 = i7 - 1;
        this.f12922e = i13;
        if (cM == ',') {
            int i14 = i13 + 1;
            this.f12922e = i14;
            this.f12921d = m(i14);
            this.f12931n = 3;
            this.f12918a = 16;
            return z8 ? -i10 : i10;
        }
        if (cM == '}') {
            int i15 = i13 + 1;
            this.f12922e = i15;
            char cM5 = m(i15);
            while (true) {
                if (cM5 == ',') {
                    this.f12918a = 16;
                    int i16 = this.f12922e + 1;
                    this.f12922e = i16;
                    this.f12921d = m(i16);
                    break;
                }
                if (cM5 == ']') {
                    this.f12918a = 15;
                    int i17 = this.f12922e + 1;
                    this.f12922e = i17;
                    this.f12921d = m(i17);
                    break;
                }
                if (cM5 == '}') {
                    this.f12918a = 13;
                    int i18 = this.f12922e + 1;
                    this.f12922e = i18;
                    this.f12921d = m(i18);
                    break;
                }
                if (cM5 == 26) {
                    this.f12918a = 20;
                    break;
                }
                if (!e.b2(cM5)) {
                    this.f12922e = i8;
                    this.f12921d = c8;
                    this.f12931n = -1;
                    return 0;
                }
                int i19 = this.f12922e + 1;
                this.f12922e = i19;
                cM5 = m(i19);
            }
            this.f12931n = 4;
        }
        return z8 ? -i10 : i10;
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public long w1(char c8) {
        int i7;
        char cM;
        boolean z7 = false;
        this.f12931n = 0;
        int i8 = this.f12922e;
        int i9 = i8 + 1;
        char cM2 = m(i8);
        boolean z8 = cM2 == '\"';
        if (z8) {
            int i10 = i9 + 1;
            char cM3 = m(i9);
            i9 = i10;
            cM2 = cM3;
        }
        boolean z9 = cM2 == '-';
        if (z9) {
            int i11 = i9 + 1;
            char cM4 = m(i9);
            i9 = i11;
            cM2 = cM4;
        }
        char c9 = '0';
        if (cM2 >= '0' && cM2 <= '9') {
            long j7 = cM2 - '0';
            while (true) {
                i7 = i9 + 1;
                cM = m(i9);
                if (cM < c9 || cM > '9') {
                    break;
                }
                j7 = (j7 * 10) + ((long) (cM - '0'));
                i9 = i7;
                c9 = '0';
            }
            if (cM == '.') {
                this.f12931n = -1;
                return 0L;
            }
            if (z8) {
                if (cM != '\"') {
                    this.f12931n = -1;
                    return 0L;
                }
                cM = m(i7);
                i7++;
            }
            if (j7 >= 0 || (j7 == Long.MIN_VALUE && z9)) {
                z7 = true;
            }
            if (!z7) {
                this.f12931n = -1;
                return 0L;
            }
            while (cM != c8) {
                if (!e.b2(cM)) {
                    this.f12931n = -1;
                    return j7;
                }
                cM = m(i7);
                i7++;
            }
            this.f12922e = i7;
            this.f12921d = m(i7);
            this.f12931n = 3;
            this.f12918a = 16;
            return z9 ? -j7 : j7;
        }
        if (cM2 == 'n') {
            int i12 = i9 + 1;
            if (m(i9) == 'u') {
                int i13 = i12 + 1;
                if (m(i12) == 'l') {
                    int i14 = i13 + 1;
                    if (m(i13) == 'l') {
                        this.f12931n = 5;
                        int i15 = i14 + 1;
                        char cM5 = m(i14);
                        if (z8 && cM5 == '\"') {
                            int i16 = i15 + 1;
                            char cM6 = m(i15);
                            i15 = i16;
                            cM5 = cM6;
                        }
                        while (cM5 != ',') {
                            if (cM5 == ']') {
                                this.f12922e = i15;
                                this.f12921d = m(i15);
                                this.f12931n = 5;
                                this.f12918a = 15;
                                return 0L;
                            }
                            if (!e.b2(cM5)) {
                                this.f12931n = -1;
                                return 0L;
                            }
                            int i17 = i15 + 1;
                            char cM7 = m(i15);
                            i15 = i17;
                            cM5 = cM7;
                        }
                        this.f12922e = i15;
                        this.f12921d = m(i15);
                        this.f12931n = 5;
                        this.f12918a = 16;
                        return 0L;
                    }
                }
            }
        }
        this.f12931n = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.e, com.alibaba.fastjson.parser.d
    public final String x0() {
        return !this.f12927j ? N2(this.f12926i + 1, this.f12925h) : new String(this.f12924g, 0, this.f12925h);
    }

    @Override // com.alibaba.fastjson.parser.e
    public long x2(char[] cArr) {
        boolean z7;
        int i7;
        char cM;
        this.f12931n = 0;
        int i8 = this.f12922e;
        char c8 = this.f12921d;
        if (!P2(this.f12937u, i8, cArr)) {
            this.f12931n = -2;
            return 0L;
        }
        int length = this.f12922e + cArr.length;
        int i9 = length + 1;
        char cM2 = m(length);
        boolean z8 = cM2 == '\"';
        if (z8) {
            cM2 = m(i9);
            i9++;
        }
        if (cM2 == '-') {
            z7 = true;
            cM2 = m(i9);
            i9++;
        } else {
            z7 = false;
        }
        if (cM2 >= '0') {
            char c9 = '9';
            if (cM2 <= '9') {
                long j7 = cM2 - '0';
                while (true) {
                    i7 = i9 + 1;
                    cM = m(i9);
                    if (cM < '0' || cM > c9) {
                        break;
                    }
                    j7 = (j7 * 10) + ((long) (cM - '0'));
                    i9 = i7;
                    c9 = '9';
                }
                if (cM == '.') {
                    this.f12931n = -1;
                    return 0L;
                }
                if (z8) {
                    if (cM != '\"') {
                        this.f12931n = -1;
                        return 0L;
                    }
                    int i10 = i7 + 1;
                    char cM3 = m(i7);
                    i7 = i10;
                    cM = cM3;
                }
                if (cM == ',' || cM == '}') {
                    this.f12922e = i7 - 1;
                }
                if (!(j7 >= 0 || (j7 == Long.MIN_VALUE && z7))) {
                    this.f12922e = i8;
                    this.f12921d = c8;
                    this.f12931n = -1;
                    return 0L;
                }
                while (cM != ',') {
                    if (cM == '}') {
                        int i11 = this.f12922e + 1;
                        this.f12922e = i11;
                        char cM4 = m(i11);
                        while (true) {
                            if (cM4 == ',') {
                                this.f12918a = 16;
                                int i12 = this.f12922e + 1;
                                this.f12922e = i12;
                                this.f12921d = m(i12);
                                break;
                            }
                            if (cM4 == ']') {
                                this.f12918a = 15;
                                int i13 = this.f12922e + 1;
                                this.f12922e = i13;
                                this.f12921d = m(i13);
                                break;
                            }
                            if (cM4 == '}') {
                                this.f12918a = 13;
                                int i14 = this.f12922e + 1;
                                this.f12922e = i14;
                                this.f12921d = m(i14);
                                break;
                            }
                            if (cM4 == 26) {
                                this.f12918a = 20;
                                break;
                            }
                            if (!e.b2(cM4)) {
                                this.f12922e = i8;
                                this.f12921d = c8;
                                this.f12931n = -1;
                                return 0L;
                            }
                            int i15 = this.f12922e + 1;
                            this.f12922e = i15;
                            cM4 = m(i15);
                        }
                        this.f12931n = 4;
                        return z7 ? -j7 : j7;
                    }
                    if (!e.b2(cM)) {
                        this.f12931n = -1;
                        return 0L;
                    }
                    this.f12922e = i7;
                    int i16 = i7 + 1;
                    char cM5 = m(i7);
                    i7 = i16;
                    cM = cM5;
                }
                int i17 = this.f12922e + 1;
                this.f12922e = i17;
                this.f12921d = m(i17);
                this.f12931n = 3;
                this.f12918a = 16;
                return z7 ? -j7 : j7;
            }
        }
        this.f12922e = i8;
        this.f12921d = c8;
        this.f12931n = -1;
        return 0L;
    }

    @Override // com.alibaba.fastjson.parser.e
    public String y2(char[] cArr) {
        this.f12931n = 0;
        int i7 = this.f12922e;
        char c8 = this.f12921d;
        while (!P2(this.f12937u, this.f12922e, cArr)) {
            if (!e.b2(this.f12921d)) {
                this.f12931n = -2;
                return M2();
            }
            next();
        }
        int length = this.f12922e + cArr.length;
        int i8 = length + 1;
        if (m(length) != '\"') {
            this.f12931n = -1;
            return M2();
        }
        int iY1 = Y1(h0.f35376b, i8);
        if (iY1 == -1) {
            throw new com.alibaba.fastjson.d("unclosed str");
        }
        String strN2 = N2(i8, iY1 - i8);
        if (strN2.indexOf(92) != -1) {
            while (true) {
                int i9 = 0;
                for (int i10 = iY1 - 1; i10 >= 0 && m(i10) == '\\'; i10--) {
                    i9++;
                }
                if (i9 % 2 == 0) {
                    break;
                }
                iY1 = Y1(h0.f35376b, iY1 + 1);
            }
            int i11 = this.f12922e;
            int length2 = iY1 - ((cArr.length + i11) + 1);
            strN2 = e.k2(O2(i11 + cArr.length + 1, length2), length2);
        }
        char cM = m(iY1 + 1);
        while (cM != ',' && cM != '}') {
            if (!e.b2(cM)) {
                this.f12931n = -1;
                return M2();
            }
            iY1++;
            cM = m(iY1 + 1);
        }
        int i12 = iY1 + 1;
        this.f12922e = i12;
        this.f12921d = cM;
        if (cM == ',') {
            int i13 = i12 + 1;
            this.f12922e = i13;
            this.f12921d = m(i13);
            this.f12931n = 3;
            return strN2;
        }
        int i14 = i12 + 1;
        this.f12922e = i14;
        char cM2 = m(i14);
        if (cM2 == ',') {
            this.f12918a = 16;
            int i15 = this.f12922e + 1;
            this.f12922e = i15;
            this.f12921d = m(i15);
        } else if (cM2 == ']') {
            this.f12918a = 15;
            int i16 = this.f12922e + 1;
            this.f12922e = i16;
            this.f12921d = m(i16);
        } else if (cM2 == '}') {
            this.f12918a = 13;
            int i17 = this.f12922e + 1;
            this.f12922e = i17;
            this.f12921d = m(i17);
        } else {
            if (cM2 != 26) {
                this.f12922e = i7;
                this.f12921d = c8;
                this.f12931n = -1;
                return M2();
            }
            this.f12918a = 20;
        }
        this.f12931n = 4;
        return strN2;
    }

    @Override // com.alibaba.fastjson.parser.e
    public Collection<String> z2(char[] cArr, Class<?> cls) {
        char cM;
        int i7;
        int i8;
        char cM2;
        int i9 = 0;
        this.f12931n = 0;
        if (!P2(this.f12937u, this.f12922e, cArr)) {
            this.f12931n = -2;
            return null;
        }
        Collection<String> collectionG2 = g2(cls);
        int length = this.f12922e + cArr.length;
        int i10 = length + 1;
        if (m(length) == '[') {
            int i11 = i10 + 1;
            char cM3 = m(i10);
            while (true) {
                if (cM3 == '\"') {
                    int iY1 = Y1(h0.f35376b, i11);
                    if (iY1 == -1) {
                        throw new com.alibaba.fastjson.d("unclosed str");
                    }
                    String strN2 = N2(i11, iY1 - i11);
                    if (strN2.indexOf(92) != -1) {
                        while (true) {
                            int i12 = i9;
                            for (int i13 = iY1 - 1; i13 >= 0 && m(i13) == '\\'; i13--) {
                                i12++;
                            }
                            if (i12 % 2 == 0) {
                                break;
                            }
                            iY1 = Y1(h0.f35376b, iY1 + 1);
                            i9 = 0;
                        }
                        int i14 = iY1 - i11;
                        strN2 = e.k2(O2(i11, i14), i14);
                    }
                    int i15 = iY1 + 1;
                    i8 = i15 + 1;
                    cM2 = m(i15);
                    collectionG2.add(strN2);
                } else {
                    if (cM3 != 'n' || !this.f12937u.startsWith("ull", i11)) {
                        if (cM3 != ']' || collectionG2.size() != 0) {
                            this.f12931n = -1;
                            return null;
                        }
                        i7 = i11 + 1;
                        cM = m(i11);
                        break;
                    }
                    int i16 = i11 + 3;
                    i8 = i16 + 1;
                    cM2 = m(i16);
                    collectionG2.add(null);
                }
                if (cM2 != ',') {
                    if (cM2 != ']') {
                        this.f12931n = -1;
                        return null;
                    }
                    i7 = i8 + 1;
                    cM = m(i8);
                    while (e.b2(cM)) {
                        cM = m(i7);
                        i7++;
                    }
                    break;
                }
                i11 = i8 + 1;
                cM3 = m(i8);
                i9 = 0;
            }
        } else {
            if (!this.f12937u.startsWith("ull", i10)) {
                this.f12931n = -1;
                return null;
            }
            int i17 = i10 + 3;
            collectionG2 = null;
            cM = m(i17);
            i7 = i17 + 1;
        }
        this.f12922e = i7;
        if (cM == ',') {
            this.f12921d = m(i7);
            this.f12931n = 3;
            return collectionG2;
        }
        if (cM != '}') {
            this.f12931n = -1;
            return null;
        }
        char cM4 = m(i7);
        while (cM4 != ',') {
            if (cM4 == ']') {
                this.f12918a = 15;
                int i18 = this.f12922e + 1;
                this.f12922e = i18;
                this.f12921d = m(i18);
            } else if (cM4 == '}') {
                this.f12918a = 13;
                int i19 = this.f12922e + 1;
                this.f12922e = i19;
                this.f12921d = m(i19);
            } else if (cM4 == 26) {
                this.f12918a = 20;
                this.f12921d = cM4;
            } else {
                boolean z7 = false;
                while (e.b2(cM4)) {
                    int i20 = i7 + 1;
                    char cM5 = m(i7);
                    this.f12922e = i20;
                    z7 = true;
                    cM4 = cM5;
                    i7 = i20;
                }
                if (!z7) {
                    this.f12931n = -1;
                    return null;
                }
            }
            this.f12931n = 4;
            return collectionG2;
        }
        this.f12918a = 16;
        int i21 = this.f12922e + 1;
        this.f12922e = i21;
        this.f12921d = m(i21);
        this.f12931n = 4;
        return collectionG2;
    }

    public g(String str, int i7) {
        super(i7);
        this.f12937u = str;
        this.f12938v = str.length();
        this.f12922e = -1;
        next();
        if (this.f12921d == 65279) {
            next();
        }
    }

    public g(char[] cArr, int i7) {
        this(cArr, i7, com.alibaba.fastjson.a.f12532f);
    }

    public g(char[] cArr, int i7, int i8) {
        this(new String(cArr, 0, i7), i8);
    }
}
