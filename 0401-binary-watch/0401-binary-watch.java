class Solution {

    private Set<String> permutations;

    private String getTimeStr(int hours, int minutes) {
        int hr = hours;
        int mn = minutes;

        StringBuilder time = new StringBuilder();

        time.append(hr);
        time.append(":");

        if(mn <= 9) {
            time.append(0);
        }

        time.append(mn);

        return time.toString();
    }

    private void readBinaryWatchPermutation(int hours, int minutes, int remainingLights) {
        if(hours > 11 || minutes > 59) {
            return;
        }

        if(remainingLights == 0) {
            permutations.add(getTimeStr(hours, minutes));
            return;
        }

        int mask = 0;

        for(int i = 0; i < 4; i++) {
            mask = 1 << i;
            if((hours & mask) == 0) {
                readBinaryWatchPermutation(hours | mask, minutes, remainingLights - 1);
            }
        }

        for(int i = 0; i < 6; i++) {
            mask = 1 << i;
            if((minutes & mask) == 0) {
                readBinaryWatchPermutation(hours, minutes | mask, remainingLights - 1);
            }
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        permutations = new HashSet<>();

        readBinaryWatchPermutation(0, 0, turnedOn);

        List<String> res = new ArrayList<>();
        for(String time : permutations) {
            res.add(time);
        }

        return res;
    }
}