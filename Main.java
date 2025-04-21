/********************************************
*	AUTHORS:	Muhammad Conn
* COLLABORATORS: N/A
*	LAST MODIFIED:	4/10/2025
********************************************/

/********************************************
*	Ramadan Fasting Calculator
*********************************************
*	PROGRAM DESCRIPTION:
*	<A calculator that takes the time of day, time of dawn, and the time of sunset to output useful information for Ramadan fasting.
*********************************************
*	ALGORITHM:
*	Time of dawn in 24-hours
* Current time in 24-hours
* Time of sunset in 24-hours
* Output how long you've been fasting
* Output how long til sunset
* Format times correctly, convert them from 24 to 12
*
*
* Take current date, start of Ramadan, date of eid
* Output which day of ramadan it is, what day is eid, how long until eid
*
* Note: The program evolved substantially since this initial pseudocode
*********************************************
*	STATIC METHODS:
* <list of static methods and which teammate made each>
*  - formatTime(int hour, int minutes) - Muhammad Conn
*  - printAscii() - Muhammad Conn
*  - calcJulianDate(int monthToday, int dayToday, int yearToday) - Muhammad Conn
*  - formatDate(int month, int day, int year) - Muhammad Conn
*********************************************/


public class Main 
{
  /***** CONSTANT SECTION *****/

  // Constants for the dates and times we'll need in our calculations. These are not user-dependent.
  static final int PRESENT_YEAR = 2025;

  static final int RAMADAN_MONTH = 3;
  static final int RAMADAN_DAY = 1;
  static final int RAMADAN_YEAR = 2025;

  static final int EID_MONTH = 3;
  static final int EID_DAY = 30;
  static final int EID_YEAR = 2025;




  // Constant for the divider to make the output look nicer
  static final String DIVIDER = "----------------------------------------";


  // Constants for the ASCII art
  static final String ASCII_ART_1 = "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓";
  static final String ASCII_ART_2 = "▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓";
  static final String ASCII_ART_3 = "▓──────────────────────────────────────▓";
  static final String ASCII_ART_4 = "▓────▄▀────────────▄▀───────────▄▀─────▓";
  static final String ASCII_ART_5 = "▓────▀▄───────────▐█────────────▀▄─────▓";
  static final String ASCII_ART_6 = "▓────▄█▄───────────▀▄───────────▄█▄────▓";
  static final String ASCII_ART_7 = "▓──▄▀░░░▀▄──────────▌─────────▄▀░░░▀▄──▓";
  static final String ASCII_ART_8 = "▓─▐░░░░░░░▌──────▄▄▀▀▄▄──────▐░░░░░░░▌─▓";
  static final String ASCII_ART_9 = "▓──▀▄░░░▄▀─────▄▀░░░░░░▀▄─────▀▄░░░▄▀──▓";
  static final String ASCII_ART_10 = "▓───▐███▌─────▐█░░░░░░░░█▌─────▐███▌───▓";
  static final String ASCII_ART_11 = "▓───▐░░░▌─────██▀▀▀▀▀▀▀▀██─────▐░░░▌───▓";
  static final String ASCII_ART_12 = "▓▄▄▄▐░█░▌▄▄▄▄▄████████████▄▄▄▄▄▐░█░▌▄▄▄▓";
  static final String ASCII_ART_13 = "▓──────────────────────────────────────▓";
  static final String ASCII_ART_14 = "▓─█▀▀▄──▄▄──█▀▄▀█──▄▄──█▀▀▄──▄▄──█▄──█─▓";
  static final String ASCII_ART_15 = "▓─█▄▄▀─█▄▄█─█─█─█─█▄▄█─█──█─█▄▄█─█─█─█─▓";
  static final String ASCII_ART_16 = "▓─█──█─█──█─█───█─█──█─█──█─█──█─█─█─█─▓";
  static final String ASCII_ART_17 = "▓─█──█─█──█─█───█ █──█─█▄▄▀─█──█─█─█─█─▓";
  static final String ASCII_ART_18 = "▓─█──█───────────────────────────█──▀█─▓";
  static final String ASCII_ART_19 = "▓──────────────────────────────────────▓";
  static final String ASCII_ART_20 = "▓───██───██─█─█─██▄─▄█▄─█▀▀▄─▄█▄─█─────▓";
  static final String ASCII_ART_21 = "▓───███─███─█─█─█─█─█─█─█──█─█─█─█─█▀──▓";
  static final String ASCII_ART_22 = "▓───█──█──█─█─█─█▀█─█▀█─█▐█▀─█▀█─█▀▄───▓";
  static final String ASCII_ART_23 = "▓───█─────█─█─█─█─█─█─█─█─█──█─█─█─█───▓";
  static final String ASCII_ART_24 = "▓───█─────█─███─██▀─█─█─█─█▄─█─█─█─█▄──▓";
  static final String ASCII_ART_25 = "▓──────────────────────────────────────▓";
  static final String ASCII_ART_26 = "▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓";
  static final String ASCII_ART_27 = "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓";
  // Credit: https://textart4u.blogspot.com/2013/06/ramadan-mubarak-text-art.html

