public class openHash {

    private class Entry {
        String key;
        String value;
        boolean deleted;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
            this.deleted = false;
        }
    }

    private Entry[] table;   // table[0] unused
    private int m;           // table size
    private int size;        // number of active elements

    // Constructor
    public openHash(int m) {
        this.m = m;
        this.table = new Entry[m + 1];  // index range [1..m]
        this.size = 0;
    }

    // Hash function → uniform distribution
    private int hash(String key) {
        int h = key.hashCode();
        h = Math.abs(h);
        return (h % m) + 1;  // ensure [1..m]
    }

    // Insert key-value pair
    public void insert(String key, String value) {
        if (isFull())
            return;

        int i = hash(key);

        while (table[i] != null && !table[i].deleted) {

            if (table[i].key.equals(key)) {
                table[i].value = value;  // update existing
                return;
            }

            i = (i % m) + 1;  // linear probing
        }

        table[i] = new Entry(key, value);
        size++;
    }

    // Lookup value by key
    public String lookup(String key) {

        int i = hash(key);

        while (table[i] != null) {

            if (!table[i].deleted && table[i].key.equals(key))
                return table[i].value;

            i = (i % m) + 1;
        }

        return null;
    }

    // Remove key-value pair
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

    // Check if key exists
    public boolean isInTable(String key) {
        return lookup(key) != null;
    }

    // Check if table is full
    public boolean isFull() {
        return size == m;
    }

    // Check if table empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return number of elements
    public int size() {
        return size;
    }

    // Return table capacity
    public int capacity() {
        return m;
    }
}
