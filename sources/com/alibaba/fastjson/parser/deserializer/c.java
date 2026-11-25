package com.alibaba.fastjson.parser.deserializer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c extends k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Type f12874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12875e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e1 f12876f;

    public c(com.alibaba.fastjson.parser.j jVar, Class<?> cls, com.alibaba.fastjson.util.e eVar) {
        super(cls, eVar);
        Type type = eVar.f13298f;
        if (!(type instanceof ParameterizedType)) {
            this.f12874d = Object.class;
            return;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        this.f12874d = type2;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.k
    public int a() {
        return 14;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.k
    public void b(com.alibaba.fastjson.parser.b bVar, Object obj, Type type, Map<String, Object> map) {
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        int iL0 = dVar.L0();
        if (iL0 == 8 || (iL0 == 4 && dVar.x0().length() == 0)) {
            f(obj, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        com.alibaba.fastjson.parser.i iVarC = bVar.C();
        bVar.Y1(iVarC, obj, this.f12897a.f13293a);
        i(bVar, type, arrayList);
        bVar.a2(iVarC);
        if (obj == null) {
            map.put(this.f12897a.f13293a, arrayList);
        } else {
            e(obj, arrayList);
        }
    }

    public final void i(com.alibaba.fastjson.parser.b bVar, Type type, Collection collection) {
        Class cls;
        int i7;
        Type iVar;
        int i8;
        Type type2 = this.f12874d;
        e1 e1VarN = this.f12876f;
        int i9 = 0;
        if (type instanceof ParameterizedType) {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
                if (cls == null) {
                    i8 = -1;
                    break;
                }
                int length = cls.getTypeParameters().length;
                i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        i8 = -1;
                        break;
                    } else if (cls.getTypeParameters()[i8].getName().equals(typeVariable.getName())) {
                        break;
                    } else {
                        i8++;
                    }
                }
                if (i8 != -1) {
                    iVar = parameterizedType.getActualTypeArguments()[i8];
                    if (!iVar.equals(this.f12874d)) {
                        e1VarN = bVar.u().n(iVar);
                    }
                    type2 = iVar;
                }
            } else if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1) {
                    Type type3 = actualTypeArguments[0];
                    if (type3 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type3;
                        ParameterizedType parameterizedType3 = (ParameterizedType) type;
                        cls = parameterizedType3.getRawType() instanceof Class ? (Class) parameterizedType3.getRawType() : null;
                        if (cls == null) {
                            i7 = -1;
                            break;
                        }
                        int length2 = cls.getTypeParameters().length;
                        i7 = 0;
                        while (true) {
                            if (i7 >= length2) {
                                i7 = -1;
                                break;
                            } else if (cls.getTypeParameters()[i7].getName().equals(typeVariable2.getName())) {
                                break;
                            } else {
                                i7++;
                            }
                        }
                        if (i7 != -1) {
                            actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i7];
                            iVar = new com.alibaba.fastjson.util.i(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                            type2 = iVar;
                        }
                    }
                }
            }
        } else if ((type2 instanceof TypeVariable) && (type instanceof Class)) {
            Class cls2 = (Class) type;
            TypeVariable typeVariable3 = (TypeVariable) type2;
            cls2.getTypeParameters();
            int length3 = cls2.getTypeParameters().length;
            for (int i10 = 0; i10 < length3; i10++) {
                TypeVariable typeVariable4 = cls2.getTypeParameters()[i10];
                if (typeVariable4.getName().equals(typeVariable3.getName())) {
                    Type[] bounds = typeVariable4.getBounds();
                    if (bounds.length != 1) {
                        break;
                    }
                    type2 = bounds[0];
                    break;
                }
            }
        }
        com.alibaba.fastjson.parser.d dVar = bVar.f12789f;
        if (dVar.L0() != 14) {
            if (e1VarN == null) {
                e1VarN = bVar.u().n(type2);
                this.f12876f = e1VarN;
            }
            collection.add(e1VarN.b(bVar, type2, 0));
            bVar.m(collection);
            return;
        }
        if (e1VarN == null) {
            e1VarN = bVar.u().n(type2);
            this.f12876f = e1VarN;
            this.f12875e = e1VarN.e();
        }
        e1 e1Var = e1VarN;
        dVar.Q(this.f12875e);
        while (true) {
            if (dVar.G(com.alibaba.fastjson.parser.c.AllowArbitraryCommas)) {
                while (dVar.L0() == 16) {
                    dVar.E();
                }
            }
            if (dVar.L0() == 15) {
                dVar.Q(16);
                return;
            }
            collection.add(e1Var.b(bVar, type2, Integer.valueOf(i9)));
            bVar.m(collection);
            if (dVar.L0() == 16) {
                dVar.Q(this.f12875e);
            }
            i9++;
        }
    }
}
