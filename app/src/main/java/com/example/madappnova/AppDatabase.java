package com.example.madappnova;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class, Product.class, Order.class, Chat.class},
        version = 3, // Incremented version for userType field
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract ProductDao productDao();
    public abstract OrderDao orderDao();
    public abstract ChatDao chatMessageDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "myshop_database")
                            .fallbackToDestructiveMigration() // For development only!
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                UserDao userDao = INSTANCE.userDao();
                ProductDao productDao = INSTANCE.productDao();
                OrderDao orderDao = INSTANCE.orderDao();
                ChatDao chatMessageDao = INSTANCE.chatMessageDao();

                // Create sample seller account
                User seller = new User();
                seller.setName("Dona Bakery");
                seller.setEmail("dona@bakery.com");
                seller.setPassword("password123"); // In production, hash this!
                seller.setUserType("Seller");
                seller.setLocation("Kampung Baru Balakong");
                seller.setPhoneNumber("+60123456789");
                long sellerId = userDao.insert(seller);

                // Create sample customers
                User customer1 = new User();
                customer1.setName("Abdul Malik");
                customer1.setEmail("abdul@gmail.com");
                customer1.setPassword("password123");
                customer1.setUserType("Customer");
                long customerId1 = userDao.insert(customer1);

                User customer2 = new User();
                customer2.setName("Siti Zulaikha");
                customer2.setEmail("siti@gmail.com");
                customer2.setPassword("password123");
                customer2.setUserType("Customer");
                long customerId2 = userDao.insert(customer2);

                User customer3 = new User();
                customer3.setName("Alisya Qaisara");
                customer3.setEmail("alisya@gmail.com");
                customer3.setPassword("password123");
                customer3.setUserType("Customer");
                long customerId3 = userDao.insert(customer3);

                // Create sample products
                Product product1 = new Product();
                product1.setSellerId((int) sellerId);
                product1.setName("Croissant");
                product1.setImageUrl("croissant");
                product1.setOriginalPrice(10.00);
                product1.setDiscountedPrice(5.00);
                product1.setDiscountPercentage(50);
                product1.setQuantityAvailable(1);
                product1.setUploadedDate("12/01/2025");
                product1.setBestBeforeDate("15/01/2025");
                long productId1 = productDao.insert(product1);

                Product product2 = new Product();
                product2.setSellerId((int) sellerId);
                product2.setName("Pain au Chocolat");
                product2.setImageUrl("pain_au_chocolat");
                product2.setOriginalPrice(14.00);
                product2.setDiscountedPrice(7.00);
                product2.setDiscountPercentage(50);
                product2.setQuantityAvailable(1);
                product2.setUploadedDate("12/01/2025");
                product2.setBestBeforeDate("15/01/2025");
                long productId2 = productDao.insert(product2);

                Product product3 = new Product();
                product3.setSellerId((int) sellerId);
                product3.setName("Almond Croissant");
                product3.setImageUrl("almond_croissant");
                product3.setOriginalPrice(14.00);
                product3.setDiscountedPrice(7.00);
                product3.setDiscountPercentage(50);
                product3.setQuantityAvailable(1);
                product3.setUploadedDate("12/01/2025");
                product3.setBestBeforeDate("15/01/2025");
                long productId3 = productDao.insert(product3);

                Product product4 = new Product();
                product4.setSellerId((int) sellerId);
                product4.setName("Strawberry Danish");
                product4.setImageUrl("strawberry_danish");
                product4.setOriginalPrice(14.00);
                product4.setDiscountedPrice(7.00);
                product4.setDiscountPercentage(50);
                product4.setQuantityAvailable(1);
                product4.setUploadedDate("12/01/2025");
                product4.setBestBeforeDate("15/01/2025");
                long productId4 = productDao.insert(product4);

                // Create sample orders
                Order order1 = new Order();
                order1.setCustomerId((int) customerId1);
                order1.setSellerId((int) sellerId);
                order1.setProductId((int) productId1);
                order1.setCustomerName("Abdul Malik");
                order1.setItemName("Croissant");
                order1.setQuantity(1);
                order1.setTotalPayment(5.0);
                order1.setStatus("Preparing");
                orderDao.insert(order1);

                Order order2 = new Order();
                order2.setCustomerId((int) customerId2);
                order2.setSellerId((int) sellerId);
                order2.setProductId((int) productId2);
                order2.setCustomerName("Siti Zulaikha");
                order2.setItemName("Pain au Chocolat");
                order2.setQuantity(1);
                order2.setTotalPayment(7.0);
                order2.setStatus("Preparing");
                orderDao.insert(order2);

                Order order3 = new Order();
                order3.setCustomerId((int) customerId2);
                order3.setSellerId((int) sellerId);
                order3.setProductId((int) productId4);
                order3.setCustomerName("Siti Zulaikha");
                order3.setItemName("Strawberry Danish");
                order3.setQuantity(1);
                order3.setTotalPayment(7.0);
                order3.setStatus("Preparing");
                orderDao.insert(order3);

                Order order4 = new Order();
                order4.setCustomerId((int) customerId1);
                order4.setSellerId((int) sellerId);
                order4.setProductId((int) productId3);
                order4.setCustomerName("Abdul Malik");
                order4.setItemName("Almond Croissant");
                order4.setQuantity(1);
                order4.setTotalPayment(7.0);
                order4.setStatus("Preparing");
                orderDao.insert(order4);

                Order order5 = new Order();
                order5.setCustomerId((int) customerId3);
                order5.setSellerId((int) sellerId);
                order5.setProductId((int) productId1);
                order5.setCustomerName("Alisya Qaisara");
                order5.setItemName("Croissant");
                order5.setQuantity(1);
                order5.setTotalPayment(5.0);
                order5.setStatus("Preparing");
                orderDao.insert(order5);

                // Create sample chat messages
                Chat chat1 = new Chat();
                chat1.setSenderId((int) customerId1);
                chat1.setReceiverId((int) sellerId);
                chat1.setSenderName("Abdul Malik");
                chat1.setLastMessage("Hi...It seem u forgot my order");
                chat1.setUnreadCount(1);
                chat1.setRead(false);
                chat1.setUserType("Customer");
                chatMessageDao.insert(chat1);

                Chat chat2 = new Chat();
                chat2.setSenderId((int) customerId2);
                chat2.setReceiverId((int) sellerId);
                chat2.setSenderName("Siti Zulaikha");
                chat2.setLastMessage("Thank you seller <33");
                chat2.setUnreadCount(1);
                chat2.setRead(false);
                chat2.setUserType("Customer");
                chatMessageDao.insert(chat2);

                Chat chat3 = new Chat();
                chat3.setSenderId((int) customerId3);
                chat3.setReceiverId((int) sellerId);
                chat3.setSenderName("Alisya Qaisara");
                chat3.setLastMessage("When will my order be ready?");
                chat3.setUnreadCount(0);
                chat3.setRead(true);
                chat3.setUserType("Customer");
                chatMessageDao.insert(chat3);
            });
        }
    };
}