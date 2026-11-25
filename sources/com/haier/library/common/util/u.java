package com.haier.library.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    public interface a<S, K> {
        K a(S s7);
    }

    public interface b<S> {
        boolean a(S s7);
    }

    public interface c<S> {
        boolean a(S s7);
    }

    public static <S, T> ArrayList<T> a(List<S> list, p<S, T> pVar) {
        if (list == null || pVar == null) {
            return (ArrayList) Collections.emptyList();
        }
        ArrayList<T> arrayList = new ArrayList<>(list.size());
        for (S s7 : list) {
            if (s7 != null) {
                arrayList.add(pVar.transform(s7));
            }
        }
        return arrayList;
    }

    public static <S> ArrayList<S> b(List<S> list, c<S> cVar) {
        if (list == null || cVar == null) {
            throw new IllegalArgumentException("sourceList or predictor should not be null");
        }
        ArrayList<S> arrayList = new ArrayList<>();
        for (S s7 : list) {
            if (s7 == null) {
                throw new IllegalArgumentException("source should not be null.");
            }
            if (cVar.a(s7)) {
                arrayList.add(s7);
            }
        }
        return arrayList;
    }

    public static <K, S, T> HashMap<K, T> c(Map<K, S> map, p<S, T> pVar) {
        if (map == null || pVar == null) {
            throw new IllegalArgumentException("source list should not be null");
        }
        HashMap<K, T> map2 = new HashMap<>();
        for (K k7 : map.keySet()) {
            if (k7 == null) {
                throw new IllegalArgumentException("source should not be null.");
            }
            S s7 = map.get(k7);
            if (s7 == null) {
                throw new IllegalArgumentException("source should not be null.");
            }
            map2.put(k7, pVar.transform(s7));
        }
        return map2;
    }

    public static <S> List<S> d(List<S> list) {
        if (list == null) {
            throw new IllegalArgumentException("source list should not be null");
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (S s7 : list) {
            if (s7 != null) {
                arrayList.add(s7);
            }
        }
        return arrayList;
    }

    public static <S, T> List<T> e(List<S> list, c<S> cVar, p<S, T> pVar) {
        if (list == null || cVar == null || pVar == null) {
            throw new IllegalArgumentException("sourceList or predictor or converter should not be null");
        }
        ArrayList arrayList = new ArrayList();
        for (S s7 : list) {
            if (s7 == null) {
                throw new IllegalArgumentException("source should not be null.");
            }
            if (cVar.a(s7)) {
                arrayList.add(pVar.transform(s7));
            }
        }
        return arrayList;
    }

    public static <S, K> Map<K, S> f(List<S> list, a<S, K> aVar) {
        if (list == null || aVar == null) {
            throw new IllegalArgumentException("sourceList or keyConverter should not be null");
        }
        HashMap map = new HashMap();
        for (S s7 : list) {
            map.put(aVar.a(s7), s7);
        }
        return map;
    }

    public static <S> void g(List<S> list, b<S> bVar) {
        if (list == null || bVar == null) {
            throw new IllegalArgumentException("sourceList or operation should not be null");
        }
        Iterator<S> it = list.iterator();
        while (it.hasNext()) {
            bVar.a(it.next());
        }
    }

    public static <O> boolean h(List<O> list) {
        return list == null || list.isEmpty();
    }
}
