package Other;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock1Cond
{
    private final Lock Lock;
    private final Condition con;

    public Lock1Cond()
    {
        Lock = new ReentrantLock();
        con = Lock.newCondition();
    }

    public void SignalAll()
    {
        Lock.lock();
        con.signalAll();
        Lock.unlock();
    }

    public void Wait()
    {
        Lock.lock();
        try
        {
            con.await();
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        } finally
        {
            Lock.unlock();
        }
    }

    public void Lock()
    {
        Lock.lock();
    }

    public void Unlock()
    {
        Lock.unlock();
    }
}
