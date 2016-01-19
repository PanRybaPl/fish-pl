/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.panryba.mc.pl;

/**
 *
 * @author PanRyba.pl
 */
public class LanguageHelper {
    public static String joinNames(String[] names) {
        if(names.length == 0)
            return "";
        
        if(names.length == 1)
            return names[0];
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < names.length - 1; ++i) {
            if(sb.length() > 0)
                sb.append(", ");
            
            sb.append(names[i]);
        }
        
        sb.append(" oraz ");
        sb.append(names[names.length - 1]);
        
        return sb.toString();
    }
    
    private static String formatDays(long days) {
        Declination singular = new Declination("dzien", "dnia", "dniu", "dzien", "dniem", "dniu", "dniu");
        Declination plural = new Declination("dni", "dni", "dniom", "dni", "dniami", "dniach", "dni");

        return DeclinationManager.getInstance().getPossesiveCountDeclination((int) days, singular, plural);
    }

    private static String formatHours(long hours) {
        Declination singular = new Declination("godzina", "godziny", "godzinie", "godzine", "godzina", "godzinie", "godzino");
        Declination plural = new Declination("godziny", "godzin", "godzinom", "godziny", "godzinami", "godzinach", "godziny");

        return DeclinationManager.getInstance().getPossesiveCountDeclination((int) hours, singular, plural);
    }

    private static String formatMinutes(long minutes) {
        Declination singular = new Declination("minuta", "minuty", "minucie", "minute", "minuta", "minucie", "minuto");
        Declination plural = new Declination("minuty", "minut", "minutom", "minuty", "minutami", "minutach", "minuty");

        return DeclinationManager.getInstance().getPossesiveCountDeclination((int) minutes, singular, plural);
    }

    private static String formatSeconds(long seconds) {
        Declination singular = new Declination("sekunda", "sekundy", "sekundzie", "sekunde", "sekunda", "sekundzie", "sekundo");
        Declination plural = new Declination("sekundy", "sekund", "sekundom", "sekundy", "sekundami", "sekundach", "sekundy");

        return DeclinationManager.getInstance().getPossesiveCountDeclination((int) seconds, singular, plural);
    }
    
    private static String formatTime(long days, long hours, long minutes, long seconds) {
        StringBuilder sb = new StringBuilder();
        if (days > 0) {
            sb.append(days);
            sb.append(" ");
            sb.append(formatDays(days));
            sb.append(" ");
        }

        if (hours > 0) {
            sb.append(hours);
            sb.append(" ");
            sb.append(formatHours(hours));
            sb.append(" ");
        }

        if (minutes > 0) {
            sb.append(minutes);
            sb.append(" ");
            sb.append(formatMinutes(minutes));
            sb.append(" ");
        }

        if (seconds > 0) {
            sb.append(seconds);
            sb.append(" ");
            sb.append(formatSeconds(seconds));
        }

        return sb.toString();
    }    

    public static String formatDHMS(long banSeconds) {
        long days = banSeconds / (3600 * 24);
        long hours = (banSeconds % (3600 * 24)) / 3600;
        long minutes = (banSeconds % 3600) / 60;
        long seconds = (banSeconds % 60);
        String timeString = formatTime(days, hours, minutes, seconds);
        return timeString;
    }
}
