import java.util.*;

/*
===========================================================
        HOTEL MANAGEMENT SYSTEM - LLD INTERVIEW
===========================================================

HOW TO THINK IN ANY LLD QUESTION:

1. Find the main ENTITIES/NOUNS
       ↓
   Hotel, Room, User, Booking

2. Give each entity its DATA
       ↓
   id, name, price, location, etc.

3. Find RELATIONSHIPS
       ↓
   User has Bookings
   Hotel has Rooms
   Booking belongs to User and Room

4. Find OPERATIONS
       ↓
   addHotel()
   searchHotel()
   bookRoom()
   cancelBooking()

5. Put the operation in the class responsible for it.

6. Use inheritance/interface ONLY when it actually makes sense.

7. Finally test the system from main().
*/


public class hotelmanagement {


    // =====================================================
    // ENUM 1: ROOM TYPE
    // =====================================================

    /*
       Enum is useful when a variable can have a fixed set
       of values.

       Instead of:

       String type = "single";

       we use:

       RoomType.SINGLE

       This prevents invalid values like:
       "singel", "Singlee", etc.
    */

    enum RoomType {
        SINGLE,
        DOUBLE,
        DELUXE
    }


    // =====================================================
    // ENUM 2: BOOKING STATUS
    // =====================================================

    /*
       A booking can have a fixed number of states.

       CONFIRMED
       CANCELLED
    */

    enum BookingStatus {
        CONFIRMED,
        CANCELLED
    }


    // =====================================================
    // CLASS: ROOM
    // =====================================================

    /*
       Think:

       "What is a Room?"

       A Room has:

       - roomId
       - roomType
       - price
       - availability

       Therefore Room becomes a class.
    */

    static class Room {

        private int roomId;

        private RoomType roomType;

        private double price;

        private boolean available;


        // Constructor

        public Room(int roomId,
                    RoomType roomType,
                    double price) {

            this.roomId = roomId;
            this.roomType = roomType;
            this.price = price;

            // Initially every newly created room is available.
            this.available = true;
        }


        // Getter methods

        public int getRoomId() {
            return roomId;
        }


        public RoomType getRoomType() {
            return roomType;
        }


        public double getPrice() {
            return price;
        }


        public boolean isAvailable() {
            return available;
        }


        // =================================================
        // BOOK ROOM
        // =================================================

        /*
           Who should change room availability?

           ROOM itself.

           Because availability belongs to Room.

           This follows:

           "Data + behavior related to that data
            should stay together."
        */

        public boolean bookRoom() {

            if (available) {

                available = false;

                return true;
            }

            return false;
        }


        // =================================================
        // RELEASE ROOM
        // =================================================

        /*
           When booking is cancelled,
           the room becomes available again.
        */

        public void releaseRoom() {

            available = true;
        }


        @Override
        public String toString() {

            return "Room ID: " + roomId +
                    ", Type: " + roomType +
                    ", Price: " + price +
                    ", Available: " + available;
        }
    }



    // =====================================================
    // CLASS: HOTEL
    // =====================================================

    /*
       Hotel is another major ENTITY.

       Hotel has:

       - id
       - name
       - location
       - rating
       - rooms

       Relationship:

              HOTEL
                |
                | has
                ↓
              ROOMS

       This is called HAS-A relationship.
    */

    static class Hotel {

        private int hotelId;

        private String name;

        private String location;

        private int rating;


        /*
           One hotel can have MANY rooms.

           Therefore:

           List<Room>

           is used.
        */

        private List<Room> rooms;


        public Hotel(int hotelId,
                     String name,
                     String location,
                     int rating) {

            this.hotelId = hotelId;
            this.name = name;
            this.location = location;
            this.rating = rating;

            // Initially hotel has an empty room list.
            this.rooms = new ArrayList<>();
        }


        public int getHotelId() {
            return hotelId;
        }


        public String getName() {
            return name;
        }


        public String getLocation() {
            return location;
        }


