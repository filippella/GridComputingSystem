/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.dao;

import gridcomputingsystem.model.Job;
import java.util.List;

/**
 *
 * @author Filippo-TheAppExpert
 *
 * ItemDAO.java is the high level of abstraction of an Item manipulation in a
 * database
 *
 * @param <T> Generic type which can be {@link Resource} or {@link Job}
 */
public interface ItemDAO<T> {

    /**
     * This method is responsible for adding item type T values into the
     * database
     *
     * @param item can be {@link Resource} or {@link Job}
     */
    void addItem(T item);

    /**
     * This method is responsible for removing an item from the database based
     * on an item type
     *
     * @param item can be {@link Resource} or {@link Job}
     */
    void removeItem(T item);

    /**
     * This method is responsible to retrieve all the values from database and
     * assign into an {@link ArrayList<T>} object which T stands for {@link Job}
     * or {@link Resource} based on an {@link ItemType}
     *
     * @param type The type of the item
     * @return {@link ArrayList<T>} of an object T which can be {@link Job} or
     * {@link Resource}
     */
    List<T> getAllItems(ItemType type);

    /**
     * This method is used to update an element of the database based on an
     * object type And from the object it refers the object id
     * Example:{@link Job#getJobId()}
     *
     * @param item can be {@link Resource} or {@link Job}
     */
    void updateItem(T item);

    /**
     * This method is used to search an item from the database based on a given
     * keyword
     *
     * @param type can be {@link Resource} or {@link Job}
     * @param keyword The string passed as a keyword
     *
     * @return true if the item is found from the given keyword
     */
    boolean searchItem(ItemType type, String keyword);

    /**
     * This method is used to empty the list of the items saved into the
     * database
     *
     * @param type can be {@link Resource} or {@link Job}
     */
    void emptyItems(ItemType type);

    /**
     * ItemType.java exist for making a separation of concerns of object based
     * on item type
     */
    enum ItemType {

        JOB, RESOURCE
    }
}
