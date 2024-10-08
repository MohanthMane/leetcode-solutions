class Solution:
    def splitBST(self, root: Optional[TreeNode], target: int) -> List[Optional[TreeNode]]:
        def dfs(node):
            if not node:
                return None, None
            if node.val <= target:
                left, right = dfs(node.right)
                node.right = left
                return node, right
            else:
                left, right = dfs(node.left)
                node.left = right
                return left, node
        return dfs(root)