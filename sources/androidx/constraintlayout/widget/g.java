package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f4958h = "ConstraintLayoutStates";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final boolean f4959i = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    d f4961b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4960a = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f4962c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f4963d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SparseArray<a> f4964e = new SparseArray<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SparseArray<d> f4965f = new SparseArray<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f4966g = null;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<b> f4968b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f4969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f4970d;

        public a(Context context, XmlPullParser parser) {
            this.f4969c = -1;
            this.f4970d = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.State_android_id) {
                    this.f4967a = typedArrayObtainStyledAttributes.getResourceId(index, this.f4967a);
                } else if (index == R.styleable.State_constraints) {
                    this.f4969c = typedArrayObtainStyledAttributes.getResourceId(index, this.f4969c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4969c);
                    context.getResources().getResourceName(this.f4969c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f4970d = true;
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void a(b size) {
            this.f4968b.add(size);
        }

        public int b(float width, float height) {
            for (int i7 = 0; i7 < this.f4968b.size(); i7++) {
                if (this.f4968b.get(i7).a(width, height)) {
                    return i7;
                }
            }
            return -1;
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f4971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f4972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f4973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f4974d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f4975e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f4976f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f4977g;

        public b(Context context, XmlPullParser parser) {
            this.f4972b = Float.NaN;
            this.f4973c = Float.NaN;
            this.f4974d = Float.NaN;
            this.f4975e = Float.NaN;
            this.f4976f = -1;
            this.f4977g = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == R.styleable.Variant_constraints) {
                    this.f4976f = typedArrayObtainStyledAttributes.getResourceId(index, this.f4976f);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4976f);
                    context.getResources().getResourceName(this.f4976f);
                    if ("layout".equals(resourceTypeName)) {
                        this.f4977g = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f4975e = typedArrayObtainStyledAttributes.getDimension(index, this.f4975e);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f4973c = typedArrayObtainStyledAttributes.getDimension(index, this.f4973c);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f4974d = typedArrayObtainStyledAttributes.getDimension(index, this.f4974d);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f4972b = typedArrayObtainStyledAttributes.getDimension(index, this.f4972b);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        boolean a(float widthDp, float heightDp) {
            if (!Float.isNaN(this.f4972b) && widthDp < this.f4972b) {
                return false;
            }
            if (!Float.isNaN(this.f4973c) && heightDp < this.f4973c) {
                return false;
            }
            if (Float.isNaN(this.f4974d) || widthDp <= this.f4974d) {
                return Float.isNaN(this.f4975e) || heightDp <= this.f4975e;
            }
            return false;
        }
    }

    public g(Context context, XmlPullParser parser) {
        b(context, parser);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void b(Context context, XmlPullParser parser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.StateSet);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i7 = 0; i7 < indexCount; i7++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i7);
            if (index == R.styleable.StateSet_defaultState) {
                this.f4960a = typedArrayObtainStyledAttributes.getResourceId(index, this.f4960a);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        try {
            int eventType = parser.getEventType();
            a aVar = null;
            while (true) {
                byte b8 = 1;
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    parser.getName();
                } else if (eventType == 2) {
                    String name = parser.getName();
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                b8 = 2;
                            } else {
                                b8 = -1;
                            }
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                b8 = 0;
                            } else {
                                b8 = -1;
                            }
                            break;
                        case 1382829617:
                            if (!name.equals("StateSet")) {
                                b8 = -1;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b8 = 3;
                            } else {
                                b8 = -1;
                            }
                            break;
                        default:
                            b8 = -1;
                            break;
                    }
                    if (b8 == 2) {
                        aVar = new a(context, parser);
                        this.f4964e.put(aVar.f4967a, aVar);
                    } else if (b8 == 3) {
                        b bVar = new b(context, parser);
                        if (aVar != null) {
                            aVar.a(bVar);
                        }
                    }
                } else if (eventType == 3 && "StateSet".equals(parser.getName())) {
                    return;
                }
                eventType = parser.next();
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        } catch (XmlPullParserException e9) {
            e9.printStackTrace();
        }
    }

    public int a(int currentConstrainSettId, int stateId, float width, float height) {
        a aVar = this.f4964e.get(stateId);
        if (aVar == null) {
            return stateId;
        }
        if (width == -1.0f || height == -1.0f) {
            if (aVar.f4969c == currentConstrainSettId) {
                return currentConstrainSettId;
            }
            Iterator<b> it = aVar.f4968b.iterator();
            while (it.hasNext()) {
                if (currentConstrainSettId == it.next().f4976f) {
                    return currentConstrainSettId;
                }
            }
            return aVar.f4969c;
        }
        b bVar = null;
        for (b bVar2 : aVar.f4968b) {
            if (bVar2.a(width, height)) {
                if (currentConstrainSettId == bVar2.f4976f) {
                    return currentConstrainSettId;
                }
                bVar = bVar2;
            }
        }
        return bVar != null ? bVar.f4976f : aVar.f4969c;
    }

    public boolean c(int id, float width, float height) {
        int i7 = this.f4962c;
        if (i7 != id) {
            return true;
        }
        a aVarValueAt = id == -1 ? this.f4964e.valueAt(0) : this.f4964e.get(i7);
        int i8 = this.f4963d;
        return (i8 == -1 || !aVarValueAt.f4968b.get(i8).a(width, height)) && this.f4963d != aVarValueAt.b(width, height);
    }

    public void d(e constraintsChangedListener) {
        this.f4966g = constraintsChangedListener;
    }

    public int e(int id, int width, int height) {
        return f(-1, id, width, height);
    }

    public int f(int currentId, int id, float width, float height) {
        int iB;
        if (currentId != id) {
            a aVar = this.f4964e.get(id);
            if (aVar == null) {
                return -1;
            }
            int iB2 = aVar.b(width, height);
            return iB2 == -1 ? aVar.f4969c : aVar.f4968b.get(iB2).f4976f;
        }
        a aVarValueAt = id == -1 ? this.f4964e.valueAt(0) : this.f4964e.get(this.f4962c);
        if (aVarValueAt == null) {
            return -1;
        }
        if ((this.f4963d == -1 || !aVarValueAt.f4968b.get(currentId).a(width, height)) && currentId != (iB = aVarValueAt.b(width, height))) {
            return iB == -1 ? aVarValueAt.f4969c : aVarValueAt.f4968b.get(iB).f4976f;
        }
        return currentId;
    }
}
