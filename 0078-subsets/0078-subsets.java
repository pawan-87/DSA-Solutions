class Solution {
    private Set<List<Integer>> subsetsSet;

    private void subsetsUtil(int index, ArrayList<Integer> subset, int[] nums) {
        if(index >= nums.length) {
            subsetsSet.add(List.copyOf(subset));
            return;
        }

        subset.add(nums[index]);
        subsetsUtil(index + 1, subset, nums);
        subset.remove(subset.size() - 1);

        subsetsUtil(index + 1, subset, nums);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        subsetsSet = new HashSet<>();

        ArrayList<Integer> subset = new ArrayList<>();

        subsetsUtil(0, subset, nums);

        List<List<Integer>> subsetsRes = new ArrayList<>();
        for(List<Integer> sb : subsetsSet) {
            subsetsRes.add(sb);
        }

        return subsetsRes;
    }
}