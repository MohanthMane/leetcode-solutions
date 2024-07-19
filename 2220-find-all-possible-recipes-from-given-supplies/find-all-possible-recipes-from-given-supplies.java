class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> supplySet = new HashSet<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < supplies.length; i++) {
            supplySet.add(supplies[i]);
        }
        for (int i = 0; i < recipes.length; i++) {
            indexMap.put(recipes[i], i);
            for (String ingredient: ingredients.get(i)) {
                if (!graph.containsKey(ingredient)) {
                    graph.put(ingredient, new ArrayList<>());   
                }
                graph.get(ingredient).add(recipes[i]);
            }
        }

        int[] degrees = new int[recipes.length];
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient: ingredients.get(i)) {
                if (supplySet.contains(ingredient)) continue;
                degrees[i]++;
            }
            if (degrees[i] == 0) {
                queue.add(recipes[i]);
            }
        }

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            result.add(curr);
            for (String recipe: graph.getOrDefault(curr, new ArrayList<>())) {
                int index = indexMap.get(recipe);
                degrees[index]--;
                if (degrees[index] == 0) queue.offer(recipe);
            }
        }
        return result;
    }
}