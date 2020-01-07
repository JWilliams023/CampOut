package com.projects.campout.J;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.projects.campout.J.service.GoogleSignInService;
import com.squareup.picasso.Picasso;
import com.projects.campout.J.CampOutDatabase;

public class CampOutApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    GoogleSignInService.setApplicationContext(this);
    Stetho.initializeWithDefaults(this);
    Picasso.setSingletonInstance(new Picasso.Builder(this)
        .loggingEnabled(true)
        .build());
    CampOutDatabase.setApplicationContext(this);
    final CampOutDatabase database = CampOutDatabase.getInstance();
    new Thread(new Runnable() {
      @Override
      public void run() {
        database.getItemDao().insert();
      }
    }).start();
  }

}

