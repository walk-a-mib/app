package com.example.demoapiarch.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.demoapiarch.database.relationship.Pathway;
import com.example.demoapiarch.domain.Coordinate;
import com.example.demoapiarch.domain.Edge;
import com.example.demoapiarch.domain.GA;
import com.example.demoapiarch.domain.Node;
import com.example.demoapiarch.model.path.Step;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PathDao_Impl implements PathDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Pathway> __insertionAdapterOfPathway;

  private final EntityDeletionOrUpdateAdapter<Pathway> __deletionAdapterOfPathway;

  private final EntityDeletionOrUpdateAdapter<Pathway> __updateAdapterOfPathway;

  public PathDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPathway = new EntityInsertionAdapter<Pathway>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Pathway` (`reference_id`,`destination_id`,`intermediate_id`,`connecting_edge_id`,`order_number`,`id`) VALUES (?,?,?,?,?,nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pathway value) {
        if (value.getReferenceId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getReferenceId());
        }
        if (value.getDestinationId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDestinationId());
        }
        if (value.getIntermediateId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIntermediateId());
        }
        if (value.getEdgeId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEdgeId());
        }
        stmt.bindLong(5, value.getOrderNumber());
        stmt.bindLong(6, value.getId());
      }
    };
    this.__deletionAdapterOfPathway = new EntityDeletionOrUpdateAdapter<Pathway>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Pathway` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pathway value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPathway = new EntityDeletionOrUpdateAdapter<Pathway>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Pathway` SET `reference_id` = ?,`destination_id` = ?,`intermediate_id` = ?,`connecting_edge_id` = ?,`order_number` = ?,`id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pathway value) {
        if (value.getReferenceId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getReferenceId());
        }
        if (value.getDestinationId() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDestinationId());
        }
        if (value.getIntermediateId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIntermediateId());
        }
        if (value.getEdgeId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEdgeId());
        }
        stmt.bindLong(5, value.getOrderNumber());
        stmt.bindLong(6, value.getId());
        stmt.bindLong(7, value.getId());
      }
    };
  }

  @Override
  public void insert(final Pathway entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPathway.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<? extends Pathway> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPathway.insert(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Pathway entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPathway.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<? extends Pathway> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPathway.handleMultiple(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Pathway entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPathway.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final List<? extends Pathway> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPathway.handleMultiple(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Step> getPath(final String referenceId, final String destinationId) {
    final String _sql = "SELECT e.*, n.* FROM pathway INNER JOIN node AS n ON intermediate_id = n.node_id INNER JOIN edge AS e ON connecting_edge_id = e.edge_id WHERE reference_id = ? AND destination_id = ? ORDER BY order_number ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (referenceId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, referenceId);
    }
    _argIndex = 2;
    if (destinationId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, destinationId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "edge_id");
      final int _cursorIndexOfLabel = CursorUtil.getColumnIndexOrThrow(_cursor, "edge_label");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "edge_type");
      final int _cursorIndexOfDistance = CursorUtil.getColumnIndexOrThrow(_cursor, "distance");
      final int _cursorIndexOfAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "edgeavailable");
      final int _cursorIndexOfAccessible = CursorUtil.getColumnIndexOrThrow(_cursor, "edgeaccessible");
      final int _cursorIndexOfIndoor = CursorUtil.getColumnIndexOrThrow(_cursor, "edgeindoor");
      final int _cursorIndexOfBuilding = CursorUtil.getColumnIndexOrThrow(_cursor, "edgebuilding");
      final int _cursorIndexOfFloor = CursorUtil.getColumnIndexOrThrow(_cursor, "edgefloor");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "node_id");
      final int _cursorIndexOfLabel_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "node_label");
      final int _cursorIndexOfType_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "node_type");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "nodelat");
      final int _cursorIndexOfLon = CursorUtil.getColumnIndexOrThrow(_cursor, "nodelon");
      final int _cursorIndexOfAlt = CursorUtil.getColumnIndexOrThrow(_cursor, "nodealt");
      final int _cursorIndexOfAvailable_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeavailable");
      final int _cursorIndexOfAccessible_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeaccessible");
      final int _cursorIndexOfIndoor_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "nodeindoor");
      final int _cursorIndexOfBuilding_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "nodebuilding");
      final int _cursorIndexOfFloor_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "nodefloor");
      final List<Step> _result = new ArrayList<Step>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Step _item;
        final Edge _tmpEdge;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfLabel) && _cursor.isNull(_cursorIndexOfType) && _cursor.isNull(_cursorIndexOfDistance) && _cursor.isNull(_cursorIndexOfAvailable) && _cursor.isNull(_cursorIndexOfAccessible) && _cursor.isNull(_cursorIndexOfIndoor) && _cursor.isNull(_cursorIndexOfBuilding) && _cursor.isNull(_cursorIndexOfFloor))) {
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
          final int _tmpDistance;
          _tmpDistance = _cursor.getInt(_cursorIndexOfDistance);
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
          _tmpEdge = new Edge(_tmpId,_tmpLabel,_tmpType,_tmpDistance,_tmpGa);
        }  else  {
          _tmpEdge = null;
        }
        final Node _tmpNode;
        if (! (_cursor.isNull(_cursorIndexOfId_1) && _cursor.isNull(_cursorIndexOfLabel_1) && _cursor.isNull(_cursorIndexOfType_1) && _cursor.isNull(_cursorIndexOfName) && _cursor.isNull(_cursorIndexOfDescription) && _cursor.isNull(_cursorIndexOfLat) && _cursor.isNull(_cursorIndexOfLon) && _cursor.isNull(_cursorIndexOfAlt) && _cursor.isNull(_cursorIndexOfAvailable_1) && _cursor.isNull(_cursorIndexOfAccessible_1) && _cursor.isNull(_cursorIndexOfIndoor_1) && _cursor.isNull(_cursorIndexOfBuilding_1) && _cursor.isNull(_cursorIndexOfFloor_1))) {
          final String _tmpId_1;
          if (_cursor.isNull(_cursorIndexOfId_1)) {
            _tmpId_1 = null;
          } else {
            _tmpId_1 = _cursor.getString(_cursorIndexOfId_1);
          }
          final String _tmpLabel_1;
          if (_cursor.isNull(_cursorIndexOfLabel_1)) {
            _tmpLabel_1 = null;
          } else {
            _tmpLabel_1 = _cursor.getString(_cursorIndexOfLabel_1);
          }
          final int _tmpType_1;
          _tmpType_1 = _cursor.getInt(_cursorIndexOfType_1);
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
          final GA _tmpGa_1;
          if (! (_cursor.isNull(_cursorIndexOfAvailable_1) && _cursor.isNull(_cursorIndexOfAccessible_1) && _cursor.isNull(_cursorIndexOfIndoor_1) && _cursor.isNull(_cursorIndexOfBuilding_1) && _cursor.isNull(_cursorIndexOfFloor_1))) {
            final boolean _tmpAvailable_1;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfAvailable_1);
            _tmpAvailable_1 = _tmp_3 != 0;
            final boolean _tmpAccessible_1;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfAccessible_1);
            _tmpAccessible_1 = _tmp_4 != 0;
            final boolean _tmpIndoor_1;
            final int _tmp_5;
            _tmp_5 = _cursor.getInt(_cursorIndexOfIndoor_1);
            _tmpIndoor_1 = _tmp_5 != 0;
            final int _tmpBuilding_1;
            _tmpBuilding_1 = _cursor.getInt(_cursorIndexOfBuilding_1);
            final int _tmpFloor_1;
            _tmpFloor_1 = _cursor.getInt(_cursorIndexOfFloor_1);
            _tmpGa_1 = new GA(_tmpAvailable_1,_tmpAccessible_1,_tmpIndoor_1,_tmpBuilding_1,_tmpFloor_1);
          }  else  {
            _tmpGa_1 = null;
          }
          _tmpNode = new Node(_tmpId_1,_tmpLabel_1,_tmpType_1,_tmpName,_tmpDescription,_tmpPosition,_tmpGa_1);
        }  else  {
          _tmpNode = null;
        }
        _item = new Step(_tmpEdge,_tmpNode);
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
