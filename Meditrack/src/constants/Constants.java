package constants;
public final class Constants {

    // Private constructor to prevent object creation
    private Constants() {}

    // Tax rate used in billing
    public static final double TAX_RATE = 0.18;

    public static final String MAIN_MENU =
            "\n===== MediTrack Menu =====\n" +
                    "1. Add Patient\n" +
                    "2. Add Doctor\n" +
                    "3. View Patients\n" +
                    "4. View Doctors\n" +
                    "5. Create Appointment\n" +
                    "6. View Appointments\n" +
                    "7. Cancel Appointment\n" +
                    "8. Exit\n";

    // File paths for persistence
    public static final String PATIENT_FILE = "data/patients.csv";
    public static final String DOCTOR_FILE = "data/doctors.csv";
    public static final String APPOINTMENT_FILE = "data/appointments.csv";

    // Default consultation fee
    public static final double DEFAULT_CONSULTATION_FEE = 500.0;

    // Date format used in application
    public static final String DATE_FORMAT = "dd-MM-yyyy";

    // Application messages
    public static final String APPOINTMENT_CREATED = "Appointment created successfully.";
    public static final String APPOINTMENT_CANCELLED = "Appointment cancelled successfully.";
    public static final String INVALID_INPUT = "Invalid input provided.";

}
