import java.util.Arrays;

class Solution00053 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        //check if all non-positive
        // then select max value;
        int result = checkMaxNegativeOrCompact(nums);
        if (result <= 0) return result;

        len = result; // must be odd number >= 1;
        if (len == 1) {
            return nums[0];
        }

        //run the search
        result = 0;
        int max = 0;
        for (int size = 1; size < len; size += 2) {
            for (int pos = 0; pos <= (len - size); pos += 2) {
                for (int i = pos; i < (pos + size); i++) {
                    result += nums[i];
                }
                if (max < result) max = result;
                result = 0;
            }
        }
        return max;
    }

    private int checkMaxNegativeOrCompact(int[] n) {
        int runningSum = 0;
        int chunkStart = 0;

        int max = n[0];
        int len = n.length;
        int i = 0;
        while (i < len && n[i] <= 0) {
            if (max < n[i]) max = n[i];
            i++;
        }

        if (i == len) return max;

        // start new group
        int groupSum = n[i];
        int arrayIndex = i+1;
        int groupPos = 0;
        int groupSign = 1;
        runningSum = 0;
        while (arrayIndex < len) {
            if (n[arrayIndex] * groupSign >= 0) {
                //group continues
                groupSum += n[arrayIndex];
            } else {
                //save group sum
                n[groupPos] = groupSum;
                groupPos++;
                groupSign *= -1;
                groupSum = n[arrayIndex];
                runningSum += groupSum;
            }
            arrayIndex++;
        }

        //last group was positive
        if (groupSign > 0) {
            n[groupPos] = groupSum;
            groupPos++;
            runningSum += groupSum;
        }
        return groupPos;
    }

    //region tests
    static int[][] tests = {
            { -2, 1, -3, 4, -1, 2, 1, -5, 4 },
            { 1 },
            { 5, 4, -1, 7, 8 },
            {
                    -32,-54,-36,62,20,76,-1,-86,-13,38,-58,-77,17,38,-17,43,32,-88,-19,-70,95,0,-64,75,15,-87,-26,69,-95,
                    -65,-18,-28,-43,22,-88,54,-25,-13,67,61,-74,-91,60,42,24,-80,-15,-44,-91,42,-38,-96,-58,-3,55,33,-13,
                    -71,2,-9,-60,60,39,-26,-41,50,-72,33,-62,94,-28,-37,79,-68,81,3,-71,-57,35,-63,61,96,-83,-97,-29,48,
                    35,57,76,-86,-52,92,50,86,-34,85,14,-30,18,51,-36,66,90,-79,75,48,0,-96,67,-64,-83,28,-91,-90,30,-44,
                    57,-58,-87,10,-68,-63,-21,81,-76,45,66,14,-85,-39,-58,-44,-95,-68,-47,79,56,52,59,23,64,75,-49,50,61,
                    57,-94,-5,98,95,81,-70,-68,-40,87,-68,-95,30,45,96,90,86,-71,94,94,-19,50,27,-90,9,-50,51,-39,-23,-22,
                    -78,-66,-17,-7,-68,-22,-26,-62,-13,34,-75,18,38,54,-36,11,22,-73,39,-7,98,96,-56,25,83,52,75,34,-86,
                    -48,-88,-88,-14,-29,5,-6,26,78,9,-87,12,10,30,-72,-58,70,15,63,97,-68,-67,95,-72,-24,20,-89,-94,-28,
                    21,-81,1,32,-93,63,80,11,-43,6,-33,42,18,78,-47,-75,82,-6,95,-25,-66,69,6,-57,41,10,19,-62,21,1,10,
                    -81,19,-89,28,2,73,8,-86,-93,-86,-20,49,8,-65,78,32,94,-51,27,-31,-41,-27,51,1,-86,-39,96,-48,58,-3,
                    38,77,92,25,5,-5,-25,89,-15,-42,79,41,83,-13,52,61,-81,23,86,23,68,-55,72,19,23,86,80,19,-85,38,93,
                    29,-8,85,-46,73,-43,5,62,41,62,41,-41,23,-72,-88,-39,-76,34,-52,23,-20,-31,-5,98,91,-19,78,-12,-28,
                    -6,-19,-99,85,-34,-69,59,0,12,-2,-82,-25,-60,-23,74,-56,-35,-65,-33,75,-18,89,-45,51,-38,-46,19,42,
                    -91,-93,91,-21,-13,91,-35,30,99,-99,-70,11,-2,-53,62,14,0,36,58,64,48,-98,40,-70,68,71,57,-70,-75,
                    -23,48,-89,-17,39,-11,70,8,30,-23,-16,7,6,94,82,29,34,-4,-70,-53,-69,70,94,-67,-13,-98,77,-41,58,-93,
                    -40,-88,31,-30,-5,-29,36,-58,55,-34,18,-84,73,-99,86,32,29,20,-72,35,67,-64,6,38,-55,92,39,-78,-72,-2,
                    -95,-12,9,35,34,80,82,-30,-78,14,13,16,29,-37,16,16,94,-54,-87,98,57,56,-66,-37,-5,-22,-44,-66,-24,
                    -17,8,-20,47,94,92,-18,51,74,28,50,-11,-59,-34,94,-20,59,10,-26,-95,23,-27,61,-21,-17,-98,50,38,-66
            }
    };
    //endregion
    public static void main(String[] args) {
        var solution = new Solution00053();
        for (int i = 0; i < tests.length; i++) {
        System.out.println("Running test case: " + i);
            runCase(solution, tests[i]);
        }
//        runCase(solution, tests[0]);
    }

    private static void runCase(Solution00053 sol, int[] input) {
        System.out.println("  Input:");
        System.out.println(Arrays.toString(input));
        System.out.println("  Result:");
        System.out.println(sol.maxSubArray(input));
    }
}
