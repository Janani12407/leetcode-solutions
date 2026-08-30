class Solution {
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root);
        for (int num : queries) {
		//if num is present add num else add lower value than num
            Integer low = map.containsKey(num) ? Integer.valueOf(num) : map.lowerKey(num);
		//if num is present add num else add higher value than num
            Integer high = map.containsKey(num) ? Integer.valueOf(num) : map.higherKey(num);
		//if low or high value also not present add -1 else add low or high
            ans.add(Arrays.asList(low == null ? -1 : low, high == null ? -1 : high));
        }
        return ans;
    }

    void helper(TreeNode root) {
        if (root == null) return;
        map.put(root.val, 0);
        helper(root.left);
        helper(root.right);
    }
//The `higherKey()`method class is used to return the least key strictly greater than the given key, or null if there is no such key.
//AND
//The `lowerKey()` method is used to return the greatest key strictly less than to given key, 
}