        public int getRating() {
            return rating;
        }


        public List<Room> getRooms() {
            return rooms;
        }


        // =================================================
        // ADD ROOM
        // =================================================

        /*
           Hotel owns its rooms.

           Therefore addRoom() belongs naturally
           to Hotel.
        */

        public void addRoom(Room room) {

            rooms.add(room);
        }


        // =================================================
        // FIND AVAILABLE ROOM
        // =================================================

        /*
           Search through all rooms.

           Time Complexity:

           O(R)

           where R = number of rooms in this hotel.
        */

        public Room findAvailableRoom(RoomType type) {

            for (Room room : rooms) {

                if (room.getRoomType() == type &&
                    room.isAvailable()) {

                    return room;
                }
            }

            return null;
        }


        @Override
        public String toString() {

            return "Hotel ID: " + hotelId +
                    ", Name: " + name +
                    ", Location: " + location +
                    ", Rating: " + rating +
                    ", Rooms: " + rooms.size();
        }
    }



    // =====================================================
    // CLASS: USER
    // =====================================================

    /*
       User is another ENTITY.

       A user can have multiple bookings.

       Therefore:

       User
        |
        | has many
        ↓
       Bookings

       List<Booking>
    */

    static class User {

        private int userId;

        private String name;

        private List<Booking> bookings;


        public User(int userId, String name) {

            this.userId = userId;

            this.name = name;

            bookings = new ArrayList<>();
        }


        public int getUserId() {
            return userId;
        }


        public String getName() {
            return name;
        }


        public List<Booking> getBookings() {
            return bookings;
        }


        // Add booking to user's booking list.

        public void addBooking(Booking booking) {

            bookings.add(booking);
        }


        // Remove booking.

        public void removeBooking(Booking booking) {

            bookings.remove(booking);
        }
    }



    // =====================================================
    // CLASS: BOOKING
    // =====================================================

    /*
       Booking is extremely important.

       Why do we need Booking?

       Because booking represents the TRANSACTION.

       A booking connects:

              USER
                |
                ↓
             BOOKING
                |
                ↓
              ROOM
                |
                ↓
             HOTEL

       Therefore Booking contains references to:

       - User
       - Hotel
       - Room
    */

    static class Booking {

        private int bookingId;

        private User user;

        private Hotel hotel;

        private Room room;

        private BookingStatus status;


        public Booking(int bookingId,
                       User user,
                       Hotel hotel,
                       Room room) {

            this.bookingId = bookingId;

            this.user = user;

            this.hotel = hotel;

            this.room = room;

            // New booking starts as CONFIRMED.

            this.status = BookingStatus.CONFIRMED;
        }


        public int getBookingId() {
            return bookingId;
        }


        public User getUser() {
            return user;
        }


        public Hotel getHotel() {
            return hotel;
        }


        public Room getRoom() {
            return room;
        }


        public BookingStatus getStatus() {
            return status;
        }


        // =================================================
        // CANCEL BOOKING
        // =================================================

        /*
           Change booking status to CANCELLED.

           We don't delete the booking object.

           Why?

           In real systems, keeping cancelled bookings
           can be useful for history.
        */

        public void cancel() {

            status = BookingStatus.CANCELLED;
        }


        @Override
        public String toString() {

            return "Booking ID: " + bookingId +
                    ", User: " + user.getName() +
                    ", Hotel: " + hotel.getName() +
                    ", Room: " + room.getRoomId() +
                    ", Status: " + status;
        }
    }



    // =====================================================
    // INTERFACE: PAYMENT
    // =====================================================

    /*
       Now imagine interviewer asks:

       "What if the user can pay using UPI, Card,
        or Cash?"

       We should NOT write:

       if(paymentType == "UPI")
       ...
       if(paymentType == "CARD")
       ...

       Instead we can use an interface.

       Payment is the COMMON BEHAVIOR.

       Different payment methods can implement it.
    */

    interface Payment {

        boolean pay(double amount);
    }



