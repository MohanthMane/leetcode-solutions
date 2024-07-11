class Solution:
    def smallestSufficientTeam (self, req_skills: List[str], people: List[List[str]]) -> List[int]:
        skills_people_table = [set() for i in range(len(req_skills))]
        skills_map = {skill : i for i, skill in enumerate(req_skills)}
        for i in range(len(people)):
            for skill in people[i]: skills_people_table[skills_map[skill]].add(i)
        q = deque() ; q.append((skills_people_table, []))
        while (q):
            curr_table, curr_team = q.popleft()
            rare_skill_people_set = min(curr_table, key=len)
            for person in rare_skill_people_set:
                next_table = [skill_people_set for skill_people_set in curr_table if person not in skill_people_set]
                if (not next_table): return curr_team + [person]
                q.append((next_table, curr_team + [person]))