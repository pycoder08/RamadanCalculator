public class Dates {
    /**Turns a normal date into a julian day number, sampled from personal work on previous labs
     * @param monthToday integer for the month of the provided date
     * @param dayToday integer for the day of the provided date
     * @param yearToday integer for the year of the provided date
     * @return returns an int with the julian day number
     * @author Muhammad Conn
     */
    public static int calcJulianDate(int monthToday, int dayToday, int yearToday)
    {
        // We calculate the Julian date using the formula provided in the lab
        int julianConstant = (14 - monthToday) / 12;
        int julianMonth = monthToday + 12 * julianConstant - 3;
        int julianYear = yearToday + 4800 - julianConstant;
        int julianPresent = dayToday + (153 * julianMonth + 2) / 5 + 365 * julianYear + 
            julianYear / 4 - julianYear / 100 + julianYear / 400 - 32045;

        // We return the result of the calculation
        return(julianPresent);
    }

    /**Formats a date properly, sampled from personal work on previous labs
     * @param month integer for the month of the year
     * @param day integer for the day of the year
     * @param year integer for the year
     * @return returns a string with the date including slashes between numbers
     * @author Muhammad Conn
     */
    public static String formatDate(int month, int day, int year)
        {
            return(month + "/" + day + "/" + year);
        }

    /**
     * Converts a 12 hour time to minutes since midnight.
     * @param hour int for the hour of the time
     * @param min int for the minutes of the time
     * @param merid String for the meridian of the time (AM/PM)
     * @return int for the time in minutes since midnight
     */
    public static int twelveToMins(int hour, int min, String merid)
    {
        if ((merid.equalsIgnoreCase("AM")) && (hour == 12))
        {
          return(min);
        }
        else if (merid.equalsIgnoreCase("PM") && hour != 12)
        {
          return(60 * (hour + 12) + min);
        }
        else 
        {
          return(60 * hour + min);
        }
    }

    /**
     * Converts a 24 hour time to minutes since midnight.
     * @param hour int for the hour of the time
     * @param min int for the minutes of the time
     * @return int for the time in minutes since midnight
     */
    public static int twentyFourToMins(int hour, int min)
    {
      return(60 * hour + min);
    }

    public static String minsToTwelve(int mins)
    {
        int hour = mins / 60;
        int min = mins % 60;
        String merid = "AM";

        if (hour > 12)
        {
            hour -= 12;
            merid = "PM";
        }
        else if (hour == 0)
        {
            hour = 12;
        }

        return( String.format("%d%s%02d%s%s", hour, ":", min, " ", merid));
    }
}
