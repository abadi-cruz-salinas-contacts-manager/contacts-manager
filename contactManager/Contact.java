package contactManager;

public class Contact {
        public String name;
        public int number;
        // constructor
        public Contact(String name, int phoneNumber) {
            this.name = name;
            this.number = phoneNumber;
        }

        public String getName(){
            return this.name;
        }

        public void setName(String name){
            this.name = name;
        }

        public int getNumber(){
            return this.number;
        }

        public void setNumber(int number){
            this.name = name;
        }
    }

