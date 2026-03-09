package service;

import entity.Patient;
import util.DataStore;

import java.util.List;
import java.util.stream.Collectors;

public class PatientService {

    private DataStore<Patient> patientStore = new DataStore<>();

    // Create Patient
    public void addPatient(Patient patient) {
        patientStore.add(patient);
        System.out.println("Patient added successfully.");
    }

    // Read All Patients
    public List<Patient> getAllPatients() {
        return patientStore.getAll();
    }

    // Search by ID (Overloading)
    public Patient searchPatient(int id) {
        for (Patient p : patientStore.getAll()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Search by Name
    public List<Patient> searchPatient(String name) {
        return patientStore.getAll()
                .stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Search by Age
    public List<Patient> searchPatientByAge(int age) {
        return patientStore.getAll()
                .stream()
                .filter(p -> p.getAge() == age)
                .collect(Collectors.toList());
    }

    // Display All
    public void displayPatients() {
        patientStore.getAll().forEach(Patient::displayDetails);
    }
}