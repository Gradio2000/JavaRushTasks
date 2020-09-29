package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.Solution;
import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;


public class CachingProxyRetriever implements Retriever{
    OriginalRetriever originalRetriever;
    LRUCache lruCache = new LRUCache(10);

    public CachingProxyRetriever(Storage storage) {
        this.originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object o;
        if (lruCache.find(id) != null){
            return lruCache.get(id);
        }
        else {
            o = originalRetriever.retrieve(id);
            lruCache.set(id, o);
            return o;
        }
    }
}
