package entity;
import constants.Constants;
import enums.AppointmentStatus;

public class Appointment implements Cloneable {

    private int id;
    private Doctor doctor;
    private Patient patient;
    private AppointmentStatus status;

    public Appointment(int id, Doctor doctor, Patient patient) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.status = AppointmentStatus.CONFIRMED;
    }

    public void cancel() {
        status = AppointmentStatus.CANCELLED;
    }

    public Appointment clone() {
        return new Appointment(id, doctor, patient.clone());
    }

    public void display() {
        System.out.println("Appointment ID: " + id +
                " Doctor: " + doctor.getId() +
                " Patient: " + patient.getId() +
                " Status: " + status);
        System.out.println(Constants.APPOINTMENT_CREATED);
    }

}
