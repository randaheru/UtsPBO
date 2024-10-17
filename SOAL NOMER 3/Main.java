// Kelas UserProfile
class UserProfile {
    protected int user_id;
    protected String password;
    protected String name;
    protected int age;
    protected String email;
    protected String doc;

    public UserProfile(int user_id, String password, String name, int age, String email, String doc) {
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.email = email;
        this.doc = doc;
    }

    public int getUserId() {
        return user_id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void editProfile(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void showDocuments() {
        System.out.println("Dokumen: " + doc);
    }
}

// Kelas User
class User extends UserProfile {

    public User(int user_id, String password, String name, int age, String email, String doc) {
        super(user_id, password, name, age, email, doc);
    }

    public void logIn(int user_id, String password) {
        if (this.user_id == user_id && this.password.equals(password)) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Login gagal.");
        }
    }

    public void recoverPassword() {
        System.out.println("Proses pemulihan password...");
    }

    public void logOut() {
        System.out.println("Logout berhasil.");
    }
}

// Kelas Customer
class Customer extends User {
    private boolean verification_status = false;

    public Customer(int user_id, String password, String name, int age, String email, String doc) {
        super(user_id, password, name, age, email, doc);
    }

    public boolean getVerificationStatus() {
        return verification_status;
    }

    public void applyVerification(String doc) {
        this.doc = doc;
        this.verification_status = true;
        System.out.println("Verifikasi berhasil!");
    }
}

// Kelas Admin
class Admin extends User {

    public Admin(int user_id, String password, String name, int age, String email, String doc) {
        super(user_id, password, name, age, email, doc);
    }

    public void updateVehicleDetails(int vehicle_id) {
        System.out.println("Detail kendaraan dengan ID " + vehicle_id + " diperbarui.");
    }

    public void addVehicle() {
        System.out.println("Kendaraan ditambahkan.");
    }

    public void retrieveComplain() {
        System.out.println("Mengambil keluhan pengguna...");
    }

    public void verifyUser() {
        System.out.println("Pengguna diverifikasi.");
    }
}

// Main Class untuk Pengujian
public class Main {
    public static void main(String[] args) {
        // Membuat objek Admin
        Admin admin = new Admin(1, "admin123", "Admin", 35, "admin@example.com", ".pdf");
        admin.logIn(1, "admin123");
        admin.addVehicle();
        admin.updateVehicleDetails(1001);
        admin.verifyUser();
        admin.logOut();

        // Membuat objek Customer
        Customer customer = new Customer(2, "cust123", "Customer", 25, "customer@example.com", ".jpg");
        customer.logIn(2, "cust123");
        customer.applyVerification(".jpg");
        System.out.println("Status Verifikasi: " + (customer.getVerificationStatus() ? "Terverifikasi" : "Belum Terverifikasi"));
        customer.logOut();
    }
}
