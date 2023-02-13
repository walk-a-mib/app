package com.example.demoapiarch.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MapsRoomDatabase_Impl extends MapsRoomDatabase {
  private volatile PlaceDao _placeDao;

  private volatile PlaceNearbyDao _placeNearbyDao;

  private volatile PathDao _pathDao;

  private volatile EdgeDao _edgeDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Proximity` (`reference_id` TEXT NOT NULL, `neighbour_id` TEXT NOT NULL, `distance` INTEGER NOT NULL, PRIMARY KEY(`reference_id`, `neighbour_id`), FOREIGN KEY(`reference_id`) REFERENCES `Node`(`node_id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`neighbour_id`) REFERENCES `Node`(`node_id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Node` (`node_id` TEXT NOT NULL, `node_label` TEXT NOT NULL, `node_type` INTEGER NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `nodelat` REAL NOT NULL, `nodelon` REAL NOT NULL, `nodealt` REAL NOT NULL, `nodeavailable` INTEGER NOT NULL, `nodeaccessible` INTEGER NOT NULL, `nodeindoor` INTEGER NOT NULL, `nodebuilding` INTEGER NOT NULL, `nodefloor` INTEGER NOT NULL, PRIMARY KEY(`node_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Pathway` (`reference_id` TEXT NOT NULL, `destination_id` TEXT NOT NULL, `intermediate_id` TEXT NOT NULL, `connecting_edge_id` TEXT NOT NULL, `order_number` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, FOREIGN KEY(`reference_id`) REFERENCES `Node`(`node_id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`destination_id`) REFERENCES `Node`(`node_id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`intermediate_id`) REFERENCES `Node`(`node_id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`connecting_edge_id`) REFERENCES `Edge`(`edge_id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Edge` (`edge_id` TEXT NOT NULL, `edge_label` TEXT NOT NULL, `edge_type` INTEGER NOT NULL, `distance` INTEGER NOT NULL, `edgeavailable` INTEGER NOT NULL, `edgeaccessible` INTEGER NOT NULL, `edgeindoor` INTEGER NOT NULL, `edgebuilding` INTEGER NOT NULL, `edgefloor` INTEGER NOT NULL, PRIMARY KEY(`edge_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3a20d293658890422a71179dffae0025')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Proximity`");
        _db.execSQL("DROP TABLE IF EXISTS `Node`");
        _db.execSQL("DROP TABLE IF EXISTS `Pathway`");
        _db.execSQL("DROP TABLE IF EXISTS `Edge`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsProximity = new HashMap<String, TableInfo.Column>(3);
        _columnsProximity.put("reference_id", new TableInfo.Column("reference_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProximity.put("neighbour_id", new TableInfo.Column("neighbour_id", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProximity.put("distance", new TableInfo.Column("distance", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProximity = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysProximity.add(new TableInfo.ForeignKey("Node", "NO ACTION", "NO ACTION",Arrays.asList("reference_id"), Arrays.asList("node_id")));
        _foreignKeysProximity.add(new TableInfo.ForeignKey("Node", "NO ACTION", "NO ACTION",Arrays.asList("neighbour_id"), Arrays.asList("node_id")));
        final HashSet<TableInfo.Index> _indicesProximity = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProximity = new TableInfo("Proximity", _columnsProximity, _foreignKeysProximity, _indicesProximity);
        final TableInfo _existingProximity = TableInfo.read(_db, "Proximity");
        if (! _infoProximity.equals(_existingProximity)) {
          return new RoomOpenHelper.ValidationResult(false, "Proximity(com.example.demoapiarch.database.relationship.Proximity).\n"
                  + " Expected:\n" + _infoProximity + "\n"
                  + " Found:\n" + _existingProximity);
        }
        final HashMap<String, TableInfo.Column> _columnsNode = new HashMap<String, TableInfo.Column>(13);
        _columnsNode.put("node_id", new TableInfo.Column("node_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("node_label", new TableInfo.Column("node_label", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("node_type", new TableInfo.Column("node_type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("nodelat", new TableInfo.Column("nodelat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("nodelon", new TableInfo.Column("nodelon", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("nodealt", new TableInfo.Column("nodealt", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("nodeavailable", new TableInfo.Column("nodeavailable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("nodeaccessible", new TableInfo.Column("nodeaccessible", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("nodeindoor", new TableInfo.Column("nodeindoor", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("nodebuilding", new TableInfo.Column("nodebuilding", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNode.put("nodefloor", new TableInfo.Column("nodefloor", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNode = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNode = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNode = new TableInfo("Node", _columnsNode, _foreignKeysNode, _indicesNode);
        final TableInfo _existingNode = TableInfo.read(_db, "Node");
        if (! _infoNode.equals(_existingNode)) {
          return new RoomOpenHelper.ValidationResult(false, "Node(com.example.demoapiarch.domain.Node).\n"
                  + " Expected:\n" + _infoNode + "\n"
                  + " Found:\n" + _existingNode);
        }
        final HashMap<String, TableInfo.Column> _columnsPathway = new HashMap<String, TableInfo.Column>(6);
        _columnsPathway.put("reference_id", new TableInfo.Column("reference_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPathway.put("destination_id", new TableInfo.Column("destination_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPathway.put("intermediate_id", new TableInfo.Column("intermediate_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPathway.put("connecting_edge_id", new TableInfo.Column("connecting_edge_id", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPathway.put("order_number", new TableInfo.Column("order_number", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPathway.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPathway = new HashSet<TableInfo.ForeignKey>(4);
        _foreignKeysPathway.add(new TableInfo.ForeignKey("Node", "NO ACTION", "NO ACTION",Arrays.asList("reference_id"), Arrays.asList("node_id")));
        _foreignKeysPathway.add(new TableInfo.ForeignKey("Node", "NO ACTION", "NO ACTION",Arrays.asList("destination_id"), Arrays.asList("node_id")));
        _foreignKeysPathway.add(new TableInfo.ForeignKey("Node", "NO ACTION", "NO ACTION",Arrays.asList("intermediate_id"), Arrays.asList("node_id")));
        _foreignKeysPathway.add(new TableInfo.ForeignKey("Edge", "NO ACTION", "NO ACTION",Arrays.asList("connecting_edge_id"), Arrays.asList("edge_id")));
        final HashSet<TableInfo.Index> _indicesPathway = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPathway = new TableInfo("Pathway", _columnsPathway, _foreignKeysPathway, _indicesPathway);
        final TableInfo _existingPathway = TableInfo.read(_db, "Pathway");
        if (! _infoPathway.equals(_existingPathway)) {
          return new RoomOpenHelper.ValidationResult(false, "Pathway(com.example.demoapiarch.database.relationship.Pathway).\n"
                  + " Expected:\n" + _infoPathway + "\n"
                  + " Found:\n" + _existingPathway);
        }
        final HashMap<String, TableInfo.Column> _columnsEdge = new HashMap<String, TableInfo.Column>(9);
        _columnsEdge.put("edge_id", new TableInfo.Column("edge_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdge.put("edge_label", new TableInfo.Column("edge_label", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdge.put("edge_type", new TableInfo.Column("edge_type", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdge.put("distance", new TableInfo.Column("distance", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdge.put("edgeavailable", new TableInfo.Column("edgeavailable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdge.put("edgeaccessible", new TableInfo.Column("edgeaccessible", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdge.put("edgeindoor", new TableInfo.Column("edgeindoor", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdge.put("edgebuilding", new TableInfo.Column("edgebuilding", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEdge.put("edgefloor", new TableInfo.Column("edgefloor", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEdge = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEdge = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEdge = new TableInfo("Edge", _columnsEdge, _foreignKeysEdge, _indicesEdge);
        final TableInfo _existingEdge = TableInfo.read(_db, "Edge");
        if (! _infoEdge.equals(_existingEdge)) {
          return new RoomOpenHelper.ValidationResult(false, "Edge(com.example.demoapiarch.domain.Edge).\n"
                  + " Expected:\n" + _infoEdge + "\n"
                  + " Found:\n" + _existingEdge);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "3a20d293658890422a71179dffae0025", "7f86d1c5414565bbc7b80ed3cbf08807");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Proximity","Node","Pathway","Edge");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Proximity`");
      _db.execSQL("DELETE FROM `Pathway`");
      _db.execSQL("DELETE FROM `Node`");
      _db.execSQL("DELETE FROM `Edge`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PlaceDao.class, PlaceDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PlaceNearbyDao.class, PlaceNearbyDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PathDao.class, PathDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(EdgeDao.class, EdgeDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public PlaceDao placeDao() {
    if (_placeDao != null) {
      return _placeDao;
    } else {
      synchronized(this) {
        if(_placeDao == null) {
          _placeDao = new PlaceDao_Impl(this);
        }
        return _placeDao;
      }
    }
  }

  @Override
  public PlaceNearbyDao placeNearbyDao() {
    if (_placeNearbyDao != null) {
      return _placeNearbyDao;
    } else {
      synchronized(this) {
        if(_placeNearbyDao == null) {
          _placeNearbyDao = new PlaceNearbyDao_Impl(this);
        }
        return _placeNearbyDao;
      }
    }
  }

  @Override
  public PathDao pathDao() {
    if (_pathDao != null) {
      return _pathDao;
    } else {
      synchronized(this) {
        if(_pathDao == null) {
          _pathDao = new PathDao_Impl(this);
        }
        return _pathDao;
      }
    }
  }

  @Override
  public EdgeDao edgeDao() {
    if (_edgeDao != null) {
      return _edgeDao;
    } else {
      synchronized(this) {
        if(_edgeDao == null) {
          _edgeDao = new EdgeDao_Impl(this);
        }
        return _edgeDao;
      }
    }
  }
}
