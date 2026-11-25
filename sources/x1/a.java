package x1;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.text.h0;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f40571a = "UTC";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TimeZone f40572b = TimeZone.getTimeZone(f40571a);

    private static boolean a(String str, int i7, char c8) {
        return i7 < str.length() && str.charAt(i7) == c8;
    }

    public static String b(Date date) {
        return d(date, false, f40572b);
    }

    public static String c(Date date, boolean z7) {
        return d(date, z7, f40572b);
    }

    public static String d(Date date, boolean z7, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z7 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        f(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        f(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        f(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        f(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        f(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        f(sb, gregorianCalendar.get(13), 2);
        if (z7) {
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            f(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i7 = offset / 60000;
            int iAbs = Math.abs(i7 / 60);
            int iAbs2 = Math.abs(i7 % 60);
            sb.append(offset >= 0 ? '+' : '-');
            f(sb, iAbs, 2);
            sb.append(':');
            f(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    private static int e(String str, int i7) {
        while (i7 < str.length()) {
            char cCharAt = str.charAt(i7);
            if (cCharAt < '0' || cCharAt > '9') {
                return i7;
            }
            i7++;
        }
        return str.length();
    }

    private static void f(StringBuilder sb, int i7, int i8) {
        String string = Integer.toString(i7);
        for (int length = i8 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00cf A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d6 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x00db  */
    /* JADX WARN: Code duplicated, block: B:59:0x0106  */
    /* JADX WARN: Code duplicated, block: B:60:0x0107 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0181 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x01b4 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:60:0x0107, please report this as an issue */
    public static Date g(String str, ParsePosition parsePosition) throws ParseException {
        String str2;
        int i7;
        int i8;
        int i9;
        int iH;
        char cCharAt;
        String strSubstring;
        int length;
        TimeZone timeZone;
        char cCharAt2;
        try {
            int index = parsePosition.getIndex();
            int i10 = index + 4;
            int iH2 = h(str, index, i10);
            if (a(str, i10, '-')) {
                i10++;
            }
            int i11 = i10 + 2;
            int iH3 = h(str, i10, i11);
            if (a(str, i11, '-')) {
                i11++;
            }
            int i12 = i11 + 2;
            int iH4 = h(str, i11, i12);
            boolean zA = a(str, i12, 'T');
            if (!zA && str.length() <= i12) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(iH2, iH3 - 1, iH4);
                parsePosition.setIndex(i12);
                return gregorianCalendar.getTime();
            }
            if (zA) {
                int i13 = i12 + 1;
                int i14 = i13 + 2;
                int iH5 = h(str, i13, i14);
                if (a(str, i14, ':')) {
                    i14++;
                }
                int i15 = i14 + 2;
                int iH6 = h(str, i14, i15);
                if (a(str, i15, ':')) {
                    i15++;
                }
                if (str.length() <= i15 || (cCharAt2 = str.charAt(i15)) == 'Z' || cCharAt2 == '+' || cCharAt2 == '-') {
                    i8 = iH6;
                    i9 = 0;
                    i7 = iH5;
                    i12 = i15;
                } else {
                    int i16 = i15 + 2;
                    iH = h(str, i15, i16);
                    if (iH > 59 && iH < 63) {
                        iH = 59;
                    }
                    if (a(str, i16, ClassUtils.PACKAGE_SEPARATOR_CHAR)) {
                        int i17 = i16 + 1;
                        int iE = e(str, i17 + 1);
                        int iMin = Math.min(iE, i17 + 3);
                        int iH7 = h(str, i17, iMin);
                        int i18 = iMin - i17;
                        if (i18 == 1) {
                            iH7 *= 100;
                        } else if (i18 == 2) {
                            iH7 *= 10;
                        }
                        i8 = iH6;
                        i9 = iH7;
                        i7 = iH5;
                        i12 = iE;
                    } else {
                        i8 = iH6;
                        i7 = iH5;
                        i12 = i16;
                        i9 = 0;
                    }
                }
                if (str.length() > i12) {
                    throw new IllegalArgumentException("No time zone indicator");
                }
                cCharAt = str.charAt(i12);
                if (cCharAt == 'Z') {
                    timeZone = f40572b;
                    length = i12 + 1;
                } else {
                    if (cCharAt != '+' && cCharAt != '-') {
                        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                    }
                    strSubstring = str.substring(i12);
                    if (strSubstring.length() >= 5) {
                        strSubstring = strSubstring + "00";
                    }
                    length = i12 + strSubstring.length();
                    if (!"+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                        timeZone = f40572b;
                    } else {
                        String str3 = "GMT" + strSubstring;
                        TimeZone timeZone2 = TimeZone.getTimeZone(str3);
                        String id = timeZone2.getID();
                        if (!id.equals(str3) && !id.replace(":", "").equals(str3)) {
                            throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str3 + " given, resolves to " + timeZone2.getID());
                        }
                        timeZone = timeZone2;
                    }
                }
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
                gregorianCalendar2.setLenient(false);
                gregorianCalendar2.set(1, iH2);
                gregorianCalendar2.set(2, iH3 - 1);
                gregorianCalendar2.set(5, iH4);
                gregorianCalendar2.set(11, i7);
                gregorianCalendar2.set(12, i8);
                gregorianCalendar2.set(13, iH);
                gregorianCalendar2.set(14, i9);
                parsePosition.setIndex(length);
                return gregorianCalendar2.getTime();
            }
            i7 = 0;
            i8 = 0;
            i9 = 0;
            iH = 0;
            if (str.length() > i12) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            cCharAt = str.charAt(i12);
            if (cCharAt == 'Z') {
                timeZone = f40572b;
                length = i12 + 1;
            } else {
                if (cCharAt != '+') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt + "'");
                }
                strSubstring = str.substring(i12);
                if (strSubstring.length() >= 5) {
                    strSubstring = strSubstring + "00";
                }
                length = i12 + strSubstring.length();
                if ("+0000".equals(strSubstring)) {
                    timeZone = f40572b;
                } else {
                    timeZone = f40572b;
                }
            }
            GregorianCalendar gregorianCalendar3 = new GregorianCalendar(timeZone);
            gregorianCalendar3.setLenient(false);
            gregorianCalendar3.set(1, iH2);
            gregorianCalendar3.set(2, iH3 - 1);
            gregorianCalendar3.set(5, iH4);
            gregorianCalendar3.set(11, i7);
            gregorianCalendar3.set(12, i8);
            gregorianCalendar3.set(13, iH);
            gregorianCalendar3.set(14, i9);
            parsePosition.setIndex(length);
            return gregorianCalendar3.getTime();
        } catch (IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException e8) {
            if (str == null) {
                str2 = null;
            } else {
                str2 = h0.f35376b + str + h0.f35376b;
            }
            String message = e8.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e8.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException("Failed to parse date [" + str2 + "]: " + message, parsePosition.getIndex());
            parseException.initCause(e8);
            throw parseException;
        }
    }

    private static int h(String str, int i7, int i8) throws NumberFormatException {
        int i9;
        int i10;
        if (i7 < 0 || i8 > str.length() || i7 > i8) {
            throw new NumberFormatException(str);
        }
        if (i7 < i8) {
            i10 = i7 + 1;
            int iDigit = Character.digit(str.charAt(i7), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i7, i8));
            }
            i9 = -iDigit;
        } else {
            i9 = 0;
            i10 = i7;
        }
        while (i10 < i8) {
            int i11 = i10 + 1;
            int iDigit2 = Character.digit(str.charAt(i10), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i7, i8));
            }
            i9 = (i9 * 10) - iDigit2;
            i10 = i11;
        }
        return -i9;
    }
}
