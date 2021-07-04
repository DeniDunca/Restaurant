package business;

import data.Serializer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @invariant menuItems != null and temporary != null
 */
public class DeliveryService implements Serializable,IDeliveryServiceProcessing {

    private HashMap<Order, ArrayList<MenuItem>> hashMap;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private ArrayList<MenuItem> temporary = new ArrayList<>();
    private Serializer serializer = new Serializer();

    public DeliveryService()
    {
        hashMap = new HashMap<>();

    }

    @Override
    public ArrayList<MenuItem> importProducts(String fileName) {
        assert fileName != null;
        Pattern pattern = Pattern.compile(",");
        try (Stream<String> line = Files.lines(Path.of(fileName))){
            menuItems = line.skip(1).map(line1->{
                String[] attrib = pattern.split(line1);
                return new BaseProduct(
                        attrib[0],
                        Double.parseDouble(attrib[1]),
                        Integer.parseInt(attrib[2]),
                        Integer.parseInt(attrib[3]),
                        Integer.parseInt(attrib[4]),
                        Integer.parseInt(attrib[5]),
                        Integer.parseInt(attrib[6]));
            }).distinct().collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return menuItems;
    }

    @Override
    public void addMenuItem(MenuItem menuItem) {
        assert menuItem != null;
        menuItems.add(menuItem);
        assert menuItems.contains(menuItem);
    }

    @Override
    public void deleteMenuItem(String title) {
        assert title != null;
        MenuItem item = null;
        for(MenuItem m : menuItems)
        {
            String nume = m.getTitle();
            if(title.equals(nume))
            {
                item = m;
            }
        }
        menuItems.remove(item);
        assert !menuItems.contains(item);
    }

    @Override
    public void editMenuItem( MenuItem menuItem) throws Exception {
        assert menuItem != null;
        if(menuItem.getTitle().equals(""))
        {
            throw new Exception("Not a product selected");
        }
        for(MenuItem m : menuItems)
        {
            if(m.getTitle().equals(menuItem.getTitle()))
            {
                if(menuItem.getCalories() != -1)
                {
                    m.setCalories(menuItem.getCalories());
                }
                if(menuItem.getFats() != -1)
                {
                    m.setFats(menuItem.getFats());
                }
                if(menuItem.getProteins() != -1)
                {
                    m.setProteins(menuItem.getProteins());
                }
                if(menuItem.getRating() != -1)
                {
                    m.setRating(menuItem.getRating());
                }
                if(menuItem.getSodium() != -1)
                {
                    m.setSodium(menuItem.getSodium());
                }
                if(menuItem.getPrice() != -1)
                {
                    m.setPrice(menuItem.getPrice());
                }
            }
        }
        assert isWellFormed();
    }

    @Override
    public void createOrder(int id, LocalDateTime date, String name) {
        assert id != -1 && date != null && name != null;
        Order order = new Order(id,name, date);
        ArrayList<MenuItem> list = new ArrayList<>();
        hashMap.put(order, list);
        assert hashMap.containsKey(order) && hashMap.containsValue(list);
    }

    @Override
    public void addItemToOrder(MenuItem menuItem, Order order)
    {
        assert menuItem != null && order != null;
        ArrayList<MenuItem> menu = hashMap.get(order);
        menu.add(menuItem);
        hashMap.put(order, menu);
        assert hashMap.containsKey(order) && hashMap.containsValue(menu);
    }

    @Override
    public void sendOrder(Order order)
    {
        assert order != null;
        for(Order o : hashMap.keySet())
        {
            if(o.getId() == order.getId())
            {
                ArrayList<MenuItem> m  = hashMap.get(o);
                m.forEach(System.out::println);
            }
        }
    }
    @Override
    public MenuItem getMenu(String title)
    {
        assert title != null;
        for(MenuItem m : menuItems)
        {
            if(title.equals(m.getTitle()))
            {
                return m;
            }
        }
        return null;
    }

    @Override
    public Order getOrder(int idOrder)
    {
        assert idOrder != -1;
        for(Order o : hashMap.keySet())
        {
            if(idOrder == o.getId())
            {
                return o;
            }
        }
        return null;
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public int computePrice(Order order)
    {
        assert order != null;
        int price = 0;
        for(HashMap.Entry<Order, ArrayList<MenuItem>> e : hashMap.entrySet())
        {
            Order key = e.getKey();
            ArrayList<MenuItem> val = e.getValue();
            if(key.equals(order))
            {
                for(MenuItem m : val)
                {
                    price = price + m.getPrice();
                }
            }
        }
        return price;
    }

    @Override
    public ArrayList<MenuItem> doSearch(String title, String rating, String proteins, String calories, String fats, String sodium, String price) {
        assert title != null && rating != null && proteins != null && calories != null && fats != null && sodium != null && price != null;
        ArrayList<MenuItem> m = menuItems;
        m = m.stream()
            .filter(field -> field.getTitle().contains(title))
            .filter(field -> rating.equals("") || field.getRating() == Double.parseDouble(rating))
            .filter(field -> calories.equals("") || field.getCalories() == Integer.parseInt(calories))
            .filter(field -> proteins.equals("") || field.getProteins() == Integer.parseInt(proteins))
            .filter(field -> fats.equals("") ||field.getFats() == Integer.parseInt(fats) )
            .filter(field -> sodium.equals("") || field.getSodium() == Integer.parseInt(sodium))
            .filter(field -> price.equals("") ||field.getPrice() == Integer.parseInt(price))
            .collect(Collectors.toCollection(ArrayList::new));
        m.forEach(System.out::println);
        return m;
    }

    public ArrayList<Order> getOrders(){
        return new ArrayList<>(hashMap.keySet());
    }

    private boolean isWellFormed() {
        for (Order key : hashMap.keySet()) {
            if (!key.equals(hashMap.keySet())) return false;
        }
        return true;
    }

    @Override
    public void report1(int date1, int date2)
    {
        Model model = new Model();
        assert date1 != -1 && date2 != -1;
        ArrayList<Order> o = getOrders();
        o = o.stream()
            .filter(s ->  s.getDate().getHour() > date1 && s.getDate().getHour() < date2)
            .collect(Collectors.toCollection(ArrayList::new));
        model.showReport1(o, "Report1.txt");
    }

    @Override
    public void report2(int number)
    {
        Model model = new Model();
        assert number != -1;
        ArrayList<MenuItem> menu = numberOfTimes();
        Map<MenuItem, Long> counters = menu.stream()
                .collect(Collectors.groupingBy(m -> m, Collectors.counting()));
        ArrayList<MenuItem> m = new ArrayList<>();

        for (Map.Entry<MenuItem, Long> entry : counters.entrySet())
        {
            if(entry.getValue() == number)
            {
                m.add(entry.getKey());
            }
        }
        model.showReport2(m, "Report2.txt");
    }

    @Override
    public void report3(int numberTimes, int amount)
    {
        Model model = new Model();
        assert numberTimes != -1 && amount != -1;
        ArrayList<Order> o = getOrders();
        Map<String, Long> counters = o.stream()
                .collect(Collectors.groupingBy(Order::getName, Collectors.counting()));
        ArrayList<String> or = new ArrayList<>();
        for (Map.Entry<String, Long> entry : counters.entrySet()) {
            if(entry.getValue() >= numberTimes)
            {
                or.add(entry.getKey());
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for(Order order : o)
        {
            for(String orr : or)
            {
                if(order.getName().equals(orr))
                {
                    if(computePrice(order) > amount)
                    {
                        if(!list.contains(orr))
                        {
                            list.add(orr);
                        }
                    }
                }
            }
        }
        model.showReport3(list,"Report3.txt");
    }

    @Override
    public void report4(int specifiedDate)
    {
        Model model = new Model();
        assert specifiedDate != -1;
        ArrayList<Order> o = getOrders();
        o = o.stream()
           .filter(s -> s.getDate().getDayOfMonth() == specifiedDate)
           .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<MenuItem> menu = number(o);
        Map<MenuItem, Long> counters = menu.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        model.showReport4(counters, "Report4.txt");
    }

    @Override
    public void temporaryComposite(String title)
    {
        assert title != null;
        for(MenuItem m: menuItems)
        {
            if(m.getTitle().equals(title));
            {
                temporary.add(m);
                break;
            }
        }
    }

    @Override
    public void saveComposite(String title)
    {
        assert title != null;
        MenuItem menuItem = new CompositeProduct(title,0,0,0,0,0,0);
        for(MenuItem m : temporary)
        {
            menuItem.add(m);
        }
        menuItems.add(menuItem);
        assert menuItems.contains(menuItem);
    }

    @Override
    public void generateBill(int idOrder)
    {
        assert idOrder != -1;
        Order o = getOrder(idOrder);

        File file = new File("Order.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        FileWriter filewriter;
        BufferedWriter bufferedwriter = null;
        try {
            filewriter = new FileWriter(file.getAbsoluteFile());
            bufferedwriter = new BufferedWriter(filewriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String bill = "_________BILL_________\r\n\r\n DATA: " + o.getDate() +
                "\r\n\r\n Order Id: " + o.getId() + "\r\n\r\n The client: " + o.getName()
                +"\r\n\r\n has ordered: "+ getOrderedProductsName(o) + "\r\n\r\n Price: " + computePrice(o);
        try {
            bufferedwriter.write(bill);
            bufferedwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * metoda folosita pentru a adauga toate elementele dintr-un order intr-o lista
     * @param order
     * @return o noua lista de orderuri
     */
    public ArrayList<MenuItem> number(ArrayList<Order> order)
    {
        ArrayList<MenuItem> newList = new ArrayList<>();
        for(Order o : hashMap.keySet())
        {
            for(Order ok : order)
            {
                if(o.getId() == ok.getId())
                {
                    ArrayList<MenuItem> m = hashMap.get(o);
                    newList.addAll(m);
                }
            }
        }
        return newList;
    }

    /**
     * metoda care pune in lista doar numele produselor si este folosita pentru a determina numarul de comenzi dintr-un produs
     * @return lista de produse
     */
    public ArrayList<MenuItem> numberOfTimes()
    {
        ArrayList<MenuItem> newList = new ArrayList<>();
        for (Order o : hashMap.keySet())
        {
            ArrayList<MenuItem> m = hashMap.get(o);
            newList.addAll(m);
        }
        return newList;
    }

    /**
     * metoda care adauga la un string numele tutoror produselor care au fost comandate
     * @param order
     * @return sirul de produse
     */
    public String getOrderedProductsName(Order order)
    {
        String names = "";
        for(Order o : hashMap.keySet())
        {
            if(o.getId() == order.getId())
            {
                ArrayList<MenuItem> m  = hashMap.get(o);
                for(MenuItem menu : m)
                {
                    names = names + menu.getTitle() + "| ";
                }
            }
        }
        return names;
    }


}
