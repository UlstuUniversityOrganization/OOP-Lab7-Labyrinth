import java.util.ArrayList;

public class EntityRegister {   
    static ArrayList<Entity> registeredEntities;
    
    public EntityRegister()
    {
	registeredEntities = new ArrayList<Entity>();
	registeredEntities.add(new Player());
	registeredEntities.add(new Cat());
    }
    
    public static Entity getEntity(int entityId)
    {
	return registeredEntities.get(entityId).clone();
    }
}
