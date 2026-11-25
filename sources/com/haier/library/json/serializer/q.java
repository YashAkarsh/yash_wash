package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements h3.f, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f26852a = new q();

    private q() {
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.text.DateFormat, java.text.SimpleDateFormat] */
    @Override // h3.f
    public <T> T a(com.haier.library.json.parser.b bVar, Type type, Object obj) {
        Object objG;
        if (type == StackTraceElement.class) {
            return (T) c(bVar);
        }
        com.haier.library.json.parser.e eVar = bVar.f26664e;
        if (bVar.f26669j == 2) {
            bVar.f26669j = 0;
            bVar.b(16);
            if (eVar.d0() != 4) {
                throw new com.haier.library.json.d("syntax error");
            }
            if (!"val".equals(eVar.a0())) {
                throw new com.haier.library.json.d("syntax error");
            }
            eVar.x();
            bVar.b(17);
            objG = bVar.G();
            bVar.b(13);
        } else {
            objG = bVar.G();
        }
        if (objG == null) {
            return null;
        }
        if (!(objG instanceof String)) {
            throw new com.haier.library.json.d("except string value");
        }
        String str = (String) objG;
        if (str.length() == 0) {
            return null;
        }
        if (type == UUID.class) {
            return (T) UUID.fromString(str);
        }
        if (type == Class.class) {
            return (T) i3.d.C(str, bVar.f26661b.f26771c);
        }
        if (type == Locale.class) {
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length == 1) {
                return (T) new Locale(strArrSplit[0]);
            }
            return strArrSplit.length == 2 ? (T) new Locale(strArrSplit[0], strArrSplit[1]) : (T) new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        }
        if (type == URI.class) {
            return (T) URI.create(str);
        }
        if (type == URL.class) {
            try {
                return (T) new URL(str);
            } catch (MalformedURLException e8) {
                throw new com.haier.library.json.d("create url error", e8);
            }
        }
        if (type == Pattern.class) {
            return (T) Pattern.compile(str);
        }
        if (type == Charset.class) {
            return (T) Charset.forName(str);
        }
        if (type == Currency.class) {
            return (T) Currency.getInstance(str);
        }
        if (type != SimpleDateFormat.class) {
            return (type == Character.TYPE || type == Character.class) ? (T) i3.d.i(str) : (T) TimeZone.getTimeZone(str);
        }
        ?? r7 = (T) new SimpleDateFormat(str, bVar.f26664e.f26709e);
        r7.setTimeZone(bVar.f26664e.f26708d);
        return r7;
    }

    @Override // com.haier.library.json.serializer.t
    public void b(m mVar, Object obj, Object obj2, Type type) throws IOException {
        z zVar = mVar.f26832b;
        if (obj == null) {
            if (type == Character.TYPE || type == Character.class) {
                mVar.z("");
                return;
            } else if ((zVar.f26874c & a0.WriteNullListAsEmpty.f26811a) == 0 || !Enumeration.class.isAssignableFrom(i3.d.v(type))) {
                zVar.H();
                return;
            } else {
                zVar.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            }
        }
        if (obj instanceof Pattern) {
            mVar.z(((Pattern) obj).pattern());
            return;
        }
        if (obj instanceof TimeZone) {
            mVar.z(((TimeZone) obj).getID());
            return;
        }
        if (obj instanceof Currency) {
            mVar.z(((Currency) obj).getCurrencyCode());
            return;
        }
        if (obj instanceof Class) {
            mVar.z(((Class) obj).getName());
            return;
        }
        if (obj instanceof Character) {
            Character ch = (Character) obj;
            if (ch.charValue() == 0) {
                mVar.z("\u0000");
                return;
            } else {
                mVar.z(ch.toString());
                return;
            }
        }
        int i7 = 0;
        if (obj instanceof SimpleDateFormat) {
            String pattern = ((SimpleDateFormat) obj).toPattern();
            if ((zVar.f26874c & a0.WriteClassName.f26811a) == 0 || obj.getClass() == type) {
                zVar.K(pattern);
                return;
            }
            zVar.write(123);
            zVar.v(com.haier.library.json.a.f26646c, false);
            mVar.z(obj.getClass().getName());
            zVar.write(44);
            zVar.v("val", false);
            zVar.K(pattern);
            zVar.write(125);
            return;
        }
        if (obj instanceof com.haier.library.json.f) {
            ((com.haier.library.json.f) obj).a(zVar);
            return;
        }
        if (obj instanceof com.haier.library.json.c) {
            zVar.write(((com.haier.library.json.c) obj).k());
            return;
        }
        if (obj instanceof l) {
            ((l) obj).a(mVar, obj2, type);
            return;
        }
        if (!(obj instanceof Enumeration)) {
            mVar.z(obj.toString());
            return;
        }
        Type type2 = ((zVar.f26874c & a0.WriteClassName.f26811a) == 0 || !(type instanceof ParameterizedType)) ? null : ((ParameterizedType) type).getActualTypeArguments()[0];
        Enumeration enumeration = (Enumeration) obj;
        w wVar = mVar.f26843m;
        mVar.t(wVar, obj, obj2, 0);
        try {
            zVar.write(91);
            while (enumeration.hasMoreElements()) {
                Object objNextElement = enumeration.nextElement();
                int i8 = i7 + 1;
                if (i7 != 0) {
                    zVar.write(44);
                }
                if (objNextElement == null) {
                    zVar.H();
                } else {
                    mVar.f26831a.a(objNextElement.getClass()).b(mVar, objNextElement, Integer.valueOf(i8 - 1), type2);
                }
                i7 = i8;
            }
            zVar.write(93);
        } finally {
            mVar.f26843m = wVar;
        }
    }

    protected <T> T c(com.haier.library.json.parser.b bVar) {
        com.haier.library.json.parser.e eVar = bVar.f26664e;
        if (eVar.d0() == 8) {
            eVar.x();
            return null;
        }
        if (eVar.d0() != 12 && eVar.d0() != 16) {
            throw new com.haier.library.json.d("syntax error: " + com.haier.library.json.parser.f.a(eVar.d0()));
        }
        int iO = 0;
        String strA0 = null;
        String strA1 = null;
        String strA2 = null;
        while (true) {
            String strT = eVar.T(bVar.f26660a);
            if (strT == null) {
                if (eVar.d0() == 13) {
                    eVar.y(16);
                    break;
                }
                if (eVar.d0() != 16 || (eVar.f26707c & com.haier.library.json.parser.d.AllowArbitraryCommas.f26696a) == 0) {
                }
            }
            eVar.z(':');
            if ("className".equals(strT)) {
                if (eVar.d0() == 8) {
                    strA0 = null;
                } else {
                    if (eVar.d0() != 4) {
                        throw new com.haier.library.json.d("syntax error");
                    }
                    strA0 = eVar.a0();
                }
            } else if ("methodName".equals(strT)) {
                if (eVar.d0() == 8) {
                    strA1 = null;
                } else {
                    if (eVar.d0() != 4) {
                        throw new com.haier.library.json.d("syntax error");
                    }
                    strA1 = eVar.a0();
                }
            } else if ("fileName".equals(strT)) {
                if (eVar.d0() == 8) {
                    strA2 = null;
                } else {
                    if (eVar.d0() != 4) {
                        throw new com.haier.library.json.d("syntax error");
                    }
                    strA2 = eVar.a0();
                }
            } else if ("lineNumber".equals(strT)) {
                if (eVar.d0() == 8) {
                    iO = 0;
                } else {
                    if (eVar.d0() != 2) {
                        throw new com.haier.library.json.d("syntax error");
                    }
                    iO = eVar.o();
                }
            } else if ("nativeMethod".equals(strT)) {
                if (eVar.d0() != 8 && eVar.d0() != 6 && eVar.d0() != 7) {
                    throw new com.haier.library.json.d("syntax error");
                }
                eVar.y(16);
            } else {
                if (strT != com.haier.library.json.a.f26646c) {
                    throw new com.haier.library.json.d("syntax error : " + strT);
                }
                if (eVar.d0() == 4) {
                    String strA3 = eVar.a0();
                    if (!strA3.equals("java.lang.StackTraceElement")) {
                        throw new com.haier.library.json.d("syntax error : " + strA3);
                    }
                } else if (eVar.d0() != 8) {
                    throw new com.haier.library.json.d("syntax error");
                }
            }
            if (eVar.d0() == 13) {
                eVar.y(16);
                break;
            }
        }
        return (T) new StackTraceElement(strA0, strA1, strA2, iO);
    }
}
