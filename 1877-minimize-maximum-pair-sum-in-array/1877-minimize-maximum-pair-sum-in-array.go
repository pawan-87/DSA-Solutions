func minPairSum(nums []int) int {
    n := len(nums)

    sort.Ints(nums)

    minimizedMaximumPairSum := 0;

    for i := 0; i < n/2; i++ {
        sum := nums[i] + nums[n - i - 1]
        if minimizedMaximumPairSum < sum {
            minimizedMaximumPairSum = sum
        }
    }

    return minimizedMaximumPairSum
}