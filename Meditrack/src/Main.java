import constants.Constants;
import entity.Doctor;
import entity.Patient;
import enums.Specialization;
import service.AppointmentService;
import service.DoctorService;
import service.PatientService;
import util.IdGenerator;

import java.util.Scanner;

public class Main {

    private static DoctorService doctorService = new DoctorService();
    private static PatientService patientService = new PatientService();
    private static AppointmentService appointmentService = new AppointmentService();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("===== Welcome to MediTrack System =====");

        boolean running = true;

        while (running) {

            System.out.println(Constants.MAIN_MENU);
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    addDoctor();
                    break;

                case 3:
                    viewPatients();
                    break;

                case 4:
                    viewDoctors();
                    break;

                case 5:
                    createAppointment();
                    break;

                case 6:
                    viewAppointments();
                    break;

                case 7:
                    cancelAppointment();
                    break;

                case 8:
                    running = false;
                    System.out.println("Exiting MediTrack...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // ================= PATIENT =================

    private static void addPatient() {

        int id = IdGenerator.getInstance().generateId();

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();

        Patient patient = new Patient(id, name, age, disease);

        patientService.addPatient(patient);

        System.out.println("Patient added successfully.");
    }

    private static void viewPatients() {

        System.out.println("\n--- Patient List ---");

        patientService.displayPatients();
    }

    // ================= DOCTOR =================

    private static void addDoctor() {

        int id = IdGenerator.getInstance().generateId();

        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.println("Select Specialization:");

        for (Specialization s : Specialization.values()) {
            System.out.println(s.ordinal() + " - " + s);
        }

        int specChoice = scanner.nextInt();
        scanner.nextLine();

        Specialization specialization = Specialization.values()[specChoice];

        System.out.print("Enter Consultation Fee: ");
        double fee = scanner.nextDouble();
        scanner.nextLine();

        Doctor doctor = new Doctor(id, name, age, specialization, fee);

        doctorService.addDoctor(doctor);

        System.out.println("Doctor added successfully.");
    }

    private static void viewDoctors() {

        System.out.println("\n--- Doctor List ---");

        doctorService.displayDoctors();
    }

    // ================= APPOINTMENT =================

    private static void createAppointment() {

        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Doctor doctor = doctorService.getDoctorById(doctorId);
        Patient patient = patientService.searchPatient(patientId);

        if (doctor == null || patient == null) {
            System.out.println("Doctor or Patient not found.");
            return;
        }

        appointmentService.createAppointment(doctor, patient);
    }

    private static void viewAppointments() {

        System.out.println("\n--- Appointment List ---");

        appointmentService.displayAppointments();
    }

    private static void cancelAppointment() {

        System.out.print("Enter Appointment ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            appointmentService.cancelAppointment(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}