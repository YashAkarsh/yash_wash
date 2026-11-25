package org.json.alipay;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.h0;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f39757a = new a(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f39758b;

    private static final class a {
        private a() {
        }

        protected final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public final String toString() {
            return "null";
        }

        /* synthetic */ a(byte b8) {
            this();
        }
    }

    public b() {
        this.f39758b = new HashMap();
    }

    private static void b(Object obj) throws JSONException {
        if (obj != null) {
            if (obj instanceof Double) {
                Double d8 = (Double) obj;
                if (d8.isInfinite() || d8.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
                return;
            }
            if (obj instanceof Float) {
                Float f8 = (Float) obj;
                if (f8.isInfinite() || f8.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0086  */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0034. Please report as an issue. */
    public static String c(String str) {
        String str2;
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length + 4);
        stringBuffer.append(h0.f35376b);
        int i7 = 0;
        char c8 = 0;
        while (i7 < length) {
            char cCharAt = str.charAt(i7);
            if (cCharAt == '\f') {
                str2 = "\\f";
            } else if (cCharAt != '\r') {
                if (cCharAt == '\"') {
                    stringBuffer.append('\\');
                } else if (cCharAt != '/') {
                    if (cCharAt != '\\') {
                        switch (cCharAt) {
                            case '\b':
                                str2 = "\\b";
                                break;
                            case '\t':
                                str2 = "\\t";
                                break;
                            case '\n':
                                str2 = "\\n";
                                break;
                            default:
                                if (cCharAt < ' ' || ((cCharAt >= 128 && cCharAt < 160) || (cCharAt >= 8192 && cCharAt < 8448))) {
                                    String str3 = "000" + Integer.toHexString(cCharAt);
                                    str2 = "\\u" + str3.substring(str3.length() - 4);
                                }
                                break;
                        }
                        i7++;
                        c8 = cCharAt;
                    } else {
                        stringBuffer.append('\\');
                    }
                } else if (c8 == '<') {
                    stringBuffer.append('\\');
                }
                stringBuffer.append(cCharAt);
                i7++;
                c8 = cCharAt;
            } else {
                str2 = "\\r";
            }
            stringBuffer.append(str2);
            i7++;
            c8 = cCharAt;
        }
        stringBuffer.append(h0.f35376b);
        return stringBuffer.toString();
    }

    public final Object a(String str) throws JSONException {
        Object obj = str == null ? null : this.f39758b.get(str);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONObject[" + c(str) + "] not found.");
    }

    public String toString() {
        try {
            Iterator itA = a();
            StringBuffer stringBuffer = new StringBuffer("{");
            while (itA.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = itA.next();
                stringBuffer.append(c(next.toString()));
                stringBuffer.append(':');
                stringBuffer.append(a(this.f39758b.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public b(String str) {
        this(new c(str));
    }

    static String a(Object obj) throws JSONException {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (!(obj instanceof Number)) {
            if ((obj instanceof Boolean) || (obj instanceof b) || (obj instanceof org.json.alipay.a)) {
                return obj.toString();
            }
            if (obj instanceof Map) {
                return new b((Map) obj).toString();
            }
            if (obj instanceof Collection) {
                return new org.json.alipay.a((Collection) obj).toString();
            }
            return obj.getClass().isArray() ? new org.json.alipay.a(obj).toString() : c(obj.toString());
        }
        Number number = (Number) obj;
        b(number);
        String string = number.toString();
        if (string.indexOf(46) <= 0 || string.indexOf(101) >= 0 || string.indexOf(69) >= 0) {
            return string;
        }
        while (string.endsWith("0")) {
            string = string.substring(0, string.length() - 1);
        }
        return string.endsWith(com.alibaba.android.arouter.utils.b.f12515h) ? string.substring(0, string.length() - 1) : string;
    }

    public final boolean b(String str) {
        return this.f39758b.containsKey(str);
    }

    public b(Map map) {
        this.f39758b = map == null ? new HashMap() : map;
    }

    public final Iterator a() {
        return this.f39758b.keySet().iterator();
    }

    public b(c cVar) throws JSONException {
        this();
        if (cVar.c() != '{') {
            throw cVar.a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char c8 = cVar.c();
            if (c8 == 0) {
                throw cVar.a("A JSONObject text must end with '}'");
            }
            if (c8 == '}') {
                return;
            }
            cVar.a();
            String string = cVar.d().toString();
            char c9 = cVar.c();
            if (c9 == '=') {
                if (cVar.b() != '>') {
                    cVar.a();
                }
            } else if (c9 != ':') {
                throw cVar.a("Expected a ':' after a key");
            }
            Object objD = cVar.d();
            if (string == null) {
                throw new JSONException("Null key.");
            }
            if (objD != null) {
                b(objD);
                this.f39758b.put(string, objD);
            } else {
                this.f39758b.remove(string);
            }
            char c10 = cVar.c();
            if (c10 != ',' && c10 != ';') {
                if (c10 != '}') {
                    throw cVar.a("Expected a ',' or '}'");
                }
                return;
            } else if (cVar.c() == '}') {
                return;
            } else {
                cVar.a();
            }
        }
    }
}
