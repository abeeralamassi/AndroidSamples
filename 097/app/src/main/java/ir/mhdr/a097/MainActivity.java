package ir.mhdr.a097;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private DaoSession daoSession;
    private NoteDao noteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daoSession = Statics.daoSession;
        noteDao = daoSession.getNoteDao();

        Note note = new Note();
        note.setUuid(UUID.randomUUID().toString());
        note.setDate(new Date());
        note.setText("Hello World");

        noteDao.save(note);
    }
}
