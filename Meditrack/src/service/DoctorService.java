package service;
import entity.Doctor;
import enums.Specialization;
import util.DataStore;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorService {

    private DataStore<Doctor> doctorStore = new DataStore<>();

    // Create Doctor
    public void addDoctor(Doctor doctor) {
        doctorStore.add(doctor);
        System.out.println("Doctor added successfully.");
    }

    // Get All Doctors
    public List<Doctor> getAllDoctors() {
        return doctorStore.getAll();
    }

    // Search Doctor by Specialization
    public List<Doctor> searchBySpecialization(Specialization specialization) {
        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getSpecialization() == specialization)
                .collect(Collectors.toList());
    }

    // Get Doctor by ID
    public Doctor getDoctorById(int id) {
        for (Doctor d : doctorStore.getAll()) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    // Doctor Analytics using Streams
    public void showDoctorAnalytics() {

        double avgFee = doctorStore.getAll()
                .stream()
                .mapToDouble(Doctor::getConsultationFee)
                .average()
                .orElse(0);

        System.out.println("Average Consultation Fee: " + avgFee);
    }

    // Display All Doctors
    public void displayDoctors() {
        doctorStore.getAll().forEach(Doctor::displayDetails);
    }
}