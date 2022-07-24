# test_challenge_medium

Hello everyone, it's a medium lvl of java challenge test.

As database i'm going to use MySQL and JDBC connector for connection to db.
The database will store three table: Users, Products and Cart...Cart stores User id and Product id (with many-to-many relationship)

Of course, users can add as many products as they want, but they can't buy them, if they don't have enough money.

P.S. many-to-many relationship was a bad idea, i think i need one-to-many but i haven't time. Also i know that i didn't delete orders in
cart when the user successfully buy his products. And I didn't use the repository pattern correctly.

Below you can see the database structure


![image](https://user-images.githubusercontent.com/53920825/180607311-2ec2f604-9f32-4bb4-9da7-d918a4ffadc6.png)


Add new user and product example:


![image](https://user-images.githubusercontent.com/53920825/180607730-9178ba7c-5662-4795-b961-6af839583909.png)

Result:


![image](https://user-images.githubusercontent.com/53920825/180607736-3ddfe613-30b4-40fc-9cee-f950d6444319.png)


Get cart of all users example


![image](https://user-images.githubusercontent.com/53920825/180607878-116c9445-940c-46b0-8e76-5db427d781c6.png)


Get order of certain user example


![image](https://user-images.githubusercontent.com/53920825/180607912-07d937f5-1ed8-4295-a856-1796f25e7e3f.png)


If user have enough money to buy products in cart he can see successfully message, and if not, he will see an exception


![image](https://user-images.githubusercontent.com/53920825/180609242-afd4d87d-19d1-4137-a8f1-3b24e99f401c.png)
