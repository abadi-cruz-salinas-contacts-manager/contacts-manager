package contactManager;

class Contact{
    String name;
    String phone;
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    public String getName() {
        return this.name;
    }
    public String getPhone() {
        return this.phone;
    }
}