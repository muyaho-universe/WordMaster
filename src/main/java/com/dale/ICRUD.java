package com.dale;

public interface ICRUD {
    public Object add();

    public int update(Object obj);

    public void delete();

    public void select(Object obj);
}
