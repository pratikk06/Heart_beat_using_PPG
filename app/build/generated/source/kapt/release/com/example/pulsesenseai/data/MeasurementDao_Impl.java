package com.example.pulsesenseai.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MeasurementDao_Impl implements MeasurementDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Measurement> __insertionAdapterOfMeasurement;

  public MeasurementDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMeasurement = new EntityInsertionAdapter<Measurement>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `measurements` (`id`,`timestamp`,`durationMs`,`bpmPhaseDetector`,`bpmPeakDetector`,`signalQuality`,`algorithmUsed`,`valid`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Measurement entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getTimestamp());
        statement.bindLong(3, entity.getDurationMs());
        if (entity.getBpmPhaseDetector() == null) {
          statement.bindNull(4);
        } else {
          statement.bindDouble(4, entity.getBpmPhaseDetector());
        }
        if (entity.getBpmPeakDetector() == null) {
          statement.bindNull(5);
        } else {
          statement.bindDouble(5, entity.getBpmPeakDetector());
        }
        statement.bindDouble(6, entity.getSignalQuality());
        if (entity.getAlgorithmUsed() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getAlgorithmUsed());
        }
        final int _tmp = entity.getValid() ? 1 : 0;
        statement.bindLong(8, _tmp);
      }
    };
  }

  @Override
  public Object insert(final Measurement measurement,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMeasurement.insert(measurement);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAll(final Continuation<? super List<Measurement>> $completion) {
    final String _sql = "SELECT * FROM measurements ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Measurement>>() {
      @Override
      @NonNull
      public List<Measurement> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfDurationMs = CursorUtil.getColumnIndexOrThrow(_cursor, "durationMs");
          final int _cursorIndexOfBpmPhaseDetector = CursorUtil.getColumnIndexOrThrow(_cursor, "bpmPhaseDetector");
          final int _cursorIndexOfBpmPeakDetector = CursorUtil.getColumnIndexOrThrow(_cursor, "bpmPeakDetector");
          final int _cursorIndexOfSignalQuality = CursorUtil.getColumnIndexOrThrow(_cursor, "signalQuality");
          final int _cursorIndexOfAlgorithmUsed = CursorUtil.getColumnIndexOrThrow(_cursor, "algorithmUsed");
          final int _cursorIndexOfValid = CursorUtil.getColumnIndexOrThrow(_cursor, "valid");
          final List<Measurement> _result = new ArrayList<Measurement>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Measurement _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final long _tmpDurationMs;
            _tmpDurationMs = _cursor.getLong(_cursorIndexOfDurationMs);
            final Float _tmpBpmPhaseDetector;
            if (_cursor.isNull(_cursorIndexOfBpmPhaseDetector)) {
              _tmpBpmPhaseDetector = null;
            } else {
              _tmpBpmPhaseDetector = _cursor.getFloat(_cursorIndexOfBpmPhaseDetector);
            }
            final Float _tmpBpmPeakDetector;
            if (_cursor.isNull(_cursorIndexOfBpmPeakDetector)) {
              _tmpBpmPeakDetector = null;
            } else {
              _tmpBpmPeakDetector = _cursor.getFloat(_cursorIndexOfBpmPeakDetector);
            }
            final float _tmpSignalQuality;
            _tmpSignalQuality = _cursor.getFloat(_cursorIndexOfSignalQuality);
            final String _tmpAlgorithmUsed;
            if (_cursor.isNull(_cursorIndexOfAlgorithmUsed)) {
              _tmpAlgorithmUsed = null;
            } else {
              _tmpAlgorithmUsed = _cursor.getString(_cursorIndexOfAlgorithmUsed);
            }
            final boolean _tmpValid;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfValid);
            _tmpValid = _tmp != 0;
            _item = new Measurement(_tmpId,_tmpTimestamp,_tmpDurationMs,_tmpBpmPhaseDetector,_tmpBpmPeakDetector,_tmpSignalQuality,_tmpAlgorithmUsed,_tmpValid);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