  public static void main(String[] args)
  {
    /***** DECLARATION SECTION *****/
    // Variables for the hours and minutes of certain key times of day for our calculations
    int currentHour;
    int currentMin;

    int dawnHour;
    int dawnMin;
    int sunsetHour;
    int sunsetMin;


    boolean contMeridiem;
    String currentMeridiem;


    // Variables for the month, day, and year of the present day, the start of Ramadan, and Eid
    int presentMonth;
    int presentDay;

    //Julian dates that will be useful in the calculation section
    int presentJulian;
    int eidJulian;
    int ramadanJulian;

    // Variables for the times of day formatted in minutes. For example, noon is 12 * 60 = 720 minutes
    int currentTotalMinutes;
    int dawnTotalMinutes; 
    int sunsetTotalMinutes;

    // Variables for the hour and minute components of how long you've fasted and how much time is left as well as what percent of the fast you have completed
    int fastedHoursComponent;
    int fastedMinsComponent;

    int timeLeftHoursComponent;
    int timeLeftMinsComponent;
    double percentOfFast;

    // Variables for the number of days since the start of Ramadan, the number of days until Eid, and the percent of Ramadan completed
    int daysSinceRamadan;
    int daysUntilEid;
    double percentOfRamadan;
    

    // Int for the switch case to determine if the present date is before Ramadan or after Eid
    int ramadanState;

    // Array to store the dawn and sunset times for each day of Ramadan. Since there is no exact pattern, we cannot automate this using for loops
    int timesArray[][] = {
      {Dates.twelveToMins(5, 9, "AM"), Dates.twelveToMins(5, 56, "PM")},
      {Dates.twelveToMins(5, 7, "AM"), Dates.twelveToMins(5, 57, "PM")},
      {Dates.twelveToMins(5, 6, "AM"), Dates.twelveToMins(5, 57, "PM")},
      {Dates.twelveToMins(5, 5, "AM"), Dates.twelveToMins(5, 58, "PM")},
      {Dates.twelveToMins(5, 4, "AM"), Dates.twelveToMins(5, 59, "PM")},
      {Dates.twelveToMins(5, 2, "AM"), Dates.twelveToMins(6, 0, "PM")},
      {Dates.twelveToMins(5, 1, "AM"), Dates.twelveToMins(6, 1, "PM")},
      {Dates.twelveToMins(5, 0, "AM"), Dates.twelveToMins(6, 2, "PM")},
      {Dates.twelveToMins(4, 58, "AM"), Dates.twelveToMins(6, 2, "PM")},
      {Dates.twelveToMins(4, 57, "AM"), Dates.twelveToMins(6, 3, "PM")},
      {Dates.twelveToMins(4, 56, "AM"), Dates.twelveToMins(6, 4, "PM")},
      {Dates.twelveToMins(4, 54, "AM"), Dates.twelveToMins(6, 5, "PM")},
      {Dates.twelveToMins(4, 53, "AM"), Dates.twelveToMins(6, 6, "PM")},
      {Dates.twelveToMins(4, 52, "AM"), Dates.twelveToMins(6, 6, "PM")},
      {Dates.twelveToMins(4, 50, "AM"), Dates.twelveToMins(6, 7, "PM")},
      {Dates.twelveToMins(4, 49, "AM"), Dates.twelveToMins(6, 8, "PM")},
      {Dates.twelveToMins(4, 48, "AM"), Dates.twelveToMins(6, 8, "PM")},
      {Dates.twelveToMins(4, 46, "AM"), Dates.twelveToMins(6, 9, "PM")},
      {Dates.twelveToMins(4, 45, "AM"), Dates.twelveToMins(6, 10, "PM")},
      {Dates.twelveToMins(4, 43, "AM"), Dates.twelveToMins(6, 11, "PM")},
      {Dates.twelveToMins(4, 42, "AM"), Dates.twelveToMins(6, 12, "PM")},
      {Dates.twelveToMins(4, 41, "AM"), Dates.twelveToMins(6, 13, "PM")},
      {Dates.twelveToMins(4, 39, "AM"), Dates.twelveToMins(6, 13, "PM")},
      {Dates.twelveToMins(4, 38, "AM"), Dates.twelveToMins(6, 14, "PM")},
      {Dates.twelveToMins(4, 36, "AM"), Dates.twelveToMins(6, 15, "PM")},
      {Dates.twelveToMins(4, 35, "AM"), Dates.twelveToMins(6, 16, "PM")},
      {Dates.twelveToMins(4, 33, "AM"), Dates.twelveToMins(6, 17, "PM")},
      {Dates.twelveToMins(4, 32, "AM"), Dates.twelveToMins(6, 17, "PM")},
      {Dates.twelveToMins(4, 30, "AM"), Dates.twelveToMins(6, 18, "PM")},
      {Dates.twelveToMins(4, 29, "AM"), Dates.twelveToMins(6, 19, "PM")}
  };

    /***** INITIALIZATION + PROCESSING SECTION *****/
    // The times for dawn and sunset change each day, but aren't always consistent, so every few days we catch up/fall behind to stay accurate


    presentMonth = UtilityBelt.readInt("Please enter the current month (1-12): ", 1, 12);
    presentDay = UtilityBelt.readInt("Please enter the current day (1-31): ", 1, 31);

    presentJulian = Dates.calcJulianDate(presentMonth, presentDay, PRESENT_YEAR);
    eidJulian = Dates.calcJulianDate(EID_MONTH, EID_DAY, EID_YEAR);
    ramadanJulian = Dates.calcJulianDate(RAMADAN_MONTH, RAMADAN_DAY, RAMADAN_YEAR);

    if (presentJulian < ramadanJulian)
    {
      ramadanState = 0;
    }
    else if (presentJulian == eidJulian)
    {
      ramadanState = 1;
    }
    else if (presentJulian > eidJulian)
    {
      ramadanState = 2;
    }
    else
    {
      ramadanState = 3;
    }

    
    // Ask the user for the present time only if Ramadan is ongoing
    if (ramadanState == 3) 
    {
      // Ask the user for the present time
      currentHour = UtilityBelt.readInt("Please enter the current hour (0-12): ", 0, 12);
      currentMin = UtilityBelt.readInt("Please enter the current minute (0-59): ", 0, 59);

      // Set up a loop to ask the user if their time is in AM or PM
      contMeridiem = true;
      currentMeridiem = "";
      while (contMeridiem == true)
      {
        currentMeridiem = UtilityBelt.readString("Please enter the current meridiem (AM/PM): ");
        if (currentMeridiem.equalsIgnoreCase("AM") || currentMeridiem.equalsIgnoreCase("PM"))
        {
          contMeridiem = false;
        }
        else
        {
          System.out.println("Invalid input. Please enter either AM or PM.");
        }
      }

      

  }
  else 
  {
    // If the current date is not in Ramadan, we set the current hour, mins, and meridiem to null to keep the compiler happy since these variables are not used
    currentHour = 0;
    currentMin = 0;
    currentMeridiem = "";
  }

  // We calculate the number of days since the start of Ramadan, the number of days until Eid, and the percent of ramadan compelted
  daysSinceRamadan = Dates.calcJulianDate(presentMonth, presentDay, PRESENT_YEAR) - Dates.calcJulianDate(RAMADAN_MONTH, RAMADAN_DAY, RAMADAN_YEAR);
  daysUntilEid = Dates.calcJulianDate(EID_MONTH, EID_DAY, EID_YEAR) - Dates.calcJulianDate(presentMonth, presentDay, PRESENT_YEAR);
  percentOfRamadan = ((double)daysSinceRamadan / 30) * 100;

  presentJulian = Dates.calcJulianDate(presentMonth, presentDay, PRESENT_YEAR);
  eidJulian = Dates.calcJulianDate(EID_MONTH, EID_DAY, EID_YEAR);
  ramadanJulian = Dates.calcJulianDate(RAMADAN_MONTH, RAMADAN_DAY, RAMADAN_YEAR);


  if (ramadanState == 3) // These calculations will break unless the current date is within ramadan
  {
    dawnHour = timesArray[daysSinceRamadan][0] / 60;
    dawnMin = timesArray[daysSinceRamadan][0] % 60;
    sunsetHour = timesArray[daysSinceRamadan][1] / 60;
    sunsetMin = timesArray[daysSinceRamadan][1] % 60;
  }
  else // IF the date is not in ramadan, set all variables to 0 to keep the compiler happy
  {
    dawnHour = 0;
    dawnMin = 0;
    sunsetHour = 0;
    sunsetMin = 0;
  }
    
     // Calculations to figure out certain times in terms of total minutes
    currentTotalMinutes = Dates.twelveToMins(currentHour, currentMin, currentMeridiem);
    dawnTotalMinutes = Dates.twentyFourToMins(dawnHour, dawnMin);
    sunsetTotalMinutes = Dates.twentyFourToMins(sunsetHour, sunsetMin);

    // Calculations to figure out the hours and minutes component of how long you've fasted
    fastedHoursComponent = (currentTotalMinutes - dawnTotalMinutes) / 60;
    fastedMinsComponent = (currentTotalMinutes - dawnTotalMinutes) % 60;


    // Calculations to figure out the hours and minutes component of how long is left til sunset
    timeLeftHoursComponent = (sunsetTotalMinutes - currentTotalMinutes) / 60;
    timeLeftMinsComponent = (sunsetTotalMinutes - currentTotalMinutes) % 60;
    // We calculate the percent of the fast completed by dividing the current total minutes fasted by the total minutes of the fast
    percentOfFast = (((double)currentTotalMinutes - dawnTotalMinutes) / (sunsetTotalMinutes - dawnTotalMinutes)) * 100;
  


    /***** OUTPUT SECTION *****/
      {
        // We output the divider to make the output look nicer
        System.out.println(DIVIDER);
        System.out.println("Welcome to the Ramadan Fasting Calculator!");
        System.out.println("This program will help you keep track of your fast and the days of Ramadan.");
        System.out.println(DIVIDER);
      }

      // Switch case to determine if the present date is before Ramadan or after Eid
    System.out.println("Today is " + Dates.formatDate(presentMonth, presentDay, PRESENT_YEAR));
    switch (ramadanState)
      {
        case 0: // The date is before Ramadan
          System.out.println("Ramadan has not started yet.");

          System.out.println();
          
          System.out.println("Ramadan will begin on " + Dates.formatDate(RAMADAN_MONTH, RAMADAN_DAY, RAMADAN_YEAR));
          System.out.println("There are " + (ramadanJulian - presentJulian) + " days until Ramadan.");
          System.out.println("See you then!");
          System.out.println(DIVIDER);
          break;
        case 1: // The date is on Eid
          System.out.println("Eid is today! Eid Mubarak!");
          break;
        case 2: // The date is after Eid
          System.out.println("Eid has already passed. See you next year!");
          break;
        case 3: // The date is during Ramadan
        
          if (currentTotalMinutes < dawnTotalMinutes)
          {
            System.out.println("You have not started fasting yet.");
            System.out.println("There are " + (dawnTotalMinutes - currentTotalMinutes)/60 + " hours and " + (dawnTotalMinutes - currentTotalMinutes)%60 + " minutes left until dawn.");
      
          }
          else if (currentTotalMinutes > sunsetTotalMinutes)
          {
            System.out.println("You have completed 100% of your fast for today!");
          }
          else
          {
            System.out.println("There are " + timeLeftHoursComponent + " hours and " + timeLeftMinsComponent + " minutes left until sunset.");
            System.out.println("You have fasted for " + fastedHoursComponent + " hours and " + fastedMinsComponent + " minutes today.");
            System.out.printf("%s%.2f%s", "You have completed ", percentOfFast, "% of your fast today. \n");
            // We use formatted ouptut to round the percent of the fast to 2 decimal places
          }
          
          System.out.println(DIVIDER);
          // Output the key times, and our calculations
          System.out.println("The time is " + Dates.minsToTwelve(currentTotalMinutes));
          System.out.println("Dawn is at " + Dates.minsToTwelve(dawnTotalMinutes));
          System.out.println("Sunset is at " + Dates.minsToTwelve(Dates.twentyFourToMins(sunsetHour, sunsetMin)));

          System.out.println(DIVIDER);

          // Output the present date, the start of Ramadan, and the date of Eid as well as the difference between today's date and the other 2 dates
          System.out.println("Ramadan started on " + Dates.formatDate(RAMADAN_MONTH, RAMADAN_DAY, RAMADAN_YEAR));
          System.out.println("Eid is on either " + Dates.formatDate(EID_MONTH, EID_DAY, EID_YEAR) + " or " + Dates.formatDate(EID_MONTH, EID_DAY + 1, EID_YEAR));
          System.out.println();
          System.out.println(daysSinceRamadan + " days have passed since the start of Ramadan.");
          System.out.printf("%s%.2f%s","You have completed ", percentOfRamadan, "% of Ramadan. \n");
          System.out.println("There are either " + daysUntilEid + " or " + (daysUntilEid + 1) + " days until Eid.");
          System.out.println(DIVIDER);
          // We output two options for Eid since the date is variable depending on moon sighting
          printAscii();
          break;
      }
    


  }
  /***** STATIC METHODS *****/
  /**
   * Method for formatting a time properly with hours and minutes separated by a colon.
   * @param hour The hour component of the inputted time, must be in 24-hour formatting
   * @param minutes The minute component of the inputted time
   * @return Returns a string of the time formatted properly
   */
  public static String formatTime(int hour, int minutes)
  {
    return String.format("%d%s%02d",  hour, ":", minutes);
  }

