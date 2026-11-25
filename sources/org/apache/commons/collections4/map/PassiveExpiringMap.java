package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class PassiveExpiringMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<Object, Long> expirationMap;
    private final ExpirationPolicy<K, V> expiringPolicy;

    public static class ConstantTimeToLiveExpirationPolicy<K, V> implements ExpirationPolicy<K, V> {
        private static final long serialVersionUID = 1;
        private final long timeToLiveMillis;

        public ConstantTimeToLiveExpirationPolicy() {
            this(-1L);
        }

        @Override // org.apache.commons.collections4.map.PassiveExpiringMap.ExpirationPolicy
        public long expirationTime(K k7, V v7) {
            if (this.timeToLiveMillis < 0) {
                return -1L;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j7 = this.timeToLiveMillis;
            if (jCurrentTimeMillis > Long.MAX_VALUE - j7) {
                return -1L;
            }
            return jCurrentTimeMillis + j7;
        }

        public ConstantTimeToLiveExpirationPolicy(long j7) {
            this.timeToLiveMillis = j7;
        }

        public ConstantTimeToLiveExpirationPolicy(long j7, TimeUnit timeUnit) {
            this(PassiveExpiringMap.validateAndConvertToMillis(j7, timeUnit));
        }
    }

    public interface ExpirationPolicy<K, V> extends Serializable {
        long expirationTime(K k7, V v7);
    }

    public PassiveExpiringMap() {
        this(-1L);
    }

    private boolean isExpired(long j7, Long l7) {
        if (l7 == null) {
            return false;
        }
        long jLongValue = l7.longValue();
        return jLongValue >= 0 && j7 >= jLongValue;
    }

    private long now() {
        return System.currentTimeMillis();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void removeAllExpired(long j7) {
        Iterator<Map.Entry<Object, Long>> it = this.expirationMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Long> next = it.next();
            if (isExpired(j7, next.getValue())) {
                super.remove(next.getKey());
                it.remove();
            }
        }
    }

    private void removeIfExpired(Object obj, long j7) {
        if (isExpired(j7, this.expirationMap.get(obj))) {
            remove(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long validateAndConvertToMillis(long j7, TimeUnit timeUnit) {
        if (timeUnit != null) {
            return TimeUnit.MILLISECONDS.convert(j7, timeUnit);
        }
        throw new NullPointerException("Time unit must not be null");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        super.clear();
        this.expirationMap.clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        removeIfExpired(obj, now());
        return super.containsKey(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        removeAllExpired(now());
        return super.containsValue(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        removeAllExpired(now());
        return super.entrySet();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        removeIfExpired(obj, now());
        return (V) super.get(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        removeAllExpired(now());
        return super.isEmpty();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        removeAllExpired(now());
        return super.keySet();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k7, V v7) {
        this.expirationMap.put(k7, Long.valueOf(this.expiringPolicy.expirationTime(k7, v7)));
        return (V) super.put(k7, v7);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        this.expirationMap.remove(obj);
        return (V) super.remove(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        removeAllExpired(now());
        return super.size();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        removeAllExpired(now());
        return super.values();
    }

    public PassiveExpiringMap(ExpirationPolicy<K, V> expirationPolicy) {
        this(expirationPolicy, new HashMap());
    }

    public PassiveExpiringMap(ExpirationPolicy<K, V> expirationPolicy, Map<K, V> map) {
        super(map);
        this.expirationMap = new HashMap();
        if (expirationPolicy != null) {
            this.expiringPolicy = expirationPolicy;
            return;
        }
        throw new NullPointerException("Policy must not be null.");
    }

    public PassiveExpiringMap(long j7) {
        this(new ConstantTimeToLiveExpirationPolicy(j7), new HashMap());
    }

    public PassiveExpiringMap(long j7, Map<K, V> map) {
        this(new ConstantTimeToLiveExpirationPolicy(j7), map);
    }

    public PassiveExpiringMap(long j7, TimeUnit timeUnit) {
        this(validateAndConvertToMillis(j7, timeUnit));
    }

    public PassiveExpiringMap(long j7, TimeUnit timeUnit, Map<K, V> map) {
        this(validateAndConvertToMillis(j7, timeUnit), map);
    }

    public PassiveExpiringMap(Map<K, V> map) {
        this(-1L, map);
    }
}
