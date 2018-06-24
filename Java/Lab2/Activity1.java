class Activity1 {
    public static void main( String[] args ) {
        String str;
        str = "sandra papo";
        System.out.println(str);
        System.out.println(str.length());
        String[] strArray = str.split(" ");
        String firstName = strArray[0];
        System.out.println(firstName);
        String lastName = strArray[1];
        System.out.println(lastName);
        String str2 = lastName + ", " + firstName;
        System.out.println(str2);
        firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1);
        lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
        System.out.println(firstName + " " + lastName);
    }
}
