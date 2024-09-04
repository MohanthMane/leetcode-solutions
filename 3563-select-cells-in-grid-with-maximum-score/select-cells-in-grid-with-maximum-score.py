class Solution:
    def maxScore(self, grid):
        rows, cols = len(grid), len(grid[0])
        unique = set(grid[r][c] for r in range(rows) for c in range(cols))
        sorted_unique = sorted(list(unique), reverse = True)
        val_to_rows = defaultdict(list)
        
        for r in range(rows):
            for c in range(cols):
                val = grid[r][c]
                if r not in val_to_rows[val]:
                    val_to_rows[val].append(r)

        def dfs(chosen, values, score, idx):
            if idx == len(values):
                return score
            
            scores = []
            for row in val_to_rows[values[idx]]:
                if row not in chosen:
                    chosen.add(row)
                    scores.append(dfs(chosen, values, score + values[idx], idx + 1))
                    chosen.remove(row)
            
            if len(scores) == 0:
                scores.append(dfs(chosen, values, score, idx + 1))

            return max(scores)
        
        return dfs(set(), sorted_unique, 0, 0)
