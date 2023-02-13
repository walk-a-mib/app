package com.example.demoapiarch.database;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.demoapiarch.domain.Edge;
import com.example.demoapiarch.domain.GA;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class EdgeDao_Impl implements EdgeDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Edge> __insertionAdapterOfEdge;

  private final EntityDeletionOrUpdateAdapter<Edge> __deletionAdapterOfEdge;

  private final EntityDeletionOrUpdateAdapter<Edge> __updateAdapterOfEdge;

  public EdgeDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEdge = new EntityInsertionAdapter<Edge>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Edge` (`edge_id`,`edge_label`,`edge_type`,`distance`,`edgeavailable`,`edgeaccessible`,`edgeindoor`,`edgebuilding`,`edgefloor`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Edge value) {
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
        stmt.bindLong(4, value.getDistance());
        final GA _tmpGa = value.getGa();
        if(_tmpGa != null) {
          final int _tmp = _tmpGa.getAvailable() ? 1 : 0;
          stmt.bindLong(5, _tmp);
          final int _tmp_1 = _tmpGa.getAccessible() ? 1 : 0;
          stmt.bindLong(6, _tmp_1);
          final int _tmp_2 = _tmpGa.getIndoor() ? 1 : 0;
          stmt.bindLong(7, _tmp_2);
          stmt.bindLong(8, _tmpGa.getBuilding());
          stmt.bindLong(9, _tmpGa.getFloor());
        } else {
          stmt.bindNull(5);
          stmt.bindNull(6);
          stmt.bindNull(7);
          stmt.bindNull(8);
          stmt.bindNull(9);
        }
      }
    };
    this.__deletionAdapterOfEdge = new EntityDeletionOrUpdateAdapter<Edge>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Edge` WHERE `edge_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Edge value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfEdge = new EntityDeletionOrUpdateAdapter<Edge>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Edge` SET `edge_id` = ?,`edge_label` = ?,`edge_type` = ?,`distance` = ?,`edgeavailable` = ?,`edgeaccessible` = ?,`edgeindoor` = ?,`edgebuilding` = ?,`edgefloor` = ? WHERE `edge_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Edge value) {
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
        stmt.bindLong(4, value.getDistance());
        final GA _tmpGa = value.getGa();
        if(_tmpGa != null) {
          final int _tmp = _tmpGa.getAvailable() ? 1 : 0;
          stmt.bindLong(5, _tmp);
          final int _tmp_1 = _tmpGa.getAccessible() ? 1 : 0;
          stmt.bindLong(6, _tmp_1);
          final int _tmp_2 = _tmpGa.getIndoor() ? 1 : 0;
          stmt.bindLong(7, _tmp_2);
          stmt.bindLong(8, _tmpGa.getBuilding());
          stmt.bindLong(9, _tmpGa.getFloor());
        } else {
          stmt.bindNull(5);
          stmt.bindNull(6);
          stmt.bindNull(7);
          stmt.bindNull(8);
          stmt.bindNull(9);
        }
        if (value.getId() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getId());
        }
      }
    };
  }

  @Override
  public void insert(final Edge entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEdge.insert(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final List<? extends Edge> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEdge.insert(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Edge entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEdge.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final List<? extends Edge> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEdge.handleMultiple(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Edge entity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEdge.handle(entity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final List<? extends Edge> entities) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEdge.handleMultiple(entities);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
