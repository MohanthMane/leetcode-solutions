class Solution:
    def minSteps(self, n: int) -> int:
        def highest_prime_factor(n):
            highest_factor = None
            while n % 2 == 0:
                highest_factor = 2
                n //= 2

            limit = int(math.sqrt(n)) + 1
            for factor in range(3, limit, 2):
                while n % factor == 0:
                    highest_factor = factor
                    n //= factor

            if n > 1:
                highest_factor = n

            return highest_factor 
        
        if n == 1:
            return 0
        if n == 2 or n == 3:
            return n
        
        highest_factor = highest_prime_factor(n)
        return highest_factor + self.minSteps(n // highest_factor)

        