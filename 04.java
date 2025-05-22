class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() { return ticketNumber; }
    public String getCustomerName() { return customerName; }
    public int getSeatNumber() { return seatNumber; }
}

class BookingSystem {
    private Ticket[] tickets;
    private boolean[] seats;
    private int ticketCount;

    public BookingSystem() {
        tickets = new Ticket[10];
        seats = new boolean[10];
        ticketCount = 0;
    }

    public boolean bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number (1-10 only)");
            return false;
        }
        
        if (seats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " already booked");
            return false;
        }
        
        if (ticketCount >= 10) {
            System.out.println("All seats booked");
            return false;
        }
        
        tickets[ticketCount++] = new Ticket(ticketNumber, customerName, seatNumber);
        seats[seatNumber - 1] = true;
        return true;
    }

    public boolean cancelTicket(int ticketNumber) {
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                int seat = tickets[i].getSeatNumber();
                seats[seat - 1] = false;
                
                // Shift remaining tickets
                for (int j = i; j < ticketCount - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                tickets[--ticketCount] = null;
                return true;
            }
        }
        System.out.println("Ticket " + ticketNumber + " not found");
        return false;
    }

    public void displayAllBookings() {
        System.out.println("Ticket #\tCustomer\tSeat #");
        System.out.println("--------------------------------");
        for (int i = 0; i < ticketCount; i++) {
            System.out.printf("%-10d\t%-15s\t%d\n",
                tickets[i].getTicketNumber(),
                tickets[i].getCustomerName(),
                tickets[i].getSeatNumber());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BookingSystem cinema = new BookingSystem();
        
        cinema.bookTicket(1, "Customer 1", 1);
        cinema.bookTicket(2, "Customer 2", 2);
        cinema.bookTicket(3, "Customer 3", 3);
        
        cinema.cancelTicket(2);
        cinema.bookTicket(4, "Customer 4", 2);
        
        cinema.displayAllBookings();
    }
}