package com.fhh.bxgu.entity;
//一个简单的工具类型。
public class Pair<K,V> {
    public K key;
    public V value;
    public Pair(K k,V v) {
        key = k;
        value = v;
    }
}
