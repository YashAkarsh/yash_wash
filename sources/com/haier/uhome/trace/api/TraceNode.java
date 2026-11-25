package com.haier.uhome.trace.api;

import android.text.TextUtils;
import com.haier.uhome.trace.b.f;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class TraceNode {
    private final String mBusinessName;
    private String mCustomTraceId;
    private TraceNode mInnerSRNode;
    private final String mProtocol;
    private TraceNode mRelatedCSNode;
    private TraceNode mRelatedSRNode;
    private String mSpanId;
    private String mTraceId;
    private final f mType;
    private final HashMap<String, String> mExtendInfo = new HashMap<>();
    private final long mTimestamp = System.currentTimeMillis();

    /* JADX INFO: renamed from: com.haier.uhome.trace.api.TraceNode$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f30228a;

        static {
            int[] iArr = new int[f.values().length];
            f30228a = iArr;
            try {
                iArr[f.SR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30228a[f.CS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30228a[f.CR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30228a[f.SS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private TraceNode(String str, String str2, f fVar) {
        this.mBusinessName = str;
        this.mProtocol = str2;
        this.mType = fVar;
    }

    public static TraceNode createCRNode(String str, String str2, TraceNode traceNode) {
        TraceNode traceNode2 = new TraceNode(str, str2, f.CR);
        traceNode2.setRelatedCSNode(traceNode);
        return traceNode2;
    }

    public static TraceNode createCSNode(String str, String str2) {
        return createCSNode(str, str2, null);
    }

    public static TraceNode createNode(String str, String str2, f fVar, TraceNode traceNode) {
        int i7 = AnonymousClass1.f30228a[fVar.ordinal()];
        if (i7 == 1) {
            return createSRNode(str, str2, traceNode);
        }
        if (i7 == 2) {
            return createCSNode(str, str2, traceNode);
        }
        if (i7 != 3) {
            return i7 != 4 ? createCSNode(str, str2, traceNode) : createSSNode(str, str2, traceNode);
        }
        return createCRNode(str, str2, traceNode);
    }

    private static TraceNode createSRNode(String str, String str2, TraceNode traceNode) {
        f fVar = f.SR;
        TraceNode traceNode2 = new TraceNode(str, str2, fVar);
        traceNode2.setRelatedCSNode(traceNode);
        if (traceNode != null && traceNode.getType() == fVar) {
            traceNode2.setInnerSRNode(traceNode);
        }
        return traceNode2;
    }

    private static TraceNode createSSNode(String str, String str2, TraceNode traceNode) {
        TraceNode traceNode2 = new TraceNode(str, str2, f.SS);
        traceNode2.setRelatedSRNode(traceNode);
        return traceNode2;
    }

    public void add(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            e3.a.f("TraceNode add error: key = %s, value = %s", str, str2, new Object[0]);
        } else {
            this.mExtendInfo.put(str, str2);
        }
    }

    public String getBusinessName() {
        return this.mBusinessName;
    }

    public String getCustomTraceId() {
        return this.mCustomTraceId;
    }

    public HashMap<String, String> getExtendInfo() {
        return new HashMap<>(this.mExtendInfo);
    }

    public TraceNode getInnerSRNode() {
        return this.mInnerSRNode;
    }

    public String getProtocol() {
        return this.mProtocol;
    }

    public TraceNode getRelatedCSNode() {
        return this.mRelatedCSNode;
    }

    public TraceNode getRelatedSRNode() {
        return this.mRelatedSRNode;
    }

    public String getSpanId() {
        return TextUtils.isEmpty(this.mSpanId) ? "0.1" : this.mSpanId;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public String getTraceId() {
        String str = this.mTraceId;
        return str == null ? "" : str;
    }

    public f getType() {
        return this.mType;
    }

    public void setCustomTraceId(String str) {
        this.mCustomTraceId = str;
    }

    public void setInnerSRNode(TraceNode traceNode) {
        this.mInnerSRNode = traceNode;
    }

    public void setRelatedCSNode(TraceNode traceNode) {
        this.mRelatedCSNode = traceNode;
    }

    public void setRelatedSRNode(TraceNode traceNode) {
        this.mRelatedSRNode = traceNode;
    }

    public void setSpanId(String str) {
        this.mSpanId = str;
    }

    public void setTraceId(String str) {
        this.mTraceId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TraceNode{mBusinessName=");
        sb.append(this.mBusinessName);
        sb.append(", mProtocol=");
        sb.append(this.mProtocol);
        sb.append(", mExtendInfo=");
        sb.append(this.mExtendInfo);
        sb.append(", mTraceId=");
        sb.append(this.mTraceId);
        sb.append(", mSpanId=");
        sb.append(this.mSpanId);
        sb.append(", mType=");
        sb.append(this.mType);
        sb.append(", mRelatedCSNode=");
        TraceNode traceNode = this.mRelatedCSNode;
        sb.append(traceNode == null ? "null" : traceNode.getSpanId());
        sb.append(", mRelatedSRNode=");
        TraceNode traceNode2 = this.mRelatedSRNode;
        sb.append(traceNode2 != null ? traceNode2.getSpanId() : "null");
        sb.append('}');
        return sb.toString();
    }

    private static TraceNode createCSNode(String str, String str2, TraceNode traceNode) {
        TraceNode traceNode2 = new TraceNode(str, str2, f.CS);
        if (traceNode != null && traceNode.getType() != null) {
            int i7 = AnonymousClass1.f30228a[traceNode.getType().ordinal()];
            if (i7 == 1) {
                traceNode2.setRelatedSRNode(traceNode);
            } else if (i7 == 2) {
                traceNode2.setRelatedCSNode(traceNode);
            }
        }
        return traceNode2;
    }
}
