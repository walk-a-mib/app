package com.example.demoapiarch.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.demoapiarch.database.relationship.Proximity;
import com.example.demoapiarch.domain.Coordinate;
import com.example.demoapiarch.domain.GA;
import com.example.demoapiarch.domain.Node;
import com.example.demoapiarch.model.placesNearby.Neighbour;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PlaceNearbyDao_Impl implements PlaceNearbyDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Proximity> __insertionAdapterOfProximity;

  private final EntityDeletionOrUpdateAdapter<Proximity> __deletionAdapterOfProximity;

  private final EntityDeletionOrUpdateAdapter<Proximity> __updateAdapterOfProximity;

  public PlaceNearbyDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProximity = new EntityInsertionAdapter<Proximity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Proximity` (`reference_id`,`neighbour_id`,`distance`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Proximity value) {
        if (value.getReferenceId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getReferenceId());
        }
        if (value.getNeighborId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNeighborId());
        }
        stmt.bindLong(3, value.getDistance());
      }
    };
    this.__deletionAdapterOfProximity = new EntityDeletionOrUpdateAdapter<Proximity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Proximity` WHERE `reference_id` = ? AND `neighbour_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Proximity value) {
        if (value.getReferenceId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getReferenceId());
        }
        if (value.getNeighborId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNeighborId());
        }
      }
    };
    this.__updateAdapterOfProximity = new EntityDeletionOrUpdateAdapter<Proximity>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Proximity` SET `reference_id` = ?,`neighbour_id` = ?,`distance` = ? WHERE `reference_id` = ? AND `neighbour_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Proximity value) {
        if (value.getReferenceId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getReferenceId());
        }
        if (value.getNeighborId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNeighborId());
        }
        stmt.bindLong(3, value.getDistance());
        if (value.getReferenceId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getReferenceId());
        }
        if (value.getNeighborId() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getNeighborId());
        }
      }
    };
  }

  @Override
  public void insert(final Proximity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProximity.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<? extends Proximity> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProximity.insert(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Proximity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProximity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<? extends Proximity> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProximity.handleMultiple(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Proximity entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfProximity.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final List<? extends Proximity> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfProximity.handleMultiple(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Neighbour> getPlacesNearby(final String referenceId, final int maxDistance) {
    final String _sql = "SELECT n.*, pr.distance FROM node AS n INNER JOIN proximity AS pr ON node_id = pr.neighbour_id WHERE pr.reference_id = ? AND distance <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (referenceId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, referenceId);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, maxDistance);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "node_id");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "node_label");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "node_type");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "nodelat");
      final int _cursorIndexOfLon = CursorUtil.getColumnIndexOrThrow(_cursor, "nodelon");
      final int _cursorIndexOfAlt = CursorUtil.getColumnIndexOrThrow(_cursor, "nodealt");
      final int _cursorIndexOfAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeavailable");
      final int _cursorIndexOfAccessible = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeaccessible");
      final int _cursorIndexOfIndoor = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeindoor");
      final int _cursorIndexOfBuilding = CursorUtil.getColumnIndexOrThrow(_cursor, "nodebuilding");
      final int _cursorIndexOfFloor = CursorUtil.getColumnIndexOrThrow(_cursor, "nodefloor");
      final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
      final List<Neighbour> _result = new ArrayList<Neighbour>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Neighbour _item;
        final int _tmpDistance;
        _tmpDistance = _cursor.getInt(_cursorIndexOfDistance);
        final Node _tmpPlace;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfLabel) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDescription) && _cursor.isNull(_cursorIndexOfLat) && _cursor.isNull(_cursorIndexOfLon) && _cursor.isNull(_cursorIndexOfAlt) && _cursor.isNull(_cursorIndexOfAvailable) && _cursor.isNull(_cursorIndexOfAccessible) && _cursor.isNull(_cursorIndexOfIndoor) && _cursor.isNull(_cursorIndexOfBuilding) && _cursor.isNull(_cursorIndexOfFloor))) {
          final String _tmpId;
          if (_cursor.isNull(_cursorIndexOfId)) {
            _tmpId = null;
          } else {
            _tmpId = _cursor.getString(_cursorIndexOfId);
          }
          final String _tmpLabel;
          if (_cursor.isNull(_cursorIndexOfLabel)) {
            _tmpLabel = null;
          } else {
            _tmpLabel = _cursor.getString(_cursorIndexOfLabel);
          }
          final int _tmpType;
          _tmpType = _cursor.getInt(_cursorIndexOfType);
          final String _tmpName;
          if (_cursor.isNull(_cursorIndexOfName)) {
            _tmpName = null;
          } else {
            _tmpName = _cursor.getString(_cursorIndexOfName);
          }
          final String _tmpDescription;
          if (_cursor.isNull(_cursorIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
          }
          final Coordinate _tmpPosition;
          if (! (_cursor.isNull(_cursorIndexOfLat) && _cursor.isNull(_cursorIndexOfLon) && _cursor.isNull(_cursorIndexOfAlt))) {
            final double _tmpLat;
            _tmpLat = _cursor.getDouble(_cursorIndexOfLat);
            final double _tmpLon;
            _tmpLon = _cursor.getDouble(_cursorIndexOfLon);
            final double _tmpAlt;
            _tmpAlt = _cursor.getDouble(_cursorIndexOfAlt);
            _tmpPosition = new Coordinate(_tmpLat,_tmpLon,_tmpAlt);
          }  else  {
            _tmpPosition = null;
          }
          final GA _tmpGa;
          if (! (_cursor.isNull(_cursorIndexOfAvailable) && _cursor.isNull(_cursorIndexOfAccessible) && _cursor.isNull(_cursorIndexOfIndoor) && _cursor.isNull(_cursorIndexOfBuilding) && _cursor.isNull(_cursorIndexOfFloor))) {
            final boolean _tmpAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfAvailable);
            _tmpAvailable = _tmp != 0;
            final boolean _tmpAccessible;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfAccessible);
            _tmpAccessible = _tmp_1 != 0;
            final boolean _tmpIndoor;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIndoor);
            _tmpIndoor = _tmp_2 != 0;
            final int _tmpBuilding;
            _tmpBuilding = _cursor.getInt(_cursorIndexOfBuilding);
            final int _tmpFloor;
            _tmpFloor = _cursor.getInt(_cursorIndexOfFloor);
            _tmpGa = new GA(_tmpAvailable,_tmpAccessible,_tmpIndoor,_tmpBuilding,_tmpFloor);
          }  else  {
            _tmpGa = null;
          }
          _tmpPlace = new Node(_tmpId,_tmpLabel,_tmpType,_tmpName,_tmpDescription,_tmpPosition,_tmpGa);
        }  else  {
          _tmpPlace = null;
        }
        _item = new Neighbour(_tmpPlace,_tmpDistance);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
