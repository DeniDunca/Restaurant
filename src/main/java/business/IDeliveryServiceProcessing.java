package business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface IDeliveryServiceProcessing {
    /**
     * Metoda care face import la produsele din fisierul.csv si le pune intr-un arraylist
     * @param string fisierul unde se pune
     * @return lista de menuItems
     * @pre filename valid
     * @post none
     */
    ArrayList<MenuItem> importProducts(String string);

    /**
     * metoda care adauga un produs nou in meniu
     * @param menuItem produs din meniu
     * @pre menuItem != null;
     * @post menuItems.contains(menuItem);
     */
    void addMenuItem(MenuItem menuItem);

    /**
     * metoda care sterge un produs din meniu
     * @param title numele unui produs din meniu
     * @pre title != null;
     * @post !menuItems.contains(item);
     */
    void deleteMenuItem(String title);

    /**
     * metoda care permite administratorului sa editeze oricare field al unui produs deja existent in functie de numele acestuia
     * @param menuItem produsul din meniu ce vrem sa il editam
     * @throws Exception
     * @pre menuItem != null;
     * @post isWellFormed();
     */
    void editMenuItem(MenuItem menuItem) throws Exception;

    /**
     * metoda care creaza un order cu id, numele clientului care a facut comanda, si data la care s-a facut si le pune intr-un
     * hashmap impreuna cu lista de produse
     * @param id id-ul comenzii
     * @param date data la care s-a facut comanda
     * @param name numele clientului
     * @pre  id != -1 && date != null && name != null;
     * @post hashMap.containsKey(order) && hashMap.containsValue(list);
     */
    void createOrder(int id, LocalDateTime date, String name);

    /**
     * metoda care adauga un produs in hashmapul de comenzi
     * @param menuItem produs din meniu
     * @param order o comanda
     * @pre menuItem != null && order != null;
     * @post hashMap.containsKey(order) && hashMap.containsValue(menu);
     */
    void addItemToOrder(MenuItem menuItem, Order order);

    /**
     * verifica daca id orderului este egal cu cel di hashmap si adauga in lista
     * @param order o comanda
     * @pre order != null;
     * @post none
     */
    void sendOrder(Order order);

    /**
     * metoda pentru a alege un produs in functie de numele acestuia
     * @param title numele produsului din meniu
     * @return menuItems || null
     * @pre title != null;
     * @post m || null;
     */
    MenuItem getMenu(String title);

    /**
     * metoda care verifica daca id ul dat ca parametru este egal cu id ul orderului
     * @param idOrder id-ul comenzii
     * @return order || null
     * @pre idOrder != -1;
     * @post o || null
     */
    Order getOrder(int idOrder);

    /**
     * metoda care aduna la pretul total doate preturile produselor dintr un order
     * @param order o comanda
     * @return price
     * @pre order != null;
     * @post none
     */
    int computePrice(Order order);

    /**
     * metoda folosita pentru a face cautarea de produse in functie de diferite filtre folosind lambda si stream
     * @param title numele produsului
     * @param rating ratingul produsului
     * @param proteins proteinele din produs
     * @param calories caloriile din produs
     * @param fats grasimile din produs
     * @param sodium sodiul din produs
     * @param price pretul produsului
     * @return menuItems
     * @pre title != null && rating != null && proteins != null && calories != null && fats != null && sodium != null && price != null;
     * @post none
     */
    ArrayList<MenuItem> doSearch(String title, String rating, String proteins, String calories, String fats, String sodium, String price);

    /**
     * metoda care primeste doua inturi (ore) si care verifica daca sunt comenzi intre orele respective si pune rezultatul in fisier
     * @param date1 prima ora
     * @param date2 a doua ora
     * @pre date1 != -1 && date2 != -1;
     * @post none
     */
    void report1(int date1, int date2);

    /**
     * primeste ca parametru un int si verifica ce produse au fost comandate de mai mult decat numarul dat
     * @param number numarul cu care se face vrificarea
     * @pre number != -1;
     * @post none
     */
    void report2(int number);

    /**
     * primeste ca parametru doua numere, unul pentru numarul de orderuri si al doilea pentru pretul minim
     * @param numberTimes de cate ori vrem sa apara
     * @param amount pretul minim pe care vrem sa il aiba
     * @pre numberTimes != -1 && amount != -1;
     * @post none
     */
    void report3(int numberTimes, int amount);

    /**
     * primeste ca parametru o zi luna sub forma de int si cauta produsele comandate in ziua respectiva si de cate ori au fost comandate
     * @param specifiedDate o zi din luna
     * @pre specifiedDate != -1;
     * @post none
     */
    void report4(int specifiedDate);

    /**
     * metoda care creaza o lista temporara de produse compuse
     * @param title numele produsului
     * @pre title != null;
     * @post none
     */
    void temporaryComposite(String title);

    /**
     * metoda care creaza un produs compus din mai multe produse si il adauga in lista de produse
     * @param title numele produslui
     * @pre title != null
     * @post menuItems.contains(menuItem);
     */
    void saveComposite(String title);

    /**
     * metoda pentru generarea billului si punerea lui in fisierul Order.txt
     * @param idOrder id-ul comenzii
     * @pre idOrder != -1;
     * @post none
     */
    void generateBill(int idOrder);
}
