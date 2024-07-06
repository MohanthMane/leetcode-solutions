class Solution:
    def minAreaFreeRect(self, points: List[List[int]]) -> float:
        def dist(p1, p2):
            return (p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2
        
        def euclid_dist(p1, p2):
            return sqrt((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2)

        def is_rectangle(p1, p2, p3, p4):
            cx = (p1[0] + p2[0] + p3[0] + p4[0]) / 4
            cy = (p1[1] + p2[1] + p3[1] + p4[1]) / 4

            d1 = dist([cx, cy], p1)
            d2 = dist([cx, cy], p2)
            d3 = dist([cx, cy], p3)
            d4 = dist([cx, cy], p4)

            return d1 == d2 and d1 == d3 and d1 == d4

        result = 10 ** 10
        for a in range(len(points)):
            for b in range(a + 1, len(points)):
                for c in range(b + 1, len(points)):
                    for d in range(c + 1, len(points)):
                        p1, p2, p3, p4 = points[a], points[b], points[c], points[d]
                        if is_rectangle(p1, p2, p3, p4):
                            vertices = [p1, p2, p3, p4]
                            print(vertices)
                            distances = []
                            for i in range(len(vertices)):
                                for j in range(i + 1, len(vertices)):
                                    distances.append(euclid_dist(vertices[i], vertices[j]))
                            distances.sort()
                            print(distances)
                            side1, side2 = distances[0], distances[2]
                            result = min(result, side1 * side2)
        if result == 10 ** 10:
            return 0
        return result
                            