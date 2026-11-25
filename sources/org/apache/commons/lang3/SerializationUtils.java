package org.apache.commons.lang3;

import androidx.constraintlayout.core.motion.utils.w;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class SerializationUtils {

    static class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        private static final Map<String, Class<?>> primitiveTypes = new HashMap();
        private final ClassLoader classLoader;

        public ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader) throws IOException {
            super(inputStream);
            this.classLoader = classLoader;
            Map<String, Class<?>> map = primitiveTypes;
            map.put("byte", Byte.TYPE);
            map.put("short", Short.TYPE);
            map.put("int", Integer.TYPE);
            map.put("long", Long.TYPE);
            map.put(w.b.f3028c, Float.TYPE);
            map.put("double", Double.TYPE);
            map.put(w.b.f3031f, Boolean.TYPE);
            map.put("char", Character.TYPE);
            map.put("void", Void.TYPE);
        }

        @Override // java.io.ObjectInputStream
        protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
            String name = objectStreamClass.getName();
            try {
                try {
                    return Class.forName(name, false, this.classLoader);
                } catch (ClassNotFoundException e8) {
                    Class<?> cls = primitiveTypes.get(name);
                    if (cls != null) {
                        return cls;
                    }
                    throw e8;
                }
            } catch (ClassNotFoundException unused) {
                return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
            }
        }
    }

    public static <T extends Serializable> T clone(T t7) throws Throwable {
        ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream = null;
        if (t7 == null) {
            return null;
        }
        try {
            try {
                ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream2 = new ClassLoaderAwareObjectInputStream(new ByteArrayInputStream(serialize(t7)), t7.getClass().getClassLoader());
                try {
                    T t8 = (T) classLoaderAwareObjectInputStream2.readObject();
                    try {
                        classLoaderAwareObjectInputStream2.close();
                        return t8;
                    } catch (IOException e8) {
                        throw new SerializationException("IOException on closing cloned object data InputStream.", e8);
                    }
                } catch (IOException e9) {
                    e = e9;
                    throw new SerializationException("IOException while reading cloned object data", e);
                } catch (ClassNotFoundException e10) {
                    e = e10;
                    throw new SerializationException("ClassNotFoundException while reading cloned object data", e);
                } catch (Throwable th) {
                    th = th;
                    classLoaderAwareObjectInputStream = classLoaderAwareObjectInputStream2;
                    if (classLoaderAwareObjectInputStream != null) {
                        try {
                            classLoaderAwareObjectInputStream.close();
                        } catch (IOException e11) {
                            throw new SerializationException("IOException on closing cloned object data InputStream.", e11);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e12) {
            e = e12;
        } catch (ClassNotFoundException e13) {
            e = e13;
        }
    }

    public static <T> T deserialize(InputStream inputStream) throws Throwable {
        if (inputStream == null) {
            throw new IllegalArgumentException("The InputStream must not be null");
        }
        ObjectInputStream objectInputStream = null;
        try {
            try {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(inputStream);
                try {
                    T t7 = (T) objectInputStream2.readObject();
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return t7;
                } catch (IOException e8) {
                    e = e8;
                    throw new SerializationException(e);
                } catch (ClassCastException e9) {
                    e = e9;
                    throw new SerializationException(e);
                } catch (ClassNotFoundException e10) {
                    e = e10;
                    throw new SerializationException(e);
                } catch (Throwable th) {
                    th = th;
                    objectInputStream = objectInputStream2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e11) {
            e = e11;
        } catch (ClassCastException e12) {
            e = e12;
        } catch (ClassNotFoundException e13) {
            e = e13;
        }
    }

    public static <T extends Serializable> T roundtrip(T t7) {
        return (T) deserialize(serialize(t7));
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) throws Throwable {
        if (outputStream == null) {
            throw new IllegalArgumentException("The OutputStream must not be null");
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(outputStream);
                try {
                    objectOutputStream2.writeObject(serializable);
                    try {
                        objectOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (IOException e8) {
                    e = e8;
                    objectOutputStream = objectOutputStream2;
                    throw new SerializationException(e);
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static byte[] serialize(Serializable serializable) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static <T> T deserialize(byte[] bArr) {
        if (bArr != null) {
            return (T) deserialize(new ByteArrayInputStream(bArr));
        }
        throw new IllegalArgumentException("The byte[] must not be null");
    }
}
