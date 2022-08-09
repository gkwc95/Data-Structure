public int numFactoredBinaryTrees(int[] arr) {
    int M = 1000000007;
    Arrays.sort(arr);
    Map<Integer, Long> map = new HashMap<>();
    for (int a : arr){
        long tmp = 1L;
        for (int b : arr){
            if (b>a) break;
            if (a % b == 0 && map.containsKey(a/b)){
                tmp += (map.get(b) * map.get(a/b));
            }
        }
        map.put(a, tmp);
    }
    long sum = 0;
    for (long tmp : map.values())
        sum = (sum + tmp)%M;
    return (int) sum;
}
