
package com.projects.campout.J.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.projects.campout.J.model.api.pojo.SectionWithItems;
import com.projects.campout.J.service.GoogleSignInService;
import com.projects.campout.J.view.ItemAdapter;
import com.projects.campout.J.viewmodel.MainViewModel;
import com.projects.campout.J.R;
import com.projects.campout.J.model.api.pojo.SectionWithItems;
import com.projects.campout.J.service.GoogleSignInService;
import com.projects.campout.J.view.ItemAdapter;
import com.projects.campout.J.viewmodel.MainViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

  private RecyclerView recyclerview;
  ItemAdapter adapter;
  private MainViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    init();
    viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    viewModel.refresh();
    viewModel.getSections().observe(this, (sections) -> {

      List<Object> items = new ArrayList<>();
      for (SectionWithItems section: sections){
        items.add(section);
        items.addAll(section.getItems());
      }
      ItemAdapter adapter = new ItemAdapter(this,items);
      recyclerview.setAdapter(adapter);

    });
  }



  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    boolean handled = true;
    switch (item.getItemId()) {
      case R.id.sign_out:
        signOut();
        break;
      default:
        handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }

  private void signOut() {
    GoogleSignInService.getInstance().signOut()
        .addOnCompleteListener((task) -> {
          Intent intent = new Intent(this, LoginActivity.class);
          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);
        });
  }


  public void init() {

    recyclerview = findViewById(R.id.recyclerview);
    RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
    recyclerview.setLayoutManager(manager);


  }



}