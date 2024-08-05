class MRUQueue {

    private final List<LinkedList<Integer>> blocks = new ArrayList<>();
    private final int blockSize;

    public MRUQueue(int n) {
        blockSize = (int) Math.ceil(Math.sqrt(n));
        int blockCount = (int) Math.ceil((double) n / blockSize);

        for (int i = 0; i < blockCount; i++) {
            blocks.add(new LinkedList<>()); 
        }

        for (int i = 0; i < n; i++) {
            int blockNumber = i / blockSize;
            blocks.get(blockNumber).add(i + 1);
        }
    }

    public int fetch(int k) {
        k--;
        int blockNumber = k / blockSize;
        int index = k % blockSize; // Index within the block
        int removedNum = blocks.get(blockNumber).remove(index);
        
        blocks.get(blocks.size() - 1).add(removedNum);

        for (int i = blockNumber; i < blocks.size() - 1; i++) {
            blocks.get(i).add(blocks.get(i + 1).remove(0));
        }
        return removedNum;
    }
}