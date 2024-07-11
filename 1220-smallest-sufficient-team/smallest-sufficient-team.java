import java.util.*;

class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        Map<String, Integer> skillsMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillsMap.put(req_skills[i], i);
        }

        List<Set<Integer>> skillsPeopleTable = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            skillsPeopleTable.add(new HashSet<>());
        }

        for (int i = 0; i < people.size(); i++) {
            for (String skill : people.get(i)) {
                int skillIndex = skillsMap.get(skill);
                skillsPeopleTable.get(skillIndex).add(i);
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(skillsPeopleTable, new ArrayList<>()));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            List<Set<Integer>> currTable = curr.table;
            List<Integer> currTeam = curr.team;

            Set<Integer> rareSkillPeopleSet = Collections.min(currTable, Comparator.comparingInt(Set::size));

            for (int person : rareSkillPeopleSet) {
                List<Set<Integer>> nextTable = new ArrayList<>();
                for (Set<Integer> skillPeopleSet : currTable) {
                    if (!skillPeopleSet.contains(person)) {
                        nextTable.add(skillPeopleSet);
                    }
                }
                if (nextTable.isEmpty()) {
                    int[] result = new int[currTeam.size() + 1];
                    for (int i = 0; i < currTeam.size(); i++) {
                        result[i] = currTeam.get(i);
                    }
                    result[currTeam.size()] = person;
                    return result;
                }
                List<Integer> nextTeam = new ArrayList<>(currTeam);
                nextTeam.add(person);
                q.add(new Pair(nextTable, nextTeam));
            }
        }

        return new int[0]; // Should not reach here
    }

    class Pair {
        List<Set<Integer>> table;
        List<Integer> team;

        Pair(List<Set<Integer>> table, List<Integer> team) {
            this.table = table;
            this.team = team;
        }
    }
}
