public class RealEstate {
    public static void main(String[] args) {
        double pricePerSqFt = 5000; // Price per square foot in INR
        double area = 1500; // Area in square feet
        double taxRate = 0.08; // 8% tax
        double gstRate = 0.03; // 3% GST
        // Calculate base price
        double basePrice = pricePerSqFt * area;
        // Calculate tax
        double tax = basePrice * taxRate;
        // Calculate GST
        double gst = basePrice * gstRate;
        // Calculate total price
        double totalPrice = basePrice + tax + gst;
        // Print the results
        System.out.println("Base Price: INR " + basePrice);
        System.out.println("Tax (8%): INR " + tax);
        System.out.println("GST (3%): INR " + gst);
        System.out.println("Total Price: INR " + totalPrice);
    }
}