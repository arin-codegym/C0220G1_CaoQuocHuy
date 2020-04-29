package CaseStudy.Commons;

import CaseStudy.Model.House;
import CaseStudy.Model.Room;
import CaseStudy.Model.Services;
import CaseStudy.Model.Villa;

import java.util.Calendar;

public class FuncValidation {
    private static String pattern = "";

    public static boolean isValidIdServices(Services services, String string) {
        if (services instanceof Villa) {
            pattern = "^SVVL-\\d{4}$";
        } else if (services instanceof House) {
            pattern = "^SVHO-\\d{4}$";
        } else if (services instanceof Room) {
            pattern = "^SVRO-\\d{4}$";
        }
        return string.matches(pattern);
    }

    public static boolean isValidNameServices(String string) {
        pattern = "^([\\p{Lu}]|([\\p{Lu}][\\p{Ll}]{1,8}))([\\s]([\\p{Lu}][\\p{Lu}]{1,10})){0,6}$";
        return string.matches(pattern);
    }

    public static boolean isValidFreeServices(String string) {
        pattern = "^massage|karaoke|food|drink|car@";
        return string.matches(pattern);
    }

    public static String getValidIdService(Services services, String strDisplay, String errMes) {
        System.out.println(strDisplay);
        String result = ScannerUtils.scanner.nextLine();
        if (!isValidFreeServices(result)) {
            System.out.println(errMes);
            result = getValidIdService(services, strDisplay, errMes);
        }
        return result;
    }

    public static String getValidName(String strDisplay, String errMes) {
        System.out.println(strDisplay);
        String result = ScannerUtils.scanner.nextLine();
        if (!isValidNameServices(result)) {
            System.out.println(errMes);
            result = getValidName(strDisplay, errMes);
        }
        return result;

    }

    public static String getValidFreeServices(String strDisplay, String errMes) {
        System.out.println(strDisplay);
        String result = ScannerUtils.scanner.nextLine();
        if (!isValidFreeServices(result)) {
            System.out.println(errMes);
            result = getValidFreeServices(strDisplay, errMes);

        }
        return result;
    }

    public static double getValidNumberDouble(String strDisplay, String errMes) {
        return getValidNumberDouble(strDisplay, errMes, null);

    }

    public static double getValidNumberDouble(String strDisplay, String errMes, Double min) {
        double result = 0.0;
        System.out.println(strDisplay);
        try {
            result = Double.parseDouble(ScannerUtils.scanner.nextLine());
            if (min != null && result <= min) {
                throw new Exception(errMes);
            }
        } catch (Exception e) {
            System.out.println(errMes);
            result = getValidNumberDouble(strDisplay, errMes, min);
        }
        return result;
    }

    public static Integer getValidNumberInteger(String strDisplay, String errMes, Integer min) {
        return getValidNumberInteger(strDisplay, errMes, min, null);
    }
      //check Integer
    public static Integer getValidNumberInteger(String strDisplay, String errMes, Integer min, Integer max) {
        int result = 0;
        System.out.println(strDisplay);
        try {
            result = Integer.parseInt(ScannerUtils.scanner.nextLine());
            if (min != null && result <= min) {
                throw new Exception(errMes);
            }
            if (max != null && result >= max) {
                throw new Exception(errMes);
            }

        } catch (Exception e) {
            System.out.println(errMes);
            result = getValidNumberInteger(strDisplay, errMes, min, max);
        }
        return result;
    }

    public static String getValidCustomerName(String strDisplay, String errMes) {
        String result = "";
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidNameServices(result)) {
                throw new NameException(errMes);
            }
        } catch (NameException e) {
            System.out.println(errMes);
            result = getValidCustomerName(strDisplay, errMes);
        }
        return result;
    }
    // check email
    public static boolean isValidEmail(String string) {
        pattern = "^[a-z0-9._-]+@[a-z0-9.-]+\\.[a-z]{2,3}";
        return string.matches(pattern);
    }

    public static String getValidEmail(String strDisPlay, String errMes) {
        String result = null;
        System.out.println(strDisPlay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidEmail(result)) {
                throw new EmailException(errMes);
            }
        } catch (EmailException e) {

            System.out.println(errMes);
            result = getValidEmail(strDisPlay, errMes);
        }
        return result;
    }

    public static boolean isValidGender(String str) {
        pattern = "(?i:Male|Female|Unknow)$";// case-insensitive(?i:X)
        return str.matches(pattern);
    }

    public static String getValidGender(String strDisplay, String errMes) {
        String result = null;
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidGender(result)) {
                throw new GenderException(errMes);
            }
        } catch (GenderException e) {
            System.out.println(errMes);
            result = getValidGender(strDisplay, errMes);
        }
        return result;
    }

    public static boolean isValidIdCard(String str) {
        pattern = "^\\d{9}$";
        return str.matches(pattern);
    }

    public static String getValidIdCard(String strDisplay, String errMes) {
        String result = null;
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextLine();
            if (!isValidIdCard(result)) {
                throw new IdCardException(errMes);
            }

        } catch (IdCardException e) {
            System.out.println(errMes);
            result = getValidIdCard(strDisplay, errMes);
        }
        return result;
    }

    public static boolean isValidBirthday(String str) {
        pattern = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
        return str.matches(pattern);
    }

    public static String getValidBirthday(String strDisplay, String errMes) {
        String result = null;
        System.out.println(strDisplay);
        try {
            if (!isValidBirthday(result)) {
                throw new BirthdayException(errMes);
            }
            int year = Integer.parseInt(result.substring(6, 10));
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            if (year <= 1900 || currentYear - year <= 18) {
                throw new BirthdayException(errMes);
            }
        } catch (BirthdayException e) {
            System.out.println(errMes);
            result = getValidBirthday(strDisplay, errMes);
        }
        return result;
    }
}
