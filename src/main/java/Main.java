public class Passenger {
    private int passportNum;
    private String name;
    private Boolean permPass;
    private int km;

    public int getPassportNum() { 
        return passportNum; }
    public void setPassportNum(int n) { 
        passportNum = n; }

    public String getName() { 
        return name; }
    public void setName(String n) { 
        name = n; }

    public Boolean getPermPass() {
        return permPass; }
    public void setPermPass(Boolean p) {
        permPass = p; }

    public int getKm() { 
        return km; 
    }
    public void setKm(int k) {
        km = k;
    }
}

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T v) { 
        value = v; 
    }
    public T getValue() {
        return value; 
    }
    public Node<T> getNext() {
        return next; 
    }
    public void setNext(Node<T> n) {
        next = n;
    }
}

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void insert(T x) {
        Node<T> n = new Node<>(x);
        if (head == null) head = n;
        else tail.setNext(n);
        tail = n;
        size++;
    }

    public T remove() {
        if (head == null) return null;
        T v = head.getValue();
        head = head.getNext();
        if (head == null) tail = null;
        size--;
        return v;
    }

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public void removeSpecific(T obj) {
        Node<T> prev = null;
        Node<T> curr = head;
        while (curr != null) {
            if (curr.getValue().equals(obj)) {
                if (prev == null) head = curr.getNext();
                else prev.setNext(curr.getNext());
                if (curr == tail) tail = prev;
                size--;
                return;
            }
            prev = curr;
            curr = curr.getNext();
        }
    }
}

public class Flight {

    private String flightNum;
    private Node<Passenger> passengers;
    private Node<Passenger> passTail;
    private int capacity;
    private int km;
    private Queue<Passenger> waiting;

    // (1) addPassenger
    public boolean addPassenger(Passenger p) {
        if (capacity > 0) {
            Node<Passenger> n = new Node<>(p);
            if (passengers == null) passengers = n;
            else passTail.setNext(n);
            passTail = n;
            capacity--;
            p.setKm(p.getKm() + km);
            if (p.getKm() >= 20000) p.setPermPass(true);
            return true;
        }
        waiting.insert(p);
        return false;
    }

    // (2) removePassenger
    public boolean removePassenger(int passport) {
        Node<Passenger> prev = null;
        Node<Passenger> curr = passengers;

        while (curr != null) {
            if (curr.getValue().getPassportNum() == passport) {
                if (prev == null) passengers = curr.getNext();
                else prev.setNext(curr.getNext());
                if (curr == passTail) passTail = prev;
                capacity++;
                return true;
            }
            prev = curr;
            curr = curr.getNext();
        }
        return false;
    }

    // (3) promoteFromWaiting
    public boolean promoteFromWaiting() {
        if (waiting.isEmpty()) return false;

        Passenger best = null;
        Passenger temp;
        int size = waiting.size();

        for (int i = 0; i < size; i++) {
            temp = waiting.remove();
            if (temp.getPermPass()) {
                if (best == null || temp.getKm() > best.getKm())
                    best = temp;
            }
            waiting.insert(temp);
        }

        if (best != null) waiting.removeSpecific(best);
        else best = waiting.remove();

        addPassenger(best);
        return true;
    }
}

// (4) סעיף א
public static boolean assignFlight(Flight[] flights, Passenger p) {
    if (p.getPermPass()) 
        return false;

    Flight best = null;

    for (Flight f : flights) {
        if (p.getKm() + f.km >= 20000) {
            if (best == null || f.km < best.km)
                best = f;
        }
    }

    if (best == null) return false;

    p.setKm(p.getKm() + best.km);
    if (p.getKm() >= 20000) p.setPermPass(true);

    best.addPassenger(p);
    return true;
}

// (5) סעיף ב
public static boolean cancelAndPromote(Flight[] flights, int index, Passenger p) {
    if (index < 0 || index >= flights.length) return false;

    Flight f = flights[index];

    boolean removed = f.removePassenger(p.getPassportNum());
    if (!removed) return false;

    p.setKm(p.getKm() - f.km);
    if (p.getKm() < 20000) p.setPermPass(false);

    f.promoteFromWaiting();
    return true;
}