    // =====================================================
    // UPI PAYMENT
    // =====================================================

    static class UPIPayment implements Payment {

        @Override
        public boolean pay(double amount) {

            System.out.println(
                    "Paid ₹" + amount + " using UPI"
            );

            return true;
        }
    }



    // =====================================================
    // CARD PAYMENT
    // =====================================================

    static class CardPayment implements Payment {

        @Override
        public boolean pay(double amount) {

            System.out.println(
                    "Paid ₹" + amount + " using Card"
            );

            return true;
        }
    }



    // =====================================================
    // HOTEL MANAGEMENT SYSTEM
    // =====================================================

    /*
       This is the SERVICE / MANAGER class.

       Important interview concept:

       Entity classes:
           Hotel
           Room
           User
           Booking

       Service class:
           HotelManagementSystem

       The service class coordinates different objects.

       For example:

       bookRoom()

       needs:

       User
       +
       Hotel
       +
       Room
       +
       Booking

       Therefore it makes sense for the service to
       coordinate these objects.
    */

    static class HotelManagementSystem {


        // =================================================
        // DATA STRUCTURES
        // =================================================

        /*
           We need to store hotels and users.

           List is simple and easy to understand.

           But searching by ID is O(N).

           In a larger system, HashMap would be better:

           Map<Integer, Hotel>

           because lookup becomes approximately O(1).
        */

        private List<Hotel> hotels;

        private List<User> users;

        private List<Booking> bookings;


        // Used to generate unique booking IDs.

        private int nextBookingId = 1;


        // =================================================
        // CONSTRUCTOR
        // =================================================

        public HotelManagementSystem() {

            hotels = new ArrayList<>();

            users = new ArrayList<>();

            bookings = new ArrayList<>();
        }



        // =================================================
        // ADD HOTEL
        // =================================================

        public void addHotel(Hotel hotel) {

            hotels.add(hotel);
        }



        // =================================================
        // ADD USER
        // =================================================

        public void addUser(User user) {

            users.add(user);
        }



        // =================================================
        // FIND HOTEL BY ID
        // =================================================

        /*
           Search hotel using ID.

           Time Complexity:

           O(H)

           H = number of hotels.
        */

        public Hotel findHotel(int hotelId) {

            for (Hotel hotel : hotels) {

                if (hotel.getHotelId() == hotelId) {

                    return hotel;
                }
            }

            return null;
        }



        // =================================================
        // FIND USER BY ID
        // =================================================

        public User findUser(int userId) {

            for (User user : users) {

                if (user.getUserId() == userId) {

                    return user;
                }
            }

            return null;
        }



        // =================================================
        // SEARCH HOTELS BY LOCATION
        // =================================================

        /*
           Example:

           searchByLocation("Kolkata")

           We check every hotel.

           Time Complexity:

           O(H)
        */

        public List<Hotel> searchByLocation(String location) {

            List<Hotel> result = new ArrayList<>();

            for (Hotel hotel : hotels) {

                if (hotel.getLocation()
                        .equalsIgnoreCase(location)) {

                    result.add(hotel);
                }
            }

            return result;
        }



        // =================================================
        // SEARCH HOTELS BY RATING
        // =================================================

        public List<Hotel> sortByRating() {

            /*
               Create a copy.

               This avoids changing the original hotel list.
            */

            List<Hotel> result =
                    new ArrayList<>(hotels);


            /*
               Sort hotels by rating in descending order.

               Highest rating comes first.
            */

            result.sort(
                    Comparator.comparingInt(
                            Hotel::getRating
                    ).reversed()
            );


            return result;
        }



        // =================================================
        // BOOK ROOM
        // =================================================

        /*
           This is the MOST IMPORTANT method.

           Flow:

           1. Find user
           2. Find hotel
           3. Find available room
           4. Book room
           5. Create Booking object
           6. Add booking to user
           7. Add booking to system
           8. Make payment
        */

