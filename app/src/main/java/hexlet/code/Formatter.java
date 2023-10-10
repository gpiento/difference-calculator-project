package hexlet.code;

public class Formatter {

    public static String format(String diff, String formatName) throws Exception {
        switch (formatName) {
            case "stylish":
                return Stylish.render(diff);
            case "plain":
                return Plain.render(diff);
            case "json":
                return Json.render(diff);
            default:
                throw new Exception("Unknown format: '" + formatName + "'");
        }
    }
}
