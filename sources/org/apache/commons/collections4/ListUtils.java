package org.apache.commons.collections4;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.functors.DefaultEquator;
import org.apache.commons.collections4.list.FixedSizeList;
import org.apache.commons.collections4.list.LazyList;
import org.apache.commons.collections4.list.PredicatedList;
import org.apache.commons.collections4.list.TransformedList;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.apache.commons.collections4.sequence.CommandVisitor;
import org.apache.commons.collections4.sequence.EditScript;
import org.apache.commons.collections4.sequence.SequencesComparator;

/* JADX INFO: loaded from: classes3.dex */
public class ListUtils {

    private static final class CharSequenceAsList extends AbstractList<Character> {
        private final CharSequence sequence;

        public CharSequenceAsList(CharSequence charSequence) {
            this.sequence = charSequence;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.sequence.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int i7) {
            return Character.valueOf(this.sequence.charAt(i7));
        }
    }

    private static final class LcsVisitor<E> implements CommandVisitor<E> {
        private ArrayList<E> sequence = new ArrayList<>();

        public List<E> getSubSequence() {
            return this.sequence;
        }

        @Override // org.apache.commons.collections4.sequence.CommandVisitor
        public void visitDeleteCommand(E e8) {
        }

        @Override // org.apache.commons.collections4.sequence.CommandVisitor
        public void visitInsertCommand(E e8) {
        }

        @Override // org.apache.commons.collections4.sequence.CommandVisitor
        public void visitKeepCommand(E e8) {
            this.sequence.add(e8);
        }
    }

    private static class Partition<T> extends AbstractList<List<T>> {
        private final List<T> list;
        private final int size;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            int size = this.list.size();
            int i7 = this.size;
            return ((size + i7) - 1) / i7;
        }

        private Partition(List<T> list, int i7) {
            this.list = list;
            this.size = i7;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> get(int i7) {
            int size = size();
            if (size < 0) {
                throw new IllegalArgumentException("negative size: " + size);
            }
            if (i7 < 0) {
                throw new IndexOutOfBoundsException("Index " + i7 + " must not be negative");
            }
            if (i7 < size) {
                int i8 = this.size;
                int i9 = i7 * i8;
                return this.list.subList(i9, Math.min(i8 + i9, this.list.size()));
            }
            throw new IndexOutOfBoundsException("Index " + i7 + " must be less than size " + size);
        }
    }

    private ListUtils() {
    }

    public static <T> List<T> defaultIfNull(List<T> list, List<T> list2) {
        return list == null ? list2 : list;
    }

    public static <T> List<T> emptyIfNull(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    public static <E> List<E> fixedSizeList(List<E> list) {
        return FixedSizeList.fixedSizeList(list);
    }

    public static int hashCodeForList(Collection<?> collection) {
        if (collection == null) {
            return 0;
        }
        Iterator<?> it = collection.iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next == null ? 0 : next.hashCode());
        }
        return iHashCode;
    }

    public static <E> int indexOf(List<E> list, Predicate<E> predicate) {
        if (list == null || predicate == null) {
            return -1;
        }
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (predicate.evaluate(list.get(i7))) {
                return i7;
            }
        }
        return -1;
    }

    public static <E> List<E> intersection(List<? extends E> list, List<? extends E> list2) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > list2.size()) {
            list2 = list;
            list = list2;
        }
        HashSet hashSet = new HashSet(list);
        for (E e8 : list2) {
            if (hashSet.contains(e8)) {
                arrayList.add(e8);
                hashSet.remove(e8);
            }
        }
        return arrayList;
    }

    public static boolean isEqualList(Collection<?> collection, Collection<?> collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        Iterator<?> it = collection.iterator();
        Iterator<?> it2 = collection2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            Object next2 = it2.next();
            if (next == null) {
                if (next2 != null) {
                    return false;
                }
            } else if (!next.equals(next2)) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public static <E> List<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return LazyList.lazyList(list, factory);
    }

    public static <E> List<E> longestCommonSubsequence(List<E> list, List<E> list2) {
        return longestCommonSubsequence(list, list2, DefaultEquator.defaultEquator());
    }

    public static <T> List<List<T>> partition(List<T> list, int i7) {
        if (list == null) {
            throw new NullPointerException("List must not be null");
        }
        if (i7 > 0) {
            return new Partition(list, i7);
        }
        throw new IllegalArgumentException("Size must be greater than 0");
    }

    public static <E> List<E> predicatedList(List<E> list, Predicate<E> predicate) {
        return PredicatedList.predicatedList(list, predicate);
    }

    public static <E> List<E> removeAll(Collection<E> collection, Collection<?> collection2) {
        ArrayList arrayList = new ArrayList();
        for (E e8 : collection) {
            if (!collection2.contains(e8)) {
                arrayList.add(e8);
            }
        }
        return arrayList;
    }

    public static <E> List<E> retainAll(Collection<E> collection, Collection<?> collection2) {
        ArrayList arrayList = new ArrayList(Math.min(collection.size(), collection2.size()));
        for (E e8 : collection) {
            if (collection2.contains(e8)) {
                arrayList.add(e8);
            }
        }
        return arrayList;
    }

    public static <E> List<E> select(Collection<? extends E> collection, Predicate<? super E> predicate) {
        return (List) CollectionUtils.select(collection, predicate, new ArrayList(collection.size()));
    }

    public static <E> List<E> selectRejected(Collection<? extends E> collection, Predicate<? super E> predicate) {
        return (List) CollectionUtils.selectRejected(collection, predicate, new ArrayList(collection.size()));
    }

    public static <E> List<E> subtract(List<E> list, List<? extends E> list2) {
        ArrayList arrayList = new ArrayList();
        HashBag hashBag = new HashBag(list2);
        for (E e8 : list) {
            if (!hashBag.remove(e8, 1)) {
                arrayList.add(e8);
            }
        }
        return arrayList;
    }

    public static <E> List<E> sum(List<? extends E> list, List<? extends E> list2) {
        return subtract(union(list, list2), intersection(list, list2));
    }

    public static <E> List<E> synchronizedList(List<E> list) {
        return Collections.synchronizedList(list);
    }

    public static <E> List<E> transformedList(List<E> list, Transformer<? super E, ? extends E> transformer) {
        return TransformedList.transformingList(list, transformer);
    }

    public static <E> List<E> union(List<? extends E> list, List<? extends E> list2) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    public static <E> List<E> unmodifiableList(List<? extends E> list) {
        return UnmodifiableList.unmodifiableList(list);
    }

    public static <E> List<E> longestCommonSubsequence(List<E> list, List<E> list2, Equator<? super E> equator) {
        if (list == null || list2 == null) {
            throw new NullPointerException("List must not be null");
        }
        if (equator == null) {
            throw new NullPointerException("Equator must not be null");
        }
        EditScript script = new SequencesComparator(list, list2, equator).getScript();
        LcsVisitor lcsVisitor = new LcsVisitor();
        script.visit(lcsVisitor);
        return lcsVisitor.getSubSequence();
    }

    public static String longestCommonSubsequence(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            List listLongestCommonSubsequence = longestCommonSubsequence(new CharSequenceAsList(charSequence), new CharSequenceAsList(charSequence2));
            StringBuilder sb = new StringBuilder();
            Iterator it = listLongestCommonSubsequence.iterator();
            while (it.hasNext()) {
                sb.append((Character) it.next());
            }
            return sb.toString();
        }
        throw new NullPointerException("CharSequence must not be null");
    }
}