        public Booking bookRoom(
                int userId,
                int hotelId,
                RoomType roomType,
                Payment payment) {


            // ---------------------------------------------
            // STEP 1: FIND USER
            // ---------------------------------------------

            User user = findUser(userId);


            if (user == null) {

                System.out.println(
                        "User not found."
                );

                return null;
            }



            // ---------------------------------------------
            // STEP 2: FIND HOTEL
            // ---------------------------------------------

            Hotel hotel = findHotel(hotelId);


            if (hotel == null) {

                System.out.println(
                        "Hotel not found."
                );

                return null;
            }



            // ---------------------------------------------
            // STEP 3: FIND AVAILABLE ROOM
            // ---------------------------------------------

            Room room =
                    hotel.findAvailableRoom(roomType);


            if (room == null) {

                System.out.println(
                        "No available room."
                );

                return null;
            }



            // ---------------------------------------------
            // STEP 4: BOOK THE ROOM
            // ---------------------------------------------

            /*
               bookRoom() returns true if room was available.

               It also changes:

               available = true

               to:

               available = false
            */

            boolean booked = room.bookRoom();


            if (!booked) {

                System.out.println(
                        "Room booking failed."
                );

                return null;
            }



            // ---------------------------------------------
            // STEP 5: PAYMENT
            // ---------------------------------------------

            /*
               In a real system payment failure should
               release the room.

               This is an important edge case.

               Example:

               Room booked
                    ↓
               Payment fails
                    ↓
               Room should become available again
            */

            boolean paymentSuccess =
                    payment.pay(room.getPrice());


            if (!paymentSuccess) {

                room.releaseRoom();

                System.out.println(
                        "Payment failed."
                );

                return null;
            }



            // ---------------------------------------------
            // STEP 6: CREATE BOOKING
            // ---------------------------------------------

            Booking booking =
                    new Booking(
                            nextBookingId++,
                            user,
                            hotel,
                            room
                    );



            // ---------------------------------------------
            // STEP 7: STORE BOOKING
            // ---------------------------------------------

            bookings.add(booking);

            user.addBooking(booking);



            System.out.println(
                    "Room booked successfully!"
            );


            return booking;
        }



        // =================================================
        // CANCEL BOOKING
        // =================================================

        /*
           Cancellation flow:

           1. Find booking
           2. Check status
           3. Change status
           4. Release room
        */

        public void cancelBooking(int bookingId) {


            // Find booking

            Booking booking = null;


            for (Booking b : bookings) {

                if (b.getBookingId() == bookingId) {

                    booking = b;

                    break;
                }
            }


            // Booking doesn't exist

            if (booking == null) {

                System.out.println(
                        "Booking not found."
                );

                return;
            }


            // Already cancelled

            if (booking.getStatus()
                    == BookingStatus.CANCELLED) {

                System.out.println(
                        "Booking already cancelled."
                );

                return;
            }


            // Change status

            booking.cancel();


            // Release room

            booking.getRoom().releaseRoom();


            System.out.println(
                    "Booking cancelled successfully."
            );
        }



        // =================================================
        // SHOW ALL HOTELS
        // =================================================

        public void showHotels() {

            System.out.println(
                    "\n========== HOTELS =========="
            );


            for (Hotel hotel : hotels) {

                System.out.println(hotel);


                // Also show rooms

                for (Room room : hotel.getRooms()) {

                    System.out.println(
                            "   " + room
                    );
                }
            }
        }



        // =================================================
        // SHOW USER BOOKINGS
        // =================================================

        public void showUserBookings(int userId) {

            User user = findUser(userId);


            if (user == null) {

                System.out.println(
                        "User not found."
                );

                return;
            }


            System.out.println(
                    "\nBookings of " +
                    user.getName()
            );


            if (user.getBookings().isEmpty()) {

                System.out.println(
                        "No bookings."
                );

                return;
            }


            for (Booking booking :
                    user.getBookings()) {

                System.out.println(booking);
            }
        }
    }



