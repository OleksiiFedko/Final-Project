package com.epamhotel.model.dao.impldao;

import java.util.List;

public interface GenericDao<T> {

    /**
     * get all items of type T from given table
     * @return generic List
     */
    List<T> getAllItems();

    /**
     * delete check with given id
     * @param item
     */
    void deleteItem(T item);

    /**
     * update item with given id
     * @param item
     */
    void updateItem(T item);

    /**
     * get item by it primary key
     * @param key
     * @return item of T type
     */
    T getByKey(int key);

    /**
     * create new item in table
     * @param item
     */
    void insertItem(T item);
}
