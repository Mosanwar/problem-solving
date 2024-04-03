package com.example.problemsolving.problems.itc;

public class Screening {
}

class Super {
    public int index = 1;
}

class App extends Super {
    public App(int index) {
        index = index;
    }

    public static void main(String[] args) {
        App myApp = new App(10);
        System.out.println(myApp.index);
    }
}

/*[2:38 PM] Keziah Susan Wilson
class Super {
   public int index = 1;
}

class App extends Super {

   public App(int index) {
       index = index;
   }

   public static void main(String args[]) {
       App myApp = new App(10);
      System.out.println(myApp.index);
   }
}
[2:39 PM] Keziah Susan Wilson
Q2. class TestApp {

   public static void main() {
       int odd = 1;
       if (odd) {
          System.out.println("odd");
       } else {
           System.out.println("even");
       }
   }
}
[2:41 PM] Keziah Susan Wilson
What is the output of the following Java code?
java
Copy code
public class Test {
    public static void main(String[] args) {
        int i = 0;
        int j = 5;
        while (i < j) {
            System.out.print(i + " ");
            i++;
        }
    }
}
[2:42 PM] Keziah Susan Wilson
class TestApp {
   public static void main(String[] args) {
       for (int index = 0; true; index++) {
          System.out.println("Welcome");
           break;
       }
   }
}*/