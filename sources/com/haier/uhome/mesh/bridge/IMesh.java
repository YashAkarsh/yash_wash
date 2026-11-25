package com.haier.uhome.mesh.bridge;

import com.haier.uhome.mesh.api.model.MeshAppKey;
import com.haier.uhome.mesh.api.model.MeshDeviceNode;
import com.haier.uhome.mesh.api.model.MeshNetKey;
import com.haier.uhome.usdk.base.api.o;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IMesh {
    void addKnownNodes(MeshDeviceNode meshDeviceNode, o oVar);

    void closeConnect();

    void closeGatt(String str);

    void initStack(int i7, long j7, List<MeshDeviceNode> list, List<MeshNetKey> list2, List<MeshAppKey> list3, o oVar);

    void setLogLevel(int i7);

    void setMeshCallback(IMeshCallback iMeshCallback);

    void setProxyNode(String str, o oVar);

    void startAutoConnect();

    void startMeshModule(o oVar);

    void stopMeshModule(o oVar);
}
