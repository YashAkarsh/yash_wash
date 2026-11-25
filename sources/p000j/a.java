package p000j;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import c.m0;
import c.o0;
import com.facebook.share.internal.MessengerShareContentUtility;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f34194a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f34195b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f34196c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f34197d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f34198e = 32;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f34199f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f34200g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f34201h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f34202i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f34203j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f34204k = 32;

    private a() {
    }

    @m0
    public static String a(int i7) {
        if (i7 == 1) {
            return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
        }
        if (i7 == 2) {
            return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
        }
        if (i7 != 4) {
            return i7 != 8 ? "UNKNOWN" : "CAPABILITY_CAN_FILTER_KEY_EVENTS";
        }
        return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    }

    @m0
    public static String b(int i7) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (i7 > 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i7);
            i7 &= ~iNumberOfTrailingZeros;
            if (sb.length() > 1) {
                sb.append(", ");
            }
            if (iNumberOfTrailingZeros == 1) {
                sb.append("FEEDBACK_SPOKEN");
            } else if (iNumberOfTrailingZeros == 2) {
                sb.append("FEEDBACK_HAPTIC");
            } else if (iNumberOfTrailingZeros == 4) {
                sb.append("FEEDBACK_AUDIBLE");
            } else if (iNumberOfTrailingZeros == 8) {
                sb.append("FEEDBACK_VISUAL");
            } else if (iNumberOfTrailingZeros == 16) {
                sb.append("FEEDBACK_GENERIC");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @o0
    public static String c(int i7) {
        if (i7 == 1) {
            return MessengerShareContentUtility.PREVIEW_DEFAULT;
        }
        if (i7 == 2) {
            return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
        }
        if (i7 == 4) {
            return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
        }
        if (i7 == 8) {
            return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
        }
        if (i7 == 16) {
            return "FLAG_REPORT_VIEW_IDS";
        }
        if (i7 != 32) {
            return null;
        }
        return "FLAG_REQUEST_FILTER_KEY_EVENTS";
    }

    public static int d(@m0 AccessibilityServiceInfo accessibilityServiceInfo) {
        return accessibilityServiceInfo.getCapabilities();
    }

    @o0
    public static String e(@m0 AccessibilityServiceInfo accessibilityServiceInfo, @m0 PackageManager packageManager) {
        return accessibilityServiceInfo.loadDescription(packageManager);
    }
}
