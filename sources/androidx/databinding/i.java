package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i<C, T, A> implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f7280f = "CallbackRegistry";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<C> f7281a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7282b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f7283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a<C, T, A> f7285e;

    public static abstract class a<C, T, A> {
        public abstract void a(C c8, T t7, int i7, A a8);
    }

    public i(a<C, T, A> aVar) {
        this.f7285e = aVar;
    }

    private boolean l(int i7) {
        int i8;
        if (i7 < 64) {
            return ((1 << i7) & this.f7282b) != 0;
        }
        long[] jArr = this.f7283c;
        if (jArr != null && (i8 = (i7 / 64) - 1) < jArr.length) {
            return ((1 << (i7 % 64)) & jArr[i8]) != 0;
        }
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void n(T t7, int i7, A a8, int i8, int i9, long j7) {
        long j8 = 1;
        while (i8 < i9) {
            if ((j7 & j8) == 0) {
                this.f7285e.a(this.f7281a.get(i8), t7, i7, a8);
            }
            j8 <<= 1;
            i8++;
        }
    }

    private void o(T t7, int i7, A a8) {
        n(t7, i7, a8, 0, Math.min(64, this.f7281a.size()), this.f7282b);
    }

    private void p(T t7, int i7, A a8) {
        int size = this.f7281a.size();
        long[] jArr = this.f7283c;
        int length = jArr == null ? -1 : jArr.length - 1;
        q(t7, i7, a8, length);
        n(t7, i7, a8, (length + 2) * 64, size, 0L);
    }

    private void q(T t7, int i7, A a8, int i8) {
        if (i8 < 0) {
            o(t7, i7, a8);
            return;
        }
        long j7 = this.f7283c[i8];
        int i9 = (i8 + 1) * 64;
        int iMin = Math.min(this.f7281a.size(), i9 + 64);
        q(t7, i7, a8, i8 - 1);
        n(t7, i7, a8, i9, iMin, j7);
    }

    private void s(int i7, long j7) {
        long j8 = Long.MIN_VALUE;
        for (int i8 = (i7 + 64) - 1; i8 >= i7; i8--) {
            if ((j7 & j8) != 0) {
                this.f7281a.remove(i8);
            }
            j8 >>>= 1;
        }
    }

    private void t(int i7) {
        if (i7 < 64) {
            this.f7282b = (1 << i7) | this.f7282b;
            return;
        }
        int i8 = (i7 / 64) - 1;
        long[] jArr = this.f7283c;
        if (jArr == null) {
            this.f7283c = new long[this.f7281a.size() / 64];
        } else if (jArr.length <= i8) {
            long[] jArr2 = new long[this.f7281a.size() / 64];
            long[] jArr3 = this.f7283c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f7283c = jArr2;
        }
        long j7 = 1 << (i7 % 64);
        long[] jArr4 = this.f7283c;
        jArr4[i8] = j7 | jArr4[i8];
    }

    public synchronized void a(C c8) {
        try {
            if (c8 == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            int iLastIndexOf = this.f7281a.lastIndexOf(c8);
            if (iLastIndexOf < 0 || l(iLastIndexOf)) {
                this.f7281a.add(c8);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void e() {
        if (this.f7284d == 0) {
            this.f7281a.clear();
        } else if (!this.f7281a.isEmpty()) {
            for (int size = this.f7281a.size() - 1; size >= 0; size--) {
                t(size);
            }
        }
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public synchronized i<C, T, A> clone() {
        i<C, T, A> iVar;
        CloneNotSupportedException e8;
        try {
            iVar = (i) super.clone();
            try {
                iVar.f7282b = 0L;
                iVar.f7283c = null;
                iVar.f7284d = 0;
                iVar.f7281a = new ArrayList();
                int size = this.f7281a.size();
                for (int i7 = 0; i7 < size; i7++) {
                    if (!l(i7)) {
                        iVar.f7281a.add(this.f7281a.get(i7));
                    }
                }
            } catch (CloneNotSupportedException e9) {
                e8 = e9;
                e8.printStackTrace();
            }
        } catch (CloneNotSupportedException e10) {
            iVar = null;
            e8 = e10;
        }
        return iVar;
    }

    public synchronized ArrayList<C> i() {
        ArrayList<C> arrayList;
        arrayList = new ArrayList<>(this.f7281a.size());
        int size = this.f7281a.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (!l(i7)) {
                arrayList.add(this.f7281a.get(i7));
            }
        }
        return arrayList;
    }

    public synchronized void j(List<C> list) {
        list.clear();
        int size = this.f7281a.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (!l(i7)) {
                list.add(this.f7281a.get(i7));
            }
        }
    }

    public synchronized boolean k() {
        if (this.f7281a.isEmpty()) {
            return true;
        }
        if (this.f7284d == 0) {
            return false;
        }
        int size = this.f7281a.size();
        for (int i7 = 0; i7 < size; i7++) {
            if (!l(i7)) {
                return false;
            }
        }
        return true;
    }

    public synchronized void m(T t7, int i7, A a8) {
        this.f7284d++;
        p(t7, i7, a8);
        int i8 = this.f7284d - 1;
        this.f7284d = i8;
        if (i8 == 0) {
            long[] jArr = this.f7283c;
            if (jArr != null) {
                for (int length = jArr.length - 1; length >= 0; length--) {
                    long j7 = this.f7283c[length];
                    if (j7 != 0) {
                        s((length + 1) * 64, j7);
                        this.f7283c[length] = 0;
                    }
                }
            }
            long j8 = this.f7282b;
            if (j8 != 0) {
                s(0, j8);
                this.f7282b = 0L;
            }
        }
    }

    public synchronized void r(C c8) {
        if (this.f7284d == 0) {
            this.f7281a.remove(c8);
        } else {
            int iLastIndexOf = this.f7281a.lastIndexOf(c8);
            if (iLastIndexOf >= 0) {
                t(iLastIndexOf);
            }
        }
    }
}
