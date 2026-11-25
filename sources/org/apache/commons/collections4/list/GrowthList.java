package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GrowthList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3620001881672L;

    public GrowthList() {
        super(new ArrayList());
    }

    public static <E> GrowthList<E> growthList(List<E> list) {
        return new GrowthList<>(list);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public void add(int i7, E e8) {
        int size = decorated().size();
        if (i7 > size) {
            decorated().addAll(Collections.nCopies(i7 - size, null));
        }
        decorated().add(i7, e8);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i7, Collection<? extends E> collection) {
        boolean z7;
        int size = decorated().size();
        if (i7 > size) {
            decorated().addAll(Collections.nCopies(i7 - size, null));
            z7 = true;
        } else {
            z7 = false;
        }
        return decorated().addAll(i7, collection) | z7;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E set(int i7, E e8) {
        int size = decorated().size();
        if (i7 >= size) {
            decorated().addAll(Collections.nCopies((i7 - size) + 1, null));
        }
        return decorated().set(i7, e8);
    }

    public GrowthList(int i7) {
        super(new ArrayList(i7));
    }

    protected GrowthList(List<E> list) {
        super(list);
    }
}
