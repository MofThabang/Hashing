public class openHash {

    private class Entry {
        String key;
        String value;
        boolean deleted;

        Entry(String k, String v) {
            key = k;
            value = v;
            deleted = false;
        }
    }

    private Entry[] table;
    private int m;
    private int size;

    private int hash(String key) {
    int h = key.hashCode();
    h = Math.abs(h);
    return (h % m) + 1;  // indices [1..m]
}
    private int hash(String key) {
    int h = key.hashCode();
    h = Math.abs(h);
    return (h % m) + 1;  // indices [1..m]
}
    public void insert(String key, String value) {
    if (isFull()) return;

    int i = hash(key);

    while (table[i] != null && !table[i].deleted) {
        if (table[i].key.equals(key)) {
            table[i].value = value;
            return;
        }
        i = (i % m) + 1;
    }

    table[i] = new Entry(key, value);
    size++;
}
    public String lookup(String key) {
    int i = hash(key);

    while (table[i] != null) {
        if (!table[i].deleted && table[i].key.equals(key))
            return table[i].value;

        i = (i % m) + 1;
    }
    return null;
}
    public String remove(String key) {
    int i = hash(key);

    while (table[i] != null) {
        if (!table[i].deleted && table[i].key.equals(key)) {
            table[i].deleted = true;
            size--;
            return table[i].value;
        }
        i = (i % m) + 1;
    }
    return null;
}
    public boolean isFull() {
    return size == m;
}

public boolean isEmpty() {
    return size == 0;
}

public boolean isInTable(String key) {
    return lookup(key) != null;
}

  

     
