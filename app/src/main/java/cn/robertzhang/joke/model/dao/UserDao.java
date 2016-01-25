package cn.robertzhang.joke.model.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import cn.robertzhang.joke.model.entities.joke.User;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table USER.
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Avatar_updated_at = new Property(1, Integer.class, "avatar_updated_at", false, "AVATAR_UPDATED_AT");
        public final static Property Last_visited_at = new Property(2, Integer.class, "last_visited_at", false, "LAST_VISITED_AT");
        public final static Property Created_at = new Property(3, Integer.class, "created_at", false, "CREATED_AT");
        public final static Property State = new Property(4, String.class, "state", false, "STATE");
        public final static Property Last_device = new Property(5, String.class, "last_device", false, "LAST_DEVICE");
        public final static Property Role = new Property(6, String.class, "role", false, "ROLE");
        public final static Property Login = new Property(7, String.class, "login", false, "LOGIN");
        public final static Property Icon = new Property(8, String.class, "icon", false, "ICON");
    };


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USER' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'AVATAR_UPDATED_AT' INTEGER," + // 1: avatar_updated_at
                "'LAST_VISITED_AT' INTEGER," + // 2: last_visited_at
                "'CREATED_AT' INTEGER," + // 3: created_at
                "'STATE' TEXT," + // 4: state
                "'LAST_DEVICE' TEXT," + // 5: last_device
                "'ROLE' TEXT," + // 6: role
                "'LOGIN' TEXT," + // 7: login
                "'ICON' TEXT);"); // 8: icon
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USER'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer avatar_updated_at = entity.getAvatar_updated_at();
        if (avatar_updated_at != null) {
            stmt.bindLong(2, avatar_updated_at);
        }
 
        Integer last_visited_at = entity.getLast_visited_at();
        if (last_visited_at != null) {
            stmt.bindLong(3, last_visited_at);
        }
 
        Integer created_at = entity.getCreated_at();
        if (created_at != null) {
            stmt.bindLong(4, created_at);
        }
 
        String state = entity.getState();
        if (state != null) {
            stmt.bindString(5, state);
        }
 
        String last_device = entity.getLast_device();
        if (last_device != null) {
            stmt.bindString(6, last_device);
        }
 
        String role = entity.getRole();
        if (role != null) {
            stmt.bindString(7, role);
        }
 
        String login = entity.getLogin();
        if (login != null) {
            stmt.bindString(8, login);
        }
 
        String icon = entity.getIcon();
        if (icon != null) {
            stmt.bindString(9, icon);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // avatar_updated_at
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // last_visited_at
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // created_at
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // state
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // last_device
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // role
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // login
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // icon
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAvatar_updated_at(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setLast_visited_at(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setCreated_at(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setState(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setLast_device(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setRole(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setLogin(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setIcon(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}