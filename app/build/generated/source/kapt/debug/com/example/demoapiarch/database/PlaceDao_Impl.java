package com.example.demoapiarch.database;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.demoapiarch.domain.Coordinate;
import com.example.demoapiarch.domain.GA;
import com.example.demoapiarch.domain.Node;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PlaceDao_Impl implements PlaceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Node> __insertionAdapterOfNode;

  private final EntityDeletionOrUpdateAdapter<Node> __deletionAdapterOfNode;

  private final EntityDeletionOrUpdateAdapter<Node> __updateAdapterOfNode;

  public PlaceDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfNode = new EntityInsertionAdapter<Node>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Node` (`node_id`,`node_label`,`node_type`,`name`,`description`,`nodelat`,`nodelon`,`nodealt`,`nodeavailable`,`nodeaccessible`,`nodeindoor`,`nodebuilding`,`nodefloor`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Node value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLabel());
        }
        stmt.bindLong(3, value.getType());
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDescription());
        }
        final Coordinate _tmpPosition = value.getPosition();
        if(_tmpPosition != null) {
          stmt.bindDouble(6, _tmpPosition.getLat());
          stmt.bindDouble(7, _tmpPosition.getLon());
          stmt.bindDouble(8, _tmpPosition.getAlt());
        } else {
          stmt.bindNull(6);
          stmt.bindNull(7);
          stmt.bindNull(8);
        }
        final GA _tmpGa = value.getGa();
        if(_tmpGa != null) {
          final int _tmp = _tmpGa.getAvailable() ? 1 : 0;
          stmt.bindLong(9, _tmp);
          final int _tmp_1 = _tmpGa.getAccessible() ? 1 : 0;
          stmt.bindLong(10, _tmp_1);
          final int _tmp_2 = _tmpGa.getIndoor() ? 1 : 0;
          stmt.bindLong(11, _tmp_2);
          stmt.bindLong(12, _tmpGa.getBuilding());
          stmt.bindLong(13, _tmpGa.getFloor());
        } else {
          stmt.bindNull(9);
          stmt.bindNull(10);
          stmt.bindNull(11);
          stmt.bindNull(12);
          stmt.bindNull(13);
        }
      }
    };
    this.__deletionAdapterOfNode = new EntityDeletionOrUpdateAdapter<Node>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Node` WHERE `node_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Node value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfNode = new EntityDeletionOrUpdateAdapter<Node>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Node` SET `node_id` = ?,`node_label` = ?,`node_type` = ?,`name` = ?,`description` = ?,`nodelat` = ?,`nodelon` = ?,`nodealt` = ?,`nodeavailable` = ?,`nodeaccessible` = ?,`nodeindoor` = ?,`nodebuilding` = ?,`nodefloor` = ? WHERE `node_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Node value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getLabel() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getLabel());
        }
        stmt.bindLong(3, value.getType());
        if (value.getName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDescription());
        }
        final Coordinate _tmpPosition = value.getPosition();
        if(_tmpPosition != null) {
          stmt.bindDouble(6, _tmpPosition.getLat());
          stmt.bindDouble(7, _tmpPosition.getLon());
          stmt.bindDouble(8, _tmpPosition.getAlt());
        } else {
          stmt.bindNull(6);
          stmt.bindNull(7);
          stmt.bindNull(8);
        }
        final GA _tmpGa = value.getGa();
        if(_tmpGa != null) {
          final int _tmp = _tmpGa.getAvailable() ? 1 : 0;
          stmt.bindLong(9, _tmp);
          final int _tmp_1 = _tmpGa.getAccessible() ? 1 : 0;
          stmt.bindLong(10, _tmp_1);
          final int _tmp_2 = _tmpGa.getIndoor() ? 1 : 0;
          stmt.bindLong(11, _tmp_2);
          stmt.bindLong(12, _tmpGa.getBuilding());
          stmt.bindLong(13, _tmpGa.getFloor());
        } else {
          stmt.bindNull(9);
          stmt.bindNull(10);
          stmt.bindNull(11);
          stmt.bindNull(12);
          stmt.bindNull(13);
        }
        if (value.getId() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getId());
        }
      }
    };
  }

  @Override
  public void insert(final Node entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNode.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<? extends Node> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfNode.insert(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Node entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfNode.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<? extends Node> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfNode.handleMultiple(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Node entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfNode.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final List<? extends Node> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfNode.handleMultiple(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Node> getAllPlaces() {
    final String _sql = "SELECT * FROM node";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
      final List<Node> _result = new ArrayList<Node>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Node _item;
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
        _item = new Node(_tmpId,_tmpLabel,_tmpType,_tmpName,_tmpDescription,_tmpPosition,_tmpGa);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Node getPlace(final String id) {
    final String _sql = "SELECT * FROM node WHERE node_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
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
      final Node _result;
      if(_cursor.moveToFirst()) {
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
        _result = new Node(_tmpId,_tmpLabel,_tmpType,_tmpName,_tmpDescription,_tmpPosition,_tmpGa);
      } else {
        _result = null;
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
