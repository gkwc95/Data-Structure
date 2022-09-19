class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> store = new HashMap<>();
        for (String path : paths){
            String[] arr = path.split(" ");
            String directory = arr[0];
            for (int i = 1; i < arr.length; i++){
                String fileName = arr[i].substring(0, arr[i].indexOf("("));
                String content = arr[i].substring(arr[i].indexOf("(")+1, arr[i].length()-1);
                List<String> filePaths = store.getOrDefault(content, new ArrayList<>());
                filePaths.add(directory + "/" + fileName);
                store.put(content, filePaths);
            }
        }
        
        store.entrySet().removeIf(entry->entry.getValue().size() <= 1);
        return new ArrayList<>(store.values());
    }
}
