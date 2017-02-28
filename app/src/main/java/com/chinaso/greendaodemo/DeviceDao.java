package com.chinaso.greendaodemo;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.cool.hello.greenDB.Device;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DEVICE".
*/
public class DeviceDao extends AbstractDao<Device, Long> {

    public static final String TABLENAME = "DEVICE";

    /**
     * Properties of entity Device.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property DeviceId = new Property(1, long.class, "deviceId", false, "DEVICE_ID");
        public final static Property DeviceName = new Property(2, String.class, "deviceName", false, "DEVICE_NAME");
    }

    private Query<Device> space_DevicesQuery;

    public DeviceDao(DaoConfig config) {
        super(config);
    }
    
    public DeviceDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DEVICE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"DEVICE_ID\" INTEGER NOT NULL ," + // 1: deviceId
                "\"DEVICE_NAME\" TEXT);"); // 2: deviceName
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DEVICE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Device entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getDeviceId());
 
        String deviceName = entity.getDeviceName();
        if (deviceName != null) {
            stmt.bindString(3, deviceName);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Device entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getDeviceId());
 
        String deviceName = entity.getDeviceName();
        if (deviceName != null) {
            stmt.bindString(3, deviceName);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Device readEntity(Cursor cursor, int offset) {
        Device entity = new Device( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // deviceId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // deviceName
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Device entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDeviceId(cursor.getLong(offset + 1));
        entity.setDeviceName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Device entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Device entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Device entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "devices" to-many relationship of Space. */
    public List<Device> _querySpace_Devices(long deviceId) {
        synchronized (this) {
            if (space_DevicesQuery == null) {
                QueryBuilder<Device> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.DeviceId.eq(null));
                space_DevicesQuery = queryBuilder.build();
            }
        }
        Query<Device> query = space_DevicesQuery.forCurrentThread();
        query.setParameter(0, deviceId);
        return query.list();
    }

}
