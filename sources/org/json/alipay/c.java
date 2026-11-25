package org.json.alipay;

import com.paytm.pgsdk.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.apache.commons.lang3.CharUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f39759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Reader f39760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private char f39761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f39762d;

    private c(Reader reader) {
        this.f39760b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.f39762d = false;
        this.f39759a = 0;
    }

    private String a(int i7) throws JSONException {
        if (i7 == 0) {
            return "";
        }
        char[] cArr = new char[i7];
        int i8 = 0;
        if (this.f39762d) {
            this.f39762d = false;
            cArr[0] = this.f39761c;
            i8 = 1;
        }
        while (i8 < i7) {
            try {
                int i9 = this.f39760b.read(cArr, i8, i7 - i8);
                if (i9 == -1) {
                    break;
                }
                i8 += i9;
            } catch (IOException e8) {
                throw new JSONException(e8);
            }
        }
        this.f39759a += i8;
        if (i8 < i7) {
            throw a("Substring bounds error");
        }
        this.f39761c = cArr[i7 - 1];
        return new String(cArr);
    }

    public final char b() throws JSONException {
        if (this.f39762d) {
            this.f39762d = false;
            char c8 = this.f39761c;
            if (c8 != 0) {
                this.f39759a++;
            }
            return c8;
        }
        try {
            int i7 = this.f39760b.read();
            if (i7 <= 0) {
                this.f39761c = (char) 0;
                return (char) 0;
            }
            this.f39759a++;
            char c9 = (char) i7;
            this.f39761c = c9;
            return c9;
        } catch (IOException e8) {
            throw new JSONException(e8);
        }
    }

    public final char c() {
        char cB;
        char cB2;
        while (true) {
            char cB3 = b();
            if (cB3 == '/') {
                char cB4 = b();
                if (cB4 == '*') {
                    while (true) {
                        char cB5 = b();
                        if (cB5 == 0) {
                            throw a("Unclosed comment");
                        }
                        if (cB5 == '*') {
                            if (b() == '/') {
                                break;
                            }
                            a();
                        }
                    }
                } else {
                    if (cB4 != '/') {
                        a();
                        return '/';
                    }
                    do {
                        cB = b();
                        if (cB == '\n' || cB == '\r') {
                            break;
                        }
                    } while (cB != 0);
                }
            } else if (cB3 == '#') {
                do {
                    cB2 = b();
                    if (cB2 == '\n' || cB2 == '\r') {
                        break;
                    }
                } while (cB2 != 0);
            } else if (cB3 == 0 || cB3 > ' ') {
                return cB3;
            }
        }
    }

    public final Object d() {
        String strA;
        char c8 = c();
        if (c8 != '\"') {
            if (c8 != '[') {
                if (c8 == '{') {
                    a();
                    return new b(this);
                }
                if (c8 != '\'') {
                    if (c8 != '(') {
                        StringBuffer stringBuffer = new StringBuffer();
                        char cB = c8;
                        while (cB >= ' ' && ",:]}/\\\"[{;=#".indexOf(cB) < 0) {
                            stringBuffer.append(cB);
                            cB = b();
                        }
                        a();
                        String strTrim = stringBuffer.toString().trim();
                        if (strTrim.equals("")) {
                            throw a("Missing value");
                        }
                        if (strTrim.equalsIgnoreCase("true")) {
                            return Boolean.TRUE;
                        }
                        if (strTrim.equalsIgnoreCase(d.G)) {
                            return Boolean.FALSE;
                        }
                        if (strTrim.equalsIgnoreCase("null")) {
                            return b.f39757a;
                        }
                        if ((c8 < '0' || c8 > '9') && c8 != '.' && c8 != '-' && c8 != '+') {
                            return strTrim;
                        }
                        if (c8 == '0') {
                            try {
                                return (strTrim.length() <= 2 || !(strTrim.charAt(1) == 'x' || strTrim.charAt(1) == 'X')) ? new Integer(Integer.parseInt(strTrim, 8)) : new Integer(Integer.parseInt(strTrim.substring(2), 16));
                            } catch (Exception unused) {
                            }
                        }
                        try {
                            try {
                                try {
                                    return new Integer(strTrim);
                                } catch (Exception unused2) {
                                    return new Double(strTrim);
                                }
                            } catch (Exception unused3) {
                                return new Long(strTrim);
                            }
                        } catch (Exception unused4) {
                            return strTrim;
                        }
                    }
                }
            }
            a();
            return new a(this);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        while (true) {
            char cB2 = b();
            if (cB2 == 0 || cB2 == '\n' || cB2 == '\r') {
                break;
            }
            if (cB2 == '\\') {
                cB2 = b();
                if (cB2 == 'b') {
                    stringBuffer2.append('\b');
                } else if (cB2 == 'f') {
                    cB2 = '\f';
                } else if (cB2 == 'n') {
                    stringBuffer2.append('\n');
                } else if (cB2 != 'r') {
                    if (cB2 == 'x') {
                        strA = a(2);
                    } else if (cB2 == 't') {
                        cB2 = '\t';
                    } else if (cB2 == 'u') {
                        strA = a(4);
                    }
                    cB2 = (char) Integer.parseInt(strA, 16);
                } else {
                    stringBuffer2.append(CharUtils.CR);
                }
            } else if (cB2 == c8) {
                return stringBuffer2.toString();
            }
            stringBuffer2.append(cB2);
        }
        throw a("Unterminated string");
    }

    public final String toString() {
        return " at character " + this.f39759a;
    }

    public c(String str) {
        this(new StringReader(str));
    }

    public final JSONException a(String str) {
        return new JSONException(str + toString());
    }

    public final void a() {
        int i7;
        if (this.f39762d || (i7 = this.f39759a) <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.f39759a = i7 - 1;
        this.f39762d = true;
    }
}
