import java.util.*;

class Main {
    static List<Section> sections = new ArrayList<>();


    static class Section implements Comparator<Section>{
        int section;
        int stoneValue;
        List<String> mineralsList;

        public Section(int section, int stoneValue, List<String> mineralsList) {
            this.section = section;
            this.stoneValue = stoneValue;
            this.mineralsList = mineralsList;
        }

        @Override
        public int compare(Section o1, Section o2) {
            return o2.stoneValue - o1.stoneValue;
        }

    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int allSection = minerals.length / 5 + 1;
        int picksNum = 0;

        picksNum += picks[0] + picks[1] + picks[2];
        int findSection = allSection > picksNum ? picksNum : allSection;

        for(int section = 0; section < findSection; section++) {
            List<String> oneSection = new ArrayList<>();
            for(int i=0; i<5; i++) {
                int index = section * 5 + i;
                if(section * 5 + i >= minerals.length) {
                    break;
                }
                oneSection.add(minerals[index]);
            }
            int stoneValue = stonePick(oneSection);
            sections.add(new Section(section, stoneValue, oneSection));
        }
        Collections.sort(sections, (a, b) -> b.stoneValue - a.stoneValue);

        for(Section s : sections) {
            if(picks[0] > 0) {
                picks[0]--;
                answer += diamondPick(s.mineralsList);
                continue;
            }
            if(picks[1] > 0) {
                picks[1]--;
                answer += ironPick(s.mineralsList);
                continue;
            }
            if(picks[2] > 0) {
                picks[2]--;
                answer += s.stoneValue;
            }
        }


        return answer;
    }



    static int diamondPick(List<String> minerals) {
        return minerals.size();
    }

    static int ironPick(List<String> minerals) {
        int sum = 0;
        for(String mineral : minerals) {
            if(mineral.equals("diamond")) {
                sum += 5;
                continue;
            }
            sum += 1;
        }
        return sum;
    }

    static int stonePick(List<String> minerals) {
        int sum = 0;
        for(String mineral : minerals) {
            if(mineral.equals("diamond")) {
                sum += 25;
                continue;
            }
            if(mineral.equals("iron")) {
                sum += 5;
                continue;
            }
            sum += 1;
        }
        return sum;
    }
}