/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> m = new HashMap<>();
        employees.forEach(e -> m.put(e.id, e));
        Map<Integer, Boolean> visited = new HashMap<>();

        Queue<Employee> q = new LinkedList<>();
        q.offer(m.get(id));
        int result = 0;
        while (!q.isEmpty()) {
            Employee curr = q.poll();
            result += curr.importance;
            for (int subordinate : curr.subordinates) {
                if (!visited.getOrDefault(subordinate, false)) {
                    q.offer(m.get(subordinate));
                    visited.put(subordinate, true);
                }
            }
        }
        return result;
    }
}