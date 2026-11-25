package org.apache.commons.collections4.functors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;

/* JADX INFO: loaded from: classes3.dex */
public class PrototypeFactory {

    static class PrototypeCloneFactory<T> implements Factory<T> {
        private transient Method iCloneMethod;
        private final T iPrototype;

        private void findCloneMethod() {
            try {
                this.iCloneMethod = this.iPrototype.getClass().getMethod("clone", null);
            } catch (NoSuchMethodException unused) {
                throw new IllegalArgumentException("PrototypeCloneFactory: The clone method must exist and be public ");
            }
        }

        @Override // org.apache.commons.collections4.Factory
        public T create() {
            if (this.iCloneMethod == null) {
                findCloneMethod();
            }
            try {
                return (T) this.iCloneMethod.invoke(this.iPrototype, null);
            } catch (IllegalAccessException e8) {
                throw new FunctorException("PrototypeCloneFactory: Clone method must be public", e8);
            } catch (InvocationTargetException e9) {
                throw new FunctorException("PrototypeCloneFactory: Clone method threw an exception", e9);
            }
        }

        private PrototypeCloneFactory(T t7, Method method) {
            this.iPrototype = t7;
            this.iCloneMethod = method;
        }
    }

    static class PrototypeSerializationFactory<T extends Serializable> implements Factory<T> {
        private final T iPrototype;

        private PrototypeSerializationFactory(T t7) {
            this.iPrototype = t7;
        }

        /* JADX WARN: Code duplicated, block: B:36:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // org.apache.commons.collections4.Factory
        public T create() throws Throwable {
            Throwable th;
            ClassNotFoundException e8;
            IOException e9;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            ByteArrayInputStream byteArrayInputStream = null;
            try {
                try {
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(this.iPrototype);
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    try {
                        T t7 = (T) new ObjectInputStream(byteArrayInputStream2).readObject();
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException unused) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused2) {
                        }
                        return t7;
                    } catch (IOException e10) {
                        e9 = e10;
                        throw new FunctorException(e9);
                    } catch (ClassNotFoundException e11) {
                        e8 = e11;
                        throw new FunctorException(e8);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (IOException e12) {
                e9 = e12;
            } catch (ClassNotFoundException e13) {
                e8 = e13;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                    byteArrayInputStream.close();
                }
                byteArrayOutputStream.close();
                throw th;
            }
        }
    }

    private PrototypeFactory() {
    }

    public static <T> Factory<T> prototypeFactory(T t7) {
        if (t7 == null) {
            return ConstantFactory.constantFactory(null);
        }
        try {
            try {
                return new PrototypeCloneFactory(t7, t7.getClass().getMethod("clone", null));
            } catch (NoSuchMethodException unused) {
                t7.getClass().getConstructor(t7.getClass());
                return new InstantiateFactory(t7.getClass(), new Class[]{t7.getClass()}, new Object[]{t7});
            }
        } catch (NoSuchMethodException unused2) {
            if (t7 instanceof Serializable) {
                return new PrototypeSerializationFactory((Serializable) t7);
            }
            throw new IllegalArgumentException("The prototype must be cloneable via a public clone method");
        }
    }
}
