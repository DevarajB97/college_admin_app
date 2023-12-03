package com.harshini.jbasadmin.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.harshini.jbasadmin.R;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {
    FloatingActionButton fab;
    private RecyclerView administrativeTeacher,mathsbscteacher, statisticsbsc, microbiologybsc, ecbsc, csbsc, iddbsc, infobcom, bcom, csbcom, honoursbcom, afbcom, bba, bca, corporateeconomicsba, englishliteratureba, ttmba, others;
    private LinearLayout administrativeNoData, mathsbscteacherNoData, statisticsbscNoData, microbiologybscNoData, ecbscNoData,csbscNoData, iddbscNoData, infobcomNoData, bcomNoData, csbcomNoData,honoursbcomNoData,afbcomNoData,bbaNoData, bcaNoData, corporateeconomicsbaNoData, englishliteraturebaNoData, ttmbaNoData, othersNoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6, list7, list8, list9, list10, list11, list12, list13, list14, list15, list16, list17, list18;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        administrativeTeacher = findViewById(R.id.administrativeTeacher);
        mathsbscteacher = findViewById(R.id.mathsbscteacher);
        statisticsbsc = findViewById(R.id.statisticsbsc);
        microbiologybsc = findViewById(R.id.microbiologybsc);
        ecbsc = findViewById(R.id.ecbsc);
        csbsc = findViewById(R.id.csbsc);
        iddbsc = findViewById(R.id.iddbsc);
        infobcom = findViewById(R.id.infobcom);
        bcom = findViewById(R.id.bcom);
        csbcom = findViewById(R.id.csbcom);
        honoursbcom = findViewById(R.id.honoursbcom);
        afbcom = findViewById(R.id.afbcom);
        bba = findViewById(R.id.bba);
        bca = findViewById(R.id.bca);
        corporateeconomicsba = findViewById(R.id.corporateeconomicsba);
        englishliteratureba = findViewById(R.id.englishliteratureba);
        ttmba = findViewById(R.id.ttmba);
        others = findViewById(R.id.others);


        administrativeNoData = findViewById(R.id.administrativeNoData);
        mathsbscteacherNoData = findViewById(R.id.mathsbscteacherNoData);
        statisticsbscNoData = findViewById(R.id.statisticsbscNoData);
        microbiologybscNoData = findViewById(R.id.microbiologybscNoData);
        ecbscNoData = findViewById(R.id.ecbscNoData);
        csbscNoData = findViewById(R.id.csbscNoData);
        iddbscNoData = findViewById(R.id.iddbscNoData);
        infobcomNoData = findViewById(R.id.infobcomNoData);
        bcomNoData = findViewById(R.id.bcomNoData);
        csbcomNoData = findViewById(R.id.csbcomNoData);
        honoursbcomNoData = findViewById(R.id.honoursbcomNoData);
        afbcomNoData = findViewById(R.id.afbcomNoData);
        bbaNoData = findViewById(R.id.bbaNoData);
        bcaNoData = findViewById(R.id.bcaNoData);
        corporateeconomicsbaNoData = findViewById(R.id.corporateeconomicsbaNoData);
        englishliteraturebaNoData = findViewById(R.id.englishliteraturebaNoData);
        ttmbaNoData = findViewById(R.id.ttmbaNoData);
        othersNoData = findViewById(R.id.othersNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");


        administrativeTeacher();
        mathsTeacher();
        statTeacher();
        microbscTeacher();
        ecbscTeacher();
        csbscTeacher();
        idbscTeacher();
        isbcomTeacher();
        bcomTeacher();
        csbcomTeacher();
        honobcomTeacher();
        afbcomTeacher();
        bbaTeacher();
        bccTeacher();
        cebaTeacher();
        elbaTeacher();
        ttmbaTeacher();
        others();


        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this, AddTeachers.class));
            }
        });
    }

    private void administrativeTeacher() {
        dbRef = reference.child("Administrative");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    administrativeNoData.setVisibility(View.VISIBLE);
                    administrativeTeacher.setVisibility(View.GONE);
                }else {
                    administrativeNoData.setVisibility(View.GONE);
                    administrativeTeacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    administrativeTeacher.setHasFixedSize(true);
                    administrativeTeacher.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this, "Administrative");
                    administrativeTeacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mathsTeacher() {
        dbRef = reference.child("Mathematics Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    mathsbscteacherNoData.setVisibility(View.VISIBLE);
                    mathsbscteacher.setVisibility(View.GONE);
                }else {
                    mathsbscteacherNoData.setVisibility(View.GONE);
                    mathsbscteacher.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mathsbscteacher.setHasFixedSize(true);
                    mathsbscteacher.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2, UpdateFaculty.this, "Mathematics Department");
                    mathsbscteacher.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void statTeacher() {
        dbRef = reference.child("Statistics Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    statisticsbscNoData.setVisibility(View.VISIBLE);
                    statisticsbsc.setVisibility(View.GONE);
                }else {
                    statisticsbscNoData.setVisibility(View.GONE);
                    statisticsbsc.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    statisticsbsc.setHasFixedSize(true);
                    statisticsbsc.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3, UpdateFaculty.this,"Statistics Department");
                    statisticsbsc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void microbscTeacher() {
        dbRef = reference.child("Microbiology Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    microbiologybscNoData.setVisibility(View.VISIBLE);
                    microbiologybsc.setVisibility(View.GONE);
                }else {
                    microbiologybscNoData.setVisibility(View.GONE);
                    microbiologybsc.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    microbiologybsc.setHasFixedSize(true);
                    microbiologybsc.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4, UpdateFaculty.this,"Microbiology Department");
                    microbiologybsc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ecbscTeacher() {
        dbRef = reference.child("Electronics and Communication Science Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    ecbscNoData.setVisibility(View.VISIBLE);
                    ecbsc.setVisibility(View.GONE);
                }else {
                    ecbscNoData.setVisibility(View.GONE);
                    ecbsc.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    ecbsc.setHasFixedSize(true);
                    ecbsc.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list5, UpdateFaculty.this,"Electronics and Communication Science Department");
                    ecbsc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
////////////////////////////////////////////////////////////////
    private void csbscTeacher() {
        dbRef = reference.child("Computer Science Department BSC");
        dbRef.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            list6 = new ArrayList<>();
            if(!dataSnapshot.exists()){
                csbscNoData.setVisibility(View.VISIBLE);
                csbsc.setVisibility(View.GONE);
            }else {
                csbscNoData.setVisibility(View.GONE);
                csbsc.setVisibility(View.VISIBLE);
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    TeacherData data = snapshot.getValue(TeacherData.class);
                    list6.add(data);
                }
                csbsc.setHasFixedSize(true);
                csbsc.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                adapter = new TeacherAdapter(list6, UpdateFaculty.this,"Computer Science Department BSC");
                csbsc.setAdapter(adapter);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });
}
//
    private void idbscTeacher() {
        dbRef = reference.child("Interior and Decor Design Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    iddbscNoData.setVisibility(View.VISIBLE);
                    iddbsc.setVisibility(View.GONE);
                }else {
                    iddbscNoData.setVisibility(View.GONE);
                    iddbsc.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    iddbsc.setHasFixedSize(true);
                    iddbsc.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list7, UpdateFaculty.this,"Interior and Decor Design Department");
                    iddbsc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
//
    private void isbcomTeacher() {
        dbRef = reference.child("Information System Management Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    infobcomNoData.setVisibility(View.VISIBLE);
                    infobcom.setVisibility(View.GONE);
                }else {
                    infobcomNoData.setVisibility(View.GONE);
                    infobcom.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list8.add(data);
                    }
                    infobcom.setHasFixedSize(true);
                    infobcom.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list8, UpdateFaculty.this,"Information System Management Department");
                    infobcom.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
//
    private void bcomTeacher() {
        dbRef = reference.child("Bachelor of Commerce Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bcomNoData.setVisibility(View.VISIBLE);
                    bcom.setVisibility(View.GONE);
                }else {
                    bcomNoData.setVisibility(View.GONE);
                    bcom.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list9.add(data);
                    }
                    bcom.setHasFixedSize(true);
                    bcom.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list9, UpdateFaculty.this,"Bachelor of Commerce Department");
                    bcom.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
//
    private void csbcomTeacher() {
        dbRef = reference.child("Computer Science Department BCOM");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csbcomNoData.setVisibility(View.VISIBLE);
                    csbcom.setVisibility(View.GONE);
                }else {
                    csbcomNoData.setVisibility(View.GONE);
                    csbcom.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list10.add(data);
                    }
                    csbcom.setHasFixedSize(true);
                    csbcom.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list10, UpdateFaculty.this,"Computer Science Department BCOM");
                    csbcom.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
//
    private void honobcomTeacher() {
        dbRef = reference.child("Honours Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list11 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    honoursbcomNoData.setVisibility(View.VISIBLE);
                    honoursbcom.setVisibility(View.GONE);
                }else {
                    honoursbcomNoData.setVisibility(View.GONE);
                    honoursbcom.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list11.add(data);
                    }
                    honoursbcom.setHasFixedSize(true);
                    honoursbcom.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list11, UpdateFaculty.this,"Honours Department");
                    honoursbcom.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//
    private void afbcomTeacher() {
        dbRef = reference.child("Accounts and Finance Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list12 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    afbcomNoData.setVisibility(View.VISIBLE);
                    afbcom.setVisibility(View.GONE);
                }else {
                    afbcomNoData.setVisibility(View.GONE);
                    afbcom.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list12.add(data);
                    }
                    afbcom.setHasFixedSize(true);
                    afbcom.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list12, UpdateFaculty.this,"Accounts and Finance Department");
                    afbcom.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
//
    private void bbaTeacher() {
        dbRef = reference.child("Bachelor of Business Administration Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list13 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bbaNoData.setVisibility(View.VISIBLE);
                    bba.setVisibility(View.GONE);
                }else {
                    bbaNoData.setVisibility(View.GONE);
                    bba.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list13.add(data);
                    }
                    bba.setHasFixedSize(true);
                    bba.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list13, UpdateFaculty.this,"Bachelor of Business Administration Department");
                    bba.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
//
    private void bccTeacher() {
        dbRef = reference.child("Bachelor of Computer Application Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list14 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bcaNoData.setVisibility(View.VISIBLE);
                    bca.setVisibility(View.GONE);
                }else {
                    bcaNoData.setVisibility(View.GONE);
                    bca.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list14.add(data);
                    }
                    bca.setHasFixedSize(true);
                    bca.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list14, UpdateFaculty.this,"Bachelor of Computer Application Department");
                    bca.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
//
    private void cebaTeacher() {
        dbRef = reference.child("Corporate Economics Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list15 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    corporateeconomicsbaNoData.setVisibility(View.VISIBLE);
                    corporateeconomicsba.setVisibility(View.GONE);
                }else {
                    corporateeconomicsbaNoData.setVisibility(View.GONE);
                    corporateeconomicsba.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list15.add(data);
                    }
                    corporateeconomicsba.setHasFixedSize(true);
                    corporateeconomicsba.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list15, UpdateFaculty.this,"Corporate Economics Department");
                    corporateeconomicsba.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//
    private void elbaTeacher() {
        dbRef = reference.child("English Literature Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list16 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    englishliteraturebaNoData.setVisibility(View.VISIBLE);
                    englishliteratureba.setVisibility(View.GONE);
                }else {
                    englishliteraturebaNoData.setVisibility(View.GONE);
                    englishliteratureba.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list16.add(data);
                    }
                    englishliteratureba.setHasFixedSize(true);
                    englishliteratureba.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list16, UpdateFaculty.this,"English Literature Department");
                    englishliteratureba.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

//
    private void ttmbaTeacher() {
        dbRef = reference.child("Tourism and Travel Management Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list17 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    ttmbaNoData.setVisibility(View.VISIBLE);
                    ttmba.setVisibility(View.GONE);
                }else {
                    ttmbaNoData.setVisibility(View.GONE);
                    ttmba.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list17.add(data);
                    }
                    ttmba.setHasFixedSize(true);
                    ttmba.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list17, UpdateFaculty.this,"Tourism and Travel Management Department");
                    ttmba.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void others() {
        dbRef = reference.child("Others");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list18 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    othersNoData.setVisibility(View.VISIBLE);
                    others.setVisibility(View.GONE);
                }else {
                    othersNoData.setVisibility(View.GONE);
                    others.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list18.add(data);
                    }
                    others.setHasFixedSize(true);
                    others.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list18, UpdateFaculty.this,"Others");
                    others.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}