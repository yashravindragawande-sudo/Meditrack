package service;

import entity.Appointment;
import entity.Doctor;
import entity.Patient;
import exception.AppointmentNotFoundException;
import util.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    private Map<Integer, Appointment> appointmentMap = new HashMap<>();

    public void createAppointment(Doctor doctor, Patient patient) {

        int id = IdGenerator.getInstance().generateId();

        Appointment appointment = new Appointment(id, doctor, patient);

        appointmentMap.put(id, appointment);

        System.out.println("Appointment created with ID: " + id);
    }

    public void cancelAppointment(int id) {

        Appointment appointment = appointmentMap.get(id);

        if (appointment == null) {
            throw new AppointmentNotFoundException("Appointment not found with ID: " + id);
        }

        appointment.cancel();

        System.out.println("Appointment cancelled.");
    }

    public void displayAppointments() {

        if (appointmentMap.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment appointment : appointmentMap.values()) {
            appointment.display();
        }
    }
}