package VitoBarra.JavaUtil.State;

public class StateGenericContext<T>
{
    protected T State;
    public void setState(T state) {
        this.State = state;
    }

    public T getState() {
        return State;
    }

}
