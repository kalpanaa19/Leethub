class Solution:
    def maxScore(self, nums: List[int]) -> int:
        operations = len(nums) // 2

        @cache
        def dp(arr, k):
            if k == operations + 1: return 0
            output = 0
            for i in range(len(arr)):
                for j in range(i + 1, len(arr)):
                    score = k * gcd(arr[i], arr[j])
                    new_arr = tuple(arr[:i] + arr[i + 1: j] + arr[j + 1:])
                    output = max(output, score + dp(new_arr, k + 1))
            return output

        return dp(tuple(nums), 1)