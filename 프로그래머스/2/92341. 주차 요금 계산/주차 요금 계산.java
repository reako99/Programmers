import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String,Integer> parkingTime = new HashMap<>();
        Map<String,Integer> inTime = new HashMap<>();
        for(int i = 0 ; i < records.length ; i++){
            String[] record = records[i].split(" ");
            if(inTime.containsKey(record[1])&&record[2].equals("OUT")){
                parkingTime.put(record[1],parkingTime.getOrDefault(record[1],0)+(Integer.valueOf(record[0].split(":")[0])*60+Integer.valueOf(record[0].split(":")[1]))-inTime.get(record[1]));
                inTime.remove(record[1]);
            }else if(record[2].equals("IN")){
                inTime.put(record[1],Integer.valueOf(record[0].split(":")[0])*60+Integer.valueOf(record[0].split(":")[1]));
            }
        }
        Iterator<String> iter = inTime.keySet().iterator();
        while(iter.hasNext()){
            String car = iter.next();
            parkingTime.put(car,parkingTime.getOrDefault(car,0)+(24*60-1-inTime.get(car)));
        }
        List<String> carList = new ArrayList<>(parkingTime.keySet());
        List<Integer> feeList = new ArrayList<>();
        carList.sort(Comparator.naturalOrder());
        carList.forEach(s -> {
            Integer time = parkingTime.get(s);
            int fee = 0;
            if(time<=fees[0]){
                fee=fees[1];
            }else{
                fee=fees[1]+(time-fees[0])/fees[2]*fees[3];
                if((time-fees[0])%fees[2]!=0){
                    fee+=fees[3];
                }
            }
            feeList.add(fee);
        });
        return feeList.stream().mapToInt(i->i).toArray();
    }
    
}