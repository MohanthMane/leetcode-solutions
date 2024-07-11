import java.util.*;

class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int m = people.size();
        
        // Map each skill to an index
        Map<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillIndex.put(req_skills[i], i);
        }
        
        // Create a bitmask for each person
        int[] personSkills = new int[m];
        for (int i = 0; i < m; i++) {
            int bitmask = 0;
            for (String skill : people.get(i)) {
                bitmask |= 1 << skillIndex.get(skill);
            }
            personSkills[i] = bitmask;
        }
        
        // BFS setup
        Queue<State> queue = new LinkedList<>();
        Map<Integer, List<Integer>> visited = new HashMap<>();
        int fullSkillSet = (1 << n) - 1;
        
        queue.offer(new State(0, new ArrayList<>()));
        visited.put(0, new ArrayList<>());
        
        // BFS loop
        while (!queue.isEmpty()) {
            State current = queue.poll();
            int currentSkills = current.skills;
            List<Integer> currentTeam = current.team;
            
            if (currentSkills == fullSkillSet) {
                int[] result = new int[currentTeam.size()];
                for (int i = 0; i < currentTeam.size(); i++) {
                    result[i] = currentTeam.get(i);
                }
                return result;
            }
            
            for (int i = 0; i < m; i++) {
                int newSkills = currentSkills | personSkills[i];
                if (!visited.containsKey(newSkills) || visited.get(newSkills).size() > currentTeam.size() + 1) {
                    List<Integer> newTeam = new ArrayList<>(currentTeam);
                    newTeam.add(i);
                    queue.offer(new State(newSkills, newTeam));
                    visited.put(newSkills, newTeam);
                }
            }
        }
        
        return new int[0];  // Should not reach here
    }
    
    class State {
        int skills;
        List<Integer> team;
        
        State(int skills, List<Integer> team) {
            this.skills = skills;
            this.team = team;
        }
    }
}
