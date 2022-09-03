package com.dale;

public interface ICRUD {
    public Object add();

    public int update(Object obj);

    public int delete(Object obj);

    public void select(Object obj);
}
