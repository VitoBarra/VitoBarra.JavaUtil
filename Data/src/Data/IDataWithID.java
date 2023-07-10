package Data;

public interface IDataWithID<T extends IDataWithID<T>>
{
    int getID();

    default boolean EqualsById(T DataWithID){
        return getID() == DataWithID.getID();
    }

}
