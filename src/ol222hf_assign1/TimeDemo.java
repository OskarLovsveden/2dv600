/*
* Date: 2021-09-14.
* File Name: TimeDemo.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;
import java.util.Scanner;

/**
 * Class Description: Demo for the Time class.
 * 
 * @version 1 14 Sept 2021
 * @author Oskar Lövsveden
 */
public class TimeDemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        try {
            // timeA
            System.out.print("Enter amount of seconds since midnight: ");
            int input = in.nextInt();
            Time timeA = new Time(input);
    
            // Tick timeA 10 times
            for (int i = 0; i < 10; i++) {
                timeA.tick();
                System.out.println("Tick " + (i + 1));
                System.out.println(timeA + "\n");
            }

            // timeB
            System.out.println("Set the time!");
            System.out.print("How many hours have passed since midnight? ");
            int hours = in.nextInt();
            System.out.print("How many minutes have passed on the current hour? ");
            int minutes = in.nextInt();
            System.out.print("How many seconds have passed on the current minute? ");
            int seconds = in.nextInt();
            Time timeB = new Time(hours, minutes, seconds);

            // Tick timeB 10 times
            for (int i = 0; i < 10; i++) {
                timeB.tick();
                System.out.println("Tick " + (i + 1));
                System.out.println(timeB + "\n");
            }

            System.out.println("Add timeA(" + timeA + ") and timeB(" + timeB + "):");
            System.out.println(timeA.addTime(timeB) + "\n");
            
            // timeC
            Time timeC = timeA.subtracTime(timeB);
            System.out.println("Subtract timeB(" + timeB + ") from timeA(" + timeA + "):");
            System.out.println(timeC + "\n");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            in.close();
        }
    }
}