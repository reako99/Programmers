import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Map<Integer,Integer>> maps = new HashMap<>();
        Map<String, Integer> genrePlays = new HashMap<>();
        for(int i = 0 ; i < genres.length; i++){
            maps.put(genres[i],new HashMap<>());
            genrePlays.put(genres[i],genrePlays.getOrDefault(genres[i],0)+plays[i]);
        }
        for(int i = 0 ; i < genres.length; i++){
            maps.get(genres[i]).put(i,plays[i]);
        }
        List<String>keySetList = new ArrayList<>(genrePlays.keySet());
        keySetList.sort((o1, o2) -> genrePlays.get(o2).compareTo(genrePlays.get(o1)));
        keySetList.forEach(s -> {
            Map<Integer, Integer> music_play = maps.get(s);
            List<Integer> musics = new ArrayList<>(music_play.keySet());
            musics.sort((o1,o2) -> music_play.get(o2).compareTo(music_play.get(o1)));
            if(musics.size()<=1){
                answer.add(musics.get(0));
            }else{
                answer.add(musics.get(0));
                answer.add(musics.get(1));
            }
        });
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}