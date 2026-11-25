package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import c.b0;
import c.m0;
import c.o0;
import c.x0;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class n extends l implements Iterable<l> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final androidx.collection.j<l> f8892j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8893k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f8894l;

    class a implements Iterator<l> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8895a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f8896b = false;

        a() {
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public l next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f8896b = true;
            androidx.collection.j<l> jVar = n.this.f8892j;
            int i7 = this.f8895a + 1;
            this.f8895a = i7;
            return jVar.D(i7);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8895a + 1 < n.this.f8892j.C();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f8896b) {
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
            n.this.f8892j.D(this.f8895a).F(null);
            n.this.f8892j.x(this.f8895a);
            this.f8895a--;
            this.f8896b = false;
        }
    }

    public n(@m0 w<? extends n> wVar) {
        super(wVar);
        this.f8892j = new androidx.collection.j<>();
    }

    public final void H(@m0 n nVar) {
        Iterator<l> it = nVar.iterator();
        while (it.hasNext()) {
            l next = it.next();
            it.remove();
            I(next);
        }
    }

    public final void I(@m0 l lVar) {
        if (lVar.m() == 0) {
            throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
        }
        l lVarM = this.f8892j.m(lVar.m());
        if (lVarM == lVar) {
            return;
        }
        if (lVar.p() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (lVarM != null) {
            lVarM.F(null);
        }
        lVar.F(this);
        this.f8892j.s(lVar.m(), lVar);
    }

    public final void J(@m0 Collection<l> collection) {
        for (l lVar : collection) {
            if (lVar != null) {
                I(lVar);
            }
        }
    }

    public final void K(@m0 l... lVarArr) {
        for (l lVar : lVarArr) {
            if (lVar != null) {
                I(lVar);
            }
        }
    }

    @o0
    public final l L(@b0 int i7) {
        return M(i7, true);
    }

    @o0
    final l M(@b0 int i7, boolean z7) {
        l lVarM = this.f8892j.m(i7);
        if (lVarM != null) {
            return lVarM;
        }
        if (!z7 || p() == null) {
            return null;
        }
        return p().L(i7);
    }

    @m0
    String N() {
        if (this.f8894l == null) {
            this.f8894l = Integer.toString(this.f8893k);
        }
        return this.f8894l;
    }

    @b0
    public final int O() {
        return this.f8893k;
    }

    public final void P(@m0 l lVar) {
        int iO = this.f8892j.o(lVar.m());
        if (iO >= 0) {
            this.f8892j.D(iO).F(null);
            this.f8892j.x(iO);
        }
    }

    public final void Q(@b0 int i7) {
        this.f8893k = i7;
        this.f8894l = null;
    }

    public final void clear() {
        Iterator<l> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    @Override // java.lang.Iterable
    @m0
    public final Iterator<l> iterator() {
        return new a();
    }

    @Override // androidx.navigation.l
    @x0({x0.a.LIBRARY_GROUP})
    @m0
    public String k() {
        return m() != 0 ? super.k() : "the root navigation";
    }

    @Override // androidx.navigation.l
    @o0
    l.b t(@m0 k kVar) {
        l.b bVarT = super.t(kVar);
        Iterator<l> it = iterator();
        while (it.hasNext()) {
            l.b bVarT2 = it.next().t(kVar);
            if (bVarT2 != null && (bVarT == null || bVarT2.compareTo(bVarT) > 0)) {
                bVarT = bVarT2;
            }
        }
        return bVarT;
    }

    @Override // androidx.navigation.l
    @m0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        l lVarL = L(O());
        if (lVarL == null) {
            String str = this.f8894l;
            if (str == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.f8893k));
            } else {
                sb.append(str);
            }
        } else {
            sb.append("{");
            sb.append(lVarL.toString());
            sb.append(com.alipay.sdk.util.j.f13808d);
        }
        return sb.toString();
    }

    @Override // androidx.navigation.l
    public void u(@m0 Context context, @m0 AttributeSet attributeSet) {
        super.u(context, attributeSet);
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavGraphNavigator);
        Q(typedArrayObtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavGraphNavigator_startDestination, 0));
        this.f8894l = l.l(context, this.f8893k);
        typedArrayObtainAttributes.recycle();
    }
}