  /** 
   * Method for printing out the ASCII art 
   * Credit: https://textart4u.blogspot.com/2013/06/ramadan-mubarak-text-art.html
  */
  public static void printAscii()
  {
    System.out.println(ASCII_ART_1);
    System.out.println(ASCII_ART_2);
    System.out.println(ASCII_ART_3);
    System.out.println(ASCII_ART_4);
    System.out.println(ASCII_ART_5);
    System.out.println(ASCII_ART_6);
    System.out.println(ASCII_ART_7);
    System.out.println(ASCII_ART_8);
    System.out.println(ASCII_ART_9);
    System.out.println(ASCII_ART_10);
    System.out.println(ASCII_ART_11);
    System.out.println(ASCII_ART_12);
    System.out.println(ASCII_ART_13);
    System.out.println(ASCII_ART_14);
    System.out.println(ASCII_ART_15);
    System.out.println(ASCII_ART_16);
    System.out.println(ASCII_ART_17);
    System.out.println(ASCII_ART_18);
    System.out.println(ASCII_ART_19);
    System.out.println(ASCII_ART_20);
    System.out.println(ASCII_ART_21);
    System.out.println(ASCII_ART_22);
    System.out.println(ASCII_ART_23);
    System.out.println(ASCII_ART_24);
    System.out.println(ASCII_ART_25);
    System.out.println(ASCII_ART_26);
    System.out.println(ASCII_ART_27);
  }
}
