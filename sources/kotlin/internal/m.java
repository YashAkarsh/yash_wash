package kotlin.internal;

import com.facebook.internal.NativeProtocol;
import kotlin.a0;
import kotlin.a1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.text.c0;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final l f34747a;

    /* JADX WARN: Code duplicated, block: B:34:0x00b7 A[Catch: ClassCastException -> 0x00bc, ClassNotFoundException -> 0x00f2, TRY_ENTER, TryCatch #4 {ClassCastException -> 0x00bc, blocks: (B:34:0x00b7, B:37:0x00be, B:38:0x00c3), top: B:64:0x00b5, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00be A[Catch: ClassCastException -> 0x00bc, ClassNotFoundException -> 0x00f2, TryCatch #4 {ClassCastException -> 0x00bc, blocks: (B:34:0x00b7, B:37:0x00be, B:38:0x00c3), top: B:64:0x00b5, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        l lVar;
        Object objNewInstance;
        int iC = c();
        if (iC >= 65544 || iC < 65536) {
            try {
                Object objNewInstance2 = e5.d.class.newInstance();
                l0.o(objNewInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        if (objNewInstance2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        lVar = (l) objNewInstance2;
                    } catch (ClassCastException e8) {
                        ClassLoader classLoader = objNewInstance2.getClass().getClassLoader();
                        ClassLoader classLoader2 = l.class.getClassLoader();
                        if (l0.g(classLoader, classLoader2)) {
                            throw e8;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e8);
                    }
                } catch (ClassNotFoundException unused) {
                    if (iC < 65543) {
                        try {
                            try {
                                objNewInstance = d5.a.class.newInstance();
                                l0.o(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                                try {
                                    if (objNewInstance == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                                    }
                                    lVar = (l) objNewInstance;
                                } catch (ClassCastException e9) {
                                    ClassLoader classLoader3 = objNewInstance.getClass().getClassLoader();
                                    ClassLoader classLoader4 = l.class.getClassLoader();
                                    if (l0.g(classLoader3, classLoader4)) {
                                        throw e9;
                                    }
                                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e9);
                                }
                            } catch (ClassNotFoundException unused2) {
                                Object objNewInstance3 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                                l0.o(objNewInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                                try {
                                    if (objNewInstance3 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                                    }
                                    lVar = (l) objNewInstance3;
                                } catch (ClassCastException e10) {
                                    ClassLoader classLoader5 = objNewInstance3.getClass().getClassLoader();
                                    ClassLoader classLoader6 = l.class.getClassLoader();
                                    if (l0.g(classLoader5, classLoader6)) {
                                        throw e10;
                                    }
                                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e10);
                                }
                            }
                        } catch (ClassNotFoundException unused3) {
                            lVar = new l();
                        }
                    } else {
                        objNewInstance = d5.a.class.newInstance();
                        l0.o(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
                        if (objNewInstance == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        lVar = (l) objNewInstance;
                    }
                }
            } catch (ClassNotFoundException unused4) {
                Object objNewInstance4 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                l0.o(objNewInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (objNewInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    lVar = (l) objNewInstance4;
                } catch (ClassCastException e11) {
                    ClassLoader classLoader7 = objNewInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = l.class.getClassLoader();
                    if (l0.g(classLoader7, classLoader8)) {
                        throw e11;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e11);
                }
            }
        } else if (iC < 65543 || iC < 65536) {
            objNewInstance = d5.a.class.newInstance();
            l0.o(objNewInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            if (objNewInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            lVar = (l) objNewInstance;
        } else {
            lVar = new l();
        }
        f34747a = lVar;
    }

    @g1(version = "1.2")
    @a1
    public static final boolean a(int i7, int i8, int i9) {
        return a0.f34441g.f(i7, i8, i9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @f
    private static final /* synthetic */ <T> T b(Object obj) throws ClassNotFoundException {
        try {
            l0.y(1, "T");
            return obj;
        } catch (ClassCastException e8) {
            ClassLoader classLoader = obj.getClass().getClassLoader();
            l0.y(4, "T");
            ClassLoader classLoader2 = Object.class.getClassLoader();
            if (l0.g(classLoader, classLoader2)) {
                throw e8;
            }
            throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e8);
        }
    }

    private static final int c() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        }
        int iQ3 = c0.q3(property, ClassUtils.PACKAGE_SEPARATOR_CHAR, 0, false, 6, null);
        if (iQ3 < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
            }
        }
        int i7 = iQ3 + 1;
        int iQ4 = c0.q3(property, ClassUtils.PACKAGE_SEPARATOR_CHAR, i7, false, 4, null);
        if (iQ4 < 0) {
            iQ4 = property.length();
        }
        String strSubstring = property.substring(0, iQ3);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = property.substring(i7, iQ4);
        l0.o(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
        } catch (NumberFormatException unused2) {
            return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        }
    }
}
