package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FixedOrderComparator<T> implements Comparator<T>, Serializable {
    private static final long serialVersionUID = 82794675842863201L;
    private final Map<T, Integer> map = new HashMap();
    private int counter = 0;
    private boolean isLocked = false;
    private UnknownObjectBehavior unknownObjectBehavior = UnknownObjectBehavior.EXCEPTION;

    /* JADX INFO: renamed from: org.apache.commons.collections4.comparators.FixedOrderComparator$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior;

        static {
            int[] iArr = new int[UnknownObjectBehavior.values().length];
            $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior = iArr;
            try {
                iArr[UnknownObjectBehavior.BEFORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[UnknownObjectBehavior.AFTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[UnknownObjectBehavior.EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum UnknownObjectBehavior {
        BEFORE,
        AFTER,
        EXCEPTION
    }

    public FixedOrderComparator() {
    }

    public boolean add(T t7) {
        checkLocked();
        Map<T, Integer> map = this.map;
        int i7 = this.counter;
        this.counter = i7 + 1;
        return map.put(t7, Integer.valueOf(i7)) == null;
    }

    public boolean addAsEqual(T t7, T t8) {
        checkLocked();
        Integer num = this.map.get(t7);
        if (num != null) {
            return this.map.put(t8, num) == null;
        }
        throw new IllegalArgumentException(t7 + " not known to " + this);
    }

    protected void checkLocked() {
        if (isLocked()) {
            throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
        }
    }

    @Override // java.util.Comparator
    public int compare(T t7, T t8) {
        this.isLocked = true;
        Integer num = this.map.get(t7);
        Integer num2 = this.map.get(t8);
        if (num != null && num2 != null) {
            return num.compareTo(num2);
        }
        int i7 = AnonymousClass1.$SwitchMap$org$apache$commons$collections4$comparators$FixedOrderComparator$UnknownObjectBehavior[this.unknownObjectBehavior.ordinal()];
        if (i7 == 1) {
            if (num == null) {
                return num2 == null ? 0 : -1;
            }
            return 1;
        }
        if (i7 == 2) {
            if (num == null) {
                return num2 == null ? 0 : 1;
            }
            return -1;
        }
        if (i7 != 3) {
            throw new UnsupportedOperationException("Unknown unknownObjectBehavior: " + this.unknownObjectBehavior);
        }
        if (num != null) {
            t7 = t8;
        }
        throw new IllegalArgumentException("Attempting to compare unknown object " + t7);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FixedOrderComparator fixedOrderComparator = (FixedOrderComparator) obj;
        Map<T, Integer> map = this.map;
        if (map != null ? map.equals(fixedOrderComparator.map) : fixedOrderComparator.map == null) {
            UnknownObjectBehavior unknownObjectBehavior = this.unknownObjectBehavior;
            if (unknownObjectBehavior != null) {
                UnknownObjectBehavior unknownObjectBehavior2 = fixedOrderComparator.unknownObjectBehavior;
                if (unknownObjectBehavior == unknownObjectBehavior2 && this.counter == fixedOrderComparator.counter && this.isLocked == fixedOrderComparator.isLocked && unknownObjectBehavior == unknownObjectBehavior2) {
                    return true;
                }
            } else if (fixedOrderComparator.unknownObjectBehavior == null) {
                return true;
            }
        }
        return false;
    }

    public UnknownObjectBehavior getUnknownObjectBehavior() {
        return this.unknownObjectBehavior;
    }

    public int hashCode() {
        Map<T, Integer> map = this.map;
        int iHashCode = (629 + (map == null ? 0 : map.hashCode())) * 37;
        UnknownObjectBehavior unknownObjectBehavior = this.unknownObjectBehavior;
        return ((((iHashCode + (unknownObjectBehavior != null ? unknownObjectBehavior.hashCode() : 0)) * 37) + this.counter) * 37) + (!this.isLocked ? 1 : 0);
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setUnknownObjectBehavior(UnknownObjectBehavior unknownObjectBehavior) {
        checkLocked();
        if (unknownObjectBehavior == null) {
            throw new NullPointerException("Unknown object behavior must not be null");
        }
        this.unknownObjectBehavior = unknownObjectBehavior;
    }

    public FixedOrderComparator(T... tArr) {
        if (tArr != null) {
            for (T t7 : tArr) {
                add(t7);
            }
            return;
        }
        throw new NullPointerException("The list of items must not be null");
    }

    public FixedOrderComparator(List<T> list) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
            return;
        }
        throw new NullPointerException("The list of items must not be null");
    }
}
