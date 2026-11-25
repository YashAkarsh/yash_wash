package g1;

import android.text.TextUtils;
import c.m0;
import c.o0;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@d0
@c1.a
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f34019a = Pattern.compile("\\\\.");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f34020b = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    private r() {
    }

    @c1.a
    public static boolean a(@o0 Object obj, @o0 Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = (JSONObject) obj2;
            if (jSONObject.length() != jSONObject2.length()) {
                return false;
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!jSONObject2.has(next)) {
                    return false;
                }
                try {
                    com.google.android.gms.common.internal.u.k(next);
                    if (!a(jSONObject.get(next), jSONObject2.get(next))) {
                        return false;
                    }
                } catch (JSONException unused) {
                }
            }
            return true;
        }
        if (!(obj instanceof JSONArray) || !(obj2 instanceof JSONArray)) {
            return obj.equals(obj2);
        }
        JSONArray jSONArray = (JSONArray) obj;
        JSONArray jSONArray2 = (JSONArray) obj2;
        if (jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        for (int i7 = 0; i7 < jSONArray.length(); i7++) {
            try {
                if (!a(jSONArray.get(i7), jSONArray2.get(i7))) {
                    return false;
                }
            } catch (JSONException unused2) {
            }
        }
        return true;
    }

    @o0
    @c1.a
    public static String b(@o0 String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = f34020b.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            char cCharAt = matcher.group().charAt(0);
            if (cCharAt == '\f') {
                matcher.appendReplacement(stringBuffer, "\\\\f");
            } else if (cCharAt == '\r') {
                matcher.appendReplacement(stringBuffer, "\\\\r");
            } else if (cCharAt == '\"') {
                matcher.appendReplacement(stringBuffer, "\\\\\\\"");
            } else if (cCharAt == '/') {
                matcher.appendReplacement(stringBuffer, "\\\\/");
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        matcher.appendReplacement(stringBuffer, "\\\\b");
                        break;
                    case '\t':
                        matcher.appendReplacement(stringBuffer, "\\\\t");
                        break;
                    case '\n':
                        matcher.appendReplacement(stringBuffer, "\\\\n");
                        break;
                }
            } else {
                matcher.appendReplacement(stringBuffer, "\\\\\\\\");
            }
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    @c1.a
    @m0
    public static String c(@m0 String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strA = h0.a(str);
        Matcher matcher = f34019a.matcher(strA);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            char cCharAt = matcher.group().charAt(1);
            if (cCharAt == '\"') {
                matcher.appendReplacement(stringBuffer, "\"");
            } else if (cCharAt == '/') {
                matcher.appendReplacement(stringBuffer, "/");
            } else if (cCharAt == '\\') {
                matcher.appendReplacement(stringBuffer, "\\\\");
            } else if (cCharAt == 'b') {
                matcher.appendReplacement(stringBuffer, "\b");
            } else if (cCharAt == 'f') {
                matcher.appendReplacement(stringBuffer, "\f");
            } else if (cCharAt == 'n') {
                matcher.appendReplacement(stringBuffer, "\n");
            } else if (cCharAt == 'r') {
                matcher.appendReplacement(stringBuffer, "\r");
            } else {
                if (cCharAt != 't') {
                    throw new IllegalStateException("Found an escaped character that should never be.");
                }
                matcher.appendReplacement(stringBuffer, "\t");
            }
        }
        if (stringBuffer == null) {
            return strA;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
