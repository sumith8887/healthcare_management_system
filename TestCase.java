package health_care_management;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Dummy model classes
class Patient {
    String name; int age; String gender, contact;
    Patient(String n, int a, String g, String c) { name = n; age = a; gender = g; contact = c; }
}

class Doctor {
    String name, specialization, contact;
    Doctor(String n, String s, String c) { name = n; specialization = s; contact = c; }
}

class Appointment {
    int patientId, doctorId;
    String date;
    Appointment(int pId, int dId, String d) { patientId = pId; doctorId = dId; date = d; }
}

class Prescription {
    int appointmentId;
    String medicine;
    Prescription(int aId, String m) { appointmentId = aId; medicine = m; }
}

class Treatment {
    int appointmentId;
    String details;
    Treatment(int aId, String d) { appointmentId = aId; details = d; }
}

class Bill {
    int treatmentId;
    double total;
    Bill(int id, double t) { treatmentId = id; total = t; }
    double getTotal() { return total; }
}

// Dummy service classes
class PatientService {
    boolean addPatient(Patient p) { return true; }
}

class DoctorService {
    boolean addDoctor(Doctor d) { return true; }
}

class AppointmentService {
    boolean bookAppointment(Appointment a) { return true; }
}

class PrescriptionService {
    boolean assignPrescription(Prescription p) { return true; }
}

class TreatmentService {
    boolean assignTreatment(Treatment t) { return true; }
}

class BillingService {
    Bill generateBill(int treatmentId) { return new Bill(treatmentId, 500.0); }
}

// Test Class
public class HealthcareClinicSystemTest {

    @Test
    void testAddPatient() {
        PatientService service = new PatientService();
        Patient patient = new Patient("John Doe", 30, "Male", "9876543210");
        assertTrue(service.addPatient(patient));
    }

    @Test
    void testAddDoctor() {
        DoctorService service = new DoctorService();
        Doctor doctor = new Doctor("Dr. Smith", "Cardiology", "1234567890");
        assertTrue(service.addDoctor(doctor));
    }

    @Test
    void testBookAppointment() {
        AppointmentService service = new AppointmentService();
        Appointment appointment = new Appointment(1, 1, "2025-04-25");
        assertTrue(service.bookAppointment(appointment));
    }

    @Test
    void testAssignPrescription() {
        PrescriptionService service = new PrescriptionService();
        Prescription prescription = new Prescription(1, "Paracetamol 500mg");
        assertTrue(service.assignPrescription(prescription));
    }

    @Test
    void testAssignTreatment() {
        TreatmentService service = new TreatmentService();
        Treatment treatment = new Treatment(1, "X-Ray & Consultation");
        assertTrue(service.assignTreatment(treatment));
    }

    @Test
    void testGenerateBill() {
        BillingService service = new BillingService();
        Bill bill = service.generateBill(1);
        assertNotNull(bill);
        assertTrue(bill.getTotal() > 0);
    }
}
