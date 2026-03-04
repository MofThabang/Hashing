public class chainedHash {

    private class Node {
        String key;
        String value;
        Node next;

        Node(String k, String v) {
            key = k;
            value = v;
        }
    }

    private Node[] table;
    private int m;
private int hash(String key) {
    int h = Math.abs(key.hashCode());
    return (h % m) + 1;
}
  public void insert(String key, String value) {
    int i = hash(key);

    Node head = table[i];

    if (head == null) {
        table[i] = new Node(key, value);
        return;
    }

    Node current = head;
    Node prev = null;

    while (current != null) {
        if (current.key.equals(key)) {
            current.value = value;
            return;
        }
        prev = current;
        current = current.next;
    }

    prev.next = new Node(key, value);
}
  public String lookup(String key) {
    int i = hash(key);
    Node current = table[i];

    while (current != null) {
        if (current.key.equals(key))
            return current.value;
        current = current.next;
    }

    return null;
}
