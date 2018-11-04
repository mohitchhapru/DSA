/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused. 
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 * Example 1:
 * Input: "19:34"
 * Output: "19:39"
 * Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
 * 
 * Example 2:
 * Input: "23:59"
 * Output: "22:22"
 * Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
 */

class nextClosestTime {
    public String getNextClosestMinInHour(String min, int[] arr){
        int unitsDigit = Character.getNumericValue(min.charAt(1));

        for(int i=0; i<4; i++){ // try to get the next digit in the units place
            if(arr[i]>unitsDigit)
                return min.charAt(0) + Integer.toString(arr[i]);   // If YES -> Return
        }

        // if not check the valid number at tens place (it should be between 0-5)
        int tensDigit = Character.getNumericValue(min.charAt(0));
        boolean search = true;
        tensDigit += 1;
        while(search){
            if(tensDigit > 5)
                break;
            // check if the current digit is present in arr
            for(int i=0; i<4; i++){ // try to get the next digit in the units place
                if(arr[i]==tensDigit){
                    search = false;
                    return Integer.toString(tensDigit)+Integer.toString(arr[0]);
                }
            }
            if(search)
                tensDigit += 1;
        }
        return "-1";
    }
    public String getNextClosestHourNextDay(String hr, int[] arr){
        int unitsDigit = Character.getNumericValue(hr.charAt(1));
        int tensDigit = Character.getNumericValue(hr.charAt(0));

        // try to get next hour in same tensDigit
        unitsDigit += 1;
        if(tensDigit<2){ // check from digit to 9
            for(;unitsDigit<=9; unitsDigit++){
                for(int i=0; i<4; i++){ // try to get the next digit in the units place
                    if(arr[i] == unitsDigit)
                        return hr.charAt(0) + Integer.toString(unitsDigit);   // If YES -> Return
                }
            }
        }
        else{ // check from digit to 3
            for(;unitsDigit<=3; unitsDigit++){
                for(int i=0; i<4; i++){ // try to get the next digit in the units place
                    if(arr[i] == unitsDigit)
                        return hr.charAt(0) + Integer.toString(unitsDigit);   // If YES -> Return
                }
            }
        }

        // try to get next tens digit and see if its present in arr
        tensDigit += 1;
        boolean search = true;
        while(search){
            if(tensDigit > 2)
                tensDigit = 0;

            // check if the current digit is present in arr
            for(int i=0; i<4; i++){ // try to get the next digit in the units place
                if(arr[i]==tensDigit){
                    search = false;
                    return Integer.toString(tensDigit)+Integer.toString(arr[0]);
                }
            }
            if(search)
                tensDigit += 1;
        }
        return "-1";

    }
    public String getNextClosestTime(String time) {
        String currentMin = time.split(":")[1];
        String currentHr = time.split(":")[0];

        int[] arr = new int[4];
        arr[0] = Character.getNumericValue(currentMin.charAt(0));
        arr[1] = Character.getNumericValue(currentMin.charAt(1));
        arr[2] = Character.getNumericValue(currentHr.charAt(0));
        arr[3] = Character.getNumericValue(currentHr.charAt(1));
        Arrays.sort(arr);

        String nextClosestMin = getNextClosestMinInHour(currentMin, arr);

        if(!nextClosestMin.equals("-1")){
            return currentHr + ":" + nextClosestMin;
        }

        String nextClosestHr = getNextClosestHourNextDay(currentHr, arr);
        return nextClosestHr+":"+ Integer.toString(arr[0])+ Integer.toString(arr[0]);
    }
}