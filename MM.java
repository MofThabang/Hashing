int N = 1 << 20;
List<String> keys = new ArrayList<>();

for (int i = 0; i < N; i++) {
    keys.add(String.valueOf(i));
}

Collections.shuffle(keys);

String[] keyArray = new String[N];
String[] valueArray = new String[N];

for (int i = 0; i < N; i++) {
    keyArray[i] = keys.get(i);
    valueArray[i] = String.valueOf(i + 1);
}
m = (int)(N / alpha);
long start = System.currentTimeMillis();

// perform lookups

long end = System.currentTimeMillis();
double seconds = (end - start) / 1000.0;
int repetitions = 30;
double total = 0;

for (int r = 0; r < repetitions; r++) {
    long start = System.currentTimeMillis();

    for (int i = 0; i < numSearches; i++) {
        hash.lookup(keyArray[i]);
    }

    long end = System.currentTimeMillis();
    total += (end - start) / 1000.0;
}

double average = total / repetitions;

