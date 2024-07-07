import java.util.concurrent.Semaphore;

public class H2O {
    private Semaphore hydrogen;
    private Semaphore oxygen;

    public H2O() {
        hydrogen=new Semaphore(2);
        oxygen=new Semaphore(1);
    }

    public void h(Runnable release) throws InterruptedException{
        hydrogen.acquire();
        createWater();
        release.run();
    }
    public void o(Runnable release) throws InterruptedException{
        oxygen.acquire();
        createWater();
        release.run();
    }

    private void createWater(){
        if(hydrogen.availablePermits()==1 && oxygen.availablePermits()==0){
            hydrogen.release(2);
            oxygen.release();
        }
        else if(hydrogen.availablePermits()==0 && oxygen.availablePermits()==1){
            hydrogen.release();
            oxygen.release();
        }
    }
}