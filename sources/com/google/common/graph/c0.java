package com.google.common.graph;

/* JADX INFO: loaded from: classes2.dex */
final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f21589a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f21590b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f21591c = 20;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final float f21592d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f21593e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f21594f = "Node %s is not an element of this graph.";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final String f21595g = "Edge %s is not an element of this graph.";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final String f21596h = "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final String f21597i = "Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final String f21598j = "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final String f21599k = "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final String f21600l = "Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final String f21601m = "Edge %s already exists in the graph.";

    enum a {
        EDGE_EXISTS
    }

    private c0() {
    }
}
