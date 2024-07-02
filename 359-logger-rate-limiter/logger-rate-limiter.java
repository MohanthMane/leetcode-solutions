class Logger {

    private Map<String, Integer> nextEligibleTimeStamp;

    public Logger() {
        this.nextEligibleTimeStamp = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!nextEligibleTimeStamp.containsKey(message) || (nextEligibleTimeStamp.containsKey(message) && nextEligibleTimeStamp.get(message) <= timestamp)) {
            nextEligibleTimeStamp.put(message, timestamp + 10);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */