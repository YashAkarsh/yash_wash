package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.l0;
import kotlin.l2;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f37869a = 253402300799999L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f37870b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f37871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DateFormat[] f37872d;

    public static final class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        @a7.d
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(okhttp3.internal.d.f37859f);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f37871c = strArr;
        f37872d = new DateFormat[strArr.length];
    }

    @a7.e
    public static final Date a(@a7.d String toHttpDateOrNull) {
        l0.p(toHttpDateOrNull, "$this$toHttpDateOrNull");
        if (toHttpDateOrNull.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = f37870b.get().parse(toHttpDateOrNull, parsePosition);
        if (parsePosition.getIndex() == toHttpDateOrNull.length()) {
            return date;
        }
        String[] strArr = f37871c;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i7 = 0; i7 < length; i7++) {
                DateFormat[] dateFormatArr = f37872d;
                DateFormat simpleDateFormat = dateFormatArr[i7];
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(f37871c[i7], Locale.US);
                    simpleDateFormat.setTimeZone(okhttp3.internal.d.f37859f);
                    dateFormatArr[i7] = simpleDateFormat;
                }
                parsePosition.setIndex(0);
                Date date2 = simpleDateFormat.parse(toHttpDateOrNull, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
            }
            l2 l2Var = l2.f34958a;
            return null;
        }
    }

    @a7.d
    public static final String b(@a7.d Date toHttpDateString) {
        l0.p(toHttpDateString, "$this$toHttpDateString");
        String str = f37870b.get().format(toHttpDateString);
        l0.o(str, "STANDARD_DATE_FORMAT.get().format(this)");
        return str;
    }
}
