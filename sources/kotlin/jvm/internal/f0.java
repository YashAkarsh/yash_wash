package kotlin.jvm.internal;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.k(level = kotlin.m.ERROR, message = "This class is no longer supported, do not use it.")
@Deprecated
public abstract class f0 implements kotlin.v, Serializable, i5.a, i5.l, i5.p, i5.q, i5.r, i5.s, i5.t, i5.u, i5.v, i5.w, i5.b, i5.c, i5.d, i5.e, i5.f, i5.g, i5.h, i5.i, i5.j, i5.k, i5.m, i5.n, i5.o {
    private void b(int i7) {
        if (getArity() != i7) {
            e(i7);
        }
    }

    private void e(int i7) {
        throw new IllegalStateException("Wrong function arity, expected: " + i7 + ", actual: " + getArity());
    }

    @Override // i5.k
    public Object B(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19) {
        b(19);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // i5.h
    public Object C(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16) {
        b(16);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // i5.r
    public Object K(Object obj, Object obj2, Object obj3, Object obj4) {
        b(4);
        return d(obj, obj2, obj3, obj4);
    }

    @Override // i5.v
    public Object M(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        b(8);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // i5.m
    public Object P(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20) {
        b(20);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // i5.o
    public Object S(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21, Object obj22) {
        b(22);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }

    @Override // i5.e
    public Object T(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13) {
        b(13);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // i5.t
    public Object W(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        b(6);
        return d(obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // i5.f
    public Object X(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14) {
        b(14);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // i5.i
    public Object Y(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17) {
        b(17);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // i5.p
    public Object a0(Object obj, Object obj2) {
        b(2);
        return d(obj, obj2);
    }

    @Override // i5.w
    public Object b0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
        b(9);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    public Object d(Object... objArr) {
        throw new UnsupportedOperationException();
    }

    @Override // i5.s
    public Object d0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        b(5);
        return d(obj, obj2, obj3, obj4, obj5);
    }

    @Override // i5.n
    public Object f0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18, Object obj19, Object obj20, Object obj21) {
        b(21);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    public abstract int getArity();

    @Override // i5.u
    public Object h0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        b(7);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // i5.a
    public Object invoke() {
        b(0);
        return d(new Object[0]);
    }

    @Override // i5.b
    public Object j0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        b(10);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // i5.c
    public Object l(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        b(11);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // i5.j
    public Object p(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15, Object obj16, Object obj17, Object obj18) {
        b(18);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // i5.g
    public Object p0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object obj13, Object obj14, Object obj15) {
        b(15);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // i5.q
    public Object v(Object obj, Object obj2, Object obj3) {
        b(3);
        return d(obj, obj2, obj3);
    }

    @Override // i5.d
    public Object y(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12) {
        b(12);
        return d(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // i5.l
    public Object z(Object obj) {
        b(1);
        return d(obj);
    }
}
