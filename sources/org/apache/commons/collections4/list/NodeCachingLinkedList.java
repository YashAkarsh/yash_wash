package org.apache.commons.collections4.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public class NodeCachingLinkedList<E> extends AbstractLinkedList<E> implements Serializable {
    private static final int DEFAULT_MAXIMUM_CACHE_SIZE = 20;
    private static final long serialVersionUID = 6897789178562232073L;
    private transient int cacheSize;
    private transient AbstractLinkedList.Node<E> firstCachedNode;
    private int maximumCacheSize;

    public NodeCachingLinkedList() {
        this(20);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    protected void addNodeToCache(AbstractLinkedList.Node<E> node) {
        if (isCacheFull()) {
            return;
        }
        AbstractLinkedList.Node<E> node2 = this.firstCachedNode;
        node.previous = null;
        node.next = node2;
        node.setValue(null);
        this.firstCachedNode = node;
        this.cacheSize++;
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    protected AbstractLinkedList.Node<E> createNode(E e8) {
        AbstractLinkedList.Node<E> nodeFromCache = getNodeFromCache();
        if (nodeFromCache == null) {
            return super.createNode(e8);
        }
        nodeFromCache.setValue(e8);
        return nodeFromCache;
    }

    protected int getMaximumCacheSize() {
        return this.maximumCacheSize;
    }

    protected AbstractLinkedList.Node<E> getNodeFromCache() {
        int i7 = this.cacheSize;
        if (i7 == 0) {
            return null;
        }
        AbstractLinkedList.Node<E> node = this.firstCachedNode;
        this.firstCachedNode = node.next;
        node.next = null;
        this.cacheSize = i7 - 1;
        return node;
    }

    protected boolean isCacheFull() {
        return this.cacheSize >= this.maximumCacheSize;
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    protected void removeAllNodes() {
        int iMin = Math.min(this.size, this.maximumCacheSize - this.cacheSize);
        AbstractLinkedList.Node<E> node = this.header.next;
        int i7 = 0;
        while (i7 < iMin) {
            AbstractLinkedList.Node<E> node2 = node.next;
            addNodeToCache(node);
            i7++;
            node = node2;
        }
        super.removeAllNodes();
    }

    @Override // org.apache.commons.collections4.list.AbstractLinkedList
    protected void removeNode(AbstractLinkedList.Node<E> node) {
        super.removeNode(node);
        addNodeToCache(node);
    }

    protected void setMaximumCacheSize(int i7) {
        this.maximumCacheSize = i7;
        shrinkCacheToMaximumSize();
    }

    protected void shrinkCacheToMaximumSize() {
        while (this.cacheSize > this.maximumCacheSize) {
            getNodeFromCache();
        }
    }

    public NodeCachingLinkedList(Collection<? extends E> collection) {
        super(collection);
        this.maximumCacheSize = 20;
    }

    public NodeCachingLinkedList(int i7) {
        this.maximumCacheSize = i7;
        init();
    }
}
