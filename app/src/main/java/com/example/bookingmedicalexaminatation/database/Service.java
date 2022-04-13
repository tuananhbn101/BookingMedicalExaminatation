package com.example.bookingmedicalexaminatation.database;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookingmedicalexaminatation.model.Admin;
import com.example.bookingmedicalexaminatation.model.Appointment;
import com.example.bookingmedicalexaminatation.model.Doctor;
import com.example.bookingmedicalexaminatation.model.Patient;
import com.example.bookingmedicalexaminatation.model.WorkSchedule;
import com.example.bookingmedicalexaminatation.util.Const;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Service {
    private DatabaseReference databaseReference;
    private ExecutorService executorService;
    private final int THREAD_NUMBER = 4;

    public Service() {
        databaseReference = DataBaseSingleton.getInstance().getDatabaseReference();
        executorService = Executors.newFixedThreadPool(THREAD_NUMBER);
    }

    public void registerAccount(Patient patient, RegisterCallBack registerCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                databaseReference.child(Const.PATIENT_ROLE).child(patient.getId()).setValue(patient, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error != null) {
                            registerCallBack.registerSuccess(false);
                        } else {
                            registerCallBack.registerSuccess(true);
                        }
                    }
                });
            }
        });
    }

    public void registerAccount(Doctor doctor, RegisterCallBack registerCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                databaseReference.child(Const.DOCTOR_ROLE).child(doctor.getId()).setValue(doctor, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error != null) {
                            registerCallBack.registerSuccess(false);
                        } else {
                            registerCallBack.registerSuccess(true);
                        }
                    }
                });
            }
        });
    }

    public void updateAccount(Patient patient, CallBack callback) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                databaseReference.child(Const.PATIENT_ROLE).child(patient.getId()).setValue(patient, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error != null) {
                            callback.updateSuccess(false);
                        } else {
                            callback.updateSuccess(true);
                        }
                    }
                });
            }
        });
    }

    public void updateAccount(Doctor doctor, CallBack callback) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                databaseReference.child(Const.DOCTOR_ROLE).child(doctor.getId()).setValue(doctor, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error != null) {
                            callback.updateSuccess(false);
                        } else {
                            callback.updateSuccess(true);
                        }
                    }
                });
            }
        });
    }

    public void login(String userName, String password, String userRole, LoginCallBack loginCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Query query = databaseReference.child(userRole).orderByChild("userName").equalTo(userName);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            if (userRole.equals(Const.ADMIN_ROLE)) {
                                Admin admin = snapshot.getChildren().iterator().next().getValue(Admin.class);
                                if (admin != null) {
                                    if (password.equals(admin.getPassword())) {
                                        loginCallBack.loginSuccess(snapshot.getChildren().iterator().next().getKey(), userRole);
                                    } else {
                                        loginCallBack.loginSuccess("", "");
                                    }
                                }
                            } else if (userRole.equals(Const.PATIENT_ROLE)) {
                                Patient patient = snapshot.getChildren().iterator().next().getValue(Patient.class);
                                if (patient != null) {
                                    if (password.equals(patient.getPassword())) {
                                        loginCallBack.loginSuccess(snapshot.getChildren().iterator().next().getKey(), userRole);
                                    } else {
                                        loginCallBack.loginSuccess("", "");
                                    }
                                }
                            } else {
                                Doctor doctor = snapshot.getChildren().iterator().next().getValue(Doctor.class);
                                if (doctor != null) {
                                    if (password.equals(doctor.getPassWord())) {
                                        loginCallBack.loginSuccess(snapshot.getChildren().iterator().next().getKey(), userRole);
                                    } else {
                                        loginCallBack.loginSuccess("", "");
                                    }
                                }
                            }
                        } else {
                            loginCallBack.loginSuccess("", "");
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    public void checkUserNameExisted(String username, String userRole, RegisterCallBack registerCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Query query = databaseReference.child(userRole).orderByChild("userName").equalTo(username);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            registerCallBack.userNameExist(true);
                        } else {
                            registerCallBack.userNameExist(false);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    public void getAccount(String id, String userRole, CallBack callback) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                databaseReference.child(userRole).child(id).get().addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.e("firebase", "Error getting data", task.getException());
                    } else {
                        if (userRole.equals(Const.PATIENT_ROLE)) {
                            callback.requestPatientSuccess(task.getResult().getValue(Patient.class));
                        } else {
                            callback.requestDoctorSuccess(task.getResult().getValue(Doctor.class));
                        }
                    }
                });
            }
        });
    }

    public void getAccounts(String userRole, CallBack callback) {
        List<Doctor> doctors = new ArrayList<>();
        List<Patient> patients = new ArrayList<>();
        databaseReference.child(userRole).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if (userRole.equals(Const.DOCTOR_ROLE)) {
                    Doctor doctor = snapshot.getValue(Doctor.class);
                    doctors.add(doctor);
                    callback.requestDoctorsSuccess(doctors);
                } else {
                    Patient patient = snapshot.getValue(Patient.class);
                    patients.add(patient);
                    callback.requestPatientsSuccess(patients);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void createAppointment(Appointment appointment, AppointmentCallBack appointmentCallBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                databaseReference.child(Const.APPOINTMENT).child(appointment.getId()).setValue(appointment, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error != null) {
                            appointmentCallBack.createSuccess(false);
                        } else {
                            appointmentCallBack.createSuccess(true);
                        }
                    }
                });
            }
        });
    }

    public void getAppointments(String userName, String userRole, AppointmentCallBack callBack) {
        executorService.execute(new Runnable() {
            List<Appointment> appointments = new ArrayList<>();

            @Override
            public void run() {
                Query query;
                if (userRole.equals(Const.PATIENT_ROLE)) {
                    query = databaseReference.child(Const.APPOINTMENT).orderByChild("patientUserName").equalTo(userName);
                } else {
                    query = databaseReference.child(Const.APPOINTMENT).orderByChild("doctorUserName").equalTo(userName);
                }
                query.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        Appointment appointment = snapshot.getValue(Appointment.class);
                        appointments.add(appointment);
                        callBack.getAppointmentsSuccess(appointments);
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }

    public void registerWorkSchedule(WorkSchedule workSchedule, WorkCallBack callBack) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                databaseReference.child(Const.WORK_SCHEDULE).child(workSchedule.getId()).setValue(workSchedule, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if (error != null) {
                            callBack.registerWorkScheduleSuccess(false);
                        } else {
                            callBack.registerWorkScheduleSuccess(true);
                        }
                    }
                });
            }
        });
    }

    public void getWorkSchedules(String username, WorkCallBack callBack) {
        List<WorkSchedule> workSchedules = new ArrayList<>();
        Query query = databaseReference.child(Const.WORK_SCHEDULE).orderByChild("userName").equalTo(username);
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                WorkSchedule workSchedule = snapshot.getValue(WorkSchedule.class);
                workSchedules.add(workSchedule);
                callBack.requestWorkSchedulesSuccess(workSchedules);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public interface CallBack {
        void requestPatientSuccess(Patient patient);

        void requestDoctorSuccess(Doctor doctor);

        void requestPatientsSuccess(List<Patient> patients);

        void requestDoctorsSuccess(List<Doctor> doctors);

        void updateSuccess(Boolean isSuccess);
    }

    public interface WorkCallBack {
        void registerWorkScheduleSuccess(Boolean isSuccess);

        void requestWorkSchedulesSuccess(List<WorkSchedule> workSchedules);
    }

    public interface RegisterCallBack {
        void registerSuccess(boolean isSuccess);

        void userNameExist(boolean isExist);
    }

    public interface LoginCallBack {
        void loginSuccess(String accountId, String userRole);
    }

    public interface AppointmentCallBack {
        void createSuccess(Boolean isSuccess);

        void getAppointmentsSuccess(List<Appointment> appointments);
    }
}
