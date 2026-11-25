package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Object> f34919a;

    public r1(int i7) {
        this.f34919a = new ArrayList<>(i7);
    }

    public void a(Object obj) {
        this.f34919a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f34919a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f34919a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f34919a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f34919a.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.f34919a.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.f34919a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f34919a.toArray(objArr);
    }
}
