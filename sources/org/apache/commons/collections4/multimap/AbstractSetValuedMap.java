package org.apache.commons.collections4.multimap;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.collections4.SetValuedMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractSetValuedMap<K, V> extends AbstractMultiValuedMap<K, V> implements SetValuedMap<K, V> {

    private class WrappedSet extends AbstractMultiValuedMap<K, V>.WrappedCollection implements Set<V> {
        public WrappedSet(K k7) {
            super(k7);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            Set set = (Set) getMapping();
            if (set == null) {
                return Collections.emptySet().equals(obj);
            }
            if (obj instanceof Set) {
                return SetUtils.isEqualSet(set, (Set) obj);
            }
            return false;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return SetUtils.hashCodeForSet((Set) getMapping());
        }
    }

    protected AbstractSetValuedMap() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public abstract Set<V> createCollection();

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    protected Map<K, Set<V>> getMap() {
        return super.getMap();
    }

    protected AbstractSetValuedMap(Map<K, ? extends Set<V>> map) {
        super(map);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public Set<V> get(K k7) {
        return wrappedCollection((Object) k7);
    }

    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap, org.apache.commons.collections4.MultiValuedMap
    public Set<V> remove(Object obj) {
        return SetUtils.emptyIfNull(getMap().remove(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public Set<V> wrappedCollection(K k7) {
        return new WrappedSet(k7);
    }
}
