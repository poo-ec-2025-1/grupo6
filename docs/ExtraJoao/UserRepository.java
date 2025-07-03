import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;

public class UserRepository
{
    private static Database database;
    private static Dao<User, Integer> dao;
    private List<User> loadedUsers;
    private User loadedUser; 
    
    public UserRepository(Database database) {
        UserRepository.setDatabase(database);
        loadedUsers = new ArrayList<User>();
    }
    
    public static void setDatabase(Database database) {
        UserRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), User.class);
            TableUtils.createTableIfNotExists(database.getConnection(), User.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }            
    }
    
    public User create(User user) {
        int nrows = 0;
        try {
            nrows = dao.create(user);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedUser = user;
            loadedUsers.add(user);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }    

    public void update(User user) {
      // TODO
    }

    public void delete(User user) {
      // TODO
    }
    
    public User loadFromId(int id) {
        try {
            this.loadedUser = dao.queryForId(id);
            if (this.loadedUser != null)
                this.loadedUsers.add(this.loadedUser);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedUser;
    }    
    
    public List<User> loadAll() {
        try {
            this.loadedUsers =  dao.queryForAll();
            if (this.loadedUsers.size() != 0)
                this.loadedUser = this.loadedUsers.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedUsers;
    }
     
}