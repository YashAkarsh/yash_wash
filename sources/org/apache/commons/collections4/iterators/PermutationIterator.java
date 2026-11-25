package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public class PermutationIterator<E> implements Iterator<List<E>> {
    private boolean[] direction;
    private int[] keys;
    private List<E> nextPermutation;
    private Map<Integer, E> objectMap;

    public PermutationIterator(Collection<? extends E> collection) {
        if (collection == null) {
            throw new NullPointerException("The collection must not be null");
        }
        this.keys = new int[collection.size()];
        boolean[] zArr = new boolean[collection.size()];
        this.direction = zArr;
        Arrays.fill(zArr, false);
        this.objectMap = new HashMap();
        Iterator<? extends E> it = collection.iterator();
        int i7 = 1;
        while (it.hasNext()) {
            this.objectMap.put(Integer.valueOf(i7), it.next());
            this.keys[i7 - 1] = i7;
            i7++;
        }
        this.nextPermutation = new ArrayList(collection);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.nextPermutation != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }

    @Override // java.util.Iterator
    public List<E> next() {
        int[] iArr;
        int i7;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i8 = 0;
        int i9 = 0;
        int i10 = -1;
        int i11 = -1;
        while (true) {
            iArr = this.keys;
            if (i9 >= iArr.length) {
                break;
            }
            boolean z7 = this.direction[i9];
            if (((z7 && i9 < iArr.length - 1 && iArr[i9] > iArr[i9 + 1]) || (!z7 && i9 > 0 && iArr[i9] > iArr[i9 - 1])) && (i7 = iArr[i9]) > i10) {
                i11 = i9;
                i10 = i7;
            }
            i9++;
        }
        if (i10 == -1) {
            List<E> list = this.nextPermutation;
            this.nextPermutation = null;
            return list;
        }
        boolean[] zArr = this.direction;
        boolean z8 = zArr[i11];
        int i12 = z8 ? 1 : -1;
        int i13 = iArr[i11];
        int i14 = i12 + i11;
        iArr[i11] = iArr[i14];
        iArr[i14] = i13;
        zArr[i11] = zArr[i14];
        zArr[i14] = z8;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int[] iArr2 = this.keys;
            if (i8 >= iArr2.length) {
                List<E> list2 = this.nextPermutation;
                this.nextPermutation = arrayList;
                return list2;
            }
            int i15 = iArr2[i8];
            if (i15 > i10) {
                boolean[] zArr2 = this.direction;
                zArr2[i8] = !zArr2[i8];
            }
            arrayList.add(this.objectMap.get(Integer.valueOf(i15)));
            i8++;
        }
    }
}
