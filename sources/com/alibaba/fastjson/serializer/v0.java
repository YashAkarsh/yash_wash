package com.alibaba.fastjson.serializer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class v0 implements y0, com.alibaba.fastjson.parser.deserializer.e1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f13179c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v0 f13178b = new v0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f13180d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f13177a = "true".equals(com.alibaba.fastjson.util.f.l("fastjson.deserializer.fileRelativePathSupport"));

    /* JADX WARN: Type inference failed for: r11v39, types: [T, java.text.DateFormat, java.text.SimpleDateFormat] */
    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public <T> T b(com.alibaba.fastjson.parser.b bVar, Type type, Object obj) {
        Object objX0;
        String str;
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        InetAddress inetAddress = null;
        int i7 = 0;
        if (type != InetSocketAddress.class) {
            if (bVar.f12794k == 2) {
                bVar.f12794k = 0;
                bVar.b(16);
                if (dVar.L0() != 4) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
                if (!"val".equals(dVar.x0())) {
                    throw new com.alibaba.fastjson.d("syntax error");
                }
                dVar.E();
                bVar.b(17);
                objX0 = bVar.x0();
                bVar.b(13);
            } else {
                objX0 = bVar.x0();
            }
            if (objX0 == null) {
                str = null;
            } else {
                if (!(objX0 instanceof String)) {
                    if (!(objX0 instanceof com.alibaba.fastjson.e)) {
                        throw new com.alibaba.fastjson.d("expect string");
                    }
                    com.alibaba.fastjson.e eVar = (com.alibaba.fastjson.e) objX0;
                    if (type == Currency.class) {
                        String strY1 = eVar.y1("currency");
                        if (strY1 != null) {
                            return (T) Currency.getInstance(strY1);
                        }
                        String strY2 = eVar.y1("currencyCode");
                        if (strY2 != null) {
                            return (T) Currency.getInstance(strY2);
                        }
                    }
                    return type == Map.Entry.class ? (T) eVar.entrySet().iterator().next() : (T) eVar.N0(type);
                }
                str = (String) objX0;
            }
            if (str == null || str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return (T) UUID.fromString(str);
            }
            if (type == URI.class) {
                return (T) URI.create(str);
            }
            if (type == URL.class) {
                try {
                    return (T) new URL(str);
                } catch (MalformedURLException e8) {
                    throw new com.alibaba.fastjson.d("create url error", e8);
                }
            }
            if (type == Pattern.class) {
                return (T) Pattern.compile(str);
            }
            if (type == Locale.class) {
                return (T) com.alibaba.fastjson.util.l.q0(str);
            }
            if (type == SimpleDateFormat.class) {
                ?? r11 = (T) new SimpleDateFormat(str, dVar.getLocale());
                r11.setTimeZone(dVar.getTimeZone());
                return r11;
            }
            if (type == InetAddress.class || type == Inet4Address.class || type == Inet6Address.class) {
                try {
                    return (T) InetAddress.getByName(str);
                } catch (UnknownHostException e9) {
                    throw new com.alibaba.fastjson.d("deserialize inet adress error", e9);
                }
            }
            if (type == File.class) {
                if (str.indexOf("..") < 0 || f13177a) {
                    return (T) new File(str);
                }
                throw new com.alibaba.fastjson.d("file relative path not support.");
            }
            if (type == TimeZone.class) {
                return (T) TimeZone.getTimeZone(str);
            }
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            }
            if (type == Class.class) {
                return (T) com.alibaba.fastjson.util.l.o0(str, bVar.u().k(), false);
            }
            if (type == Charset.class) {
                return (T) Charset.forName(str);
            }
            if (type == Currency.class) {
                return (T) Currency.getInstance(str);
            }
            if (type == com.alibaba.fastjson.g.class) {
                return (T) new com.alibaba.fastjson.g(str);
            }
            if (!(type instanceof Class)) {
                throw new com.alibaba.fastjson.d("MiscCodec not support " + type.toString());
            }
            String name = ((Class) type).getName();
            if (name.equals("java.nio.file.Path")) {
                try {
                    if (f13179c == null && !f13180d) {
                        f13179c = com.alibaba.fastjson.util.l.m0("java.nio.file.Paths").getMethod("get", String.class, String[].class);
                    }
                    Method method = f13179c;
                    if (method != null) {
                        return (T) method.invoke(null, str, new String[0]);
                    }
                    throw new com.alibaba.fastjson.d("Path deserialize erorr");
                } catch (IllegalAccessException e10) {
                    throw new com.alibaba.fastjson.d("Path deserialize erorr", e10);
                } catch (NoSuchMethodException unused) {
                    f13180d = true;
                } catch (InvocationTargetException e11) {
                    throw new com.alibaba.fastjson.d("Path deserialize erorr", e11);
                }
            }
            throw new com.alibaba.fastjson.d("MiscCodec not support " + name);
        }
        if (dVar.L0() == 8) {
            dVar.E();
            return null;
        }
        bVar.b(12);
        while (true) {
            String strX0 = dVar.x0();
            dVar.Q(17);
            if (strX0.equals("address")) {
                bVar.b(17);
                inetAddress = (InetAddress) bVar.s1(InetAddress.class);
            } else if (strX0.equals("port")) {
                bVar.b(17);
                if (dVar.L0() != 2) {
                    throw new com.alibaba.fastjson.d("port is not int");
                }
                int iH = dVar.H();
                dVar.E();
                i7 = iH;
            } else {
                bVar.b(17);
                bVar.x0();
            }
            if (dVar.L0() != 16) {
                bVar.b(13);
                return (T) new InetSocketAddress(inetAddress, i7);
            }
            dVar.E();
        }
    }

    @Override // com.alibaba.fastjson.serializer.y0
    public void c(n0 n0Var, Object obj, Object obj2, Type type, int i7) throws IOException {
        String currencyCode;
        j1 j1Var = n0Var.f13143k;
        if (obj == null) {
            j1Var.X1();
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls == SimpleDateFormat.class) {
            currencyCode = ((SimpleDateFormat) obj).toPattern();
            if (j1Var.G(k1.WriteClassName) && obj.getClass() != type) {
                j1Var.write(123);
                j1Var.J0(com.alibaba.fastjson.a.f12529c);
                n0Var.T(obj.getClass().getName());
                j1Var.i1(',', "val", currencyCode);
                j1Var.write(125);
                return;
            }
        } else if (cls == Class.class) {
            currencyCode = ((Class) obj).getName();
        } else {
            if (cls == InetSocketAddress.class) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
                InetAddress address = inetSocketAddress.getAddress();
                j1Var.write(123);
                if (address != null) {
                    j1Var.J0("address");
                    n0Var.S(address);
                    j1Var.write(44);
                }
                j1Var.J0("port");
                j1Var.N1(inetSocketAddress.getPort());
                j1Var.write(125);
                return;
            }
            if (obj instanceof File) {
                currencyCode = ((File) obj).getPath();
            } else if (obj instanceof InetAddress) {
                currencyCode = ((InetAddress) obj).getHostAddress();
            } else if (obj instanceof TimeZone) {
                currencyCode = ((TimeZone) obj).getID();
            } else {
                if (!(obj instanceof Currency)) {
                    if (obj instanceof com.alibaba.fastjson.j) {
                        ((com.alibaba.fastjson.j) obj).a(j1Var);
                        return;
                    }
                    if (obj instanceof Iterator) {
                        f(n0Var, j1Var, (Iterator) obj);
                        return;
                    }
                    if (obj instanceof Iterable) {
                        f(n0Var, j1Var, ((Iterable) obj).iterator());
                        return;
                    }
                    if (!(obj instanceof Map.Entry)) {
                        if (obj.getClass().getName().equals("net.sf.json.JSONNull")) {
                            j1Var.X1();
                            return;
                        }
                        throw new com.alibaba.fastjson.d("not support class : " + cls);
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (key instanceof String) {
                        String str = (String) key;
                        if (value instanceof String) {
                            j1Var.z1('{', str, (String) value);
                        } else {
                            j1Var.write(123);
                            j1Var.J0(str);
                            n0Var.S(value);
                        }
                    } else {
                        j1Var.write(123);
                        n0Var.S(key);
                        j1Var.write(58);
                        n0Var.S(value);
                    }
                    j1Var.write(125);
                    return;
                }
                currencyCode = ((Currency) obj).getCurrencyCode();
            }
        }
        j1Var.a2(currencyCode);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.e1
    public int e() {
        return 4;
    }

    protected void f(n0 n0Var, j1 j1Var, Iterator<?> it) {
        j1Var.write(91);
        int i7 = 0;
        while (it.hasNext()) {
            if (i7 != 0) {
                j1Var.write(44);
            }
            n0Var.S(it.next());
            i7++;
        }
        j1Var.write(93);
    }
}
