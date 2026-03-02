// NO NEED THIS SUBMIT THIS CLASS
public class WRM {
    Patient dh;

    //The constructor is already created for you
    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }

    public void registerPatient(int id, String name, int age, String bloodgroup) {
        // To Do

        Patient new_patient = new Patient(id, name, age, bloodgroup, null, null);
        Patient tail = dh.prev;

        new_patient.next = dh;
        new_patient.prev = tail;
        tail.next = new_patient;
        dh.prev = new_patient;

        System.out.println("Patient reigstered: " + id + " " + name);

    }

    public void servePatient() {
        // To do

        if(dh.next == dh) {
            System.out.println("No patient to serve.");
            return;
        }

        Patient first = dh.next;

        dh.next = first.next;
        first.next.prev = dh;

        System.out.println("Serving patient: " + first.id + " " + first.name);
    }

    public void showAllPatient() {
        // To Do

        if(dh.next == dh) {
            System.out.println("No patient in the waiting room.");
            return;
        }

        Patient temp = dh.next;

        while(temp != dh) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Age: " + temp.age + ", BloodGroup: " + temp.bloodGroup);
            temp = temp.next;
        }
    }

    public Boolean canDoctorGoHome() {
        // To Do
        // return null; // Delete this line once you're ready
        return dh.next == dh;
    }

    public void cancelAll() {
        // To Do

        dh.next = dh;
        dh.prev = dh;
        System.out.println("All appointments cancelled.");
    }


    public void reverseTheLine() {
        // To Do

        if(dh.next == dh || dh.next.next == dh) {
            System.out.println("Nothing to reverse.");
            return;
        }

        Patient current = dh.next;

        while(current != dh) {
            Patient temp = current.next;

            current.next = current.prev;
            current.prev = temp;
            current = temp;
        }

        Patient temp = dh.next;

        dh.next = dh.prev;
        dh.prev = temp;
        System.out.println("Line reversed.");
    }
}