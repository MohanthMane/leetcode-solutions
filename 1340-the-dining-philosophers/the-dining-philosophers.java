class DiningPhilosophers {

    private final Lock[] forks = new Lock[5];
    private final Semaphore taken = new Semaphore(1, true);

    public DiningPhilosophers() {
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {
        int leftForkIndex = philosopher;
        int rightForkIndex = (philosopher + 1) % 5;
        /*
        forks[leftForkIndex].lock();
        forks[rightForkIndex].lock();

        The above code will cause a problem because all the philosophers pick the left fork first
        and keep waiting for the right fork to be available. This will cause a deadlock. So we need to
        make sure that the forks are allocated in an asymmetric way.
         */
        taken.acquire();
        if (philosopher % 2 == 0) {
            forks[leftForkIndex].lock();
            forks[rightForkIndex].lock();
        } else {
            forks[rightForkIndex].lock();
            forks[leftForkIndex].lock();
        }
        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            if (philosopher % 2 == 0) {
                forks[leftForkIndex].unlock();
                forks[rightForkIndex].unlock();
            } else {
                forks[rightForkIndex].unlock();
                forks[leftForkIndex].unlock();
            }
            taken.release();
        }
    }
}