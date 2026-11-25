package org.apache.commons.collections4;

import com.alipay.sdk.util.j;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.map.AbstractMapDecorator;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;
import org.apache.commons.collections4.map.FixedSizeMap;
import org.apache.commons.collections4.map.FixedSizeSortedMap;
import org.apache.commons.collections4.map.LazyMap;
import org.apache.commons.collections4.map.LazySortedMap;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.collections4.map.PredicatedMap;
import org.apache.commons.collections4.map.PredicatedSortedMap;
import org.apache.commons.collections4.map.TransformedMap;
import org.apache.commons.collections4.map.TransformedSortedMap;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.map.UnmodifiableSortedMap;

/* JADX INFO: loaded from: classes3.dex */
public class MapUtils {
    public static final SortedMap EMPTY_SORTED_MAP = UnmodifiableSortedMap.unmodifiableSortedMap(new TreeMap());
    private static final String INDENT_STRING = "    ";

    private MapUtils() {
    }

    public static void debugPrint(PrintStream printStream, Object obj, Map<?, ?> map) {
        verbosePrintInternal(printStream, obj, map, new ArrayDeque(), true);
    }

    public static <K, V> Map<K, V> emptyIfNull(Map<K, V> map) {
        return map == null ? Collections.emptyMap() : map;
    }

    public static <K, V> IterableMap<K, V> fixedSizeMap(Map<K, V> map) {
        return FixedSizeMap.fixedSizeMap(map);
    }

    public static <K, V> SortedMap<K, V> fixedSizeSortedMap(SortedMap<K, V> sortedMap) {
        return FixedSizeSortedMap.fixedSizeSortedMap(sortedMap);
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K k7) {
        Object obj;
        if (map == null || (obj = map.get(k7)) == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            return Boolean.valueOf((String) obj);
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue() != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        return null;
    }

    public static <K> boolean getBooleanValue(Map<? super K, ?> map, K k7) {
        return Boolean.TRUE.equals(getBoolean(map, k7));
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K k7) {
        Number number = getNumber(map, k7);
        if (number == null) {
            return null;
        }
        return number instanceof Byte ? (Byte) number : Byte.valueOf(number.byteValue());
    }

    public static <K> byte getByteValue(Map<? super K, ?> map, K k7) {
        Byte b8 = getByte(map, k7);
        if (b8 == null) {
            return (byte) 0;
        }
        return b8.byteValue();
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K k7) {
        Number number = getNumber(map, k7);
        if (number == null) {
            return null;
        }
        return number instanceof Double ? (Double) number : Double.valueOf(number.doubleValue());
    }

    public static <K> double getDoubleValue(Map<? super K, ?> map, K k7) {
        Double d8 = getDouble(map, k7);
        if (d8 == null) {
            return 0.0d;
        }
        return d8.doubleValue();
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K k7) {
        Number number = getNumber(map, k7);
        if (number == null) {
            return null;
        }
        return number instanceof Float ? (Float) number : Float.valueOf(number.floatValue());
    }

    public static <K> float getFloatValue(Map<? super K, ?> map, K k7) {
        Float f8 = getFloat(map, k7);
        if (f8 == null) {
            return 0.0f;
        }
        return f8.floatValue();
    }

    public static <K> int getIntValue(Map<? super K, ?> map, K k7) {
        Integer integer = getInteger(map, k7);
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K k7) {
        Number number = getNumber(map, k7);
        if (number == null) {
            return null;
        }
        return number instanceof Integer ? (Integer) number : Integer.valueOf(number.intValue());
    }

    public static <K> Long getLong(Map<? super K, ?> map, K k7) {
        Number number = getNumber(map, k7);
        if (number == null) {
            return null;
        }
        return number instanceof Long ? (Long) number : Long.valueOf(number.longValue());
    }

    public static <K> long getLongValue(Map<? super K, ?> map, K k7) {
        Long l7 = getLong(map, k7);
        if (l7 == null) {
            return 0L;
        }
        return l7.longValue();
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K k7) {
        Object obj;
        if (map == null || (obj = map.get(k7)) == null || !(obj instanceof Map)) {
            return null;
        }
        return (Map) obj;
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K k7) {
        Object obj;
        if (map == null || (obj = map.get(k7)) == null) {
            return null;
        }
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return NumberFormat.getInstance().parse((String) obj);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static <K, V> V getObject(Map<? super K, V> map, K k7) {
        if (map != null) {
            return map.get(k7);
        }
        return null;
    }

    public static <K> Short getShort(Map<? super K, ?> map, K k7) {
        Number number = getNumber(map, k7);
        if (number == null) {
            return null;
        }
        return number instanceof Short ? (Short) number : Short.valueOf(number.shortValue());
    }

    public static <K> short getShortValue(Map<? super K, ?> map, K k7) {
        Short sh = getShort(map, k7);
        if (sh == null) {
            return (short) 0;
        }
        return sh.shortValue();
    }

    public static <K> String getString(Map<? super K, ?> map, K k7) {
        Object obj;
        if (map == null || (obj = map.get(k7)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static <K, V> Map<V, K> invertMap(Map<K, V> map) {
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            map2.put(entry.getValue(), entry.getKey());
        }
        return map2;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static <K, V> IterableMap<K, V> iterableMap(Map<K, V> map) {
        if (map != null) {
            return map instanceof IterableMap ? (IterableMap) map : new AbstractMapDecorator<K, V>(map) { // from class: org.apache.commons.collections4.MapUtils.1
            };
        }
        throw new NullPointerException("Map must not be null");
    }

    public static <K, V> IterableSortedMap<K, V> iterableSortedMap(SortedMap<K, V> sortedMap) {
        if (sortedMap != null) {
            return sortedMap instanceof IterableSortedMap ? (IterableSortedMap) sortedMap : new AbstractSortedMapDecorator<K, V>(sortedMap) { // from class: org.apache.commons.collections4.MapUtils.2
            };
        }
        throw new NullPointerException("Map must not be null");
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Factory<? extends V> factory) {
        return LazyMap.lazyMap(map, factory);
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Factory<? extends V> factory) {
        return LazySortedMap.lazySortedMap(sortedMap, factory);
    }

    @Deprecated
    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> map) {
        return MultiValueMap.multiValueMap(map);
    }

    public static <K, V> OrderedMap<K, V> orderedMap(Map<K, V> map) {
        return ListOrderedMap.listOrderedMap(map);
    }

    public static <K, V> void populateMap(Map<K, V> map, Iterable<? extends V> iterable, Transformer<V, K> transformer) {
        populateMap(map, iterable, transformer, TransformerUtils.nopTransformer());
    }

    public static <K, V> IterableMap<K, V> predicatedMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return PredicatedMap.predicatedMap(map, predicate, predicate2);
    }

    public static <K, V> SortedMap<K, V> predicatedSortedMap(SortedMap<K, V> sortedMap, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return PredicatedSortedMap.predicatedSortedMap(sortedMap, predicate, predicate2);
    }

    private static void printIndent(PrintStream printStream, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            printStream.print(INDENT_STRING);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> putAll(Map<K, V> map, Object[] objArr) {
        if (map == 0) {
            throw new NullPointerException("The map must not be null");
        }
        if (objArr != null && objArr.length != 0) {
            int i7 = 0;
            Object obj = objArr[0];
            if (obj instanceof Map.Entry) {
                int length = objArr.length;
                while (i7 < length) {
                    Map.Entry entry = (Map.Entry) objArr[i7];
                    map.put(entry.getKey(), entry.getValue());
                    i7++;
                }
            } else if (obj instanceof KeyValue) {
                int length2 = objArr.length;
                while (i7 < length2) {
                    KeyValue keyValue = (KeyValue) objArr[i7];
                    map.put(keyValue.getKey(), keyValue.getValue());
                    i7++;
                }
            } else if (obj instanceof Object[]) {
                for (int i8 = 0; i8 < objArr.length; i8++) {
                    Object[] objArr2 = (Object[]) objArr[i8];
                    if (objArr2 == null || objArr2.length < 2) {
                        throw new IllegalArgumentException("Invalid array element: " + i8);
                    }
                    map.put(objArr2[0], objArr2[1]);
                }
            } else {
                while (i7 < objArr.length - 1) {
                    int i9 = i7 + 1;
                    map.put(objArr[i7], objArr[i9]);
                    i7 = i9 + 1;
                }
            }
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K> void safeAddToMap(Map<? super K, Object> map, K k7, Object obj) throws NullPointerException {
        if (obj == null) {
            obj = "";
        }
        map.put(k7, obj);
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        return Collections.synchronizedMap(map);
    }

    public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> sortedMap) {
        return Collections.synchronizedSortedMap(sortedMap);
    }

    public static Map<String, Object> toMap(ResourceBundle resourceBundle) {
        Enumeration<String> keys = resourceBundle.getKeys();
        HashMap map = new HashMap();
        while (keys.hasMoreElements()) {
            String strNextElement = keys.nextElement();
            map.put(strNextElement, resourceBundle.getObject(strNextElement));
        }
        return map;
    }

    public static <K, V> Properties toProperties(Map<K, V> map) {
        Properties properties = new Properties();
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                properties.put(entry.getKey(), entry.getValue());
            }
        }
        return properties;
    }

    public static <K, V> IterableMap<K, V> transformedMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedMap.transformingMap(map, transformer, transformer2);
    }

    public static <K, V> SortedMap<K, V> transformedSortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedSortedMap.transformingSortedMap(sortedMap, transformer, transformer2);
    }

    public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> map) {
        return UnmodifiableMap.unmodifiableMap(map);
    }

    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> sortedMap) {
        return UnmodifiableSortedMap.unmodifiableSortedMap(sortedMap);
    }

    public static void verbosePrint(PrintStream printStream, Object obj, Map<?, ?> map) {
        verbosePrintInternal(printStream, obj, map, new ArrayDeque(), false);
    }

    private static void verbosePrintInternal(PrintStream printStream, Object obj, Map<?, ?> map, Deque<Map<?, ?>> deque, boolean z7) {
        printIndent(printStream, deque.size());
        if (map == null) {
            if (obj != null) {
                printStream.print(obj);
                printStream.print(" = ");
            }
            printStream.println("null");
            return;
        }
        if (obj != null) {
            printStream.print(obj);
            printStream.println(" = ");
        }
        printIndent(printStream, deque.size());
        printStream.println("{");
        deque.addLast(map);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (!(value instanceof Map) || deque.contains(value)) {
                printIndent(printStream, deque.size());
                printStream.print(key);
                printStream.print(" = ");
                int iIndexOf = IterableUtils.indexOf(deque, PredicateUtils.equalPredicate(value));
                if (iIndexOf == -1) {
                    printStream.print(value);
                } else if (deque.size() - 1 == iIndexOf) {
                    printStream.print("(this Map)");
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(ancestor[");
                    sb.append(((deque.size() - 1) - iIndexOf) - 1);
                    sb.append("] Map)");
                    printStream.print(sb.toString());
                }
                if (!z7 || value == null) {
                    printStream.println();
                } else {
                    printStream.print(' ');
                    printStream.println(value.getClass().getName());
                }
            } else {
                if (key == null) {
                    key = "null";
                }
                verbosePrintInternal(printStream, key, (Map) value, deque, z7);
            }
        }
        deque.removeLast();
        printIndent(printStream, deque.size());
        printStream.println(z7 ? "} " + map.getClass().getName() : j.f13808d);
    }

    public static <K> boolean getBooleanValue(Map<? super K, ?> map, K k7, boolean z7) {
        Boolean bool = getBoolean(map, k7);
        return bool == null ? z7 : bool.booleanValue();
    }

    public static <K, V> V getObject(Map<K, V> map, K k7, V v7) {
        V v8;
        return (map == null || (v8 = map.get(k7)) == null) ? v7 : v8;
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        return LazyMap.lazyMap(map, transformer);
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends V> transformer) {
        return LazySortedMap.lazySortedMap(sortedMap, transformer);
    }

    @Deprecated
    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Class<C> cls) {
        return MultiValueMap.multiValueMap(map, cls);
    }

    public static <K, V, E> void populateMap(Map<K, V> map, Iterable<? extends E> iterable, Transformer<E, K> transformer, Transformer<E, V> transformer2) {
        for (E e8 : iterable) {
            map.put(transformer.transform(e8), transformer2.transform(e8));
        }
    }

    public static <K> byte getByteValue(Map<? super K, ?> map, K k7, byte b8) {
        Byte b9 = getByte(map, k7);
        return b9 == null ? b8 : b9.byteValue();
    }

    public static <K> double getDoubleValue(Map<? super K, ?> map, K k7, double d8) {
        Double d9 = getDouble(map, k7);
        return d9 == null ? d8 : d9.doubleValue();
    }

    public static <K> float getFloatValue(Map<? super K, ?> map, K k7, float f8) {
        Float f9 = getFloat(map, k7);
        return f9 == null ? f8 : f9.floatValue();
    }

    public static <K> int getIntValue(Map<? super K, ?> map, K k7, int i7) {
        Integer integer = getInteger(map, k7);
        return integer == null ? i7 : integer.intValue();
    }

    public static <K> long getLongValue(Map<? super K, ?> map, K k7, long j7) {
        Long l7 = getLong(map, k7);
        return l7 == null ? j7 : l7.longValue();
    }

    public static <K> short getShortValue(Map<? super K, ?> map, K k7, short s7) {
        Short sh = getShort(map, k7);
        return sh == null ? s7 : sh.shortValue();
    }

    public static <K> String getString(Map<? super K, ?> map, K k7, String str) {
        String string = getString(map, k7);
        return string == null ? str : string;
    }

    @Deprecated
    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Factory<C> factory) {
        return MultiValueMap.multiValueMap(map, factory);
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K k7, Map<?, ?> map2) {
        Map<?, ?> map3 = getMap(map, k7);
        return map3 == null ? map2 : map3;
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K k7, Byte b8) {
        Byte b9 = getByte(map, k7);
        return b9 == null ? b8 : b9;
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K k7, Double d8) {
        Double d9 = getDouble(map, k7);
        return d9 == null ? d8 : d9;
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K k7, Float f8) {
        Float f9 = getFloat(map, k7);
        return f9 == null ? f8 : f9;
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K k7, Integer num) {
        Integer integer = getInteger(map, k7);
        return integer == null ? num : integer;
    }

    public static <K> Long getLong(Map<? super K, ?> map, K k7, Long l7) {
        Long l8 = getLong(map, k7);
        return l8 == null ? l7 : l8;
    }

    public static <K> Short getShort(Map<? super K, ?> map, K k7, Short sh) {
        Short sh2 = getShort(map, k7);
        return sh2 == null ? sh : sh2;
    }

    public static <K, V> void populateMap(MultiMap<K, V> multiMap, Iterable<? extends V> iterable, Transformer<V, K> transformer) {
        populateMap((MultiMap) multiMap, (Iterable) iterable, (Transformer) transformer, TransformerUtils.nopTransformer());
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K k7, Number number) {
        Number number2 = getNumber(map, k7);
        return number2 == null ? number : number2;
    }

    public static <K, V, E> void populateMap(MultiMap<K, V> multiMap, Iterable<? extends E> iterable, Transformer<E, K> transformer, Transformer<E, V> transformer2) {
        for (E e8 : iterable) {
            multiMap.put(transformer.transform(e8), transformer2.transform(e8));
        }
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K k7, Boolean bool) {
        Boolean bool2 = getBoolean(map, k7);
        return bool2 == null ? bool : bool2;
    }
}