    // =====================================================
    // MAIN METHOD
    // =====================================================

    /*
       In an interview, main() is mainly used to
       demonstrate that your design works.

       You don't need a huge main method.

       Just show important use cases.
    */

    public static void main(String[] args) {


        // =================================================
        // STEP 1: CREATE SYSTEM
        // =================================================

        HotelManagementSystem system =
                new HotelManagementSystem();



        // =================================================
        // STEP 2: CREATE USERS
        // =================================================

        User user1 =
                new User(101, "Imran");

        User user2 =
                new User(102, "Rahul");


        system.addUser(user1);

        system.addUser(user2);



        // =================================================
        // STEP 3: CREATE HOTEL
        // =================================================

        Hotel taj =
                new Hotel(
                        1,
                        "Taj Hotel",
                        "Kolkata",
                        5
                );


        Hotel itc =
                new Hotel(
                        2,
                        "ITC Hotel",
                        "Mumbai",
                        4
                );



        // =================================================
        // STEP 4: ADD ROOMS TO HOTEL
        // =================================================

        taj.addRoom(
                new Room(
                        101,
                        RoomType.SINGLE,
                        3000
                )
        );


        taj.addRoom(
                new Room(
                        102,
                        RoomType.DOUBLE,
                        5000
                );


        taj.addRoom(
                new Room(
                        103,
                        RoomType.DELUXE,
                        8000
                );


        itc.addRoom(
                new Room(
                        201,
                        RoomType.SINGLE,
                        3500
                )
        );


        // =================================================
        // STEP 5: ADD HOTELS
        // =================================================

        system.addHotel(taj);

        system.addHotel(itc);



        // =================================================
        // STEP 6: DISPLAY HOTELS
        // =================================================

        system.showHotels();



        // =================================================
        // STEP 7: SEARCH HOTEL
        // =================================================

        System.out.println(
                "\n========== KOLKATA HOTELS =========="
        );


        List<Hotel> kolkataHotels =
                system.searchByLocation("Kolkata");


        for (Hotel hotel : kolkataHotels) {

            System.out.println(hotel);
        }



        // =================================================
        // STEP 8: SORT BY RATING
        // =================================================

        System.out.println(
                "\n========== SORTED BY RATING =========="
        );


        List<Hotel> sortedHotels =
                system.sortByRating();


        for (Hotel hotel : sortedHotels) {

            System.out.println(hotel);
        }



        // =================================================
        // STEP 9: BOOK ROOM USING UPI
        // =================================================

        System.out.println(
                "\n========== BOOKING =========="
        );


        Payment upi =
                new UPIPayment();


        Booking booking1 =
                system.bookRoom(
                        101,
                        1,
                        RoomType.SINGLE,
                        upi
                );


        if (booking1 != null) {

            System.out.println(booking1);
        }



        // =================================================
        // STEP 10: SHOW USER BOOKINGS
        // =================================================

        system.showUserBookings(101);



        // =================================================
        // STEP 11: TRY TO BOOK SAME ROOM
        // =================================================

        /*
           The SINGLE room is already occupied.

           Therefore another user trying to book
           the same room type should get another
           available room or fail if none exists.
        */

        Payment card =
                new CardPayment();


        Booking booking2 =
                system.bookRoom(
                        102,
                        1,
                        RoomType.SINGLE,
                        card
                );


        if (booking2 != null) {

            System.out.println(booking2);
        }



        // =================================================
        // STEP 12: CANCEL BOOKING
        // =================================================

        if (booking1 != null) {

            system.cancelBooking(
                    booking1.getBookingId()
            );
        }



        // =================================================
        // STEP 13: SHOW BOOKINGS AGAIN
        // =================================================

        system.showUserBookings(101);



        // =================================================
        // STEP 14: SHOW HOTEL STATE
        // =================================================

        System.out.println(
                "\n========== FINAL HOTEL STATE =========="
        );


        system.showHotels();
    }
}