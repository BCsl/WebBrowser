package com.moe.utils;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.security.Key;

public class LinkedListMap<K extends Object,V extends Object>
{
	private ArrayList<K> key;
	private ArrayList<V> value;
	public LinkedListMap(){
		key=new ArrayList<>();
		value=new ArrayList<>();
	}
	public int indexKey(K k){
		return key.indexOf(k);
	}
	public int indexValue(V v){
		return value.indexOf(v);
	}
	
	public void clear()
	{
		key.clear();
		value.clear();
	}

	public boolean containsKey(Object p1)
	{
		return key.contains(p1);
	}

	public boolean containsValue(Object p1)
	{
		return value.contains(p1);
	}

	
	public V getKey(K p1)
	{
		int index=key.indexOf(p1);
		if(index==-1)return null;
		return value.get(index);
	}
	public V getIndex(int index){
		return value.get(index);
	}
	public boolean isEmpty()
	{
		return key.isEmpty();
	}

	
	public V put(K p1, V p2)
	{
		int index=key.indexOf(p1);
		if(index!=-1){
			key.remove(index);
			value.remove(index);
			key.add(index,p1);
			value.add(index,p2);
		}else{
		key.add(p1);
		value.add(p2);
		}
		return p2;
	}
	public V put(int index,K k,V v){
		key.add(index,k);
		value.add(index,v);
		return v;
	}
	
	public void putAll(Map<? extends K, ? extends V> p1)
	{
		Iterator<K> iterator=(Iterator<K>)p1.keySet().iterator();
		while(iterator.hasNext()){
			K k=iterator.next();
			 put(k,p1.get(k));
		}
	}

	public int removeKey(K p1)
	{
		int index=key.indexOf(p1);
		if(index==-1)return -1;
		key.remove(index);
		value.remove(index);
		return index;
	}
	public int removeValue(V v){
		int index=value.indexOf(v);
		if(index==-1)return -1;
		key.remove(index);
		value.remove(index);
		return index;
	}
	public V remove(K k){
		int index=key.indexOf(k);
		if(index==-1)return null;
		key.remove(index);
		return value.remove(index);
	}
	public int size()
	{
		return key.size();
	}

	
}
