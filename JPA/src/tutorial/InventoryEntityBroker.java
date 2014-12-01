// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.package tutorial;
package tutorial;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class InventoryEntityBroker {
    EntityManagerFactory factory;
    EntityManager em;

    public InventoryEntityBroker() {
        factory = Persistence.createEntityManagerFactory("InventorySystem", System.getProperties());

        // Create a new EntityManager from the EntityManagerFactory. The
        // EntityManager is the main object in the persistence API, and is
        // used to create, delete, and query objects, as well as access
        // the current transaction
        em = factory.createEntityManager();
    }

    void close() {
        em.close();
        factory.close();
    }

    // Item methods
    public List<InventoryItem> getAllItems() {
        Query q = em.createQuery("SELECT item FROM InventoryItem item ORDER BY item.itemName");

        return (List<InventoryItem>) q.getResultList();
    }

    public InventoryItem getSingleItem(int id) {
        Query q = em.createQuery("SELECT item FROM InventoryItem item WHERE item.id=" + id);
        return (InventoryItem) q.getSingleResult();
    }

    public void addItem(String name, String description, float price, int categoryID)
    {

        InventoryItem item = new InventoryItem();
        item.setItemName(name);
        item.setItemDescription(description);
        item.setItemPrice(price);
        item.setCategory(getSingleCategory(categoryID));

        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    public void updateItem(int id, String name, String description, float price, int categoryID) {

    	InventoryItem item = em.find(InventoryItem.class, id);
        item.setItemName(name);
        item.setItemDescription(description);
        item.setItemPrice(price);
        item.setCategory(getSingleCategory(categoryID));

        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }

    public void deleteItem(int id) {
    	InventoryItem item = em.find(InventoryItem.class, id);

        em.getTransaction().begin();
        em.remove(item);
        em.getTransaction().commit();
    }

//Category Methods
    public List<InventoryCategory> getAllCategories() {
        Query q = em.createQuery("SELECT cat FROM InventoryCategory cat ORDER BY cat.categoryName");

        return (List<InventoryCategory>) q.getResultList();
    }

    public InventoryCategory getSingleCategory(int id) {
        Query q = em.createQuery("SELECT cat FROM InventoryCategory cat WHERE cat.id=" + id);
        return (InventoryCategory) q.getSingleResult();
    }

    public void addCategory(String name, String description)
    {
        InventoryCategory cat = new InventoryCategory();
        cat.setCategoryName(name);
        cat.setCategoryDescription(description);

        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }

    public void updateCategory(int id, String name, String description) {

    	InventoryCategory cat = em.find(InventoryCategory.class, id);
        cat.setCategoryName(name);
        cat.setCategoryDescription(description);

        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
    }

    public void deleteCategory(int id) {
    	InventoryCategory cat = em.find(InventoryCategory.class, id);

        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
    }

    public static void main(String[] args)
    {
    	InventoryEntityBroker broker = new InventoryEntityBroker();
    	broker.addCategory("Eletronics", "Anything that uses eletricity");
    	broker.close();
    }
}
