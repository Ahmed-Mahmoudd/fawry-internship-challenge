# Fawry Internship Challenge – E-commerce System

This is my solution to the Fawry Quantum Internship Challenge.  
I built a simple e-commerce system using Java and core OOP principles like inheritance, polymorphism, abstraction, and interfaces.

## 💡 What the System Does
- You can define products (some expire, some don’t, some require shipping)
- Customers can add products to a cart (with quantity checks)
- When checking out:
  - It calculates subtotal, shipping fees, and final amount
  - Deducts from the customer's balance
  - Validates expired products or out-of-stock cases
- Shipping items are grouped and printed with total weight

## 🔧 Tools Used
- Java 17
- IntelliJ IDEA
- Object-Oriented Programming

## 🧪 Example Output
** Shipment notice **
2x Cheese 400g
1x Biscuits 700g
Total package weight 1.5kg

** Checkout receipt **
2x Cheese 200
1x Biscuits 150
1x Scratch Card 50
Subtotal 400
Shipping 45
Amount 445
Remaining Balance: 555
