package kotlinx.coroutines.channels;

import java.util.ArrayList;
import kotlin.l2;
import kotlinx.coroutines.internal.d1;
import kotlinx.coroutines.internal.r0;

/* JADX INFO: loaded from: classes2.dex */
public class d0<E> extends a<E> {
    public d0(@a7.e i5.l<? super E, l2> lVar) {
        super(lVar);
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean F() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean H() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.d
    protected Object J(E e8) {
        j0<?> j0VarO;
        do {
            Object objJ = super.J(e8);
            r0 r0Var = b.f35563d;
            if (objJ == r0Var) {
                return r0Var;
            }
            if (objJ != b.f35564e) {
                if (objJ instanceof w) {
                    return objJ;
                }
                throw new IllegalStateException(kotlin.jvm.internal.l0.C("Invalid offerInternal result ", objJ).toString());
            }
            j0VarO = O(e8);
            if (j0VarO == null) {
                return r0Var;
            }
        } while (!(j0VarO instanceof w));
        return j0VarO;
    }

    @Override // kotlinx.coroutines.channels.c
    @a7.d
    protected Object K(E e8, @a7.d kotlinx.coroutines.selects.f<?> fVar) {
        Object objE0;
        while (true) {
            if (e0()) {
                objE0 = super.K(e8, fVar);
            } else {
                objE0 = fVar.e0(i(e8));
                if (objE0 == null) {
                    objE0 = b.f35563d;
                }
            }
            if (objE0 == kotlinx.coroutines.selects.g.d()) {
                return kotlinx.coroutines.selects.g.d();
            }
            r0 r0Var = b.f35563d;
            if (objE0 == r0Var) {
                return r0Var;
            }
            if (objE0 != b.f35564e && objE0 != kotlinx.coroutines.internal.c.f36965b) {
                if (objE0 instanceof w) {
                    return objE0;
                }
                throw new IllegalStateException(kotlin.jvm.internal.l0.C("Invalid result ", objE0).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean f0() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean g0() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.a
    protected void j0(@a7.d Object obj, @a7.d w<?> wVar) {
        d1 d1VarC = null;
        if (obj != null) {
            if (obj instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    d1 d1VarC2 = null;
                    while (true) {
                        int i7 = size - 1;
                        l0 l0Var = (l0) arrayList.get(size);
                        if (l0Var instanceof c.a) {
                            i5.l<E, l2> lVar = this.f35570a;
                            d1VarC2 = lVar == null ? null : kotlinx.coroutines.internal.i0.c(lVar, ((c.a) l0Var).f35572d, d1VarC2);
                        } else {
                            l0Var.X0(wVar);
                        }
                        if (i7 < 0) {
                            break;
                        } else {
                            size = i7;
                        }
                    }
                    d1VarC = d1VarC2;
                }
            } else {
                l0 l0Var2 = (l0) obj;
                if (l0Var2 instanceof c.a) {
                    i5.l<E, l2> lVar2 = this.f35570a;
                    if (lVar2 != null) {
                        d1VarC = kotlinx.coroutines.internal.i0.c(lVar2, ((c.a) l0Var2).f35572d, null);
                    }
                } else {
                    l0Var2.X0(wVar);
                }
            }
        }
        if (d1VarC != null) {
            throw d1VarC;
        }
    }
}
