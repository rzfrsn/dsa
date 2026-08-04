/**
 * Pattern : Binary Search — largest timestamp <= target
 * Time : O(log n) | Space : O(n)
 * LeetCode 981 - Time Based Key-Value Store
 */
class TimeMap {
    private Map<String, List<Integer>> timestamps;
    private Map<String, List<String>> values;

    public TimeMap() {
        timestamps = new HashMap<>();
        values = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timestamps.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
        values.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public String get(String key, int timestamp) {
        if(!timestamps.containsKey(key)) return "";

        List<Integer> times = timestamps.get(key);
        List<String> vals = values.get(key);

        int resultIdx = -1;
        int left = 0, right = times.size() - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(times.get(mid) <= timestamp) {
                resultIdx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return resultIdx != -1 ? vals.get(resultIdx) : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
